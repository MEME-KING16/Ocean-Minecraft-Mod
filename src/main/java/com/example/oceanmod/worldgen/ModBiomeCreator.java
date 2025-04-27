// package com.example.oceanmod.worldgen;

// import net.minecraft.core.HolderGetter;
// import net.minecraft.core.registries.Registries;
// import net.minecraft.data.worldgen.BootstapContext;
// import net.minecraft.world.level.biome.*;
// import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
// import net.minecraft.world.level.levelgen.placement.PlacedFeature;
// import net.minecraft.world.entity.MobCategory;
// import net.minecraft.world.entity.EntityType;
// import net.minecraft.data.worldgen.BiomeDefaultFeatures;

// public class ModBiomeCreator {

//     public static Biome createOpenOceanBiome(BootstapContext<Biome> context) {
//         HolderGetter<PlacedFeature> features = context.lookup(Registries.PLACED_FEATURE);
//         HolderGetter<ConfiguredWorldCarver<?>> carvers = context.lookup(Registries.CONFIGURED_CARVER);

//         BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
//                 .fogColor(0x0a0a28)
//                 .waterColor(0x022e4a)
//                 .waterFogColor(0x011627)
//                 .skyColor(0x000000)
//                 .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
//                 .build();

//         // Spawn settings (add fish here later)
//         MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//         BiomeDefaultFeatures.commonSpawns(spawnSettings);
//         // Spawn dolphins:
//         spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DOLPHIN, 5, 1, 2));

//         // Generation settings (ores, caves, etc.)
//         BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(features, carvers);
//         BiomeDefaultFeatures.addDefaultOres(generationSettings);
//         BiomeDefaultFeatures.addDefaultCarversAndLakes(generationSettings);

//         return new Biome.BiomeBuilder()
//                 .hasPrecipitation(true)
//                 .temperature(0.5f)
//                 .downfall(0.5f)
//                 .specialEffects(effects)
//                 .mobSpawnSettings(spawnSettings.build())
//                 .generationSettings(generationSettings.build())
//                 .temperatureAdjustment(Biome.TemperatureModifier.NONE)
//                 .build();
//     }
// }
