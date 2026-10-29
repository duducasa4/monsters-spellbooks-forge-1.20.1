package net.redreaper.monsterspellbooks.compat120.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.redreaper.monsterspellbooks.compat120.ScaleCompat;

/** Draws entities under Endersent Strength at their size (see ScaleCompat). */
@Mod.EventBusSubscriber(modid = "monsterspellbooks", value = Dist.CLIENT)
public final class ScaleRenderCompat {
    private ScaleRenderCompat() {
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void pre(RenderLivingEvent.Pre<?, ?> event) {
        if (event.isCanceled()) {
            return;
        }
        float s = ScaleCompat.scale(event.getEntity());
        event.getPoseStack().pushPose();
        if (s != 1f) {
            event.getPoseStack().scale(s, s, s);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void post(RenderLivingEvent.Post<?, ?> event) {
        event.getPoseStack().popPose();
    }
}
