package net.redreaper.monsterspellbooks.item.curios.elemental_charm;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.item.curios.SimpleDescriptiveCurio;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.redreaper.monsterspellbooks.init.ModMobEffects;
import top.theillusivec4.curios.api.SlotContext;

public class ObsidianMedalItem extends SimpleDescriptiveCurio {
    public ObsidianMedalItem() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).fireResistant().rarity(ASRarities.COSMIC_RARITY), Curios.NECKLACE_SLOT);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, java.util.UUID id, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(AttributeRegistry.ENDER_SPELL_POWER.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.10, AttributeModifier.Operation.MULTIPLY_BASE));
        attr.put(Attributes.ARMOR, net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 4, AttributeModifier.Operation.ADDITION));
        return attr;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        super.curioTick(slotContext, stack);
        slotContext.entity().removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
        slotContext.entity().removeEffect(MobEffects.DIG_SLOWDOWN);
        slotContext.entity().removeEffect(MobEffects.LEVITATION);
        slotContext.entity().removeEffect(ModMobEffects.PARALYSIS.get());
        slotContext.entity().removeEffect(ModMobEffects.STUNNED.get());
        slotContext.entity().removeEffect(MobEffectRegistry.ANTIGRAVITY.get());
        slotContext.entity().removeEffect(MobEffectRegistry.AIRBORNE.get());
    }
}
