package com.mao.snowballs_plus.init;

import com.mao.snowballs_plus.SnowballsPlus;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static void registerModItemGroup(){
        Registry.register(Registries.ITEM_GROUP, new Identifier(SnowballsPlus.MOD_ID, "mod_item_group"), ITEM_GROUP);

    }
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.ICE_SNOWBALL_ITEM))
            .displayName(Text.translatable("itemGroup.snowballs_plus.mod_item_group"))
            .entries((displayContext, entries) -> {
                entries.add(new ItemStack(ModItems.ICE_SNOWBALL_ITEM));
                entries.add(new ItemStack(ModItems.STONES_SNOWBALL_ITEM));
                entries.add(new ItemStack(ModItems.AMETHYST_SNOWBALL_ITEM));
                entries.add(new ItemStack(ModItems.SMALL_SNOWBALL_ITEM));
                entries.add(new ItemStack(ModItems.WALL_SNOWBALL_ITEM));
                entries.add(new ItemStack(ModItems.FORTRESS_SNOWBALL_ITEM));
                entries.add(new ItemStack(ModItems.HEALTHY_SNOWBALL_ITEM));
                entries.add(new ItemStack(ModItems.SUCTION_SNOWBALL_ITEM));
                entries.add(new ItemStack(ModItems.MARKER_SNOWBALL_ITEM));
                entries.add(new ItemStack(ModItems.FANGS_SNOWBALL_ITEM));
                entries.add(new ItemStack(ModItems.BLOODTHIRSTY_SNOWBALL_ITEM));
            })
            .build();
}
