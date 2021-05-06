package org.ctf.eu.Commands.Money;

import net.minecraft.server.v1_16_R3.CommandDataAccessor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.ctf.eu.Main.bal;

public class Bal implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            commandSender.sendMessage(ChatColor.GOLD +"Your balance is : " +ChatColor.RED + bal.get((Player) commandSender) +"$");
            return true;
        }
        else {
            return false;
        }
    }
}
