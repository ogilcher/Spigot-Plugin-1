package com.disunion.dropper.listeners;

import com.disunion.dropper.manager.GameManager;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Clickables implements Listener {

    private final GameManager gameManager;


    public Clickables(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @EventHandler
    public void netherStarClick(PlayerInteractEvent e){
        Player player = e.getPlayer();

        if(player.getItemInHand().getType() == Material.NETHER_STAR){
            Inventory gui = gameManager.openGUI(player);

            player.openInventory(gui);
        }
    }
}
