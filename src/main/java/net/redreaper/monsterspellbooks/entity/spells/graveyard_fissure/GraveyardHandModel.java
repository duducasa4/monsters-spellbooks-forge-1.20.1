package net.redreaper.monsterspellbooks.entity.spells.graveyard_fissure;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GraveyardHandModel extends GeoModel<GraveyardHand> {
    public ResourceLocation getModelResource(GraveyardHand animatable) {
        return new ResourceLocation("monsterspellbooks", "geo/entity/spells/graveyard_hand.geo.json");
    }

    public ResourceLocation getTextureResource(GraveyardHand animatable) {
        return new ResourceLocation("monsterspellbooks", "textures/entity/graveyard_fissure/graveyard_hand.png");
    }

    public ResourceLocation getAnimationResource(GraveyardHand animatable) {
        return new ResourceLocation("monsterspellbooks", "animations/entity/spells/graveyard_hand.animation.json");
    }
}