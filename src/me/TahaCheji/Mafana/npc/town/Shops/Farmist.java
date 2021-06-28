package me.TahaCheji.Mafana.npc.town.Shops;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.game.Glow;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Farmist implements Listener {


    public static Main plugin = Main.getPlugin(Main.class);

    public static ItemStack Carrot() {
        ItemStack Bread = new ItemStack(Material.CARROT);
        ItemMeta BreadMeta = (ItemMeta) Bread.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin, Main.getInstance().getDescription().getName());
        Glow glow = new Glow(key);
        BreadMeta.setDisplayName(ChatColor.GREEN + "Carrot");
        BreadMeta.addEnchant(glow, 1, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY +"Carrot is just a carrort");
        BreadMeta.setLore(lore);
        Bread.setItemMeta(BreadMeta);
        return Bread.clone();

    }
    public static ItemStack Berries() {
        ItemStack Bread = new ItemStack(Material.SWEET_BERRIES);
        ItemMeta BreadMeta = (ItemMeta) Bread.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin, Main.getInstance().getDescription().getName());
        Glow glow = new Glow(key);
        BreadMeta.setDisplayName(ChatColor.GREEN + "Berries");
        BreadMeta.addEnchant(glow, 1, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY +"Berries is just a Berry");
        BreadMeta.setLore(lore);
        Bread.setItemMeta(BreadMeta);
        return Bread.clone();

    }
    public static ItemStack Potato() {
        ItemStack Bread = new ItemStack(Material.POTATO);
        ItemMeta BreadMeta = (ItemMeta) Bread.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin, Main.getInstance().getDescription().getName());
        Glow glow = new Glow(key);
        BreadMeta.setDisplayName(ChatColor.GREEN + "Potato");
        BreadMeta.addEnchant(glow, 1, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY +"Potato is just a Potato");
        BreadMeta.setLore(lore);
        Bread.setItemMeta(BreadMeta);
        return Bread.clone();

    }
    public static ItemStack BeetRoot() {
        ItemStack Bread = new ItemStack(Material.CARROT);
        ItemMeta BreadMeta = (ItemMeta) Bread.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin, Main.getInstance().getDescription().getName());
        Glow glow = new Glow(key);
        BreadMeta.setDisplayName(ChatColor.GREEN + "BeetRoot");
        BreadMeta.addEnchant(glow, 1, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY +"BeetRoot is just a BeetRoot");
        BreadMeta.setLore(lore);
        Bread.setItemMeta(BreadMeta);
        return Bread.clone();

    }
    public static ItemStack Apple() {
        ItemStack Bread = new ItemStack(Material.APPLE);
        ItemMeta BreadMeta = (ItemMeta) Bread.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin, Main.getInstance().getDescription().getName());
        Glow glow = new Glow(key);
        BreadMeta.setDisplayName(ChatColor.GREEN + "Apple");
        BreadMeta.addEnchant(glow, 1, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY +"Apple is just a Apple");
        BreadMeta.setLore(lore);
        Bread.setItemMeta(BreadMeta);
        return Bread.clone();

    }

    public Farmist() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Farmist = registry.createNPC(EntityType.PLAYER, "Smith");
        Farmist.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Farmist " + ChatColor.GRAY + "(Right Click to open shop)");
        Farmist.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Farmist")){
            Player player = event.getClicker();
            player.performCommand("farmshop");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }




}
