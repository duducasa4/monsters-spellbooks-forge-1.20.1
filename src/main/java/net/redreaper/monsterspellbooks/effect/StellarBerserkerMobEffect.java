package net.redreaper.monsterspellbooks.effect;

import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import io.redspace.ironsspellbooks.util.ModTags;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class StellarBerserkerMobEffect extends MagicMobEffect {
    public static final float ATTACK_PER_LEVEL =  0.50f;
    public static final float ATTACK_SPEED_PER_LEVEL =  0.30f;
    public static final float KNOCKBACK_RESISTANCE_PER_LEVEL = 15F;
    public StellarBerserkerMobEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    public void applyEffectTick(LivingEntity entity, int amplifier) {
        var effects = entity.getActiveEffects().stream().map(MobEffectInstance::getEffect).filter(effect -> effect.getCategory() == MobEffectCategory.HARMFUL && !net.minecraftforge.registries.ForgeRegistries.MOB_EFFECTS.tags().getTag(ModTags.CLEANSE_IMMUNE).contains(effect)).toList();
        effects.forEach(entity::removeEffect);
        return;
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
