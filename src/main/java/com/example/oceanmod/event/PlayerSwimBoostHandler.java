// package com.example.oceanmod.event;

// import com.example.oceanmod.worldgen.ModBootstrapBiomes;
// import net.minecraft.world.effect.MobEffects;
// import net.minecraft.world.entity.player.Player;
// import net.minecraft.world.level.biome.Biome;
// import net.minecraft.world.effect.MobEffectInstance;
// import net.minecraftforge.api.distmarker.Dist;
// import net.minecraftforge.event.TickEvent;
// import net.minecraftforge.eventbus.api.SubscribeEvent;
// import net.minecraftforge.fml.common.Mod;
// import net.minecraftforge.registries.ForgeRegistries;

// @Mod.EventBusSubscriber(value = Dist.CLIENT)
// public class PlayerSwimBoostHandler {

//     @SubscribeEvent
//     public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//         if (event.phase == TickEvent.Phase.END) {
//             Player player = event.player;
//             if (player.isInWater()) {
//                 Biome currentBiome = player.level().getBiome(player.blockPosition()).value();
//                 if (ForgeRegistries.BIOMES.getKey(currentBiome).equals(ModBootstrapBiomes.OPEN_OCEAN.location())) {
//                     if (!player.hasEffect(MobEffects.DOLPHINS_GRACE)) {
//                         player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 0, true, false));
//                     }
//                 }
//             }
//         }
//     }
// }
