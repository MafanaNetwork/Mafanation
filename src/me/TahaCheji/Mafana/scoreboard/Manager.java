package me.TahaCheji.Mafana.scoreboard;

import com.gamingmesh.jobs.Jobs;
import com.gamingmesh.jobs.container.Job;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.math.Vector3;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.commands.task.RegionManagerLoader;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.utils.Files;
import me.clip.placeholderapi.PlaceholderAPI;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import uk.co.harieo.seasons.plugin.Seasons;

import java.text.DecimalFormat;


public class Manager {

   static DecimalFormat format = new DecimalFormat("#.##");

    public static void setScoreBoard(Player player) {
        Economy economy = Main.getEcon();

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("Mafanation", "dummy", ChatColor.GRAY + "♧" + ChatColor.GOLD + "Mafana" + ChatColor.GRAY + "♧");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = obj.getScore(ChatColor.GOLD + "=-=-=-=-Mafanation=-=-=--=");
        score.setScore(16);


        Team Location = board.registerNewTeam("Location");
        Location.addEntry(ChatColor.BLACK + "" + ChatColor.BLACK);
        String regionName = PlaceholderAPI.setPlaceholders(player, " %worldguard_region_name_capitalized%");
        Location.setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Location: " + ChatColor.DARK_GREEN + "★" + ChatColor.GREEN + regionName + ChatColor.DARK_GREEN + "★");
        obj.getScore(ChatColor.BLACK + "" + ChatColor.BLACK).setScore(15);


        Team Season = board.registerNewTeam("Season");
        Season.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE);
        Season.setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Season: " + ChatColor.WHITE + Seasons.getInstance().getWorldCycle(player.getWorld()).getSeason().getName() + " " +
                Seasons.getInstance().getWorldCycle(player.getWorld()).getDay() + "/30"
        );
        obj.getScore(ChatColor.BLACK + "" + ChatColor.WHITE).setScore(14);

        Team coins = board.registerNewTeam("Coins");
        coins.addEntry(ChatColor.BLACK + "" + ChatColor.GREEN);
        coins.setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Coins: " + ChatColor.WHITE +  "$" + format.format(economy.getBalance(player)));
        obj.getScore(ChatColor.BLACK + "" + ChatColor.GREEN).setScore(13);


        Team job = board.registerNewTeam("Job");
        job.addEntry(ChatColor.BLACK + "" + ChatColor.BLUE);
        String jobName = PlaceholderAPI.setPlaceholders(player, "%jobsr_user_jobs%");
        String jobQuest = PlaceholderAPI.setPlaceholders(player, " %jobsr_user_quests%");
        job.setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Job: " + ChatColor.WHITE + jobName);
        obj.getScore(ChatColor.BLACK + "" + ChatColor.BLUE).setScore(12);


        Team jobQuestLine = board.registerNewTeam("jobQuestLine");
        jobQuestLine.addEntry(ChatColor.WHITE + "" + ChatColor.BLUE);
        jobQuestLine.setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "JobQuest:" + ChatColor.WHITE + jobQuest);
        obj.getScore(ChatColor.WHITE + "" + ChatColor.BLUE).setScore(11);




        Score score4 = obj.getScore("           ");
        score4.setScore(10);

        Score score7 = obj.getScore(ChatColor.GRAY + "Mafana.us.to");
        score7.setScore(9);

        player.setScoreboard(board);
    }


    public static void updateScoreBoard(Player player) {
        Scoreboard board = player.getScoreboard();
        Economy economy = Main.getEcon();

        String regionName = PlaceholderAPI.setPlaceholders(player, "%worldguard_region_name_capitalized%");
        board.getTeam("Location").setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Location: " + ChatColor.DARK_GREEN + "★" + ChatColor.GREEN + regionName + ChatColor.DARK_GREEN + "★");
        board.getTeam("Season").setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Season: " + ChatColor.WHITE + Seasons.getInstance().getWorldCycle(player.getWorld()).getSeason().getName() + " " +
                Seasons.getInstance().getWorldCycle(player.getWorld()).getDay() + "/30"
        );
        board.getTeam("Coins").setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Coins: " + ChatColor.WHITE +  "$" + format.format(economy.getBalance(player)));

        String jobName = PlaceholderAPI.setPlaceholders(player, "%jobsr_user_jobs%");
        String jobQuest = PlaceholderAPI.setPlaceholders(player, " %jobsr_user_quests%");
        board.getTeam("Job").setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Job: " + ChatColor.WHITE + jobName);
        board.getTeam("jobQuestLine").setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "JobQuest:" + ChatColor.WHITE + jobQuest);
    }


}
