package net.redreaper.monsterspellbooks.entity.curios.orb_soul;

import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;

public class OrbSoulCurioItemRenderer extends AzArmorRenderer {
    public static final ResourceLocation GEO = new ResourceLocation(
            MonstersSpellbooks.MOD_ID,
            "geo/curios/orb_soul.geo.json"
    );

    public static final ResourceLocation TEX = new ResourceLocation(
            MonstersSpellbooks.MOD_ID,
            "textures/curios/orb_soul.png"
    );

    public OrbSoulCurioItemRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(OrbOfSoulAnimator::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .build()
        );
    }
}