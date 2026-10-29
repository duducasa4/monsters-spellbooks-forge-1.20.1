package net.redreaper.monsterspellbooks.entity.model.SoulWizardEntity;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.entity.living.summons.SoulWizardEntity;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SoulWizardModel extends DefaultedEntityGeoModel<SoulWizardEntity> {
    public SoulWizardModel() {
        super(new ResourceLocation(MonstersSpellbooks.MOD_ID, "soul_wizard"));
    }

    @Override
    public ResourceLocation getModelResource(SoulWizardEntity animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/entity/soul_wizard.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SoulWizardEntity animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/entity/living/soul_wizard/soul_wizard.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SoulWizardEntity animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "animations/entity/soul_wizard.animation.json");
    }

    @Override
    public void setCustomAnimations(SoulWizardEntity animatable, long instanceId, AnimationState<SoulWizardEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}