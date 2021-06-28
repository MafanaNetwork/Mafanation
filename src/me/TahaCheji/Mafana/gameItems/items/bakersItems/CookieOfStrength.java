package me.TahaCheji.Mafana.gameItems.items.bakersItems;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.stats.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CookieOfStrength implements Listener {

    public static Main plugin = Main.getPlugin(Main.class);

    public static ItemStack CookieOfStrength() {
        ItemStack cookie = new ItemStack(Material.COOKIE);
        ItemMeta cookie_meta = cookie.getItemMeta();
        cookie_meta.setDisplayName(ChatColor.GOLD + "Cookie Of Strength");
        ArrayList<String> cookie_lore = new ArrayList<>();
        cookie_lore.add("");
        cookie_lore.add(ChatColor.GOLD + "[Right Click]");
        cookie_lore.add(ChatColor.WHITE + "Gives 3 strength for 30 seconds.");
        cookie_lore.add("");
        cookie_lore.add("Lapis" + " Item");
        cookie_meta.setLore(cookie_lore);
        cookie.setItemMeta(cookie_meta);
        return cookie.clone();
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
            if(e.getItem().getItemMeta().getDisplayName().contains(ChatColor.GOLD + "Cookie Of Strength")) {
                PlayerStats pS = PlayerStats.playerStats.get(player.getUniqueId());
                pS.setStrength(PlayerStats.getStrength(player) + 100);
                player.sendMessage(ChatColor.GOLD + "Yum!");
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 10, 10);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        PlayerStats pS = PlayerStats.playerStats.get(player.getUniqueId());
                        pS.setStrength(pS.getStrength() - 3);
                    }
                }, 1200L);
            }

            }


    }
