package com.example.oceanmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.particles.ParticleTypes;

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

        List<Player> players = level.getEntitiesOfClass(Player.class, area);

        for (Player player : players) {
            // Check if the player is underwater
            FluidState fluidState = level.getFluidState(player.blockPosition());
            if (fluidState.getType() == Fluids.WATER) {
                // Give Water Breathing
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 0, true, true));

                // Calculate start (block) and end (player) points
                double startX = pos.getX() + 0.5;
                double startY = pos.getY() + 0.5;
                double startZ = pos.getZ() + 0.5;

                double endX = player.getX();
                double endY = player.getY() + player.getBbHeight() / 2.0;
                double endZ = player.getZ();

                int particles = 20; // How many particles along the beam

                for (int i = 0; i <= particles; i++) {
                    double t = i / (double) particles;

                    double x = startX + (endX - startX) * t;
                    double y = startY + (endY - startY) * t;
                    double z = startZ + (endZ - startZ) * t;

                    level.sendParticles(
                        ParticleTypes.BUBBLE,
                        x, y, z,
                        1, // 1 particle at each point
                        0, 0, 0, // no random spread
                        0.01 // slow drift
                    );
                }
            }
        }

        level.scheduleTick(pos, this, 20); // Schedule next tick
    }
}
