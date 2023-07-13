package com.mao.snowballs_plus.init;

import com.mao.snowballs_plus.SnowballsPlus;
import com.mao.snowballs_plus.entities.snowballs.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<IceSnowballEntity> ICE_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "ice_snowball"),
            FabricEntityTypeBuilder.<IceSnowballEntity>create(SpawnGroup.MISC, IceSnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f,0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
            );

    public static final EntityType<WallSnowballEntity> WALL_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "wall_snowball"),
            FabricEntityTypeBuilder.<WallSnowballEntity>create(SpawnGroup.MISC, WallSnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
            );

    public static final EntityType<FortressSnowballEntity> FORTRESS_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "fortress_snowball"),
            FabricEntityTypeBuilder.<FortressSnowballEntity>create(SpawnGroup.MISC, FortressSnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<MarkerSnowballEntity> MARKER_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "marker_snowball"),
            FabricEntityTypeBuilder.<MarkerSnowballEntity>create(SpawnGroup.MISC, MarkerSnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<HealthySnowballEntity> HEALTHY_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "healthy_snowball"),
            FabricEntityTypeBuilder.<HealthySnowballEntity>create(SpawnGroup.MISC, HealthySnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<SuctionSnowballEntity> SUCTION_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "suction_snowball"),
            FabricEntityTypeBuilder.<SuctionSnowballEntity>create(SpawnGroup.MISC, SuctionSnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<StonesSnowballEntity> STONES_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "stones_snowball"),
            FabricEntityTypeBuilder.<StonesSnowballEntity>create(SpawnGroup.MISC, StonesSnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<FangsSnowballEntity> FANGS_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "fangs_snowball"),
            FabricEntityTypeBuilder.<FangsSnowballEntity>create(SpawnGroup.MISC, FangsSnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<SmallSnowballEntity> SMALL_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "small_snowball"),
            FabricEntityTypeBuilder.<SmallSnowballEntity>create(SpawnGroup.MISC, SmallSnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<AmethystSnowballEntity> AMETHYST_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "amethyst_snowball"),
            FabricEntityTypeBuilder.<AmethystSnowballEntity>create(SpawnGroup.MISC, AmethystSnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<BloodthirstySnowballEntity> BLOODTHIRSTY_SNOWBALL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SnowballsPlus.MOD_ID, "bloodthirsty_snowball"),
            FabricEntityTypeBuilder.<BloodthirstySnowballEntity>create(SpawnGroup.MISC, BloodthirstySnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static void registerModEntities() {
        SnowballsPlus.LOGGER.debug("Registering Mod Entities for " + SnowballsPlus.MOD_ID);
    }
}
