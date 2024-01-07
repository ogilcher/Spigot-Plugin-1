package com.disunion.dropper.commands;

import com.disunion.dropper.manager.GameManager;
import com.disunion.dropper.manager.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopCommand implements CommandExecutor {

    //-- Instance Variables
    final GameManager gameManager;

    //-- Constructor
    public StopCommand(GameManager gameManager){
        this.gameManager = gameManager;
    }

    //-- Command Execution
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        gameManager.setGameState(GameState.WON);
        return false;
    }
}
