package net.kozibrodka.sdk_api.mixin;

import net.minecraft.block.Fire;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Fire.class)
public interface BlockFireAccessor {

    @Accessor
    int[] getSpreadDelayChance();

}
