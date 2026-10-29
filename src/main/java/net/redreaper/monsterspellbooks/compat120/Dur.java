package net.redreaper.monsterspellbooks.compat120;

import net.minecraft.world.item.ArmorItem;

/** 1.21's ArmorItem.Type.getDurability(multiplier). */
public final class Dur {
    private Dur() {
    }

    public static int armor(ArmorItem.Type type, int multiplier) {
        int base = switch (type) {
            case HELMET -> 11;
            case CHESTPLATE -> 16;
            case LEGGINGS -> 15;
            case BOOTS -> 13;
        };
        return base * multiplier;
    }
}
