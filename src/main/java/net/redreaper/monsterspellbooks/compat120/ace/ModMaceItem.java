package net.redreaper.monsterspellbooks.compat120.ace;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 1.20.1 has no mace (it came with 1.21). This is the mod's own heavy weapon with the same idea: hitting while falling
 * (more than 1.5 blocks) turns the fall into extra damage, stops the fall, knocks back what is around the target and
 * sends out a burst of dust.
 */
@Mod.EventBusSubscriber(modid = "monsterspellbooks")
public class ModMaceItem extends Item {
    public ModMaceItem(Properties properties) {
        super(properties);
    }

    public static boolean canSmash(LivingEntity attacker) {
        return attacker.fallDistance > 1.5F && !attacker.isFallFlying();
    }

    /** Extra damage for the height fallen: steep at first, then gentler. */
    public static float smashBonus(float fall) {
        if (fall <= 3.0F) {
            return 4.0F * fall;
        }
        if (fall <= 8.0F) {
            return 12.0F + 2.0F * (fall - 3.0F);
        }
        return 22.0F + fall - 8.0F;
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repair) {
        return super.isValidRepairItem(stack, repair);
    }

    /** The 1.21 mace takes the weapon enchantments (minus sweeping edge); 1.20.1 decides that per item. */
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.world.item.enchantment.Enchantment enchantment) {
        return (enchantment.category == net.minecraft.world.item.enchantment.EnchantmentCategory.WEAPON && enchantment != net.minecraft.world.item.enchantment.Enchantments.SWEEPING_EDGE)
            || super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        if (canSmash(attacker) && attacker.level() instanceof ServerLevel level) {
            // the fall ends in the blow
            attacker.setDeltaMovement(attacker.getDeltaMovement().with(net.minecraft.core.Direction.Axis.Y, 0.01));
            attacker.fallDistance = 0;
            if (attacker instanceof Player p) {
                p.hurtMarked = true;
            }
            BlockState below = level.getBlockState(target.blockPosition().below());
            if (!below.isAir()) {
                level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, below), target.getX(), target.getY(), target.getZ(),
                    40, 1.2, 0.1, 1.2, 0.15);
            }
            level.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 0.6F, 0.6F);
            for (LivingEntity e : level.getEntitiesOfClass(LivingEntity.class, target.getBoundingBox().inflate(3.5),
                e -> e != attacker && e != target && e.isAlive() && !e.isAlliedTo(attacker) && !(e instanceof Player pl && pl.isSpectator()))) {
                Vec3 d = e.position().subtract(target.position());
                double dist = d.length();
                double power = (3.5 - dist) * 0.7 * (1.0 - e.getAttributeValue(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE));
                if (power > 0 && dist > 1.0e-3) {
                    Vec3 push = d.normalize().scale(power);
                    e.push(push.x, 0.7 * power, push.z);
                    e.hurtMarked = true;
                }
            }
        }
        return true;
    }

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event) {
        if (event.getSource().getDirectEntity() instanceof LivingEntity attacker && event.getSource().getEntity() == attacker
            && attacker.getMainHandItem().getItem() instanceof ModMaceItem && canSmash(attacker)) {
            event.setAmount(event.getAmount() + smashBonus(attacker.fallDistance));
        }
    }
}
