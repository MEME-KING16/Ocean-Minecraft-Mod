package com.example.oceanmod.effect;

import net.minecraft.server.level.ServerLevel;
import com.example.oceanmod.damage.ModDamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;

public class RustEffect extends MobEffect {
    public RustEffect() {
        super(MobEffectCategory.HARMFUL, 0x9c7644); // Color = brownish rust
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide()) {
            ServerLevel serverLevel = (ServerLevel) entity.level();
            entity.hurt(ModDamageTypes.rust(serverLevel), 1.0F + amplifier);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true; // Tick every tick
    }
}
