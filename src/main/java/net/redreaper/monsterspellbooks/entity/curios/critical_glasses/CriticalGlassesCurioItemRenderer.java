package net.redreaper.monsterspellbooks.entity.curios.critical_glasses;

import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;

public class CriticalGlassesCurioItemRenderer extends AzArmorRenderer {
    public static final ResourceLocation GEO = new ResourceLocation(
            MonstersSpellbooks.MOD_ID,
            "geo/curios/critical_glasses.geo.json"
    );

    public static final ResourceLocation TEX = new ResourceLocation(
            MonstersSpellbooks.MOD_ID,
            "textures/curios/critical_glasses.png"
    );

    public CriticalGlassesCurioItemRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .build()
        );
    }
}