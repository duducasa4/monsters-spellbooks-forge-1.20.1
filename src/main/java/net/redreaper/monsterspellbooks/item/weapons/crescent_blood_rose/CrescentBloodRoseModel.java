package net.redreaper.monsterspellbooks.item.weapons.crescent_blood_rose;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class CrescentBloodRoseModel extends DefaultedItemGeoModel<CrescentBloodRoseItem> {
    public CrescentBloodRoseModel() {super(new ResourceLocation("monsterspellbooks", ""));}

    public ResourceLocation getModelResource(CrescentBloodRoseItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/item/weapons/crescent_blood_rose.geo.json");
    }

    public ResourceLocation getTextureResource(CrescentBloodRoseItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/item/weapons/crescent_blood_rose.png");
    }

    public ResourceLocation getAnimationResource(CrescentBloodRoseItem animatable) {
        return new ResourceLocation("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}

