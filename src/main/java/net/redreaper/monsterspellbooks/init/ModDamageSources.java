package net.redreaper.monsterspellbooks.init;

import io.redspace.ironsspellbooks.api.magic.MagicData;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

@Mod.EventBusSubscriber
public class ModDamageSources {
    public static DamageSource get(Level level, ResourceKey<DamageType> damageType) {
        return new DamageSource(level.registryAccess().registryOrThrow(net.minecraft.core.registries.Registries.DAMAGE_TYPE).getHolderOrThrow(damageType));
    }

    public static Holder<DamageType> getHolderFromResource(Entity entity, ResourceKey<DamageType> damageTypeResourceKey) {
        var option = entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolder(damageTypeResourceKey);
        if (option.isPresent()) {
            return option.get();
        } else {
            return entity.level().damageSources().genericKill().typeHolder();
        }
    }

    @SubscribeEvent
    public static void postHitEffects(LivingDamageEvent event) {
        var damageSource = event.getSource();
        if (damageSource instanceof ModSpellDamageSources spellDamageSource && spellDamageSource.hasPostHitEffects()) {
            float actualDamage = event.getAmount();
            var target = event.getEntity();
            var attacker = event.getSource().getEntity();
            if (attacker instanceof LivingEntity livingAttacker) {
                if (spellDamageSource.getManastealPercent() > 0) {
                    float manaAdd = (spellDamageSource.getManastealPercent() * actualDamage);
                    MagicData pmg = MagicData.getPlayerMagicData(livingAttacker);
                    pmg.setMana(pmg.getMana() + manaAdd);
                }
            }
        }
    }
}
