package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.itemData.EnchancmentsUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class WarriorsBlade implements Listener {


    public static ItemStack WarriorsBlade(Player player) {
        ItemStack skeletonSword = new ItemStack(Material.IRON_SWORD);
        ItemMeta skeletonMeta = (ItemMeta) skeletonSword.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        skeletonMeta.setUnbreakable(true);
            skeletonMeta.setDisplayName(RarityType.GOLD.getLore() +  " Warrior’s Blade");
        skeletonMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        skeletonMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        skeletonMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        lore.add("");
        lore.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
        lore.add("§7Level §f" + (double) 0);
        if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
            lore.add("§c" + player.getName());
        }
        lore.add("");
        lore.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(player, skeletonSword));
            //6
            lore.add(ChatColor.translateAlternateColorCodes('&', "&dStrength: &c+750"));
            //7
            lore.add(ChatColor.translateAlternateColorCodes('&', "&cHealth: &c+500 HP"));
            //8
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Mana: &c+60"));
             //9
             lore.add(ChatColor.translateAlternateColorCodes('&', "&bSpeed: &c+10"));
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Level 10 Ability [Unknown]");
        lore.add("");
            lore.add(RarityType.GOLD.getLore() + " Sword");
        skeletonMeta.setLore(lore);
        skeletonSword.setItemMeta(skeletonMeta);
        EnchancmentsUtl.Enchancments(skeletonSword, player);
        return skeletonSword.clone();
    }




    }






