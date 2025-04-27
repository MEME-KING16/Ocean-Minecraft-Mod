package com.example.oceanmod.event;

import com.example.oceanmod.entity.ModEntityTypes;
import com.example.oceanmod.entity.GenericSmallFishEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = com.example.oceanmod.OceanMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.GENERIC_SMALL_FISH.get(), GenericSmallFishEntity.createAttributes().build());
    }
}
