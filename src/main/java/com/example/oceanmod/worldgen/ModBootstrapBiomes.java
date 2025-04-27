// package com.example.oceanmod.worldgen;

// import com.example.oceanmod.OceanMod;
// import net.minecraft.core.registries.Registries;
// import net.minecraft.data.worldgen.BootstapContext;
// import net.minecraft.resources.ResourceKey;
// import net.minecraft.resources.ResourceLocation;
// import net.minecraft.world.level.biome.Biome;

// public class ModBootstrapBiomes {

//     public static final ResourceKey<Biome> OPEN_OCEAN = ResourceKey.create(
//             Registries.BIOME, new ResourceLocation(OceanMod.MOD_ID, "open_ocean")
//     );

//     public static void bootstrap(BootstapContext<Biome> context) {
//         context.register(ModBiomes.OPEN_OCEAN, ModBiomeCreator.createOpenOceanBiome(context));
//     }
// }
