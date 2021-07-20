package me.TahaCheji.Mafana.Mining;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.RarityType;
import me.TahaCheji.Mafana.npc.town.Shops.OreMaster;
import me.TahaCheji.Mafana.game.Title;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public class blockevent implements Listener {

    public static Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void block(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        Material m = block.getType();

        if(player.getGameMode() == GameMode.CREATIVE) {
            return;
        }

        /*
        if(m == (Material.STONE)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.BEDROCK);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    block.setType(Material.STONE);
                }
            }, 200L);
        }

        if(m == (Material.IRON_ORE)) {
            e.setCancelled(true);
            int random = ThreadLocalRandom.current().nextInt(10000000);
            if (random < 1) {
                Title title1 = new Title("HOLY ****","MilkGem 1/10M",15,100,15);
                title1.setTitleColor(ChatColor.DARK_PURPLE);
                title1.setSubtitleColor(ChatColor.WHITE);
                title1.setTimingsToTicks();
                title1.send(player);
                player.setVelocity(new Vector(0, 5, 5));
                player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 10, 10);
            }
            e.getBlock().setType(Material.STONE);
            player.getInventory().addItem(OreMaster.Iron());
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    block.setType(Material.IRON_ORE);
                }
            }, 200L);
        }
        if(m == (Material.GOLD_ORE)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.STONE);
            player.getInventory().addItem(OreMaster.Gold());
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    block.setType(Material.GOLD_ORE);
                }
            }, 200L);
        }
        if(m == (Material.DIAMOND_ORE)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.STONE);
            player.getInventory().addItem(OreMaster.Diamond());
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    block.setType(Material.DIAMOND_ORE);
                }
            }, 200L);
        }
        if(m == (Material.REDSTONE_ORE)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.STONE);
            player.getInventory().addItem(OreMaster.RedStuff());
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    block.setType(Material.REDSTONE_ORE);
                }
            }, 200L);
        }
        if(m == (Material.LAPIS_ORE)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.STONE);
            player.getInventory().addItem(OreMaster.Lapis());
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    block.setType(Material.LAPIS_ORE);
                }
            }, 200L);
        }
        if(m == (Material.EMERALD_ORE)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.STONE);
            player.getInventory().addItem(OreMaster.EMERALD());
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    block.setType(Material.EMERALD_ORE);
                }
            }, 200L);
        }

         */


    }


}
