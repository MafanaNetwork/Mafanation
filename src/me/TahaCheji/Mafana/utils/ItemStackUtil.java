package me.TahaCheji.Mafana.utils;

import com.mojang.authlib.GameProfile;
import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemStackUtil {

    private ItemStack item;
    private ItemMeta im;

    public static ItemStack addItemTags(ItemStack item, int Value, ItemType itemType, RarityType rarityType) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if (item.getItemMeta().getLore() == null) {
            List<String> list = new ArrayList<>();
            String newLore = rarityType.getLore() + itemType.getLore();
            ItemMeta meta = item.getItemMeta();
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            list.add("");
            list.add(newLore);
            meta.setLore(list);
            item.setItemMeta(meta);
        }
        if (!(item.getItemMeta().getLore().contains(rarityType.getLore() + itemType.getLore()) || new NBTItem(item).hasKey("ItemKey") || new NBTItem(item).hasKey("ItemRarity"))) {
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(rarityType.getColor() + meta.getDisplayName());
            List<String> list = new ArrayList<>();
            if ((item.getItemMeta().getLore() != null)) {
                for (String string : meta.getLore()) {
                    if (string.contains(rarityType.getLore())) {
                        break;
                    }
                    list.add(string);
                }
            }
            String newLore = rarityType.getLore() + itemType.getLore();
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            list.add("");
            list.add(newLore);
            meta.setLore(list);
            item.setItemMeta(meta);
        }
        item = NBTUtils.setInt(item, "value", Value);
        item = NBTUtils.setString(item, "SellValue", ChatColor.GOLD + "Sell Value: $" + Value);
        item = NBTUtils.setString(item, "BuyValue", ChatColor.GOLD + "Buy Value: $" + Value);

        item = NBTUtils.setString(item, "ItemKey", item.getItemMeta().getDisplayName());
        item = NBTUtils.setString(item, "ItemType", itemType.getLore());
        item = NBTUtils.setString(item, "ItemRarity", rarityType.getLore());

        item = NBTUtils.setString(item, "ItemDate", dtf.format(now));
        return item;
    }

    public static ItemStack setItemTags(ItemStack item, int Value, ItemType itemType, RarityType rarityType, Player player) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        NBTItem tags = new NBTItem(item);

        if(player != null) {
            tags.setUUID("PlayerUUID", player.getUniqueId());
        } else {
            tags.setString("PlayerUUID", "Nothing");
        }

        tags.setItemStack("Item", item);

        item = tags.getItem();
        item = NBTUtils.setInt(item, "value", Value);
        item = NBTUtils.setString(item, "SellValue", ChatColor.GOLD + "Sell Value: $" + Value);
        item = NBTUtils.setString(item, "BuyValue", ChatColor.GOLD + "Buy Value: $" + Value);

        item = NBTUtils.setString(item, "ItemKey", item.getItemMeta().getDisplayName());
        item = NBTUtils.setString(item, "ItemType", itemType.getLore());
        item = NBTUtils.setString(item, "ItemRarity", rarityType.getLore());

        item = NBTUtils.setString(item, "ItemDate", dtf.format(now));
        return item;
    }

    public ItemStackUtil(Material material, String name) {
        item = new ItemStack(material);
        this.im = this.item.getItemMeta();
        this.setDisplayName(name);
    }

    public static List<String> stringToLore(String string, int characterLimit, ChatColor prefixColor) {
        String[] words = string.split(" ");
        List<String> lines = new ArrayList();
        StringBuilder currentLine = new StringBuilder();
        String[] var6 = words;
        int var7 = words.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            String word = var6[var8];
            if (!word.equals("/newline")) {
                if (currentLine.toString().equals("")) {
                    currentLine = new StringBuilder(word);
                } else {
                    currentLine.append(" ").append(word);
                }
            }

            if (word.equals("/newline") || currentLine.length() + word.length() >= characterLimit) {
                String newLine = currentLine.toString();
                lines.add("" + prefixColor + newLine);
                currentLine = new StringBuilder();
            }
        }

        if (currentLine.length() > 0) {
            lines.add("" + prefixColor + currentLine);
        }

        return lines;
    }

    public ItemStackUtil(Material material, String name, int amount, byte data) {
        item = new ItemStack(material, amount, data);
        this.im = this.item.getItemMeta();
        this.setDisplayName(name);

    }

    public boolean isLeatherArmor() {
        return this.item.getType().equals(Material.LEATHER_BOOTS) || this.item.getType().equals(Material.LEATHER_CHESTPLATE) || this.item.getType().equals(Material.LEATHER_HELMET) || this.item.getType().equals(Material.LEATHER_LEGGINGS);
    }

    public ItemStackUtil setUnbreakable(boolean bol) {
        NBTItem nbt = new NBTItem(this.item);
        nbt.setBoolean("Unbreakablye", bol);
        this.item = nbt.getItem();
        return this;
    }

    public ItemStackUtil setString(String key, String value) {
        if(value == null) return this;
        NBTItem nbt = new NBTItem(getItem());
        nbt.setString(key, value);
        this.setItem(nbt.getItem());
        return this;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public boolean isSkull() {
        return this.item.getType().equals(Material.LEGACY_SKULL);
    }

    public ItemStackUtil setAmount(int amount) {
        this.item.setAmount(amount);
        return this;
    }

    public ItemStackUtil setColor(Color c) {
        LeatherArmorMeta im = (LeatherArmorMeta) item.getItemMeta();
        im.setColor(c);
        item.setItemMeta(im);
        return this;
    }

    public ItemStackUtil setLore(ArrayList<String> lore) {
        this.im = this.item.getItemMeta();
        this.im.setLore(lore);
        this.item.setItemMeta(this.im);
        return this;
    }

    public ItemStackUtil setDisplayName(String name) {
        this.im = item.getItemMeta();
        this.im.setDisplayName(name);
        this.item.setItemMeta(this.im);
        return this;
    }

    /*
    public ItemStackUtil setTexture(String texture) {
        SkullMeta hm = (SkullMeta) this.item.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", texture));
        try {
            Field field = hm.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(hm, profile);
        } catch(IllegalArgumentException  | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        this.item.setItemMeta(hm);
        return this;
    }

     */

    public ItemStackUtil setItem(ItemStack item) {
        this.item = item;
        return this;
    }

}
