package net.redreaper.monsterspellbooks.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoods {
    public static final FoodProperties ROSE_GOLD_APPLE=new FoodProperties.Builder().nutrition(4)
            .saturationMod(5).effect(()->new MobEffectInstance(ModMobEffects.MANA_REGEN.get(),5000,3),1f)
            .effect(()->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1F)
            .effect(()->new MobEffectInstance(MobEffects.ABSORPTION, 6000, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties GOLD_TRUFFLE_SLICE = (new FoodProperties.Builder()).nutrition(10)
            .saturationMod(1.5F).build();
}
