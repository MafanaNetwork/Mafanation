package me.TahaCheji.Mafana.npc.town.Baker;

import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static me.TahaCheji.Mafana.itemData.ItemUtl.*;

import java.util.ArrayList;

    public class BakerShopGui implements InventoryHolder {
    public Inventory bakerShop;
    public BakerShopGui(Player player) {
        bakerShop = Bukkit.createInventory(null, 54, ChatColor.GRAY + "" + ChatColor.BOLD + "Baker's Shop");
        ArrayList<String> lore = new ArrayList<String>();

/*
        ItemStack bread = new ItemStack(Material.BREAD);
        ItemMeta bread_meta = bread.getItemMeta();
        bread_meta.setDisplayName(ChatColor.GOLD + "Loaf Of Health");
        ArrayList<String> bread_lore = new ArrayList<>();
        bread_lore.add("");
        bread_lore.add(ChatColor.GOLD + "[Right Click]");
        bread_lore.add(ChatColor.WHITE + "Summons 3 Cooks to fight for you!");
        bread_lore.add(ChatColor.WHITE + "(For Only 30 Seconds)");
        bread_lore.add("");
        bread_lore.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 200");
        bread_lore.add("");
        bread_lore.add("Lapis" + " Item");
        bread_meta.setLore(bread_lore);
        bread.setItemMeta(bread_meta);

        ItemStack pie = new ItemStack(Material.PUMPKIN_PIE);
        ItemMeta pie_meta = pie.getItemMeta();
        pie_meta.setDisplayName(ChatColor.GOLD +  "Mana Infused Pie");
        ArrayList<String> pie_lore = new ArrayList<>();
        pie_lore.add("");
        pie_lore.add(ChatColor.GOLD + "[Right Click]");
        pie_lore.add(ChatColor.WHITE + "Gives 100 mana that will not regenerate");
        pie_lore.add(ChatColor.WHITE + "(You cant consume more than 1 Mana Infused Pie at a time.");
        pie_lore.add("");
        pie_lore.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 500");
        pie_lore.add("");
        pie_lore.add("Lapis" + " Item");
        pie_meta.setLore(pie_lore);
        pie.setItemMeta(pie_meta);

        ItemStack rabbitstew = new ItemStack(Material.RABBIT_STEW);
        ItemMeta rabbitstew_meta = rabbitstew.getItemMeta();
        rabbitstew_meta.setDisplayName(ChatColor.GOLD + "Stew Of Strength");
        ArrayList<String> rabbitstew_lore = new ArrayList<>();
        rabbitstew_lore.add("");
        rabbitstew_lore.add(ChatColor.GOLD + "[Right Click]");
        rabbitstew_lore.add(ChatColor.WHITE + "Gives 10 strength for 30 seconds.");
        rabbitstew_lore.add("");
        rabbitstew_lore.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 1000");
        rabbitstew_lore.add("");
        rabbitstew_lore.add("Lapis" + " Item");
        rabbitstew_meta.setLore(rabbitstew_lore);
        rabbitstew.setItemMeta(rabbitstew_meta);

        ItemStack cookie = new ItemStack(Material.COOKIE);
        ItemMeta cookie_meta = cookie.getItemMeta();
        cookie_meta.setDisplayName(ChatColor.GOLD + "Cookie Of Strength");
        ArrayList<String> cookie_lore = new ArrayList<>();
        cookie_lore.add("");
        cookie_lore.add(ChatColor.GOLD + "[Right Click]");
        cookie_lore.add(ChatColor.WHITE + "Gives 3 strength for 30 seconds.");
        cookie_lore.add("");
        cookie_lore.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 50");
        cookie_lore.add("");
        cookie_lore.add("Lapis" + " Item");
        cookie_meta.setLore(cookie_lore);
        cookie.setItemMeta(cookie_meta);

        ItemStack cake = new ItemStack(Material.CAKE);
        ItemMeta cake_meta = cake.getItemMeta();
        cake_meta.setDisplayName(ChatColor.GOLD + "Slice Of Health");
        ArrayList<String> cake_lore = new ArrayList<>();
        cake_lore.add("");
        cake_lore.add(ChatColor.GOLD  + "[Right Click]");
        cake_lore.add(ChatColor.WHITE + "Gives 100 health that will not regenerate");
        cake_lore.add(ChatColor.WHITE + "(You cant consume more than 1 slices of health at a time)");
        cake_lore.add("");
        cake_lore.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 1500");
        cake_lore.add("");
        cake_lore.add("Lapis" + " Item");
        cake_meta.setLore(cake_lore);
        cake.setItemMeta(cake_meta);

        ItemStack bakedpotato = new ItemStack(Material.BAKED_POTATO);
        ItemMeta bakedpotato_meta = bakedpotato.getItemMeta();
        bakedpotato_meta.setDisplayName(ChatColor.GOLD + "Baked Potato Of Speed");
        ArrayList<String> bakedpotato_lore = new ArrayList<>();
        bakedpotato_lore.add("");
        bakedpotato_lore.add(ChatColor.GOLD + "[Right Click]");
        bakedpotato_lore.add(ChatColor.DARK_GRAY + "Gives 50 speed for 30 seconds.");
        bakedpotato_lore.add("");
        bakedpotato_lore.add(ChatColor.GOLD + "COST:" + ChatColor.GRAY + " 450");
        bakedpotato_lore.add("");
        bakedpotato_lore.add( "Lapis" + " Item");
        bakedpotato_meta.setLore(bakedpotato_lore);
        bakedpotato.setItemMeta(bakedpotato_meta);

 */

        ItemStack closeShop = new ItemStack(Material.BARRIER);
        ItemMeta closeShopeta = closeShop.getItemMeta();
        closeShopeta.setDisplayName(ChatColor.GRAY + "Close Shop");
        closeShopeta.setLore(lore);
        closeShop.setItemMeta(closeShopeta);


        ItemStack greystainedglass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta newmeta = greystainedglass.getItemMeta();
        newmeta.setDisplayName(ChatColor.GRAY + " ");
        newmeta.setLore(lore);
        greystainedglass.setItemMeta(newmeta);

        bakerShop.setItem(0,greystainedglass);
        bakerShop.setItem(1,greystainedglass);
        bakerShop.setItem(2,greystainedglass);
        bakerShop.setItem(3,greystainedglass);
        bakerShop.setItem(4,greystainedglass);
        bakerShop.setItem(5,greystainedglass);
        bakerShop.setItem(6,greystainedglass);
        bakerShop.setItem(7,greystainedglass);
        bakerShop.setItem(8,greystainedglass);
        bakerShop.setItem(17,greystainedglass);
        bakerShop.setItem(26,greystainedglass);
        bakerShop.setItem(35,greystainedglass);
        bakerShop.setItem(45,greystainedglass);
        bakerShop.setItem(53,greystainedglass);
        bakerShop.setItem(52,greystainedglass);
        bakerShop.setItem(51,greystainedglass);
        bakerShop.setItem(50,greystainedglass);
        bakerShop.setItem(49,greystainedglass);
        bakerShop.setItem(48,greystainedglass);
        bakerShop.setItem(47,greystainedglass);
        bakerShop.setItem(46,greystainedglass);
        bakerShop.setItem(45,greystainedglass);
        bakerShop.setItem(36,greystainedglass);
        bakerShop.setItem(27,greystainedglass);
        bakerShop.setItem(18,greystainedglass);
        bakerShop.setItem(9,greystainedglass);
        bakerShop.setItem(40,closeShop);
        /*
        bakerShop.setItem(11,pie);
        bakerShop.setItem(12,rabbitstew);
        bakerShop.setItem(13,cookie);
        bakerShop.setItem(14,cake);
        bakerShop.setItem(15,bakedpotato);

         */





    }


    @Override
    public Inventory getInventory() {
        return bakerShop;
    }
}

