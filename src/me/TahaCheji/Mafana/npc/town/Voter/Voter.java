package me.TahaCheji.Mafana.npc.town.Voter;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.npc.town.Baker.BakerShopGui;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Voter implements Listener {

    public Voter() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Voter = registry.createNPC(EntityType.PLAYER, "Smith");
        Voter.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Voter " + ChatColor.GRAY + "(Right Click to Vote!)");
        Voter.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Voter")){
            Player player = event.getClicker();

            VoterGui gui = new VoterGui();
            player.openInventory(gui.getInventory());
        }
    }



}
