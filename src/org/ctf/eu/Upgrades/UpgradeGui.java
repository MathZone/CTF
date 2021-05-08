package org.ctf.eu.Upgrades;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static org.ctf.eu.Functions.makeCustomItem;
import static org.ctf.eu.Main.menuGlass;
import static org.ctf.eu.Main.upgradesGui;

public class UpgradeGui implements CommandExecutor {
    public static Inventory makeUpgradeGui() {
        Inventory gui = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Upgrades");
        for (int i = 0; i < 27; i++) {
            gui.setItem(i, menuGlass);
        }

        ItemStack chainArmor = makeCustomItem(Material.CHAINMAIL_CHESTPLATE, 1, ChatColor.GRAY+""+ChatColor.BOLD+"Chainmail Armor","Gives you full","Chainmail Armor","100$");
        ItemStack ironArmor = makeCustomItem(Material.IRON_CHESTPLATE, 1,  ChatColor.WHITE + "" + ChatColor.BOLD +  "Iron Armor", "Gives you full", "Iron Armor", "200$");
        ItemStack diamondArmor = makeCustomItem(Material.DIAMOND_CHESTPLATE,1,ChatColor.AQUA+""+ChatColor.BOLD+ "Diamond Armor","Gives you full","Diamond Armor","1000$");
        ItemStack netheriteArmor = makeCustomItem(Material.NETHERITE_CHESTPLATE,1,ChatColor.DARK_PURPLE+""+ ChatColor.BOLD +  "Netherite Armor","Gives you full","Netherite Armor","5000$");

        ItemStack ironSword = makeCustomItem(Material.IRON_SWORD,1, ChatColor.WHITE+""+ChatColor.BOLD+"Iron Sword", "Gives you","A Iron Sword", "150$");
        ItemStack diamondSword = makeCustomItem(Material.DIAMOND_SWORD,1, ChatColor.AQUA+""+ChatColor.BOLD+"Diamond Sword", "Gives you","A Diamond Sword", "500$");
        ItemStack netheriteSword = makeCustomItem(Material.NETHERITE_SWORD,1, ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"Netherite Sword", "Gives you","A Netherite Sword", "2500$");
        ItemStack bow = makeCustomItem(Material.BOW,1, ChatColor.GOLD+""+ChatColor.BOLD+"Bow", "Gives you","A Bow and 16 arrows", "1000$");
        ItemStack arrows = makeCustomItem(Material.ARROW,16,ChatColor.WHITE+""+ChatColor.BOLD+"16 Arrows","Gives you","16 arrows","250$");
        ItemStack gApple = makeCustomItem(Material.GOLDEN_APPLE,1,ChatColor.GOLD + "" + ChatColor.BOLD+"Golden Apple" , "Gives you","a Golden Apple","100$");
        ItemStack notchApple = makeCustomItem(Material.ENCHANTED_GOLDEN_APPLE,1,ChatColor.GOLD + "" + ChatColor.BOLD+"Enchanted Golden Apple" , "Gives you","a Enchanted Golden Apple","1000$");

        gui.setItem(0,chainArmor);
        gui.setItem(10, ironArmor);
        gui.setItem(2, diamondArmor);
        gui.setItem(12,netheriteArmor);

        gui.setItem(14,ironSword);
        gui.setItem(6,diamondSword);
        gui.setItem(16,netheriteSword);
        gui.setItem(8,bow);

        gui.setItem( 22,arrows);
        gui.setItem( 18,gApple);
        gui.setItem( 26,notchApple);

        return gui;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            ((Player) commandSender).openInventory(upgradesGui);
            return true;
        } else {
            return false;
        }
    }
}
