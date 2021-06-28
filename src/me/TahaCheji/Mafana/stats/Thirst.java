package me.TahaCheji.Mafana.stats;

import me.TahaCheji.Mafana.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Thirst implements Listener {
    public double Thirst;
    public double MAXThirst;
    private BukkitTask regen;




    public Thirst(int Thirst) {
        this.Thirst = Thirst;

    }

    public double getThirst() {
        return this.Thirst;
    }

    public double getMAXThirst() {
        return this.MAXThirst;
    }

    public void setMAXThirst(double MAXThirst){
        this.MAXThirst = MAXThirst;

    }

    public float setThirst(double Thirst){
        this.Thirst = Thirst;

        return 0;
    }

    public void ThirstRegen(Player player) {
        BukkitTask t = new BukkitRunnable() {
            @Override
            public void run() {
                if (Thirst + (0.05 * MAXThirst) > MAXThirst) {
                    // cancel
                } else {
                    Thirst += 0.05 * MAXThirst;
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 20L);
    }



}

