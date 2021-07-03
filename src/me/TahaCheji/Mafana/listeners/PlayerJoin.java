package me.TahaCheji.Mafana.listeners;


//import com.bringholm.nametagchanger.NameTagChanger;
import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.game.Title;
import me.TahaCheji.Mafana.playerData.playerInventoryData;
import me.TahaCheji.Mafana.scoreboard.Manager;
import me.TahaCheji.Mafana.stats.*;
import me.TahaCheji.Mafana.utils.Files;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PlayerJoin implements Listener {

@EventHandler
    public void mainOnJoin(PlayerJoinEvent event) throws IOException {
        Player p = event.getPlayer();
        event.setJoinMessage(null);
        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        p.sendMessage(ChatColor.DARK_RED + "[Owner]" + " Msked: " + ChatColor.WHITE + "This is a Beta Version of the game if there are any bugs please add me on discord" +
                ChatColor.GRAY + " [Masked#1025]" + ChatColor.WHITE +", There will be daily updates and if you have " +
                "any ideas please put your idea into the ideas section in the discord server, Thank you and Enjoy your stay");
            p.setGameMode(GameMode.ADVENTURE);
            p.setHealthScale(40);
            p.setFoodLevel(25);
            p.teleport(Main.getInstance().getLobbyPoint());
        Title title1 = new Title("Mafanation","Welcome Back!",15,100,15);
        title1.setTitleColor(ChatColor.DARK_PURPLE);
        title1.setSubtitleColor(ChatColor.GREEN);
        title1.setTimingsToTicks();
        title1.send(p);
        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 10, 10);
        BukkitTask t = new BukkitRunnable() {
            @Override
            public void run() {
                if (!(p.isOnline())) {
                    cancel();
                    return;
                }
                Manager.updateScoreBoard(p);
            }
        }.runTaskTimer(Main.getInstance(), 0L, 20L);
        Manager.setScoreBoard(p);
        p.setMaxHealth(Files.cfg.getDouble("base_health") + PlayerStats.getHealthWithoutBase(p));
        p.setHealthScale(20 + (PlayerStats.getHealthWithoutBase(p) / 100));
        p.setHealth(p.getMaxHealth());

        PlayerStats pS = new PlayerStats();
        pS.setUUID(p.getUniqueId());
        pS.setPlayer(p);
        pS.setMaxHealth(PlayerStats.getTotalHealth(p));
        pS.setCurrentHealth(pS.getMaxHealth());
        pS.setMaxIntelligence(PlayerStats.getTotalIntelligence(p));
        pS.setCurrentIntelligence(pS.getMaxIntelligence());
        pS.setSpeed(PlayerStats.getSpeed(pS.getPlayer()));
        PlayerStats.playerStats.put(p.getUniqueId(), pS);
   // NameTagChanger.INSTANCE.changePlayerName(p, "TestName");
   // System.out.println(p.getDisplayName());
        if(!(p.hasPlayedBefore())) {
                p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 5, 5);
                p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 10, 10);
                p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 10, 10);
                Title title = new Title("Mafanation","Where will Your Adventure Begin?",15,200,15);
                title.setTitleColor(ChatColor.DARK_PURPLE);
                title.setSubtitleColor(ChatColor.LIGHT_PURPLE);
                title.setTimingsToTicks();
                title.send(p);
                }
            }

            @EventHandler
    public void onJoin(PlayerJoinEvent e) throws IOException {
    Player p = e.getPlayer();
                Economy economy = Main.getEcon();
                File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/data.yml");
                File playerInventory = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerInventory.yml");
                File playerInfo = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerInfo.yml");
                File playerMobData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerMobData.yml");
                File playerItemFished = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerItemFished.yml");
                File playerTalkedTo = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerTalkedTo.yml");
                File playerCollections = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerCollections.yml");
                File playerDungeonsCompleted = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerDungeonsCompleted.yml");

                File playerSellHistory = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerSellHistory.yml");
                File playerBuyHistory = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerBuyHistory.yml");
                FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
                FileConfiguration pInv = YamlConfiguration.loadConfiguration(playerInventory);
                FileConfiguration pInfo = YamlConfiguration.loadConfiguration(playerInfo);
                FileConfiguration pMobData = YamlConfiguration.loadConfiguration(playerMobData);
                FileConfiguration pItemFished = YamlConfiguration.loadConfiguration(playerItemFished);
                FileConfiguration pTalkedTo = YamlConfiguration.loadConfiguration(playerTalkedTo);
                FileConfiguration pCollections = YamlConfiguration.loadConfiguration(playerCollections);
                FileConfiguration pDungeonsCompleted = YamlConfiguration.loadConfiguration(playerDungeonsCompleted);

                FileConfiguration pSellHistory = YamlConfiguration.loadConfiguration(playerSellHistory);
                FileConfiguration pBuyHistory = YamlConfiguration.loadConfiguration(playerBuyHistory);
                if (!new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString()).exists()) {
                    new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString()).mkdir();
                }
                if (!playerData.exists()) {
                    playerData.createNewFile();
                    pD.set("stats.extra_mana", 0);
                    pD.set("stats.extra_health", 0);
                    pD.set("stats.extra_strength", 0);
                    pD.set("stats.extra_speed", 0);
                    pD.save(playerData);
                }
                if (!playerInventory.exists()) {
                    playerInventory.createNewFile();
                    pInv.save(playerInventory);
                }
                if (!playerInfo.exists()) {
                    playerInfo.createNewFile();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    pInfo.set("info.name", p.getDisplayName());
                    pInfo.set("info.coins", economy.getBalance(p));
                    pInfo.set("info.coinSpent", 0);
                    pInfo.set("info.mostDamage", 0);
                    pInfo.set("info.lastLocation", p.getLocation());
                    pInfo.set("info.timePlayed", p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 60);
                    pInfo.set("info.dateLastJoined", dtf.format(now));
                    pInfo.set("info.dateFirstJoined", dtf.format(now));
                    pInfo.save(playerInfo);
                }
                if (!playerMobData.exists()) {
                    playerMobData.createNewFile();
                    pMobData.set("info.kills", p.getStatistic(Statistic.MOB_KILLS));
                    pMobData.set("info.deaths", p.getStatistic(Statistic.DEATHS));
                    pMobData.save(playerMobData);
                }
                if (!playerItemFished.exists()) {
                    playerItemFished.createNewFile();
                    pItemFished.set("info.fishCount", p.getStatistic(Statistic.FISH_CAUGHT));
                    pItemFished.save(playerItemFished);
                }
                if (!playerTalkedTo.exists()) {
                    playerTalkedTo.createNewFile();
                    pTalkedTo.save(playerTalkedTo);
                }
                if (!playerCollections.exists()) {
                    playerCollections.createNewFile();
                    pCollections.set("info.totalBroken", 0);
                    pCollections.set("info.totalPlaced", 0);
                    pCollections.save(playerCollections);
                }
                if (!playerDungeonsCompleted.exists()) {
                    playerDungeonsCompleted.createNewFile();
                    pDungeonsCompleted.save(playerDungeonsCompleted);
                }

                if (!playerBuyHistory.exists()) {
                    playerBuyHistory.createNewFile();
                    pBuyHistory.save(playerBuyHistory);
                }
                if (!playerSellHistory.exists()) {
                    playerSellHistory.createNewFile();
                    pSellHistory.save(playerSellHistory);
                }
            }



    }


