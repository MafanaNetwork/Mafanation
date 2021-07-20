package me.TahaCheji.Mafana.npc.town.GuildNpc;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.npc.NpcWalkLocations;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.NavigatorParameters;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Jen {

    public static void Jen(Player player) {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC Jen = registry.createNPC(EntityType.PLAYER, "Smith");
        Jen.setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Jen " + ChatColor.GRAY + "[Guild Npc]");
        SkinTrait skinTrait = Jen.getOrAddTrait(SkinTrait.class);
        skinTrait.setSkinName("Jen", true);
        Jen.setProtected(true);
        Location location = new Location(Bukkit.getWorld("world"),20, 69, 6);
        Jen.spawn(location);

        new NpcWalkLocations(Jen, new Location(Bukkit.getWorld("world"), 34, 68, 12), 2, "Follow me dumb shit").setWalk(player);
    }

}
