package com.mao.snowballs_plus;

import com.mao.snowballs_plus.events.ServerWorldTickEventHandle;
import com.mao.snowballs_plus.init.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnowballsPlus implements ModInitializer {
    public static final String MOD_ID = "snowballs_plus";
    public static final Logger LOGGER = LoggerFactory.getLogger(SnowballsPlus.class);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModItemGroup.registerModItemGroup();
        ModEntities.registerModEntities();
        ServerTickEvents.START_WORLD_TICK.register(new ServerWorldTickEventHandle());
        LOGGER.info("Welcome to SnowballsPlus Mod");
    }
}
