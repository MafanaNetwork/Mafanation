package me.TahaCheji.Mafana.playerData.playerInfo;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;

public class playerCoinSpent implements Listener {

    public static double getCoinsSpent(Player p) {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        double count = pD.getDouble("info.coinSpent");

        return count;
    }

    public static void setCoinsSpent(Player p, double amount) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("info.coinSpent", amount);
        pD.save(playerData);

    }


}
