package me.TahaCheji.Mafana.mobData;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTEntity;
import me.TahaCheji.Mafana.utils.NBTUtils;
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
        Player player = e.getEntity().getKiller();
        e.getDrops().clear();
        e.setDroppedExp(0);
        if(entity instanceof Player) {
            return;
        }
        if(entity.getCustomName() == null) {
            return;
        }
        NBTCompound nbt = new NBTEntity(entity).getPersistentDataContainer();
        if(!(nbt.hasKey("MobName"))) {
            return;
        }
        if(!(NBTUtils.getEntityString(entity, "MobName").equalsIgnoreCase(mob.getName()))) {
            return;
        }
            mob.tryDropLoot(entity.getLocation(), player);
    }



}
