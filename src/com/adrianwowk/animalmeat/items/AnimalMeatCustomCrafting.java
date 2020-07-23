package com.adrianwowk.animalmeat.items;


import com.adrianwowk.animalmeat.AnimalMeat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmokingRecipe;

public class AnimalMeatCustomCrafting {

    public static void init(){
        initDogMeat();
        initHorseMeat();
        initCatMeat();
        initParrotMeat();
    }

    // Make a create meat method to eliminate duplicate code

    private static void initDogMeat() {
        ItemStack Smelt = CustomMeat.RAW_DOG.getItem();
        Material mat = Smelt.getType();
        NamespacedKey key = new NamespacedKey(AnimalMeat.getPlugin(AnimalMeat.class), "cooked_dog_meat");
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(key, CustomMeat.COOKED_DOG.getItem(), mat, 0.7f, 100);
        SmokingRecipe smokingRecipe = new SmokingRecipe(key, CustomMeat.COOKED_DOG.getItem(), mat, 0.35f, 75);
        Bukkit.addRecipe(furnaceRecipe);
        Bukkit.addRecipe(smokingRecipe);
    }
    private static void initHorseMeat() {
        ItemStack Smelt = CustomMeat.RAW_HORSE.getItem();
        Material mat = Smelt.getType();
        NamespacedKey key = new NamespacedKey(AnimalMeat.getPlugin(AnimalMeat.class), "cooked_horse_meat");
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(key, CustomMeat.COOKED_HORSE.getItem(), mat, 0.7f, 100);
        SmokingRecipe smokingRecipe = new SmokingRecipe(key, CustomMeat.COOKED_HORSE.getItem(), mat, 0.35f, 75);
        Bukkit.addRecipe(furnaceRecipe);
        Bukkit.addRecipe(smokingRecipe);
    }
    private static void initCatMeat() {
        ItemStack Smelt = CustomMeat.RAW_CAT.getItem();
        Material mat = Smelt.getType();
        NamespacedKey key = new NamespacedKey(AnimalMeat.getPlugin(AnimalMeat.class), "cooked_cat_meat");
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(key, CustomMeat.COOKED_CAT.getItem(), mat, 0.7f, 100);
        SmokingRecipe smokingRecipe = new SmokingRecipe(key, CustomMeat.COOKED_CAT.getItem(), mat, 0.35f, 75);
        Bukkit.addRecipe(furnaceRecipe);
        Bukkit.addRecipe(smokingRecipe);
    }
    private static void initParrotMeat() {
        ItemStack Smelt = CustomMeat.RAW_PARROT.getItem();
        Material mat = Smelt.getType();
        NamespacedKey key = new NamespacedKey(AnimalMeat.getPlugin(AnimalMeat.class), "cooked_parrot_meat");
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(key, CustomMeat.COOKED_PARROT.getItem(), mat, 0.7f, 100);
        SmokingRecipe smokingRecipe = new SmokingRecipe(key, CustomMeat.COOKED_PARROT.getItem(), mat, 0.35f, 75);
        Bukkit.addRecipe(furnaceRecipe);
        Bukkit.addRecipe(smokingRecipe);
    }
}
