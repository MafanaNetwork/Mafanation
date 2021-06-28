package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.crafting.CraftingUtl;
import me.TahaCheji.Mafana.gameItems.items.MagicCookie;
import me.TahaCheji.Mafana.itemData.ClickType;
import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.Vector;

public class Moon implements Listener {


    public static ItemStack Moon(Player player) {
        final ItemStack moon = ItemUtl.createItem(Material.END_STONE, 1, ItemType.SWORD, player, true, true, RarityType.OBSIDAIN, "Moon", 300, 12000, 0, -12,
                "Gravitational force, mobs in a 5 by 5 area are dragged towards you.", ClickType.RIGHT_CLICK, true, true, 10000, null,"in the name of the moon, I’ll punish you!");
        return moon;
    }

    @EventHandler
    public void rightClick(PlayerInteractEvent e) {
        if (!(e.getPlayer() instanceof Player)) {
            return;
        }
        if(e.getItem() == null) {
            return;
        }
        if(e.getItem().getItemMeta() == null) {
            return;
        }
        if(e.getItem().getItemMeta().getDisplayName() == null) {
            return;
        }
        Player player = (Player) e.getPlayer();
        if(!(player.getItemInHand().getItemMeta().getDisplayName().contains("Moon"))) {
            return;
        }
        if(!(e.getAction() == Action.RIGHT_CLICK_AIR)) {
            return;
        }
       for(Entity entity : player.getNearbyEntities(5, 5, 5)) {
           if(entity.getType().equals(NPC.class)) {
               return;
           }
           Location location = player.getLocation();
           entity.teleport(location);
           player.playSound(location, Sound.ENTITY_ENDER_PEARL_THROW, 10, 10);
           player.sendMessage("in the name of the moon, I'll punish you!");
       }
    }



}
