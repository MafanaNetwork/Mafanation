package me.TahaCheji.Mafana.utils;

import com.gmail.filoghost.holographicdisplays.util.nbt.NBTTag;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTEntity;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class NBTUtils {

    public static ItemStack setString(ItemStack is, String key, String value) {
        NBTItem nbt = new NBTItem(is);
        nbt.setString(key, value);
        return nbt.getItem();
    }

    public static void setEntityString(Entity is, String key, String value) {
        NBTCompound nbt = new NBTEntity(is).getPersistentDataContainer();

        nbt.setString(key, value);
    }

    public static ItemStack setDouble(ItemStack is, String key, double value) {
        NBTItem nbt = new NBTItem(is);
        nbt.setDouble(key, value);
        return nbt.getItem();
    }

    public static ItemStack setInt(ItemStack is, String key, int value) {
        NBTItem nbt = new NBTItem(is);
        nbt.setInteger(key, value);
        return nbt.getItem();
    }

    public static ItemStack setBoolean(ItemStack is, String key, boolean value) {
        NBTItem nbt = new NBTItem(is);
        nbt.setBoolean(key, value);
        return nbt.getItem();
    }





    public static String getString(ItemStack is, String key) {
        return new NBTItem(is).getString(key);
    }

    public static double getDouble(ItemStack is, String key) {
        return new NBTItem(is).getDouble(key);
    }

    public static String getEntityString(Entity entity, String key) {
        NBTCompound nbt = new NBTEntity(entity).getPersistentDataContainer();
        return nbt.getString(key);
    }


    public static int getInt(ItemStack is, String key) {
        return new NBTItem(is).getInteger(key);
    }

    public static boolean getBoolean(ItemStack is, String key) {
        return new NBTItem(is).getBoolean(key);
    }

}
