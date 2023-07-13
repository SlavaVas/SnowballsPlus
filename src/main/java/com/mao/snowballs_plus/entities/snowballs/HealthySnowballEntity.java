package com.mao.snowballs_plus.entities.snowballs;

import com.mao.snowballs_plus.init.ModEntities;
import com.mao.snowballs_plus.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class HealthySnowballEntity extends ModSnowballEntity {

    public HealthySnowballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public HealthySnowballEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.HEALTHY_SNOWBALL_ENTITY, livingEntity, world);
    }

    @Override
    public void handleStatus(byte status) {
        super.handleStatus(status);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof HostileEntity ? 5 : 0;
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), (float)i);
        if (entity instanceof PlayerEntity player){
            if (player.getHealth() <= 15) {
                player.setHealth(15.0f);
                for(int j = 0; j < 3; ++j) {
                    this.addHeartParticle();
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
        return ModItems.HEALTHY_SNOWBALL_ITEM;
    }

    private void addHeartParticle() {
        double d = this.random.nextGaussian() * 0.06;
        double e = this.random.nextGaussian() * 0.06;
        double f = this.random.nextGaussian() * 0.06;
        this.world.addParticle(ParticleTypes.HEART, this.getParticleX(1.0), this.getRandomBodyY() + 0.5, this.getParticleZ(1.0), d, e, f);
    }
}
