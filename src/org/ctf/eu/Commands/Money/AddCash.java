package org.ctf.eu.Commands.Money;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.ctf.eu.Main.bal;

public class AddCash implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player) {
            if (strings.length < 1) {
                commandSender.sendMessage("no amount given");
                return false;
            } else {
                    bal.put((Player) commandSender,bal.get((Player) commandSender) + Integer.parseInt(strings[0]));
                    commandSender.sendMessage(ChatColor.RED + "Added " + strings[0] + "$ to bal");
                return true;
            }
        }else{
                return false;
            }
        }
    }

