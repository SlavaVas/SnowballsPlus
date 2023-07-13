package com.mao.snowballs_plus.entities.snowballs;

import com.mao.snowballs_plus.init.ModEntities;
import com.mao.snowballs_plus.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class FangsSnowballEntity extends ModSnowballEntity{
    public FangsSnowballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public FangsSnowballEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.FANGS_SNOWBALL_ENTITY, livingEntity, world);
    }

    @Override
    public void handleStatus(byte status) {
        super.handleStatus(status);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        double d = Math.min(entity.getY(), this.getOwner().getY());
        double e = Math.max(entity.getY(), this.getOwner().getY()) + 1.0;
        float f = (float)MathHelper.atan2(entity.getZ() - this.getZ(), entity.getX() - this.getX());
        int i;
        float g;
        for(i = 0; i < 5; ++i) {
            g = f + (float)i * 3.1415927F * 0.4F;
            this.conjureFangs(entity.getX() + (double)MathHelper.cos(g) * 0.65, entity.getZ() + (double)MathHelper.sin(g) * 0.65, d, e, g, 0);
        }
        for(i = 0; i < 8; ++i) {
            g = f + (float) i * 3.1415927F * 0.4F;
            this.conjureFangs(entity.getX() + (double) MathHelper.cos(g) * 1.5, entity.getZ() + (double) MathHelper.sin(g) * 1.5, d, e, g, 0);
        }
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.FANGS_SNOWBALL_ITEM;
    }

    private void conjureFangs(double x, double z, double maxY, double y, float yaw, int warmup) {
        BlockPos blockPos = BlockPos.ofFloored(x, y, z);
        boolean bl = false;
        double d = 0.0;

        do {
            BlockPos blockPos2 = blockPos.down();
            BlockState blockState = this.getWorld().getBlockState(blockPos2);
            if (blockState.isSideSolidFullSquare(this.getWorld(), blockPos2, Direction.UP)) {
                if (!this.getWorld().isAir(blockPos)) {
                    BlockState blockState2 = this.getWorld().getBlockState(blockPos);
                    VoxelShape voxelShape = blockState2.getCollisionShape(this.getWorld(), blockPos);
                    if (!voxelShape.isEmpty()) {
                        d = voxelShape.getMax(Direction.Axis.Y);
                    }
                }

                bl = true;
                break;
            }

            blockPos = blockPos.down();
        } while(blockPos.getY() >= MathHelper.floor(maxY) - 1);

        if (bl) {
            this.getWorld().spawnEntity(new EvokerFangsEntity(this.getWorld(), x, (double)blockPos.getY() + d, z, yaw, warmup,  (LivingEntity) this.getOwner()));
        }

    }
}
