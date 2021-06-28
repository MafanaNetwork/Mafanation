package me.TahaCheji.Mafana.npc.town.GuildNpc;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.*;
import org.bukkit.entity.EntityType;

public class Shaggy {

    public static void Shaggy() {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Shaggy = registry.createNPC(EntityType.PLAYER, "Smith");
        NPC chatBox = registry.createNPC(EntityType.ARMOR_STAND, "");
        Shaggy.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Shaggy " + ChatColor.GRAY + "(Guild Npc)");
        Shaggy.setProtected(true);
        Location location = new Location(Bukkit.getWorld("world"),20, 69, 6);
        Shaggy.spawn(location);
        chatBox.spawn(location);
    }

}
