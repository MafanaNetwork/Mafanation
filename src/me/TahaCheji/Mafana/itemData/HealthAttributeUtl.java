package me.TahaCheji.Mafana.itemData;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class HealthAttributeUtl implements Listener {

    public static ItemStack setHealthAttribute(ItemStack is, Double value) {
        NBTItem nbt = new NBTItem(is);
        nbt.setDouble("HealthAttribute", value);
        return nbt.getItem();
    }

    public static Double getHealthAttribute(ItemStack is) {
        return new NBTItem(is).getDouble("HealthAttribute");
    }

    public HashMap<UUID, ItemStack> check = new HashMap<>();

    @EventHandler
    public void armorOn(ArmorEquipEvent e) {
        ItemStack newArmor = e.getNewArmorPiece();
        Player player  = e.getPlayer();
        if(newArmor == null) {
            return;
        }
        if(newArmor.getItemMeta() == null) {
            return;
        }
        if(!(new NBTItem(newArmor).hasKey("HealthAttribute"))) {
            System.out.println("f");
            return;
        }
        if(check.containsKey(player.getUniqueId()) && check.containsValue(newArmor)) {
            return;
        }
        check.put(player.getUniqueId(), newArmor);
        double health = getHealthAttribute(newArmor) / 5;
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier("generic.MaxHealth", health, AttributeModifier.Operation.ADD_NUMBER));

    }

    @EventHandler
    public void armorOf(ArmorEquipEvent e) {
        ItemStack oldArmor = e.getOldArmorPiece();
        Player player  = e.getPlayer();
        if(oldArmor == null) {
            return;
        }
        if(oldArmor.getItemMeta() == null) {
            return;
        }
        if(!(new NBTItem(oldArmor).hasKey("HealthAttribute"))) {
            System.out.println("f");
            return;
        }
        if(!check.containsKey(player.getUniqueId()) && !check.containsValue(oldArmor)) {
            return;
        }
        check.remove(player.getUniqueId(), oldArmor);
        double health = getHealthAttribute(oldArmor) / 5;
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier("generic.MaxHealth", -health, AttributeModifier.Operation.ADD_NUMBER));
    }







}
