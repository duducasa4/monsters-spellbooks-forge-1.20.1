package net.redreaper.monsterspellbooks.item.weapons;

import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.spells.thrown_item.ThrownItemProjectile;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.util.TooltipsUtils;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.redreaper.monsterspellbooks.init.ModExtendedWeaponTiers;
import net.redreaper.monsterspellbooks.utils.ModRarities;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VillagerButchererItem extends ExtendedSwordItem {
    public VillagerButchererItem() {
        super(
                ModExtendedWeaponTiers.VILLAGE_BUTCHER,
                net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(new Item
                        .Properties()
                        .stacksTo(1)
                        .rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue())
                        .fireResistant()
                        , net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.VILLAGE_BUTCHER)
                        )
        );
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @javax.annotation.Nullable net.minecraft.world.level.Level context, @NotNull List<Component> lines, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemStack, context, lines, flag);
        var affinityData = AffinityData.getAffinityData(itemStack);
        if (!affinityData.affinityData().isEmpty()) {
            int i = TooltipsUtils.indexOfComponent(lines, "tooltip.irons_spellbooks.spellbook_spell_count");
            lines.addAll(i < 0 ? lines.size() : i + 1, affinityData.getDescriptionComponent());
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.SPEAR;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (isTooDamagedToUse(itemstack)) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || enchantment == Enchantments.LOYALTY || enchantment == Enchantments.CHANNELING;
    }

    private float getAdditionalDamage(LivingEntity entity) {
        if (entity == null) {
            return 0;
        }
        float weaponDamage = Utils.getWeaponDamage(entity);
        var weaponItem = entity.getMainHandItem();
        if (!weaponItem.isEmpty() && weaponItem.isEnchanted()) {
            weaponDamage += net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_ASPECT, weaponItem);
        }
        return weaponDamage;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            int i = this.getUseDuration(stack) - timeLeft;
            if (i >= 8) {
                if (!isTooDamagedToUse(stack)) {
                    SoundEvent holder = SoundEvents.TRIDENT_THROW;
                    if (!level.isClientSide) {
                        stack.hurtAndBreak(1, player, __e -> __e.broadcastBreakEvent(entityLiving.getUsedItemHand()));
                        double damage = 1 + getAdditionalDamage(entityLiving);
                        if (stack.equals(player.getMainHandItem())) {
                            damage = player.getAttributeValue(Attributes.ATTACK_DAMAGE);
                        }
                        ThrownItemProjectile throwntrident = new ThrownItemProjectile(level, stack);
                        throwntrident.setOwner(player);
                        throwntrident.moveTo(player.getEyePosition());
                        throwntrident.shoot(player.getLookAngle());
                        throwntrident.setDamage((float) damage);
                        throwntrident.setScale(player.getScale());
                        level.addFreshEntity(throwntrident);
                        if (!player.getAbilities().instabuild) {
                            player.getCooldowns().addCooldown(stack.getItem(), 20 * 10);
                        }
                        level.playSound(null, throwntrident, holder, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    private static boolean isTooDamagedToUse(ItemStack stack) {
        return stack.getDamageValue() >= stack.getMaxDamage() - 1;
    }
}

