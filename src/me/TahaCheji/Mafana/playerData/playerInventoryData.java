package me.TahaCheji.Mafana.playerData;

import me.TahaCheji.Mafana.listeners.PlayerQuit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class playerInventoryData implements Listener {

    //-players inventory
    public static void saveInventory(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerInventory.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        if(!(p.getInventory().getContents() == null)) {
            pD.set("inventory.armor", p.getInventory().getArmorContents());
        }
        if(!(p.getInventory().getArmorContents() == null) ){
            pD.set("inventory.content", p.getInventory().getContents());
        }
        pD.save(playerData);
    }

    @SuppressWarnings("unchecked")
    public static void restoreInventory(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerInventory.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        if(pD.get("inventory.armor") == null) {
            return;
        }
        ItemStack[] content = ((List<ItemStack>) pD.get("inventory.armor")).toArray(new ItemStack[0]);
        p.getInventory().setArmorContents(content);
        content = ((List<ItemStack>) pD.get("inventory.content")).toArray(new ItemStack[0]);
        p.getInventory().setContents(content);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) throws IOException {
        saveInventory(e.getPlayer());
    }
}
