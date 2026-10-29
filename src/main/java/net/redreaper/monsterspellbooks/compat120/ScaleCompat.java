package net.redreaper.monsterspellbooks.compat120;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.redreaper.monsterspellbooks.effect.EndersentStrengthMobEffect;
import net.redreaper.monsterspellbooks.effect.InflammableMobEffect;
import net.redreaper.monsterspellbooks.init.ModMobEffects;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * 1.20.1 has neither the SCALE nor the BURNING_TIME attribute that two of the mod's effects use in 1.21:
 * - Endersent Strength (Endersent Form) makes its target 1 + 1.5 x level times bigger: hitbox and eye height here,
 *   the model in the client render events;
 * - Inflammable makes fire last 5% longer per level: each time the fire on the target goes up, the rise is stretched.
 */
@Mod.EventBusSubscriber(modid = "monsterspellbooks")
public final class ScaleCompat {
    private static final Map<Entity, Float> LAST_SCALE = new WeakHashMap<>();
    private static final Map<Entity, Integer> LAST_FIRE = new WeakHashMap<>();

    private ScaleCompat() {
    }

    public static float scale(Entity entity) {
        if (entity instanceof LivingEntity living && living.isAddedToWorld()) {
            MobEffectInstance inst = living.getEffect(ModMobEffects.ENDERSENT_STRENGTH.get());
            if (inst != null) {
                return 1f + EndersentStrengthMobEffect.SCALE_PER_LEVEL * (inst.getAmplifier() + 1);
            }
        }
        return 1f;
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onSize(EntityEvent.Size event) {
        float s = scale(event.getEntity());
        if (s != 1f) {
            event.setNewSize(event.getNewSize().scale(s));
            event.setNewEyeHeight(event.getNewEyeHeight() * s);
        }
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity living = event.getEntity();
        float s = scale(living);
        Float last = LAST_SCALE.get(living);
        if (last == null ? s != 1f : last != s) {
            if (s == 1f) {
                LAST_SCALE.remove(living);
            } else {
                LAST_SCALE.put(living, s);
            }
            living.refreshDimensions();
        }

        if (!living.level().isClientSide) {
            int fire = living.getRemainingFireTicks();
            Integer lastFire = LAST_FIRE.get(living);
            MobEffectInstance inflammable = living.getEffect(ModMobEffects.INFLAMMABLE.get());
            if (inflammable != null && lastFire != null && fire > 0 && fire > lastFire) {
                int rise = fire - Math.max(lastFire, 0);
                int extra = Math.round(rise * InflammableMobEffect.BURN_TIME_PER_LEVEL * (inflammable.getAmplifier() + 1));
                if (extra > 0) {
                    fire += extra;
                    living.setRemainingFireTicks(fire);
                }
            }
            if (fire > 0 || lastFire != null || inflammable != null) {
                LAST_FIRE.put(living, fire);
            }
        }
    }
}
