package me.TahaCheji.Mafana.playerData.playerInfo;

import me.TahaCheji.Mafana.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class playerCoins implements Listener {

    public Double getCoins(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        Double count = pD.getDouble("info.coins");
        return count;
    }

    public static void setCoins(Player p, double amount) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        Economy economy = Main.getEcon();
        pD.set("info.coins", amount);
        economy.withdrawPlayer(p, economy.getBalance(p));
        economy.depositPlayer(p, amount);
        pD.save(playerData);
    }

    public Double getCoinsSpent(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        Double count = pD.getDouble("info.coinSpent");
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

    @EventHandler
    public void onQuit(PlayerQuitEvent e) throws IOException {
        setCoins(e.getPlayer(), getCoins(e.getPlayer()));
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws IOException {
        setCoins(e.getPlayer(), getCoins(e.getPlayer()));
    }
    }
