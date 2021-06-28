package me.TahaCheji.Mafana.stats;

import me.TahaCheji.Mafana.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Mana {
    public double mana;
    public double MAXMANA;
    private BukkitTask regen;




    public Mana(int mana) {
        this.mana = mana;

    }

    public double getMana() {
        return this.mana;
    }
    public double getMaxMana() {
        return this.MAXMANA;
    }

    public void setMaxMana(double MAXMANA){
        this.MAXMANA = MAXMANA;

    }

    public void setMana(double mana){
        this.mana = mana;

    }

    public void manaregen(Player player) {
        this.regen = new BukkitRunnable() {
            @Override
            public void run() {
                if (mana + (0.05 * MAXMANA) > MAXMANA) {
                    // cancel
                } else {
                    // set mana to current mana + (0.02 * maxMana)
                    mana += 0.05 * MAXMANA;
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 20L);
    }
}

