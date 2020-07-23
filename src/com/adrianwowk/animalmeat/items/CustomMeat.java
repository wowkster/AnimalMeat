package com.adrianwowk.animalmeat.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum CustomMeat {
    RAW_DOG(makeItemStack(Material.BEEF, "Raw Dog Meat")),
    COOKED_DOG(makeItemStack(Material.COOKED_BEEF, "Cooked Dog Meat")),
    RAW_HORSE(makeItemStack(Material.MUTTON, "Raw Horse Meat")),
    COOKED_HORSE(makeItemStack(Material.COOKED_MUTTON, "Cooked Horse Meat")),
    RAW_CAT(makeItemStack(Material.RABBIT, "Raw Cat Meat")),
    COOKED_CAT(makeItemStack(Material.COOKED_RABBIT, "Cooked Cat Meat")),
    RAW_PARROT(makeItemStack(Material.CHICKEN, "Raw Parrot Meat")),
    COOKED_PARROT(makeItemStack(Material.COOKED_CHICKEN, "Cooked Parrot Meat"));

    private final ItemStack item;

    CustomMeat(ItemStack value) {
        this.item = value;
    }

    public ItemStack getItem() {
        return item;
    }

    private static ItemStack makeItemStack(Material mat, String name) {
        ItemStack meat = new ItemStack(mat, 1);
        ItemMeta meatLabel = meat.getItemMeta();
        assert meatLabel != null;
        meatLabel.setDisplayName(ChatColor.GOLD + name);

        switch (mat) {
            case BEEF:
                meatLabel.setCustomModelData(690222);
                break;
            case COOKED_BEEF:
                meatLabel.setCustomModelData(690226);
                break;
            case MUTTON:
                meatLabel.setCustomModelData(690224);
                break;
            case COOKED_MUTTON:
                meatLabel.setCustomModelData(690228);
                break;
            case RABBIT:
                meatLabel.setCustomModelData(690225);
                break;
            case COOKED_RABBIT:
                meatLabel.setCustomModelData(690227);
                break;
            case CHICKEN:
                meatLabel.setCustomModelData(690223);
                break;
            case COOKED_CHICKEN:
                meatLabel.setCustomModelData(690229);
                break;

        }

        meat.setItemMeta(meatLabel);

        return meat;
    }
}