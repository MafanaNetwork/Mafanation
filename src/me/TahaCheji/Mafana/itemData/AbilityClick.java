package me.TahaCheji.Mafana.itemData;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class AbilityClick implements Listener {

    public void rightClick(PlayerInteractEvent e, ItemStack itemStack) {
        Player player = e.getPlayer();
        if(e.getItem() == null) {
            return;
        }
        if(e.getItem().getItemMeta() == null) {
            return;
        }
        if(e.getItem().getItemMeta().getDisplayName() == null) {
            return;
        }
        if(!(player.getItemInHand().getItemMeta().getDisplayName().contains(itemStack.getItemMeta().getDisplayName()))) {
            return;
        }
    }

}
