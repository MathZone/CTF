package org.ctf.eu.Teams.Blue;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class BlueArmor {
    public static ItemStack[] makeBlueArmor(){
        ItemStack leatherChestplate = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) leatherChestplate.getItemMeta();
        chestplateMeta.setColor(Color.BLUE);
        leatherChestplate.setItemMeta(chestplateMeta);

        ItemStack leatherLegs = new ItemStack(Material.LEATHER_LEGGINGS,1);
        LeatherArmorMeta legsMeta = (LeatherArmorMeta) leatherLegs.getItemMeta();
        legsMeta.setColor(Color.BLUE);
        leatherLegs.setItemMeta(legsMeta);

        ItemStack leatherBoots = new ItemStack(Material.LEATHER_BOOTS,1);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) leatherBoots.getItemMeta();
        bootsMeta.setColor(Color.BLUE);
        leatherBoots.setItemMeta(bootsMeta);

        ItemStack [] leatherArmor = {leatherBoots,leatherLegs,leatherChestplate};

        return leatherArmor;
    }
}
