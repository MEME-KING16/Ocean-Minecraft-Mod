package com.example.oceanmod.client;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import com.example.oceanmod.OceanMod;



 

@Mod.EventBusSubscriber(modid = OceanMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    // public static void registerEffects(RegisterDimensionSpecialEffectsEvent event) {
    //     event.register(new ResourceLocation("oceanmod", "dim_effects"), new DimSpecialEffects());
    // }
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(
                OceanMod.SEA_GLASS_GREEN_BLOCK.get(),
                RenderType.translucent()
            );
            ItemBlockRenderTypes.setRenderLayer(
                OceanMod.SEA_GLASS_RED_BLOCK.get(),
                RenderType.translucent()
            );
        });
    }
}
