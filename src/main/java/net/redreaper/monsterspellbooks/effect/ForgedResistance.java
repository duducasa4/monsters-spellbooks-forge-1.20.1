package net.redreaper.monsterspellbooks.effect;

import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.redreaper.monsterspellbooks.init.ModMobEffects;

@Mod.EventBusSubscriber
public class ForgedResistance extends MagicMobEffect{
    public static final float DAMAGE_PER_LEVEL = .15f;
    public ForgedResistance(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @SubscribeEvent
    public static void increaseDamage(LivingHurtEvent event) {
        var attacker = event.getSource().getEntity();
        var target  = event.getEntity();
        if (attacker instanceof LivingEntity livingAttacker) {
            if (livingAttacker.hasEffect(ModMobEffects.FORGED_RESISTANCE.get())) {
                if (target.isOnFire()) {
                    float multiplier = 1 + ForgedResistance.DAMAGE_PER_LEVEL;
                    event.setAmount(event.getAmount() * multiplier);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingIncomingDamage(LivingHurtEvent event) {
        var livingEntity = event.getEntity();
        if ((livingEntity instanceof ServerPlayer)){
            if (event.getEntity().hasEffect(ModMobEffects.FORGED_RESISTANCE.get()) && event.getSource().is(DamageTypeTags.IS_FIRE)) {
                event.getEntity().clearFire();
                event.setCanceled(true);
                return;
            }
        }
    }
}


