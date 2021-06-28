package me.TahaCheji.Mafana.mobData;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ArmorStandUtl implements Listener {



        @EventHandler
    public void onRightClick(PlayerInteractAtEntityEvent e) {
            Entity entity = e.getRightClicked();
            if(entity instanceof ArmorStand) {
                e.setCancelled(true);
                return;
            }

        }


}
