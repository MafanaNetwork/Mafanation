package me.TahaCheji.Mafana.dungeons.AquaDungeon;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ArmorStandAnimationRight extends BukkitRunnable {
    ArmorStand s;
    Player p;
    public ArmorStandAnimationRight(ArmorStand stand) {
        s = stand;
    }

    @Override
    public void run() {
        Vector vector = new Vector(1, 0, 0);
        s.setVelocity(vector);

    }
}
