package net.redreaper.monsterspellbooks.effect;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import io.redspace.ironsspellbooks.network.particles.FieryExplosionParticlesPacket;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.redreaper.monsterspellbooks.network.ModNetwork;
import net.redreaper.monsterspellbooks.init.ModMobEffects;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.WeakHashMap;

@Mod.EventBusSubscriber
public class VoidTouchedEffect extends MagicMobEffect implements ISyncedMobEffect {
    public static final float DAMAGE_PER_LEVEL = 0.05F;
    private static final Map<LivingEntity, Entity> EFFECT_CREDIT = new WeakHashMap<>();

    public VoidTouchedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public static MobEffectInstance addVoidStack(LivingEntity entity, @Nullable Entity afflicter) {
        MobEffectInstance previous = entity.getEffect(ModMobEffects.VOID_TOUCHED.get());
        MobEffectInstance inst;
        if (previous != null) {
            inst = new MobEffectInstance(ModMobEffects.VOID_TOUCHED.get(), 7 * 20, previous.getAmplifier() + 1, previous.isAmbient(), previous.isVisible(), previous.showIcon());
        } else {
            inst = new MobEffectInstance(ModMobEffects.VOID_TOUCHED.get(), 7 * 20, 0, false, true, true);
        }
        if (afflicter != null) {
            EFFECT_CREDIT.put(entity, afflicter);
        }
        entity.addEffect(inst);
        return inst;
    }

    @Override
    public void clientTick(LivingEntity livingEntity, MobEffectInstance instance) {
        int amplifier = instance.getAmplifier();
        ParticleOptions particle = ParticleHelper.ENDER_SPARKS;
        if (amplifier >= 1) {
            particle = ParticleHelper.UNSTABLE_ENDER;
        }
        var random = livingEntity.getRandom();
        for (int i = 0; i < 2; i++) {
            Vec3 motion = new Vec3(
                    random.nextFloat() * 2 - 1,
                    random.nextFloat() * 2 - 1,
                    random.nextFloat() * 2 - 1
            );
            motion = motion.scale(.04f);
            livingEntity.level().addParticle(particle, livingEntity.getRandomX(.4f), livingEntity.getRandomY(), livingEntity.getRandomZ(.4f), motion.x, motion.y, motion.z);
        }
    }

    @SubscribeEvent
    public static void increaseDamage(LivingHurtEvent event) {
        var attacker = event.getSource().getEntity();
        if (attacker instanceof LivingEntity livingAttacker) {
                if (event.getEntity().hasEffect(ModMobEffects.VOID_TOUCHED.get())) {
                    int lvl = event.getEntity().getEffect(ModMobEffects.VOID_TOUCHED.get()).getAmplifier() + 1;
                    float before = event.getAmount();
                    float multiplier = 1 + VoidTouchedEffect.DAMAGE_PER_LEVEL * lvl;
                    event.setAmount(event.getAmount() * multiplier);
                }
        }
    }
}

