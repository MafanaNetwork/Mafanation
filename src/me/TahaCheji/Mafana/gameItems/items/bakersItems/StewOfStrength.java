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

public class StewOfStrength implements Listener {

    public static Main plugin = Main.getPlugin(Main.class);

    public static ItemStack StewOfStrength() {
        ItemStack rabbitstew = new ItemStack(Material.RABBIT_STEW);
        ItemMeta rabbitstew_meta = rabbitstew.getItemMeta();
        rabbitstew_meta.setDisplayName(ChatColor.GOLD + "Stew Of Strength");
        ArrayList<String> rabbitstew_lore = new ArrayList<>();
        rabbitstew_lore.add("");
        rabbitstew_lore.add(ChatColor.GOLD + "[Right Click]");
        rabbitstew_lore.add(ChatColor.WHITE + "Gives 10 strength for 30 seconds.");
        rabbitstew_lore.add(ChatColor.translateAlternateColorCodes('&', "&dStrength: &c+10"));
        rabbitstew_lore.add("");
        rabbitstew_lore.add("Lapis" + " Item");
        rabbitstew_meta.setLore(rabbitstew_lore);
        rabbitstew.setItemMeta(rabbitstew_meta);
        return rabbitstew.clone();
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
            if(e.getItem().getItemMeta().getDisplayName().contains(ChatColor.GOLD + "Stew Of Strength")) {
                PlayerStats pS = PlayerStats.playerStats.get(player.getUniqueId());
                pS.setStrength(pS.getStrength() + 10);
                player.sendMessage(ChatColor.GOLD + "Yum!");
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 10, 10);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        pS.setStrength(pS.getStrength() - 10);
                    }
                }, 1200L);
            }

            }


    }
