package me.TahaCheji.Mafana.listeners;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTEntity;
import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerMoveEvent implements Listener {



    @EventHandler
    public void onMove(org.bukkit.event.player.PlayerMoveEvent e) {
        Player player = e.getPlayer();

        for(Entity entity : player.getNearbyEntities(1,1,1)) {
            if(entity == null) {
                return;
            }
            if(entity instanceof ArmorStand) {
                if(((ArmorStand) entity).getEquipment() == null) {
                    continue;
                }
                if(((ArmorStand) entity).getItemInHand() == null) {
                    continue;
                }
                NBTCompound nbt = new NBTEntity(entity).getPersistentDataContainer();
                if(!(nbt.hasKey("LootItem"))) {
                   return;
                }
                player.getInventory().addItem(((ArmorStand) entity).getEquipment().getItemInMainHand());
                player.getInventory().addItem(((ArmorStand) entity).getEquipment().getArmorContents());
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10, 10);
                entity.remove();

            }
        }


    }



}
