package com.mao.snowballs_plus.events;


import com.mao.snowballs_plus.items.snowballs.ModSnowballItem;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;


public class ServerWorldTickEventHandle implements ServerTickEvents.StartWorldTick{
    @Override
    public void onStartTick(ServerWorld world) {
        world.getPlayers().forEach(player -> {
            ItemStack stack1 = player.getOffHandStack();
            for (ItemStack stack : player.getInventory().main) {
                if (world.getBiome(player.getBlockPos()).isIn(BiomeTags.SNOW_GOLEM_MELTS)) {
                    if (stack.getItem() instanceof ModSnowballItem && !(stack1.isOf(Items.ICE))|| stack.isOf(Items.SNOWBALL) && !(stack1.isOf(Items.ICE))) {
                        stack.decrement(1);
                        player.sendMessage(Text.translatable("text.player.tips"), true);
                    }
                }
            }
        });
    }
}
