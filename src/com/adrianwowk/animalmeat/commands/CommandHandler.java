package com.adrianwowk.animalmeat.commands;

import com.adrianwowk.animalmeat.AnimalMeat;
import com.adrianwowk.animalmeat.events.ExampleGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args){
        if (cmd.getName().equalsIgnoreCase("meat") && sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("am.meat")) {
                AnimalMeat.gui.openInventory((HumanEntity) sender);
            } else {
                sender.sendMessage(AnimalMeat.prefix + "You do not have permission to use that command.");
            }
        } else {
            sender.sendMessage(AnimalMeat.prefix + "You must be a player to use that command.");
        }
        return false;
    }
}
