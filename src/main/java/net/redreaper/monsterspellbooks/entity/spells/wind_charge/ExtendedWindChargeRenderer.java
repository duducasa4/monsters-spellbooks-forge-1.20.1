package net.redreaper.monsterspellbooks.entity.spells.wind_charge;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.NoopRenderer;

/** 1.20.1: the wind charge is drawn by its trail of wind particles (the 1.21 wind charge model doesn't exist here). */
public class ExtendedWindChargeRenderer extends NoopRenderer<ExtendedWindCharge> {
    public ExtendedWindChargeRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
}
