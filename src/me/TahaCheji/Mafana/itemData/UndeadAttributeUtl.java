package me.TahaCheji.Mafana.itemData;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public class UndeadAttributeUtl implements Listener {

    public static ItemStack setUndeadAttribute(ItemStack is, Double value) {
        NBTItem nbt = new NBTItem(is);
        nbt.setDouble("UndeadAttribute", value);
        return nbt.getItem();
    }

    public static Double getUndeadAttribute(ItemStack is, String key) {
        return new NBTItem(is).getDouble(key);
    }

    @EventHandler
    public static void onHit(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        Player player = (Player) e.getDamager();
        ItemStack itemStack = player.getItemInHand();
        if(!(e.getEntity() instanceof Zombie)) {
            return;
        }
        if(getUndeadAttribute(itemStack, "UndeadAttribute") != 0) {
            double damage = e.getDamage();
            double newDamage = damage * getUndeadAttribute(itemStack, "UndeadAttribute") / 100;
            e.setDamage(damage + newDamage);
        }
    }





}
