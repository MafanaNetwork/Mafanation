package me.TahaCheji.Mafana.npc;

import me.TahaCheji.Mafana.Main;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class Lobby implements Listener {

    public Lobby() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Lobby = registry.createNPC(EntityType.PLAYER, "Smith");
        Lobby.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Lobby " + ChatColor.GRAY + "(Right Click to talk)");
        Lobby.setProtected(true);
    }
    @EventHandler
    public void onRightClick(NPCRightClickEvent event){
        NPC npc = event.getNPC();
        if (npc.getName().contains("Lobby")){
            Player player = event.getClicker();
            player.sendMessage(ChatColor.GOLD + "[NPC] " + "Lobby: " +
                    ChatColor.AQUA + "Sending you back to the lobby");

            try {
                ByteArrayOutputStream b = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(b);
                out.writeUTF("Connect");
                out.writeUTF("Lobby");
                player.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
                b.close();
                out.close();
            }
            catch (Exception e) {
                player.sendMessage(ChatColor.RED+"Error when trying to connect to " + "Lobby");
            }
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
        }
    }

}
