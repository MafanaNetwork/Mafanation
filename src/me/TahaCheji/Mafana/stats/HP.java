package me.TahaCheji.Mafana.stats;

import me.TahaCheji.Mafana.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class HP implements Listener {
    public double hp;
    public double MAXHP;
    private Player p;
    private BukkitTask regen;
    public HP(int hp) {
        this.hp = hp; }
    public double getHP() {
        return this.hp;
    }
    public double getMAXHP() {
        return this.MAXHP;
    }
    public void setMAXHP(double MAXHP){
        this.MAXHP = MAXHP;
        p.setMaxHealth(MAXHP);

    }
    public float setHP(double hp){
        this.hp = hp;
        p.setHealth(hp);
        return 0;
    }
    public void setCurrentHealth(double value) {
        if(value < p.getMaxHealth()) {
            p.setHealth(value);
        }
    }
    public double getCurrentHealth() {
        return p.getHealth();
    }
    public void hpRegen(Player player) {
        this.regen = new BukkitRunnable() {
            @Override
            public void run() {
                if (hp + (0.05 * MAXHP) > MAXHP) {
                    player.setMaxHealth(getMAXHP());
                    player.setHealth(getHP());
                } else {
                    hp += 0.05 * MAXHP;
                    player.setMaxHealth(getMAXHP());
                    player.setHealth(getHP());
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 20L);
    }




}

