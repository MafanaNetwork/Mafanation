package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.itemData.EnchancmentsUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.*;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AtomSplit implements Listener {

    public static ItemStack AtomSplit(Player player) {
        ItemStack skeletonSword = new ItemStack(Material.BOW);
        ItemMeta skeletonMeta = (ItemMeta) skeletonSword.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        skeletonMeta.setUnbreakable(true);
        skeletonMeta.setDisplayName(RarityType.DIAMOND.getLore() +  "AtomSplit");
        skeletonMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        skeletonMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        skeletonMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        lore.add("");
        lore.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
        lore.add("§7Level §f" + (double) 0);
        if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
            lore.add("§c" + player.getName());
        }
        lore.add("");
        lore.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(player, skeletonSword));
        //6
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dStrength: &c+1850"));
        //7
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        //8
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9Mana: &c+750"));
        //9
        lore.add(ChatColor.translateAlternateColorCodes('&', "&bSpeed: &c+500"));
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Level 10 Ability [Unknown]");
        lore.add("");
        lore.add(ChatColor.GOLD + "Item Ability: [Right Click]");
        lore.add(ChatColor.WHITE + "Right Click to split your Arrows [50 Mana]");
        lore.add("");
        lore.add(RarityType.DIAMOND.getLore() + " Bow");
        skeletonMeta.setLore(lore);
        skeletonSword.setItemMeta(skeletonMeta);
        EnchancmentsUtl.Enchancments(skeletonSword, player);
        return skeletonSword.clone();
    }
    /*

    @EventHandler
    public void onPlayerShootArrow(ProjectileLaunchEvent e) {
        if (e.getEntity().getShooter() != null) {
            if (e.getEntity().getShooter() instanceof Player) {
                if (e.getEntity() instanceof Arrow) {
                    Player p = (Player) e.getEntity().getShooter();
                    if (p.getItemInHand().getItemMeta().getDisplayName().contains(" AtomSplit")) {
                        Main.getInstance().addTrail(p, Particle.ENCHANTMENT_TABLE);
                        Main.getInstance().getTrail(p).addArrow((Arrow) e.getEntity());
                        Arrow arrow = (Arrow) e.getEntity();
                        World world = p.getWorld();
                        world.spawnArrow(arrow.getLocation(), p.getLocation().getDirection(), 2, 2);
                    }
                }
            }
        }
    }

     */

    @EventHandler
    public void OnPlayerInteract(final PlayerInteractEvent event) {

        Player player = event.getPlayer();
        PlayerInventory inv = player.getInventory();
        World world = player.getWorld();
        if(event.getItem() == null) {
            return;
        }
        if(event.getItem().getItemMeta() == null) {
            return;
        }
        if(event.getItem().getItemMeta().getDisplayName() == null) {
            return;
        }

        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            if (inv.getItemInHand().getItemMeta().getDisplayName().contains(" AtomSplit")) {
                Arrow arrow = player.launchProjectile(Arrow.class);
                    Arrow arrowDuplicate1 = world.spawnArrow(arrow.getLocation().add(2, 0, 0), player.getLocation().getDirection(), 2, 2);
                    player.sendMessage(ChatColor.GOLD + "Split Your Arrows");
                    Arrow arrowDuplicate2 = world.spawnArrow(arrow.getLocation().add(-2, 0, 0), player.getLocation().getDirection(), 2, 2);
                    world.spawnArrow(arrowDuplicate1.getLocation().add(2, 0, 0), player.getLocation().getDirection(), 2, 2);
                    player.sendMessage(ChatColor.GOLD + "Split Your Arrows");
                    Arrow arrowDuplicate3 = world.spawnArrow(arrow.getLocation().add(3, 0, 0), player.getLocation().getDirection(), 2, 2);
                    world.spawnArrow(arrowDuplicate1.getLocation().add(3, 0, 0), player.getLocation().getDirection(), 2, 2);
                    world.spawnArrow(arrowDuplicate2.getLocation().add(1, 0, 0), player.getLocation().getDirection(), 2, 2);
                    player.sendMessage(ChatColor.GOLD + "Split Your Arrows");

            }
        }
    }



}
