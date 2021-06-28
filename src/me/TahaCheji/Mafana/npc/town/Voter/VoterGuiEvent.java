package me.TahaCheji.Mafana.npc.town.Voter;

import net.md_5.bungee.api.plugin.Listener;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.sql.SQLException;
import java.util.UUID;

public class VoterGuiEvent implements Listener {

    public static int option1;

    public static int option2;

    public static int option3;

    @EventHandler
    public void setvoting(InventoryClickEvent event) throws SQLException {
        Player player = (Player) event.getWhoClicked();
        UUID uuid = player.getUniqueId();
        if (!(event.getView().getTitle().contains("Baker"))) {
            return;
        }
        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;


        event.setCancelled(true);


        if (event.getSlot() == 20) {
//option1

            ++option1;

            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Voter: " +
                    ChatColor.BOLD + "Thank you for voting!");


            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);


            player.closeInventory();
            return;
        }

        if (event.getSlot() == 22) {
//option2

            ++option2;

            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Voter: " +
                    ChatColor.BOLD + "Thank you for voting!");

            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);

            player.closeInventory();
            return;
        }

        if (event.getSlot() == 24) {
//option3

            ++option3;

            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Voter: " +
                    ChatColor.BOLD + "Thank you for voting!");

            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);


            player.closeInventory();
            return;

        }

        if (event.getSlot() == 40) {
//close menu
            player.closeInventory();
        }
        return;

    }
}
