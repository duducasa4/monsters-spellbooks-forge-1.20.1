package net.redreaper.monsterspellbooks.effect;

import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.redreaper.monsterspellbooks.init.ModMobEffects;

@Mod.EventBusSubscriber
public class CharmingMobEffect extends MagicMobEffect implements ISyncedMobEffect {
    public CharmingMobEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int pAmplifier) {
        super.applyEffectTick(livingEntity, pAmplifier);

        var targetingCondition = TargetingConditions.forCombat().ignoreLineOfSight().selector(e -> {
            return (((Mob) e).getTarget() == livingEntity);
        });
        livingEntity.level().getNearbyEntities(Mob.class, targetingCondition, livingEntity, livingEntity.getBoundingBox().inflate(40D))
                .forEach(entityTargetingCaster -> {
                    //IronsSpellbooks.LOGGER.debug("InvisibilitySpell Clear Target From:{}", entityTargetingCaster);
                    entityTargetingCaster.setTarget(null);
                    entityTargetingCaster.targetSelector.getAvailableGoals().forEach(WrappedGoal::stop);
                    entityTargetingCaster.getBrain().setMemory(MemoryModuleType.AVOID_TARGET,entityTargetingCaster.getTarget());
                });
        return;
    }

    @SubscribeEvent
    public static void onDealDamage(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity livingAttacker && livingAttacker.hasEffect(ModMobEffects.FEARSOME.get())) {
            livingAttacker.removeEffect(ModMobEffects.FEARSOME.get());
        }
    }

    @Override
    public boolean isDurationEffectTick(int tickCount, int amplifier) {
        return true;
    }
}
