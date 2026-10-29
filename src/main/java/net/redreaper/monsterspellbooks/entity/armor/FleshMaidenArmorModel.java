package net.redreaper.monsterspellbooks.entity.armor;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.item.armor.tierUnique.FleshMaidenArmorItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class FleshMaidenArmorModel extends DefaultedItemGeoModel<FleshMaidenArmorItem> {
    public FleshMaidenArmorModel() {
        super(new ResourceLocation("monsterspellbooks", ""));
    }

    public ResourceLocation getModelResource(FleshMaidenArmorItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/armor/flesh_maiden.geo.json");
    }

    public ResourceLocation getTextureResource(FleshMaidenArmorItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/armor/flesh_maiden.png");
    }

    public ResourceLocation getAnimationResource(FleshMaidenArmorItem animatable) {
        return new ResourceLocation("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}