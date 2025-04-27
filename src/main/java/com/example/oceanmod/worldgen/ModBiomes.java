// package com.example.oceanmod.worldgen;

// import com.example.oceanmod.OceanMod;
// import net.minecraft.core.Registry;
// import net.minecraft.core.registries.Registries;
// import net.minecraft.resources.ResourceKey;
// import net.minecraft.resources.ResourceLocation;
// import net.minecraft.world.level.biome.Biome;
// import net.minecraftforge.registries.DeferredRegister;
// import net.minecraftforge.registries.ForgeRegistries;
// import net.minecraftforge.registries.RegistryObject;
// import net.minecraftforge.fml.common.Mod;
// import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// public class ModBiomes {
//     public static final DeferredRegister<Biome> BIOMES =
//         DeferredRegister.create(ForgeRegistries.BIOMES, OceanMod.MOD_ID);

//     public static final ResourceKey<Biome> OPEN_OCEAN = ResourceKey.create(
//             Registries.BIOME, new ResourceLocation("oceanmod", "open_ocean")
//     );

//     public static void register() {
//         BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
//     }
// }

