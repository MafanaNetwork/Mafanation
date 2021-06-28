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

public class Phiko implements Listener {

    public Phiko() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Phiko = registry.createNPC(EntityType.PLAYER, "Smith");
        Phiko.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Phiko " + ChatColor.GRAY + "(Right Click to talk)");
        Phiko.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Phiko")){
            Player player = event.getClicker();
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Phiko: " +
                    ChatColor.BOLD + "have some bread yum!");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }

}
