package com.example.oceanmod.client;

import com.example.oceanmod.OceanMod;
import com.example.oceanmod.entity.ModEntityTypes;
import com.example.oceanmod.entity.client.GenericSmallFishModel;
import com.example.oceanmod.entity.client.GenericSmallFishRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OceanMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityRenderers {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.GENERIC_SMALL_FISH.get(), GenericSmallFishRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GenericSmallFishModel.LAYER_LOCATION, GenericSmallFishModel::createBodyLayer);
    }
}
