package org.ctf.eu.Commands.TeamCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.ctf.eu.Main.blueTeam;
import static org.ctf.eu.Main.redTeam;

public class LeaveTeam implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            p.resetTitle();
            if(blueTeam.contains(p)){
                blueTeam.remove(p);
                commandSender.sendMessage(ChatColor.BLUE + "Left team Blue");
            }else if(redTeam.contains(p)){
                redTeam.remove(p);
                commandSender.sendMessage(ChatColor.RED + "Left team Red");
            }else{
                commandSender.sendMessage(ChatColor.DARK_RED + "You're not in any team!");
            }
            return true;
        }else {
            return false;
        }
    }
}
