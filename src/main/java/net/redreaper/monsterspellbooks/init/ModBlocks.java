package net.redreaper.monsterspellbooks.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS=DeferredRegister.create(net.minecraftforge.registries.ForgeRegistries.BLOCKS, MonstersSpellbooks.MOD_ID);

    public static final RegistryObject<Block>ROSE_GOLD_BLOCK=registerBlock("rose_gold_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.COPPER)));
    public static final RegistryObject<Block>POSEIDON_PEARL_ORE=registerBlock("poseidon_pearl_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block>POSEIDON_PEARL_BLOCK=registerBlock("poseidon_pearl_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block>ORICHALCUM_ORE=registerBlock("orichalcum_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block>DEEPSLATE_ORICHALCUM_ORE=registerBlock("deepslate_orichalcum_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block>RAW_ORICHALCUM_BLOCK=registerBlock("raw_orichalcum_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block>ORICHALCUM_BLOCK=registerBlock("orichalcum_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block>SANGUINITE_BLOCK=registerBlock("sanguinite_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block>ILLAGERITE_BLOCK=registerBlock("illagerite_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.COPPER)));
    public static final RegistryObject<Block>DWARVEN_ALLOY_BLOCK =registerBlock("dwarven_alloy_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block>WHITE_GOLD_BLOCK=registerBlock("white_gold_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));
    public static final RegistryObject<Block>SCORCHED_METAL_ORE =registerBlock("scorched_metal_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.GILDED_BLACKSTONE)));
    public static final RegistryObject<Block>RAW_SCORCHED_METAL_BLOCK=registerBlock("raw_scorched_metal_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));
    public static final RegistryObject<Block>SCORCHED_METAL_BLOCK=registerBlock("scorched_metal_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block>NETHER_PYRITE_ORE =registerBlock("nether_pyrite_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_ORE).sound(SoundType.NETHER_ORE)));
    public static final RegistryObject<Block>NETHER_PYRITE_BLOCK=registerBlock("nether_pyrite_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)));
    public static final RegistryObject<Block>NETHER_RUBY_ORE=registerBlock("nether_ruby_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.NETHER_ORE)));
    public static final RegistryObject<Block>NETHER_RUBY_BLOCK=registerBlock("nether_ruby_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> DEATHSILVER_ORE =registerBlock("deathsilver_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block>DEATHSILVER_BLOCK=registerBlock("deathsilver_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block>SPECTRITE_BLOCK=registerBlock("spectrite_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));
    public static final RegistryObject<Block>WITHER_ALLOY_BLOCK=registerBlock("wither_alloy_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));
    public static final RegistryObject<Block>BLAZESTEEL_BLOCK=registerBlock("blazesteel_block",
            ()->new MagmaBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));
    public static final RegistryObject<Block>VOID_MATTER_ORE=registerBlock("void_matter_ore",
            ()->new MagmaBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block>CORAL_LOG=registerBlock("coral_log",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block>CORAL_PLANKS=registerBlock("coral_planks",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    public static final RegistryObject<Block>CHISELED_PRISMARINE_BRICKS=registerBlock("chiseled_prismarine_bricks",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS)));

    public static final RegistryObject<Block>PEARl_MARBLE=registerBlock("pearl_marble",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));
    public static final RegistryObject<StairBlock>PEARL_MARBLE_STAIRS=registerBlock("pearl_marble_stairs",
            () -> new StairBlock(ModBlocks.PEARl_MARBLE.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));
    public static final RegistryObject<SlabBlock>PEARL_MARBLE_SLAB=registerBlock("pearl_marble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));
    public static final RegistryObject<WallBlock> PEARL_MARBLE_WALL =registerBlock("pearl_marble_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));
    public static final RegistryObject<Block>POLISHED_PEARl_MARBLE=registerBlock("polished_pearl_marble",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS)));
    public static final RegistryObject<StairBlock>POLISHED_PEARL_MARBLE_STAIRS=registerBlock("polished_pearl_marble_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_PEARl_MARBLE.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS)));
    public static final RegistryObject<SlabBlock>POLISHED_PEARL_MARBLE_SLAB=registerBlock("polished_pearl_marble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS)));
    public static final RegistryObject<WallBlock> POLISHED_PEARL_MARBLE_WALL =registerBlock("polished_pearl_marble_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS)));
    public static final RegistryObject<Block>PEARl_MARBLE_TILES=registerBlock("pearl_marble_tiles",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS)));
    public static final RegistryObject<StairBlock>PEARL_MARBLE_TILE_STAIRS=registerBlock("pearl_marble_tile_stairs",
            () -> new StairBlock(ModBlocks.PEARl_MARBLE_TILES.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));
    public static final RegistryObject<SlabBlock>PEARL_MARBLE_TILE_SLAB=registerBlock("pearl_marble_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));
    public static final RegistryObject<WallBlock> PEARL_MARBLE_TILE_WALL =registerBlock("pearl_marble_tile_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));
    public static final RegistryObject<Block>PEARl_MARBLE_PILLAR=registerBlock("pearl_marble_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));


    public static final RegistryObject<Block>IVORYSTONE=registerBlock("ivorystone",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<StairBlock>IVORYSTONE_STAIRS=registerBlock("ivorystonestairs",
            () -> new StairBlock(ModBlocks.IVORYSTONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<SlabBlock>IVORYSTONE_SLAB=registerBlock("ivorystone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<WallBlock> IVORYSTONE_WALL =registerBlock("ivorystone_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block>POLISHED_IVORYSTONE=registerBlock("polished_ivorystone",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
    public static final RegistryObject<StairBlock> POLISHED_IVORYSTONE_STAIRS =registerBlock("polished_ivorystone_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_IVORYSTONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
    public static final RegistryObject<SlabBlock>POLISHED_IVORYSTONE_SLAB=registerBlock("polished_ivorystone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
    public static final RegistryObject<WallBlock>POLISHED_IVORYSTONE_WALL =registerBlock("polished_ivorystone_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
    public static final RegistryObject<Block>IVORYSTONE_BRICKS=registerBlock("ivorystone_bricks",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final RegistryObject<StairBlock> IVORYSTONE_BRICK_STAIRS =registerBlock("ivorystone_brick_stairs",
            () -> new StairBlock(ModBlocks.IVORYSTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final RegistryObject<SlabBlock> IVORYSTONE_BRICK_SLAB =registerBlock("ivorystone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final RegistryObject<WallBlock> IVORYSTONE_BRICK_WALL =registerBlock("ivorystone_brick_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block>CRACKED_IVORYSTONE_BRICKS=registerBlock("cracked_ivorystone_bricks",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
    public static final RegistryObject<StairBlock>CRACKED_IVORYSTONE_BRICK_STAIRS =registerBlock("cracked_ivorystone_brick_stairs",
            () -> new StairBlock(ModBlocks.CRACKED_IVORYSTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
    public static final RegistryObject<SlabBlock>CRACKED_IVORYSTONE_BRICK_SLAB =registerBlock("cracked_ivorystone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
    public static final RegistryObject<WallBlock>CRACKED_IVORYSTONE_BRICK_WALL =registerBlock("cracked_ivorystone_brick_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block>CHISELED_IVORYSTONE_BRICKS=registerBlock("chiseled_ivorystone_bricks",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
    public static final RegistryObject<Block>FROST_IVORYSTONE_BRICKS=registerBlock("frost_ivorystone_bricks",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
    public static final RegistryObject<StairBlock>FROST_IVORYSTONE_BRICK_STAIRS =registerBlock("frost_ivorystone_brick_stairs",
            () -> new StairBlock(ModBlocks.FROST_IVORYSTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
    public static final RegistryObject<SlabBlock>FROST_IVORYSTONE_BRICK_SLAB =registerBlock("frost_ivorystone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
    public static final RegistryObject<WallBlock>FROST_IVORYSTONE_BRICK_WALL =registerBlock("frost_ivorystone_brick_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));

    public static final RegistryObject<Block>VILESTONE=registerBlock("vilestone",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
    public static final RegistryObject<StairBlock>VILESTONE_STAIRS =registerBlock("vilestone_stairs",
            () -> new StairBlock(ModBlocks.VILESTONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
    public static final RegistryObject<SlabBlock> VILESTONE_SLAB =registerBlock("vilestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
    public static final RegistryObject<WallBlock> VILESTONE_WALL =registerBlock("vilestone_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));

    public static final RegistryObject<Block>VILESTONE_BRICKS=registerBlock("vilestone_bricks",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
    public static final RegistryObject<StairBlock>VILESTONE_BRICK_STAIRS =registerBlock("vilestone_brick_stairs",
            () -> new StairBlock(ModBlocks.VILESTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
    public static final RegistryObject<SlabBlock> VILESTONE_BRICK_SLAB =registerBlock("vilestone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
    public static final RegistryObject<WallBlock> VILESTONE_BRICK_WALL =registerBlock("vilestone_brick_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));

    public static final RegistryObject<Block>CHISELED_VILESTONE_BRICKS=registerBlock("chiseled_vilestone_bricks",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));

    public static final RegistryObject<Block>GRAVISTONE=registerBlock("gravistone",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn=BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T>block){
        ModItems.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
