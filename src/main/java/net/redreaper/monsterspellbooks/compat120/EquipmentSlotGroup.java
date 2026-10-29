package net.redreaper.monsterspellbooks.compat120;

import net.minecraft.world.entity.EquipmentSlot;

/** 1.20.1 stand-in for 1.21's EquipmentSlotGroup. */
public enum EquipmentSlotGroup {
    ANY, MAINHAND, OFFHAND, HAND, FEET, LEGS, CHEST, HEAD, ARMOR, BODY;

    public boolean test(EquipmentSlot slot) {
        return switch (this) {
            case ANY -> true;
            case MAINHAND -> slot == EquipmentSlot.MAINHAND;
            case OFFHAND -> slot == EquipmentSlot.OFFHAND;
            case HAND -> slot.getType() == EquipmentSlot.Type.HAND;
            case FEET -> slot == EquipmentSlot.FEET;
            case LEGS -> slot == EquipmentSlot.LEGS;
            case CHEST, BODY -> slot == EquipmentSlot.CHEST;
            case HEAD -> slot == EquipmentSlot.HEAD;
            case ARMOR -> slot.getType() == EquipmentSlot.Type.ARMOR;
        };
    }

    public static EquipmentSlotGroup bySlot(EquipmentSlot slot) {
        return switch (slot) {
            case MAINHAND -> MAINHAND;
            case OFFHAND -> OFFHAND;
            case FEET -> FEET;
            case LEGS -> LEGS;
            case CHEST -> CHEST;
            case HEAD -> HEAD;
        };
    }
}
