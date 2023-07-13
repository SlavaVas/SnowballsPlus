package com.mao.snowballs_plus.items.snowballs;

import com.mao.snowballs_plus.entities.snowballs.BloodthirstySnowballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BloodthirstySnowballItem extends ModSnowballItem{
    public BloodthirstySnowballItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        this.spawnSnowballEntity(world, user, hand, new BloodthirstySnowballEntity(user, world), 0.0F, 1.5F, 1.0F);
        return TypedActionResult.success(stack, world.isClient());
    }
}
