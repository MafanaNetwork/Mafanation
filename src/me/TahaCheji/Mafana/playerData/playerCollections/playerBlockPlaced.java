package me.TahaCheji.Mafana.playerData.playerCollections;

import org.bukkit.block.Block;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.io.File;
import java.io.IOException;

public class playerBlockPlaced implements Listener {
    public static Double getTotalAmount(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerCollections.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        double count = pD.getDouble("info.totalPlaced");

        return count;
    }

    public static void addTotalAmount(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerCollections.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("info.totalPlaced", getTotalAmount(p) + 1);
        pD.save(playerData);

    }


    @EventHandler
    public void onBreak(BlockPlaceEvent e) throws IOException {
        Player player = e.getPlayer();
        addTotalAmount(player);
    }
}
