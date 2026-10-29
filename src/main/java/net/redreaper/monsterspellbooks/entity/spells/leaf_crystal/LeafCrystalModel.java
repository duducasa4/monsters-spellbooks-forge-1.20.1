package net.redreaper.monsterspellbooks.entity.spells.leaf_crystal;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LeafCrystalModel extends GeoModel<LeafCrystalEntity> {
    public ResourceLocation getModelResource(LeafCrystalEntity animatable) {
        return new ResourceLocation("monsterspellbooks", "geo/entity/spells/leaf_crystal.geo.json");
    }

    public ResourceLocation getTextureResource(LeafCrystalEntity animatable) {
        return new ResourceLocation("monsterspellbooks", "textures/entity/leaf_crystal/leaf_crystal.png");
    }

    public ResourceLocation getAnimationResource(LeafCrystalEntity animatable) {
        return new ResourceLocation("monsterspellbooks", "animations/entity/spells/leaf_crystal.animation.json");
    }
}
