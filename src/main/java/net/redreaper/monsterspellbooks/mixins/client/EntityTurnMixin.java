package net.redreaper.monsterspellbooks.mixins.client;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.redreaper.monsterspellbooks.init.ModMobEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Focus locks the camera where the player is looking. In 1.21 this wraps the player.turn call in MouseHandler.turnPlayer
 * with MixinExtras; Forge 1.20.1 has no MixinExtras and a plain @Redirect there clashes with Epic Fight's own redirect of
 * that same call, so the mouse turn is stopped in Entity.turn instead (a turn of 0, 0 like the original).
 */
@Mixin(Entity.class)
public class EntityTurnMixin {
    @Inject(method = "turn", at = @At("HEAD"), cancellable = true)
    private void monsterspellbooks$focusLocksTurn(double yRot, double xRot, CallbackInfo ci) {
        if ((Object) this instanceof LocalPlayer player && player.hasEffect(ModMobEffects.FOCUS.get())) {
            ci.cancel();
        }
    }
}
