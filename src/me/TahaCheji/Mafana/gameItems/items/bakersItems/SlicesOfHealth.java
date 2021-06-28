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

public class SlicesOfHealth implements Listener {

    public static Main plugin = Main.getPlugin(Main.class);

    public static ItemStack SlicesOfHealth() {
        ItemStack cake = new ItemStack(Material.CAKE);
        ItemMeta cake_meta = cake.getItemMeta();
        cake_meta.setDisplayName(ChatColor.GOLD + "Slice Of Health");
        ArrayList<String> cake_lore = new ArrayList<>();
        cake_lore.add("");
        cake_lore.add(ChatColor.GOLD  + "[Right Click]");
        cake_lore.add(ChatColor.WHITE + "Gives 100 health that will not regenerate");
        cake_lore.add(ChatColor.WHITE + "(You cant consume more than 1 slices of health at a time)");
        cake_lore.add(ChatColor.translateAlternateColorCodes('&', "&cHealth: &c+100 HP"));
        cake_lore.add("");
        cake_lore.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 1500");
        cake_lore.add("");
        cake_lore.add("Lapis" + " Item");
        cake_meta.setLore(cake_lore);
        cake.setItemMeta(cake_meta);
        return cake.clone();
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
            if(e.getItem().getItemMeta().getDisplayName().contains(ChatColor.GOLD + "Slice Of Health")) {
                PlayerStats pS = PlayerStats.playerStats.get(player.getUniqueId());
                pS.setCurrentHealth(pS.getCurrentHealth() + 30);
                player.sendMessage(ChatColor.GOLD + "Yum!");
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 10, 10);
            }

            }


    }
