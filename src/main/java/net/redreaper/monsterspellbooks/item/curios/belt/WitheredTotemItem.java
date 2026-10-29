package net.redreaper.monsterspellbooks.item.curios.belt;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.items.curios.PresetImbueCurio;
import net.acetheeldritchking.aces_spell_utils.registries.ASAttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.redreaper.monsterspellbooks.init.ModAtributeRegistry;
import net.redreaper.monsterspellbooks.init.ModSpellRegistry;
import net.redreaper.monsterspellbooks.utils.ModRarities;
import top.theillusivec4.curios.api.SlotContext;

public class WitheredTotemItem extends PresetImbueCurio {
    public WitheredTotemItem() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).fireResistant().rarity(ModRarities.SOUL_RARITY_PROXY.getValue()), Curios.NECKLACE_SLOT,
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(ModSpellRegistry.WITHER_BOMB, 3)));
    }
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, java.util.UUID id, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(ModAtributeRegistry.NECRO_MAGIC_POWER.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.05, AttributeModifier.Operation.MULTIPLY_BASE));
        attr.put(ASAttributeRegistry.MAGIC_PROJECTILE_DAMAGE.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.10, AttributeModifier.Operation.MULTIPLY_BASE));
        attr.put(AttributeRegistry.SUMMON_DAMAGE.get(), net.redreaper.monsterspellbooks.compat120.ItemAttrs.modifier(id, 0.10, AttributeModifier.Operation.MULTIPLY_BASE));
        return attr;
    }
}
