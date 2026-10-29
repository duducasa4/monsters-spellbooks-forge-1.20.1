package net.redreaper.monsterspellbooks.entity.model.DraugrVindicatorEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.redreaper.monsterspellbooks.entity.living.draugr.DraugrEliteVindicatorEntity;

public class DraugrVindicatorRenderer extends AbstractSpellCastingMobRenderer {

    public DraugrVindicatorRenderer(EntityRendererProvider.Context context) {
        super(context, new DraugrVindicatorModel());
    }

    // 1.20.1 has no SCALE attribute: the elite vindicator (scale 1.2 in 1.21) is scaled here instead
    @Override
    public void render(AbstractSpellCastingMob entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity instanceof DraugrEliteVindicatorEntity) {
            poseStack.pushPose();
            poseStack.scale(1.2f, 1.2f, 1.2f);
            super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
            poseStack.popPose();
        } else {
            super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        }
    }
}
