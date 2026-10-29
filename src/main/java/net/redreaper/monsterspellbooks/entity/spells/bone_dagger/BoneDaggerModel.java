package net.redreaper.monsterspellbooks.entity.spells.bone_dagger;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.entity.spells.paladin_throw.HolyHammerProjectile;
import software.bernie.geckolib.model.GeoModel;

public class BoneDaggerModel extends GeoModel<BoneDaggerProjectile> {
    public ResourceLocation getModelResource(BoneDaggerProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "geo/entity/spells/bone_dagger.geo.json");
    }

    public ResourceLocation getTextureResource(BoneDaggerProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "textures/entity/bone_dagger/bone_dagger.png");
    }

    public ResourceLocation getAnimationResource(BoneDaggerProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "animations/entity/spells/bone_dagger.animation.json");
    }
}