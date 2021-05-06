package org.ctf.eu;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

import static org.ctf.eu.Main.*;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent e){
        if(!breakingEnabled) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(!(bal.containsKey(e.getPlayer()))) {
            bal.put(e.getPlayer(), 0);
        }
        if(!(upgrades.containsKey(e.getPlayer()))) {
            ArrayList<String> s = new ArrayList<>();
            upgrades.put(e.getPlayer(),s);
        }
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
        }else{
            p.sendMessage("You're already in a team");
        }
    }

    @EventHandler
    public void PlayerQuitEvent(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(blueTeam.contains(p)){
            blueTeam.remove(p);
        }else if (redTeam.contains(p)){
            redTeam.remove(p);
        }
    }
}
