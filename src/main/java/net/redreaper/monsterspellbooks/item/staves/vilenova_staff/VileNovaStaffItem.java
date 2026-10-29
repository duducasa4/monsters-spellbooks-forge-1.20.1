package net.redreaper.monsterspellbooks.item.staves.vilenova_staff;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.redreaper.monsterspellbooks.init.ModDispatcher;
import net.redreaper.monsterspellbooks.init.ModStaffMaterials;
import net.redreaper.monsterspellbooks.utils.ModRarities;


public class VileNovaStaffItem extends StaffItem {
    public final ModDispatcher dispatcher = new ModDispatcher();

    public VileNovaStaffItem() {
        super(
                net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(new Properties()
                        .stacksTo(1)
                        .rarity(ModRarities.SOUL_RARITY_PROXY.getValue())
                        , net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModStaffMaterials.VILENOVA)
                        ), 0, 0, java.util.Map.of()
        );
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player) {
            this.dispatcher.idle(player, stack);
        }

    }
}
