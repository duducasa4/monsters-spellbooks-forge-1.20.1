package net.redreaper.monsterspellbooks.entity.model.DwarvenSphere;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.entity.living.DwarvenSphereEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DwarvenSphereRenderer extends GeoEntityRenderer<DwarvenSphereEntity> {
    public DwarvenSphereRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DwarvenSphereModel());
        this.shadowRadius = 0.5F;
    }

    public RenderType getRenderType(DwarvenSphereEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    public void preRender(PoseStack poseStack, DwarvenSphereEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        float scale = 1.0F;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    protected float getDeathMaxRotation(DwarvenSphereEntity entityLivingBaseIn) {
        return 0.0F;
    }
}
