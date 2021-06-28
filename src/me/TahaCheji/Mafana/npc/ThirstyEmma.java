package me.TahaCheji.Mafana.npc;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.md_5.bungee.protocol.packet.Chat;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ThirstyEmma implements Listener {

    public ThirstyEmma() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC ThirstyEmma = registry.createNPC(EntityType.PLAYER, "Smith");
        ThirstyEmma.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "ThirstyEmma " + ChatColor.GRAY + "(Right Click to talk)");
        ThirstyEmma.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("ThirstyEmma")){
            Player player = event.getClicker();
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "ThirstyEmma: " +
                    ChatColor.RED + "PLEASE " + "get me a glass of water " +
                            ChatColor.RED + "NOW " + ChatColor.WHITE + "oh wait i have some right here lol "
                            + ChatColor.BOLD + "I would not go there if I was you");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }

}
