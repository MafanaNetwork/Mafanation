package me.TahaCheji.Mafana.gameItems.items.bakersItems;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.stats.PlayerStats;
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

public class ManaInfusedPie implements Listener {

    public static Main plugin = Main.getPlugin(Main.class);

    public static ItemStack ManaInfusedPie() {
        ItemStack pie = new ItemStack(Material.PUMPKIN_PIE);
        ItemMeta pie_meta = pie.getItemMeta();
        pie_meta.setDisplayName(ChatColor.GOLD +  "Mana Infused Pie");
        ArrayList<String> pie_lore = new ArrayList<>();
        pie_lore.add("");
        pie_lore.add(ChatColor.GOLD + "[Right Click]");
        pie_lore.add(ChatColor.WHITE + "Gives 100 mana that will not regenerate");
        pie_lore.add(ChatColor.WHITE + "(You cant consume more than 1 Mana Infused Pie at a time.");
        pie_lore.add(ChatColor.translateAlternateColorCodes('&', "&9Mana: &c+100"));
        pie_lore.add("");
        pie_lore.add("Lapis" + " Item");
        pie_meta.setLore(pie_lore);
        pie.setItemMeta(pie_meta);
        return pie.clone();
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
            if(e.getItem().getItemMeta().getDisplayName().contains(ChatColor.GOLD +  "Mana Infused Pie")) {
                PlayerStats pS = PlayerStats.playerStats.get(player.getUniqueId());
                pS.setCurrentIntelligence(pS.getCurrentIntelligence() + 100);
                player.sendMessage(ChatColor.GOLD + "Yum!");
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 10, 10);
            }

            }


    }
