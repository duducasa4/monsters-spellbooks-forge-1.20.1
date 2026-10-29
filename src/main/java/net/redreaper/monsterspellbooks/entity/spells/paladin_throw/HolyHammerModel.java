package net.redreaper.monsterspellbooks.entity.spells.paladin_throw;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HolyHammerModel extends GeoModel<HolyHammerProjectile> {
    public ResourceLocation getModelResource(HolyHammerProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "geo/entity/spells/holy_hammer.geo.json");
    }

    public ResourceLocation getTextureResource(HolyHammerProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "textures/entity/paladin_throw/holy_hammer.png");
    }

    public ResourceLocation getAnimationResource(HolyHammerProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "animations/entity/spells/holy_hammer.animation.json");
    }
}