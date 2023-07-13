package com.mao.snowballs_plus.items.snowballs;

import com.mao.snowballs_plus.entities.snowballs.ModSnowballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ModSnowballItem extends Item {

    public ModSnowballItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        this.spawnSnowballEntity(world, user, hand, new SnowballEntity(world, user), 0.0f, 1.5f, 1.0f);
        return TypedActionResult.success(stack, world.isClient());
    }

    public void spawnSnowballEntity(World world, PlayerEntity player, Hand hand, ThrownItemEntity entity, Float roll, Float speed, Float divergence) {
        ItemStack itemStack = player.getStackInHand(hand);
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            entity.setItem(itemStack);
            entity.setVelocity(player, player.getPitch(), player.getYaw(), roll, speed, divergence);
            world.spawnEntity(entity);
        }

        player.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!player.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
    }
}
