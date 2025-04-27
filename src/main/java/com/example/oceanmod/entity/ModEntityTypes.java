package com.example.oceanmod.entity;

import com.example.oceanmod.OceanMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OceanMod.MOD_ID);

    public static final RegistryObject<EntityType<GenericSmallFishEntity>> GENERIC_SMALL_FISH =
        ENTITY_TYPES.register("generic_small_fish", () ->
            EntityType.Builder.of(GenericSmallFishEntity::new, MobCategory.WATER_CREATURE)
                .sized(0.5F, 0.5F) // size of fish
                .build("generic_small_fish"));
}
