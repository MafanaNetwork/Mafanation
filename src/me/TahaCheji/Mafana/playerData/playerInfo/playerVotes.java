package me.TahaCheji.Mafana.playerData.playerInfo;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class playerVotes {

    public static Boolean hasVoted(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        Boolean count = pD.getBoolean("info.voted");
        return count;
    }

    public static void setVoted(Player p, boolean tf, String who) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        pD.set("info.votedFor", who);
        pD.set("info.voted", tf);
        pD.save(playerData);
    }

    public static String getVotedFor(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        String count = pD.getString("info.votedFor");
        return count;
    }


}
