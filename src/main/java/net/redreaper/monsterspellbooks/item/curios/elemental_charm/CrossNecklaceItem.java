package net.redreaper.monsterspellbooks.item.curios.elemental_charm;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.entity.spells.sunbeam.SunbeamEntity;
import io.redspace.ironsspellbooks.item.curios.PassiveAbilityCurio;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.items.curios.FlatCooldownPassiveAbilityCurio;
import net.acetheeldritchking.aces_spell_utils.registries.ASAttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.redreaper.monsterspellbooks.init.ModItems;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;


@Mod.EventBusSubscriber
public class CrossNecklaceItem extends FlatCooldownPassiveAbilityCurio {
    public static final int COOLDOWN_IN_TICKS = 5 * 20;
    public CrossNecklaceItem() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON), Curios.NECKLACE_SLOT);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, java.util.UUID id, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(AttributeRegistry.HOLY_SPELL_POWER.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.10, AttributeModifier.Operation.MULTIPLY_BASE));
        attr.put(AttributeRegistry.CAST_TIME_REDUCTION.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.10, AttributeModifier.Operation.MULTIPLY_BASE));
        attr.put(ASAttributeRegistry.EVASIVE.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.05, AttributeModifier.Operation.MULTIPLY_BASE));
        return attr;
    }

    @SubscribeEvent
    public static void handleAbility(LivingDamageEvent event) {
        var sourceEntity = event.getSource().getEntity();
        var target = event.getEntity();
        var CHARM = ((CrossNecklaceItem) ModItems.CROSS_NECKLACE.get());
        if (target instanceof ServerPlayer serverPlayer) {
            if (sourceEntity instanceof LivingEntity) {
                if (CHARM.isEquippedBy(serverPlayer) && CHARM.tryProcCooldown(serverPlayer)) {
                    double baseDamage = damageFor(target);
                    Vec3 spawn = sourceEntity.position();
                    SunbeamEntity sunbeam = new SunbeamEntity(target.level());
                    sunbeam.setOwner(target);
                    sunbeam.moveTo(spawn);
                    sunbeam.setDamage((float) baseDamage);
                    target.level().addFreshEntity(sunbeam);
                    target.level().playSound(null, sunbeam.blockPosition(), SoundRegistry.SUNBEAM_WINDUP.get(), SoundSource.NEUTRAL, 3.5f, 1);
                }
            }
        }
    }

    public static double damageFor(@Nullable Entity entity) {
        double baseDamage = 5;
        if (entity instanceof LivingEntity livingAttacker) {
            baseDamage = baseDamage * livingAttacker.getAttributeValue(AttributeRegistry.SPELL_POWER.get()) * livingAttacker.getAttributeValue(AttributeRegistry.HOLY_SPELL_POWER.get());
        }
        return baseDamage;
    }

    @Override
    protected int getCooldownTicks() {
        return COOLDOWN_IN_TICKS;
    }
}