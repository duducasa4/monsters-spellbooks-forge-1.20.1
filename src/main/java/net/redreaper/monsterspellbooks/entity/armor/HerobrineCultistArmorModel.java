package net.redreaper.monsterspellbooks.entity.armor;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.item.armor.tierUnique.HerobrineCultistArmorItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class HerobrineCultistArmorModel extends DefaultedItemGeoModel<HerobrineCultistArmorItem> {
    public HerobrineCultistArmorModel() {
        super(new ResourceLocation("monsterspellbooks", ""));
    }

    public ResourceLocation getModelResource(HerobrineCultistArmorItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/armor/herobrine_cultist_armor.geo.json");
    }

    public ResourceLocation getTextureResource(HerobrineCultistArmorItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/armor/herobrine_cultist_armor.png");
    }

    public ResourceLocation getAnimationResource(HerobrineCultistArmorItem animatable) {
        return new ResourceLocation("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}