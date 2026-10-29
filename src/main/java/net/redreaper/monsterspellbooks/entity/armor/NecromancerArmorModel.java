package net.redreaper.monsterspellbooks.entity.armor;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.item.armor.tierSchool.NecromancerArmorItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class NecromancerArmorModel extends DefaultedItemGeoModel<NecromancerArmorItem> {
    public NecromancerArmorModel() {
        super(new ResourceLocation("monsterspellbooks", ""));
    }

    public ResourceLocation getModelResource(NecromancerArmorItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/armor/necromancer_armor.geo.json");
    }

    public ResourceLocation getTextureResource(NecromancerArmorItem animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/armor/necromancer_armor.png");
    }

    public ResourceLocation getAnimationResource(NecromancerArmorItem animatable) {
        return new ResourceLocation("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}