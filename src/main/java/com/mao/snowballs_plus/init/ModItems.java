package com.mao.snowballs_plus.init;

import com.mao.snowballs_plus.SnowballsPlus;
import com.mao.snowballs_plus.items.snowballs.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final IceSnowballItem ICE_SNOWBALL_ITEM = (IceSnowballItem) registryItems("ice_snowball", new IceSnowballItem(new Item.Settings().maxCount(16)));
    public static final WallSnowballItem WALL_SNOWBALL_ITEM = (WallSnowballItem) registryItems("wall_snowball", new WallSnowballItem(new Item.Settings().maxCount(16)));
    public static final FortressSnowballItem FORTRESS_SNOWBALL_ITEM = (FortressSnowballItem) registryItems("fortress_snowball", new FortressSnowballItem(new Item.Settings().maxCount(16)));
    public static final MarkerSnowballItem MARKER_SNOWBALL_ITEM = (MarkerSnowballItem) registryItems("marker_snowball", new MarkerSnowballItem(new Item.Settings().maxCount(16)));
    public static final HealthySnowballItem HEALTHY_SNOWBALL_ITEM = (HealthySnowballItem) registryItems("healthy_snowball", new HealthySnowballItem(new Item.Settings().maxCount(16)));
    public static final SuctionSnowballItem SUCTION_SNOWBALL_ITEM = (SuctionSnowballItem) registryItems("suction_snowball", new SuctionSnowballItem(new Item.Settings().maxCount(16)));
    public static final StonesSnowballItem STONES_SNOWBALL_ITEM = (StonesSnowballItem) registryItems("stones_snowball", new StonesSnowballItem(new Item.Settings().maxCount(16)));
    public static final FangsSnowballItem FANGS_SNOWBALL_ITEM = (FangsSnowballItem) registryItems("fangs_snowball", new FangsSnowballItem(new Item.Settings().maxCount(16)));
    public static final SmallSnowballItem SMALL_SNOWBALL_ITEM = (SmallSnowballItem) registryItems("small_snowball", new SmallSnowballItem(new Item.Settings().maxCount(32)));
    public static final AmethystSnowballItem AMETHYST_SNOWBALL_ITEM = (AmethystSnowballItem) registryItems("amethyst_snowball", new AmethystSnowballItem(new Item.Settings().maxCount(16)));
    public static final BloodthirstySnowballItem BLOODTHIRSTY_SNOWBALL_ITEM = (BloodthirstySnowballItem) registryItems("bloodthirsty_snowball", new BloodthirstySnowballItem(new Item.Settings().maxCount(16)));

    private static Item registryItems(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SnowballsPlus.MOD_ID, name), item);
    }

    private static Item registryBlockItems(String name, BlockItem item) {
        return Registry.register(Registries.ITEM, new Identifier(SnowballsPlus.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SnowballsPlus.LOGGER.debug("Registering Mod Items for " + SnowballsPlus.MOD_ID);
    }
}
