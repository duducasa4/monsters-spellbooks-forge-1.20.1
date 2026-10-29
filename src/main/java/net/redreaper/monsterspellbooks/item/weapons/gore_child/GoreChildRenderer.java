package net.redreaper.monsterspellbooks.item.weapons.gore_child;

import mod.azure.azurelib.render.item.AzItemRenderer;
import mod.azure.azurelib.render.item.AzItemRendererConfig;
import net.minecraft.resources.ResourceLocation;

public class GoreChildRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = new ResourceLocation("monsterspellbooks", "geo/item/weapons/gore_child.geo.json");
    private static final ResourceLocation TEX = new ResourceLocation("monsterspellbooks", "textures/item/weapons/gore_child.png");

    public GoreChildRenderer() {
        super(AzItemRendererConfig.builder(GEO, TEX).build());
    }
}
