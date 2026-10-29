package net.redreaper.monsterspellbooks.item.shields.mithril_shield;

import mod.azure.azurelib.render.item.AzItemRenderer;
import mod.azure.azurelib.render.item.AzItemRendererConfig;
import mod.azure.azurelib.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.item.shields.dwarven_riot_shield.DwarvenRiotShieldAnimator;

public class MithrilShieldRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = new ResourceLocation("monsterspellbooks", "geo/item/weapons/mithril_shield.geo.json");
    private static final ResourceLocation TEX = new ResourceLocation("monsterspellbooks", "textures/item/weapons/mithril_shield.png");

    public MithrilShieldRenderer() {
        super(AzItemRendererConfig.builder(GEO, TEX).setAnimatorProvider(DwarvenRiotShieldAnimator::new).addRenderLayer(new AzAutoGlowingLayer<>()).build());
    }
}
