package me.TahaCheji.Mafana.gameItems.items.bakersItems;

import me.TahaCheji.Mafana.Main;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mcmonkey.sentinel.SentinelIntegration;
import org.mcmonkey.sentinel.SentinelTrait;

import java.util.ArrayList;

public class LoafOfHealth extends SentinelIntegration implements Listener {

    public static Main plugin = Main.getPlugin(Main.class);

    public static ItemStack LoafOfHealth() {
        ItemStack bread = new ItemStack(Material.BREAD);
        ItemMeta bread_meta = bread.getItemMeta();
        bread_meta.setDisplayName(ChatColor.GOLD + "Loaf Of Health");
        ArrayList<String> bread_lore = new ArrayList<>();
        bread_lore.add("");
        bread_lore.add(ChatColor.GOLD + "[Right Click]");
        bread_lore.add(ChatColor.WHITE + "Summons 3 Cooks to fight for you!");
        bread_lore.add(ChatColor.WHITE + "(For Only 30 Seconds)");
        bread_lore.add("");
        bread_lore.add("Lapis" + " Item");
        bread_meta.setLore(bread_lore);
        bread.setItemMeta(bread_meta);
        return bread.clone();
    }


    public static void Cooks(Player player) {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Cook = registry.createNPC(EntityType.PLAYER, "Cook");
        Cook.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Cook" + ChatColor.GRAY + "(Npc Fighter)");
        Cook.setProtected(true);
        SentinelTrait sentinel = Cook.getOrAddTrait(SentinelTrait.class);
        sentinel.addTarget("monsters");
        sentinel.setHealth(10);
        sentinel.damage = 10;
        Cook.spawn(player.getLocation().add(1, 0, 0));
        player.sendMessage(ChatColor.GOLD + "Summoned 3 Cooks for you!");
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 10, 10);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Cook.despawn();
            }
        }, 600L);

    }



    @EventHandler
    public void rightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getItem() == null) {
            return;
        }
        if(e.getItem().getItemMeta() == null) {
            return;
        }
        if(e.getItem().getItemMeta().getDisplayName() == null) {
            return;
        }
            if(e.getItem().getItemMeta().getDisplayName().contains(ChatColor.GOLD + "Loaf Of Health")) {
                Cooks(p);
                e.getItem().setType(Material.AIR);
            }
            }

            }

