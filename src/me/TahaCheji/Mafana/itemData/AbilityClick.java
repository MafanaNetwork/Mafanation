package me.TahaCheji.Mafana.itemData;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class AbilityClick {

    public void rightClick(PlayerInteractEvent e, ItemStack itemStack) {
        Player player = e.getPlayer();
        if (e.getItem() == null) {
            return;
        }
        if (e.getItem().getItemMeta() == null) {
            e.setCancelled(true);
            return;
        }
        if (new NBTItem(itemStack).getString("ItemKey") == null) {
            e.setCancelled(true);
            return;
        }
        if (!(new NBTItem(player.getItemInHand()).getString("ItemKey").equalsIgnoreCase(new NBTItem(itemStack).getString("ItemKey")))) {
            e.setCancelled(true);
            return;
        }
        if(!(e.getAction() == Action.RIGHT_CLICK_AIR)) return;
        if(player.getNearbyEntities(5, 5, 5) instanceof Player) {
            player.sendMessage(ChatColor.RED + "You cannot use this near a Player");
            e.setCancelled(true);
         } else {
            e.setCancelled(false);
        }




    }

}
