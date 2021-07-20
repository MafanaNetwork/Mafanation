package me.TahaCheji.Mafana.itemData.itemLevel.managers;

import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.utils.Attribute;
import me.TahaCheji.Mafana.utils.NBTUtils;
import me.TahaCheji.Mafana.utils.StatsUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LevelManager {

    public static void addXPToTool(ItemStack is, int amount, Player player, Event event) {
        if(LoreManager.getOwner(is) == null) {
            add(is, amount, player, event);
        }
        if(LoreManager.getOwner(is).equals(player)) {
            add(is, amount, player, event);
        }
        if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding") == false) {
            add(is, amount, player, event);
        }
    }

    private static void add(ItemStack is, int amount, Player player, Event event) {
        int strength = 0;
        int health = 0;
        int speed = 0;
        int mana = 0;
        if(is.getItemMeta().hasLore() &! (event instanceof PlayerExpChangeEvent)) {
            if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager.isPickaxe(is) || me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager.isShovel(is)) {
                me.TahaCheji.Mafana.itemData.itemLevel.managers.BonusManager.increaseBlockBreakSpeed((BlockBreakEvent) event);
            }
            if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager.isSword(is) || me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager.isBow(is) || me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager.isCrossbow(is)) {
                me.TahaCheji.Mafana.itemData.itemLevel.managers.BonusManager.increaseDamageDealt((EntityDamageByEntityEvent) event);
            }
            if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager.isHelmet(is) || me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager.isChestplate(is) || me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager.
                    isLeggings(is) || me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager.isBoots(is)) {
                me.TahaCheji.Mafana.itemData.itemLevel.managers.BonusManager.reduceDamageTaken((EntityDamageByEntityEvent) event);
            }
            if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager.isAxe(is)) {
                if(event instanceof EntityDamageByEntityEvent) {
                    me.TahaCheji.Mafana.itemData.itemLevel.managers.BonusManager.increaseDamageDealt((EntityDamageByEntityEvent) event);
                } else if(event instanceof BlockBreakEvent) {
                    me.TahaCheji.Mafana.itemData.itemLevel.managers.BonusManager.increaseBlockBreakSpeed((BlockBreakEvent) event);
                }
            }
        }
        for(int i = 0; i < amount; i++) {
            List<String> lore = new ArrayList<String>();
            ItemMeta im = is.getItemMeta();
            if(im.hasLore()) {
                if(LoreManager.getToolXP(is) < LoreManager.getMaxToolXP(is)) {
                    lore.add("");
                    lore.add("§7XP §f" + (LoreManager.getToolXP(is) + 1) + " §7/ §f" + LoreManager.getMaxToolXP(is));
                    lore.add("§7Level §f" + LoreManager.getToolLevel(is));
                    if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
                        lore.add("§c" + player.getName());
                    }
                    lore.add("");
                    lore.add(LoreManager.getLoreMilestone(is));
                    lore.addAll(getExtraLore(is));
                } else {

                    DecimalFormat format = new DecimalFormat("0.00");
                    lore.add("");
                    lore.add("§7XP §f" + (double) 0 + " §7/ §f" + format.format(LoreManager.getMaxToolXP(is) * me.TahaCheji.Mafana.itemData.itemLevel.managers.
                            ConfigManager.getDouble("multiplier.xp")).replace(",", "."));
                    lore.add("§7Level §f" + (LoreManager.getToolLevel(is) + 1));
                    if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
                        lore.add("§c" + player.getName());
                    }
                    lore.add("");
                    //this is where to change the strength
                    if(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(player, is) == "") {
                        lore.add(LoreManager.getLoreMilestone(is));
                    } else {
                        lore.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(player, is));
                    }
                    lore.addAll(getExtraLore(is));
                    me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.applyCommandMilestone(player, is);
                    for(String newLore : is.getItemMeta().getLore()) {
                        if (newLore.contains("§dStrength: §c+")) {
                            int newStats = Integer.valueOf(newLore.replace("§dStrength: §c+", "")) + 1;
                            String str = "§d" + ChatColor.translateAlternateColorCodes('&', "§dStrength" + ": §c+" + newStats);
                            strength = newStats;
                            lore.set(6, str);
                        }
                        if (newLore.contains("§cHealth: §c+")) {
                            int newStats = Integer.valueOf(newLore.replace("§cHealth: §c+", "").replace(" HP", "")) + 1;
                            String str = "§c" + ChatColor.translateAlternateColorCodes('&', "§cHealth" + ": §c+" + newStats + " HP");
                            health = newStats;
                            lore.set(7, str);
                        }
                        if (newLore.contains("§9Mana: §c+")) {
                            int newStats = Integer.valueOf(newLore.replace("§9Mana: §c+", "")) + 1;
                            String str = "§9" + ChatColor.translateAlternateColorCodes('&', "§9Mana" + ": §c+" + newStats);
                            mana = newStats;
                            lore.set(8, str);
                        }
                        if (newLore.contains("§bSpeed: §c+")) {
                            int newStats = Integer.valueOf(newLore.replace("§bSpeed: §c+", "")) + 1;
                            String str = "§b" + ChatColor.translateAlternateColorCodes('&', "§bSpeed" + ": §c+" + newStats);
                            speed = newStats;
                            lore.set(9, str);
                        }
                    }

                    im.setLore(lore);
                    is.setItemMeta(im);
                    NBTItem nbt = new NBTItem(is);
                    nbt.setInteger("baseStrength", strength);
                    nbt.setInteger("baseHealth", health);
                    nbt.setInteger("baseMana", mana);
                    nbt.setInteger("baseSpeed", speed);
                    player.setItemInHand(nbt.getItem());
                }
                im.setLore(lore);
                is.setItemMeta(im);
            } else {
                lore.add("");
                lore.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
                lore.add("§7Level §f" + (double) 0);
                if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
                    lore.add("§c" + player.getName());
                }
                lore.add("");
                lore.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(player, is));
                im.setLore(lore);
                is.setItemMeta(im);
            }
        }
    }

    private static List<String> getExtraLore(ItemStack is) {
        List<String> lore = new ArrayList<String>();
        if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
            for(int i = 0; i < is.getItemMeta().getLore().size(); i++) {
                if(i > 5) {
                    lore.add(is.getItemMeta().getLore().get(i));
                }
            }
        } else {
            for(int i = 0; i < is.getItemMeta().getLore().size(); i++) {
                if(i > 4) {
                    lore.add(is.getItemMeta().getLore().get(i));
                }
            }
        }
        return lore;
    }

}
