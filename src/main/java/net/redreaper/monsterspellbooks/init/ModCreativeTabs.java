package net.redreaper.monsterspellbooks.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab>CREATIVE_MODE_TAB=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MonstersSpellbooks.MOD_ID);

    public static final Supplier<CreativeModeTab>MONSTERS_AND_GEAR_TAB=CREATIVE_MODE_TAB.register("monsters_and_gear_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.BOOK_OF_SOULS.get()))
                    .title(Component.translatable("creative_tab.monsterspellbooks.monsters_and_gear"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModItems.ENCHANTING_TOME.get());
                        output.accept(ModItems.GUARDIAN_SPELLBOOK.get());
                        output.accept(ModItems.BOOK_OF_SOULS.get());
                        output.accept(ModItems.FRENZY_KING_BOOK.get());
                        output.accept(ModItems.DISEASE_ENCYCLOPEDIA.get());
                        output.accept(ModItems.REAPER_LANTERN.get());
                        output.accept(ModItems.VILENOVA_STAFF.get());
                        output.accept(ModItems.GREAT_AXEBLADE.get());
                        output.accept(ModItems.MASTERS_KATANA.get());
                        output.accept(ModItems.DANCERS_SWORD.get());
                        output.accept(ModItems.PRISMARINE_CLAYMORE.get());
                        output.accept(ModItems.PRISMARINE_AXE.get());
                        output.accept(ModItems.CULTIST_KNIFE.get());
                        output.accept(ModItems.ETERNAL_KNIFE.get());
                        output.accept(ModItems.WHITE_GOLD_PICKAXE.get());
                        output.accept(ModItems.WHITE_GOLD_AXE.get());
                        output.accept(ModItems.WHITE_GOLD_SHOVEL.get());
                        output.accept(ModItems.WHITE_GOLD_HOE.get());
                        output.accept(ModItems.ROSE_GOLD_PICKAXE.get());
                        output.accept(ModItems.ROSE_GOLD_AXE.get());
                        output.accept(ModItems.ROSE_GOLD_SHOVEL.get());
                        output.accept(ModItems.ROSE_GOLD_HOE.get());
                        output.accept(ModItems.ORICHALCUM_GREATSWORD.get());
                        output.accept(ModItems.ORICHALCUM_GREATAXE.get());
                        output.accept(ModItems.ORICHALCUM_WARHAMMER.get());
                        output.accept(ModItems.ORICHALCUM_AXE.get());
                        output.accept(ModItems.ORICHALCUM_DAGGER.get());
                        output.accept(ModItems.DWARVEN_GREATAXE.get());
                        output.accept(ModItems.DWARVEN_WARHAMMER.get());
                        output.accept(ModItems.DWARVEN_AXE.get());
                        output.accept(ModItems.SANGUINITE_DAGGER.get());
                        output.accept(ModItems.SANGUINITE_SCYTHE.get());
                        output.accept(ModItems.SANGUINITE_AXE.get());
                        output.accept(ModItems.DEATHSILVER_GREATAXE.get());
                        output.accept(ModItems.DEATHSILVER_AXE.get());
                        output.accept(ModItems.DEATHSILVER_SWORD.get());
                        output.accept(ModItems.DEATHSILVER_DAGGER.get());
                        output.accept(ModItems.VILLAGE_BUTCHERER.get());
                        output.accept(ModItems.POISON_BITER.get());
                        output.accept(ModItems.POISON_GLAIVE.get());
                        output.accept(ModItems.FROST_FANG.get());
                        output.accept(ModItems.CLAWS_OF_CALAMITY.get());
                        output.accept(ModItems.PALLADIN_HAMMER.get());
                        output.accept(ModItems.MAGMATIC_MACUAHUITL.get());
                        output.accept(ModItems.REAPER_SICKLE.get());
                        output.accept(ModItems.STARLESS_NIGHT.get());
                        output.accept(ModItems.SWIFT_STRIKER.get());
                        output.accept(ModItems.VOID_TOUCHED_BLADE.get());
                        output.accept(ModItems.STARSCOURGE_SWORD.get());
                        output.accept(ModItems.DISRUPTION_NAGINATA.get());
                        output.accept(ModItems.ENDERSENT_CRUSHER.get());
                        output.accept(ModItems.HEAVY_MACE.get());
                        output.accept(ModItems.SNOW_BOW.get());
                        output.accept(ModItems.MITHRIL_SHIELD.get());
                        output.accept(ModItems.DWARVEN_SHIELD.get());

                        output.accept(ModItems.WILDFIRE_CROWN.get());
                        output.accept(ModItems.FUNGAL_CAP_RED.get());
                        output.accept(ModItems.FUNGAL_CAP_BLUE.get());

                        output.accept(ModItems.DRAUGR_ELITE_HELMET.get());
                        output.accept(ModItems.DRAUGR_ELITE_CHESTPLATE.get());
                        output.accept(ModItems.DRAUGR_ELITE_BOOTS.get());

                        output.accept(ModItems.UNSTABLE_ROBES_HELMET.get());
                        output.accept(ModItems.UNSTABLE_ROBES_CHESTPLATE.get());
                        output.accept(ModItems.UNSTABLE_ROBES_LEGGINGS.get());
                        output.accept(ModItems.UNSTABLE_ROBES_BOOTS.get());

                        output.accept(ModItems.NECROMANCER_HELMET.get());
                        output.accept(ModItems.NECROMANCER_CHESTPLATE.get());
                        output.accept(ModItems.NECROMANCER_LEGGINGS.get());
                        output.accept(ModItems.NECROMANCER_BOOTS.get());

                        output.accept(ModItems.SANGUINITE_HERO_HOOD.get());
                        output.accept(ModItems.SANGUINITE_HERO_CHESTPLATE.get());
                        output.accept(ModItems.SANGUINITE_HERO_LEGGINGS.get());
                        output.accept(ModItems.SANGUINITE_HERO_BOOTS.get());

                        output.accept(ModItems.FORGE_MASTERPIECE_HELMET.get());
                        output.accept(ModItems.FORGE_MASTERPIECE_CHESTPLATE.get());
                        output.accept(ModItems.FORGE_MASTERPIECE_LEGGINGS.get());
                        output.accept(ModItems.FORGE_MASTERPIECE_BOOTS.get());

                        output.accept(ModItems.STARSCOURGE_HELMET.get());
                        output.accept(ModItems.STARSCOURGE_CHESTPLATE.get());
                        output.accept(ModItems.STARSCOURGE_LEGGINGS.get());
                        output.accept(ModItems.STARSCOURGE_BOOTS.get());

                        output.accept(ModItems.DWARVEN_ENGINEER_VISOR.get());
                        output.accept(ModItems.DWARVEN_ENGINEER_CHESTPLATE.get());
                        output.accept(ModItems.DWARVEN_ENGINEER_LEGGINGS.get());
                        output.accept(ModItems.DWARVEN_ENGINEER_BOOTS.get());

                        output.accept(ModItems.ILLAGER_ENCHANTER_HELMET.get());
                        output.accept(ModItems.ILLAGER_ENCHANTER_CHESTPLATE.get());
                        output.accept(ModItems.ILLAGER_ENCHANTER_LEGGINGS.get());
                        output.accept(ModItems.ILLAGER_ENCHANTER_BOOTS.get());

                        output.accept(ModItems.ILLAGER_EMBER_ROBE_HELMET.get());
                        output.accept(ModItems.ILLAGER_EMBER_ROBE_CHESTPLATE.get());
                        output.accept(ModItems.ILLAGER_EMBER_ROBE_LEGGINGS.get());
                        output.accept(ModItems.ILLAGER_EMBER_ROBE_BOOTS.get());

                        output.accept(ModItems.ILLAGER_ICEOLOGER_HELMET.get());
                        output.accept(ModItems.ILLAGER_ICEOLOGER_CHESTPLATE.get());
                        output.accept(ModItems.ILLAGER_ICEOLOGER_LEGGINGS.get());
                        output.accept(ModItems.ILLAGER_ICEOLOGER_BOOTS.get());

                        output.accept(ModItems.DEATH_KNIGHT_HELMET.get());
                        output.accept(ModItems.DEATH_KNIGHT_CHESTPLATE.get());
                        output.accept(ModItems.DEATH_KNIGHT_LEGGINGS.get());
                        output.accept(ModItems.DEATH_KNIGHT_BOOTS.get());

                        output.accept(ModItems.HEROBRINE_CULTIST_HELMET.get());
                        output.accept(ModItems.HEROBRINE_CULTIST_CHESTPLATE.get());
                        output.accept(ModItems.HEROBRINE_CULTIST_LEGGINGS.get());
                        output.accept(ModItems.HEROBRINE_CULTIST_BOOTS.get());

                        output.accept(ModItems.WITHERWARD_RING.get());
                        output.accept(ModItems.COLD_CONJURER_TALISMAN.get());
                        output.accept(ModItems.CRITICAL_GLASSES.get());
                        output.accept(ModItems.IGNITION_GLOVE.get());
                        output.accept(ModItems.THUNDERING_QUIVER.get());
                        output.accept(ModItems.WITHERED_TOTEM.get());

                        output.accept(ModItems.OBSIDIAN_MEDAL.get());
                        output.accept(ModItems.BRIMSTONE_SIGIL.get());
                        output.accept(ModItems.CROSS_NECKLACE.get());
                        output.accept(ModItems.DWARVEN_POWER_CORE.get());
                        output.accept(ModItems.ORB_SOUL.get());
                    }).build());

    public static final Supplier<CreativeModeTab>MONSTERS_AND_MATERIALS_TAB=CREATIVE_MODE_TAB.register("monsters_and_materials_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.VILE_BONE.get()))
                    .withTabsBefore(new ResourceLocation(MonstersSpellbooks.MOD_ID,"monsters_and_gear_tab"))
                    .title(Component.translatable("creative_tab.monsterspellbooks.monsters_and_materials"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModItems.NECRO_UPGRADE_ORB.get());

                        output.accept(ModItems.ROSE_GOLD_INGOT.get());
                        output.accept(ModItems.ROSE_GOLD_NUGGET.get());
                        output.accept(ModItems.POSEIDON_PEARL.get());
                        output.accept(ModItems.RAW_ORICHALCUM.get());
                        output.accept(ModItems.ORICHALCUM_INGOT.get());
                        output.accept(ModItems.ORICHALCUM_NUGGET.get());
                        output.accept(ModItems.SANGUINITE_INGOT.get());
                        output.accept(ModItems.ILLAGERITE_INGOT.get());
                        output.accept(ModItems.ILLAGERITE_NUGGETS.get());
                        output.accept(ModItems.DWARVEN_ALLOY_SCRAP.get());
                        output.accept(ModItems.DWARVEN_ALLOY_INGOT.get());
                        output.accept(ModItems.DWARVEN_ALLOY_NUGGET.get());
                        output.accept(ModItems.WHITE_GOLD_INGOT.get());
                        output.accept(ModItems.WHITE_GOLD_NUGGET.get());
                        output.accept(ModItems.RAW_SCORCHED_METAL.get());
                        output.accept(ModItems.SCORCHED_METAL_INGOT.get());
                        output.accept(ModItems.SCORCHED_METAL_NUGGET.get());
                        output.accept(ModItems.NETHER_PYRITE.get());
                        output.accept(ModItems.NETHER_RUBY.get());
                        output.accept(ModItems.DEATHSILVER_INGOT.get());
                        output.accept(ModItems.DEATHSILVER_NUGGET.get());
                        output.accept(ModItems.SPECTRITE_INGOT.get());
                        output.accept(ModItems.BLAZESTEEL_INGOT.get());
                        output.accept(ModItems.WITHER_ALLOY_INGOT.get());
                        output.accept(ModItems.WITHER_ALLOY_NUGGET.get());

                        output.accept(ModItems.VOID_MATTER.get());
                        output.accept(ModItems.VOID_OBSIDIAN_INGOT.get());

                        output.accept(ModItems.REDSTONE_CRYSTAL.get());
                        output.accept(ModItems.PRISMARINE_GEM.get());
                        output.accept(ModItems.WISEWOOD_BONE.get());
                        output.accept(ModItems.PLANT_MATTER.get());
                        output.accept(ModItems.HOMUNCULUS_BLOOD_ORB.get());
                        output.accept(ModItems.DWARVEN_ALLOY_PLATE.get());
                        output.accept(ModItems.DWARVEN_ALLOY_COG.get());
                        output.accept(ModItems.REDSTONE_BATTERY.get());
                        output.accept(ModItems.VILE_BONE.get());
                        output.accept(ModItems.ECTOPLASM_BALL.get());
                        output.accept(ModItems.ECTOPLASM_VIAL.get());
                        output.accept(ModItems.RAW_SANGUINITE_VIAL.get());
                        output.accept(ModItems.PUTRESCENCE_VIAL.get());
                        output.accept(ModItems.VOID_VIAL.get());
                        output.accept(ModItems.SUPERIOR_WEAPON_PARTS.get());
                        output.accept(ModItems.UPGRADE_RUNE.get());
                        output.accept(ModItems.NECRO_RUNE.get());

                        output.accept(ModItems.ROSE_GOLD_APPLE.get());
                        output.accept(ModItems.AEGIS_SPAWN_EGG.get());
                        output.accept(ModItems.DRIPPLER_SPAWN_EGG.get());
                        output.accept(ModItems.SPRIGGAN_SPAWN_EGG.get());
                        output.accept(ModItems.ILLAGER_ENCHANTER_SPAWN_EGG.get());
                        output.accept(ModItems.ILLAGER_ICEOLOGER_SPAWN_EGG.get());
                        output.accept(ModItems.ILLAGER_FIREOLOGER_SPAWN_EGG.get());

                        output.accept(ModItems.HEROBRINE_CULTIST_MAGE_SPAWN_EGG.get());
                        output.accept(ModItems.HEROBRINE_CULTIST_ASSASSIN_SPAWN_EGG.get());

                        output.accept(ModItems.DRAUGR_EVOKER_SPAWN_EGG.get());
                        output.accept(ModItems.DRAUGR_VINDICATOR_SPAWN_EGG.get());
                        output.accept(ModItems.DRAUGR_ELITE_VINDICATOR_SPAWN_EGG.get());
                        output.accept(ModItems.DRAUGR_PILLAGER_SPAWN_EGG.get());
                        output.accept(ModItems.DWARVEN_SPHERE_SPAWN_EGG.get());
                        output.accept(ModItems.DWARVEN_SLICER_SPAWN_EGG.get());
                        output.accept(ModItems.JUNGLE_WHISPERER_SPAWN_EGG.get());
                        output.accept(ModItems.JUNGLE_LEAPLEAF_SPAWN_EGG.get());
                        output.accept(ModItems.REDSTONE_ELEMENTAL_SPAWN_EGG.get());
                        output.accept(ModItems.SOUL_WRAITH_SPAWN_EGG.get());
                        output.accept(ModItems.WITHER_WARLOCK_SPAWN_EGG.get());
                        output.accept(ModItems.WITHER_WARRIOR_SPAWN_EGG.get());
                        output.accept(ModItems.PRISMARINE_KEEPER_SPAWN_EGG.get());
                        output.accept(ModItems.MAGMA_ATRONACH_SPAWN_EGG.get());
                        output.accept(ModItems.BLASTLING_SPAWN_EGG.get());
                    }).build());

    public static final Supplier<CreativeModeTab>MONSTERS_AND_BLOCKS_TAB=CREATIVE_MODE_TAB.register("monsters_and_blocks_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModBlocks.WITHER_ALLOY_BLOCK.get()))
                    .withTabsBefore(new ResourceLocation(MonstersSpellbooks.MOD_ID,"monsters_and_materials_tab"))
                    .title(Component.translatable("creative_tab.monsterspellbooks.monsters_and_blocks"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModBlocks.ROSE_GOLD_BLOCK.get());
                        output.accept(ModBlocks.POSEIDON_PEARL_ORE.get());
                        output.accept(ModBlocks.POSEIDON_PEARL_BLOCK.get());
                        output.accept(ModBlocks.ORICHALCUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get());
                        output.accept(ModBlocks.RAW_ORICHALCUM_BLOCK.get());
                        output.accept(ModBlocks.ORICHALCUM_BLOCK.get());
                        output.accept(ModBlocks.SANGUINITE_BLOCK.get());
                        output.accept(ModBlocks.ILLAGERITE_BLOCK.get());
                        output.accept(ModBlocks.DWARVEN_ALLOY_BLOCK.get());
                        output.accept(ModBlocks.WHITE_GOLD_BLOCK.get());
                        output.accept(ModBlocks.SCORCHED_METAL_ORE.get());
                        output.accept(ModBlocks.RAW_SCORCHED_METAL_BLOCK.get());
                        output.accept(ModBlocks.SCORCHED_METAL_BLOCK.get());
                        output.accept(ModBlocks.NETHER_PYRITE_ORE.get());
                        output.accept(ModBlocks.NETHER_PYRITE_BLOCK.get());
                        output.accept(ModBlocks.NETHER_RUBY_ORE.get());
                        output.accept(ModBlocks.NETHER_RUBY_BLOCK.get());
                        output.accept(ModBlocks.WITHER_ALLOY_BLOCK.get());
                        output.accept(ModBlocks.DEATHSILVER_ORE.get());
                        output.accept(ModBlocks.DEATHSILVER_BLOCK.get());
                        output.accept(ModBlocks.SPECTRITE_BLOCK.get());
                        output.accept(ModBlocks.BLAZESTEEL_BLOCK.get());
                        output.accept(ModBlocks.VOID_MATTER_ORE.get());

                        output.accept(ModBlocks.CORAL_LOG.get());
                        output.accept(ModBlocks.CORAL_PLANKS.get());

                        output.accept(ModBlocks.CHISELED_PRISMARINE_BRICKS.get());

                        output.accept(ModBlocks.PEARl_MARBLE.get());
                        output.accept(ModBlocks.PEARL_MARBLE_STAIRS.get());
                        output.accept(ModBlocks.PEARL_MARBLE_SLAB.get());
                        output.accept(ModBlocks.PEARL_MARBLE_WALL.get());
                        output.accept(ModBlocks.POLISHED_PEARl_MARBLE.get());
                        output.accept(ModBlocks.POLISHED_PEARL_MARBLE_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_PEARL_MARBLE_SLAB.get());
                        output.accept(ModBlocks.POLISHED_PEARL_MARBLE_WALL.get());
                        output.accept(ModBlocks.PEARl_MARBLE_TILES.get());

                        output.accept(ModBlocks.PEARL_MARBLE_TILE_STAIRS.get());
                        output.accept(ModBlocks.PEARL_MARBLE_TILE_SLAB.get());
                        output.accept(ModBlocks.PEARL_MARBLE_TILE_WALL.get());

                        output.accept(ModBlocks.PEARl_MARBLE_PILLAR.get());

                        output.accept(ModBlocks.IVORYSTONE.get());
                        output.accept(ModBlocks.IVORYSTONE_STAIRS.get());
                        output.accept(ModBlocks.IVORYSTONE_SLAB.get());
                        output.accept(ModBlocks.IVORYSTONE_WALL.get());

                        output.accept(ModBlocks.POLISHED_IVORYSTONE.get());
                        output.accept(ModBlocks.POLISHED_IVORYSTONE_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_IVORYSTONE_SLAB.get());
                        output.accept(ModBlocks.POLISHED_IVORYSTONE_WALL.get());

                        output.accept(ModBlocks.IVORYSTONE_BRICKS.get());
                        output.accept(ModBlocks.IVORYSTONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.IVORYSTONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.IVORYSTONE_BRICK_WALL.get());

                        output.accept(ModBlocks.CRACKED_IVORYSTONE_BRICKS.get());
                        output.accept(ModBlocks.CHISELED_IVORYSTONE_BRICKS.get());

                        output.accept(ModBlocks.FROST_IVORYSTONE_BRICKS.get());
                        output.accept(ModBlocks.FROST_IVORYSTONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.FROST_IVORYSTONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.FROST_IVORYSTONE_BRICK_WALL.get());
                    }).build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
