package net.redreaper.monsterspellbooks.entity.armor;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.item.armor.tierHybrid.IllagerEmberRobeArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class IllagerEmberRobeArmorModel extends GeoModel<IllagerEmberRobeArmorItem> {

    public IllagerEmberRobeArmorModel() {
        super();
    }

    @Override
    public ResourceLocation getModelResource(IllagerEmberRobeArmorItem object) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/armor/illager_ember_robe_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IllagerEmberRobeArmorItem object) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/armor/illager_ember_robe_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IllagerEmberRobeArmorItem animatable) {
        return new ResourceLocation("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}