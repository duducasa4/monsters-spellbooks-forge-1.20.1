package net.redreaper.monsterspellbooks.entity.spells.space_rupture;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpaceRuptureModel extends GeoModel<SpaceRupture> {
    public ResourceLocation getModelResource(SpaceRupture animatable) {
        return new ResourceLocation("monsterspellbooks", "geo/entity/spells/space_rupture.geo.json");
    }

    public ResourceLocation getTextureResource(SpaceRupture animatable) {
        return new ResourceLocation("monsterspellbooks", "textures/entity/space_rupture/space_rupture.png");
    }

    public ResourceLocation getAnimationResource(SpaceRupture animatable) {
        return new ResourceLocation("monsterspellbooks", "animations/entity/spells/space_rupture.animation.json");
    }
}