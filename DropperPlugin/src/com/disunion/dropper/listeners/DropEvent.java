package com.disunion.dropper.listeners;

import com.disunion.dropper.manager.GameManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvent implements Listener {

    //-- Instance Variables
    final GameManager gameManager;

    //-- Constructor
    public DropEvent(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @EventHandler
    public void dropEvent(PlayerDropItemEvent e){

        // make it so the player can't drop any items
        Player player = e.getPlayer();
        e.setCancelled(true);
    }
}
