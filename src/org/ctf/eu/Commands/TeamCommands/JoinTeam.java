package org.ctf.eu.Commands.TeamCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.ctf.eu.Main.blueTeam;
import static org.ctf.eu.Main.redTeam;

public class JoinTeam implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(!(blueTeam.contains(p) || redTeam.contains(p))) {
                if (blueTeam.size() < redTeam.size()) {
                    blueTeam.add(p);
                    p.setDisplayName(ChatColor.BLUE + "[BLUE]" + ChatColor.stripColor(p.getDisplayName())+ChatColor.RESET);
                    p.sendMessage(ChatColor.BLUE + "Joined team Blue");
                } else {
                    redTeam.add(p);
                    p.setDisplayName(ChatColor.RED + "[RED]" + ChatColor.stripColor(p.getDisplayName())+ChatColor.RESET);
                    p.sendMessage(ChatColor.RED + "Joined team Red");
                }
                return true;
            }else{
                commandSender.sendMessage("You're already in a team");
                return true;
            }
        }else{
        return false;
        }
    }
}
