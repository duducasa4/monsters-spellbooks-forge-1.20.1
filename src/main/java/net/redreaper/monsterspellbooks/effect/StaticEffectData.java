package net.redreaper.monsterspellbooks.effect;

import net.minecraft.world.entity.LivingEntity;
import java.util.Map;
import java.util.WeakHashMap;

public class StaticEffectData {
    private int hitCount;
    public int vfxTimestamp;

    public StaticEffectData(int hitsRemaining) {
        this.hitCount = hitsRemaining;
    }

    public StaticEffectData() {
    }

    /** 1.20.1: no data attachments; the data lives with the entity object while it is loaded. */
    private static final Map<LivingEntity, StaticEffectData> DATA = new WeakHashMap<>();

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public boolean hasHitsRemaining() {
        return hitCount > 0;
    }

    public void decrementHit() {
        if (hitCount > 0) {
            hitCount--;
        }
    }

    public void clear() {
        hitCount = 0;
    }

    public static StaticEffectData get(LivingEntity entity) {
        synchronized (DATA) {
            return DATA.computeIfAbsent(entity, e -> new StaticEffectData());
        }
    }

    public static void remove(LivingEntity livingEntity) {
        synchronized (DATA) {
            DATA.remove(livingEntity);
        }
    }

    public static boolean has(LivingEntity livingEntity) {
        synchronized (DATA) {
            return DATA.containsKey(livingEntity);
        }
    }
}
