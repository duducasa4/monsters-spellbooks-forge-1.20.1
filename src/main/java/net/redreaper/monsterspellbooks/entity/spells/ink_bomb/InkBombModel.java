package net.redreaper.monsterspellbooks.entity.spells.ink_bomb;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class InkBombModel extends GeoModel<InkBombProjectile> {
    public ResourceLocation getModelResource(InkBombProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "geo/entity/spells/ink_bomb.geo.json");
    }

    public ResourceLocation getTextureResource(InkBombProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "textures/entity/ink_bomb/ink_bomb.png");
    }

    public ResourceLocation getAnimationResource(InkBombProjectile animatable) {
        return new ResourceLocation("monsterspellbooks", "animations/entity/spells/ink_bomb.animation.json");
    }
}
