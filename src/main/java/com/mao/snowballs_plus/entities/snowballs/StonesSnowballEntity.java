package com.mao.snowballs_plus.entities.snowballs;

import com.mao.snowballs_plus.init.ModEntities;
import com.mao.snowballs_plus.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class StonesSnowballEntity extends ModSnowballEntity{
    public StonesSnowballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public StonesSnowballEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.STONES_SNOWBALL_ENTITY, livingEntity, world);
    }

    @Override
    public void handleStatus(byte status) {
        super.handleStatus(status);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        BlockPos pos = new BlockPos(entityHitResult.getEntity().getBlockPos());
        Box box = new Box(pos).expand(2);
        for (LivingEntity living : world.getNonSpectatingEntities(LivingEntity.class, box)) {
            living.damage(this.getDamageSources().thrown(this, this.getOwner()), 1.5f);
            this.world.addBlockBreakParticles(living.getBlockPos(), Blocks.STONE.getDefaultState());
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.STONES_SNOWBALL_ITEM;
    }
}
