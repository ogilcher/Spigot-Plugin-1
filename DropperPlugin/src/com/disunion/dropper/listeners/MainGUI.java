//package com.disunion.dropper.listeners;
//
//import com.disunion.dropper.manager.GameManager;
//import org.bukkit.Bukkit;
//import org.bukkit.Material;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.inventory.InventoryClickEvent;
//import org.bukkit.event.inventory.InventoryDragEvent;
//import org.bukkit.inventory.Inventory;
//import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.meta.ItemMeta;
//
//import java.util.Arrays;
//
//public class MainGUI implements Listener {
//
//    //-- Instance Variables
//    private Inventory inv;
//    //private GameManager gameManager;
//
//    //-- Constructor
//    public MainGUI(){
//
//        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
//        inv = Bukkit.createInventory(null, 9, "Example");
//
//        initializeItems();
//    }
//
//    public void initializeItems() {
//
//        inv.addItem(createGuiItem(Material.DIAMOND_SWORD, "Example Sword", "§aFirst line of the lore", "§bSecond line of the lore"));
//        inv.addItem(createGuiItem(Material.IRON_HELMET, "§bExample Helmet", "§aFirst line of the lore", "§bSecond line of the lore"));
//    }
//
//    // Nice little method to create a gui item with a custom name, and description
//    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
//        final ItemStack item = new ItemStack(material, 1);
//        final ItemMeta meta = item.getItemMeta();
//
//        // Set the name of the item
//        meta.setDisplayName(name);
//
//        // Set the lore of the item
//        meta.setLore(Arrays.asList(lore));
//
//        item.setItemMeta(meta);
//
//        return item;
//    }
//
//    public void openInventory(Player player) {
//        player.openInventory(inv);
//    }
//
//    // Check for clicks on items
//    @EventHandler
//    public void onInventoryClick(InventoryClickEvent e) {
//        if (!e.getInventory().equals(inv)) return;
//
//        e.setCancelled(true);
//
//        final ItemStack clickedItem = e.getCurrentItem();
//
//        // verify current item is not null
//        if (clickedItem == null || !clickedItem.getType().isBlock()) return;
//
//        final Player p = (Player) e.getWhoClicked();
//
//        // Using slots click is a best option for your inventory click's
//        p.sendMessage("You clicked at slot " + e.getRawSlot());
//    }
//
//    // Cancel dragging in our inventory
//    @EventHandler
//    public void onInventoryClick(InventoryDragEvent e) {
//        if (e.getInventory().equals(inv)) {
//            e.setCancelled(true);
//        }
//    }
//}