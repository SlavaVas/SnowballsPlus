package com.mao.snowballs_plus.entities.snowballs;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModSnowballEntity extends ThrownItemEntity {
    public final World world = this.getWorld();

    public ModSnowballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ModSnowballEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world) {
        super(entityType, livingEntity, world);
    }
    @Override
    public void handleStatus(byte status) {
        if (status == 3) {
            for(int i = 0; i < 8; ++i) {
                this.getWorld().addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08);
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof BlazeEntity ? 5 : 2;
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), (float)i);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        BlockState state = this.getWorld().getBlockState(blockHitResult.getBlockPos());
        if (!this.getWorld().isClient) {
            if (state.getBlock() instanceof IceBlock) {
                getWorld().breakBlock(blockHitResult.getBlockPos(), true);
            }
        }
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    public void setBlockWithBlockBreakParticles(EntityHitResult entityHitResult, int height, Block block) {
        for (int j = 0; j < height; j++) {
            this.getWorld().setBlockState(new BlockPos(entityHitResult.getEntity().getBlockPos().getX() -1, entityHitResult.getEntity().getBlockPos().getY() +j, entityHitResult.getEntity().getBlockPos().getZ()), block.getDefaultState());
            this.getWorld().addBlockBreakParticles(new BlockPos(entityHitResult.getEntity().getBlockPos().getX() -1, entityHitResult.getEntity().getBlockPos().getY() +j, entityHitResult.getEntity().getBlockPos().getZ()), block.getDefaultState());
            this.getWorld().setBlockState(new BlockPos(entityHitResult.getEntity().getBlockPos().getX() +1, entityHitResult.getEntity().getBlockPos().getY() +j, entityHitResult.getEntity().getBlockPos().getZ()), block.getDefaultState());
            this.getWorld().addBlockBreakParticles(new BlockPos(entityHitResult.getEntity().getBlockPos().getX() +1, entityHitResult.getEntity().getBlockPos().getY() +j, entityHitResult.getEntity().getBlockPos().getZ()), block.getDefaultState());
            this.getWorld().setBlockState(new BlockPos(entityHitResult.getEntity().getBlockPos().getX(), entityHitResult.getEntity().getBlockPos().getY() +j, entityHitResult.getEntity().getBlockPos().getZ() -1), block.getDefaultState());
            this.getWorld().addBlockBreakParticles(new BlockPos(entityHitResult.getEntity().getBlockPos().getX(), entityHitResult.getEntity().getBlockPos().getY() +j, entityHitResult.getEntity().getBlockPos().getZ() -1), block.getDefaultState());
            this.getWorld().setBlockState(new BlockPos(entityHitResult.getEntity().getBlockPos().getX(), entityHitResult.getEntity().getBlockPos().getY() +j, entityHitResult.getEntity().getBlockPos().getZ() +1), block.getDefaultState());
            this.getWorld().addBlockBreakParticles(new BlockPos(entityHitResult.getEntity().getBlockPos().getX(), entityHitResult.getEntity().getBlockPos().getY() +j, entityHitResult.getEntity().getBlockPos().getZ() +1), block.getDefaultState());
            this.getWorld().setBlockState(new BlockPos(entityHitResult.getEntity().getBlockPos().getX(), entityHitResult.getEntity().getBlockPos().getY() +2, entityHitResult.getEntity().getBlockPos().getZ()), block.getDefaultState());
            this.getWorld().addBlockBreakParticles(new BlockPos(entityHitResult.getEntity().getBlockPos().getX(), entityHitResult.getEntity().getBlockPos().getY() +2, entityHitResult.getEntity().getBlockPos().getZ()), block.getDefaultState());
        }
    }
}
