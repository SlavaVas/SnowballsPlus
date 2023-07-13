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
import net.minecraft.world.World;

public class FortressSnowballEntity extends ModSnowballEntity {
    public FortressSnowballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public FortressSnowballEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.FORTRESS_SNOWBALL_ENTITY, livingEntity, world);
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
        this.getWorld().playSound(entityHitResult.getEntity().getBlockPos().getX(), entityHitResult.getEntity().getBlockPos().getY(), entityHitResult.getEntity().getBlockPos().getZ(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
        this.setBlockWithBlockBreakParticles(entityHitResult, 2, Blocks.FROSTED_ICE.getDefaultState().getBlock());
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
    public Item getDefaultItem() {
        return ModItems.FORTRESS_SNOWBALL_ITEM;
    }
}
