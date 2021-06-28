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

public class Jumper implements Listener {

    public Jumper() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Jumper = registry.createNPC(EntityType.PLAYER, "Smith");
        Jumper.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Jumper " + ChatColor.GRAY + "(Right Click to talk)");
        Jumper.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Jumper")){
            Player player = event.getClicker();
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Jumper: " +
                    ChatColor.RED + "KILL THEM ALL ALL OF THE HORSES ALL OF THEM");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }

}
