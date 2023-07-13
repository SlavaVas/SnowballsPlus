package com.mao.snowballs_plus.items.snowballs;

import com.mao.snowballs_plus.entities.snowballs.FangsSnowballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FangsSnowballItem extends ModSnowballItem{
    public FangsSnowballItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        this.spawnSnowballEntity(world, user, hand, new FangsSnowballEntity(user, world), 0.0F, 1.5F, 1.0F);
        user.getItemCooldownManager().set(this, 10);
        return TypedActionResult.success(stack, world.isClient());
    }
}
