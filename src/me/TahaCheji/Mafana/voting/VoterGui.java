package me.TahaCheji.Mafana.voting;

import me.TahaCheji.Mafana.playerData.playerInfo.playerVotes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;

public class VoterGui implements InventoryHolder {

    public static Inventory Voting;

    public ItemStack Option1(Player player) throws IOException {
        if(playerVotes.getVotedFor(player).contains("Update1")) {
            ItemStack Option1 = new ItemStack(Material.OAK_BUTTON);
            ItemMeta Option1meta = Option1.getItemMeta();
            Option1meta.setDisplayName(ChatColor.GOLD + "Update #1");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("");
            lore.add(ChatColor.GOLD + MainVote.getUpdate1Name());
            lore.add(ChatColor.GRAY + MainVote.getUpdate1Info());
            lore.add("");
            lore.add(ChatColor.GOLD + "You have voted for this update!");
            Option1meta.setLore(lore);
            Option1.setItemMeta(Option1meta);
            return Option1;
        }
        ItemStack Option1 = new ItemStack(Material.STONE_BUTTON);
        ItemMeta Option1meta = Option1.getItemMeta();
        Option1meta.setDisplayName(ChatColor.GOLD + "Update #1");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.GOLD + MainVote.getUpdate1Name());
        lore.add(ChatColor.GRAY + MainVote.getUpdate1Info());
        lore.add("");
        lore.add(ChatColor.GOLD + "Click To Submit your vote");
        Option1meta.setLore(lore);
        Option1.setItemMeta(Option1meta);
        return Option1;
    }

    public ItemStack Option2(Player player) throws IOException {
        if(playerVotes.getVotedFor(player).contains("Update2")) {
            ItemStack Option1 = new ItemStack(Material.OAK_BUTTON);
            ItemMeta Option1meta = Option1.getItemMeta();
            Option1meta.setDisplayName(ChatColor.GOLD + "Update #2");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("");
            lore.add(ChatColor.GOLD + MainVote.getUpdate2Name());
            lore.add(ChatColor.GRAY + MainVote.getUpdate2Info());
            lore.add("");
            lore.add(ChatColor.GOLD + "You have voted for this update!");
            Option1meta.setLore(lore);
            Option1.setItemMeta(Option1meta);
            return Option1;
        }
        ItemStack Option1 = new ItemStack(Material.STONE_BUTTON);
        ItemMeta Option1meta = Option1.getItemMeta();
        Option1meta.setDisplayName(ChatColor.GOLD + "Update #2");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.GOLD + MainVote.getUpdate2Name());
        lore.add(ChatColor.GRAY + MainVote.getUpdate2Info());
        lore.add("");
        lore.add(ChatColor.GOLD + "Click To Submit your vote");
        Option1meta.setLore(lore);
        Option1.setItemMeta(Option1meta);
        return Option1;
    }

    public ItemStack Option3(Player player) throws IOException {
        if(playerVotes.getVotedFor(player).contains("Update3")) {
            ItemStack Option1 = new ItemStack(Material.OAK_BUTTON);
            ItemMeta Option1meta = Option1.getItemMeta();
            Option1meta.setDisplayName(ChatColor.GOLD + "Update #3");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("");
            lore.add(ChatColor.GOLD + MainVote.getUpdate3Name());
            lore.add(ChatColor.GRAY + MainVote.getUpdate3Info());
            lore.add("");
            lore.add(ChatColor.GOLD + "You have voted for this update!");
            Option1meta.setLore(lore);
            Option1.setItemMeta(Option1meta);
            return Option1;
        }
        ItemStack Option1 = new ItemStack(Material.STONE_BUTTON);
        ItemMeta Option1meta = Option1.getItemMeta();
        Option1meta.setDisplayName(ChatColor.GOLD + "Update #3");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.GOLD + MainVote.getUpdate3Name());
        lore.add(ChatColor.GRAY + MainVote.getUpdate3Info());
        lore.add("");
        lore.add(ChatColor.GOLD + "Click To Submit your vote");
        Option1meta.setLore(lore);
        Option1.setItemMeta(Option1meta);
        return Option1;
    }


    public VoterGui(Player player) throws IOException {
        Voting = Bukkit.createInventory(null, 45, ChatColor.GRAY + "" + ChatColor.BOLD + "Voting");

        ArrayList<String> lore = new ArrayList<String>();

        Voting.setItem(24, Option3(player));

        Voting.setItem(22, Option2(player));

        Voting.setItem(20, Option1(player));

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closemeta = close.getItemMeta();


        //CLOSE BUTTON
        closemeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Vote");
        lore.clear();
        closemeta.setLore(lore);
        close.setItemMeta(closemeta);
        Voting.setItem(40, close);

        //EMPTY SLOTS
        ItemStack newItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta newmeta = newItem.getItemMeta();
        newmeta.setDisplayName(ChatColor.GRAY + " ");
        newmeta.setLore(lore);
        newItem.setItemMeta(newmeta);
        for (int emptySlot = 0; emptySlot < Voting.getSize(); emptySlot++) {
            if (Voting.getItem(emptySlot) == null || Voting.getItem(emptySlot).getType().equals(Material.AIR)) {
                Voting.setItem(emptySlot, newItem);
            }
        }

    }

    @Override
    public Inventory getInventory() {
        return Voting;
    }
}
