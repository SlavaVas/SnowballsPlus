package com.mao.snowballs_plus.items.snowballs;


import com.mao.snowballs_plus.entities.snowballs.MarkerSnowballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MarkerSnowballItem extends ModSnowballItem {
    public MarkerSnowballItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        this.spawnSnowballEntity(world, user, hand, new MarkerSnowballEntity(user, world), 0.0f, 1.5f, 1.0f);
        return TypedActionResult.success(stack, world.isClient());
    }
}
