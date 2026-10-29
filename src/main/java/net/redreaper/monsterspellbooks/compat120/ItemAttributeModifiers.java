package net.redreaper.monsterspellbooks.compat120;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 1.20.1 stand-in for 1.21's ItemAttributeModifiers component: a list of (attribute, modifier, slot group). Items get
 * it through {@link ItemAttrs} (it replaces the item's default modifiers, like the 1.21 component does).
 */
public final class ItemAttributeModifiers {
    public static final ItemAttributeModifiers EMPTY = new ItemAttributeModifiers(List.of());

    public record Entry(Supplier<Attribute> attribute, AttributeModifier modifier, EquipmentSlotGroup slot) {
    }

    private final List<Entry> modifiers;

    private ItemAttributeModifiers(List<Entry> modifiers) {
        this.modifiers = List.copyOf(modifiers);
    }

    public List<Entry> modifiers() {
        return modifiers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Multimap<Attribute, AttributeModifier> toMultimap(EquipmentSlot slot) {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create();
        for (Entry e : modifiers) {
            if (e.slot().test(slot)) {
                map.put(e.attribute().get(), e.modifier());
            }
        }
        return map;
    }

    public ItemAttributeModifiers withModifierAdded(Attribute attribute, AttributeModifier modifier, EquipmentSlotGroup slot) {
        List<Entry> list = new ArrayList<>(modifiers);
        list.add(new Entry(() -> attribute, modifier, slot));
        return new ItemAttributeModifiers(list);
    }

    public static final class Builder {
        private final List<Entry> list = new ArrayList<>();

        public Builder add(Attribute attribute, AttributeModifier modifier, EquipmentSlotGroup slot) {
            list.add(new Entry(() -> attribute, modifier, slot));
            return this;
        }

        public Builder add(Supplier<? extends Attribute> attribute, AttributeModifier modifier, EquipmentSlotGroup slot) {
            list.add(new Entry(attribute::get, modifier, slot));
            return this;
        }

        public ItemAttributeModifiers build() {
            return new ItemAttributeModifiers(list);
        }
    }
}
