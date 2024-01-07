package com.disunion.dropper.listeners;

import com.disunion.dropper.manager.GameManager;
import com.disunion.dropper.manager.GameState;
import com.disunion.dropper.manager.TeleportLocations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class LandWaterListener implements Listener {

    //-- Instance Variables
    private GameManager gameManager;

    //-- Constructor
    public LandWaterListener(GameManager gameManager){
        this.gameManager = gameManager;
    }

    //-- Method for when a player hits the water
    // In this instant, we want to kill the player if they land on anything but air and water so they
    // teleport back to the top
    @EventHandler
    public void onPlayerWalkOnWater(PlayerMoveEvent e) throws InterruptedException {

        // Only run this code if the game is actually running
        if(gameManager.gameState == GameState.ACTIVE) {
            // Variables
            Player player = e.getPlayer();
            int x = player.getLocation().getBlockX();
            int y = player.getLocation().getBlockY();
            int z = player.getLocation().getBlockZ();

            // get what block the player is standing on
            Material block = player.getWorld().getBlockAt(x, y - 1, z).getType();

            if (player.getLocation().getY() <= 50 && block != Material.AIR && block != Material.STATIONARY_WATER) {
                player.teleport(player.getBedSpawnLocation());
                player.setHealth(20);
            } else if (block == Material.STATIONARY_WATER){

                player.sendMessage(ChatColor.GREEN + "You Made it! You will be teleported in 10s!");
                Thread.sleep(10000);

                TeleportLocations spawn = TeleportLocations.Spawn;
                player.teleport(spawn.getLocation());
                player.setBedSpawnLocation(spawn.getLocation(), true);
                gameManager.setGameState(GameState.WON);
            }
        }
    }

    @EventHandler
    public void onPlayerFallDamage(EntityDamageEvent e){
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL){
            e.setCancelled(true);
        }
    }
}