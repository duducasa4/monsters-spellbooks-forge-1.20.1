package net.redreaper.monsterspellbooks.item.armor.custom;

import com.google.common.base.Suppliers;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.redreaper.monsterspellbooks.compat120.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.redreaper.monsterspellbooks.compat120.ItemAttributeModifiers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.animatable.GeoItem;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModExtendedGeoArmorItem extends ModArmorItem implements GeoItem {

    /** The same ids vanilla gives each armor slot's modifiers (private in ArmorItem on 1.20.1). */
    private static final java.util.Map<ArmorItem.Type, java.util.UUID> ARMOR_UUIDS = java.util.Map.of(
        ArmorItem.Type.BOOTS, java.util.UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"),
        ArmorItem.Type.LEGGINGS, java.util.UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"),
        ArmorItem.Type.CHESTPLATE, java.util.UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"),
        ArmorItem.Type.HELMET, java.util.UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"));

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Supplier<ItemAttributeModifiers> defaultModifiers;

    public ModExtendedGeoArmorItem(ArmorMaterial material, ArmorItem.Type type, Item.Properties properties, AttributeContainer... attributeContainers) {
        super(material, type, properties);
        this.defaultModifiers = Suppliers.memoize(() -> {
            int i = material.getDefenseForType(type);
            float f = material.getToughness();
            ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
            EquipmentSlotGroup equipmentSlotGroup = EquipmentSlotGroup.bySlot(type.getSlot());
            java.util.UUID armorId = ARMOR_UUIDS.get(type);
            builder.add(Attributes.ARMOR, new AttributeModifier(armorId, "Armor modifier", (double)i, AttributeModifier.Operation.ADDITION), equipmentSlotGroup);
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(armorId, "Armor toughness", (double)f, AttributeModifier.Operation.ADDITION), equipmentSlotGroup);
            float resistance = material.getKnockbackResistance();
            if (resistance > 0.0F) {
                builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(armorId, "Armor knockback resistance", (double)resistance, AttributeModifier.Operation.ADDITION), equipmentSlotGroup);
            }

            for(AttributeContainer holder : attributeContainers) {
                builder.add(holder.attribute(), holder.createModifier(type.getSlot().getName()), equipmentSlotGroup);
            }

            return builder.build();
        });
    }

    public static AttributeContainer[] schoolAttributes(Supplier<Attribute> school, int mana, float schoolSpellPower, float spellPower) {
        return new AttributeContainer[]{new AttributeContainer(AttributeRegistry.MAX_MANA, (double)mana, AttributeModifier.Operation.ADDITION), new AttributeContainer(school, (double)schoolSpellPower, AttributeModifier.Operation.MULTIPLY_BASE), new AttributeContainer(AttributeRegistry.SPELL_POWER, (double)spellPower, AttributeModifier.Operation.MULTIPLY_BASE)};
    }

    public static AttributeContainer[] schoolAttributesWithResistance(Supplier<Attribute> school, Supplier<Attribute> resistSchool, int mana, float schoolSpellPower, float spellPower, float resistSpellPower) {
        return new AttributeContainer[]{new AttributeContainer(AttributeRegistry.MAX_MANA, (double)mana, AttributeModifier.Operation.ADDITION), new AttributeContainer(school, (double)schoolSpellPower, AttributeModifier.Operation.MULTIPLY_BASE), new AttributeContainer(resistSchool, (double)resistSpellPower, AttributeModifier.Operation.MULTIPLY_BASE), new AttributeContainer(AttributeRegistry.SPELL_POWER, (double)spellPower, AttributeModifier.Operation.MULTIPLY_BASE)};
    }

    @Override
    public com.google.common.collect.Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == this.type.getSlot() ? this.defaultModifiers.get().toMultimap(slot) : com.google.common.collect.ImmutableMultimap.of();
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controler", this::predicate));
    }

    private PlayState predicate(AnimationState<ModExtendedGeoArmorItem> itemAnimationState) {
        itemAnimationState.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
        return PlayState.CONTINUE;
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public @org.jetbrains.annotations.NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null) {
                    this.renderer = ModExtendedGeoArmorItem.this.supplyRenderer();
                }
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return null;
    }
}