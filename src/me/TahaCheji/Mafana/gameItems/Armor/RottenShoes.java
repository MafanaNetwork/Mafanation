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

public class RottenShoes {

    public static ItemStack RottenShoes(Player player) {
        ItemStack itemStack = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        int random = ThreadLocalRandom.current().nextInt(5);
        ArrayList<String> lore = new ArrayList<String>();
        itemMeta.setUnbreakable(true);
            itemMeta.setDisplayName(RarityType.IRON.getLore() +   "RottenShoes");
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        lore.add("");
        lore.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
        lore.add("§7Level §f" + (double) 0);
        if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
            lore.add("§c" + player.getName());
        }
        lore.add("");
        lore.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(player, itemStack));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&dStrength: &c+15"));

            lore.add(ChatColor.translateAlternateColorCodes('&', "&cHealth: &c+45 HP"));

            lore.add(ChatColor.translateAlternateColorCodes('&', "&9Mana: &c+50"));

            lore.add(ChatColor.translateAlternateColorCodes('&', "&bSpeed: &c+10"));
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Level 10 Ability [Unknown]");
        lore.add("");
            lore.add(RarityType.IRON.getLore() + " Boots");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        EnchancmentsUtl.Enchancments(itemStack, player);
        return itemStack.clone();
    }

}
