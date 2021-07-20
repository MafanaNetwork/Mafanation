package me.TahaCheji.Mafana.playerData;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class playerSellHistory {

    public static ItemStack getSellHistory(Player p, ItemStack item) {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerSellHistory.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        ItemStack count = pD.getItemStack("soldItem." + item.getAmount() + " for $" + new NBTItem(item).getDouble("value"));

        return count;
    }

    public static void setSellHistory(Player p, ItemStack item) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerSellHistory.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("soldItem." + item.getAmount() + " for $" + new NBTItem(item).getDouble("value"), item);
        pD.save(playerData);

    }



}
