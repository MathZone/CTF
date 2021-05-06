package org.ctf.eu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.ctf.eu.Commands.Money.AddCash;
import org.ctf.eu.Commands.Money.Bal;
import org.ctf.eu.Commands.TeamCommands.JoinTeam;
import org.ctf.eu.Commands.TestCmd;
import org.ctf.eu.Commands.ToggleBreaking;
import org.ctf.eu.Upgrades.UpgradeGui;
import org.ctf.eu.Upgrades.UpgradeListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.ctf.eu.Functions.makeMenuGlass;
import static org.ctf.eu.Teams.BlueFlag.makeBlueFlag;
import static org.ctf.eu.Teams.RedFlag.makeRedFlag;
import static org.ctf.eu.Upgrades.UpgradeGui.makeUpgradeGui;

public class Main extends JavaPlugin {
    public static boolean breakingEnabled = false;

    public static List<Player> blueTeam = new ArrayList<Player>();
    public static List<Player> redTeam = new ArrayList<Player>();

    public static ItemStack menuGlass;
    public static ItemStack blueFlag;
    public static ItemStack redFlag;

    public static Inventory upgradesGui;

    public static HashMap<Player,Integer> bal = new HashMap<Player, Integer>();
    public static HashMap<Player,ArrayList<String>> upgrades = new HashMap<Player,ArrayList<String>>();

    @Override
    public void onEnable() {

        getLogger().info("CTF running");
        getServer().getPluginManager().registerEvents(new Listener(), this);
        getServer().getPluginManager().registerEvents(new UpgradeListener(),this);

        menuGlass= makeMenuGlass();
        blueFlag = makeBlueFlag();
        redFlag = makeRedFlag();
        upgradesGui = makeUpgradeGui();

        this.getCommand("testcmd").setExecutor(new TestCmd());
        this.getCommand("bal").setExecutor(new Bal());
        this.getCommand("togglebreaking").setExecutor(new ToggleBreaking());
        this.getCommand("addcash").setExecutor(new AddCash());
        this.getCommand("upgrades").setExecutor(new UpgradeGui());
        this.getCommand("jointeam").setExecutor(new JoinTeam());
    }

    @Override
    public void onDisable() {

    }

}
