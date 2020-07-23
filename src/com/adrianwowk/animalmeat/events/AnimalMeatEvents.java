package com.adrianwowk.animalmeat.events;

import com.adrianwowk.animalmeat.AnimalMeat;
import com.adrianwowk.animalmeat.items.CustomMeat;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalMeatEvents implements Listener {
    @EventHandler
    public void onEntityDeath(final EntityDeathEvent event) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        if (event.getEntity() instanceof Wolf && AnimalMeat.dropWolf) {
            int rand = ThreadLocalRandom.current().nextInt(0, 2 + 1);
            for (int i = 0; i < rand; i++) {
                drops.add(CustomMeat.RAW_DOG.getItem());
            }
        } else if (event.getEntity() instanceof Horse && AnimalMeat.dropHorse) {
            int rand = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            for (int i = 0; i < rand; i++) {
                drops.add(CustomMeat.RAW_HORSE.getItem());
            }
        } else if (event.getEntity() instanceof Cat && AnimalMeat.dropCat) {
            int rand = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            for (int i = 0; i < rand; i++) {
                drops.add(CustomMeat.RAW_CAT.getItem());
            }
        } else if (event.getEntity() instanceof Parrot && AnimalMeat.dropParrot) {
            int rand = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            for (int i = 0; i < rand; i++) {
                drops.add(CustomMeat.RAW_PARROT.getItem());
            }
        }

        event.getDrops().addAll(drops);

        return;
    }

    @EventHandler
    private void furnaceCanceller(final FurnaceSmeltEvent event) {
        if (event.getSource() != null) {
            if (event.getSource().getType() == CustomMeat.RAW_DOG.getItem().getType()) {
                if (!event.getSource().isSimilar(CustomMeat.RAW_DOG.getItem()) &&
                        !event.getSource().isSimilar(new ItemStack(Material.BEEF))) {
                    event.setCancelled(true);
                }
            } else if (event.getSource().getType() == CustomMeat.RAW_HORSE.getItem().getType()) {
                if (!event.getSource().isSimilar(CustomMeat.RAW_HORSE.getItem()) &&
                        !event.getSource().isSimilar(new ItemStack(Material.MUTTON))) {
                    event.setCancelled(true);
                }
            } else if (event.getSource().getType() == CustomMeat.RAW_CAT.getItem().getType()) {
                if (!event.getSource().isSimilar(CustomMeat.RAW_CAT.getItem()) &&
                        !event.getSource().isSimilar(new ItemStack(Material.RABBIT))) {
                    event.setCancelled(true);
                }
            } else if (event.getSource().getType() == CustomMeat.RAW_PARROT.getItem().getType()) {
                if (!event.getSource().isSimilar(CustomMeat.RAW_PARROT.getItem()) &&
                        !event.getSource().isSimilar(new ItemStack(Material.CHICKEN))) {
                    event.setCancelled(true);
                }
            }
        }

    }

    @EventHandler
    public void onPickupItem(final PlayerPickupItemEvent event) {
        ItemStack item = event.getItem().getItemStack();
        Player p = event.getPlayer();
        if (item.isSimilar(CustomMeat.RAW_DOG.getItem()) && !hasDicovered(p, "cooked_dog_meat")) {
            p.discoverRecipe(getKey("cooked_dog_meat"));
        } else if (item.isSimilar(CustomMeat.RAW_HORSE.getItem()) && !hasDicovered(p, "cooked_horse_meat")) {
            p.discoverRecipe(getKey("cooked_horse_meat"));
        } else if (item.isSimilar(CustomMeat.RAW_CAT.getItem()) && !hasDicovered(p, "cooked_cat_meat")) {
            p.discoverRecipe(getKey("cooked_cat_meat"));
        } else if (item.isSimilar(CustomMeat.RAW_PARROT.getItem()) && !hasDicovered(p, "cooked_parrot_meat")) {
            p.discoverRecipe(getKey("cooked_parrot_meat"));
        }
        return;
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != AnimalMeat.gui.getInv()) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
//        p.sendMessage("You clicked at slot " + e.getRawSlot());
        for (int i = 0; i < 64; i++) {
            p.getInventory().addItem(clickedItem);
        }
        p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, SoundCategory.AMBIENT, 1.0f, 1.0f);
    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == AnimalMeat.gui.getInv()) {
            e.setCancelled(true);
        }
    }

    private boolean hasDicovered(Player p, String key) {
        return p.hasDiscoveredRecipe(new NamespacedKey(AnimalMeat.getPlugin(AnimalMeat.class), key));
    }

    private NamespacedKey getKey(String key) {
        return new NamespacedKey(AnimalMeat.getPlugin(AnimalMeat.class), key);
    }
}
