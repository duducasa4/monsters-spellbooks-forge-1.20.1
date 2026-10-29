package net.redreaper.monsterspellbooks.item.weapons;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.world.item.Item;
import net.redreaper.monsterspellbooks.init.ModExtendedWeaponTiers;

public class CultistKnifeItem extends ExtendedSwordItem {

    public CultistKnifeItem() {
        super(
                ModExtendedWeaponTiers.CULTIST_KNIFE,
                net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(new Item
                        .Properties()
                        .stacksTo(1)
                        .rarity(ASRarities.FORBIDDEN_RARITY)
                        , net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.CULTIST_KNIFE)
                        )
        );
    }

}
