package net.redreaper.monsterspellbooks.entity.spells.razorblade_typhoon;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RazorTyphoonModel extends GeoModel<RazorbladeTyphoonProjectile> {
    public ResourceLocation getModelResource(RazorbladeTyphoonProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "geo/entity/spells/razorblade_typhoon.geo.json");
    }

    public ResourceLocation getTextureResource(RazorbladeTyphoonProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "textures/entity/razor_typhon/razor_typhon.png");
    }

    public ResourceLocation getAnimationResource(RazorbladeTyphoonProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "animations/entity/spells/razor_typhon.animation.json");
    }
}