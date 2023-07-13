package com.mao.snowballs_plus.entities.snowballs;

import com.mao.snowballs_plus.init.ModEntities;
import com.mao.snowballs_plus.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class MarkerSnowballEntity extends ModSnowballEntity {
    public MarkerSnowballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public MarkerSnowballEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.MARKER_SNOWBALL_ENTITY, livingEntity, world);
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
        BlockPos pos = new BlockPos(entityHitResult.getEntity().getBlockPos());
        Box box = new Box(pos).expand(8);
        for (LivingEntity livingEntity : world.getNonSpectatingEntities(LivingEntity.class, box)) {
            if (livingEntity instanceof MobEntity mob) {
                if (!(mob == entity)){
                    mob.setTarget((LivingEntity) entity);
                    entity.setGlowing(true);
                }
            }
        }
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
        return ModItems.MARKER_SNOWBALL_ITEM;
    }
}
