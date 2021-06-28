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

public class Heloraptor implements Listener {

    public Heloraptor() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Heloraptor = registry.createNPC(EntityType.PLAYER, "Smith");
        Heloraptor.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Heloraptor " + ChatColor.GRAY + "(Right Click to talk)");
        Heloraptor.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Heloraptor")){
            Player player = event.getClicker();
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Heloraptor: " +
                    ChatColor.RED + "UHHHH " + ChatColor.GOLD + "cheese");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }

}
