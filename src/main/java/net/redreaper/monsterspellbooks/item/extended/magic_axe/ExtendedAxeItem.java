package net.redreaper.monsterspellbooks.item.extended.magic_axe;

import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.acetheeldritchking.aces_spell_utils.registries.ASAttributeRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.redreaper.monsterspellbooks.compat120.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import net.redreaper.monsterspellbooks.compat120.ItemAttributeModifiers;

public class ExtendedAxeItem extends AxeItem {
    public ExtendedAxeItem(Tier pTier, Properties pProperties) {
        super(pTier, 0, 0, pProperties);
    }

    public static ItemAttributeModifiers createAttributes(IronsWeaponTier pTier) {
        var builder = ItemAttributeModifiers.builder()
                .add(
                        ASAttributeRegistry.MAGIC_PROJECTILE_DAMAGE,
                         new AttributeModifier(net.redreaper.monsterspellbooks.compat120.WeaponAttrs.BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", pTier.getAttackDamageBonus(), AttributeModifier.Operation.ADDITION
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        ASAttributeRegistry.MAGIC_PROJECTILE_CRIT_CHANCE,
                         new AttributeModifier(net.redreaper.monsterspellbooks.compat120.WeaponAttrs.BASE_ATTACK_SPEED_UUID, "Weapon modifier", pTier.getSpeed(), AttributeModifier.Operation.ADDITION),
                        EquipmentSlotGroup.MAINHAND
                );
        for (AttributeContainer holder : pTier.getAdditionalAttributes()) {
            builder.add(holder.attribute(), holder.createModifier(EquipmentSlot.MAINHAND.getName()), EquipmentSlotGroup.MAINHAND);
        }
        return builder.build();
    }
}
