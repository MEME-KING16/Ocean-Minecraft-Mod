package com.example.oceanmod.entity.client;

import com.example.oceanmod.OceanMod;
import com.example.oceanmod.entity.GenericSmallFishEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class GenericSmallFishRenderer extends MobRenderer<GenericSmallFishEntity, GenericSmallFishModel<GenericSmallFishEntity>> {

    public GenericSmallFishRenderer(EntityRendererProvider.Context context) {
        super(context, new GenericSmallFishModel<>(context.bakeLayer(GenericSmallFishModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(GenericSmallFishEntity entity) {
        return new ResourceLocation(OceanMod.MOD_ID, "textures/entity/generic_small_fish.png");
    }
}
