package me.TahaCheji.Mafana.gameMobs.mobs;

import me.TahaCheji.Mafana.gameItems.Weapons.ExcavatorMasterSpade;
import me.TahaCheji.Mafana.gameItems.Weapons.PointyBone;
import me.TahaCheji.Mafana.gameItems.items.CollierStick;
import me.TahaCheji.Mafana.gameItems.items.MagicCookie;
import me.TahaCheji.Mafana.gameItems.items.ProspectorTorch;
import me.TahaCheji.Mafana.gameItems.items.RestoredCristal;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.mobData.CreateMob;
import me.TahaCheji.Mafana.mobData.DropLoot;
import me.TahaCheji.Mafana.mobData.LootItem;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;


public class ExcavatorZombie implements Listener {

    public CreateMob getExcavatorZombie(Player player) {
        LootItem lootItem = new LootItem(RestoredCristal.getRestoredCristal(), 1, 1, 50);
        LootItem Item = new LootItem(CollierStick.getCollierStick(), 1, 1, 1);
        LootItem newItem = new LootItem(ProspectorTorch.getProspectorTorch(), 1, 1, 2);
        return new CreateMob(ChatColor.DARK_GREEN + "ExcavatorZombie", 100, EntityType.ZOMBIE, 25, 10,
                5, 15, 0, ExcavatorMasterSpade.getExcavatorMasterSpade(player), armor(), lootItem, Item, newItem);
    }

    public static ItemStack[] armor() {
        return ItemUtl.createArmorSet(new org.bukkit.inventory.ItemStack(Material.LEATHER_HELMET), null, null, null);
    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        new DropLoot().onKill(e, getExcavatorZombie(e.getEntity().getKiller()));
    }

}
