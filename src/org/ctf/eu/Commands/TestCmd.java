package org.ctf.eu.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static org.ctf.eu.Main.blueFlag;
import static org.ctf.eu.Main.redFlag;
import static org.ctf.eu.Upgrades.UpgradeGui.makeUpgradeGui;

public class TestCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            p.getInventory().addItem(blueFlag);
            p.getInventory().addItem(redFlag);
            Inventory i = makeUpgradeGui();
            p.openInventory(i);
        }
        return false;
    }
}
