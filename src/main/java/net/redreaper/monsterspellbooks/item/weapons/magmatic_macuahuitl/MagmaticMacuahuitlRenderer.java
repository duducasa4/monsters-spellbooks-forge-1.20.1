package net.redreaper.monsterspellbooks.item.weapons.magmatic_macuahuitl;

import mod.azure.azurelib.render.item.AzItemRenderer;
import mod.azure.azurelib.render.item.AzItemRendererConfig;
import mod.azure.azurelib.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;

public class MagmaticMacuahuitlRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = new ResourceLocation("monsterspellbooks", "geo/item/weapons/magmatic_macuahuitl.geo.json");
    private static final ResourceLocation TEX = new ResourceLocation("monsterspellbooks", "textures/item/weapons/magmatic_macuahuitl.png");

    public MagmaticMacuahuitlRenderer() {
        super(AzItemRendererConfig.builder(GEO, TEX).addRenderLayer(new AzAutoGlowingLayer<>()).build());
    }
}
