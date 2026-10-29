package net.redreaper.monsterspellbooks.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.item.armor.tierUnique.FierceDeityMaskItem;
import software.bernie.geckolib.model.GeoModel;

public class FierceDeityMaskArmorModel extends GeoModel<FierceDeityMaskItem> {

    public FierceDeityMaskArmorModel() {
        super();

    }

    @Override
    public ResourceLocation getModelResource(FierceDeityMaskItem object) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID,"geo/armor/fierce_deity_mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FierceDeityMaskItem object) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/armor/fierce_deity_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FierceDeityMaskItem animatable) {
        return new ResourceLocation(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
