package com.example.oceanmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class RandomEffectItem extends Item {

    public RandomEffectItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide) {
            Random random = new Random();

            // Good effects
            MobEffectInstance[] goodEffects = new MobEffectInstance[]{
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0),
                new MobEffectInstance(MobEffects.REGENERATION, 200, 0),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0),
                new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0)
            };

            // Bad effects
            MobEffectInstance[] badEffects = new MobEffectInstance[]{
                new MobEffectInstance(MobEffects.POISON, 200, 0),
                new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1),
                new MobEffectInstance(MobEffects.WEAKNESS, 200, 0),
                new MobEffectInstance(MobEffects.CONFUSION, 200, 0) // Nausea effect
            };

            // 70% chance good, 30% chance bad
            if (random.nextFloat() < 0.7f) {
                MobEffectInstance effect = goodEffects[random.nextInt(goodEffects.length)];
                entity.addEffect(effect);
            } else {
                MobEffectInstance effect = badEffects[random.nextInt(badEffects.length)];
                entity.addEffect(effect);
            }
        }

        return super.finishUsingItem(stack, level, entity);
    }
}
