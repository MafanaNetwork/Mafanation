package me.TahaCheji.Mafana.playerData.playerInfo;

import org.bukkit.Statistic;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class playerTimePlayed implements Listener {

    public static Double getTimePlayed(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        Double count = pD.getDouble("info.timePlayed");
        return count;
    }

    public static void setTimePlayed(Player p, double amount) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        pD.set("info.timePlayed", amount);
        pD.save(playerData);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) throws IOException {
        setTimePlayed(e.getPlayer(), e.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE) / 60);
    }

}
