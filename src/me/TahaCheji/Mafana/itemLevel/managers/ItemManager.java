package me.TahaCheji.Mafana.itemLevel.managers;

import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemManager {

    public static boolean isSword(ItemStack is) {
        if(is == null || is.getType() == Material.AIR) {
            return false;
        }
        if(is != null) {
            return NBTUtils.getString(is, "ItemType").contains("Sword");
        } else {
            return false;
        }
    }

    public static boolean isShovel(ItemStack is) {
        if(is != null) {
            return NBTUtils.getString(is, "ItemType").contains("Tool");
        } else {
            return false;
        }
    }

    public static boolean isPickaxe(ItemStack is) {
        if(is != null) {
            return NBTUtils.getString(is, "ItemType").contains("Tool");
        } else {
            return false;
        }
    }

    public static boolean isAxe(ItemStack is) {
        if(is != null) {
            return NBTUtils.getString(is, "ItemType").contains("Tool");
        } else {
            return false;
        }
    }

    public static boolean isBow(ItemStack is) {
        if(is != null) {
            return NBTUtils.getString(is, "ItemType").contains("Bow");
        } else {
            return false;
        }
    }

    public static boolean isCrossbow(ItemStack is) {
        if(is != null) {
            return NBTUtils.getString(is, "ItemType").contains("Bow");
        } else {
            return false;
        }
    }

    public static boolean isHelmet(ItemStack is) {
        if(is != null) {
            return NBTUtils.getString(is, "ItemType").contains("Helmet");
        } else {
            return false;
        }
    }

    public static boolean isChestplate(ItemStack is) {
        if(is != null) {
            return NBTUtils.getString(is, "ItemType").contains("Chestplate");
        } else {
            return false;
        }
    }

    public static boolean isLeggings(ItemStack is) {
        if(is != null) {
            return NBTUtils.getString(is, "ItemType").contains("Leggings");
        } else {
            return false;
        }
    }

    public static boolean isBoots(ItemStack is) {
        if(is != null) {
            return NBTUtils.getString(is, "ItemType").contains("Boots");
        } else {
            return false;
        }
    }

}
