package net.redreaper.monsterspellbooks.item.curios.hands;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.util.TooltipsUtils;
import net.acetheeldritchking.aces_spell_utils.items.curios.ImbueableCurioItem;
import net.acetheeldritchking.aces_spell_utils.items.curios.PresetImbueCurio;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;
import java.util.Map;

public class IgnitionGloveItem extends PresetImbueCurio {
    public IgnitionGloveItem() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).fireResistant().rarity(ASRarities.ARID_RARITY), Curios.NECKLACE_SLOT,
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.SCORCH_SPELL, 8)));
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, java.util.UUID id, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(AttributeRegistry.FIRE_SPELL_POWER.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.05, AttributeModifier.Operation.MULTIPLY_BASE));
        attr.put(AttributeRegistry.CAST_TIME_REDUCTION.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.10, AttributeModifier.Operation.MULTIPLY_BASE));
        attr.put(AttributeRegistry.COOLDOWN_REDUCTION.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.10, AttributeModifier.Operation.MULTIPLY_BASE));
        return attr;
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

    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack != null) {
            super.initializeSpellContainer(itemStack);
            AffinityData.set(itemStack, new AffinityData(Map.of(SpellRegistry.SCORCH_SPELL.get().getSpellResource(), 3)));
        }
    }
}
