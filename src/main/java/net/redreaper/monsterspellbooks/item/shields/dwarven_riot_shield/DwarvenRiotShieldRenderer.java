package net.redreaper.monsterspellbooks.item.shields.dwarven_riot_shield;

import mod.azure.azurelib.render.item.AzItemRenderer;
import mod.azure.azurelib.render.item.AzItemRendererConfig;
import mod.azure.azurelib.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;

public class DwarvenRiotShieldRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = new ResourceLocation("monsterspellbooks", "geo/item/weapons/dwarven_shield.geo.json");
    private static final ResourceLocation TEX = new ResourceLocation("monsterspellbooks", "textures/item/weapons/dwarven_shield.png");

    public DwarvenRiotShieldRenderer() {
        super(AzItemRendererConfig.builder(GEO, TEX).setAnimatorProvider(DwarvenRiotShieldAnimator::new).addRenderLayer(new AzAutoGlowingLayer<>()).build());
    }
}

