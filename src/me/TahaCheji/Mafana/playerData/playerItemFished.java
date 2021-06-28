package me.TahaCheji.Mafana.playerData;

import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class playerItemFished implements Listener {

    //itemsFished
    public static double getFishedCollection(Player p, Material fish) {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerItemFished.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        if(pD.get("collections." + fish) == null) {
            return 0;
        }
        double count = pD.getDouble("collections." + fish);

        return count;
    }

    public static void setFishCollection(Player p, Material fish) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerItemFished.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("collections." + fish, getFishedCollection(p, fish) + 1);
        pD.save(playerData);

    }

    public static Double getFishCount(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerItemFished.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        double count = pD.getDouble("info.fishCount");

        return count;
    }

    public static void addFishCount(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerItemFished.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("info.fishCount", getFishCount(p) + 1);
        pD.save(playerData);

    }

    @EventHandler
    public void onFish(PlayerFishEvent e) throws IOException {
        if(e.getCaught() == null) {
            return;
        }
        Material mat = ((Item)e.getCaught()).getItemStack().getType();
setFishCollection(e.getPlayer(), mat);
addFishCount(e.getPlayer());
    }
}
