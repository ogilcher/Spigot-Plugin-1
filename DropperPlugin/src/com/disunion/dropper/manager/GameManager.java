package com.disunion.dropper.manager;

import com.disunion.dropper.DropperPlugin;
import com.disunion.dropper.commands.OpenGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import sun.plugin2.message.Message;

import java.util.ArrayList;

public class GameManager {

    //-- Instance Variables
    private final DropperPlugin plugin;
    public GameState gameState = GameState.LOBBY;
    private PlayerManager playerManager;


    //-- Constructor
    public GameManager(DropperPlugin plugin) {
        this.plugin = plugin;

        this.playerManager = new PlayerManager(this);

        // this.blockManager = new BlockManager(this);
    }

    public Inventory openGUI(Player player){

        Inventory gui = Bukkit.createInventory(player, 9, ChatColor.GRAY + "Map Menu");

        //-- Create each item for the inventory

        // Create a Spacer
        ItemStack space = new ItemStack(Material.AIR);

        // Add map1 Item
        ItemStack map1 = new ItemStack(Material.LOG);
        ItemMeta map1_meta = map1.getItemMeta();
        map1_meta.setDisplayName(ChatColor.GREEN + "Map 1");
        ArrayList<String> map1_lore = new ArrayList<>();
        map1_lore.add(ChatColor.GREEN + "[EASY]");
        map1_lore.add(ChatColor.GOLD + "Click to join Map 1!");
        map1_meta.setLore(map1_lore);
        map1.setItemMeta(map1_meta);

        // Add map2 Item
        ItemStack map2 = new ItemStack(Material.NETHERRACK);
        ItemMeta map2_meta = map2.getItemMeta();
        map2_meta.setDisplayName(ChatColor.RED + "Map 2");
        ArrayList<String> map2_lore = new ArrayList<>();
        map2_lore.add(ChatColor.GREEN + "[EASY]");
        map2_lore.add(ChatColor.GOLD + "Click to join Map 2!");
        map2_meta.setLore(map2_lore);
        map2.setItemMeta(map2_meta);

        // Add map3 Item
        ItemStack map3 = new ItemStack(Material.WOOL);
        ItemMeta map3_meta = map3.getItemMeta();
        map3_meta.setDisplayName(ChatColor.GRAY + "Map 3");
        ArrayList<String> map3_lore = new ArrayList<>();
        map3_lore.add(ChatColor.YELLOW + "[MEDIUM]");
        map3_lore.add(ChatColor.GOLD + "Click to join Map 3!");
        map3_meta.setLore(map3_lore);
        map3.setItemMeta(map3_meta);

        // Add map4 Item
        ItemStack map4 = new ItemStack(Material.WOOL, 1, (byte)6);
        ItemMeta map4_meta = map4.getItemMeta();
        map4_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Map 4");
        ArrayList<String> map4_lore = new ArrayList<>();
        map4_lore.add(ChatColor.YELLOW + "[MEDIUM]");
        map4_lore.add(ChatColor.GOLD + "Click to join Map 4!");
        map4_meta.setLore(map4_lore);
        map4.setItemMeta(map4_meta);

        // Add Exit Map Item
        ItemStack exit = new ItemStack(Material.BEDROCK);
        ItemMeta exit_meta = exit.getItemMeta();
        exit_meta.setDisplayName(ChatColor.RED + "QUIT");
        ArrayList<String> exit_lore = new ArrayList<>();
        exit_lore.add(ChatColor.GOLD + "Click to return to Hub!");
        exit_meta.setLore(exit_lore);
        exit.setItemMeta(exit_meta);

        // Add all the items to the menu and open the inventory
        ItemStack[] menu_items = {map1, space, map2, space, map3, space, map4, space, exit};
        gui.setContents(menu_items);

        return gui;
    }

    //-- Empty because there's no config files or file readings to be saved/cleaned up
    public void cleanup() {

    }

    //-- Getters & Setters
    public void setGameState(GameState gameState) {

        //
        if (this.gameState == GameState.ACTIVE && gameState == GameState.STARTING) return;
        this.gameState = gameState;

        switch(gameState) {
            case ACTIVE:
                Bukkit.broadcastMessage("Active!");
                break;
            case STARTING:
                Bukkit.broadcastMessage("Starting!");
                break;
            case WON:
                Bukkit.broadcastMessage("GAME OVER!");
                this.setGameState(GameState.LOBBY);
                break;
            case LOBBY:
                Bukkit.broadcastMessage("Sending you to the lobby!");
                break;

        }
    }
}
