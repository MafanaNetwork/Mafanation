package me.TahaCheji.Mafana.listeners;

import me.TahaCheji.Mafana.stats.PlayerStats;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        PlayerStats.playerStats.remove(e.getPlayer().getUniqueId());
        e.getPlayer().setHealth(1);
        e.getPlayer().resetMaxHealth();
    }

}
