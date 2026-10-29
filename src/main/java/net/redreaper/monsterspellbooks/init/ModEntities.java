package net.redreaper.monsterspellbooks.init;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.entity.spells.fireball.MagicFireball;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.entity.living.*;
import net.redreaper.monsterspellbooks.entity.living.draugr.DraugrEliteVindicatorEntity;
import net.redreaper.monsterspellbooks.entity.living.draugr.DraugrEvokerEntity;
import net.redreaper.monsterspellbooks.entity.living.draugr.DraugrPillagerEntity;
import net.redreaper.monsterspellbooks.entity.living.draugr.DraugrVindicatorEntity;
import net.redreaper.monsterspellbooks.entity.living.herobrine_cult.HerobrineCultistAssassinEntity;
import net.redreaper.monsterspellbooks.entity.living.herobrine_cult.HerobrineCultistMageEntity;
import net.redreaper.monsterspellbooks.entity.living.illagers.IllagerEnchanterEntity;
import net.redreaper.monsterspellbooks.entity.living.illagers.IllagerFireologerEntity;
import net.redreaper.monsterspellbooks.entity.living.illagers.IllagerIceologerEntity;
import net.redreaper.monsterspellbooks.entity.living.summons.*;
import net.redreaper.monsterspellbooks.entity.spells.ancient_flash.AncientFlash;
import net.redreaper.monsterspellbooks.entity.spells.ancient_lightning_lance.StaticField;
import net.redreaper.monsterspellbooks.entity.spells.blast_fungus.BlastFungusProjectile;
import net.redreaper.monsterspellbooks.entity.spells.blizzard_aspect.PowderSnowSplash;
import net.redreaper.monsterspellbooks.entity.spells.blizzard_aspect.SnowCloud;
import net.redreaper.monsterspellbooks.entity.spells.blood_pierce_bullet.BloodPierceVisualEntity;
import net.redreaper.monsterspellbooks.entity.spells.blood_thorn.BloodThornProjectile;
import net.redreaper.monsterspellbooks.entity.spells.bone_dagger.BoneDaggerProjectile;
import net.redreaper.monsterspellbooks.entity.spells.brimstone_buzzsaw.BrimstoneBuzzsawProjectile;
import net.redreaper.monsterspellbooks.entity.spells.brimstone_rain.BrimstoneField;
import net.redreaper.monsterspellbooks.entity.spells.brimstone_rain.SmallBrimstoneFireball;
import net.redreaper.monsterspellbooks.entity.spells.bubble_spray.BubbleSprayProjectile;
import net.redreaper.monsterspellbooks.entity.spells.cauterizing_touch.CauterizingTouch;
import net.redreaper.monsterspellbooks.entity.spells.divine_intervention.DivineSwordProjectile;
import net.redreaper.monsterspellbooks.entity.spells.dragon_charge.DragonChargeProjectile;
import net.redreaper.monsterspellbooks.entity.spells.effervescence_bubble.EffervescenceBubbleProjectile;
import net.redreaper.monsterspellbooks.entity.spells.rajins_judment.ElthorBeamEntity;
import net.redreaper.monsterspellbooks.entity.spells.forceful_wind.ForcefulWindProjectile;
import net.redreaper.monsterspellbooks.entity.spells.frenzied_burst.FrenziedBurstVisualEntity;
import net.redreaper.monsterspellbooks.entity.spells.frenzied_storm.SmallFrenzyFireBall;
import net.redreaper.monsterspellbooks.entity.spells.frost_breath.FrostBreathEntity;
import net.redreaper.monsterspellbooks.entity.spells.frosted_snowbolt.FrostedSnowboltProjectile;
import net.redreaper.monsterspellbooks.entity.spells.graveyard_fissure.GraveyardHand;
import net.redreaper.monsterspellbooks.entity.spells.guardians_neutralizer.GuardiansNeutralizerVisualEntity;
import net.redreaper.monsterspellbooks.entity.spells.hallow_slash.HallowSlashProjectile;
import net.redreaper.monsterspellbooks.entity.spells.ice_arsenal.IceArsenalSword;
import net.redreaper.monsterspellbooks.entity.spells.infection_slash.InfectionSlashProjectile;
import net.redreaper.monsterspellbooks.entity.spells.ink_bomb.InkBombProjectile;
import net.redreaper.monsterspellbooks.entity.spells.leaf_crystal.LeafCrystalEntity;
import net.redreaper.monsterspellbooks.entity.spells.life_drain.LifeDrainProjectile;
import net.redreaper.monsterspellbooks.entity.spells.napalm_orb.NapalmOrb;
import net.redreaper.monsterspellbooks.entity.spells.obsidian_arsenal.ObsidianArrowProjectile;
import net.redreaper.monsterspellbooks.entity.spells.obsidian_arsenal.ObsidianArrowVolleyEntity;
import net.redreaper.monsterspellbooks.entity.spells.obsidian_arsenal.SmallObsidianArrowProjectile;
import net.redreaper.monsterspellbooks.entity.spells.paladin_throw.HolyHammerProjectile;
import net.redreaper.monsterspellbooks.entity.spells.pale_thorn.PaleThornVisualEntity;
import net.redreaper.monsterspellbooks.entity.spells.poison_quill.PoisonQuillProjectile;
import net.redreaper.monsterspellbooks.entity.spells.predatory_scream.PredatoryScreamProjectile;
import net.redreaper.monsterspellbooks.entity.spells.putrescence_mass.PutrescenceField;
import net.redreaper.monsterspellbooks.entity.spells.putrescence_mass.PutrescenceMass;
import net.redreaper.monsterspellbooks.entity.spells.raigo.RaigoProjectile;
import net.redreaper.monsterspellbooks.entity.spells.rancorcall.RancorSkull;
import net.redreaper.monsterspellbooks.entity.spells.razorblade_typhoon.RazorbladeTyphoonProjectile;
import net.redreaper.monsterspellbooks.entity.spells.redstone_lasers.RedstoneBolt;
import net.redreaper.monsterspellbooks.entity.spells.redstone_mines.RedstoneMinesProjectile;
import net.redreaper.monsterspellbooks.entity.spells.sangunite_eviceration.SanguiniteEvisceration;
import net.redreaper.monsterspellbooks.entity.spells.soul_casting_field.SoulCastingFieldAOE;
import net.redreaper.monsterspellbooks.entity.spells.soul_chain.SoulChain;
import net.redreaper.monsterspellbooks.entity.spells.soul_firebolt.SoulFireBoltProjectile;
import net.redreaper.monsterspellbooks.entity.spells.soul_scorch.SoulFireField;
import net.redreaper.monsterspellbooks.entity.spells.space_breaker.SpaceBreaker;
import net.redreaper.monsterspellbooks.entity.spells.space_rupture.DistortionField;
import net.redreaper.monsterspellbooks.entity.spells.space_rupture.SpaceRupture;
import net.redreaper.monsterspellbooks.entity.spells.spectral_blast.SpectralBlastVisualEntity;
import net.redreaper.monsterspellbooks.entity.spells.spider_fangs.CaveSpiderFangProjectile;
import net.redreaper.monsterspellbooks.entity.spells.spider_fangs.ChaurusMandiblesProjectile;
import net.redreaper.monsterspellbooks.entity.spells.spider_fangs.IceSpiderFangProjectile;
import net.redreaper.monsterspellbooks.entity.spells.spinblade.DwarvenSpinbladeProjectile;
import net.redreaper.monsterspellbooks.entity.spells.static_cleave.StaticCleave;
import net.redreaper.monsterspellbooks.entity.spells.steam_stream.SteamStreamProjectile;
import net.redreaper.monsterspellbooks.entity.spells.stray_grasp.StrayGraspProjectile;
import net.redreaper.monsterspellbooks.entity.spells.thunderstorm_wave.AncientLightningStrike;
import net.redreaper.monsterspellbooks.entity.spells.vile_slash.VileSlashProjectileNew;
import net.redreaper.monsterspellbooks.entity.spells.vitaL_blast.VitalBlastVisualEntity;
import net.redreaper.monsterspellbooks.entity.spells.void_arrows.VoidArrowProjectile;
import net.redreaper.monsterspellbooks.entity.spells.voltaic_multishot.VoltArrowProjectile;
import net.redreaper.monsterspellbooks.entity.spells.water_trident.WaterTridentProjectile;
import net.redreaper.monsterspellbooks.entity.spells.wind_charge.ExtendedWindCharge;
import net.redreaper.monsterspellbooks.entity.spells.wither_bomb.WitherBombProjectile;
import net.redreaper.monsterspellbooks.entity.spells.wither_nova.WitherNovaVisualEntity;
import net.redreaper.monsterspellbooks.entity.spells.torment_arrow.TormentArrowProjectile;

import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.ENTITY_TYPE;

public class ModEntities {
    private static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ENTITY_TYPE, MonstersSpellbooks.MOD_ID);

    public static final RegistryObject<EntityType<DivineSwordProjectile>> DIVINE_SWORD =
            ENTITIES.register("divine_sword", () -> EntityType.Builder.<DivineSwordProjectile>of(DivineSwordProjectile::new, MobCategory.MISC)
                    .sized(1f, 1.5f)
                    .clientTrackingRange(4)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "divine_sword").toString()));

    public static final RegistryObject<EntityType<IceArsenalSword>> ICE_SWORD =
            ENTITIES.register("ice_sword", () -> EntityType.Builder.<IceArsenalSword>of(IceArsenalSword::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(4)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "ice_sword").toString()));

    public static final RegistryObject<EntityType<WrathEntity>> WRATH =
            ENTITIES.register("wrath", () -> EntityType.Builder.<WrathEntity>of(WrathEntity::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "wrath").toString()));

    public static final RegistryObject<EntityType<RancorPhantomEntity>> RANCOR_PHANTOM =
            ENTITIES.register("rancor_phantom", () -> EntityType.Builder.<RancorPhantomEntity>of(RancorPhantomEntity::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "rancor_phantom").toString()));

    public static final RegistryObject<EntityType<SoulCastingFieldAOE>>SOUL_CASTING_FIELD =
            ENTITIES.register("soul_casting_field", () -> EntityType.Builder.<SoulCastingFieldAOE>of(SoulCastingFieldAOE::new, MobCategory.MISC)
                    .sized(7f, 1.2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "soul_casting_field").toString()));

    public static final RegistryObject<EntityType<RedstoneMinesProjectile>> REDSTONE_MINES =
            ENTITIES.register("redstone_mines", () -> EntityType.Builder.<RedstoneMinesProjectile>of(RedstoneMinesProjectile::new, MobCategory.MISC)
                    .sized(1.5f, 1.5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "redstone_mines").toString()));

    public static final RegistryObject<EntityType<LeafCrystalEntity>> LEAF_CRYSTAL =
            ENTITIES.register("leaf_crystal", () -> EntityType.Builder.<LeafCrystalEntity>of(LeafCrystalEntity::new, MobCategory.MISC)
                    .sized(1, 1)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "leaf_crystal").toString()));


    public static final RegistryObject<EntityType<SmallObsidianArrowProjectile>> SMALL_OBSIDIAN_ARROW_PROJECTILE =
            ENTITIES.register("small_obsidian_arrow", () -> EntityType.Builder.<SmallObsidianArrowProjectile>of(SmallObsidianArrowProjectile::new, MobCategory.MISC)
                    .sized(.8f, .8f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "small_obsidian_arrow").toString()));

    public static final RegistryObject<EntityType<VoidArrowProjectile>> VOID_ARROW_PROJECTILE =
            ENTITIES.register("void_arrow", () -> EntityType.Builder.<VoidArrowProjectile>of(VoidArrowProjectile::new, MobCategory.MISC)
                    .sized(.8f, .8f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "void_arrow").toString()));

    public static final RegistryObject<EntityType<ObsidianArrowProjectile>> OBSIDIAN_ARROW_PROJECTILE =
            ENTITIES.register("obsidian_arrow", () -> EntityType.Builder.<ObsidianArrowProjectile>of(ObsidianArrowProjectile::new, MobCategory.MISC)
                    .sized(.8f, .8f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "obsidian_arrow").toString()));

    public static final RegistryObject<EntityType<ObsidianArrowVolleyEntity>> OBSIDIAN_ARROW_VOLLEY_ENTITY =
            ENTITIES.register("obsidian_arrow_volley", () -> EntityType.Builder.<ObsidianArrowVolleyEntity>of(ObsidianArrowVolleyEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "obsidian_arrow_volley").toString()));

    public static final RegistryObject<EntityType<HerobrineCultistMageEntity>> HEROBRINE_CULTIST_MAGE =
            ENTITIES.register("herobrine_cultist_mage", () -> EntityType.Builder.of(HerobrineCultistMageEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "herobrine_cultist_mage").toString()));

    public static final RegistryObject<EntityType<HerobrineCultistAssassinEntity>> HEROBRINE_CULTIST_ASSASSIN =
            ENTITIES.register("herobrine_cultist_assassin", () -> EntityType.Builder.of(HerobrineCultistAssassinEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "herobrine_cultist_assassin").toString()));

    public static final RegistryObject<EntityType<TormentArrowProjectile>> TORMENT_ARROW_PROJECTILE =
            ENTITIES.register("torment_arrow", () -> EntityType.Builder.<TormentArrowProjectile>of(TormentArrowProjectile::new, MobCategory.MISC)
                    .sized(.8f, .8f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "torment_arrow").toString()));

    public static final RegistryObject<EntityType<DwarvenSpinbladeProjectile>> DWARVEN_SPINBLADE =
            ENTITIES.register("dwarven_spinblade", () -> EntityType.Builder.<DwarvenSpinbladeProjectile>of(DwarvenSpinbladeProjectile::new, MobCategory.MISC)
                    .sized(.8f, .8f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "dwarven_spinblade").toString()));

    public static final RegistryObject<EntityType<RedSnakeWitherSkeletonEntity>> REDSNAKE_WITHER_SKELETON =
            ENTITIES.register("redsnake_wither_skeleton", () -> EntityType.Builder.<RedSnakeWitherSkeletonEntity>of(RedSnakeWitherSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(1.5f, .95f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "redsnake_wither_skeleton").toString()));

    public static final RegistryObject<EntityType<PrismarineKeeper>> PRISMARINE_KEEPER =
            ENTITIES.register("prismarine_keeper", () -> EntityType.Builder.<PrismarineKeeper>of(PrismarineKeeper::new, MobCategory.MONSTER)
                    .sized(.85f, 2.3f)
                    .clientTrackingRange(64)
                    
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "prismarine_keeper").toString()));

    public static final RegistryObject<EntityType<SummonedPrismarineKeeper>> SUMMONED_PRISMARINE_KEEPER =
            ENTITIES.register("summoned_prismarine_keeper", () -> EntityType.Builder.<SummonedPrismarineKeeper>of(SummonedPrismarineKeeper::new, MobCategory.MONSTER)
                    .sized(.85f, 2.3f)
                    .clientTrackingRange(64)
                    
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "summoned_prismarine_keeper").toString()));

    public static final RegistryObject<EntityType<InkBombProjectile>> INK_BOMB =
            ENTITIES.register("ink_bomb", () -> EntityType.Builder.<InkBombProjectile>of(InkBombProjectile::new, MobCategory.MISC)
                    .sized(0.75F, 0.75F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "ink_bomb").toString()));


    public static final RegistryObject<EntityType<VoltArrowProjectile>> VOLT_ARROW_PROJECTILE =
            ENTITIES.register("volt_arrow", () -> EntityType.Builder.<VoltArrowProjectile>of(VoltArrowProjectile::new, MobCategory.MISC)
                    .sized(.8f, .8f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "volt_arrow").toString()));

    public static final RegistryObject<EntityType<ElthorBeamEntity>> ELTHOR_BEAM =
            ENTITIES.register("elthor_beam", () -> EntityType.Builder.<ElthorBeamEntity>of(ElthorBeamEntity::new, MobCategory.MISC)
                    .sized(2, 14f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "elthor_beam").toString()));

    public static final RegistryObject<EntityType<RedstoneBolt>> PLASMA_BOLT =
            ENTITIES.register("plasma_bolt", () -> EntityType.Builder.<RedstoneBolt>of(RedstoneBolt::new, MobCategory.MISC)
                    .sized(1, 1)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "plasma_bolt").toString()));

    public static final RegistryObject<EntityType<SoulFireBoltProjectile>> SOUL_FIREBOLT_PROJECTILE =
            ENTITIES.register("soul_firebolt", () -> EntityType.Builder.<SoulFireBoltProjectile>of(SoulFireBoltProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "soul_firebolt").toString()));

    public static final RegistryObject<EntityType<FrostedSnowboltProjectile>> FROSTED_SNOWBOLT =
            ENTITIES.register("frosted_snowbolt", () -> EntityType.Builder.<FrostedSnowboltProjectile>of(FrostedSnowboltProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "frosted_snowbolt").toString()));

    public static final RegistryObject<EntityType<GraveyardHand>> GRAVEYARD_HAND =
            ENTITIES.register("graveyard_hand", () -> EntityType.Builder.<GraveyardHand>of(GraveyardHand::new, MobCategory.MISC)
                    .sized(1f, 1.5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "graveyard_hand").toString()));

    public static final RegistryObject<EntityType<RaigoProjectile>> RAIGO =
            ENTITIES.register("raigo", () -> EntityType.Builder.<RaigoProjectile>of(RaigoProjectile::new, MobCategory.MISC)
                    .sized(4f, 4f)
                    .clientTrackingRange(4)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "raigo").toString()));

    public static final RegistryObject<EntityType<StrayGraspProjectile>> STRAY_GRASP =
            ENTITIES.register("stray_grasp", () -> EntityType.Builder.<StrayGraspProjectile>of(StrayGraspProjectile::new, MobCategory.MISC)
                    .sized(1, 1)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "stray_grasp").toString()));

    public static final RegistryObject<EntityType<WaterTridentProjectile>> WATER_TRIDENT =
            ENTITIES.register("water_trident", () -> EntityType.Builder.<WaterTridentProjectile>of(WaterTridentProjectile::new, MobCategory.MISC)
                    .sized(3, 1.5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "water_trident").toString()));

    public static final RegistryObject<EntityType<VileSlashProjectileNew>> VILE_SLASH =
            ENTITIES.register("vile_slash", () -> EntityType.Builder.<VileSlashProjectileNew>of(VileSlashProjectileNew::new, MobCategory.MISC)
                    .sized(2, 0.5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "vile_slash").toString()));

    public static final RegistryObject<EntityType<HolyHammerProjectile>> HOLY_HAMMER =
            ENTITIES.register("holy_hammer", () -> EntityType.Builder.<HolyHammerProjectile>of(HolyHammerProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "holy_hammer").toString()));

    public static final RegistryObject<EntityType<ExtendedWindCharge>> EXTENDED_WIND_CHARGE =
            ENTITIES.register("extended_wind_charge", () -> EntityType.Builder.<ExtendedWindCharge>of(ExtendedWindCharge::new, MobCategory.MISC)
                    .sized(0.3125F, 0.3125F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "extended_wind_charge").toString()));

    public static final RegistryObject<EntityType<ForcefulWindProjectile>> FORCEFUL_WIND =
            ENTITIES.register("forceful_wind", () -> EntityType.Builder.<ForcefulWindProjectile>of(ForcefulWindProjectile::new, MobCategory.MISC)
                    .sized(1.5f, 2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "forceful_wind").toString()));

    public static final RegistryObject<EntityType<BoneDaggerProjectile>> BONE_DAGGER =
            ENTITIES.register("bone_dagger", () -> EntityType.Builder.<BoneDaggerProjectile>of(BoneDaggerProjectile::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "bone_dagger").toString()));

    public static final RegistryObject<EntityType<PoisonQuillProjectile>> POISON_QUILL =
            ENTITIES.register("poison_quill", () -> EntityType.Builder.<PoisonQuillProjectile>of(PoisonQuillProjectile::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "poison_quill").toString()));

    public static final RegistryObject<EntityType<CaveSpiderFangProjectile>> CAVE_SPIDER_FANG =
            ENTITIES.register("cave_spider_fang", () -> EntityType.Builder.<CaveSpiderFangProjectile>of(CaveSpiderFangProjectile::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "cave_spider_fang").toString()));

    public static final RegistryObject<EntityType<IceSpiderFangProjectile>> ICE_SPIDER_FANG =
            ENTITIES.register("ice_spider_fang", () -> EntityType.Builder.<IceSpiderFangProjectile>of(IceSpiderFangProjectile::new, MobCategory.MISC)
                    .sized(1.5f, 1.5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "ice_spider_fang").toString()));

    public static final RegistryObject<EntityType<ChaurusMandiblesProjectile>> CHAURUS_MANDIBLES =
            ENTITIES.register("chaurus_mandibles", () -> EntityType.Builder.<ChaurusMandiblesProjectile>of(ChaurusMandiblesProjectile::new, MobCategory.MISC)
                    .sized(3f, 0.5F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "chaurus_mandibles").toString()));

    public static final RegistryObject<EntityType<RancorSkull>> RANCOR_SKULL =
            ENTITIES.register("rancor_skull", () -> EntityType.Builder.<RancorSkull>of(RancorSkull::new, MobCategory.MISC)
                    .sized(1, 1)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "rancor_skull").toString()));

    public static final RegistryObject<EntityType<BloodThornProjectile>> BLOOD_THORN =
            ENTITIES.register("blood_thorn", () -> EntityType.Builder.<BloodThornProjectile>of(BloodThornProjectile::new, MobCategory.MISC)
                    .sized(0.50f, 0.50f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "blood_thorn").toString()));

    public static final RegistryObject<EntityType<AncientLightningStrike>> ANCIENT_LIGHTNING_STRIKE =
            ENTITIES.register("ancient_lightning_strike", () -> EntityType.Builder.<AncientLightningStrike>of(AncientLightningStrike::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "ancient_lightning_strike").toString()));

    public static final RegistryObject<EntityType<FrostBreathEntity>> FROST_BREATH =
            ENTITIES.register("frost_breath", () -> EntityType.Builder.<FrostBreathEntity>of(FrostBreathEntity::new, MobCategory.MISC)
                    .sized(1, 1)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "frost_breath").toString()));

    public static final RegistryObject<EntityType<SmallFrenzyFireBall>> SMALL_FRENZY_FIREBALL =
            ENTITIES.register("small_frenzy_fireball", () -> EntityType.Builder.<SmallFrenzyFireBall>of(SmallFrenzyFireBall::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "small_frenzy_fireball").toString()));

    public static final RegistryObject<EntityType<SmallBrimstoneFireball>> SMALL_BRIMSTONE_FIREBALL =
            ENTITIES.register("small_brimstone_fireball", () -> EntityType.Builder.<SmallBrimstoneFireball>of(SmallBrimstoneFireball::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "small_brimstone_fireball").toString()));

    public static final RegistryObject<EntityType<DragonChargeProjectile>> DRAGON_CHARGE_PROJECTILE =
            ENTITIES.register("dragon_charge", () -> EntityType.Builder.<DragonChargeProjectile>of(DragonChargeProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "dragon_charge").toString()));

    public static final RegistryObject<EntityType<SoulChain>> REDSTONE_CHAIN_LIGHTNING =
            ENTITIES.register("redstone_chain_lightning", () -> EntityType.Builder.<SoulChain>of(SoulChain::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "redstone_chain_lightning").toString()));

    public static final RegistryObject<EntityType<SoulChain>> SOUL_CHAIN =
            ENTITIES.register("soul_chain", () -> EntityType.Builder.<SoulChain>of(SoulChain::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "soul_chain").toString()));

    public static final RegistryObject<EntityType<SpaceRupture>> SPACE_RUPTURE =
            ENTITIES.register("space_rupture", () -> EntityType.Builder.<SpaceRupture>of(SpaceRupture::new, MobCategory.MISC)
                    .sized(2f, 2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "space_rupture").toString()));

    public static final RegistryObject<EntityType<SanguiniteEvisceration>>SANGUINITE_EVISCERATION =
            ENTITIES.register("sanguinite_evisceration", () -> EntityType.Builder.<SanguiniteEvisceration>of(SanguiniteEvisceration::new, MobCategory.MISC)
                    .sized(2f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "sanguinite_evisceration").toString()));

    public static final RegistryObject<EntityType<BloodPierceVisualEntity>> BLOOD_PIERCE_VISUAL_ENTITY =
            ENTITIES.register("blood_pierce", () -> EntityType.Builder.<BloodPierceVisualEntity>of(BloodPierceVisualEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "blood_pierce").toString()));

    public static final RegistryObject<EntityType<VitalBlastVisualEntity>> VITAL_BLAST_VISUAL_ENTITY =
            ENTITIES.register("vital_blast", () -> EntityType.Builder.<VitalBlastVisualEntity>of(VitalBlastVisualEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "vital_blast").toString()));

    public static final RegistryObject<EntityType<PaleThornVisualEntity>> PALE_THORN_VISUAL_ENTITY=
            ENTITIES.register("pale_thorn", () -> EntityType.Builder.<PaleThornVisualEntity>of(PaleThornVisualEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "pale_thorn").toString()));

    public static final RegistryObject<EntityType<GuardiansNeutralizerVisualEntity>> GUARDIAN_BEAM_VISUAL_ENTITY =
            ENTITIES.register("guardians_neutralizer", () -> EntityType.Builder.<GuardiansNeutralizerVisualEntity>of(GuardiansNeutralizerVisualEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "guardians_neutralizer").toString()));

    public static final RegistryObject<EntityType<WitherNovaVisualEntity>> WITHER_NOVA_VISUAL_ENTITY =
            ENTITIES.register("wither_nova", () -> EntityType.Builder.<WitherNovaVisualEntity>of(WitherNovaVisualEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "wither_nova").toString()));

    public static final RegistryObject<EntityType<CauterizingTouch>>CAUTERIZING_TOUCH =
            ENTITIES.register("cauterizing_touch", () -> EntityType.Builder.<CauterizingTouch>of(CauterizingTouch::new, MobCategory.MISC)
                    .sized(2f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "cauterizing_touch").toString()));

    public static final RegistryObject<EntityType<SpaceBreaker>>SPACE_BREAKER =
            ENTITIES.register("space_breaker", () -> EntityType.Builder.<SpaceBreaker>of(SpaceBreaker::new, MobCategory.MISC)
                    .sized(1.5f, 1)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "space_breaker").toString()));

    public static final RegistryObject<EntityType<BrimstoneBuzzsawProjectile>> BRIMSTONE_BUZZSAW_PROJECTILE =
            ENTITIES.register("brimstone_buzzsaw", () -> EntityType.Builder.<BrimstoneBuzzsawProjectile>of(BrimstoneBuzzsawProjectile::new, MobCategory.MISC)
                    .sized(7f, 1f)
                    .clientTrackingRange(128)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "brimstone_buzzsaw").toString()));
    public static final RegistryObject<EntityType<FrenziedBurstVisualEntity>> FRENZIED_BURST_VISUAL_ENTITY =
            ENTITIES.register("frenzied_burst", () -> EntityType.Builder.<FrenziedBurstVisualEntity>of(FrenziedBurstVisualEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "frenzied_burst").toString()));

    public static final RegistryObject<EntityType<SnowCloud>> SNOW_CLOUD =
            ENTITIES.register("snow_cloud", () -> EntityType.Builder.<SnowCloud>of(SnowCloud::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "snow_cloud").toString()));
    public static final RegistryObject<EntityType<PowderSnowSplash>> POWDER_SNOW_SPLASH =
            ENTITIES.register("powder_snow_splash", () -> EntityType.Builder.<PowderSnowSplash>of(PowderSnowSplash::new, MobCategory.MISC)
                    .sized(3.5f, 4f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "powder_snow_splash").toString()));

    public static final RegistryObject<EntityType<AncientFlash>> ANCIENT_FLASH =
            ENTITIES.register("ancient_flash", () -> EntityType.Builder.<AncientFlash>of(AncientFlash::new, MobCategory.MISC)
                    .sized(2f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "ancient_flash").toString()));

    public static final RegistryObject<EntityType<InfectionSlashProjectile>> INFECTION_SLASH_PROJECTILE =
            ENTITIES.register("infection_slash", () -> EntityType.Builder.<InfectionSlashProjectile>of(InfectionSlashProjectile::new, MobCategory.MISC)
                    .sized(2f, 2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "infection_slash").toString()));

    public static final RegistryObject<EntityType<HallowSlashProjectile>>HALLOW_SLASH_PROJECTILE =
            ENTITIES.register("hallow_slash", () -> EntityType.Builder.<HallowSlashProjectile>of(HallowSlashProjectile::new, MobCategory.MISC)
                    .sized(2.5f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "hallow_slash").toString()));

    public static final RegistryObject<EntityType<StaticCleave>> STATIC_CLEAVE =
            ENTITIES.register("static_cleave", () -> EntityType.Builder.<StaticCleave>of(StaticCleave::new, MobCategory.MISC)
                    .sized(3f, 1.5f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "static_cleave").toString()));

    public static final RegistryObject<EntityType<SpectralBlastVisualEntity>> SPECTRAL_BLAST_VISUAL_ENTITY =
            ENTITIES.register("spectral_blast", () -> EntityType.Builder.<SpectralBlastVisualEntity>of(SpectralBlastVisualEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "spectral_blast").toString()));

    public static final RegistryObject<EntityType<PredatoryScreamProjectile>> PREDATORY_SCREAM =
            ENTITIES.register("predatory_scream", () -> EntityType.Builder.<PredatoryScreamProjectile>of(PredatoryScreamProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "predatory_scream").toString()));

    public static final RegistryObject<EntityType<LifeDrainProjectile>> SOUL_RIVER_PROJECTILE =
            ENTITIES.register("life_drain", () -> EntityType.Builder.<LifeDrainProjectile>of(LifeDrainProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "life_drain").toString()));

    public static final RegistryObject<EntityType<BubbleSprayProjectile>> BUBBLE_SPRAY_PROJECTILE =
            ENTITIES.register("bubble_spray", () -> EntityType.Builder.<BubbleSprayProjectile>of(BubbleSprayProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "bubble_spray").toString()));

    public static final RegistryObject<EntityType<SteamStreamProjectile>> STEAM_STEAM =
            ENTITIES.register("steam_stream", () -> EntityType.Builder.<SteamStreamProjectile>of(SteamStreamProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "steam_stream").toString()));

    public static final RegistryObject<EntityType<WitherBombProjectile>> WITHER_BOMB =
            ENTITIES.register("wither_bomb", () -> EntityType.Builder.<WitherBombProjectile>of(WitherBombProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "wither_bomb").toString()));

    public static final RegistryObject<EntityType<RazorbladeTyphoonProjectile>> RAZORBLADE_TYPHOON =
            ENTITIES.register("razorblade_typhoon", () -> EntityType.Builder.<RazorbladeTyphoonProjectile>of(RazorbladeTyphoonProjectile::new, MobCategory.MISC)
                    .sized(4f, 1f)
                    .clientTrackingRange(4)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "razorblade_typhoon").toString()));

    public static final RegistryObject<EntityType<NapalmOrb>> NAPALM_ORB =
            ENTITIES.register("napalm_orb", () -> EntityType.Builder.<NapalmOrb>of(NapalmOrb::new, MobCategory.MISC)
                    .sized(0.75F, 0.75F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "napalm_orb").toString()));
    public static final RegistryObject<EntityType<PutrescenceField>> PUTRESCENCE_FIELD =
            ENTITIES.register("putrescence_field", () -> EntityType.Builder.<PutrescenceField>of(PutrescenceField::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "putrescence_field").toString()));

    public static final RegistryObject<EntityType<BrimstoneField>> BRIMSTONE_FIELD =
            ENTITIES.register("brimstone_field", () -> EntityType.Builder.<BrimstoneField>of(BrimstoneField::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "brimstone_field").toString()));
    public static final RegistryObject<EntityType<DistortionField>> DISTORTION_FIELD =
            ENTITIES.register("distortion_field", () -> EntityType.Builder.<DistortionField>of(DistortionField::new, MobCategory.MISC)
                    .sized(4f, 12f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "distortion_field").toString()));
    public static final RegistryObject<EntityType<StaticField>> STATIC_FIELD =
            ENTITIES.register("static_field", () -> EntityType.Builder.<StaticField>of(StaticField::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "static_field").toString()));
    public static final RegistryObject<EntityType<SoulFireField>> SOUL_FIRE_FIELD =
            ENTITIES.register("soul_fire_field", () -> EntityType.Builder.<SoulFireField>of(SoulFireField::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "soul_fire_field").toString()));
    public static final RegistryObject<EntityType<PutrescenceMass>> PUTRESCENCE_MASS =
            ENTITIES.register("putrescence_mass", () -> EntityType.Builder.<PutrescenceMass>of(PutrescenceMass::new, MobCategory.MISC)
                    .sized(0.75F, 0.75F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "putrescence_mass").toString()));

    public static final RegistryObject<EntityType<EffervescenceBubbleProjectile>> EFFERVESCENCE_BUBBLE =
            ENTITIES.register("effervescence_bubble", () -> EntityType.Builder.<EffervescenceBubbleProjectile>of(EffervescenceBubbleProjectile::new, MobCategory.MISC)
                    .sized(0.75F, 0.75F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "effervescence_bubble").toString()));

    public static final RegistryObject<EntityType<BlastFungusProjectile>> BLAST_FUNGUS_PROJECTILE =
            ENTITIES.register("blast_fungus_projectile", () -> EntityType.Builder.<BlastFungusProjectile>of(BlastFungusProjectile::new, MobCategory.MISC)
                    .sized(0.75F, 0.75F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "blast_fungus_projectile").toString()));

    public static final Supplier<EntityType<AegisEntity>>AEGIS=
            ENTITIES.register("aegis", () -> EntityType.Builder.of(AegisEntity::new, MobCategory.MONSTER).
                    sized(.8f, 1.8f).build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "aegis").toString()));

    public static final RegistryObject<EntityType<DwarvenSphereEntity>> DWARVEN_SPHERE =
            ENTITIES.register("dwarven_sphere", () -> EntityType.Builder.<DwarvenSphereEntity>of
                            (DwarvenSphereEntity::new, MobCategory.MONSTER).
                    sized(.6f, 1.8f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "dwarven_sphere").toString()
                    ));

    public static final Supplier<EntityType<DwarvenSlicerEntity>>DWARVEN_SLICER=
            ENTITIES.register("dwarven_slicer",()->EntityType.Builder.of(DwarvenSlicerEntity::new,MobCategory.MONSTER)
                    .sized(0.6F, 0.50f).build("dwarven_slicer"));

    public static final RegistryObject<EntityType<RedstoneElementalEntity>> REDSTONE_ELEMENTAL =
            ENTITIES.register("redstone_elemental", () -> EntityType.Builder.<RedstoneElementalEntity>of
                            (RedstoneElementalEntity::new, MobCategory.MONSTER).
                    sized(.6f, .8f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "redstone_elemental").toString()
                    ));

    public static final RegistryObject<EntityType<SoulWraithEntity>> SOUL_WRAITH =
            ENTITIES.register("soul_wraith", () -> EntityType.Builder.<SoulWraithEntity>of
                            (SoulWraithEntity::new, MobCategory.MONSTER).
                    sized(.6f, 1.8f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "soul_wraith").toString()
                    ));

    public static final RegistryObject<EntityType<DripplerEntity>> DRIPPLER =
            ENTITIES.register("drippler", () -> EntityType.Builder.<DripplerEntity>of
                            (DripplerEntity::new, MobCategory.MONSTER).
                    sized(.6f, .8f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "drippler").toString()
                    ));

    public static final RegistryObject<EntityType<SprigganEntity>> SPRIGGAN =
            ENTITIES.register("spriggan", () -> EntityType.Builder.of(SprigganEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 2.75f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "spriggan").toString()));

    public static final RegistryObject<EntityType<WitherWarlockEntity>> WITHER_WARLOCK =
            ENTITIES.register("wither_warlock", () -> EntityType.Builder.of(WitherWarlockEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 2.75f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "wither_warlock").toString()));

    public static final RegistryObject<EntityType<WitherWarriorEntity>> WITHER_WARRIOR =
            ENTITIES.register("wither_warrior", () -> EntityType.Builder.<WitherWarriorEntity>of(WitherWarriorEntity::new, MobCategory.MONSTER)
                    .sized(.85f, 2.3f)
                    .clientTrackingRange(64)
                    
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "wither_warrior").toString()));

    public static final RegistryObject<EntityType<SummonedWitherWarriorEntity>> SUMMONED_WITHER_WARRIOR =
            ENTITIES.register("summoned_wither_warrior", () -> EntityType.Builder.<SummonedWitherWarriorEntity>of(SummonedWitherWarriorEntity::new, MobCategory.MONSTER)
                    .sized(.85f, 2.3f)
                    .clientTrackingRange(64)
                    
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "summoned_wither_warrior").toString()));

    public static final RegistryObject<EntityType<IllagerEnchanterEntity>> ILLAGER_ENCHANTER =
            ENTITIES.register("illager_enchanter", () -> EntityType.Builder.of(IllagerEnchanterEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 2.75f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "illager_enchanter").toString()));

    public static final RegistryObject<EntityType<IllagerIceologerEntity>> ILLAGER_ICEOLOGER =
            ENTITIES.register("illager_iceologer", () -> EntityType.Builder.of(IllagerIceologerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 2.75f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "illager_iceologer").toString()));

    public static final RegistryObject<EntityType<IllagerFireologerEntity>> ILLAGER_FIREOLOGER =
            ENTITIES.register("illager_fireologer", () -> EntityType.Builder.of(IllagerFireologerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 2.75f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "illager_fireologer").toString()));

    public static final RegistryObject<EntityType<DraugrEvokerEntity>> DRAUGR_EVOKER=
            ENTITIES.register("draugr_evoker", () -> EntityType.Builder.of(DraugrEvokerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "draugr_evoker").toString()));

    public static final RegistryObject<EntityType<DraugrVindicatorEntity>> DRAUGR_VINDICATOR=
            ENTITIES.register("draugr_vindicator", () -> EntityType.Builder.of(DraugrVindicatorEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "draugr_vindicator").toString()));

    public static final RegistryObject<EntityType<DraugrEliteVindicatorEntity>> DRAUGR_ELITE_VINDICATOR=
            ENTITIES.register("draugr_elite_vindicator", () -> EntityType.Builder.of(DraugrEliteVindicatorEntity::new, MobCategory.MONSTER)
                    .sized(.72f, 2.4f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "draugr_elite_vindicator").toString()));

    public static final RegistryObject<EntityType<DraugrPillagerEntity>> DRAUGR_PILLAGER=
            ENTITIES.register("draugr_pillager", () -> EntityType.Builder.of(DraugrPillagerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 2f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "draugr_pillager").toString()));

    public static final RegistryObject<EntityType<SoulWizardEntity>> SOUL_WIZARD =
            ENTITIES.register("soul_wizard", () -> EntityType.Builder.<SoulWizardEntity>of
                            (SoulWizardEntity::new, MobCategory.MONSTER).
                    sized(.6f, .8f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "soul_wizard").toString()
                    ));

    public static final RegistryObject<EntityType<DwarvenSwarmDroneEntity>> DWARVEN_SWARM_DRONE =
            ENTITIES.register("dwarven_swarm_drone", () -> EntityType.Builder.<DwarvenSwarmDroneEntity>of
                            (DwarvenSwarmDroneEntity::new, MobCategory.MONSTER).
                    sized(.6f, .8f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "dwarven_swarm_drone").toString()
                    ));

    public static final RegistryObject<EntityType<JungleWhispererEntity>> JUNGLE_WHISPERER =
            ENTITIES.register("jungle_whisperer", () -> EntityType.Builder.<JungleWhispererEntity>of
                            (JungleWhispererEntity::new, MobCategory.MONSTER).
                    sized(.6f, 2.5f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "jungle_whisperer").toString()
                    ));

    public static final RegistryObject<EntityType<JungleLeapleafEntity>> JUNGLE_LEAPLEAF =
            ENTITIES.register("jungle_leapleaf", () -> EntityType.Builder.<JungleLeapleafEntity>of
                            (JungleLeapleafEntity::new, MobCategory.MONSTER).
                    sized(2f, 2.5f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "jungle_leapleaf").toString()
                    ));

    public static final RegistryObject<EntityType<MagmaAtronachEntity>> MAGMA_ATRONACH =
            ENTITIES.register("magma_atronach", () -> EntityType.Builder.<MagmaAtronachEntity>of
                            (MagmaAtronachEntity::new, MobCategory.MONSTER).
                    sized(1f, 4)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "magma_atronach").toString()
                    ));

    public static final RegistryObject<EntityType<BlastlingEntity>> BLASTLING =
            ENTITIES.register("blastling", () -> EntityType.Builder.<BlastlingEntity>of
                            (BlastlingEntity::new, MobCategory.MONSTER).
                    sized(.8f, 2.5f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "blastling").toString()
                    ));

    public static final RegistryObject<EntityType<PoisonQuillVineEntity>> POISON_QUILL_VINE =
            ENTITIES.register("poison_quill_vine", () -> EntityType.Builder.<PoisonQuillVineEntity>of
                            (PoisonQuillVineEntity::new, MobCategory.MONSTER).
                    sized(.6f, 5.5f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "poison_quill_vine").toString()
                    ));


    public static final RegistryObject<EntityType<LivingLeafCrystalEntity>> LIVING_LEAF_CRYSTAL =
            ENTITIES.register("living_leaf_crystal", () -> EntityType.Builder.<LivingLeafCrystalEntity>of
                            (LivingLeafCrystalEntity::new, MobCategory.MONSTER).
                    sized(1, 1)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "living_leaf_crystal").toString()
                    ));

    public static final RegistryObject<EntityType<OrbitalSnowballEntity>> ORBITAL_SNOWBALL =
            ENTITIES.register("orbital_snowball", () -> EntityType.Builder.<OrbitalSnowballEntity>of
                            (OrbitalSnowballEntity::new, MobCategory.MONSTER).
                    sized(1, 1)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "orbital_snowball").toString()
                    ));

    public static final RegistryObject<EntityType<IceSerpeantEntity>> ICE_SERPEANT =
            ENTITIES.register("ice_serpeant", () -> EntityType.Builder.<IceSerpeantEntity>of
                            (IceSerpeantEntity::new, MobCategory.MONSTER).
                    sized(.6f, 1.5f)
                    .build(
                            new ResourceLocation(MonstersSpellbooks.MOD_ID, "ice_serpeant").toString()
                    ));

    public static final Supplier<EntityType<VileSkeletonEntity>>VILE_SKELETON=
            ENTITIES.register("vile_skeleton",()->EntityType.Builder.of(VileSkeletonEntity::new,MobCategory.MONSTER)
                    .sized(0.6F, 1.9F).build("vile_skeleton"));


    public static final RegistryObject<EntityType<SummonedAegisEntity>> SUMMONED_AEGIS =
            ENTITIES.register("summoned_aegis", () -> EntityType.Builder.<SummonedAegisEntity>of(SummonedAegisEntity::new, MobCategory.MISC).
                    sized(.8f, 1.8f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "summoned_aegis").toString()));

    public static final RegistryObject<EntityType<SummonedVileSkeletonEntity>> SUMMONED_VILE_SKELETON =
            ENTITIES.register("summoned_vile_skeleton", () -> EntityType.Builder.<SummonedVileSkeletonEntity>of(SummonedVileSkeletonEntity::new, MobCategory.MISC)
                    .sized(.6f, 1.9f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "summoned_vile_skeleton").toString()));

    public static final RegistryObject<EntityType<DeathKnightEntity>> SUMMONED_DEATH_KNIGHT =
            ENTITIES.register("death_knight", () -> EntityType.Builder.<DeathKnightEntity>of(DeathKnightEntity::new, MobCategory.MISC)
                    .sized(2, 3F)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(MonstersSpellbooks.MOD_ID, "death_knight").toString()));



    public static void register(IEventBus eventBus)
    {
        ENTITIES.register(eventBus);
    }
}
