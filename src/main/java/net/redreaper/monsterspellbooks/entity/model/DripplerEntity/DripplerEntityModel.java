package net.redreaper.monsterspellbooks.entity.model.DripplerEntity;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.entity.living.DripplerEntity;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class DripplerEntityModel extends DefaultedEntityGeoModel<DripplerEntity> {
    public DripplerEntityModel() {
        super(new ResourceLocation(MonstersSpellbooks.MOD_ID, "drippler"));
    }

    @Override
    public ResourceLocation getModelResource(DripplerEntity animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/entity/drippler.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DripplerEntity animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/entity/drippler.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DripplerEntity animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "animations/entity/drippler.animation.json");
    }

    @Override
    public void setCustomAnimations(DripplerEntity animatable, long instanceId, AnimationState<DripplerEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}