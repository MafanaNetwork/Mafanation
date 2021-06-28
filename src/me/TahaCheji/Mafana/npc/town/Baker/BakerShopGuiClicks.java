package me.TahaCheji.Mafana.npc.town.Baker;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.gameItems.items.bakersItems.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BakerShopGuiClicks implements Listener {

    /*
    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Economy econ = Main.getEcon();
        if (!(e.getView().getTitle().contains("Baker"))) {
            return;
        }
        e.setCancelled(true);

        if (e.getSlot() == 10) {
            if (econ.has(player, 200)) {
                player.getInventory().addItem(LoafOfHealth.LoafOfHealth());
                player.sendMessage(ChatColor.GOLD + "You purchased " + e.getCurrentItem().getItemMeta().getDisplayName());
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
                econ.withdrawPlayer(player, 200);
            } else {
                player.sendMessage(ChatColor.GOLD + "You don't have enough coins!");
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
            }
        }
        if (e.getSlot() == 11) {
            if (econ.has(player, 500)) {
                player.getInventory().addItem(ManaInfusedPie.ManaInfusedPie());
                player.sendMessage(ChatColor.GOLD + "You purchased " + e.getCurrentItem().getItemMeta().getDisplayName());
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
                econ.withdrawPlayer(player, 500);
            } else {
                player.sendMessage(ChatColor.GOLD + "You don't have enough coins!");
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
            }
        }
        if (e.getSlot() == 12) {
            if (econ.has(player, 1000)) {
                player.getInventory().addItem(StewOfStrength.StewOfStrength());
                player.sendMessage(ChatColor.GOLD + "You purchased " + e.getCurrentItem().getItemMeta().getDisplayName());
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
                econ.withdrawPlayer(player, 1000);
            } else {
                player.sendMessage(ChatColor.GOLD + "You don't have enough coins!");
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
            }
        }
        if (e.getSlot() == 13) {
            if (econ.has(player, 50)) {
                player.getInventory().addItem(CookieOfStrength.CookieOfStrength());
                player.sendMessage(ChatColor.GOLD + "You purchased " + e.getCurrentItem().getItemMeta().getDisplayName());
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
                econ.withdrawPlayer(player, 50);
            } else {
                player.sendMessage(ChatColor.GOLD + "You don't have enough coins!");
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
            }
        }
        if (e.getSlot() == 14) {
            if (econ.has(player, 1500)) {
                player.getInventory().addItem(SlicesOfHealth.SlicesOfHealth());
                player.sendMessage(ChatColor.GOLD + "You purchased " + e.getCurrentItem().getItemMeta().getDisplayName());
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
                econ.withdrawPlayer(player, 1500);
            } else {
                player.sendMessage(ChatColor.GOLD + "You don't have enough coins!");
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
            }
        }
        if (e.getSlot() == 15) {
            if (econ.has(player, 450)) {
                player.getInventory().addItem(BakedPotatoOfSpeed.BakedPotatoOfSpeed());
                player.sendMessage(ChatColor.GOLD + "You purchased " + e.getCurrentItem().getItemMeta().getDisplayName());
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
                econ.withdrawPlayer(player, 450);
            } else {
                player.sendMessage(ChatColor.GOLD + "You don't have enough coins!");
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
            }
        }
    }

     */



}
