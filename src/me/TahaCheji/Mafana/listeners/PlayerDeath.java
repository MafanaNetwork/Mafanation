package me.TahaCheji.Mafana.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.stats.PlayerStats;
import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayerDeath implements Listener {


    @EventHandler
    public void onDeath(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player && e.getDamager() instanceof Monster)) {
            return;
        }
        Entity entity = e.getDamager();
        Player player  = (Player) e.getEntity();
        double damage = e.getDamage();
        if(damage > player.getHealth()) {
            player.setHealth(100);
            player.sendMessage(ChatColor.RED + "You Died!");
            player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 10, 10);
            player.teleport(Main.getInstance().getLobbyPoint());
            Bukkit.broadcastMessage(player.getDisplayName() + " just died from " + NBTUtils.getEntityString(entity, "MobName"));
        }
       // e.setDeathMessage(player.getCustomName() + " just ALT + F4 from " + NBTUtils.getEntityString(entity, "MobName"));
        }

        @EventHandler
        public void death(PlayerDeathEvent e) {
        e.setDeathMessage(null);
        }


        public void updateItemLore(String newLore) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                for(ItemStack itemStack : player.getInventory()) {
                    if(itemStack == null) {
                        continue;
                    }
                    if(itemStack.getItemMeta() == null) {
                        continue;
                    }
                    if(itemStack.getItemMeta().getLore() == null) {
                        continue;
                    }
                        ItemMeta meta = itemStack.getItemMeta();
                        List<String> list = new ArrayList<>();
                        list.add(newLore);
                        meta.setLore(list);
                        itemStack.setItemMeta(meta);
                }
        }


    }


}
