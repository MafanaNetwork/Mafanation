package me.TahaCheji.Mafana.itemData.masterData;

import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.crafting.MasterTable;
import me.TahaCheji.Mafana.itemData.EnchancmentsUtl;
import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.RarityType;
import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterItems {
    private final Material material;
    private final String name;
    private final ItemType itemType;
    private final RarityType rarityType;
    private final Player player;
    private final int strength;
    private final int health;
    private final int mana;
    private final int speed;
    private final boolean glow;
    private final boolean enhancements;
    private final MasterAbility masterAbility;
    private final ItemValueUtl itemValueUtl;
    private final MasterTable recipe;
    private final List<String> lore;

    public MasterItems(Material material, String name, ItemType itemType, RarityType rarityType, Player player,
                       int strength, int health, int mana, int speed, boolean glow,boolean enhancements,  MasterAbility masterAbility, ItemValueUtl itemValueUtl, MasterTable table, String... lore) {
        this.material = material;
        this.name = name;
        this.itemType = itemType;
        this.rarityType = rarityType;
        this.player = player;
        this.strength = strength;
        this.health = health;
        this.mana = mana;
        this.speed = speed;
        this.glow = glow;
        this.enhancements = enhancements;
        this.masterAbility = masterAbility;
        this.itemValueUtl = itemValueUtl;
        this.recipe = table;
        this.lore = Arrays.asList(lore);
    }

    public ItemStack createItem () {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        List<String> list = new ArrayList<>();
        String strength = "§d" + ChatColor.translateAlternateColorCodes('&', "§dStrength" + ": §c+" + this.strength);
        String health = "§c" + ChatColor.translateAlternateColorCodes('&', "§cHealth" + ": §c+" + this.health + " HP");
        String mana = "§9" + ChatColor.translateAlternateColorCodes('&', "§9Mana" + ": §c+" + this.mana);
        String speed = "§b" + ChatColor.translateAlternateColorCodes('&', "§bSpeed" + ": §c+" + this.speed);
        if(name != null || rarityType != null) {
            meta.setDisplayName(rarityType.getColor() + name);
        }
        if(lore != null) {
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
            if(this.strength != 0) {
                list.add(strength);
            } else {
                list.add("");
            }
            if(this.health != 0) {
                list.add(health);
            } else {
                list.add("");
            }
            if(this.mana != 0) {
                list.add(mana);
            } else {
                list.add("");
            }
            if(this.speed != 0) {
                list.add(speed);
            } else {
                list.add("");
            }
            list.add("");
            list.add("");
            list.add("");
            list.add("");
            list.add("");
            list.add("");
            if(masterAbility != null) {
                list.addAll(masterAbility.toLore());
            }
            list.add("");
            list.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Item Lore:");
            for(String string : lore) {
                list.add('"' + string + '"');
            }
            list.add("");
            list.add(rarityType.getLore() + itemType.getLore());
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        }
        if(glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setUnbreakable(true);
        meta.setLore(list);
        item.setItemMeta(meta);
        if(enhancements) {
            EnchancmentsUtl.Enchancments(item, player);
        }
        if(itemValueUtl.isSellable()) {
            item = NBTUtils.setBoolean(item, "Sellable", true);
        }
        if(masterAbility != null) {
            item = NBTUtils.setBoolean(item, "hasAbility", true);
        }
        NBTItem tags = new NBTItem(item);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        if(player != null) {
            tags.setUUID("PlayerUUID", player.getUniqueId());
        } else {
            tags.setString("PlayerUUID", "Nothing");
        }

        tags.setItemStack("Item", item);

        item = tags.getItem();
        item = NBTUtils.setInt(item, "value",  itemValueUtl.getValue());
        item = NBTUtils.setString(item, "SellValue", ChatColor.GOLD + "Sell Value: $" +  itemValueUtl.getValue());
        item = NBTUtils.setString(item, "BuyValue", ChatColor.GOLD + "Buy Value: $" + itemValueUtl.getValue());

        item = NBTUtils.setString(item, "ItemKey", item.getItemMeta().getDisplayName());
        item = NBTUtils.setString(item, "ItemType", itemType.getLore());
        item = NBTUtils.setString(item, "ItemRarity", rarityType.getLore());

        item = NBTUtils.setString(item, "ItemDate", dtf.format(now));
        recipe.setFinalItem(item);
        return item;

    }



    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public RarityType getRarityType() {
        return rarityType;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getSpeed() {
        return speed;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isGlow() {
        return glow;
    }

    public boolean isEnhancements() {
        return enhancements;
    }

    public MasterAbility getMasterAbility() {
        return masterAbility;
    }

    public ItemValueUtl getItemValueUtl() {
        return itemValueUtl;
    }

    public List<String> getLore() {
        return lore;
    }
}
