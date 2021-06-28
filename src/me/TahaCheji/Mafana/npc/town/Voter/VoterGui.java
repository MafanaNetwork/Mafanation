package me.TahaCheji.Mafana.npc.town.Voter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class VoterGui implements InventoryHolder {

    public static Inventory Voting;


    public void voting() {
        Voting = Bukkit.createInventory(null, 45, ChatColor.GRAY + "" + ChatColor.BOLD + "Voting");

        ItemStack Option1 = new ItemStack(Material.STONE_BUTTON);
        ItemMeta Option1meta = (ItemMeta) Option1.getItemMeta();
        Option1meta.setDisplayName(ChatColor.GOLD + "Update #1");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.WHITE + "Coming Soon");
        lore.add("");
        lore.add(ChatColor.GOLD + "Click To Submit your vote");
        Option1meta.setLore(lore);
        Option1.setItemMeta(Option1meta);


        ItemStack Option2 = new ItemStack(Material.STONE_BUTTON);
        ItemMeta Option2meta = (ItemMeta) Option2.getItemMeta();
        Option2meta.setDisplayName(ChatColor.GOLD + "Update #2");
        ArrayList<String> lore2 = new ArrayList<String>();
        lore2.add("");
        lore2.add(ChatColor.WHITE + "Coming Soon");
        lore2.add("");
        lore2.add(ChatColor.GOLD + "Click To Submit your vote");
        Option2meta.setLore(lore2);
        Option2.setItemMeta(Option2meta);


        ItemStack Option3 = new ItemStack(Material.STONE_BUTTON);
        ItemMeta Option3meta = (ItemMeta) Option3.getItemMeta();
        Option3meta.setDisplayName(ChatColor.GOLD + "Update #3");
        ArrayList<String> lore3 = new ArrayList<String>();
        lore3.add("");
        lore3.add(ChatColor.WHITE + "Coming Soon");
        lore3.add("");
        lore3.add(ChatColor.GOLD + "Click To Submit your vote");
        Option3meta.setLore(lore3);
        Option3.setItemMeta(Option3meta);


        Voting.setItem(24, Option3);

        Voting.setItem(22, Option2);

        Voting.setItem(20, Option1);

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
