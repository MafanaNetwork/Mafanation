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

public class Ben implements Listener {

    public Ben() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Ben = registry.createNPC(EntityType.PLAYER, "Smith");
        Ben.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Ben " + ChatColor.GRAY + "(Right Click to talk)");
        Ben.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Ben")){
            Player player = event.getClicker();
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Ben: " +
                    ChatColor.AQUA + "guess who I AM, " + ChatColor.GOLD + "I AM BEN");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }

}
