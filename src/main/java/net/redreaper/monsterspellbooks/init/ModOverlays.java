package net.redreaper.monsterspellbooks.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.gui.overlays.ModScreenEffectsOverlay;

@Mod.EventBusSubscriber(modid = MonstersSpellbooks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModOverlays {
    @SubscribeEvent
    public static void onRegisterOverlays(RegisterGuiOverlaysEvent event) {


        event.registerAboveAll("screen_effects", ModScreenEffectsOverlay.instance);
    }
}
