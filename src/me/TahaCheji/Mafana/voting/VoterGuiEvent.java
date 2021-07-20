package me.TahaCheji.Mafana.voting;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.playerData.playerInfo.playerVotes;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VoterGuiEvent implements Listener {

    public static int option1 = MainVote.getUpdate1Votes();

    public static int option2 = MainVote.getUpdate2();

    public static int option3 = MainVote.getUpdate3();
    static List<UUID> players = new ArrayList<>();

    @EventHandler
    public void setvoting(InventoryClickEvent event) throws SQLException, IOException {
        Player player = (Player) event.getWhoClicked();
        UUID uuid = player.getUniqueId();
        if (!(event.getView().getTitle().contains("Voting"))) {
            return;
        }
        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;


        event.setCancelled(true);

        if(playerVotes.hasVoted(player)) {
            player.sendMessage(ChatColor.RED + "You have already voted.");
            return;
        }


        if (event.getSlot() == 20) {
//option1

            ++option1;
            players.add(player.getUniqueId());
            playerVotes.setVoted(player, true, "Update1");
            File updateVotes = new File("plugins/Mafanation/gameData.yml");
            FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
            pD.set("update1.votes", option1);
            pD.save(updateVotes);

            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Voter: " +
                    ChatColor.BOLD + "Thank you for voting!");


            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);


            player.closeInventory();
            //MainVote.addPlayersVoted();
            return;
        }

        if (event.getSlot() == 22) {
//option2

            ++option2;
            players.add(player.getUniqueId());
            playerVotes.setVoted(player, true, "Update2");
            File updateVotes = new File("plugins/Mafanation/gameData.yml");
            FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
            pD.set("update2.votes", option2);
            pD.save(updateVotes);

            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Voter: " +
                    ChatColor.BOLD + "Thank you for voting!");

            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);

            player.closeInventory();
            //MainVote.addPlayersVoted();
            return;
        }

        if (event.getSlot() == 24) {
//option3

            ++option3;
            players.add(player.getUniqueId());
            playerVotes.setVoted(player, true, "Update3");
            File updateVotes = new File("plugins/Mafanation/gameData.yml");
            FileConfiguration pD = YamlConfiguration.loadConfiguration(updateVotes);
            pD.set("update3.votes", option3);
            pD.save(updateVotes);

            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Voter: " +
                    ChatColor.BOLD + "Thank you for voting!");

            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);


            player.closeInventory();
           // MainVote.addPlayersVoted();
            return;

        }

        if (event.getSlot() == 40) {
//close menu
            player.closeInventory();
        }
    }
}
