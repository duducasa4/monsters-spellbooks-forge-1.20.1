package net.redreaper.monsterspellbooks.init;

import net.minecraftforge.registries.RegistryObject;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.spells.aero.*;
import net.redreaper.monsterspellbooks.spells.blood.*;
import net.redreaper.monsterspellbooks.spells.ender.*;
import net.redreaper.monsterspellbooks.spells.evocation.EnchantersBoostSpell;
import net.redreaper.monsterspellbooks.spells.evocation.EnchantersProtectionSpell;
import net.redreaper.monsterspellbooks.spells.evocation.SpellOfUndyingSpell;
import net.redreaper.monsterspellbooks.spells.fire.*;
import net.redreaper.monsterspellbooks.spells.holy.*;
import net.redreaper.monsterspellbooks.spells.hydro.*;
import net.redreaper.monsterspellbooks.spells.ice.*;
import net.redreaper.monsterspellbooks.spells.lightning.*;
import net.redreaper.monsterspellbooks.spells.nature.*;
import net.redreaper.monsterspellbooks.spells.necro.*;
import net.redreaper.monsterspellbooks.spells.technomancy.SpinbladeSpell;
import net.redreaper.monsterspellbooks.spells.technomancy.SummonDwarvenDronesSpell;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SpellRegistry.SPELL_REGISTRY_KEY;

public class ModSpellRegistry {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SPELL_REGISTRY_KEY, MonstersSpellbooks.MOD_ID);


    public static RegistryObject<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }

    //BLOOD
    public static final RegistryObject<AbstractSpell> ANTICOAGULATION = registerSpell(new AnticoagulationSpell());
    public static final RegistryObject<AbstractSpell> BLOOD_PIERCE = registerSpell(new BloodPierceSpell());
    public static final RegistryObject<AbstractSpell> BLOOD_THORN = registerSpell(new BloodThornSpell());
    public static final RegistryObject<AbstractSpell> HYSTERIA = registerSpell(new HysteriaSpell());
    public static final RegistryObject<AbstractSpell> SANGUINITE_EVISCERATION = registerSpell(new SanguiniteEviscerationSpell());

    //ENDER
    public static final RegistryObject<AbstractSpell> CORRUPTED_BEACON_RAY = registerSpell(new CorruptedBeaconRaySpell());
    public static final RegistryObject<AbstractSpell> CRUSHING_PRESENCE = registerSpell(new CrushingPresenceSpell());
    public static final RegistryObject<AbstractSpell> CRUSH = registerSpell(new CrushSpell());
    public static final RegistryObject<AbstractSpell> DRAGON_CHARGE = registerSpell(new DragonChargeSpell());
    public static final RegistryObject<AbstractSpell> ENDERSENT_SMASH = registerSpell(new EndersentSmashSpell());
    public static final RegistryObject<AbstractSpell> ENDERSENT_FORM = registerSpell(new EndersentFormSpell());
    public static final RegistryObject<AbstractSpell> FIRMAMENT_SPLITTER = registerSpell(new FirmamentSplitterSpell());
    public static final RegistryObject<AbstractSpell> GRAVITY_WELL = registerSpell(new GravityWellSpell());
    public static final RegistryObject<AbstractSpell> SPACE_BREAKER = registerSpell(new SpaceBreakerSpell());
    public static final RegistryObject<AbstractSpell> SPACE_RUPTURE = registerSpell(new SpaceRuptureSpell());
    public static final RegistryObject<AbstractSpell> UNSTABLE_TELEPORT = registerSpell(new UnstableTeleportSpell());
    public static final RegistryObject<AbstractSpell> VOID_ARROWS = registerSpell(new VoidArrowsSpell());

    //EVOCATION
    public static final RegistryObject<AbstractSpell> ENCHANTERS_BOOST = registerSpell(new EnchantersBoostSpell());
    public static final RegistryObject<AbstractSpell> ENCHANTERS_PROTECTION = registerSpell(new EnchantersProtectionSpell());
    public static final RegistryObject<AbstractSpell> SPELL_OF_UNDYING = registerSpell(new SpellOfUndyingSpell());

    //FIRE
    public static final RegistryObject<AbstractSpell> BRIMSTONE_BUZZSAW = registerSpell(new BrimstoneBuzzsawSpell());
    public static final RegistryObject<AbstractSpell> BRIMSTONE_RAIN = registerSpell(new BrimstoneRainSpell());
    public static final RegistryObject<AbstractSpell> BRIMSTONE_WRATH = registerSpell(new BrimstoneWrathSpell());
    public static final RegistryObject<AbstractSpell> CAUTERIZING_TOUCH = registerSpell(new CauterizingTouchSpell());
    public static final RegistryObject<AbstractSpell> FRENZIED_BURST = registerSpell(new FrenziedBurstSpell());
    public static final RegistryObject<AbstractSpell> FRENZIED_STORM = registerSpell(new FrenziedStormSpell());
    public static final RegistryObject<AbstractSpell> FRENZY_SURGE = registerSpell(new FrenzySurgeSpell());
    public static final RegistryObject<AbstractSpell> NAPALM_ORB = registerSpell(new NapalmOrbSpell());
    public static final RegistryObject<AbstractSpell> OVERHEAT = registerSpell(new OverheatSpell());
    public static final RegistryObject<AbstractSpell> WRATH = registerSpell(new WrathSpell());

    //HOLY
    public static final RegistryObject<AbstractSpell> DIVINE_INTERVENTION = registerSpell(new DivineInterventionSpell());
    public static final RegistryObject<AbstractSpell> HALLOW_SLASH = registerSpell(new HallowSlashSpell());
    public static final RegistryObject<AbstractSpell> PALADIN_THROW = registerSpell(new PaladinThrowSpell());
    public static final RegistryObject<AbstractSpell> SUMMON_AEGIS_PATROL = registerSpell(new SummonAegisPatrolSpell());

    //HYDRO
    public static final RegistryObject<AbstractSpell> BUBBLE_SPRAY = registerSpell(new BubbleSpraySpell());
    public static final RegistryObject<AbstractSpell> EFFERVESCENCE_BUBBLE = registerSpell(new EffervescenceBubbleSpell());
    public static final RegistryObject<AbstractSpell> GLOW_INK_RELEASE = registerSpell(new GlowInkReleaseSpell());
    public static final RegistryObject<AbstractSpell> INK_BOMB = registerSpell(new InkBombSpell());
    public static final RegistryObject<AbstractSpell> RAZORBLADE_TYPHOON = registerSpell(new RazorbladeTyphoonSpell());
    public static final RegistryObject<AbstractSpell> RIPTIDE_DASH = registerSpell(new RiptideDashSpell());
    public static final RegistryObject<AbstractSpell> SUMMON_PRISMARINE_SQUAD = registerSpell(new SummonPrismarineSquadSpell());
    public static final RegistryObject<AbstractSpell> WATER_TRIDENT = registerSpell(new WaterTridentSpell());

    //ICE
    public static final RegistryObject<AbstractSpell> BLIZZARD_ASPECT = registerSpell(new BlizzardAspectSpell());
    public static final RegistryObject<AbstractSpell> FROST_BREATH = registerSpell(new FrostBreathSpell());
    public static final RegistryObject<AbstractSpell> FROST_COATING = registerSpell(new FrostCoatingSpell());
    public static final RegistryObject<AbstractSpell> FROSTED_SNOWBOLT = registerSpell(new FrostedSnowboltSpell());
    public static final RegistryObject<AbstractSpell> ICE_ARSENAL = registerSpell(new IceArsenalSpell());
    public static final RegistryObject<AbstractSpell> ORBITAL_SNOWBALL = registerSpell(new OrbitalSnowballSpell());
    public static final RegistryObject<AbstractSpell> SUMMON_ICE_HYDRA = registerSpell(new SummonIceHydraSpell());
    public static final RegistryObject<AbstractSpell> TUNDRA_TERRAIN = registerSpell(new TundraTerrainSpell());

    //LIGHTING
    public static final RegistryObject<AbstractSpell> PRIMORDIAL_FLASH = registerSpell(new PrimordialFlashSpell());
    public static final RegistryObject<AbstractSpell> DISCHARGE = registerSpell(new DischargeSpell());
    public static final RegistryObject<AbstractSpell> RAIJIN_JUDGEMENT = registerSpell(new RaijinJudgementSpell());
    public static final RegistryObject<AbstractSpell> REDSTONE_BOLT = registerSpell(new RedstoneBoltSpell());
    public static final RegistryObject<AbstractSpell> REDSTONE_MINES = registerSpell(new RedstoneMinesSpell());
    public static final RegistryObject<AbstractSpell> GUARDIANS_NEUTRALIZER = registerSpell(new GuardiansNeutralizerSpell());
    public static final RegistryObject<AbstractSpell> REDSTONE_CHAIN = registerSpell(new RedstoneChainSpell());
    public static final RegistryObject<AbstractSpell> REDSTONE_LASERS = registerSpell(new RedstoneLasersSpell());
    public static final RegistryObject<AbstractSpell> RAIGO = registerSpell(new RaigoSpell());
    public static final RegistryObject<AbstractSpell> STATIC_CLEAVE = registerSpell(new StaticCleaveSpell());
    public static final RegistryObject<AbstractSpell> THUNDER_STEP = registerSpell(new ThunderStepSpell());
    public static final RegistryObject<AbstractSpell> THUNDERSTORM_WAVE = registerSpell(new ThunderstormWaveSpell());
    public static final RegistryObject<AbstractSpell> VOLTAIC_MULTISHOT = registerSpell(new VoltaicMultishotSpell());
    public static final RegistryObject<AbstractSpell> ZAP = registerSpell(new ZapSpell());

    //NATURE
    public static final RegistryObject<AbstractSpell> BLAST_FUNGUS = registerSpell(new BlastFungusSpell());
    public static final RegistryObject<AbstractSpell> INFECTION_SLASH = registerSpell(new InfectionSlashSpell());
    public static final RegistryObject<AbstractSpell> LEAF_CRYSTAL = registerSpell(new LifeCrystalSpell());
    public static final RegistryObject<AbstractSpell> POISON_QUILL = registerSpell(new PoisonQuillSpell());
    public static final RegistryObject<AbstractSpell> SPIDER_FANGS = registerSpell(new SpiderFangsSpell());
    public static final RegistryObject<AbstractSpell> SUMMON_POISON_VINE = registerSpell(new SummonPoisonVinesSpell());
    public static final RegistryObject<AbstractSpell> VITAL_BLAST = registerSpell(new VitalBlastSpell());

    //NECRO
    public static final RegistryObject<AbstractSpell> REAPER_ASPECT = registerSpell(new ReaperAspectSpell());
    public static final RegistryObject<AbstractSpell> BANSHEE_SCREAM = registerSpell(new BansheeScreamSpell());
    public static final RegistryObject<AbstractSpell> BONE_DAGGER = registerSpell(new BoneDaggerSpell());
    public static final RegistryObject<AbstractSpell> SUMMON_DEATH_KNIGHT = registerSpell(new SummonDeathKnightSpell());
    public static final RegistryObject<AbstractSpell> FALL_CURSE = registerSpell(new FallCurseSpell());
    public static final RegistryObject<AbstractSpell> GRAVEYARD_FISSURE = registerSpell(new GraveyardFissureSpell());
    public static final RegistryObject<AbstractSpell> LICHDOM = registerSpell(new LichdomSpell());
    public static final RegistryObject<AbstractSpell> LIFE_DRAIN = registerSpell(new LifeDrainSpell());
    public static final RegistryObject<AbstractSpell> PUTRESCENCE_MASS = registerSpell(new PutrescenceMassSpell());
    public static final RegistryObject<AbstractSpell> RANCORCALL = registerSpell(new RancorCallSpell());
    public static final RegistryObject<AbstractSpell> SOUL_CASTING_FIELD = registerSpell(new SoulCastingFieldSpell());
    public static final RegistryObject<AbstractSpell> SOUL_CHAIN = registerSpell(new SoulChainSpell());
    public static final RegistryObject<AbstractSpell> SOUL_FIREBOLT = registerSpell(new SoulFireBoltSpell());
    public static final RegistryObject<AbstractSpell> SOUL_FIRE_TELEPORT = registerSpell(new SoulFireTeleportSpell());
    public static final RegistryObject<AbstractSpell> SOUL_FORM = registerSpell(new SoulFormSpell());
    public static final RegistryObject<AbstractSpell> SOUL_SCORCH = registerSpell(new SoulScorchSpell());
    public static final RegistryObject<AbstractSpell> SPECTRAL_BLAST = registerSpell(new SpectralBlastSpell());
    public static final RegistryObject<AbstractSpell> SPIRIT_STRIKE = registerSpell(new SpiritStrikeSpell());
    public static final RegistryObject<AbstractSpell> STRAY_GRASP = registerSpell(new StrayGraspSpell());
    public static final RegistryObject<AbstractSpell> SUMMON_SOUL_WIZARD = registerSpell(new SummonSoulWizardSpell());
    public static final RegistryObject<AbstractSpell> TORMENT_ARROW = registerSpell(new TormentArrowSpell());
    public static final RegistryObject<AbstractSpell> VILE_SLASH = registerSpell(new VileSlashSpell());
    public static final RegistryObject<AbstractSpell> SUMMON_WITHER_ARMY = registerSpell(new SummonWitherArmy());
    public static final RegistryObject<AbstractSpell> WITHER_BOMB = registerSpell(new WitherBombSpell());
    public static final RegistryObject<AbstractSpell> WITHER_NOVA = registerSpell(new WitherNovaSpell());

    //TECHNOMANCY
    public static final RegistryObject<AbstractSpell> SPINBLADE = registerSpell(new SpinbladeSpell());
    public static final RegistryObject<AbstractSpell> SUMMON_DWARVEN_DRONES = registerSpell(new SummonDwarvenDronesSpell());

    public static void register(IEventBus eventBus)
    {
        SPELLS.register(eventBus);
    }
}
