package me.TahaCheji.Mafana.stats;

import org.bukkit.entity.Player;

public class Strength {
    public double st;

    public Strength(int st) {
        this.st = st;

    }

    public double getStregnth() {
        return this.st;
    }

    public int setStregnth(double st, Player player) {
        this.st = st;
        return 0;
    }

}

