package net.redreaper.monsterspellbooks.item.curios.elemental_charm;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.curios.PassiveAbilityCurio;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.items.curios.FlatCooldownPassiveAbilityCurio;
import net.acetheeldritchking.aces_spell_utils.registries.ASAttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.redreaper.monsterspellbooks.init.ModCurios;
import net.redreaper.monsterspellbooks.utils.ModRarities;
import top.theillusivec4.curios.api.SlotContext;

public class BrimstoneSigilItem extends FlatCooldownPassiveAbilityCurio {
    public static final int COOLDOWN_IN_TICKS = 10 * 20;
    public BrimstoneSigilItem() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).fireResistant().rarity(ModRarities.BRIMSTONE_RARITY_PROXY.getValue()), ModCurios.ELEMENTAL_CHARM_SLOT);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, java.util.UUID id, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(AttributeRegistry.FIRE_SPELL_POWER.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.1, AttributeModifier.Operation.MULTIPLY_BASE));
        attr.put(ASAttributeRegistry.MAGIC_PROJECTILE_CRIT_CHANCE.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.25, AttributeModifier.Operation.MULTIPLY_BASE));
        return attr;
    }

    @Override
    protected int getCooldownTicks() {
        return COOLDOWN_IN_TICKS;
    }
}
