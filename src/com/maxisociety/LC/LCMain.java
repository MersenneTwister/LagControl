package com.maxisociety.LC;

import com.maxisociety.cmds.CmdDS;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.maxisociety.listeners.LCListener;

public class LCMain extends JavaPlugin {
    public boolean disableSpawning = false;
    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        getConfig().addDefault("prefix", "&7[&4LagControl&7]");
        saveConfig();
    }

    public void onEnable() {
        loadConfig();
        getCommand("dp").setExecutor(new CmdDS(this));
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new LCListener(this), this);
    }

    public void onDisable() {
    }
}
