package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.itemData.ClickType;
import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Dynamite implements Listener {


    public static ItemStack Dynamite(Player player) {
        final ItemStack Dynamite = ItemUtl.createItem(Material.TNT, 1,
                ItemType.SWORD, player, true, true, RarityType.DIAMOND,
                "Dynamite", 150, 400, 0, 6,
                "Explodes on impact!", ClickType.HIT, false,
                false, 0, null,"Oh yeah im a creeper so nice, " +
                        "nice to meet ya!");
        return Dynamite;
    }


}
