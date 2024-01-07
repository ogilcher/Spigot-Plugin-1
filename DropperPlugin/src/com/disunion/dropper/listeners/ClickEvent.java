package com.disunion.dropper.listeners;

import com.disunion.dropper.manager.GameManager;
import com.disunion.dropper.manager.GameState;
import com.disunion.dropper.manager.TeleportLocations;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent implements Listener {

    private GameManager gameManager;
    private TeleportLocations teleportLocations;

    public ClickEvent(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        //-- Instance Variables
        Player player = (Player) e.getWhoClicked();

        // Handles what each item in our Map Menu GUI does
        if(e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.GRAY + "Map Menu")){



            switch(e.getCurrentItem().getType()){
                case LOG:

                    // get an enum to use
                    TeleportLocations map1 = TeleportLocations.Map1;

                    player.closeInventory();
                    gameManager.setGameState(GameState.ACTIVE);
                    player.teleport(map1.getLocation());
                    player.setBedSpawnLocation(map1.getLocation(), true);
                    break;

                case NETHERRACK:

                    // get an enum to use
                    TeleportLocations map2 = TeleportLocations.Map2;

                    player.closeInventory();
                    gameManager.setGameState(GameState.ACTIVE);
                    player.teleport(map2.getLocation());
                    player.setBedSpawnLocation(map2.getLocation(), true);
                    break;

                case WOOL:
                    // get an enum to use
                    TeleportLocations map3 = TeleportLocations.Map3;

                    player.closeInventory();
                    gameManager.setGameState(GameState.ACTIVE);
                    player.teleport(map3.getLocation());
                    player.setBedSpawnLocation(map3.getLocation(), true);
                    break;

                case BEDROCK:
                    // get an enum to use
                    TeleportLocations spawn = TeleportLocations.Spawn;

                    player.closeInventory();
                    gameManager.setGameState(GameState.LOBBY);
                    player.teleport(spawn.getLocation());
                    player.setBedSpawnLocation(spawn.getLocation());
                    break;

                default:
                    player.sendMessage("Something isn't working");
                    break;
            }


            // removes the ability for the player to remove items from the gui
            e.setCancelled(true);
        }



    }
}
