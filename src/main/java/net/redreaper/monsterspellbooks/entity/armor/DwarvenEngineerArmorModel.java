package net.redreaper.monsterspellbooks.entity.armor;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.item.armor.tierHybrid.DwarvenEngineerArmorItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class DwarvenEngineerArmorModel extends DefaultedItemGeoModel<DwarvenEngineerArmorItem> {
    public DwarvenEngineerArmorModel() {
        super(new ResourceLocation("monsterspellbooks", ""));
    }

    public ResourceLocation getModelResource(DwarvenEngineerArmorItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/armor/dwarven_engineer_armor.geo.json");
    }

    public ResourceLocation getTextureResource(DwarvenEngineerArmorItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/armor/dwarven_engineer_armor.png");
    }

    public ResourceLocation getAnimationResource(DwarvenEngineerArmorItem animatable) {
        return new ResourceLocation("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}