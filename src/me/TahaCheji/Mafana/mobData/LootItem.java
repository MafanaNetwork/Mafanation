package me.TahaCheji.Mafana.mobData;

import com.gmail.filoghost.holographicdisplays.util.nbt.NBTTag;
import de.tr7zw.nbtapi.NBTEntity;
import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import simplepets.brainsynder.menu.menuItems.Armor;

import java.util.Random;

public class LootItem {

    private final ItemStack item1;
    private int min = 1, max = 1;
    private final double dropRate;
    private final Random randomiser = new Random();

    public LootItem(ItemStack item, double dropRate)  {
        this.item1 = item;
        this.dropRate = dropRate;
    }

    public LootItem(ItemStack item, int min, int max, double dropRate) {
        this.item1 = item;
        this.min = min;
        this.max = max;
        this.dropRate = dropRate;
    }

    public void tryDropItem(Location loc, Player player) {
        if (Math.random() * 101 > dropRate) {
            System.out.println(item1.getItemMeta().getDisplayName());
            return;
        }
        int amount = randomiser.nextInt(max - min + 1) + min;
        if (amount == 0) return;
        ItemStack item = item1.clone();
        item.setAmount(amount);
        ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        as.setCustomNameVisible(true);
        as.setCustomName(item.getItemMeta().getDisplayName() + ChatColor.GRAY + " x" + amount);
        as.setInvulnerable(true);
        as.setVisible(false);
        as.setGravity(false);
        as.setArms(true);
        as.setLeftArmPose(new EulerAngle(0,0,38f));
        as.setRightArmPose(new EulerAngle(80f, 90f, 15f));
        NBTUtils.setEntityString(as, "LootItem", "ArmorStand");
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInstance(), new ArmorstandAnimation(as), 0, 1);
        player.sendMessage(ChatColor.GOLD + "Mob Drop: " + item.getItemMeta().getDisplayName() +  ChatColor.DARK_GRAY + " x" + amount);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
        if(NBTUtils.getString(item, "ItemType").contains("Boots")) {
            as.getEquipment().setBoots(item);
            return;
        }
        if(NBTUtils.getString(item, "ItemType").contains("Leggings")) {
            as.getEquipment().setLeggings(item);
           return;
        }
        if(NBTUtils.getString(item, "ItemType").contains("Chestplate")) {
        as.getEquipment().setChestplate(item);
       return;
        }
        if(NBTUtils.getString(item, "ItemType").contains("Helmet")) {
            as.getEquipment().setHelmet(item);
          return;
        } else {
            as.getEquipment().setItemInMainHand(item);
            return;
        }

    }


    public ItemStack getItem() {
        return item1;
    }

}

