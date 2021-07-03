package me.TahaCheji.Mafana.dungeons.AquaDungeon;


import me.TahaCheji.Mafana.itemData.RarityType;
import me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager;
import me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class WaterBreathBow implements Listener {

    public static ItemStack WaterBreathBow(Player player) {
        ItemStack WaterBreathBow = new ItemStack(Material.BOW);
        ItemMeta WaterBreathBowMeta = (ItemMeta) WaterBreathBow.getItemMeta();
        WaterBreathBowMeta.setDisplayName(RarityType.WOOD.getLore() + " WaterBreathBow");
        WaterBreathBowMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        WaterBreathBowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        WaterBreathBowMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> lore = new ArrayList<String>();
        WaterBreathBowMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        //skeletonMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        lore.add("");
        lore.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
        lore.add("§7Level §f" + (double) 0);
        if (ConfigManager.getBoolean("use.owner-binding")) {
            lore.add("§c" + player.getName());
        }
        lore.add("");
        lore.add(MilestoneManager.getLoreMilestone(player, WaterBreathBow));
        //6
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dStrength: &c+10"));
        //7
        lore.add(ChatColor.translateAlternateColorCodes('&', "&cHealth: &c+5 HP"));
        //8
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Mana: &c+5"));
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Level 10 Ability [Unknown]");
        lore.add("");
        lore.add(RarityType.WOOD.getLore() + ChatColor.BOLD + " Bow");
        WaterBreathBowMeta.setLore(lore);
        WaterBreathBow.setItemMeta(WaterBreathBowMeta);
        return WaterBreathBow.clone();
    }


    @EventHandler
    public void OnPlayerInteract(final PlayerInteractEvent event) {

        Player player = event.getPlayer();
        PlayerInventory inv = player.getInventory();

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (inv.getItemInHand().getItemMeta().getDisplayName().contains(" WaterBreathBow")) {
                Arrow arrow = player.launchProjectile(Arrow.class);
                arrow.setShooter(player);
                arrow.setVelocity(player.getLocation().getDirection().multiply(2.0));
                player.getWorld().spawnParticle(Particle.BUBBLE_POP, arrow.getLocation(), 50);
                player.playSound(player.getLocation(), Sound.BLOCK_WATER_AMBIENT, 10, 10);
            }
        }
    }

    @EventHandler
    public void arrowEvent(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {

            Arrow arrow = (Arrow) event.getEntity();
            Entity shooter = (Entity) arrow.getShooter();

            if (shooter instanceof Player) {
                Player player = (Player) shooter;

                if (player.getItemInHand().getItemMeta().getDisplayName().contains(" WaterBreathBow")) {
                    player.teleport(arrow.getLocation());
                    arrow.remove();
                    player.playSound(player.getLocation(), Sound.AMBIENT_UNDERWATER_LOOP, 10, 10);
                }

            }
        }


    }

    @EventHandler
    public void onPlayerShootArrow(ProjectileLaunchEvent e) {
        if (e.getEntity().getShooter() != null) {
            if (e.getEntity().getShooter() instanceof Player) {
                if (e.getEntity() instanceof Arrow) {
                    Player p = (Player) e.getEntity().getShooter();
                    if (p.getItemInHand().getItemMeta().getDisplayName().contains(" WaterBreathBow")) {

                    }
                }
            }


        }
    }
}
