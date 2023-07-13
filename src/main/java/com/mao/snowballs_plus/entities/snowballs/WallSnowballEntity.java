package com.mao.snowballs_plus.entities.snowballs;

import com.mao.snowballs_plus.init.ModEntities;
import com.mao.snowballs_plus.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WallSnowballEntity extends ModSnowballEntity {
    public WallSnowballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public WallSnowballEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.WALL_SNOWBALL_ENTITY, livingEntity, world);
    }

    @Override
    public void handleStatus(byte status) {
        super.handleStatus(status);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof BlazeEntity ? 2 : 0;
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), (float)i);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.setIceWithBlockBreakParticles(blockHitResult);
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.WALL_SNOWBALL_ITEM;
    }

    private void setIceWithBlockBreakParticles(BlockHitResult hitResult) {
        for (int j = 0; j < 4; j++) {
            this.world.setBlockState(new BlockPos(hitResult.getBlockPos().getX() +1, hitResult.getBlockPos().getY() +j, hitResult.getBlockPos().getZ()), Blocks.ICE.getDefaultState());
            this.world.playSound(hitResult.getBlockPos().getX() +1, hitResult.getBlockPos().getY() +j, hitResult.getBlockPos().getZ(), SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
            this.world.addBlockBreakParticles(new BlockPos(hitResult.getBlockPos().getX() +1, hitResult.getBlockPos().getY() +j, hitResult.getBlockPos().getZ()), Blocks.ICE.getDefaultState());
            this.world.setBlockState(new BlockPos(hitResult.getBlockPos().getX() +1, hitResult.getBlockPos().getY() +j, hitResult.getBlockPos().getZ() +1), Blocks.ICE.getDefaultState());
            this.world.playSound(hitResult.getBlockPos().getX() +1, hitResult.getBlockPos().getY() +j, hitResult.getBlockPos().getZ() +1, SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
            this.world.addBlockBreakParticles(new BlockPos(hitResult.getBlockPos().getX() +1, hitResult.getBlockPos().getY() +j, hitResult.getBlockPos().getZ() +1), Blocks.ICE.getDefaultState());
            this.world.setBlockState(new BlockPos(hitResult.getBlockPos().getX() +1, hitResult.getBlockPos().getY() +j, hitResult.getBlockPos().getZ() -1), Blocks.ICE.getDefaultState());
            this.world.playSound(hitResult.getBlockPos().getX() +1, hitResult.getBlockPos().getY() +j, hitResult.getBlockPos().getZ() -1, SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
            this.world.addBlockBreakParticles(new BlockPos(hitResult.getBlockPos().getX() +1, hitResult.getBlockPos().getY() +j, hitResult.getBlockPos().getZ() -1), Blocks.ICE.getDefaultState());
        }
    }
}
