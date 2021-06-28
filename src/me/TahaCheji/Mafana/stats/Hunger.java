package me.TahaCheji.Mafana.stats;

import me.TahaCheji.Mafana.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Hunger {
    public double Hunger;
    public double MAXHunger;
    private BukkitTask regen;




    public Hunger(int Hunger) {
        this.Hunger = Hunger;

    }

    public double getHunger() {
        return this.Hunger;
    }

    public double getMAXHunger() {
        return this.MAXHunger;
    }

    public void setMAXHunger(double MAXHunger){
        this.MAXHunger = MAXHunger;

    }

    public float setHunger(double Hunger){
        this.Hunger = Hunger;

        return 0;
    }

    public void HungerRegen(Player player) {
        BukkitTask t = new BukkitRunnable() {
            @Override
            public void run() {
                if (Hunger + (0.05 * MAXHunger) > MAXHunger) {
                    // cancel
                } else {
                    Hunger += 0.05 * MAXHunger;
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 20L);
    }
}
