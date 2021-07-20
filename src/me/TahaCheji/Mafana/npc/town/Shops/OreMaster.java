package me.TahaCheji.Mafana.npc.town.Shops;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OreMaster implements Listener {

    public static ItemStack Diamond() {
        ItemStack Diamond = new ItemStack(Material.DIAMOND);
        ItemMeta DiamondMeta = Diamond.getItemMeta();
        DiamondMeta.setDisplayName(ChatColor.AQUA + "Diamond");
        ArrayList<String> lore11 = new ArrayList<String>();
        lore11.add("");
        lore11.add(ChatColor.AQUA + "Iron" + ChatColor.BOLD + " Material");
        DiamondMeta.setLore(lore11);
        Diamond.setItemMeta(DiamondMeta);
        return Diamond.clone();
    }


    public static ItemStack Iron() {
        ItemStack Iron = new ItemStack(Material.IRON_INGOT);
        ItemMeta IronMeta = Iron.getItemMeta();
        IronMeta.setDisplayName(ChatColor.AQUA + "Iron Ingot");
        ArrayList<String> lore22 = new ArrayList<String>();
        lore22.add("");
        lore22.add(ChatColor.AQUA + "Iron" + ChatColor.BOLD + " Material");
        IronMeta.setLore(lore22);
        Iron.setItemMeta(IronMeta);
        return Iron.clone();
    }


    public static ItemStack Gold() {
        ItemStack Gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta GoldMeta = Gold.getItemMeta();
        GoldMeta.setDisplayName(ChatColor.AQUA + "Gold");
        ArrayList<String> lore33 = new ArrayList<String>();
        lore33.add("");
        lore33.add(ChatColor.AQUA + "Iron" + ChatColor.BOLD + " Material");
        GoldMeta.setLore(lore33);
        Gold.setItemMeta(GoldMeta);
        return Gold.clone();
    }


    public static ItemStack Lapis() {
        ItemStack Lapis = new ItemStack(Material.LAPIS_LAZULI);
        ItemMeta LapisMeta = Lapis.getItemMeta();
        LapisMeta.setDisplayName(ChatColor.AQUA + "Lapis");
        ArrayList<String> lore44 = new ArrayList<String>();
        lore44.add("");
        lore44.add(ChatColor.AQUA + "Iron" + ChatColor.BOLD + " Material");
        LapisMeta.setLore(lore44);
        Lapis.setItemMeta(LapisMeta);
        return Lapis.clone();
    }

    public static ItemStack RedStuff() {
        ItemStack RedStuff = new ItemStack(Material.REDSTONE);
        ItemMeta RedStuffMeta = RedStuff.getItemMeta();
        RedStuffMeta.setDisplayName(ChatColor.AQUA + "RedStuff");
        ArrayList<String> lore55 = new ArrayList<String>();
        lore55.add("");
        lore55.add(ChatColor.AQUA + "Iron" + ChatColor.BOLD + " Material");
        RedStuffMeta.setLore(lore55);
        RedStuff.setItemMeta(RedStuffMeta);
        return RedStuff.clone();
    }

    public static ItemStack EMERALD() {
        ItemStack EMERALD = new ItemStack(Material.EMERALD);
        ItemMeta EMERALDMeta = EMERALD.getItemMeta();
        EMERALDMeta.setDisplayName(ChatColor.AQUA + "Emerald");
        ArrayList<String> lore55 = new ArrayList<String>();
        lore55.add("");
        lore55.add(ChatColor.AQUA + "Iron" + ChatColor.BOLD + " Material");
        EMERALDMeta.setLore(lore55);
        EMERALD.setItemMeta(EMERALDMeta);
        return EMERALD.clone();
    }

    public OreMaster() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC OreMaster = registry.createNPC(EntityType.PLAYER, "Smith");
        OreMaster.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "OreMaster " + ChatColor.GRAY + "(Right Click to open shop)");
        OreMaster.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("OreMaster")){
            Player player = event.getClicker();
            player.performCommand("oreshop");
            
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }


}
