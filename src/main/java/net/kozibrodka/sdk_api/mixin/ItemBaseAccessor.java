package net.kozibrodka.sdk_api.mixin;

import net.minecraft.item.ItemBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemBase.class)
public interface ItemBaseAccessor {

    @Accessor
    int getMaxStackSize();
}
