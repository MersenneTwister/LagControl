package com.maxisociety.utils;

import com.maxisociety.LC.LCMain;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class msgSender {
    LCMain plugin;

    public msgSender(LCMain plugin) {
        this.plugin = plugin;
    }

    public void sndMsg(Player p, String message, int error) {
        String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix"));
        p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', message));
    }
}
