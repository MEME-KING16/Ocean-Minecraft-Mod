package com.example.oceanmod.effect;

import com.example.oceanmod.OceanMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
        DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "oceanmod");

    public static final RegistryObject<MobEffect> RUST =
        EFFECTS.register("rust", RustEffect::new);
}
