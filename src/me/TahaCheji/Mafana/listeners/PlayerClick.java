package me.TahaCheji.Mafana.listeners;

import me.TahaCheji.Mafana.crafting.CraftingGui;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
