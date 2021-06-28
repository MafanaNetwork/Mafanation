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

public class Frosty implements Listener {

    public Frosty() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Frosty = registry.createNPC(EntityType.PLAYER, "Smith");
        Frosty.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Frosty " + ChatColor.GRAY + "(Right Click to talk)");
        Frosty.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Frosty")){
            Player player = event.getClicker();
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Frosty: " +
                    ChatColor.AQUA + "why is everyone scared idk man just go there lmfao");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }


}
