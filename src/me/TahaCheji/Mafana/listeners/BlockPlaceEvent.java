package me.TahaCheji.Mafana.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockPlaceEvent implements Listener {


    @EventHandler
    public void blockPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
            return;
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void blockPlace(org.bukkit.event.block.BlockBreakEvent e) {
        if(e.getPlayer().getGameMode() == GameMode.CREATIVE || e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
            return;
        }
        e.setCancelled(true);
    }


}
