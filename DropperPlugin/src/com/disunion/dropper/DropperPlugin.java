package com.disunion.dropper;

import com.disunion.dropper.commands.OpenGUI;
import com.disunion.dropper.commands.StartCommand;
import com.disunion.dropper.commands.StopCommand;
import com.disunion.dropper.listeners.*;
import com.disunion.dropper.manager.GameManager;
import com.disunion.dropper.manager.GameState;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class DropperPlugin extends JavaPlugin {

    //-- Instance variables
    private GameManager gameManager;

    @Override
    public void onEnable(){
        super.onEnable();

        // Initiate Game manager and pass it through our Listeners to be able to use its properties
        this.gameManager = new GameManager(this);
        getServer().getPluginManager().registerEvents(new LandWaterListener(gameManager), this);
        getServer().getPluginManager().registerEvents(new ClickEvent(gameManager), this);
        getServer().getPluginManager().registerEvents(new DropEvent(gameManager), this);
        getServer().getPluginManager().registerEvents(new BlockBreakingEvent(), this);
        getServer().getPluginManager().registerEvents(new OnJoinEvent(gameManager), this);
        getServer().getPluginManager().registerEvents(new Clickables(gameManager), this);


        // Initiate Command
        getCommand("openGUI").setExecutor(new OpenGUI(gameManager));
        getCommand("start").setExecutor(new StartCommand(gameManager));
        getCommand("endgame").setExecutor(new StopCommand(gameManager));

        // Notify the log to be able to tell when the Plugin has successfully loaded
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Dropper Plugin is enabled!");
    }

    @Override
    public void onDisable(){
        super.onDisable();

        gameManager.cleanup();
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Dropper Plugin is disabled!");
    }
}
