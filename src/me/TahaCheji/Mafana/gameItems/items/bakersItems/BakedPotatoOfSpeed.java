package me.TahaCheji.Mafana.gameItems.items.bakersItems;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.stats.PlayerStats;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BakedPotatoOfSpeed implements Listener {

    public static ItemStack BakedPotatoOfSpeed() {
        ItemStack bakedpotato = new ItemStack(Material.BAKED_POTATO);
        ItemMeta bakedpotato_meta = bakedpotato.getItemMeta();
        bakedpotato_meta.setDisplayName(ChatColor.GOLD + "Baked Potato Of Speed");
        ArrayList<String> bakedpotato_lore = new ArrayList<>();
        bakedpotato_lore.add("");
        bakedpotato_lore.add(ChatColor.GOLD + "[Right Click]");
        bakedpotato_lore.add(ChatColor.DARK_GRAY + "Gives 50 speed for 30 seconds.");
        bakedpotato_lore.add("");
        bakedpotato_lore.add("Lapis" + " Item");
        bakedpotato_meta.setLore(bakedpotato_lore);
        bakedpotato.setItemMeta(bakedpotato_meta);
        return bakedpotato.clone();
    }



    @EventHandler
    public void rightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if(e.getItem() == null) {
            return;
        }
        if(e.getItem().getItemMeta() == null) {
            return;
        }
        if(e.getItem().getItemMeta().getDisplayName() == null) {
            return;
        }
            if(e.getItem().getItemMeta().getDisplayName().contains(ChatColor.GOLD + "Baked Potato Of Speed")) {
                PlayerStats pS = PlayerStats.playerStats.get(player.getUniqueId());
                pS.setSpeed(pS.getSpeed() + 100);
                player.sendMessage(ChatColor.GOLD + "Yum!");
                Double test = pS.getSpeed();
                player.sendMessage(String.valueOf(test));
                Main.setPlayerActionBar();
                e.getItem().setType(Material.AIR);
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 10, 10);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        PlayerStats pS = PlayerStats.playerStats.get(player.getUniqueId());
                        pS.setSpeed(pS.getSpeed() - 100);
                    }
                }, 600L);
            }

            }


    }
