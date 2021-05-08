package org.ctf.eu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.ctf.eu.Main.bal;

public class Functions {
    public static ItemStack makeMenuGlass(){
        ItemStack menuGlass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta menuGlassItemMeta= menuGlass.getItemMeta();
        menuGlassItemMeta.setDisplayName(" ");
        menuGlass.setItemMeta(menuGlassItemMeta);
        return menuGlass;
    }

    public static ItemStack makeCustomItem(Material material ,int amount, String name , String lore1 , String lore2 , String lore3){
        ItemStack itemStack = new ItemStack(material,amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        List<String> lore = Arrays.asList(ChatColor.GOLD+lore1,ChatColor.GOLD+lore2,ChatColor.GOLD+lore3);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static void buyArmor(String name , ArrayList<String> u,int balance,int price, Player p,ItemStack[] armor){
        if(!u.contains(name)){
            if(balance>=price){
                bal.remove(p);
                bal.put(p,balance-price);
                p.getInventory().setArmorContents(armor);
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Bought " + name);
                u.add(name);
            }else{
                p.sendMessage(ChatColor.RED + "You don't have enough money");
            }
        }else{
            p.sendMessage(ChatColor.RED + "You've already bought "+name);
        }
    }

    public static void buyItem(String name , ArrayList<String> u,int balance,int price, Player p,ItemStack item,ItemStack addition){
            if(balance>=price){
                bal.remove(p);
                bal.put(p,balance-price);
                p.getInventory().addItem(item);
                if(addition!=null) {
                    p.getInventory().addItem(addition);
                }
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Bought " + name);
                u.add(name);
            }else{
                p.sendMessage(ChatColor.RED + "You don't have enough money");
            }

    }
    static ItemStack ironChest = new ItemStack(Material.IRON_CHESTPLATE,1);
    static ItemStack ironLegs = new ItemStack(Material.IRON_LEGGINGS,1);
    static ItemStack ironBoots = new ItemStack(Material.IRON_BOOTS,1);
    public static ItemStack[] ironArmor = {ironBoots,ironLegs,ironChest,null};

    static ItemStack diamondChest = new ItemStack(Material.DIAMOND_CHESTPLATE,1);
    static ItemStack diamondLegs = new ItemStack(Material.DIAMOND_LEGGINGS,1);
    static ItemStack diamondBoots = new ItemStack(Material.DIAMOND_BOOTS,1);
    public static ItemStack[] diamondArmor = {diamondBoots,diamondLegs,diamondChest,null};

    static ItemStack netheriteChest = new ItemStack(Material.NETHERITE_CHESTPLATE,1);
    static ItemStack netheriteLegs = new ItemStack(Material.NETHERITE_LEGGINGS,1);
    static ItemStack netheriteBoots = new ItemStack(Material.NETHERITE_BOOTS,1);
    public static ItemStack[] netheriteArmor = {netheriteBoots,netheriteLegs,netheriteChest,null};

    static ItemStack chainChest = new ItemStack(Material.CHAINMAIL_CHESTPLATE,1);
    static ItemStack chainLegs = new ItemStack(Material.CHAINMAIL_LEGGINGS,1);
    static ItemStack chainBoots = new ItemStack(Material.CHAINMAIL_BOOTS,1);
    public static ItemStack[] chainArmor = {chainBoots,chainLegs,chainChest,null};
}
