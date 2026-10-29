package net.redreaper.monsterspellbooks.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.item.armor.tierUnique.WildFireCrownItem;
import software.bernie.geckolib.model.GeoModel;

public class WildFireCrownModel extends GeoModel<WildFireCrownItem> {

    public WildFireCrownModel() {super();}

    @Override
    public ResourceLocation getModelResource(WildFireCrownItem object) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/armor/wildfire_crown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WildFireCrownItem object) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/armor/wildfire_crown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WildFireCrownItem animatable) {
        return new ResourceLocation(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}