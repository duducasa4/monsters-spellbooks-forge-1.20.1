package net.redreaper.monsterspellbooks.mixins;

import net.minecraft.world.item.Item;
import net.redreaper.monsterspellbooks.compat120.ItemAttrs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** 1.20.1: ties the attribute modifiers given to an Item.Properties (see {@link ItemAttrs}) to the item built from it. */
@Mixin(Item.class)
public abstract class ItemAttrsMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void monsterspellbooks$attributes(Item.Properties properties, CallbackInfo ci) {
        ItemAttrs.bind((Item) (Object) this, properties);
    }
}
