package me.TahaCheji.Mafana.crafting;

import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RecipeGui implements InventoryHolder {

    public Inventory GUI;

    public RecipeGui(MasterTable table) {
        GUI = Bukkit.createInventory(null, 27, ChatColor.GRAY + "" + ChatColor.BOLD + table.getFinalItem().getItemMeta().getDisplayName() + " Recipe");
        ArrayList<String> lore = new ArrayList<String>();

        ItemStack closeShop = new ItemStack(Material.BARRIER);
        ItemMeta closeShopeta = closeShop.getItemMeta();
        closeShopeta.setDisplayName(ChatColor.GRAY + "Close Shop");
        closeShopeta.setLore(lore);
        closeShop.setItemMeta(closeShopeta);

        ItemStack newItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta newmeta = newItem.getItemMeta();
        newmeta.setDisplayName(ChatColor.GRAY + "");
        newmeta.setLore(lore);
        newItem.setItemMeta(newmeta);
        for (int emptySlot = 0; emptySlot < GUI.getSize(); emptySlot++) {
            if (GUI.getItem(emptySlot) == null || GUI.getItem(emptySlot).getType().equals(Material.AIR)) {
                GUI.setItem(emptySlot, newItem);
            }
        }

        GUI.setItem(1, table.getCheckSlot1());
        GUI.setItem(2, table.getCheckSlot2());
        GUI.setItem(3, table.getCheckSlot3());

        GUI.setItem(10, table.getCheckSlot4());
        GUI.setItem(11, table.getCheckSlot5());
        GUI.setItem(12, table.getCheckSlot6());

        GUI.setItem(19, table.getCheckSlot7());
        GUI.setItem(20, table.getCheckSlot8());
        GUI.setItem(21, table.getCheckSlot9());

        GUI.setItem(14, table.getFinalItem());


    }

    @Override
    public Inventory getInventory() {
        return GUI;
    }


}
