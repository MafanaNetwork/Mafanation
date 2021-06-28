package me.TahaCheji.Mafana.mobData;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Arrays;
import java.util.Objects;

public class DropLoot implements Listener {



    public void onKill(EntityDeathEvent e, CreateMob mob) {
        Entity entity = e.getEntity();
        e.getDrops().clear();
        e.setDroppedExp(0);
        if(entity.getCustomName() == null) {
            return;
        }
            if (!(entity.getCustomName()).contains(mob.getName())) {
                System.out.println(mob.getName());
                return;
            }
            mob.tryDropLoot(entity.getLocation());
        }


}
