package net.redreaper.monsterspellbooks.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier WHITE_GOLD=new ForgeTier(1, 1561, 12.0F, 0.0F, 22, net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL, ()-> Ingredient.of(ModItems.WHITE_GOLD_INGOT.get()));

    public static final Tier ROSE_GOLD=new ForgeTier(2, 1561, 12.0F, 0.0F, 22, net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL, ()-> Ingredient.of(ModItems.ROSE_GOLD_INGOT.get()));

    public static final Tier DEATHSILVER=new ForgeTier(3, 1400, 6f, 8, 18, net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL, ()-> Ingredient.of(ModItems.DEATHSILVER_INGOT.get()));

    public static final Tier PRISMARINE=new ForgeTier(3, 1400, 6f, 8, 18, net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL, ()-> Ingredient.of(Items.PRISMARINE_SHARD));

    public static final Tier SANGUINITE=new ForgeTier(3, 1400, 6f, 8, 18, net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL, ()-> Ingredient.of(ModItems.SANGUINITE_INGOT.get()));

    public static final Tier ORICHALCUM=new ForgeTier(3, 1400, 4f, 10, 10, net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL, ()-> Ingredient.of(ModItems.ORICHALCUM_INGOT.get()));

    public static final Tier DWARVEN_ALLOY=new ForgeTier(3, 1751, 12f, 0, 10, net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL, ()-> Ingredient.of(ModItems.DWARVEN_ALLOY_INGOT.get()));
}
