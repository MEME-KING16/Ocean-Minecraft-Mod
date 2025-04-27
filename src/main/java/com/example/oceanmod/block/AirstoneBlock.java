package com.example.oceanmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class AirstoneBlock extends Block {

    public AirstoneBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onPlace(BlockState state, net.minecraft.world.level.Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!level.isClientSide) {
            level.scheduleTick(pos, this, 20); // Start ticking after 1 second
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        AABB area = new AABB(
            pos.getX() - 10, pos.getY() - 10, pos.getZ() - 10,
            pos.getX() + 10, pos.getY() + 10, pos.getZ() + 10
        );

        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, area);

        for (LivingEntity entity : entities) {
            entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 0, true, true));
        }

        level.scheduleTick(pos, this, 20); // Schedule next tick
    }
}
