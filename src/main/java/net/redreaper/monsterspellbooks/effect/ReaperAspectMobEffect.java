package net.redreaper.monsterspellbooks.effect;

import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import io.redspace.ironsspellbooks.effect.SpiderAspectEffect;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.util.ModTags;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.redreaper.monsterspellbooks.init.ModMobEffects;

@Mod.EventBusSubscriber
public class ReaperAspectMobEffect extends MagicMobEffect {
    public static final float DAMAGE_PER_LEVEL = 0.05F;

    public ReaperAspectMobEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @SubscribeEvent
    public static void increaseDamage(LivingHurtEvent event) {
        var attacker = event.getSource().getEntity();
        if (attacker instanceof LivingEntity livingAttacker) {
            if (livingAttacker.hasEffect(ModMobEffects.REAPER_ASPECT.get())) {
                if (event.getEntity().hasEffect(MobEffects.WITHER)) {
                    int lvl = livingAttacker.getEffect(ModMobEffects.REAPER_ASPECT.get()).getAmplifier() + 1;
                    float multiplier = 1 + ReaperAspectMobEffect.DAMAGE_PER_LEVEL * lvl;
                    event.setAmount(event.getAmount() * multiplier);
                }
            }
        }
    }
}
