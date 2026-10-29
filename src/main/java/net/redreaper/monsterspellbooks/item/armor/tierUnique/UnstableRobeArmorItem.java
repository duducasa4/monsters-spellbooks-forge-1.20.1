package net.redreaper.monsterspellbooks.item.armor.tierUnique;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.redreaper.monsterspellbooks.entity.armor.UnstableRobesArmorModel;
import net.redreaper.monsterspellbooks.init.ModSpellRegistry;
import net.redreaper.monsterspellbooks.item.armor.custom.PresetImbueArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;


public class UnstableRobeArmorItem extends PresetImbueArmorItem implements IPresetSpellContainer {
    public UnstableRobeArmorItem(Type slot, Properties settings) {
        super(net.redreaper.monsterspellbooks.init.ModExtendedArmorMaterials.SCHOOL, slot, settings, SpellDataRegistryHolder.of(
                new SpellDataRegistryHolder(ModSpellRegistry.UNSTABLE_TELEPORT, 1)),
                new AttributeContainer(AttributeRegistry.MAX_MANA, 125, AttributeModifier.Operation.ADDITION),
                new AttributeContainer(() -> Attributes.MOVEMENT_SPEED, 0.05, AttributeModifier.Operation.MULTIPLY_BASE),
                new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, 0.10, AttributeModifier.Operation.MULTIPLY_BASE));

    }

    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            Item var3 = itemStack.getItem();
        }

        super.initializeSpellContainer(itemStack);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new UnstableRobesArmorModel());
    }
}
