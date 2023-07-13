package com.mao.snowballs_plus;

import com.mao.snowballs_plus.init.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class SnowballsPlusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.ICE_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.WALL_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FORTRESS_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.MARKER_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.HEALTHY_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SUCTION_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.STONES_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FANGS_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SMALL_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.AMETHYST_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.BLOODTHIRSTY_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
        /*
        BlockEntityRenderer
        */
    }
}
