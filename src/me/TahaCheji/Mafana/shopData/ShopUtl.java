package me.TahaCheji.Mafana.shopData;

import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.playerData.playerBuyHistory;
import me.TahaCheji.Mafana.playerData.playerInfo.playerCoinSpent;
import me.TahaCheji.Mafana.utils.NBTUtils;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopUtl implements InventoryHolder {
    public Inventory Gui;
    private final String name;
    private final ItemStack[] items;


    public ShopUtl(String name, ItemStack... items) {
        this.name = name;
        this.items = items;
        Gui = Bukkit.createInventory(null, 54, ChatColor.GRAY + "" + ChatColor.BOLD + name);
        ArrayList<String> lore = new ArrayList<String>();

        ItemStack closeShop = new ItemStack(Material.BARRIER);
        ItemMeta closeShopeta = closeShop.getItemMeta();
        closeShopeta.setDisplayName(ChatColor.GRAY + "Close Shop");
        closeShopeta.setLore(lore);
        closeShop.setItemMeta(closeShopeta);
        for(int i = 10; i < 43; i++) {
            if(i >= items.length + 10) {
                break;
            }
                Gui.setItem(i, items[i - 10]);
        }
        for(ItemStack item : Gui.getContents()) {
            if(item == null || item.getType() == Material.AIR) {
                continue;
            }
            if(item.getItemMeta() == null) {
                continue;
            }
            ItemMeta meta = item.getItemMeta();
            if(item == null) {
                continue;
            }
            if(item.getData() == null) {
                continue;
            }
            List<String> list = new ArrayList<>();
            for(String lorenew : item.getItemMeta().getLore()) {
                list.add(lorenew);
            }
            meta.setDisplayName(item.getItemMeta().getDisplayName());
            list.add("");
            if(!(new NBTItem(item).hasKey("BuyValue"))) {
                continue;
            }
            list.add(NBTUtils.getString(item, "BuyValue") + ChatColor.GRAY + " x" + item.getAmount());
            meta.setLore(list);
            item.setItemMeta(meta);
        }
        Gui.setItem(49, closeShop);
        ItemStack greystainedglass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta newmeta = greystainedglass.getItemMeta();
        newmeta.setDisplayName(ChatColor.GRAY + " ");
        newmeta.setLore(lore);
        greystainedglass.setItemMeta(newmeta);

        Gui.setItem(0,greystainedglass);
        Gui.setItem(1,greystainedglass);
        Gui.setItem(2,greystainedglass);
        Gui.setItem(3,greystainedglass);
        Gui.setItem(4,greystainedglass);
        Gui.setItem(5,greystainedglass);
        Gui.setItem(6,greystainedglass);
        Gui.setItem(7,greystainedglass);
        Gui.setItem(8,greystainedglass);
        Gui.setItem(17,greystainedglass);
        Gui.setItem(26,greystainedglass);
        Gui.setItem(35,greystainedglass);
        Gui.setItem(45,greystainedglass);
        Gui.setItem(53,greystainedglass);
        Gui.setItem(52,greystainedglass);
        Gui.setItem(51,greystainedglass);
        Gui.setItem(50,greystainedglass);
        Gui.setItem(48,greystainedglass);
        Gui.setItem(47,greystainedglass);
        Gui.setItem(46,greystainedglass);
        Gui.setItem(44,greystainedglass);
        Gui.setItem(36,greystainedglass);
        Gui.setItem(27,greystainedglass);
        Gui.setItem(18,greystainedglass);
        Gui.setItem(9,greystainedglass);

    }

    @Override
    public Inventory getInventory() {
        return Gui;
    }

    public String getName() {
        return name;
    }

    public ItemStack[] getItems() {
        return items;
    }

    public void getClickedItem(InventoryClickEvent e) throws IOException {
        ItemStack item = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();
        if(!(e.getView().getTitle().contains(getName()))) {
            return;
        }
        e.setCancelled(true);
        if(item == null) {
            return;
        }
        if(item.getType() == Material.BARRIER) {
            player.closeInventory();
        }
        if(item.getType() == Material.GRAY_STAINED_GLASS_PANE) {
            e.setCancelled(true);
        }
        for(ItemStack itemStack : items) {
            if (itemStack == null) {
                return;
            }
            if(item.getItemMeta() == null) {
                return;
            }
            if(itemStack.getItemMeta() == null) {
                return;
            }
            if(!(itemStack.getItemMeta().getDisplayName().contains(item.getItemMeta().getDisplayName()))) {
                continue;
            }
            break;
        }
        if(!(new NBTItem(item).hasKey("BuyValue"))) { //check if it has a value
            return;
        }
        Economy economy = Main.getEcon();
        if(!(economy.has(player, NBTUtils.getInt(item, "value") * item.getAmount()))) { //check if the player has the money
            player.sendMessage(ChatColor.RED + "You do not have enough coins to buy this item.");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
            return;
        }
        economy.withdrawPlayer(player, NBTUtils.getInt(item, "value") * item.getAmount()); //remove the money
        for(ItemStack itemStack : items) { //give the player the item
            if(itemStack.getItemMeta().getDisplayName().contains(item.getItemMeta().getDisplayName())) {
                player.getInventory().addItem(itemStack);
                player.sendMessage(ChatColor.GOLD + "You Bought " + itemStack.getItemMeta().getDisplayName() + " for $" + NBTUtils.getInt(itemStack, "value") * item.getAmount());
                playerCoinSpent.setCoinsSpent(player, playerCoinSpent.getCoinsSpent(player) + NBTUtils.getInt(itemStack, "value") * item.getAmount());
                playerBuyHistory.setBuyHistory(player, item);
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
            }
        }
    }


}
