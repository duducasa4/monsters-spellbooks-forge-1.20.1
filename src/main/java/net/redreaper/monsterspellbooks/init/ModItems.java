package net.redreaper.monsterspellbooks.init;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.item.UpgradeOrbItem;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.item.armor.tierArch.ForgeMasterpieceArmorItem;
import net.redreaper.monsterspellbooks.item.armor.tierArch.SanguiniteHeroArmorItem;
import net.redreaper.monsterspellbooks.item.armor.tierArch.StarscourgeArmorItem;
import net.redreaper.monsterspellbooks.item.armor.tierHybrid.*;
import net.redreaper.monsterspellbooks.item.armor.tierSchool.NecromancerArmorItem;
import net.redreaper.monsterspellbooks.item.armor.tierUnique.*;
import net.redreaper.monsterspellbooks.item.curios.back.ThunderingQuiverItem;
import net.redreaper.monsterspellbooks.item.curios.belt.WitheredTotemItem;
import net.redreaper.monsterspellbooks.item.curios.elemental_charm.*;
import net.redreaper.monsterspellbooks.item.curios.hands.IgnitionGloveItem;
import net.redreaper.monsterspellbooks.item.curios.head.CriticalSorcererGlassesItem;
import net.redreaper.monsterspellbooks.item.curios.necklace.ColdConjurerTalisman;
import net.redreaper.monsterspellbooks.item.curios.rings.WitherWardCurio;
import net.redreaper.monsterspellbooks.item.curios.spellbooks.*;
import net.redreaper.monsterspellbooks.item.curios.spellbooks.reaper_lantern.ReaperLanternSpellBook;
import net.redreaper.monsterspellbooks.item.shields.dwarven_riot_shield.DwarvenRiotShieldItem;
import net.redreaper.monsterspellbooks.item.shields.mithril_shield.MithrilShieldItem;
import net.redreaper.monsterspellbooks.item.staves.brimstone_orochi.BrimstoneOrochiItem;
import net.redreaper.monsterspellbooks.item.staves.frozen_commander.FrozenCommanderStaffItem;
import net.redreaper.monsterspellbooks.item.staves.vilenova_staff.VileNovaStaffItem;
import net.redreaper.monsterspellbooks.item.weapons.*;
import net.redreaper.monsterspellbooks.item.weapons.claws_of_calamity.ClawsOfCalamityItem;
import net.redreaper.monsterspellbooks.item.weapons.crescent_blood_rose.CrescentBloodRoseItem;
import net.redreaper.monsterspellbooks.item.weapons.disruption_nanginata.DisruptionNaginataItem;
import net.redreaper.monsterspellbooks.item.weapons.endersent_crusher.EndersentCrusherItem;
import net.redreaper.monsterspellbooks.item.weapons.gore_child.GoreChildItem;
import net.redreaper.monsterspellbooks.item.extended.magic_axe.ExtendedAxeItem;
import net.redreaper.monsterspellbooks.item.weapons.magmatic_macuahuitl.MagmaticMacuahuitlItem;
import net.redreaper.monsterspellbooks.item.weapons.necromancer_trident.NecromancerTridentItem;
import net.redreaper.monsterspellbooks.item.weapons.paadin_hammer.PaladinHammerItem;
import net.redreaper.monsterspellbooks.utils.ModRarities;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=DeferredRegister.create(net.minecraftforge.registries.ForgeRegistries.ITEMS, MonstersSpellbooks.MOD_ID);
    public static final RegistryObject<Item>ROSE_GOLD_INGOT= ITEMS.register("rose_gold_ingot",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>ROSE_GOLD_NUGGET= ITEMS.register("rose_gold_nugget",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>POSEIDON_PEARL= ITEMS.register("poseidon_pearl",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>RAW_ORICHALCUM= ITEMS.register("raw_orichalcum",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>ORICHALCUM_INGOT= ITEMS.register("orichalcum_ingot",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>ORICHALCUM_NUGGET= ITEMS.register("orichalcum_nugget",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>DEATHSILVER_INGOT= ITEMS.register("deathsilver_ingot",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>DEATHSILVER_NUGGET= ITEMS.register("deathsilver_nugget",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>SANGUINITE_INGOT= ITEMS.register("sanguinite_ingot",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>ILLAGERITE_INGOT= ITEMS.register("illagerite_ingot",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>ILLAGERITE_NUGGETS= ITEMS.register("illagerite_nugget",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>DWARVEN_ALLOY_SCRAP= ITEMS.register("dwarven_alloy_scrap",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>DWARVEN_ALLOY_INGOT= ITEMS.register("dwarven_alloy_ingot",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>DWARVEN_ALLOY_NUGGET= ITEMS.register("dwarven_alloy_nugget",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>WHITE_GOLD_INGOT= ITEMS.register("white_gold_ingot",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>WHITE_GOLD_NUGGET= ITEMS.register("white_gold_nugget",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>RAW_SCORCHED_METAL= ITEMS.register("raw_scorched_metal",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>SCORCHED_METAL_INGOT= ITEMS.register("scorched_metal_ingot",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>SCORCHED_METAL_NUGGET= ITEMS.register("scorched_metal_nugget",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>NETHER_PYRITE= ITEMS.register("nether_pyrite",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>NETHER_RUBY= ITEMS.register("nether_ruby",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>SPECTRITE_INGOT= ITEMS.register("spectrite_ingot",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>BLAZESTEEL_INGOT= ITEMS.register("blazesteel_ingot",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>WITHER_ALLOY_INGOT= ITEMS.register("wither_alloy_ingot",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>WITHER_ALLOY_NUGGET= ITEMS.register("wither_alloy_nugget",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>VOID_MATTER= ITEMS.register("void_matter",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>VOID_OBSIDIAN_INGOT= ITEMS.register("void_obsidian_ingot",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>HOMUNCULUS_BLOOD_ORB = ITEMS.register("homunculus_blood_orb",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>RAW_SANGUINITE_VIAL = ITEMS.register("raw_sanguinite_vial",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>REDSTONE_CRYSTAL= ITEMS.register("redstone_crystal",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>PRISMARINE_GEM= ITEMS.register("prismarine_gem",
            ()->new Item(new Item.Properties().rarity(ModRarities.PRISMARINE_RARITY_PROXY.getValue())));
    public static final RegistryObject<Item>WISEWOOD_BONE= ITEMS.register("wisewood_bone",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>PLANT_MATTER= ITEMS.register("plant_matter",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>DWARVEN_ALLOY_PLATE= ITEMS.register("dwarven_alloy_plate",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>DWARVEN_ALLOY_COG= ITEMS.register("dwarven_alloy_cog",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>REDSTONE_BATTERY= ITEMS.register("redstone_battery",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>DWARVEN_UPGRADE = ITEMS.register("dwarven_upgrade",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>STRIDER_COTTON_BALL= ITEMS.register("strider_cotton_boll",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>STRIDER_COTTON_STRING= ITEMS.register("strider_cotton_string",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>VILE_BONE= ITEMS.register("vile_bone",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>ECTOPLASM_BALL= ITEMS.register("ectoplasm_ball",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>ECTOPLASM_VIAL= ITEMS.register("ectoplasm_vial",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>PUTRESCENCE_VIAL= ITEMS.register("putrescence_vial",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>VOID_VIAL= ITEMS.register("void_vial",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>SUPERIOR_WEAPON_PARTS= ITEMS.register("superior_weapon_parts",
            ()->new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item>UPGRADE_RUNE= ITEMS.register("upgrade_rune",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>NECRO_RUNE= ITEMS.register("necro_rune",
            ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item>ROSE_GOLD_APPLE=ITEMS.register("rose_gold_apple",
            ()->new Item(new Item.Properties().food(ModFoods.ROSE_GOLD_APPLE)));
    public static final RegistryObject<Item>GOLD_TRUFFLE_SLICE=ITEMS.register("gold_truffle_slice",
            ()->new Item(new Item.Properties().fireResistant().food(ModFoods.GOLD_TRUFFLE_SLICE)));

    public static final RegistryObject<Item>FROZEN_COMMANDER_STAFF=ITEMS.register("frozen_commander_staff",
            FrozenCommanderStaffItem::new);
    public static final RegistryObject<Item>VILENOVA_STAFF=ITEMS.register("vilenova_staff",
            VileNovaStaffItem::new);
    public static final RegistryObject<Item>BRIMSTONE_OROCHI=ITEMS.register("brimstone_orochi",
            BrimstoneOrochiItem::new);

    public static final RegistryObject<Item> GREAT_AXEBLADE = ITEMS.register("great_axeblade",
            GreatAxebladeItem::new);
    public static final RegistryObject<Item> MASTERS_KATANA = ITEMS.register("masters_katana",
            MastersKatana::new);
    public static final RegistryObject<Item> DANCERS_SWORD = ITEMS.register("dancers_sword",
            DancerSwordItem::new);

    public static final RegistryObject<Item> PRISMARINE_CLAYMORE = ITEMS.register("prismarine_claymore", () ->
            new AxeItem(ModToolTiers.PRISMARINE, 0, 0, net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(ItemPropertiesHelper.equipment().rarity(ModRarities.PRISMARINE_RARITY_PROXY.getValue()), net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.PRISMARINE_CLAYMORE))));
    public static final RegistryObject<AxeItem>PRISMARINE_AXE=ITEMS.register("prismarine_axe", ()->
            new AxeItem(ModToolTiers.PRISMARINE, 0, 0, net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(ItemPropertiesHelper.equipment().rarity(ModRarities.PRISMARINE_RARITY_PROXY.getValue()), net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.PRISMARINE_AXE))));

    public static final RegistryObject<Item>CULTIST_KNIFE=ITEMS.register("cultist_knife",
            CultistKnifeItem::new);
    public static final RegistryObject<Item>ETERNAL_KNIFE=ITEMS.register("eternal_knife",
            EternalKnifeItem::new);

    public static final RegistryObject<Item>MITHRIL_SHIELD=ITEMS.register("mithril_shield",
            MithrilShieldItem::new);
    public static final RegistryObject<Item>DWARVEN_SHIELD=ITEMS.register("dwarven_shield",
            DwarvenRiotShieldItem::new);

    public static final RegistryObject<PickaxeItem>WHITE_GOLD_PICKAXE=ITEMS.register("white_gold_pickaxe",
            ()->new PickaxeItem(ModToolTiers.WHITE_GOLD, (int) (2), (float) (-2),new Item.Properties()));
    public static final RegistryObject<AxeItem>WHITE_GOLD_AXE=ITEMS.register("white_gold_axe",
            ()->new AxeItem(ModToolTiers.WHITE_GOLD, (float) (4), (float) (-2.5f),new Item.Properties()));
    public static final RegistryObject<ShovelItem>WHITE_GOLD_SHOVEL=ITEMS.register("white_gold_shovel",
            ()->new ShovelItem(ModToolTiers.WHITE_GOLD, (float) (0), (float) (-2),new Item.Properties()));
    public static final RegistryObject<HoeItem>WHITE_GOLD_HOE=ITEMS.register("white_gold_hoe",
            ()->new HoeItem(ModToolTiers.WHITE_GOLD, (int) (0), (float) (-2),new Item.Properties()));
    public static final RegistryObject<PickaxeItem>ROSE_GOLD_PICKAXE=ITEMS.register("rose_gold_pickaxe",
            ()->new PickaxeItem(ModToolTiers.ROSE_GOLD, (int) (4), (float) (-2),new Item.Properties()));
    public static final RegistryObject<AxeItem>ROSE_GOLD_AXE=ITEMS.register("rose_gold_axe",
            ()->new AxeItem(ModToolTiers.ROSE_GOLD, (float) (8), (float) (-3),new Item.Properties()));
    public static final RegistryObject<ShovelItem>ROSE_GOLD_SHOVEL=ITEMS.register("rose_gold_shovel",
            ()->new ShovelItem(ModToolTiers.ROSE_GOLD, (float) (2), (float) (-2),new Item.Properties()));
    public static final RegistryObject<HoeItem>ROSE_GOLD_HOE=ITEMS.register("rose_gold_hoe",
            ()->new HoeItem(ModToolTiers.ROSE_GOLD, (int) (0), (float) (-2),new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_DAGGER = ITEMS.register("orichalcum_dagger", () ->
            new net.minecraft.world.item.SwordItem(ModToolTiers.ORICHALCUM, 0, 0, net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(ItemPropertiesHelper.equipment(), net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.ORICHALCUM_DAGGER))));
    public static final RegistryObject<Item> ORICHALCUM_GREATSWORD = ITEMS.register("orichalcum_greatsword", () ->
            new net.minecraft.world.item.SwordItem(ModToolTiers.ORICHALCUM, 0, 0, net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(ItemPropertiesHelper.equipment(), net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.ORICHALCUM_GREATSWORD))));
    public static final RegistryObject<Item> ORICHALCUM_GREATAXE = ITEMS.register("orichalcum_greataxe", () ->
            new ExtendedAxeItem(ModToolTiers.ORICHALCUM, net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(ItemPropertiesHelper.equipment(), net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.ORICHALCUM_GREATAXE))));
    public static final RegistryObject<Item> ORICHALCUM_WARHAMMER = ITEMS.register("orichalcum_warhammer", () ->
            new ExtendedAxeItem(ModToolTiers.ORICHALCUM, net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(ItemPropertiesHelper.equipment(), net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.ORICHALCUM_WARHAMMER))));
    public static final RegistryObject<AxeItem>ORICHALCUM_AXE=ITEMS.register("orichalcum_axe", ()->
            new AxeItem(ModToolTiers.ORICHALCUM, 0, 0, net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(ItemPropertiesHelper.equipment(), net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.ORICHALCUM_AXE))));
    public static final RegistryObject<Item> DWARVEN_GREATAXE = ITEMS.register("dwarven_greataxe", () ->
            new ExtendedAxeItem(ModToolTiers.DWARVEN_ALLOY, net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(ItemPropertiesHelper.equipment().rarity(ModRarities.DWARVEN_RARITY_PROXY.getValue()), net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.DWARVEN_GREATAXE))));
    public static final RegistryObject<Item> DWARVEN_WARHAMMER = ITEMS.register("dwarven_warhammer", () ->
            new ExtendedAxeItem(ModToolTiers.DWARVEN_ALLOY, net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(ItemPropertiesHelper.equipment().rarity(ModRarities.DWARVEN_RARITY_PROXY.getValue()), net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.DWARVEN_WARHAMMER))));
    public static final RegistryObject<AxeItem>DWARVEN_AXE=ITEMS.register("dwarven_axe", ()->
            new AxeItem(ModToolTiers.DWARVEN_ALLOY, 0, 0, net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(ItemPropertiesHelper.equipment().rarity(ModRarities.DWARVEN_RARITY_PROXY.getValue()), net.redreaper.monsterspellbooks.compat120.WeaponAttrs.createAttributes(ModExtendedWeaponTiers.DWARVEN_AXE))));

    public static final RegistryObject<SwordItem>SANGUINITE_DAGGER=ITEMS.register("sanguinite_dagger",
            SanguniteDaggerItem::new);
    public static final RegistryObject<SwordItem>SANGUINITE_SCYTHE=ITEMS.register("sanguinite_scythe",
            SanguniteScytheItem::new);
    public static final RegistryObject<AxeItem>SANGUINITE_AXE=ITEMS.register("sanguinite_axe",
            SanguniteGreatAxeItem::new);

    public static final RegistryObject<Item>DEATHSILVER_DAGGER = ITEMS.register("deathsilver_dagger",
            DeathsilverDaggerItem::new);
    public static final RegistryObject<Item>DEATHSILVER_SWORD = ITEMS.register("deathsilver_sword",
            DeathsilverSwordItem::new);
    public static final RegistryObject<Item>DEATHSILVER_AXE = ITEMS.register("deathsilver_axe",
            DeathsilverAxeItem::new);
    public static final RegistryObject<Item>DEATHSILVER_GREATAXE = ITEMS.register("deathsilver_greataxe",
            DeathsilverGreataxeItem::new);

    public static final RegistryObject<Item>VILLAGE_BUTCHERER = ITEMS.register("village_butcherer",
            VillagerButchererItem::new);
    public static final RegistryObject<Item>POISON_BITER = ITEMS.register("poison_biter",
            PoisonBiterItem::new);
    public static final RegistryObject<Item>POISON_GLAIVE = ITEMS.register("poison_glaive",
            PoisonGlaive::new);
    public static final RegistryObject<Item>FROST_FANG = ITEMS.register("frost_fang",
            FrostFangItem::new);
    public static final RegistryObject<Item> NECROMANCER_TRIDENT = ITEMS.register("necromancer_trident",
            NecromancerTridentItem::new);
    public static final RegistryObject<Item>CRESCENT_BLOOD_ROSE = ITEMS.register("crescent_blood_rose",
            CrescentBloodRoseItem::new);
    public static final RegistryObject<Item>CLAWS_OF_CALAMITY = ITEMS.register("claws_of_calamity",
            ClawsOfCalamityItem::new);
    public static final RegistryObject<Item>DUCHEES_SEWING_NEEDLE = ITEMS.register("duchees_sewing_needle",
            DuchessSewingNeedle::new);
    public static final RegistryObject<Item>DUKES_HEARTSTEALER = ITEMS.register("dukes_heartstealer",
            DukesHeartstealer::new);
    public static final RegistryObject<Item> FROSTMOURNE = ITEMS.register("frostmourne",
            Frostmourne::new);
    public static final RegistryObject<Item> MAGMATIC_MACUAHUITL = ITEMS.register("magmatic_macuahuitl",
            MagmaticMacuahuitlItem::new);
    public static final RegistryObject<Item> GORE_CHILD = ITEMS.register("gore_child",
            GoreChildItem::new);
    public static final RegistryObject<Item>STARLESS_NIGHT = ITEMS.register("starless_night",
            StarlessNight::new);
    public static final RegistryObject<Item>SWIFT_STRIKER = ITEMS.register("swift_striker",
            SwiftStriker::new);
    public static final RegistryObject<Item>VOID_TOUCHED_BLADE = ITEMS.register("void_touched_blade",
            VoidTouchedBladeItem::new);
    public static final RegistryObject<Item>STARSCOURGE_SWORD = ITEMS.register("starscourge_sword",
            StarscourgeSword::new);
    public static final RegistryObject<Item>DISRUPTION_NAGINATA = ITEMS.register("disruption_naginata",
            DisruptionNaginataItem::new);
    public static final RegistryObject<Item>SWORD_OF_COURAGE = ITEMS.register("sword_of_courage",
            SwordOfCourage::new);
    public static final RegistryObject<Item>PALLADIN_HAMMER = ITEMS.register("paladin_hammer",
            PaladinHammerItem::new);
    public static final RegistryObject<Item>REAPER_SICKLE = ITEMS.register("reaper_sickle",
            ReaperSickle::new);
    public static final RegistryObject<Item>ENDERSENT_CRUSHER = ITEMS.register("endersent_crusher",
            EndersentCrusherItem::new);

    // 1.20.1 port: there is no vanilla mace before 1.21, so the recipes that used minecraft:mace use this item instead
    public static final RegistryObject<Item> HEAVY_MACE = ITEMS.register("heavy_mace",
            () -> new net.redreaper.monsterspellbooks.compat120.ace.ModMaceItem(net.redreaper.monsterspellbooks.compat120.ItemAttrs.with(
                    new Item.Properties().durability(500).rarity(net.minecraft.world.item.Rarity.EPIC),
                    net.redreaper.monsterspellbooks.compat120.ItemAttributeModifiers.builder()
                            .add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE, new net.minecraft.world.entity.ai.attributes.AttributeModifier(net.redreaper.monsterspellbooks.compat120.WeaponAttrs.BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 5.0, net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADDITION), net.redreaper.monsterspellbooks.compat120.EquipmentSlotGroup.MAINHAND)
                            .add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED, new net.minecraft.world.entity.ai.attributes.AttributeModifier(net.redreaper.monsterspellbooks.compat120.WeaponAttrs.BASE_ATTACK_SPEED_UUID, "Weapon modifier", -3.4, net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADDITION), net.redreaper.monsterspellbooks.compat120.EquipmentSlotGroup.MAINHAND)
                            .build())));

    public static final RegistryObject<Item>SNOW_BOW = ITEMS.register("snow_bow",
            SnowBowItem::new);
    public static final RegistryObject<Item> RED_SNAKE_BOW = ITEMS.register("red_snake_bow",
            RedSnakeBowItem::new);

    public static final RegistryObject<Item>ENCHANTING_TOME = ITEMS.register("enchanter_spell_book",
            EnchantingTomeItem::new);
    public static final RegistryObject<Item>GUARDIAN_SPELLBOOK = ITEMS.register("guardian_spell_book",
            GuardianSpellBookItem::new);
    public static final RegistryObject<Item>UPDRAFT_TOME = ITEMS.register("updraft_tome",
            UpdraftTomeItem::new);
    public static final RegistryObject<Item>BOOK_OF_SOULS = ITEMS.register("book_of_souls",
            BookOfSoulsItem::new);
    public static final RegistryObject<Item>FRENZY_KING_BOOK = ITEMS.register("frenzy_king_book",
            FrenzyKingBookItem::new);
    public static final RegistryObject<Item>DISEASE_ENCYCLOPEDIA = ITEMS.register("disease_encyclopedia",
            DiseaseEncyclopediaItem::new);
    public static final RegistryObject<Item>REAPER_LANTERN = ITEMS.register("reaper_lantern",
            ReaperLanternSpellBook::new);

    public static final Supplier<CurioBaseItem>WITHERWARD_RING = ITEMS.register("witherward_ring",
            WitherWardCurio::new);
    public static final Supplier<CurioBaseItem> COLD_CONJURER_TALISMAN = ITEMS.register("cold_conjurers_talisman",
            ColdConjurerTalisman::new);
    public static final Supplier<CurioBaseItem>WITHERED_TOTEM = ITEMS.register("withered_totem",
            WitheredTotemItem::new);
    public static final Supplier<CurioBaseItem>IGNITION_GLOVE = ITEMS.register("ignition_gloves",
            IgnitionGloveItem::new);
    public static final Supplier<CurioBaseItem>CRITICAL_GLASSES = ITEMS.register("critical_glasses",
            CriticalSorcererGlassesItem::new);
    public static final Supplier<CurioBaseItem>THUNDERING_QUIVER = ITEMS.register("thundering_quiver",
            ThunderingQuiverItem::new);
    public static final Supplier<CurioBaseItem>BRIMSTONE_SIGIL = ITEMS.register("brimstone_sigil",
            BrimstoneSigilItem::new);
    public static final Supplier<CurioBaseItem>DREADHOUND_TOOTH_NECKLACE = ITEMS.register("dreadhound_tooth_necklace",
            DreadHoundToothNecklaceItem::new);
    public static final Supplier<CurioBaseItem>DWARVEN_POWER_CORE = ITEMS.register("dwarven_power_core",
            DwarvenPowerCoreItem::new);
    public static final Supplier<CurioBaseItem>OBSIDIAN_MEDAL = ITEMS.register("obsidian_medal",
            ObsidianMedalItem::new);
    public static final Supplier<CurioBaseItem>ORB_SOUL = ITEMS.register("orb_soul",
            OrbOFSoulsItem::new);
    public static final Supplier<CurioBaseItem>BLIZZARD_CALLER = ITEMS.register("blizzard_caller",
            BlizzardCallerItem::new);
    public static final Supplier<CurioBaseItem>CROSS_NECKLACE = ITEMS.register("cross_necklace",
            CrossNecklaceItem::new);

    public static final RegistryObject<Item> FIERCE_DEITY_MASK = ITEMS.register("fierce_deity_mask", () ->
            new FierceDeityMaskItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(Rarity.UNCOMMON).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 30))));
    public static final RegistryObject<Item> MAJORAS_MASK = ITEMS.register("majoras_mask", () ->
            new MajorasMaskArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(Rarity.UNCOMMON).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 30))));
    public static final RegistryObject<Item> WILDFIRE_CROWN = ITEMS.register("wildfire_crown", () ->
            new WildFireCrownItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().rarity(ASRarities.ARID_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 30))));
    public static final RegistryObject<Item> FUNGAL_CAP_RED = ITEMS.register("fun_gal_cap_red", () ->
            new FunGalCapItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ASRarities.VERDANT_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 30))));
    public static final RegistryObject<Item> FUNGAL_CAP_BLUE = ITEMS.register("fun_gal_cap_blue", () ->
            new FunGalCapBlueItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ASRarities.VERDANT_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 30))));
    public static final RegistryObject<Item> FLESH_MAIDEN = ITEMS.register("flesh_maiden", () ->
            new FleshMaidenArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ASRarities.ACCURSED_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 30))));

    public static final RegistryObject<Item> NECROMANCER_HELMET = ITEMS.register("necromancer_helmet", () ->
            new NecromancerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ModRarities.SOUL_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 37))));
    public static final RegistryObject<Item>NECROMANCER_CHESTPLATE = ITEMS.register("necromancer_chestplate", () ->
            new NecromancerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ModRarities.SOUL_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 37))));
    public static final RegistryObject<Item> NECROMANCER_LEGGINGS = ITEMS.register("necromancer_leggings", () ->
            new NecromancerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.SOUL_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 37))));
    public static final RegistryObject<Item> NECROMANCER_BOOTS = ITEMS.register("necromancer_boots", () ->
            new NecromancerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.SOUL_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 37))));

    public static final RegistryObject<Item> ILLAGER_ENCHANTER_HELMET = ITEMS.register("illager_enchanter_helmet", () ->
            new IllagerEnchanterArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 48))));
    public static final RegistryObject<Item> ILLAGER_ENCHANTER_CHESTPLATE = ITEMS.register("illager_enchanter_chestplate", () ->
            new IllagerEnchanterArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 48))));
    public static final RegistryObject<Item> ILLAGER_ENCHANTER_LEGGINGS = ITEMS.register("illager_enchanter_leggings", () ->
            new IllagerEnchanterArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 48))));
    public static final RegistryObject<Item> ILLAGER_ENCHANTER_BOOTS = ITEMS.register("illager_enchanter_boots", () ->
            new IllagerEnchanterArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 48))));

    public static final RegistryObject<Item> ILLAGER_EMBER_ROBE_HELMET = ITEMS.register("illager_ember_robe_helmet", () ->
            new IllagerEmberRobeArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 48))));
    public static final RegistryObject<Item> ILLAGER_EMBER_ROBE_CHESTPLATE = ITEMS.register("illager_ember_robe_chestplate", () ->
            new IllagerEmberRobeArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 48))));
    public static final RegistryObject<Item> ILLAGER_EMBER_ROBE_LEGGINGS = ITEMS.register("illager_ember_robe_leggings", () ->
            new IllagerEmberRobeArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 48))));
    public static final RegistryObject<Item> ILLAGER_EMBER_ROBE_BOOTS = ITEMS.register("illager_ember_robe_boots", () ->
            new IllagerEmberRobeArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 48))));

    public static final RegistryObject<Item> ILLAGER_ICEOLOGER_HELMET = ITEMS.register("illager_iceologer_helmet", () ->
            new IllagerIceologerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 48))));
    public static final RegistryObject<Item> ILLAGER_ICEOLOGER_CHESTPLATE = ITEMS.register("illager_iceologer_chestplate", () ->
            new IllagerIceologerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 48))));
    public static final RegistryObject<Item> ILLAGER_ICEOLOGER_LEGGINGS = ITEMS.register("illager_iceologer_leggings", () ->
            new IllagerIceologerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 48))));
    public static final RegistryObject<Item> ILLAGER_ICEOLOGER_BOOTS = ITEMS.register("illager_iceologer_boots", () ->
            new IllagerIceologerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.ILLAGER_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 48))));

    public static final RegistryObject<Item> SANGUINITE_HERO_HOOD = ITEMS.register("sanguinite_hero_hood", () ->
            new SanguiniteHeroArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ModRarities.SANGUINITE_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 48))));
    public static final RegistryObject<Item> SANGUINITE_HERO_CHESTPLATE = ITEMS.register("sanguinite_hero_chestplate", () ->
            new SanguiniteHeroArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ModRarities.SANGUINITE_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 48))));
    public static final RegistryObject<Item> SANGUINITE_HERO_LEGGINGS = ITEMS.register("sanguinite_hero_leggings", () ->
            new SanguiniteHeroArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.SANGUINITE_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 48))));
    public static final RegistryObject<Item> SANGUINITE_HERO_BOOTS = ITEMS.register("sanguinite_hero_boots", () ->
            new SanguiniteHeroArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.SANGUINITE_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 48))));

    public static final RegistryObject<Item> DWARVEN_ENGINEER_VISOR = ITEMS.register("dwarven_engineer_visor", () ->
            new DwarvenEngineerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ModRarities.DWARVEN_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 48))));
    public static final RegistryObject<Item> DWARVEN_ENGINEER_CHESTPLATE = ITEMS.register("dwarven_engineer_chestplate", () ->
            new DwarvenEngineerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ModRarities.DWARVEN_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 48))));
    public static final RegistryObject<Item> DWARVEN_ENGINEER_LEGGINGS = ITEMS.register("dwarven_engineer_leggings", () ->
            new DwarvenEngineerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.DWARVEN_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 48))));
    public static final RegistryObject<Item> DWARVEN_ENGINEER_BOOTS = ITEMS.register("dwarven_engineer_boots", () ->
            new DwarvenEngineerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.DWARVEN_RARITY_PROXY.getValue()).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 48))));

    public static final RegistryObject<Item> HEROBRINE_CULTIST_HELMET = ITEMS.register("herobrine_cultist_helmet", () ->
            new HerobrineCultistArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ASRarities.FORBIDDEN_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 48))));
    public static final RegistryObject<Item> HEROBRINE_CULTIST_CHESTPLATE = ITEMS.register("herobrine_cultist_chestplate", () ->
            new HerobrineCultistArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ASRarities.FORBIDDEN_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 48))));
    public static final RegistryObject<Item> HEROBRINE_CULTIST_LEGGINGS = ITEMS.register("herobrine_cultist_leggings", () ->
            new HerobrineCultistArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ASRarities.FORBIDDEN_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 48))));
    public static final RegistryObject<Item> HEROBRINE_CULTIST_BOOTS = ITEMS.register("herobrine_cultist_boots", () ->
            new HerobrineCultistArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ASRarities.FORBIDDEN_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 48))));


    public static final RegistryObject<Item> DRAUGR_ELITE_HELMET = ITEMS.register("draugr_elite_helmet", () ->
            new DraugrEliteArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ASRarities.GLACIAL_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 45))));
    public static final RegistryObject<Item>DRAUGR_ELITE_CHESTPLATE = ITEMS.register("draugr_elite_chestplate", () ->
            new DraugrEliteArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ASRarities.GLACIAL_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 45))));
       public static final RegistryObject<Item> DRAUGR_ELITE_BOOTS = ITEMS.register("draugr_elite_boots", () ->
            new DraugrEliteArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ASRarities.GLACIAL_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 45))));

    public static final RegistryObject<Item> DEATH_KNIGHT_HELMET = ITEMS.register("death_knight_helmet", () ->
            new DeathKnightArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ASRarities.GLACIAL_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 37))));
    public static final RegistryObject<Item>DEATH_KNIGHT_CHESTPLATE = ITEMS.register("death_knight_chestplate", () ->
            new DeathKnightArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ASRarities.GLACIAL_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 37))));
    public static final RegistryObject<Item> DEATH_KNIGHT_LEGGINGS = ITEMS.register("death_knight_leggings", () ->
            new DeathKnightArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ASRarities.GLACIAL_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 37))));
    public static final RegistryObject<Item> DEATH_KNIGHT_BOOTS = ITEMS.register("death_knight_boots", () ->
            new DeathKnightArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ASRarities.GLACIAL_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 37))));

    public static final RegistryObject<Item> FORGE_MASTERPIECE_HELMET = ITEMS.register("forge_masterpiece_helmet", () ->
            new ForgeMasterpieceArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ModRarities.BRIMSTONE_RARITY_PROXY.getValue()).fireResistant().durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 48))));
    public static final RegistryObject<Item> FORGE_MASTERPIECE_CHESTPLATE = ITEMS.register("forge_masterpiece_chestplate", () ->
            new ForgeMasterpieceArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ModRarities.BRIMSTONE_RARITY_PROXY.getValue()).fireResistant().durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 48))));
    public static final RegistryObject<Item> FORGE_MASTERPIECE_LEGGINGS = ITEMS.register("forge_masterpiece_leggings", () ->
            new ForgeMasterpieceArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.BRIMSTONE_RARITY_PROXY.getValue()).fireResistant().durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 48))));
    public static final RegistryObject<Item> FORGE_MASTERPIECE_BOOTS = ITEMS.register("forge_masterpiece_boots", () ->
            new ForgeMasterpieceArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ModRarities.BRIMSTONE_RARITY_PROXY.getValue()).fireResistant().durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 48))));

    public static final RegistryObject<Item> STARSCOURGE_HELMET = ITEMS.register("starscourge_helmet", () ->
            new StarscourgeArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ASRarities.COSMIC_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 48))));
    public static final RegistryObject<Item> STARSCOURGE_CHESTPLATE = ITEMS.register("starscourge_chestplate", () ->
            new StarscourgeArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ASRarities.COSMIC_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 48))));
    public static final RegistryObject<Item> STARSCOURGE_LEGGINGS = ITEMS.register("starscourge_leggings", () ->
            new StarscourgeArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ASRarities.COSMIC_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 48))));
    public static final RegistryObject<Item> STARSCOURGE_BOOTS = ITEMS.register("starscourge_boots", () ->
            new StarscourgeArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ASRarities.COSMIC_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 48))));

    public static final RegistryObject<Item> UNSTABLE_ROBES_HELMET = ITEMS.register("unstable_robes_helmet", () ->
            new UnstableRobeArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).rarity(ASRarities.COSMIC_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.HELMET, 48))));
    public static final RegistryObject<Item> UNSTABLE_ROBES_CHESTPLATE = ITEMS.register("unstable_robes_chestplate", () ->
            new UnstableRobeArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).rarity(ASRarities.COSMIC_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.CHESTPLATE, 48))));
    public static final RegistryObject<Item> UNSTABLE_ROBES_LEGGINGS = ITEMS.register("unstable_robes_leggings", () ->
            new UnstableRobeArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).rarity(ASRarities.COSMIC_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.LEGGINGS, 48))));
    public static final RegistryObject<Item> UNSTABLE_ROBES_BOOTS = ITEMS.register("unstable_robes_boots", () ->
            new UnstableRobeArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).rarity(ASRarities.COSMIC_RARITY).durability(net.redreaper.monsterspellbooks.compat120.Dur.armor(ArmorItem.Type.BOOTS, 48))));

    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> AEGIS_SPAWN_EGG = ITEMS.register("aegis_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.AEGIS, 5526633, 9864548, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> DRIPPLER_SPAWN_EGG = ITEMS.register("drippler_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.DRIPPLER, 5641255, 9386054, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> DWARVEN_SPHERE_SPAWN_EGG = ITEMS.register("dwarven_sphere_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.DWARVEN_SPHERE, 10050109, 16501864, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> DWARVEN_SLICER_SPAWN_EGG = ITEMS.register("dwarven_slicer_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.DWARVEN_SLICER, 10050109, 16501864, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> JUNGLE_WHISPERER_SPAWN_EGG = ITEMS.register("jungle_whisperer_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.JUNGLE_WHISPERER, 6323765, 8601546, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> JUNGLE_LEAPLEAF_SPAWN_EGG = ITEMS.register("jungle_leapleaf_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.JUNGLE_LEAPLEAF, 6323765, 8601546, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> ILLAGER_ENCHANTER_SPAWN_EGG = ITEMS.register("illager_enchanter_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.ILLAGER_ENCHANTER, 9804699, 9053763, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> ILLAGER_ICEOLOGER_SPAWN_EGG = ITEMS.register("illager_iceologer_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.ILLAGER_ICEOLOGER, 9804699, 927571, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> ILLAGER_FIREOLOGER_SPAWN_EGG = ITEMS.register("illager_fireologer_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.ILLAGER_FIREOLOGER, 9804699, 8257536, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> HEROBRINE_CULTIST_MAGE_SPAWN_EGG = ITEMS.register("herobrine_cultist_mage_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.HEROBRINE_CULTIST_MAGE, 8653859, 16108583, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> HEROBRINE_CULTIST_ASSASSIN_SPAWN_EGG = ITEMS.register("herobrine_cultist_assassin_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.HEROBRINE_CULTIST_ASSASSIN, 8653859, 16108583, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> SPRIGGAN_SPAWN_EGG = ITEMS.register("spriggan_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.SPRIGGAN, 3746340, 11992832, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> DRAUGR_EVOKER_SPAWN_EGG = ITEMS.register("draugr_evoker_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.DRAUGR_EVOKER, 5932676, 1449245, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> DRAUGR_VINDICATOR_SPAWN_EGG = ITEMS.register("draugr_vindicator_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.DRAUGR_VINDICATOR, 5932676, 1449245, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> DRAUGR_ELITE_VINDICATOR_SPAWN_EGG = ITEMS.register("draugr_elite_vindicator_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.DRAUGR_ELITE_VINDICATOR, 5932676, 1449245, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> DRAUGR_PILLAGER_SPAWN_EGG = ITEMS.register("draugr_pillager_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.DRAUGR_PILLAGER, 5932676, 1449245, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> REDSTONE_ELEMENTAL_SPAWN_EGG = ITEMS.register("redstone_elemental_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.REDSTONE_ELEMENTAL, 6579049, 15081480, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> SOUL_WRAITH_SPAWN_EGG = ITEMS.register("soul_wraith_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.SOUL_WRAITH, 1315660, 316109, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> WITHER_WARLOCK_SPAWN_EGG = ITEMS.register("wither_warlock_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.WITHER_WARLOCK, 2039583, 316109, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> WITHER_WARRIOR_SPAWN_EGG = ITEMS.register("wither_warrior_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.WITHER_WARRIOR, 2039583, 316109, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> PRISMARINE_KEEPER_SPAWN_EGG = ITEMS.register("prismarine_keeper_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.PRISMARINE_KEEPER, 4887415, 1387045, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> VILE_SKELETON_SPAWN_EGG = ITEMS.register("vile_skeleton_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.VILE_SKELETON, 725001, 3622442, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> MAGMA_ATRONACH_SPAWN_EGG = ITEMS.register("magma_atronach_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.MAGMA_ATRONACH, 1380882, 16734238, ItemPropertiesHelper.material().stacksTo(64)));
    public static final Supplier<net.minecraftforge.common.ForgeSpawnEggItem> BLASTLING_SPAWN_EGG = ITEMS.register("blastling_spawn_egg", () -> new net.minecraftforge.common.ForgeSpawnEggItem(ModEntities.BLASTLING, 0, 15077593, ItemPropertiesHelper.material().stacksTo(64)));

    public static final RegistryObject<Item> NECRO_UPGRADE_ORB = ITEMS.register("necro_upgrade_orb", () ->
            new UpgradeOrbItem(ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON), ModUpgradeTypeRegistry.NECRO_SPELL_POWER));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
