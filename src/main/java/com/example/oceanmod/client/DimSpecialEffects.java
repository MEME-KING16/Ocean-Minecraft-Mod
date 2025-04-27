//  package com.example.oceanmod.client;

//  import net.minecraft.client.renderer.DimensionSpecialEffects;
//  import net.minecraft.client.multiplayer.ClientLevel;
//  import net.minecraft.world.phys.Vec3;

//  public class DimSpecialEffects extends DimensionSpecialEffects {

//      public DimSpecialEffects() {
//          super(256, // cloud height
//                false, // has ground
//                SkyType.NORMAL, // type of sky
//                false, // has weather
//                true); // has thick fog
//      }

//      @Override
//      public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
//          return color;
//      }

//      public Vec3 getSkyColor(ClientLevel level, float partialTicks) {
//          Vec3 colorStart = new Vec3(0.54f, 0.54f, 0.63f);
//          Vec3 colorEnd = new Vec3(0f, 0f, 0.07f);
//          float blend = (float) (Math.sin(partialTicks * Math.PI * 2) * 0.5 + 0.5);
//          return colorStart.lerp(colorEnd, blend);
//      }

//      @Override
//      public boolean isFoggyAt(int x, int z) {
//        return false;
//      }
//  }
