package net.redreaper.monsterspellbooks.item.weapons;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.redreaper.monsterspellbooks.init.ModExtendedWeaponTiers;

import java.util.List;

public class SwiftStriker extends ExtendedSwordItem {
    public static final int COOLDOWN = 20 * 20;
    public SwiftStriker() {
        super(
                ModExtendedWeaponTiers.END_DAGGER,
                net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(new Item
                        .Properties()
                        .stacksTo(1)
                        .rarity(ASRarities.COSMIC_RARITY)
                        .fireResistant()
                        , net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.END_DAGGER)
                        )
        );
    }

    public void appendHoverText(ItemStack stack, @javax.annotation.Nullable net.minecraft.world.level.Level context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.irons_spellbooks.passive_ability", new Object[]{Component.literal(Utils.timeFromTicks((float)this.getPassiveCooldownTicks(), 1)).withStyle(ChatFormatting.LIGHT_PURPLE)}).withStyle(ChatFormatting.DARK_PURPLE));
            tooltipComponents.add(Component.literal(" ").append(Component.translatable(this.getDescriptionId() + ".desc")).withStyle(ChatFormatting.LIGHT_PURPLE));
        }
        else {
            tooltipComponents.add(Component.translatable("item.aces_spell_utils.more_details1").withStyle(ChatFormatting.GRAY));
        }

    }

    public int getPassiveCooldownTicks() {
        return COOLDOWN;
    }
}
