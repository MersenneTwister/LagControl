package com.maxisociety.listeners;

import com.maxisociety.LC.LCMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class LCListener implements Listener {
    LCMain plugin;

    public LCListener(LCMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void spawnEvent(EntitySpawnEvent event){
        if(plugin.disableSpawning){
            event.getEntity().remove();
        }
    }
}
