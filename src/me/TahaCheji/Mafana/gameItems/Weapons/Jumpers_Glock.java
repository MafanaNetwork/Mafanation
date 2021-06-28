package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.itemData.ClickType;
import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Jumpers_Glock implements Listener {


    public static ItemStack Jumpers_Glock(Player player) {
        ItemStack jumpers_glock = ItemUtl.createItem(Material.DIAMOND_SHOVEL, 1, ItemType.SWORD, player, true, true, RarityType.COAL,
                "Jumpers Glock", 480, 0, 250, 100, "Shoots horses that explode on impact", ClickType.RIGHT_CLICK, true, true, 150, null,"Jumper has spoken");
        return jumpers_glock;
    }

    @EventHandler
    public void rightClick(PlayerInteractEvent e) {

        if (!(e.getPlayer() instanceof Player)) {
            return;
        }if(e.getItem() == null) {
            return;
        }
        if(e.getItem().getItemMeta() == null) {
            return;
        }
        if(e.getItem().getItemMeta().getDisplayName() == null) {
            return;
        }
        Player player = (Player) e.getPlayer();
        if (!(player.getItemInHand().getItemMeta().getDisplayName().contains("Jumpers Glock"))) {
            return;
        }
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR)) {
            return;
        }
        LivingEntity horse = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.HORSE);
        horse.setVelocity(player.getEyeLocation().getDirection().multiply(4));
        horse.setCustomNameVisible(true);
        horse.setCustomName(ChatColor.GOLD + "Ex-Horse");
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (!horse.isValid() || horse.isDead()) {
                    return;
                }
                player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 10);
                player.spawnParticle(Particle.EXPLOSION_LARGE, horse.getLocation(), 50);
                horse.remove();
            }
        }, 200L);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (!horse.isValid() || horse.isDead()) {
                    return;
                }
                for (Entity entity : horse.getNearbyEntities(2, 2, 2)) {
                    if(entity instanceof Player) {
                        return;
                    }
                    if(entity instanceof Horse) {
                        break;
                    } else {
                        player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 10);
                        player.spawnParticle(Particle.EXPLOSION_LARGE, entity.getLocation(), 50);
                        horse.remove();
                        entity.remove();
                        return;
                    }
                }
            }
        }, 5L, 5L);
    }

    @EventHandler
    public void hitHorse(EntityDamageByEntityEvent e) {
        if(!(e.getEntity() instanceof LivingEntity)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        LivingEntity entity = (LivingEntity) e.getEntity();
        if(!(entity.getCustomName().contains("Ex-Horse"))) {
            return;
        }
        e.getDamager().sendMessage(ChatColor.GOLD + "You Cannot hit this mob!");
        e.setCancelled(true);
    }
}
