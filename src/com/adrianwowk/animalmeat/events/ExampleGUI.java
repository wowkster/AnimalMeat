package com.adrianwowk.animalmeat.events;

import com.adrianwowk.animalmeat.items.CustomMeat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ExampleGUI implements Listener {
    private final Inventory inv;

    public ExampleGUI() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, InventoryType.CHEST, "Animal Meat");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.setItem(0, CustomMeat.RAW_DOG.getItem());
        inv.setItem(1, CustomMeat.RAW_HORSE.getItem());
        inv.setItem(2, CustomMeat.RAW_CAT.getItem());
        inv.setItem(3, CustomMeat.RAW_PARROT.getItem());

        inv.setItem(5, CustomMeat.COOKED_DOG.getItem());
        inv.setItem(6, CustomMeat.COOKED_HORSE.getItem());
        inv.setItem(7, CustomMeat.COOKED_CAT.getItem());
        inv.setItem(8, CustomMeat.COOKED_PARROT.getItem());

        inv.setItem(18, new ItemStack(Material.BEEF));
        inv.setItem(19, new ItemStack(Material.MUTTON));
        inv.setItem(20, new ItemStack(Material.RABBIT));
        inv.setItem(21, new ItemStack(Material.CHICKEN));

        inv.setItem(23, new ItemStack(Material.COOKED_BEEF));
        inv.setItem(24, new ItemStack(Material.COOKED_MUTTON));
        inv.setItem(25, new ItemStack(Material.COOKED_RABBIT));
        inv.setItem(26, new ItemStack(Material.COOKED_CHICKEN));
    }

    // Nice little method to create a gui item with a custom name, and description
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    public Inventory getInv(){
        return inv;
    }

}