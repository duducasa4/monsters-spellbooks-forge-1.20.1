package net.redreaper.monsterspellbooks.compat120;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 1.21 Item.Properties attributes (given through with(properties, modifiers)) on 1.20.1: the modifiers are tied to the Properties object and, when the
 * item is built from it (mixin on Item's constructor), to the item; an ItemAttributeModifierEvent listener then puts
 * them in place of the item's default ones.
 */
@Mod.EventBusSubscriber(modid = "monsterspellbooks")
public final class ItemAttrs {
    private static final Map<Item.Properties, ItemAttributeModifiers> PENDING = Collections.synchronizedMap(new IdentityHashMap<>());
    private static final Map<Item, ItemAttributeModifiers> ITEMS = Collections.synchronizedMap(new IdentityHashMap<>());

    private ItemAttrs() {
    }

    public static Item.Properties with(Item.Properties properties, ItemAttributeModifiers modifiers) {
        PENDING.put(properties, modifiers);
        return properties;
    }

    public static void bind(Item item, Item.Properties properties) {
        ItemAttributeModifiers m = PENDING.remove(properties);
        if (m != null) {
            ITEMS.put(item, m);
        }
    }

    public static ItemAttributeModifiers of(Item item) {
        return ITEMS.getOrDefault(item, ItemAttributeModifiers.EMPTY);
    }

    @SubscribeEvent
    public static void onModifiers(ItemAttributeModifierEvent event) {
        ItemAttributeModifiers m = ITEMS.get(event.getItemStack().getItem());
        if (m == null) {
            return;
        }
        event.clearModifiers();
        for (ItemAttributeModifiers.Entry e : m.modifiers()) {
            if (e.slot().test(event.getSlotType())) {
                event.addModifier(e.attribute().get(), e.modifier());
            }
        }
    }

    /** 1.21's AttributeModifier(ResourceLocation id, amount, operation). */
    public static AttributeModifier modifier(ResourceLocation id, double amount, AttributeModifier.Operation operation) {
        return new AttributeModifier(uuid(id), id.toString(), amount, operation);
    }

    /** Curios 1.20.1 gives each slot a UUID where 1.21 gives an id. */
    public static AttributeModifier modifier(UUID id, double amount, AttributeModifier.Operation operation) {
        return new AttributeModifier(id, id.toString(), amount, operation);
    }

    public static UUID uuid(ResourceLocation id) {
        return UUID.nameUUIDFromBytes(id.toString().getBytes());
    }
}
