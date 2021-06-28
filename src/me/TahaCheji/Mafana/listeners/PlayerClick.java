package me.TahaCheji.Mafana.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerClick implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack itemStack = player.getItemInHand();
        if(itemStack == null) {
            return;
        }
        if(itemStack.getItemMeta() == null) {
            return;
        }
        if(itemStack.getItemMeta().getDisplayName() == null) {
            return;
        }
        for(Entity entity : player.getNearbyEntities(5, 5, 5)) {
            if(entity instanceof Player) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You cannot use that near a NPC!");
                return;
            }
        }

    }


}
