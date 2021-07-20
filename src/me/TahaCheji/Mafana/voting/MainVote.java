package me.TahaCheji.Mafana.voting;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.playerData.playerInfo.playerVotes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class MainVote {


    public static void createFile() throws IOException {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        if (!updateVotes.exists()) {
           updateVotes.createNewFile();
            pD.set("update1.votes", 0);
            pD.set("update1.name", "Nothing");
            pD.set("update1.info", "No Info");
            pD.set("update2.votes", 0);
            pD.set("update2.name", "Nothing");
            pD.set("update2.info", "No Info");
            pD.set("update3.votes", 0);
            pD.set("update3.name", "Nothing");
            pD.set("update3.info", "No Info");
            pD.save(updateVotes);
        }
    }

    public static Integer getUpdate1Votes() {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        int count = pD.getInt("update1.votes");

        return count;
    }

    public static String getUpdate1Name() {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        String count = pD.getString("update1.name");

        return count;
    }

    public static String getUpdate1Info() {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        String count = pD.getString("update1.info");

        return count;
    }

    public static void setUpdate1(int amount) throws IOException {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("update1.votes", amount);
        pD.save(updateVotes);

    }

    public static Integer getUpdate2() {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        int count = pD.getInt("update2.votes");

        return count;
    }

    public static String getUpdate2Name() {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        String count = pD.getString("update2.name");

        return count;
    }

    public static String getUpdate2Info() {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        String count = pD.getString("update2.info");

        return count;
    }

    public static void setUpdate2(int amount) throws IOException {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("update2.votes", amount);
        pD.save(updateVotes);

    }

    public static Integer getUpdate3() {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        int count = pD.getInt("update3.votes");

        return count;
    }

    public static String getUpdate3Name() {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        String count = pD.getString("update3.name");

        return count;
    }

    public static String getUpdate3Info() {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        String count = pD.getString("update3.info");

        return count;
    }

    public static void setUpdate3(int amount) throws IOException {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("update3.votes", amount);
        pD.save(updateVotes);

    }

    /*
    public static void addPlayersVoted() throws IOException {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("playerVoted", VoterGuiEvent.players);
        pD.save(updateVotes);

    }

    public static List getPlayersVoted() throws IOException {
        File updateVotes = new File("plugins/Mafanation/gameData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
        try {
            pD.load(updateVotes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        return pD.getStringList("playerVoted");
    }

     */

    public static void clearPlayerVotes() throws IOException {
        for(UUID uuid : VoterGuiEvent.players) {
            Player player = Bukkit.getPlayer(uuid);
            playerVotes.setVoted(player, false, "null");
        }
    }

    public void clearVotes() throws IOException {
        setUpdate1(0);
        setUpdate2(0);
        setUpdate3(0);
        VoterGuiEvent.option1 = 0;
        VoterGuiEvent.option2 = 0;
        VoterGuiEvent.option3 = 0;
    }

    public void setWinner() throws IOException {
        if(getUpdate1Votes() > getUpdate2() && getUpdate1Votes() > getUpdate3()) {
            Bukkit.broadcastMessage(ChatColor.GOLD + "Update#1 has won the vote and will be arriving next week!");
            clearVotes();
        }

        if(getUpdate2() > getUpdate1Votes() && getUpdate2() > getUpdate3()) {
            Bukkit.broadcastMessage(ChatColor.GOLD + "Update#2 has won the vote and will be arriving next week!");
            clearVotes();
        }

        if(getUpdate3() > getUpdate1Votes() && getUpdate3() > getUpdate2()) {
            Bukkit.broadcastMessage(ChatColor.GOLD + "Update#3 has won the vote and will be arriving next week!");
            clearVotes();
        }
        clearPlayerVotes();
    }


}
