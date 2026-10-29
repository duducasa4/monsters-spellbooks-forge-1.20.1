    package net.redreaper.monsterspellbooks.item.shields.dwarven_riot_shield;

import mod.azure.azurelib.animation.controller.AzAnimationController;
import mod.azure.azurelib.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.animation.impl.AzItemAnimator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

    public class DwarvenRiotShieldAnimator extends AzItemAnimator {
        private static final ResourceLocation ANIMATIONS = new ResourceLocation("monsterspellbooks", "animations/item/dwarven_shield.animation.json");

        public void registerControllers(AzAnimationControllerContainer<ItemStack> animationControllerContainer) {
            animationControllerContainer.add(AzAnimationController.builder(this, "base_controller").build(), new AzAnimationController[0]);
        }

        public @NotNull ResourceLocation getAnimationLocation(ItemStack animatable) {
            return ANIMATIONS;
        }
    }
