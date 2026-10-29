package net.redreaper.monsterspellbooks.compat120;

import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.UUID;

/** 1.21 Iron's net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(tier): attack damage and speed of the tier plus its extra attributes, main hand. */
public final class WeaponAttrs {
    /** The same ids vanilla uses for a weapon's base damage and speed. */
    public static final UUID BASE_ATTACK_DAMAGE_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    public static final UUID BASE_ATTACK_SPEED_UUID = UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3");

    private WeaponAttrs() {
    }

    public static ItemAttributeModifiers createAttributes(IronsWeaponTier tier) {
        var builder = ItemAttributeModifiers.builder()
            .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", damage(tier), AttributeModifier.Operation.ADDITION),
                EquipmentSlotGroup.MAINHAND)
            .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", speed(tier), AttributeModifier.Operation.ADDITION),
                EquipmentSlotGroup.MAINHAND);
        for (AttributeContainer holder : tier.getAdditionalAttributes()) {
            builder.add(holder.attribute(), holder.createModifier(EquipmentSlot.MAINHAND.getName()), EquipmentSlotGroup.MAINHAND);
        }
        return builder.build();
    }

    // IronsWeaponTier is Iron's own interface with SRG-named methods (m_6631_/m_6624_); reobf does not always remap calls
    // made through it, so go through vanilla Tier when possible and by name otherwise.
    public static float damage(IronsWeaponTier tier) {
        if (tier instanceof net.minecraft.world.item.Tier t) {
            return t.getAttackDamageBonus();
        }
        return byName(tier, "m_6631_", "getAttackDamageBonus");
    }

    public static float speed(IronsWeaponTier tier) {
        if (tier instanceof net.minecraft.world.item.Tier t) {
            return t.getSpeed();
        }
        return byName(tier, "m_6624_", "getSpeed");
    }

    private static float byName(Object o, String... names) {
        for (String n : names) {
            try {
                return ((Number) o.getClass().getMethod(n).invoke(o)).floatValue();
            } catch (ReflectiveOperationException ignored) {
            }
        }
        return 0;
    }

    /** Level a 1.21 "incorrect for X tool" tag stands for. */
    public static int level(String incorrectTag) {
        if (incorrectTag.contains("netherite")) {
            return 4;
        }
        if (incorrectTag.contains("diamond")) {
            return 3;
        }
        if (incorrectTag.contains("iron")) {
            return 2;
        }
        if (incorrectTag.contains("stone")) {
            return 1;
        }
        return 0;
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation("monsterspellbooks", path);
    }
}
