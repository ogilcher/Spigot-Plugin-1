package com.disunion.dropper.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;

public enum TeleportLocations {

    //-- List of enums
    Spawn (964, 4, 943),
    Map1 (1000, 56, 1002),
    Map2(1026, 56, 1002),
    Map3(1047, 56, 1002),
    Map4(1069, 56, 1002),
    Map5(1088, 56, 1002),
    Map6(1109, 56, 1002),
    Map7(1130, 56, 1002),
    Map8(1151, 56, 1002);

    //-- Instance Variables
    private final double x;
    private final double y;
    private final double z;

    //-- Constuctor
    TeleportLocations(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //-- Getters & Setters
    public Location getLocation(){

        return new Location(Bukkit.getWorlds().get(0), x, y, z);
    }
}
