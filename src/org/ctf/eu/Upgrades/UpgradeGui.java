package org.ctf.eu.Upgrades;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import static org.ctf.eu.Functions.makeCustomItem;
import static org.ctf.eu.Main.menuGlass;
import static org.ctf.eu.Main.upgradesGui;

public class UpgradeGui implements CommandExecutor {
    public static Inventory makeUpgradeGui() {
        Inventory gui = Bukkit.createInventory(null, 45, "Upgrades");
        for (int i = 0; i < 45; i++) {
            gui.setItem(i, menuGlass);
        }
        ItemStack ironArmor = makeCustomItem(Material.IRON_CHESTPLATE, 1, ChatColor.BOLD + "" + ChatColor.WHITE + "Iron Armor", "Gives you full", "iron armor", "200$");
        gui.setItem(1, ironArmor);
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
