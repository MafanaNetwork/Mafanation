package me.TahaCheji.Mafana.area.town.mine;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.gameMobs.mobs.ExcavatorZombie;
import me.TahaCheji.Mafana.gameMobs.mobs.GummedSpider;
import me.TahaCheji.Mafana.mobData.SpawnMob;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MineMobs implements Listener {

    SpawnMob mob = new SpawnMob();

    public void spawnMob(Player player) {
        Location radius1 = new Location(Bukkit.getWorld("world"), 43, 48, 120);
        Location radius2 = new Location(Bukkit.getWorld("world"), 110, 2, 173);
        mob.spawnMobs(15, 15, radius1, radius2, new ExcavatorZombie().getExcavatorZombie(player));
        mob.spawnMobs(15, 15, radius1, radius2,  GummedSpider.getGummedSpider(player));
      //  System.out.println("spawned mobs");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        //spawnMob(e.getPlayer());
    }

}
