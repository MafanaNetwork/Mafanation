package me.TahaCheji.Mafana.playerData;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class playerBuyHistory {


    public static ItemStack getBuyHistory(Player p, ItemStack item) {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerBuyHistory.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        return pD.getItemStack("boughtItem." + item.getAmount() + " for $" + new NBTItem(item).getDouble("value"));
    }

    public static void setBuyHistory(Player p, ItemStack item) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerBuyHistory.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("boughtItem." + item.getAmount() + " for $" + new NBTItem(item).getDouble("value"), item);
        pD.save(playerData);

    }

}
