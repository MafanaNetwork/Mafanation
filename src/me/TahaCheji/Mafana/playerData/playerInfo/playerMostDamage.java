package me.TahaCheji.Mafana.playerData.playerInfo;

import me.TahaCheji.Mafana.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.io.File;
import java.io.IOException;

public class playerMostDamage implements Listener {

    public static Double getMostDamage(Player p) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        Double count = pD.getDouble("info.mostDamage");
        return count;
    }

    public static void setMostDamage(Player p, double amount) throws IOException {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId().toString() + "/playerInfo.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        pD.set("info.mostDamage", amount);
        pD.save(playerData);
    }

    @EventHandler
    public static void onHit(EntityDamageByEntityEvent e) throws IOException {
        if(!(e.getEntity() instanceof LivingEntity)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        if(e.getEntity() instanceof ArmorStand) {
            e.setCancelled(true);
            return;
        }
        Player player = (Player) e.getDamager();
        Double damage = e.getDamage();
        if(getMostDamage(player) >= damage ) {
            return;
        }
        setMostDamage(player, damage);
    }

}
