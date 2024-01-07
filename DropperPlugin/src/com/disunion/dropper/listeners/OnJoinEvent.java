package com.disunion.dropper.listeners;

import com.disunion.dropper.manager.GameManager;
import com.disunion.dropper.manager.TeleportLocations;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OnJoinEvent implements Listener {

    //-- Instance Variables
    final GameManager gameManager;
    final TeleportLocations spawnLocation;

    public OnJoinEvent(GameManager gameManager){
        this.gameManager = gameManager;
        this.spawnLocation = TeleportLocations.Spawn;
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        //-- Set Player in correct position
        player.sendMessage("welcome to the server");
        player.teleport(TeleportLocations.Spawn.getLocation());

        //-- Set Player with correct items
        player.getInventory().clear();

        ItemStack mapSelector = new ItemStack(Material.NETHER_STAR);
        ItemMeta mapSelector_meta = mapSelector.getItemMeta();
        mapSelector_meta.setDisplayName(ChatColor.GOLD + "Map Selector (Right Click)");
        mapSelector.setItemMeta(mapSelector_meta);

        player.getInventory().addItem(mapSelector);
        player.updateInventory();
    }

}
