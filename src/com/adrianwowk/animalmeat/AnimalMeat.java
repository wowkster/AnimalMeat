package com.adrianwowk.animalmeat;

import com.adrianwowk.animalmeat.commands.CommandHandler;
import com.adrianwowk.animalmeat.events.AnimalMeatEvents;
import com.adrianwowk.animalmeat.events.ExampleGUI;
import com.adrianwowk.animalmeat.items.AnimalMeatCustomCrafting;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AnimalMeat  extends JavaPlugin {
    Server server;
    ConsoleCommandSender console;
    public static String prefix;
    FileConfiguration config = getConfig();

    public static boolean dropWolf;
    public static boolean dropCat;
    public static boolean dropHorse;
    public static boolean dropParrot;

    public static ExampleGUI gui = new ExampleGUI();

    public AnimalMeat() {
        this.server = Bukkit.getServer();
        this.console = this.server.getConsoleSender();
        this.prefix = ChatColor.GRAY + "[" + ChatColor.GREEN + "AnimalMeat" + ChatColor.GRAY + "] " + ChatColor.YELLOW;
    }

    public void onEnable(){
        config.addDefault("drops.wolves", true);
        config.options().copyDefaults(true);
        saveConfig();

        config.addDefault("drops.horses", true);
        config.options().copyDefaults(true);
        saveConfig();

        config.addDefault("drops.cats", true);
        config.options().copyDefaults(true);
        saveConfig();

        config.addDefault("drops.parrot", true);
        config.options().copyDefaults(true);
        saveConfig();

        dropWolf = config.getBoolean("drops.wolves");
        dropCat = config.getBoolean("drops.cats");
        dropHorse = config.getBoolean("drops.horses");
        dropParrot = config.getBoolean("drops.parrot");

        getCommand("meat").setExecutor(new CommandHandler());

        // Register Event Listeners
        Bukkit.getServer().getPluginManager().registerEvents(new AnimalMeatEvents(), (Plugin) this);
        Bukkit.getServer().getPluginManager().registerEvents(gui, (Plugin) this);

        AnimalMeatCustomCrafting.init();

        // Server Console Message
        this.getLogger().info(prefix + "Plugin was successfully enabled.");
    }

    public void onDisable(){

    }
}
