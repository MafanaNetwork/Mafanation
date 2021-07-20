package me.TahaCheji.Mafana.gameItems.Armor;

import me.TahaCheji.Mafana.itemData.EnchancmentsUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RottenCap {

    public static ItemStack RottenCap(Player player) {
        ItemStack itemStack = new ItemStack(Material.IRON_HELMET);
        ItemMeta itemMeta = itemStack.getItemMeta();
        int random = ThreadLocalRandom.current().nextInt(5);
        ArrayList<String> lore = new ArrayList<String>();
        itemMeta.setUnbreakable(true);
            itemMeta.setDisplayName(RarityType.IRON.getLore() +  "RottenCap");
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        //skeletonMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        lore.add("");
        lore.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
        lore.add("§7Level §f" + (double) 0);
        if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
            lore.add("§c" + player.getName());
        }
        lore.add("");
        lore.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(player, itemStack));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&dStrength: &c+20"));

            lore.add(ChatColor.translateAlternateColorCodes('&', "&cHealth: &c+50 HP"));

            lore.add(ChatColor.translateAlternateColorCodes('&', "&9Mana: &c+80"));

        lore.add("");
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Level 10 Ability [Unknown]");
        lore.add("");
            lore.add(RarityType.IRON.getLore() + " Helmet");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        EnchancmentsUtl.Enchancments(itemStack, player);
        return itemStack.clone();
    }



}
