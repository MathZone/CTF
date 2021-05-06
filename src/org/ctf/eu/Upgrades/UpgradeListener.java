package org.ctf.eu.Upgrades;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static org.ctf.eu.Functions.ironArmor;
import static org.ctf.eu.Main.bal;
import static org.ctf.eu.Main.upgrades;

public class UpgradeListener implements Listener {
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e){
       // e.getWhoClicked().sendMessage(e.getView().getTitle());
        InventoryView i = e.getView();
        if(i.getTitle().equals("Upgrades")){

            Player p = (Player) e.getWhoClicked();
            int balance = bal.get(p);
            ArrayList<String> u = upgrades.get(p);
            if(e.getCurrentItem()!=null){
                switch (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())){
                    case "Iron Armor":
                        if(!u.contains("IronArmor")){
                        if(balance>=200){
                            bal.remove(p);
                            bal.put(p,balance-200);
                            p.getInventory().setArmorContents(ironArmor);
                            p.closeInventory();
                            p.sendMessage(ChatColor.GREEN + "Bought Iron Armor");
                            u.add("IronArmor");
                           }else{
                            p.sendMessage(ChatColor.RED + "You don't have enough money");
                        }
                        }else{
                            p.sendMessage(ChatColor.RED + "You've already bought Iron Armor");
                        }
                        break;


                }
            }
            e.setCancelled(true);
        }

    }
}
