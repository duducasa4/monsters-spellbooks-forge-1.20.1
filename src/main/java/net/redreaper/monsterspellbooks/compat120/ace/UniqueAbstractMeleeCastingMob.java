/*
 * Copied from Ace's Spell Utils (1.21.1, MIT license) by AceTheEldritchKing and adapted to Forge 1.20.1, because the
 * 1.20.1 version of Ace's Spell Utils doesn't have this class.
 */
package net.redreaper.monsterspellbooks.compat120.ace;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.entity.mobs.IAnimatedAttacker;
import io.redspace.ironsspellbooks.entity.mobs.wizards.fire_boss.NotIdioticNavigation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.core.animation.AnimationController.State;

public class UniqueAbstractMeleeCastingMob extends UniqueAbstractSpellCastingMob implements IAnimatedAttacker {
   RawAnimation animationToPlay = null;
   private final AnimationController<UniqueAbstractMeleeCastingMob> meleeAnimationController = new AnimationController(
      this, "melee_controller", 0, this::meleePredicate
   );

   public UniqueAbstractMeleeCastingMob(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
      super(pEntityType, pLevel);
      this.lookControl = this.createLookControl();
      this.moveControl = this.createMoveControl();
   }

   @Override
   protected LookControl createLookControl() {
      return new LookControl(this) {
         protected float rotateTowards(float from, float to, float maxDelta) {
            return super.rotateTowards(from, to, maxDelta * 2.5F);
         }

         protected boolean resetXRotOnTick() {
            return UniqueAbstractMeleeCastingMob.this.getTarget() == null;
         }
      };
   }

   protected MoveControl createMoveControl() {
      return new MoveControl(this) {
         protected float rotlerp(float sourceAngle, float targetAngle, float maximumChange) {
            double x = this.wantedX - this.mob.getX();
            double z = this.wantedZ - this.mob.getZ();
            return x * x + z * z < 0.5 ? sourceAngle : super.rotlerp(sourceAngle, targetAngle, maximumChange * 0.25F);
         }
      };
   }

   @Override
   protected void defineSynchedData() {
      super.defineSynchedData();
   }

   @Override
   public void addAdditionalSaveData(CompoundTag pCompound) {
      super.addAdditionalSaveData(pCompound);
   }

   @Override
   public void readAdditionalSaveData(CompoundTag pCompound) {
      super.readAdditionalSaveData(pCompound);
   }

   @Override
   public void registerControllers(ControllerRegistrar controllers) {
      controllers.add(this.meleeAnimationController);
      super.registerControllers(controllers);
   }

   private PlayState meleePredicate(AnimationState<UniqueAbstractMeleeCastingMob> animationEvent) {
      AnimationController<UniqueAbstractMeleeCastingMob> controller = animationEvent.getController();
      if (this.animationToPlay != null) {
         controller.forceAnimationReset();
         controller.setAnimation(this.animationToPlay);
         this.animationToPlay = null;
      }

      return PlayState.CONTINUE;
   }

   public void playAnimation(String animationId) {
      try {
         this.animationToPlay = RawAnimation.begin().thenPlay(animationId);
      } catch (Exception var3) {
         IronsSpellbooks.LOGGER.error("Entity {} Failed to play animation: {}", this, animationId);
      }
   }

   @Override
   public boolean isAnimating() {
      return this.meleeAnimationController.getAnimationState() != State.STOPPED || super.isAnimating();
   }

   protected PathNavigation createNavigation(Level pLevel) {
      return new NotIdioticNavigation(this, pLevel);
   }
}
