package me.TahaCheji.Mafana.itemData;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.crafting.MasterTable;
import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.TahaCheji.Mafana.utils.MessageUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static me.clip.placeholderapi.util.Msg.color;

public class ItemUtl {

    public static ItemStack createItem(Material material, int amount, ItemType itemType, Player player, boolean glow, boolean unb, RarityType rarityType, String name, int Strength, int Health, int Mana,
                                       int Speed, String Ability, ClickType AbilityClickType, boolean sellable, boolean enchancements, int Value, GemUtl gemUtl, String... lore) {
            ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        List<String> list = new ArrayList<>();
        String strength = "§d" + ChatColor.translateAlternateColorCodes('&', "§dStrength" + ": §c+" + Strength);
        String health = "§c" + ChatColor.translateAlternateColorCodes('&', "§cHealth" + ": §c+" + Health + " HP");
        String mana = "§9" + ChatColor.translateAlternateColorCodes('&', "§9Mana" + ": §c+" + Mana);
        String speed = "§b" + ChatColor.translateAlternateColorCodes('&', "§bSpeed" + ": §c+" + Speed);
        if(name != null || rarityType != null) {
            meta.setDisplayName(rarityType.getColor() + name);
        }
        if(lore != null) {
            for(String string : lore) {
                list.add("");
                list.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
                list.add("§7Level §f" + (double) 0);
                if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
                    if(player == null) {
                        list.add("§c" + "Non");
                    } else {
                        list.add("§c" + player.getName());
                    }
                }
                list.add("");
                if(player == null) {
                    Player newPlayer = Bukkit.getPlayer("Msked");
                    list.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(newPlayer, item));
                } else {
                    list.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(player, item));
                }
                if(Strength != 0) {
                    list.add(strength);
                } else {
                    list.add("");
                }
                if(Health != 0) {
                    list.add(health);
                } else {
                    list.add("");
                }
                if(Mana != 0) {
                    list.add(mana);
                } else {
                    list.add("");
                }
                if(Speed != 0) {
                    list.add(speed);
                } else {
                    list.add("");
                }
                list.add("");
                list.add("");
                list.add("");
                list.add("");
                list.add("");
                if(gemUtl != null) {
                    list.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Gem [" + gemUtl.getName() + "]");
                    list.add(gemUtl.getAbility());
                } else {
                    list.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Gem [" + "Null" + "]");
                }
                list.add("");
                if(Ability != null) {
                    list.add(ChatColor.GOLD + "Items Ability: " + AbilityClickType.getLore());
                    list.add(ChatColor.WHITE + Ability);
                    list.add("");
                }
                list.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Item's Lore:");
                list.add('"' + string + '"');
                list.add("");
                list.add(rarityType.getLore() + itemType.getLore());
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            }
        }
        if(glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if(unb) {
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setUnbreakable(true);
        }
        meta.setLore(list);
        item.setItemMeta(meta);
        if(enchancements) {
            EnchancmentsUtl.Enchancments(item, player);
        }
        if(sellable) {
            item = NBTUtils.setBoolean(item, "Sellable", true);
        }
        if(Ability != null) {
            item = NBTUtils.setBoolean(item, "hasAbility", true);
        }
       item = NBTUtils.setString(item, "SellValue", ChatColor.GOLD + "Sell Value: $" + Value);
        item = NBTUtils.setInt(item, "value", Value);
      item =  NBTUtils.setString(item, "BuyValue", ChatColor.GOLD + "Buy Value: $" + Value);
      item = NBTUtils.setString(item, "ItemType", itemType.getLore());
        item =  NBTUtils.setString(item, "ItemRarity", rarityType.getLore());
        item = NBTUtils.setBoolean(item, "hasGem", true);
        item = NBTUtils.setString(item, "ItemKey", name);
        return item;
    }


    public static ItemStack createRecipeItem(Material material, int amount, ItemType itemType, Player player, boolean glow, boolean unb, RarityType rarityType, String name, int Strength, int Health, int Mana,
                                             int Speed, String Ability, ClickType AbilityClickType, boolean sellable, boolean enchancements, int Value, GemUtl gemUtl, MasterTable masterTable, String... lore) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        List<String> list = new ArrayList<>();
        String strength = "§d" + ChatColor.translateAlternateColorCodes('&', "§dStrength" + ": §c+" + Strength);
        String health = "§c" + ChatColor.translateAlternateColorCodes('&', "§cHealth" + ": §c+" + Health + " HP");
        String mana = "§9" + ChatColor.translateAlternateColorCodes('&', "§9Mana" + ": §c+" + Mana);
        String speed = "§b" + ChatColor.translateAlternateColorCodes('&', "§bSpeed" + ": §c+" + Speed);
        if(name != null || rarityType != null) {
            meta.setDisplayName(rarityType.getColor() + name);
        }
        if(lore != null) {
            for(String string : lore) {
                list.add("");
                list.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
                list.add("§7Level §f" + (double) 0);
                if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
                    if(player == null) {
                        list.add("§c" + "Non");
                    } else {
                        list.add("§c" + player.getName());
                    }
                }
                list.add("");
                if(player == null) {
                    Player newPlayer = Bukkit.getPlayer("Msked");
                    list.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(newPlayer, item));
                } else {
                    list.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(player, item));
                }
                if(Strength != 0) {
                    list.add(strength);
                } else {
                    list.add("");
                }
                if(Health != 0) {
                    list.add(health);
                } else {
                    list.add("");
                }
                if(Mana != 0) {
                    list.add(mana);
                } else {
                    list.add("");
                }
                if(Speed != 0) {
                    list.add(speed);
                } else {
                    list.add("");
                }
                list.add("");
                list.add("");
                list.add("");
                list.add("");
                list.add("");
                if(gemUtl != null) {
                    list.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Gem [" + gemUtl.getName() + "]");
                    list.add(gemUtl.getAbility());
                } else {
                    list.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Gem [" + "Null" + "]");
                }
                list.add("");
                if(Ability != null) {
                    list.add(ChatColor.GOLD + "Items Ability: " + AbilityClickType.getLore());
                    list.add(ChatColor.WHITE + Ability);
                    list.add("");
                }
                list.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Item's Lore:");
                list.add('"' + string + '"');
                list.add("");
                list.add(rarityType.getLore() + itemType.getLore());
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            }
        }
        if(glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if(unb) {
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setUnbreakable(true);
        }
        meta.setLore(list);
        item.setItemMeta(meta);
        if(enchancements) {
            EnchancmentsUtl.Enchancments(item, player);
        }
        if(sellable) {
            item = NBTUtils.setBoolean(item, "Sellable", true);
        }
        if(Ability != null) {
            item = NBTUtils.setBoolean(item, "hasAbility", true);
        }
        Main.recipes.add(masterTable);
        item = NBTUtils.setString(item, "SellValue", ChatColor.GOLD + "Sell Value: $" + Value);
        item = NBTUtils.setInt(item, "value", Value);
        item =  NBTUtils.setString(item, "BuyValue", ChatColor.GOLD + "Buy Value: $" + Value);
        item = NBTUtils.setString(item, "ItemType", itemType.getLore());
        item =  NBTUtils.setString(item, "ItemRarity", rarityType.getLore());
        item = NBTUtils.setBoolean(item, "hasGem", true);
        item = NBTUtils.setString(item, "ItemKey", name);
        return item;
    }

    public static ItemStack createMaterial(Material material, int amount, int Value, ItemType itemType, boolean glow, boolean unb, RarityType rarityType, String name, String key, boolean sellable, String... lore) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        List<String> list = new ArrayList<>();
        if(name != null) {
            meta.setDisplayName(rarityType.getColor() + name);
        }
        if(lore != null) {
            for(String string : lore) {
                list.add('"' + string + '"');
                list.add("");
                list.add(ChatColor.DARK_GRAY + "(Right Click To View Recipe)");
                list.add("");
                list.add(rarityType.getColor() + itemType.getLore());
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            }
        }
        if(glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if(unb) {
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setUnbreakable(true);
        }
        meta.setLore(list);
        item.setItemMeta(meta);
        if(sellable) {
            item = NBTUtils.setBoolean(item, "Sellable", true);
        }
        item = NBTUtils.setString(item, "ItemType", itemType.getLore());
        item = NBTUtils.setString(item, "SellValue", ChatColor.GOLD + "Sell Value: $" + Value);
        item = NBTUtils.setInt(item, "value", Value);
        item =  NBTUtils.setString(item, "BuyValue", ChatColor.GOLD + "Buy Value: $" + Value);
        item = NBTUtils.setString(item, "ItemKey", key);
        item =  NBTUtils.setString(item, "ItemRarity", rarityType.getLore());
        return item;
    }

    public static ItemStack createGUI(Material material, int ammount, boolean glow, String name, String... lore) {
        ItemStack item = new ItemStack(material, ammount);
        ItemMeta meta = item.getItemMeta();
        List<String> list = new ArrayList<>();
        if(name != null) {
            meta.setDisplayName(name);
        }
        if(lore != null) {
            for(String string : lore) {
                list.add('"' + string + '"');
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            }
        }
        if(glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        meta.setLore(list);
        item.setItemMeta(meta);
        return item;
    }



    public static ItemStack createSpellBook(Material material, int ammount, Player player, int Value, boolean glow, boolean unb, RarityType rarityType, String name, int Mana, boolean sellable, String spell, int ManaSpellCost, ClickType SpellClickType, String... lore) {
        ItemStack item = new ItemStack(material, ammount);
        ItemMeta meta = item.getItemMeta();
        List<String> list = new ArrayList<>();
        if(name != null) {
            meta.setDisplayName(rarityType.getColor() + name);
        }
        String mana = "§9" + ChatColor.translateAlternateColorCodes('&', "§9Mana" + ": §c+" + Mana);
        if(lore != null) {
            for(String string : lore) {
                list.add("");
                list.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
                list.add("§7Level §f" + (double) 0);
                if(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getBoolean("use.owner-binding")) {
                    if(player == null) {
                        list.add("§c" + "Non");
                    } else {
                        list.add("§c" + player.getName());
                    }
                }
                list.add("");
                if(player == null) {
                    Player newPlayer = Bukkit.getPlayer("Msked");
                    list.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(newPlayer, item));
                } else {
                    list.add(me.TahaCheji.Mafana.itemData.itemLevel.managers.MilestoneManager.getLoreMilestone(player, item));
                }
                list.add(mana);
                list.add("");
                list.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Level 10 Ability [Unknown]");
                list.add("");
                    list.add(ChatColor.GOLD + "Items Spell: " + SpellClickType.getLore() + ChatColor.AQUA + " [-" + ManaSpellCost + " Mana]");
                    list.add(ChatColor.WHITE + spell);
                    list.add("");
                list.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Item's Lore:");
                list.add('"' + string + '"');
                list.add("");
                list.add(rarityType.getLore() + ItemType.SPELL.getLore());
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            }
        }
        if(glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if(unb) {
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setUnbreakable(true);
        }
        meta.setLore(list);
        item.setItemMeta(meta);
        if(sellable) {
            item = NBTUtils.setBoolean(item, "Sellable", true);
        }
        item = NBTUtils.setBoolean(item, "hasAbility", true);
        item = NBTUtils.setString(item, "ItemType", ItemType.SPELL.getLore());
        item = NBTUtils.setString(item, "SellValue", ChatColor.GOLD + "Sell Value: $" + Value);
        item = NBTUtils.setInt(item, "value", Value);
        item =  NBTUtils.setString(item, "ItemRarity", rarityType.getLore());
        item =  NBTUtils.setString(item, "BuyValue", ChatColor.GOLD + "Buy Value: $" + Value);
        return item;
    }

    public static ItemStack[] createArmorSet(ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
        ItemStack[] armor = new ItemStack[4];
        armor[3] = helmet;
        armor[2] = chestplate;
        armor[1] = leggings;
        armor[0] = boots;
        return armor;
    }


    public static ItemStack createNormalItem(Material type, int amount, boolean glow, boolean unbreakable, boolean hideUnb, String name, String... lines) {
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        if (glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if (unbreakable) meta.setUnbreakable(true);
        if (hideUnb) meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        if (name != null) meta.setDisplayName(color(name));
        if (lines != null) {
            List<String> lore = new ArrayList<>();
            for (String line : lines) {
                lore.add(color(line));
            }
            meta.setLore(lore);
        }
        item.setItemMeta(meta);
        return item;
    }






}
