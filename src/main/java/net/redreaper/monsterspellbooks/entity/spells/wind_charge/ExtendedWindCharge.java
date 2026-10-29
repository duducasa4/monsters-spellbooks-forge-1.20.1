package net.redreaper.monsterspellbooks.entity.spells.wind_charge;

import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.redreaper.monsterspellbooks.init.ModEntities;
import net.redreaper.monsterspellbooks.init.ModSpellRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * 1.20.1 has no Wind Charge (it came with 1.21), so this is the mod's own: a ball of wind that bursts where it lands,
 * hurting what it hits and throwing everything in the burst away from it (and up), like the 1.21 wind charge.
 */
public class ExtendedWindCharge extends AbstractMagicProjectile {
    protected float radius;

    public ExtendedWindCharge(EntityType<? extends ExtendedWindCharge> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public ExtendedWindCharge(Level levelIn, LivingEntity shooter) {
        this(ModEntities.EXTENDED_WIND_CHARGE.get(), levelIn);
        setOwner(shooter);
    }

    @Override
    public void trailParticles() {
        Vec3 v = getDeltaMovement();
        for (int i = 0; i < 2; i++) {
            level().addParticle(ParticleTypes.CLOUD, getX() - v.x * 0.5 + (random.nextDouble() - 0.5) * 0.2, getY() + 0.15 + (random.nextDouble() - 0.5) * 0.2,
                getZ() - v.z * 0.5 + (random.nextDouble() - 0.5) * 0.2, 0, 0, 0);
        }
        level().addParticle(ParticleTypes.WHITE_ASH, getX(), getY() + 0.15, getZ(), 0, 0, 0);
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        if (level() instanceof ServerLevel sl) {
            sl.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 1, 0, 0, 0, 0);
            sl.sendParticles(ParticleTypes.CLOUD, x, y, z, 30, radius * 0.3, radius * 0.2, radius * 0.3, 0.15);
            sl.sendParticles(ParticleTypes.POOF, x, y, z, 20, radius * 0.2, radius * 0.2, radius * 0.2, 0.1);
        }
    }

    @Override
    public float getSpeed() {
        return 1.5f;
    }

    @Override
    public Optional<Supplier<SoundEvent>> getImpactSound() {
        return Optional.of(SoundRegistry.GUST_CAST);
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide) {
            Vec3 at = result.getLocation().add(Vec3.atLowerCornerOf(result.getDirection().getNormal()).scale(0.25));
            burst(at, null);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult result) {
        super.onHitEntity(result);
        if (!this.level().isClientSide) {
            Entity target = result.getEntity();
            LivingEntity owner = getOwner() instanceof LivingEntity le ? le : null;
            if (owner != null) {
                owner.setLastHurtMob(target);
                if (owner instanceof Player p) {
                    p.fallDistance = 0;
                }
            }
            // same calls as the 1.21 version (its damage and Airborne go to the caster's side, as written there)
            if (owner != null) DamageSources.applyDamage(owner, getDamage(), ModSpellRegistry.SPECTRAL_BLAST.get().getDamageSource(this, getOwner()));
            if (target.hurt(this.damageSources().mobProjectile(this, owner), 1.0F) && target instanceof LivingEntity && owner != null) {
                owner.addEffect(new MobEffectInstance(MobEffectRegistry.AIRBORNE.get(), 60, 3));
            }
            burst(this.position(), target);
            this.discard();
        }
    }

    @Override
    protected void onHit(@NotNull HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.discard();
        }
    }

    /** The wind bursts out: everything around is thrown away from the spot (the caster too, which is how they leap). */
    protected void burst(Vec3 pos, Entity alreadyHit) {
        float r = Math.max(1.5f, getRadius());
        impactParticles(pos.x, pos.y, pos.z);
        level().playSound(null, pos.x, pos.y, pos.z, SoundRegistry.GUST_CAST.get(), SoundSource.NEUTRAL, 1.5f, 1.2f);
        AABB box = new AABB(pos, pos).inflate(r);
        for (Entity e : level().getEntities(this, box, e -> e.isAlive() && !e.isSpectator() && e.isPushable() || e instanceof Player)) {
            Vec3 d = e.position().add(0, e.getBbHeight() * 0.5, 0).subtract(pos);
            double dist = d.length();
            if (dist > r) {
                continue;
            }
            double strength = (1.0 - dist / r) * (1.22f * getDamage() + 0.6);
            Vec3 push = (dist < 1.0e-3 ? new Vec3(0, 1, 0) : d.normalize()).scale(strength).add(0, strength * 0.35, 0);
            e.setDeltaMovement(e.getDeltaMovement().add(push));
            e.hurtMarked = true;
            e.fallDistance = 0;
        }
    }

    @Override
    public void onAntiMagic(MagicData playerMagicData) {
        burst(this.position(), null);
        this.discard();
    }
}
