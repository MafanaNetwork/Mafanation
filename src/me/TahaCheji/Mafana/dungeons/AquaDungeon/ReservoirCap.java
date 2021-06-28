package me.TahaCheji.Mafana.dungeons.AquaDungeon;


import me.TahaCheji.Mafana.itemData.RarityType;
import me.TahaCheji.Mafana.itemLevel.managers.ConfigManager;
import me.TahaCheji.Mafana.itemLevel.managers.MilestoneManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ReservoirCap implements Listener {

    public static ItemStack ReservoirCap(Player player) {
        ItemStack ReservoirCap = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta ReservoirCapMeta = (ItemMeta) ReservoirCap.getItemMeta();
        ReservoirCapMeta.setDisplayName(RarityType.WOOD.getLore() + " ReservoirCap");
        ReservoirCapMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ReservoirCapMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ReservoirCapMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
        lore.add("§7Level §f" + (double) 0);
        if(ConfigManager.getBoolean("use.owner-binding")) {
            lore.add("§c" + player.getName());
        }
        lore.add("");
        lore.add(MilestoneManager.getLoreMilestone(player, ReservoirCap));
        //6
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dStrength: &c+10"));
        //7
        lore.add(ChatColor.translateAlternateColorCodes('&', "&cHealth: &c+5 HP"));
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add("");
        lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Level 10 Ability [Unknown]");
        lore.add("");
        lore.add(RarityType.WOOD.getLore() + ChatColor.BOLD + " Helmnet");
        ReservoirCapMeta.setLore(lore);
        ReservoirCap.setItemMeta(ReservoirCapMeta);
        return ReservoirCap.clone();
    }
/*
    @EventHandler
    public void armorOn(ArmorEquipEvent e) throws SQLException {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        Strength s = Main.getInstance().stMap.get(p.getUniqueId());
        HP h = Main.getInstance().hpMap.get(p.getUniqueId());
        Speed speed = Main.getInstance().speedMap.get(p.getUniqueId());
        Mana m = Main.getInstance().manaMap.get(p.getUniqueId());

        if (e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() !=
                Material.AIR && e.getNewArmorPiece().getItemMeta().getDisplayName().equals("ReservoirCap")) {
           e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 100000, 100000));

        }
    }

    @EventHandler
    public void armorOff (ArmorEquipEvent e) throws SQLException {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        Strength s = Main.getInstance().stMap.get(p.getUniqueId());
        HP h = Main.getInstance().hpMap.get(p.getUniqueId());
        Speed speed = Main.getInstance().speedMap.get(p.getUniqueId());
        Mana m = Main.getInstance().manaMap.get(p.getUniqueId());

        if (e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() !=
                Material.AIR && e.getOldArmorPiece().getItemMeta().getDisplayName().equals("ReservoirCap")) {
            e.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);

        }


    }

 */

}
