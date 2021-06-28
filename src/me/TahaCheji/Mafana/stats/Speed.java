package me.TahaCheji.Mafana.stats;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class Speed {
    public double speed;

    public Speed(int speed) {
        this.speed = speed;

    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed, Player player){
        this.speed = speed;
        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.002 * speed);

    }


}
