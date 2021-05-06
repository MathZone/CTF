package org.ctf.eu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

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
        List<String> lore = Arrays.asList(lore1,lore2,lore3);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    static ItemStack ironChest = new ItemStack(Material.IRON_CHESTPLATE,1);
    static ItemStack ironLegs = new ItemStack(Material.IRON_LEGGINGS,1);
    static ItemStack ironBoots = new ItemStack(Material.IRON_BOOTS,1);
    public static ItemStack[] ironArmor = {ironBoots,ironLegs,ironChest,null};
}
