package me.TahaCheji.Mafana.npc;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class WolfMaster implements Listener {

    public WolfMaster() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC WolfMaster = registry.createNPC(EntityType.PLAYER, "Smith");
        WolfMaster.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "WolfMaster " + ChatColor.GRAY + "(Right Click to talk)");
        WolfMaster.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("WolfMaster")){
            Player player = event.getClicker();
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "WolfMaster: " + ChatColor.RED + "DO NOT " + "go this way it is dangerous they will eat you " + ChatColor.RED + "ALIVE");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }


}
