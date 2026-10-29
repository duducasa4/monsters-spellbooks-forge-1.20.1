package net.redreaper.monsterspellbooks.effect;

import io.redspace.ironsspellbooks.damage.ISSDamageTypes;
import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.ForgeMod;

public class BrimstoneFrenzyMobEffect extends MagicMobEffect implements ISyncedMobEffect {
    public static final float FIRE_SPELL_POWER_PER_LEVEL = .25f;
    public static final float MANA_REGEN_PER_LEVEL = -2;

    public BrimstoneFrenzyMobEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    public void applyEffectTick(LivingEntity p_296276_, int p_296233_) {
        Registry<DamageType> dTypeReg = p_296276_.level().registryAccess().registryOrThrow(net.minecraft.core.registries.Registries.DAMAGE_TYPE);
        Holder.Reference<DamageType> dType = dTypeReg.getHolder(net.minecraft.world.damagesource.DamageTypes.MAGIC).orElse(dTypeReg.getHolderOrThrow(ISSDamageTypes.FIRE_MAGIC));
        p_296276_.hurt(new DamageSource(dType), 1.5f);
        return;
    }

    public boolean isDurationEffectTick(int p_295629_, int p_295734_) {
        int i = 40 >> p_295734_;
        return i == 0 || p_295629_ % i == 0;
    }
}
