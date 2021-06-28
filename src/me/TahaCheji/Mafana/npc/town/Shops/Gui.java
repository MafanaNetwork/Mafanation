package me.TahaCheji.Mafana.npc.town.Shops;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Gui{
    /*
    public static Inventory weaponshop, oreshop, farmshop;

    public void shops() {
        weaponshop = Bukkit.createInventory(null, 45, ChatColor.GRAY + "" + ChatColor.BOLD + "WeaponSmith");

        ItemStack WoodSaliva = new ItemStack(Material.IRON_SWORD);
        ItemMeta WoodSalivaMeta = (ItemMeta) WoodSaliva.getItemMeta();
        WoodSalivaMeta.setDisplayName(ChatColor.GRAY + "WoodSaliva");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.LIGHT_PURPLE + "Strength:" + ChatColor.GRAY + " 15");
        lore.add("");
        lore.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 2k");
        WoodSalivaMeta.setLore(lore);
        WoodSaliva.setItemMeta(WoodSalivaMeta);

        weaponshop.setItem(10, WoodSaliva);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closemeta = close.getItemMeta();

        //CLOSE BUTTON
        closemeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Shop");
        lore.clear();
        closemeta.setLore(lore);
        close.setItemMeta(closemeta);
        weaponshop.setItem(31, close);

        //EMPTY SLOTS
        ItemStack newItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta newmeta = newItem.getItemMeta();
        newmeta.setDisplayName(ChatColor.GRAY + " ");
        newmeta.setLore(lore);
        newItem.setItemMeta(newmeta);
        for (int emptySlot = 0; emptySlot < weaponshop.getSize(); emptySlot++) {
            if (weaponshop.getItem(emptySlot) == null || weaponshop.getItem(emptySlot).getType().equals(Material.AIR)) {
                weaponshop.setItem(emptySlot, newItem);
            }
        }

        oreshop = Bukkit.createInventory(null, 45, ChatColor.GRAY + "" + ChatColor.BOLD + "OreMaster");
        ItemStack Diamond = new ItemStack(Material.DIAMOND);
        ItemMeta DiamondMeta = (ItemMeta) Diamond.getItemMeta();
        DiamondMeta.setDisplayName(ChatColor.BLUE + "Diamond");
        ArrayList<String> lore11 = new ArrayList<String>();
        lore11.add(ChatColor.GRAY + "Diamond the its like blue or somthin");
        lore11.add("");
        lore11.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 1000");
        DiamondMeta.setLore(lore11);
        Diamond.setItemMeta(DiamondMeta);


        ItemStack Iron = new ItemStack(Material.IRON_INGOT);
        ItemMeta IronMeta = (ItemMeta) Iron.getItemMeta();
        IronMeta.setDisplayName(ChatColor.GRAY + "Iron");
        ArrayList<String> lore22 = new ArrayList<String>();
        lore22.add(ChatColor.GRAY + "Iron is just Iron");
        lore22.add("");
        lore22.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 250");
        IronMeta.setLore(lore22);
        Iron.setItemMeta(IronMeta);


        ItemStack Gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta GoldMeta = (ItemMeta) Gold.getItemMeta();
        GoldMeta.setDisplayName(ChatColor.GOLD + "Gold");
        ArrayList<String> lore33 = new ArrayList<String>();
        lore33.add(ChatColor.GRAY + "Gold IM RiTCH");
        lore33.add("");
        lore33.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 1m");
        GoldMeta.setLore(lore33);
        Gold.setItemMeta(GoldMeta);

        ItemStack Lapis = new ItemStack(Material.LAPIS_LAZULI);
        ItemMeta LapisMeta = (ItemMeta) Lapis.getItemMeta();
        LapisMeta.setDisplayName(ChatColor.BLUE + "Lapis");
        ArrayList<String> lore44 = new ArrayList<String>();
        lore44.add(ChatColor.GRAY + "Lapis ewww poor");
        lore44.add("");
        lore44.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 15");
        LapisMeta.setLore(lore44);
        Lapis.setItemMeta(LapisMeta);

        ItemStack RedStuff = new ItemStack(Material.REDSTONE);
        ItemMeta RedStuffMeta = (ItemMeta) RedStuff.getItemMeta();
        RedStuffMeta.setDisplayName(ChatColor.GREEN + "RedStuff");
        ArrayList<String> lore55 = new ArrayList<String>();
        lore55.add(ChatColor.GRAY + "idk what is it????");
        lore55.add("");
        lore55.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 500");
        RedStuffMeta.setLore(lore55);
        RedStuff.setItemMeta(RedStuffMeta);

        oreshop.setItem(10, Diamond);
        oreshop.setItem(11, Iron);
        oreshop.setItem(12, Gold);
        oreshop.setItem(13, Lapis);
        oreshop.setItem(14, RedStuff);


        //CLOSE BUTTON
        closemeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Shop");
        lore.clear();
        closemeta.setLore(lore);
        close.setItemMeta(closemeta);
        oreshop.setItem(31, close);

        newmeta.setDisplayName(ChatColor.GRAY + " ");
        newmeta.setLore(lore);
        newItem.setItemMeta(newmeta);
        for (int emptySlot = 0; emptySlot < oreshop.getSize(); emptySlot++) {
            if (oreshop.getItem(emptySlot) == null || oreshop.getItem(emptySlot).getType().equals(Material.AIR)) {
                oreshop.setItem(emptySlot, newItem);
            }
        }


        farmshop = Bukkit.createInventory(null, 45, ChatColor.GRAY + "" + ChatColor.BOLD + "Farmist");
        ItemStack Carrot = new ItemStack(Material.CARROT);
        ItemMeta CarrotMeta = (ItemMeta) Carrot.getItemMeta();
        CarrotMeta.setDisplayName(ChatColor.GREEN + "Carrot");
        ArrayList<String> lore1 = new ArrayList<String>();
        lore1.add(ChatColor.GRAY + "Carrot is just a carrort");
        lore1.add("");
        lore1.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 10");
        CarrotMeta.setLore(lore1);
        Carrot.setItemMeta(CarrotMeta);


        ItemStack Potato = new ItemStack(Material.POTATO);
        ItemMeta PotatoMeta = (ItemMeta) Potato.getItemMeta();
        PotatoMeta.setDisplayName(ChatColor.GREEN + "Potato");
        ArrayList<String> lore2 = new ArrayList<String>();
        lore2.add(ChatColor.GRAY + "Potato is just a Potato");
        lore2.add("");
        lore2.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 10");
        PotatoMeta.setLore(lore2);
        Potato.setItemMeta(PotatoMeta);


        ItemStack BeetRoot = new ItemStack(Material.BEETROOT);
        ItemMeta BeetRootMeta = (ItemMeta) BeetRoot.getItemMeta();
        BeetRootMeta.setDisplayName(ChatColor.GREEN + "BeetRoot");
        ArrayList<String> lore3 = new ArrayList<String>();
        lore3.add(ChatColor.GRAY + "BeetRoot is just a BeetRoot");
        lore3.add("");
        lore3.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 10");
        BeetRootMeta.setLore(lore3);
        BeetRoot.setItemMeta(BeetRootMeta);

        ItemStack Berries = new ItemStack(Material.SWEET_BERRIES);
        ItemMeta BerriesMeta = (ItemMeta) Berries.getItemMeta();
        BerriesMeta.setDisplayName(ChatColor.GREEN + "Berries");
        ArrayList<String> lore4 = new ArrayList<String>();
        lore4.add(ChatColor.GRAY + "Berries is just a Berries");
        lore4.add("");
        lore4.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 10");
        BerriesMeta.setLore(lore4);
        Berries.setItemMeta(BerriesMeta);

        ItemStack Apple = new ItemStack(Material.APPLE);
        ItemMeta AppleMeta = (ItemMeta) Apple.getItemMeta();
        AppleMeta.setDisplayName(ChatColor.GREEN + "Apple");
        ArrayList<String> lore5 = new ArrayList<String>();
        lore5.add(ChatColor.GRAY + "Apple is just a Apple");
        lore5.add("");
        lore5.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 10");
        AppleMeta.setLore(lore5);
        Apple.setItemMeta(AppleMeta);

        farmshop.setItem(10, Carrot);
        farmshop.setItem(11, Potato);
        farmshop.setItem(12, BeetRoot);
        farmshop.setItem(13, Berries);
        farmshop.setItem(14, Apple);


        //CLOSE BUTTON
        closemeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Shop");
        lore.clear();
        closemeta.setLore(lore);
        close.setItemMeta(closemeta);
        farmshop.setItem(31, close);

        newmeta.setDisplayName(ChatColor.GRAY + " ");
        newmeta.setLore(lore);
        newItem.setItemMeta(newmeta);
        for (int emptySlot = 0; emptySlot < farmshop.getSize(); emptySlot++) {
            if (farmshop.getItem(emptySlot) == null || farmshop.getItem(emptySlot).getType().equals(Material.AIR)) {
                farmshop.setItem(emptySlot, newItem);
            }
        }
    }

    @Override
    public Inventory getInventory() {
        return weaponshop;
    }

     */

}
