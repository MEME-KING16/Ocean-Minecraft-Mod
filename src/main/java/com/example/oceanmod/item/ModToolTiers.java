package com.example.oceanmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

public class ModToolTiers {

    public static final Tier RUSTED = new Tier() {
        @Override
        public int getUses() {
            return 225; // durability
        }

        @Override
        public float getSpeed() {
            return 5.0F; // mining speed
        }

        @Override
        public float getAttackDamageBonus() {
            return 0.0F; // extra damage
        }

        @Override
        public int getLevel() {
            return 2; // mining level (2 = iron)
        }

        @Override
        public int getEnchantmentValue() {
            return 15; // enchantability
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.EMPTY;
        }
    };
}
