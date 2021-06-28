package me.TahaCheji.Mafana.npc.town.Baker;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.playerData.playerTalkedTo;
import me.TahaCheji.Mafana.shops.BakerShop;
import me.TahaCheji.Mafana.utils.NBTUtils;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;

public class Baker implements Listener {

    public Baker() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Ben = registry.createNPC(EntityType.PLAYER, "Smith");
        Ben.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "[NPC] Baker " + ChatColor.GRAY + "(Right Click to open Shop)");
        Ben.setProtected(true);
    }

    @EventHandler
    public void onRightClick(NPCRightClickEvent event) throws IOException {
        NPC npc = event.getNPC();
        Player player = event.getClicker();
        if (npc.getName().contains("Baker")){
            player.openInventory(new BakerShop().bakersCock(player).getInventory());
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }

}
