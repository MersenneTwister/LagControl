package com.maxisociety.cmds;

import com.maxisociety.LC.LCMain;
import com.maxisociety.utils.msgSender;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class CmdDS implements CommandExecutor {
    LCMain plugin;

    public CmdDS(LCMain plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        int numEnt = 0;
        msgSender msgSender = new msgSender(plugin);
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                if (!plugin.disableSpawning) {
                    sender.sendMessage("Mob spawning disabled in worlds " + Bukkit.getServer().getWorlds());
                    plugin.disableSpawning = true;
                    return true;
                } else {
                    sender.sendMessage("Mob spawning enabled in worlds " + Bukkit.getServer().getWorlds());
                    plugin.disableSpawning = false;
                    return true;
                }
            }
            Player p = (Player) sender;
            if (!plugin.disableSpawning) {
                msgSender.sndMsg(p, "&cMob spawning disabled in worlds " + Bukkit.getServer().getWorlds(), 0);
                plugin.disableSpawning = true;
            } else {
                msgSender.sndMsg(p, "&cMob spawning enabled in worlds " + Bukkit.getServer().getWorlds(), 0);
                plugin.disableSpawning = false;
            }
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used in-game!");
            return true;
        }
        Player p = (Player) sender;
        if (args[0].equalsIgnoreCase("kill")) {
            for (Entity e : p.getWorld().getEntities()) {
                if (!(e instanceof Player) && !(e instanceof Painting) && !(e instanceof ItemFrame) && !(e instanceof Item)) {
                    e.remove();
                    msgSender.sndMsg(p, "&dKilled " + numEnt + " entities.", 0);
                }
            }
        }
        return false;
    }
}

