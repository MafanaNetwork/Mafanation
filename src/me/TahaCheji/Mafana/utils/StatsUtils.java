package me.TahaCheji.Mafana.utils;

import org.bukkit.inventory.ItemStack;

public class StatsUtils {

    public static int getAttribute(ItemStack is, Attribute att) {
        return NBTUtils.getInt(is, att.getName());
    }

    public static ItemStack setAttribute(ItemStack is, Attribute att, int value) {
        is = NBTUtils.setInt(is, att.getName(), value);
        return is;
    }

    public static ItemStack addAttribute(ItemStack is, Attribute att, int value) {
        is = NBTUtils.setInt(is, att.getName(), NBTUtils.getInt(is, att.getName()) + value);
        return is;
    }

    public static ItemStack subtractAttribute(ItemStack is, Attribute att, int value) {
        is = NBTUtils.setInt(is, att.getName(), NBTUtils.getInt(is, att.getName()) - value);
        return is;
    }

}
