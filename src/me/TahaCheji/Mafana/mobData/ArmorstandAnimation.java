package me.TahaCheji.Mafana.mobData;
import org.bukkit.Location;
import org.bukkit.Rotation;
import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import java.time.LocalTime;

public class ArmorstandAnimation extends BukkitRunnable {
    ArmorStand s;

    public ArmorstandAnimation(ArmorStand stand){
        s = stand;
    }

    int spin = 0;

    @Override
    public void run() {
        spin++;
        if(spin == 360) {
            spin = 0;
        }
        s.setRotation(spin, 0);
    }
}
