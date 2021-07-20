package me.TahaCheji.Mafana.npc;

import me.TahaCheji.Mafana.Main;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NpcWalkLocations {

    private final NPC npc;
    private final Location location;
    private final int time;
    private final String Message;

    public NpcWalkLocations(NPC npc, Location location, int time, String Message) {
        this.npc = npc;
        this.location = location;
        this.time = time;
        this.Message = Message;
    }


    public void setWalk(Player player) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if(Message != null) {
                    player.sendMessage(ChatColor.GOLD + npc.getName() + ": " + ChatColor.WHITE + Message);
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
                }
                if(location != null) {
                    npc.getNavigator().setTarget(location);
                }
            }
        }, time * 20L);
    }

}
