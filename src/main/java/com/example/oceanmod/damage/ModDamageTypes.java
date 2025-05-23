package com.example.oceanmod.damage;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.server.level.ServerLevel;

public class ModDamageTypes {
    // Correct: Use ResourceKey instead of ResourceLocation
    public static final ResourceKey<DamageType> RUST =
        ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("oceanmod", "rust"));

    public static DamageSource rust(ServerLevel level) {
        // Get registry access and safely fetch the damage type
        HolderGetter<DamageType> damageTypes = level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE);
        return new DamageSource(damageTypes.getOrThrow(RUST));
    }
}
