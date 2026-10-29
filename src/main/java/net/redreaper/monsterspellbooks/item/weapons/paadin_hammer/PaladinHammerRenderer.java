package net.redreaper.monsterspellbooks.item.weapons.paadin_hammer;

import mod.azure.azurelib.render.item.AzItemRenderer;
import mod.azure.azurelib.render.item.AzItemRendererConfig;
import mod.azure.azurelib.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;

public class PaladinHammerRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = new ResourceLocation("monsterspellbooks", "geo/item/weapons/paladin_hammer.geo.json");
    private static final ResourceLocation TEX = new ResourceLocation("monsterspellbooks", "textures/item/weapons/paladin_hammer.png");

    public PaladinHammerRenderer() {
        super(AzItemRendererConfig.builder(GEO, TEX).addRenderLayer(new AzAutoGlowingLayer<>()).build());
    }
}
