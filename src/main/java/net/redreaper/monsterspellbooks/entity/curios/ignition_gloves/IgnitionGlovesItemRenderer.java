package net.redreaper.monsterspellbooks.entity.curios.ignition_gloves;

import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;

public class IgnitionGlovesItemRenderer extends AzArmorRenderer {
    public static final ResourceLocation GEO = new ResourceLocation(
            MonstersSpellbooks.MOD_ID,
            "geo/curios/ignition_glove.geo.json"
    );

    public static final ResourceLocation TEX = new ResourceLocation(
            MonstersSpellbooks.MOD_ID,
            "textures/curios/ignition_glove.png"
    );

    public IgnitionGlovesItemRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .build()
        );
    }
}