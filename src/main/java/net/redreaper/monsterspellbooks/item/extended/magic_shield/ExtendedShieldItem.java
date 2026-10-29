package net.redreaper.monsterspellbooks.item.extended.magic_shield;

import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.minecraft.world.entity.EquipmentSlot;
import net.redreaper.monsterspellbooks.compat120.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ShieldItem;
import net.redreaper.monsterspellbooks.compat120.ItemAttributeModifiers;

public class ExtendedShieldItem extends ShieldItem {
    public ExtendedShieldItem(Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes(IronsWeaponTier pTier)
    {
        var builder = ItemAttributeModifiers.builder()
                .add(
                        Attributes.ARMOR_TOUGHNESS,
                         new AttributeModifier(net.redreaper.monsterspellbooks.compat120.WeaponAttrs.BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", pTier.getAttackDamageBonus(), AttributeModifier.Operation.ADDITION),
                        EquipmentSlotGroup.OFFHAND
                )
                .add(
                        Attributes.ARMOR,
                         new AttributeModifier(net.redreaper.monsterspellbooks.compat120.WeaponAttrs.BASE_ATTACK_SPEED_UUID, "Weapon modifier", pTier.getSpeed(), AttributeModifier.Operation.ADDITION),
                        EquipmentSlotGroup.OFFHAND
                );
        for (AttributeContainer holder : pTier.getAdditionalAttributes())
        {
            builder.add(holder.attribute(), holder.createModifier(EquipmentSlot.MAINHAND.getName()), EquipmentSlotGroup.OFFHAND);
        }
        return builder.build();
    }
}