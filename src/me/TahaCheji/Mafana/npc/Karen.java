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

public class Karen implements Listener {

    public Karen() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Karen = registry.createNPC(EntityType.PLAYER, "Smith");
        Karen.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Karen " + ChatColor.GRAY + "(Right Click to talk)");
        Karen.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Karen")){
            Player player = event.getClicker();
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Karen: " +
                    ChatColor.RED + "WHERE IS THE SHOP I WANT TO MALL CALL THE MANAGER");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }
}
