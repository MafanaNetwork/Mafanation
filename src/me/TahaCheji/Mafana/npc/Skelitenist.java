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

public class Skelitenist implements Listener {

    public Skelitenist() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Skelitenist = registry.createNPC(EntityType.PLAYER, "Smith");
        Skelitenist.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Skelitenist " + ChatColor.GRAY + "(Right Click to talk)");
        Skelitenist.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Skelitenist")){
            Player player = event.getClicker();
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }

}
