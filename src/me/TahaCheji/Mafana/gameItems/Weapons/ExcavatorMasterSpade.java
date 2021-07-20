package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.crafting.CraftingUtl;
import me.TahaCheji.Mafana.gameItems.items.*;
import me.TahaCheji.Mafana.itemData.ClickType;
import me.TahaCheji.Mafana.itemData.GemUtl;
import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.RarityType;
import me.TahaCheji.Mafana.stats.PlayerStats;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.mcmonkey.sentinel.SentinelTrait;

import java.io.IOException;

import static me.TahaCheji.Mafana.itemData.ItemUtl.createItem;

public class ExcavatorMasterSpade implements Listener {

    public static ItemStack getExcavatorMasterSpade(Player player) {
        ItemStack GoldenLife = createItem(Material.STONE_SHOVEL, 1, ItemType.SWORD, player,
                true, true, RarityType.GOLD, "Excavator Master's Spade", 55, 25,10, 5, "Summon a minEr to work for you", ClickType.RIGHT_CLICK,
                false, true, 10,null,"Bro imagine all the stuff I can dig up.");
        return GoldenLife;
    }


    public void getExcavatorMasterSpadeRecipe(Player player, Inventory gui) {
        new CraftingUtl().createRecipe(null, 1, RestoredCristal.getRestoredCristal(), 1, null,
                1, ProspectorTorch.getProspectorTorch(), 1, RestoredCristal.getRestoredCristal(), 1, ProspectorTorch.getProspectorTorch(), 1,
                null, 0, CollierStick.getCollierStick(), 1, null, 0,
                player, getExcavatorMasterSpade(player), gui);
    }


    public static void Miner(Player player) {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Cook = registry.createNPC(EntityType.PLAYER, "Miner");
        Cook.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Miner" + ChatColor.GRAY + "(Npc Fighter)");
        Cook.setProtected(true);
        SkinTrait skinTrait = Cook.getOrAddTrait(SkinTrait.class);
        skinTrait.setSkinName("Miner", true);
        SentinelTrait sentinel = Cook.getOrAddTrait(SentinelTrait.class);
        sentinel.addTarget("monsters");
        sentinel.setHealth(10);
        sentinel.damage = 10;
        Cook.spawn(player.getLocation().add(1, 0, 0));
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 10, 10);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Cook.despawn();
            }
        }, 600L);

    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        ItemStack itemStack = e.getItem();
        Player player = e.getPlayer();
        if (e.getItem() == null) {
            return;
        }
        if (e.getItem().getItemMeta() == null) {
            return;
        }
        if (e.getItem().getItemMeta().getDisplayName() == null) {
            return;
        }
        if (!(player.getItemInHand().getItemMeta().getDisplayName().contains("Excavator Master's Spade"))) {
            return;
        }
        Miner(player);
        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);

    }

}
