package net.redreaper.monsterspellbooks.item.armor.tierUnique;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.acetheeldritchking.aces_spell_utils.entity.render.armor.EmissiveGenericCustomArmorRenderer;
import net.acetheeldritchking.aces_spell_utils.items.example.items.armor.ImbuableExtendedGeoArmorItem;
import net.acetheeldritchking.aces_spell_utils.registries.ASAttributeRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.entity.armor.HerobrineCultistArmorModel;
import net.redreaper.monsterspellbooks.init.ModAtributeRegistry;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class HerobrineCultistArmorItem extends ImbuableExtendedGeoArmorItem {
    public HerobrineCultistArmorItem(ArmorItem.Type slot, Properties settings) {
        super(net.redreaper.monsterspellbooks.init.ModExtendedArmorMaterials.SCHOOL, slot, settings,
                new AttributeContainer(AttributeRegistry.MAX_MANA, 100, AttributeModifier.Operation.ADDITION),
                new AttributeContainer(ModAtributeRegistry.NECRO_MAGIC_POWER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE),
                new AttributeContainer(ASAttributeRegistry.RITUAL_MAGIC_POWER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE),
                new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE),
                new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE));
    }

    private static final ResourceLocation LAYER = new ResourceLocation(
            MonstersSpellbooks.MOD_ID,
            "textures/armor/herobrine_cultist_armor_glow.png");

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        RenderType GLOW_RENDER_TYPE = RenderType.eyes(LAYER);

        return new EmissiveGenericCustomArmorRenderer<>(new HerobrineCultistArmorModel(), LAYER, GLOW_RENDER_TYPE);
    }
}