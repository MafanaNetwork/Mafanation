package me.TahaCheji.Mafana.playerData;

import me.TahaCheji.Mafana.utils.NBTUtils;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;

public class playerTalkedTo implements Listener {
    //-talked to npcs
    public static void addTalkedTo(Player p, NPC npc) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerTalkedTo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        if(hasTalkedTo(p, npc) == true) {
            return;
        }

        pD.set("talkedTo." + npc.getName(), true);
        pD.save(playerData);

    }
    public static void removeTalkedTo(Player p, NPC npc) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerTalkedTo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        if(pD.contains("talkedTo." + npc.getName())) {
            return;
        }
        pD.set("talkedTo." + npc.getName(), false);
        pD.save(playerData);

    }

    public static Boolean hasTalkedTo(Player p, NPC npc) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerTalkedTo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        if(pD.getBoolean(String.valueOf("talkedTo." + npc.getName() == null))) {
            return false;
        }

       boolean count =  pD.getBoolean("talkedTo." + npc.getName());
        return count;
    }

    @EventHandler
    public void npcTalk(NPCRightClickEvent e) throws IOException {
        NBTUtils.setEntityString(e.getNPC().getEntity(), "NPC", "NPC");
        if(e.getNPC() == null) {
            return;
        }
        if(e.getNPC().getName() == null) {
            return;
        }
        addTalkedTo(e.getClicker(), e.getNPC());
    }
}
