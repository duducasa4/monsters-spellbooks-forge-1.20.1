package net.redreaper.monsterspellbooks.item.curios.necklace;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.item.curios.SimpleDescriptiveCurio;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class ColdConjurerTalisman extends SimpleDescriptiveCurio {
    public ColdConjurerTalisman() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).rarity(ASRarities.GLACIAL_RARITY).fireResistant(), Curios.NECKLACE_SLOT);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, java.util.UUID id, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(AttributeRegistry.ICE_SPELL_POWER.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.1, AttributeModifier.Operation.MULTIPLY_BASE));
        attr.put(AttributeRegistry.SUMMON_DAMAGE.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, (double)0.10F, AttributeModifier.Operation.ADDITION));
        return attr;
    }
}
