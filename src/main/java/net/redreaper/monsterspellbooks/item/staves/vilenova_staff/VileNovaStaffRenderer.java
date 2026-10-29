package net.redreaper.monsterspellbooks.item.staves.vilenova_staff;

import mod.azure.azurelib.render.item.AzItemRenderer;
import mod.azure.azurelib.render.item.AzItemRendererConfig;
import mod.azure.azurelib.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;

public class VileNovaStaffRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = new ResourceLocation("monsterspellbooks", "geo/item/staff/vilenova_staff.geo.json");
    private static final ResourceLocation TEX = new ResourceLocation("monsterspellbooks", "textures/item/staff/vilenova_staff.png");

    public VileNovaStaffRenderer() {
        super(AzItemRendererConfig.builder(GEO, TEX).setAnimatorProvider(VileNovaStaffAnimator::new).addRenderLayer(new AzAutoGlowingLayer<>()).build());
    }
}
