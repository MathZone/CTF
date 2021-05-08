package org.ctf.eu.Upgrades;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static org.ctf.eu.Functions.*;
import static org.ctf.eu.Main.bal;
import static org.ctf.eu.Main.upgrades;

public class UpgradeListener implements Listener {
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e){
       // e.getWhoClicked().sendMessage(e.getView().getTitle());
        InventoryView i = e.getView();
        if(i.getTitle().equals(ChatColor.GOLD + "Upgrades")){

            Player p = (Player) e.getWhoClicked();
            int balance = bal.get(p);
            ArrayList<String> u = upgrades.get(p);
            if(e.getCurrentItem()!=null){
                switch (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())){
                    case "Chainmail Armor":
                        chainArmor[3]=p.getInventory().getHelmet();
                        buyArmor("Chainmail Armor",u,balance,100,p,chainArmor);
                        break;
                    case "Iron Armor":
                        if(!u.contains("Diamond Armor" ) || !u.contains("Netherite Armor")){
                            ironArmor[3]=p.getInventory().getHelmet();
                            buyArmor("Iron Armor",u,balance,200,p,ironArmor);
                        }else{
                            p.sendMessage(ChatColor.RED + "You already have better armor!");
                        }
                        break;

                    case "Diamond Armor":
                        if(!u.contains("Netherite Armor")){
                            diamondArmor[3]=p.getInventory().getHelmet();
                        buyArmor("Diamond Armor",u,balance,1000,p,diamondArmor);
                        }else{
                            p.sendMessage(ChatColor.RED + "You already have better armor!");
                        }
                        break;

                    case "Netherite Armor":
                        netheriteArmor[3]=p.getInventory().getHelmet();
                        buyArmor("Netherite Armor",u,balance,5000,p,netheriteArmor);
                        break;

                    case "Iron Sword":
                        buyItem("Iron Sword",u,balance,150,p,new ItemStack(Material.IRON_SWORD,1),null);
                        break;

                    case "Diamond Sword":
                        buyItem("Diamond Sword",u,balance,500,p,new ItemStack(Material.DIAMOND_SWORD,1),null);
                        break;

                    case "Netherite Sword":
                        buyItem("Netherite Sword",u,balance,2500,p,new ItemStack(Material.NETHERITE_SWORD,1),null);
                        break;

                    case "Bow":
                        buyItem("Bow",u,balance,1000,p,new ItemStack(Material.BOW,1),new ItemStack(Material.ARROW,16) );
                        break;

                    case "16 Arrows":
                        buyItem("16 Arrows",u,balance,250,p,new ItemStack(Material.ARROW,16),null);
                        break;

                    }
                }
            e.setCancelled(true);
            }

        }

    }

