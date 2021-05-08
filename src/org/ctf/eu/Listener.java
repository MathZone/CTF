package org.ctf.eu;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

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
    public void BlockPlaceEvent(BlockPlaceEvent e){
        if(!breakingEnabled) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.getInventory().clear();
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

                p.getInventory().setArmorContents(blueArmor);
                p.getInventory().setHelmet(new ItemStack(Material.BLUE_WOOL,1));
                p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
            } else {
                redTeam.add(p);
                p.setDisplayName(ChatColor.RED + "[RED]" + ChatColor.stripColor(p.getDisplayName())+ChatColor.RESET);
                p.sendMessage(ChatColor.RED + "Joined team Red");

                p.getInventory().setArmorContents(redArmor);
                p.getInventory().setHelmet(new ItemStack(Material.RED_WOOL,1));
                p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
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

    @EventHandler
    public void PlayerAttackEvent(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
            Player attacker = (Player) e.getDamager();
            Player victim = (Player) e.getEntity();
            if(blueTeam.contains(attacker) && blueTeam.contains(victim)){
                e.setCancelled(true);
            }
            else if(redTeam.contains(attacker) && redTeam.contains(victim)){
                e.setCancelled(true);
            }

            for(ItemStack i : ((Player)e.getDamager()).getInventory().getContents() ){
                Damageable damage = (Damageable) i.getItemMeta();
                damage.setDamage(0);
                i.setItemMeta((ItemMeta) damage);
            }
            for(ItemStack i : ((Player)e.getEntity()).getInventory().getContents() ){
                Damageable damage = (Damageable) i.getItemMeta();
                damage.setDamage(0);
                i.setItemMeta((ItemMeta) damage);
            }
        }

    }

    @EventHandler
    public void PlayerDeathEvent(PlayerDeathEvent e) {
        if(e.getEntity().getKiller() !=null){
           int balance = bal.get(e.getEntity().getKiller());
           bal.put(e.getEntity().getKiller(),balance+50);
           int victim = bal.get(e.getEntity());
           bal.put(e.getEntity(),victim-10);
           e.getEntity().getKiller().sendMessage(ChatColor.GREEN + "Got 50$ for killing " + ChatColor.RESET + e.getEntity().getDisplayName());
           e.getEntity().sendMessage(ChatColor.RED + "You lost 10$ for dying to " + ChatColor.RESET + e.getEntity().getKiller().getDisplayName());
        }
    }
}
