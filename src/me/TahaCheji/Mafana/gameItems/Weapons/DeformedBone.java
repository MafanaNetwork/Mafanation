package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.itemData.ClickType;
import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import me.TahaCheji.Mafana.stats.PlayerStats;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class DeformedBone implements Listener {

    public ItemStack getDeformedBone(Player player) {
        ItemStack itemStack = ItemUtl.createItem(Material.BONE, 1, ItemType.SWORD, player, true, true, RarityType.COAL, "DeformedBone", 0, 0, 0, 0, "Explode. Kills all mobs in a 5 by 5 ratios.", ClickType.RIGHT_CLICK, true, false, 5000, null, "BOOM!");

        return itemStack;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        ItemStack itemStack = e.getItem();
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
        if(!(player.getItemInHand().getItemMeta().getDisplayName().contains("DeformedBone")) || player.getItemInHand() == null) {
            return;
        }
        for(Entity entity : player.getNearbyEntities(5, 5, 5)) {
            if(entity instanceof Player) {
                return;
            }
            player.spawnParticle(Particle.EXPLOSION_LARGE, entity.getLocation(), 1);
            entity.remove();
        }
        player.spawnParticle(Particle.EXPLOSION_LARGE, player.getLocation(), 5);
        ItemStack bones = player.getInventory().getItemInMainHand();
        bones.setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
        player.setItemInHand(bones);
        player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 10);
    }

}
