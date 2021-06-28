package me.TahaCheji.Mafana.playerData.playerCollections;

import org.bukkit.block.Block;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.File;
import java.io.IOException;

public class playerBlocksBroken implements Listener {

    public static double getBlockBroken(Player p, Block block) {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerCollections.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        if(pD.get("collections." + block.getType()) == null) {
            return 0;
        }
        double count = pD.getDouble("collections." + block.getType());

        return count;
    }

    public static void setBlockBroken(Player p, Block block) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerCollections.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("collections." + block.getType(), getBlockBroken(p, block) + 1);
        pD.save(playerData);

    }

    public static Double getTotalAmount(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerCollections.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        double count = pD.getDouble("info.totalBroken");

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

        pD.set("info.totalBroken",  getTotalAmount(p) + 1);
        pD.save(playerData);

    }


    @EventHandler
    public void onBreak(BlockBreakEvent e) throws IOException {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        setBlockBroken(player, block);
        addTotalAmount(player);
    }



}
