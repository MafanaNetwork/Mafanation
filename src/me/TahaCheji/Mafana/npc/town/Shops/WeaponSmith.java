package me.TahaCheji.Mafana.npc.town.Shops;


import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class WeaponSmith implements Listener {


    public WeaponSmith() {
        World world = Bukkit.getWorld("Mafanation");
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC WeaponSmith = registry.createNPC(EntityType.PLAYER, "Smith");
        WeaponSmith.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "WeaponSmith " + ChatColor.GRAY + "(Right Click to open shop)");
        WeaponSmith.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("WeaponSmith")){
            Player player = event.getClicker();
            player.performCommand("weaponshop");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_FALL, 10, 10);
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }
}
