package net.redreaper.monsterspellbooks.effect;

import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import io.redspace.ironsspellbooks.util.ModTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.redreaper.monsterspellbooks.init.ModMobEffects;

@Mod.EventBusSubscriber
public class ObsidianSkinMobEffect extends MagicMobEffect {
    public static final float ATTACK_PER_LEVEL =  0.25f;
    public static final float DEFENSE_PER_LEVEL  =  5;
    public static final float KNOCKBACK_RESISTANCE_PER_LEVEL = 15F;
    public ObsidianSkinMobEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    public void applyEffectTick(LivingEntity entity, int amplifier) {
        var effects = entity.getActiveEffects().stream().map(MobEffectInstance::getEffect).filter(effect -> effect.getCategory() == MobEffectCategory.HARMFUL && net.minecraftforge.registries.ForgeRegistries.MOB_EFFECTS.tags().getTag(ModTags.AFFECTED_BY_SPIDER_ASPECT).contains(effect)).toList();
        entity.setTicksFrozen(0);
        entity.removeEffect(MobEffects.WITHER);
        effects.forEach(entity::removeEffect);
        return;
    }

    @SubscribeEvent
    public static void onLivingIncomingDamage(LivingHurtEvent event) {
        var livingEntity = event.getEntity();
        if ((livingEntity instanceof ServerPlayer)){
            if (event.getEntity().hasEffect(ModMobEffects.OBSIDIAN_SKIN.get()) && event.getSource().is(DamageTypeTags.IS_FIRE)) {
                event.getEntity().clearFire();
                event.setCanceled(true);
                return;
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
