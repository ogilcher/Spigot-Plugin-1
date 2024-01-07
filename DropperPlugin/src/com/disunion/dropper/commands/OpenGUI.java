package com.disunion.dropper.commands;

import com.disunion.dropper.manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OpenGUI implements CommandExecutor {

    private GameManager gameManager;

    public OpenGUI(GameManager gameManager){
        this.gameManager = gameManager;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            Inventory gui = gameManager.openGUI(player);

            player.openInventory(gui);
        }
        return false;
    }
}
