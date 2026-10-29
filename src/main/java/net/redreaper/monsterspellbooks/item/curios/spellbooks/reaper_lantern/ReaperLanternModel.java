package net.redreaper.monsterspellbooks.item.curios.spellbooks.reaper_lantern;

import net.minecraft.resources.ResourceLocation;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ReaperLanternModel extends DefaultedItemGeoModel<ReaperLanternSpellBook> {
    public ReaperLanternModel() {super(new ResourceLocation("monsterspellbooks", ""));}

    public ResourceLocation getModelResource(ReaperLanternSpellBook animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "geo/item/curios/reapers_lantern.geo.json");
    }

    public ResourceLocation getTextureResource(ReaperLanternSpellBook animatable) {
        return new ResourceLocation(MonstersSpellbooks.MOD_ID, "textures/item/spell_book_models/reapers_lantern.png");
    }

    public ResourceLocation getAnimationResource(ReaperLanternSpellBook animatable) {
        return new ResourceLocation("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
