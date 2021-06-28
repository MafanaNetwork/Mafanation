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

public class Helper implements Listener {

    public Helper() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Helper = registry.createNPC(EntityType.PLAYER, "Smith");
        Helper.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Helper " + ChatColor.GRAY + "(Right Click to talk)");
        Helper.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Helper")){
            Player player = event.getClicker();
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Helper: " +
                    ChatColor.BLUE + "WELCOME " + "to " + ChatColor.GOLD + "Mafanation " + "what will be your next adventure");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }


}
