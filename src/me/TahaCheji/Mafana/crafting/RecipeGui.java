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

    public RecipeGui(Player player, ItemStack item) {
        GUI = Bukkit.createInventory(null, 27, ChatColor.GRAY + "" + ChatColor.BOLD + "test");
        ArrayList<String> lore = new ArrayList<String>();

        ItemStack closeShop = new ItemStack(Material.BARRIER);
        ItemMeta closeShopeta = closeShop.getItemMeta();
        closeShopeta.setDisplayName(ChatColor.GRAY + "Close Shop");
        closeShopeta.setLore(lore);
        closeShop.setItemMeta(closeShopeta);

        ItemStack newItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta newmeta = newItem.getItemMeta();
        newmeta.setDisplayName(ChatColor.GRAY + " ");
        newmeta.setLore(lore);
        newItem.setItemMeta(newmeta);
        for (int emptySlot = 0; emptySlot < GUI.getSize(); emptySlot++) {
            if (GUI.getItem(emptySlot) == null || GUI.getItem(emptySlot).getType().equals(Material.AIR)) {
                GUI.setItem(emptySlot, newItem);
            }
        }

        File playerData = new File("plugins/Mafanation/Weapons/" + item.getItemMeta().getDisplayName() + "/recipe.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        ItemStack test = pD.getItemStack("slot1");



        GUI.setItem(1, test);
        GUI.setItem(2, null);
        GUI.setItem(3, null);

        GUI.setItem(10, null);
        GUI.setItem(11, null);
        GUI.setItem(12, null);

        GUI.setItem(19, null);
        GUI.setItem(20, null);
        GUI.setItem(21, null);

        GUI.setItem(14, item);


    }

    @Override
    public Inventory getInventory() {
        return GUI;
    }


}
