package me.TahaCheji.Mafana.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.crafting.CraftingGui;
import me.TahaCheji.Mafana.crafting.MasterTable;
import me.TahaCheji.Mafana.crafting.RecipeGui;
import me.TahaCheji.Mafana.shopData.ShopUtl;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class PlayerClick implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack itemStack = player.getItemInHand();
        if (itemStack == null) {
            return;
        }
        if (itemStack.getItemMeta() == null) {
            return;
        }
        if (itemStack.getItemMeta().getDisplayName() == null) {
            return;
        }
        for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
            if (entity instanceof Player) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You cannot use that near a NPC!");
                return;
            }
        }

    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e) throws IOException {
        if(e.getView().getTitle().contains("Recipe")) {
            e.setCancelled(true);
        }

        Player player = (Player) e.getWhoClicked();
        for(ShopUtl shopUtl : Main.shopUtl) {
            shopUtl.getClickedItem(e);
        }

    }


    @EventHandler
    public void rightClick(PlayerInteractEvent e) {
        if(!(e.getAction() == Action.RIGHT_CLICK_AIR)) return;
        for(MasterTable table : Main.recipes) {
            for(ItemStack itemStack : table.getRecipe()) {
                if(e.getItem() == null) {
                    continue;
                }
                if(e.getItem().getItemMeta() == null) {
                    continue;
                }
                if(itemStack == null) {
                    continue;
                }
                if(itemStack.getItemMeta() == null) {
                    continue;
                }
                if(!new NBTItem(e.getItem()).hasNBTData()) {
                    continue;
                }
                if(!new NBTItem(e.getItem()).hasKey("ItemKey")) {
                    continue;
                }
                if(!new NBTItem(e.getItem()).getString("ItemKey").equalsIgnoreCase(new NBTItem(itemStack).getString("ItemKey"))) {
                    continue;
                }
                e.getPlayer().openInventory(new RecipeGui(table).getInventory());
            }
        }
    }



    @EventHandler
    public void playerRightClick(InventoryOpenEvent e) {
        Player player = (Player) e.getPlayer();
        Inventory inv = e.getInventory();
        if(!(inv.getType() == InventoryType.WORKBENCH)) {
            return;
        }
        e.setCancelled(true);
        CraftingGui gui = new CraftingGui();
        player.openInventory(gui.getInventory());
        player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 10, 10);
    }


}
