package me.TahaCheji.Mafana.gui;

import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ShopGuiManager implements Listener {
    /*

    public static HashMap<UUID, ItemStack[]> saveinv = new HashMap();

    @EventHandler
    public void openInventory(InventoryOpenEvent e) {
        Player player = (Player) e.getPlayer();
        if(!e.getView().getTitle().contains("Shop")) {
            return;
        }
        ItemStack[] contents = player.getInventory().getContents().clone();
        saveinv.put(player.getUniqueId(), contents);
        System.out.print(contents);
        for (ItemStack item : player.getInventory().getContents()) {
            if(item == null) {
                continue;
            }
            ItemMeta meta = item.getItemMeta();
            if(item.getData() == null) {
                return;
            }
            List<String> list = new ArrayList<>();
            for(String lore : item.getItemMeta().getLore()) {
                list.add(lore);
            }
                list.add("");
                list.add(NBTUtils.getString(item, "SellValue"));
            meta.setLore(list);
            item.setItemMeta(meta);
        }
        for(ItemStack item : e.getInventory().getContents()) {
            ItemMeta meta = item.getItemMeta();
            if(item == null) {
                continue;
            }
            if(item.getData() == null) {
                return;
            }
            List<String> list = new ArrayList<>();
            for(String lore : item.getItemMeta().getLore()) {
                list.add(lore);
            }
                list.add("");
                list.add(NBTUtils.getString(item, "BuyValue"));
            meta.setLore(list);
            item.setItemMeta(meta);
        }
    }
    @EventHandler
    public void closeInevntory(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        if(!e.getView().getTitle().contains("Shop")) {
            return;
        }
        ItemStack[] contents = saveinv.get(e.getPlayer().getUniqueId());
        player.getInventory().clear();
        player.getInventory().setContents(contents);
        saveinv.remove(player.getUniqueId());
    }

     */

}
