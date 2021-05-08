package org.ctf.eu.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static org.ctf.eu.Main.breakingEnabled;

public class ToggleBreaking implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (breakingEnabled) {
            breakingEnabled = false;
            commandSender.sendMessage(ChatColor.DARK_RED + "Disabled block breaking and placing");
        }else{
            breakingEnabled = true;
            commandSender.sendMessage(ChatColor.DARK_RED + "Enabled block breaking and placing");
        }
        return true;
    }
}
