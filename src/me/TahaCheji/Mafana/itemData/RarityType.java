package me.TahaCheji.Mafana.itemData;

import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public enum RarityType {

    WOOD(ChatColor.GRAY, ChatColor.GRAY+ "Wooden "),
    COAL(ChatColor.GRAY, ChatColor.GRAY + "Coaled "),
    IRON(ChatColor.WHITE, ChatColor.WHITE + "Irony "),
    LAPIS(ChatColor.AQUA, ChatColor.AQUA + "Lapsed "),
    GOLD(ChatColor.GOLD, ChatColor.GOLD + "Golden "),
    REDSTONE(ChatColor.RED, ChatColor.RED + "Redstone "),
    DIAMOND(ChatColor.BLUE, ChatColor.BLUE + "Diamond "),
    OBSIDAIN(ChatColor.DARK_GRAY, ChatColor.DARK_GRAY + "Obsidian "),
    ADMIN(ChatColor.DARK_RED, ChatColor.RED + "Admired ");

    private final ChatColor color;

    private final String lore;

   RarityType(ChatColor color, String lore) {
        this.color = color;
        this.lore = lore;
    }


    public ChatColor getColor() {
        return color;
    }

    public String getLore() {
        return lore;
    }

    public static void changeRarity(ItemStack itemStack, RarityType rarityType) {
       if(itemStack == null) {
           return;
       }
       if(itemStack.getItemMeta() == null) {
           return;
       }
       if(itemStack.getItemMeta().getLore() == null) {
           return;
       }
        ItemMeta meta = itemStack.getItemMeta();
       meta.setDisplayName(rarityType.getColor() + meta.getDisplayName());
        List<String> list = new ArrayList<>();
       for(String string : Objects.requireNonNull(meta.getLore())) {
           if(meta.getLore() == null) {
               return;
           }
           String newLore = string.replaceAll(NBTUtils.getString(itemStack, "ItemRarity"), rarityType.getLore());
           NBTUtils.setString(itemStack, "ItemRarity", rarityType.getLore());
          list.add(newLore);
       }
       meta.setLore(list);
       itemStack.setItemMeta(meta);
    }



}
