/*
 * Copied from Ace's Spell Utils (1.21.1, MIT license) by AceTheEldritchKing and adapted to Forge 1.20.1, because the
 * 1.20.1 version of Ace's Spell Utils doesn't have this class.
 */
package net.redreaper.monsterspellbooks.compat120.ace;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.entity.IMagicEntity;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.magic.SpellSelectionManager;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellData;
import io.redspace.ironsspellbooks.capabilities.magic.SyncedSpellData;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.spells.fire.BurningDashSpell.BurningDashDirectionOverrideCastData;
import net.acetheeldritchking.aces_spell_utils.utils.ASTags;
import net.acetheeldritchking.aces_spell_utils.utils.ASUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class UniqueAbstractSpellCastingMob extends AbstractSpellCastingMob implements GeoEntity, IMagicEntity {
   private static final EntityDataAccessor<Boolean> DATA_CANCEL_CAST = SynchedEntityData.defineId(
      UniqueAbstractSpellCastingMob.class, EntityDataSerializers.BOOLEAN
   );
   private SpellData castingSpell;
   protected AbstractSpell lastCastSpellType = SpellRegistry.none();
   protected AbstractSpell instantCastSpellType = SpellRegistry.none();
   protected boolean cancelCastAnimation = false;
   protected boolean animatingLegs = false;
   private final MagicData playerMagicData = new MagicData(true);
   private boolean recreateSpell;
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   protected final RawAnimation idle = RawAnimation.begin().thenLoop("idle");
   protected final RawAnimation walking = RawAnimation.begin().thenLoop("walking");
   protected final RawAnimation instantCast = RawAnimation.begin().thenPlay("instant_cast");
   protected final RawAnimation longCast = RawAnimation.begin().thenPlay("long_cast");
   protected final RawAnimation continuousCast = RawAnimation.begin().thenLoop("continuous_cast");
   protected final RawAnimation slashCast = RawAnimation.begin().thenPlay("slash_cast");
   protected final RawAnimation stompCast = RawAnimation.begin().thenPlay("stomp_cast");
   protected final AnimationController instantCastAnimationController = new AnimationController(this, "instant_cast_controller", 0, this::instantCastPredicate);
   protected final AnimationController longCastAnimationController = new AnimationController(this, "long_cast_controller", 0, this::longCastPredicate);
   protected final AnimationController contCastAnimationController = new AnimationController(
      this, "continuous_cast_controller", 0, this::continuousCastPredicate
   );

   public UniqueAbstractSpellCastingMob(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
      super(pEntityType, pLevel);
      this.playerMagicData.setSyncedData(new SyncedSpellData(this));
      this.noCulling = true;
      this.lookControl = this.createLookControl();
   }

   protected LookControl createLookControl() {
      return new LookControl(this) {
         protected float rotateTowards(float from, float to, float maxDelta) {
            return super.rotateTowards(from, to, maxDelta * 2.5F);
         }

         protected boolean resetXRotOnTick() {
            return UniqueAbstractSpellCastingMob.this.getTarget() == null;
         }
      };
   }

   public MagicData getMagicData() {
      return this.playerMagicData;
   }

   public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
      super.onSyncedDataUpdated(pKey);
      if (this.level().isClientSide && pKey.getId() == DATA_CANCEL_CAST.getId()) {
         IronsSpellbooks.LOGGER
            .debug(
               "ASCM.onSyncedDataUpdated.1 this.isCasting:{}, playerMagicData.isCasting:{} isClient:{}",
               new Object[]{this.isCasting(), this.playerMagicData == null ? "null" : this.playerMagicData.isCasting(), this.level().isClientSide()}
            );
         this.cancelCast();
      }
   }

   public void cancelCast() {
      if (this.isCasting()) {
         if (this.level().isClientSide) {
            this.cancelCastAnimation = true;
         } else {
            this.entityData.set(DATA_CANCEL_CAST, !(Boolean)this.entityData.get(DATA_CANCEL_CAST));
         }

         this.castComplete();
      }
   }

   public void castComplete() {
      if (!this.level().isClientSide) {
         if (this.castingSpell != null) {
            this.castingSpell.getSpell().onServerCastComplete(this.level(), this.castingSpell.getLevel(), this, this.playerMagicData, false);
         }
      } else {
         this.playerMagicData.resetCastingState();
      }

      this.castingSpell = null;
   }

   public void setSyncedSpellData(SyncedSpellData syncedSpellData) {
      if (this.level().isClientSide) {
         boolean isCasting = this.playerMagicData.isCasting();
         this.playerMagicData.setSyncedData(syncedSpellData);
         this.castingSpell = this.playerMagicData.getCastingSpell();
         IronsSpellbooks.LOGGER
            .debug(
               "ASCM.setSyncedSpellData playerMagicData:{}, priorIsCastingState:{}, spell:{}", new Object[]{this.playerMagicData, isCasting, this.castingSpell}
            );
         if (this.castingSpell != null) {
            if (!this.playerMagicData.isCasting() && isCasting) {
               this.castComplete();
            } else if (this.playerMagicData.isCasting() && !isCasting) {
               AbstractSpell spell = this.playerMagicData.getCastingSpell().getSpell();
               this.initiateCastSpell(spell, this.playerMagicData.getCastingSpellLevel());
               if (this.castingSpell.getSpell().getCastType() == CastType.INSTANT) {
                  this.instantCastSpellType = this.castingSpell.getSpell();
                  this.castingSpell
                     .getSpell()
                     .onClientPreCast(this.level(), this.castingSpell.getLevel(), this, InteractionHand.MAIN_HAND, this.playerMagicData);
                  this.castComplete();
               }
            }
         }
      }
   }

   protected void customServerAiStep() {
      super.customServerAiStep();
      if (this.recreateSpell) {
         this.recreateSpell = false;
         SyncedSpellData syncedSpellData = this.playerMagicData.getSyncedData();
         AbstractSpell spell = SpellRegistry.getSpell(syncedSpellData.getCastingSpellId());
         this.initiateCastSpell(spell, syncedSpellData.getCastingSpellLevel());
      }

      if (this.castingSpell != null) {
         this.playerMagicData.handleCastDuration();
         if (this.playerMagicData.isCasting()) {
            this.castingSpell.getSpell().onServerCastTick(this.level(), this.castingSpell.getLevel(), this, this.playerMagicData);
         }

         IronsSpellbooks.LOGGER.debug("ASCM.customServerAiStep.1");
         this.forceLookAtTarget(this.getTarget());
         if (this.playerMagicData.getCastDurationRemaining() <= 0) {
            IronsSpellbooks.LOGGER.debug("ASCM.customServerAiStep.2");
            if (this.castingSpell.getSpell().getCastType() == CastType.LONG || this.castingSpell.getSpell().getCastType() == CastType.INSTANT) {
               IronsSpellbooks.LOGGER.debug("ASCM.customServerAiStep.3");
               this.castingSpell.getSpell().onCast(this.level(), this.castingSpell.getLevel(), this, CastSource.MOB, this.playerMagicData);
            }

            this.castComplete();
         } else if (this.castingSpell.getSpell().getCastType() == CastType.CONTINUOUS && (this.playerMagicData.getCastDurationRemaining() + 1) % 10 == 0) {
            this.castingSpell.getSpell().onCast(this.level(), this.castingSpell.getLevel(), this, CastSource.MOB, this.playerMagicData);
         }
      }
   }

   public void initiateCastSpell(AbstractSpell spell, int spellLevel) {
      IronsSpellbooks.LOGGER
         .debug("ASCM.initiateCastSpell: spellType:{} spellLevel:{}, isClient:{}", new Object[]{spell.getSpellId(), spellLevel, this.level().isClientSide});
      if (spell == SpellRegistry.none()) {
         this.castingSpell = null;
      } else {
         if (this.level().isClientSide) {
            this.cancelCastAnimation = false;
         }

         this.castingSpell = new SpellData(spell, spellLevel);
         if (this.getTarget() != null) {
            this.forceLookAtTarget(this.getTarget());
         }

         if (!this.level().isClientSide && !this.castingSpell.getSpell().checkPreCastConditions(this.level(), spellLevel, this, this.playerMagicData)) {
            IronsSpellbooks.LOGGER
               .debug("ASCM.precastfailed: spellType:{} spellLevel:{}, isClient:{}", new Object[]{spell.getSpellId(), spellLevel, this.level().isClientSide});
            this.castingSpell = null;
         } else {
            if (spell == SpellRegistry.TELEPORT_SPELL.get() || spell == SpellRegistry.FROST_STEP_SPELL.get()) {
               this.setTeleportLocationBehindTarget(10);
            } else if (spell == SpellRegistry.BLOOD_STEP_SPELL.get()) {
               this.setTeleportLocationBehindTarget(3);
            } else if (spell == SpellRegistry.BURNING_DASH_SPELL.get()) {
               this.setBurningDashDirectionData();
            }

            this.playerMagicData
               .initiateCast(
                  this.castingSpell.getSpell(),
                  this.castingSpell.getLevel(),
                  this.castingSpell.getSpell().getEffectiveCastTime(this.castingSpell.getLevel(), this),
                  CastSource.MOB,
                  SpellSelectionManager.MAINHAND
               );
            if (!this.level().isClientSide) {
               this.castingSpell.getSpell().onServerPreCast(this.level(), this.castingSpell.getLevel(), this, this.playerMagicData);
            }
         }
      }
   }

   public boolean isCasting() {
      return this.playerMagicData.isCasting();
   }

   public void setBurningDashDirectionData() {
      this.playerMagicData.setAdditionalCastData(new BurningDashDirectionOverrideCastData());
   }

   private void forceLookAtTarget(LivingEntity target) {
      if (target != null) {
         double d0 = target.getX() - this.getX();
         double d2 = target.getZ() - this.getZ();
         double d1 = target.getEyeY() - this.getEyeY();
         double d3 = Math.sqrt(d0 * d0 + d2 * d2);
         float f = (float)(Mth.atan2(d2, d0) * 180.0F / (float)Math.PI) - 90.0F;
         float f1 = (float)(-(Mth.atan2(d1, d3) * 180.0F / (float)Math.PI));
         this.setXRot(f1 % 360.0F);
         this.setYRot(f % 360.0F);
      }
   }

   public void registerControllers(ControllerRegistrar controllers) {
      controllers.add(this.instantCastAnimationController);
      controllers.add(this.longCastAnimationController);
      controllers.add(this.contCastAnimationController);
      controllers.add(new AnimationController(this, "idle", 0, this::predicate));
   }

   protected PlayState predicate(AnimationState event) {
      if (this.isAnimating()) {
         return PlayState.STOP;
      } else if (event.isMoving()) {
         event.getController().setAnimation(this.walking);
         return PlayState.CONTINUE;
      } else if (!event.isMoving()) {
         event.getController().setAnimation(this.idle);
         return PlayState.CONTINUE;
      } else {
         return PlayState.STOP;
      }
   }

   protected PlayState instantCastPredicate(AnimationState event) {
      if (this.cancelCastAnimation) {
         return PlayState.STOP;
      } else {
         AnimationController controller = event.getController();
         if (this.instantCastSpellType != SpellRegistry.none() && controller.getAnimationState() == State.STOPPED) {
            this.setStartAnimationFromSpell(controller, this.instantCastSpellType);
            this.instantCastSpellType = SpellRegistry.none();
         }

         return PlayState.CONTINUE;
      }
   }

   protected PlayState longCastPredicate(AnimationState event) {
      AnimationController controller = event.getController();
      AbstractSpell castingSpell = null;
      if (this.isCasting()) {
         MagicData magicData = this.getMagicData();
         SpellData spellData = magicData.getCastingSpell();
         if (spellData != null) {
            castingSpell = spellData.getSpell();
         }
      }

      if (!this.cancelCastAnimation
         && (controller.getAnimationState() != State.STOPPED || this.isCasting() && castingSpell != null && castingSpell.getCastType() == CastType.LONG)) {
         if (this.isCasting() && controller.getAnimationState() == State.STOPPED) {
            if (castingSpell != null) {
               this.setStartAnimationFromSpell(controller, castingSpell);
            }
         } else if (!this.isCasting() && this.lastCastSpellType.getCastType() == CastType.LONG) {
            this.setFinishAnimationFromSpell(controller, this.lastCastSpellType);
         }

         return PlayState.CONTINUE;
      } else {
         return PlayState.STOP;
      }
   }

   protected PlayState continuousCastPredicate(AnimationState event) {
      if (this.cancelCastAnimation) {
         return PlayState.STOP;
      } else {
         AnimationController controller = event.getController();
         AbstractSpell castingSpell = null;
         if (this.isCasting()) {
            MagicData magicData = this.getMagicData();
            SpellData spellData = magicData.getCastingSpell();
            if (spellData != null) {
               castingSpell = spellData.getSpell();
            }
         }

         if (this.isCasting() && castingSpell != null && controller.getAnimationState() == State.STOPPED) {
            if (castingSpell.getCastType() == CastType.CONTINUOUS) {
               this.setStartAnimationFromSpell(controller, castingSpell);
            }

            return PlayState.CONTINUE;
         } else {
            return this.isCasting() ? PlayState.CONTINUE : PlayState.STOP;
         }
      }
   }

   protected void setFinishAnimationFromSpell(AnimationController controller, AbstractSpell spell) {
      controller.forceAnimationReset();
      this.lastCastSpellType = SpellRegistry.none();
   }

   protected void setStartAnimationFromSpell(AnimationController controller, AbstractSpell spell) {
      controller.forceAnimationReset();
      if (spell.getCastType() == CastType.CONTINUOUS) {
         controller.setAnimation(this.continuousCast);
      } else if (ASUtils.getSpellsFromTag(ASTags.STOMP_LIKE_SPELL).contains(spell)) {
         controller.setAnimation(this.stompCast);
      } else if (ASUtils.getSpellsFromTag(ASTags.SLASH_LIKE_SPELL).contains(spell)) {
         controller.setAnimation(this.slashCast);
      } else if (spell.getCastType() == CastType.LONG) {
         controller.setAnimation(this.longCast);
      } else {
         controller.setAnimation(this.instantCast);
      }

      this.lastCastSpellType = spell;
      this.cancelCastAnimation = false;
      this.animatingLegs = false;
   }

   public boolean isAnimating() {
      return this.isCasting()
         || this.longCastAnimationController.getAnimationState() != State.STOPPED
         || this.instantCastAnimationController.getAnimationState() != State.STOPPED
         || this.contCastAnimationController.getAnimationState() != State.STOPPED;
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public void readAdditionalSaveData(CompoundTag pCompound) {
      super.readAdditionalSaveData(pCompound);
      SyncedSpellData syncedSpellData = new SyncedSpellData(this);
      syncedSpellData.loadNBTData(pCompound, this.level().registryAccess());
      if (syncedSpellData.isCasting()) {
         this.recreateSpell = true;
      }

      this.playerMagicData.setSyncedData(syncedSpellData);
   }

   public void addAdditionalSaveData(CompoundTag pCompound) {
      super.addAdditionalSaveData(pCompound);
      this.playerMagicData.getSyncedData().saveNBTData(pCompound, this.level().registryAccess());
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(DATA_CANCEL_CAST, false);
   }
}
