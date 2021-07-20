package me.TahaCheji.Mafana.playerData;

import me.TahaCheji.Mafana.listeners.PlayerDeath;
import me.TahaCheji.Mafana.utils.NBTUtils;
import me.TahaCheji.Mafana.utils.removeHealth;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;
import java.io.IOException;

public class playerMobData implements Listener {

   static removeHealth health = new removeHealth();

    public static double getMobCollection(Player p, Entity entity) {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerMobData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        if(pD.get("collections." + entity.getType()) == null) {
            return 0;
        }
        double count = pD.getDouble("collections." + entity.getType());

        return count;
    }

    public static void setMobCollection(Player p, Entity entity) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerMobData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("collections." + entity.getType(), getMobCollection(p, entity) + 1);
        pD.save(playerData);

    }

    public static double getAdvancedMobCollection(Player p, Entity entity) {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerMobData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        health.removeMobHealth(entity);
        if(pD.get("collectionsAdvanced." + entity.getCustomName()) == null) {
            return 0;
        }
        if(NBTUtils.getEntityString(entity, "MobName") == null) return 0;
        double count = pD.getDouble("collectionsAdvanced." + NBTUtils.getEntityString(entity, "MobName"));

        return count;
    }

    public static void setAdvancedMobCollection(Player p, Entity entity) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerMobData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        health.removeMobHealth(entity);
        pD.set("collectionsAdvanced." + entity.getCustomName(), getAdvancedMobCollection(p, entity) + 1);
        pD.save(playerData);

    }

    public static Double getKillsTotalAmount(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerMobData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        double count = pD.getDouble("info.kills");

        return count;
    }

    public static void addKillsTotalAmount(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerMobData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("info.kills", getKillsTotalAmount(p) + 1);
        pD.save(playerData);

    }
    public static Double getDeathsTotalAmount(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerMobData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        double count = pD.getDouble("info.deaths");

        return count;
    }

    public static void addDeathsTotalAmount(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/playerMobData.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        pD.set("info.deaths", getDeathsTotalAmount(p) + 1);
        pD.save(playerData);

    }

    @EventHandler
    public void onKill(EntityDeathEvent e) throws IOException {
        Player player = e.getEntity().getKiller();
       Entity entity = e.getEntity();
       if(!(e.getEntity().getKiller() instanceof Player)) {
           return;
       }
        setMobCollection(player, entity);
       setAdvancedMobCollection(player, entity);
       addKillsTotalAmount(player);
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e ) throws IOException {
        Player player = e.getEntity();
        addDeathsTotalAmount(player);
    }
}
