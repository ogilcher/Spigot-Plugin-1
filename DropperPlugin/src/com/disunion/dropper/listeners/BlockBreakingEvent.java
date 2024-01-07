package com.disunion.dropper.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakingEvent implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        // Variables
        Player player = e.getPlayer();

        // If the player isn't opped
        if (!player.isOp()) {
            e.setCancelled(true);
            //player.sendMessage("You cannot break blocks");
        }
    }
}
