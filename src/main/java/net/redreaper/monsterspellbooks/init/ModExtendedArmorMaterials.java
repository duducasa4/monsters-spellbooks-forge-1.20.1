package net.redreaper.monsterspellbooks.init;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModExtendedArmorMaterials {
    
    /** 1.20.1: Iron's 1.21 ArmorMaterialRegistry.SCHOOL, which Iron's 1.20.1 doesn't have. */
    public static final ModArmorMaterial SCHOOL = register("school_armor",
            schoolArmorMap(),
            20,
            () -> SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
            0,
            0);

    //ARCH
    public static final ModArmorMaterial STARSCOURGE_ARMOR = register("starscourge_armor",
            schoolUpgradedArmorMap(),
            25,
            () -> SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ModItems.VOID_OBSIDIAN_INGOT.get()),
            3,
            0.05F);

    public static final ModArmorMaterial FORGE_MASTERPIECE_ARMOR = register("forge_masterpiece_armor",
            schoolUpgradedArmorMap(),
            25,
            SoundRegistry.FIRE_CAST,
            () -> Ingredient.of(ModItems.SCORCHED_METAL_INGOT.get()),
            1.5f,
            0F);

    public static final ModArmorMaterial SANGUINITE_ARMOR = register("sanguinite_armor",
            schoolUpgradedArmorMap(),
            25,
            SoundRegistry.BLOOD_EXPLOSION,
            () -> Ingredient.of(ModItems.SANGUINITE_INGOT.get()),
            0,
            0F);

    //HYBRID
    public static final ModArmorMaterial DWARVEN_ENGINEER = register("dwarven_engineer_armor",
            schoolUpgradedArmorMap(),
            25,
            SoundRegistry.LIGHTNING_CAST,
            () -> Ingredient.of(ModItems.DWARVEN_ALLOY_PLATE.get()),
            2,
            0F);

    public static final ModArmorMaterial FROST_DEATHSILVER = register("frost_deathsilver",
            schoolHybridArmorMap(),
            20,
            SoundRegistry.ICE_CAST,
            () -> Ingredient.of(ModItems.DEATHSILVER_INGOT.get()),
            2,
            0);

    public static final ModArmorMaterial ENCHANTER = register("enchanter",
            schoolHybridArmorMap(),
            10,
            () -> SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
            0,
            0);

    public static final ModArmorMaterial ICEOLOGER = register("iceologer",
            schoolHybridArmorMap(),
            10,
            () -> SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
            0,
            0);

    //UNIQUE
    public static final ModArmorMaterial FIERCE_DEITY = register("fierce_deity",
            makeArmorMap(2, 0, 0, 0),
            15,
            () -> SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(ItemRegistry.DIVINE_PEARL.get()),
            0,
            0);

    public static final ModArmorMaterial MAJORAS_MASK = register("majoras_mask",
            makeArmorMap(2, 0, 0, 0),
            15,
            () -> SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(ModTags.Items.NECRO_FOCUS),
            0,
            0);

    public static final ModArmorMaterial WILDFIRE_CROWN = register("wildfire_crown",
            makeArmorMap(3, 0, 0, 0),
            15,
            () -> SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ModItems.NETHER_RUBY.get()),
            0,
            0);

    public static final ModArmorMaterial FUNGAL_CAP = register("fungal_cap",
            makeArmorMap(3, 0, 0, 0),
            15,
            () -> SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(Tags.Items.MUSHROOMS),
            0,
            0);


    public static final ModArmorMaterial DEATHSILVER = register("deathsilver",
            spellcounterArmorMap(),
            10,
            () -> SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ModItems.DEATHSILVER_INGOT.get()),
            3,
            0);

    public static final ModArmorMaterial FLESH_MAIDEN = register("flesh_maiden",
            schoolArmorMap(),
            25,
            SoundRegistry.BLOOD_EXPLOSION,
            () -> Ingredient.of(ItemRegistry.BLOOD_VIAL.get()),
            0,
            0F);

    private static ModArmorMaterial register(
            String name,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantmentValue,
            Supplier<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngredient,
            float toughness,
            float knockbackResistance
    )
    {
        return new ModArmorMaterial(MonstersSpellbooks.MOD_ID + ":" + name, defense, enchantmentValue, equipSound, repairIngredient, toughness, knockbackResistance);
    }

    /** 1.20.1: armor materials are plain objects (no registry); durability comes from the item's properties. */
    public record ModArmorMaterial(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Supplier<SoundEvent> equipSound,
                                   Supplier<Ingredient> repairIngredient, float toughness, float knockbackResistance) implements io.redspace.ironsspellbooks.item.armor.IronsExtendedArmorMaterial {
        @Override
        public java.util.Map<net.minecraft.world.entity.ai.attributes.Attribute, net.minecraft.world.entity.ai.attributes.AttributeModifier> getAdditionalAttributes() {
            return java.util.Map.of();
        }

        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return 0;
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return defense.getOrDefault(type, 0);
        }

        @Override
        public int getEnchantmentValue() {
            return enchantmentValue;
        }

        @Override
        public SoundEvent getEquipSound() {
            return equipSound.get();
        }

        @Override
        public Ingredient getRepairIngredient() {
            return repairIngredient.get();
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return knockbackResistance;
        }
    }

    public static EnumMap<ArmorItem.Type, Integer> makeArmorMap(int helmet, int chestplate, int leggings, int boots)
    {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), (typeIntegerEnumMap) -> {
            typeIntegerEnumMap.put(ArmorItem.Type.HELMET, helmet);
            typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, chestplate);
            typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, leggings);
            typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, boots);
        });
    }
    static public EnumMap<ArmorItem.Type, Integer> spellcounterArmorMap() {
        return makeArmorMap(7, 11, 10, 6);
    }

    static public EnumMap<ArmorItem.Type, Integer> schoolArmorMap() {
        return makeArmorMap(3, 8, 6, 3);
    }

    static public EnumMap<ArmorItem.Type, Integer> schoolHybridArmorMap() {
        return makeArmorMap(3, 9, 7, 3);
    }

    static public EnumMap<ArmorItem.Type, Integer> schoolUpgradedArmorMap() {
        return makeArmorMap(4, 9, 7, 5);
    }

}
