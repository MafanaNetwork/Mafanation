package me.TahaCheji.Mafana.itemData;

import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public enum ItemType {

    SWORD("Sword"),
    TOOL("Tool"),
    BOW("Bow"),
    ITEM("Item"),
    ARMOR("Armor"),
    BOOTS("Boots"),
    LEGGGINGS("Leggings"),
    CHESTPLATE("Chestplate"),
    HELMET("Helmet"),
    SPELL("Spell"),
    MATERIAL( "Material");


    private final String lore;

    ItemType(String lore) {
        this.lore = lore;
    }

    public String getLore() {
        return lore;
    }


    public static void changeType(ItemStack itemStack, ItemType itemType) {
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
        List<String> list = new ArrayList<>();
        for(String string : Objects.requireNonNull(meta.getLore())) {
            if(meta.getLore() == null) {
                return;
            }
            String newLore = string.replaceAll(NBTUtils.getString(itemStack, "ItemType"), itemType.getLore());
            NBTUtils.setString(itemStack, "ItemType", itemType.getLore());
            list.add(newLore);
        }
        meta.setLore(list);
        itemStack.setItemMeta(meta);
    }


}
