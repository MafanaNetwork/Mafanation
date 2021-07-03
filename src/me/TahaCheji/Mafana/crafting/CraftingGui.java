package me.TahaCheji.Mafana.crafting;

import me.TahaCheji.Mafana.dungeons.AquaDungeon.ReservoirCap;
import me.TahaCheji.Mafana.dungeons.AquaDungeon.WaterBreathBow;
import me.TahaCheji.Mafana.gameItems.Armor.RottenCap;
import me.TahaCheji.Mafana.gameItems.Armor.RottenPants;
import me.TahaCheji.Mafana.gameItems.Armor.RottenShirt;
import me.TahaCheji.Mafana.gameItems.Armor.RottenShoes;
import me.TahaCheji.Mafana.gameItems.Weapons.*;
import me.TahaCheji.Mafana.gameItems.items.MagicCookie;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CraftingGui implements InventoryHolder {

    public Inventory GUI;

    public CraftingGui() {
        GUI = Bukkit.createInventory(null, 27, ChatColor.GRAY + "" + ChatColor.BOLD + "MafanaCraft");
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

        GUI.setItem(1, null);
        GUI.setItem(2, null);
        GUI.setItem(3, null);

        GUI.setItem(10, null);
        GUI.setItem(11, null);
        GUI.setItem(12, null);

        GUI.setItem(19, null);
        GUI.setItem(20, null);
        GUI.setItem(21, null);

        GUI.setItem(14, null);


    }

    @Override
    public Inventory getInventory() {
        return GUI;
    }


}
