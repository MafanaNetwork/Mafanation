package me.TahaCheji.Mafana.npc;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GraveMiner implements Listener {

    public GraveMiner() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC GraveMiner = registry.createNPC(EntityType.PLAYER, "Smith");
        GraveMiner.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "GraveMiner " + ChatColor.GRAY + "(Right Click to talk)");
        GraveMiner.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("GraveMiner")){
            Player player = event.getClicker();
           /*
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "GraveMiner: " +
                    ChatColor.RED + "DO NOT GO DOWN THERE THE THING IS SCARY");

            */
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }

}
