package net.redreaper.monsterspellbooks.entity.armor;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.item.armor.tierUnique.UnstableRobeArmorItem;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class UnstableRobesArmorModel extends DefaultedEntityGeoModel<UnstableRobeArmorItem> {
    public UnstableRobesArmorModel() {
        super(new ResourceLocation("monsterspellbooks", ""));
    }

    public ResourceLocation getModelResource(UnstableRobeArmorItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/armor/unstable_armor.geo.json");
    }

    public ResourceLocation getTextureResource(UnstableRobeArmorItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/armor/unstable_armor.png");
    }

    public ResourceLocation getAnimationResource(UnstableRobeArmorItem animatable) {
        return new ResourceLocation("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
