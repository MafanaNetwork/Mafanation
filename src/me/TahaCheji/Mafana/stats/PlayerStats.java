package me.TahaCheji.Mafana.stats;


import me.TahaCheji.Mafana.utils.Files;
import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class PlayerStats {

    public static HashMap<UUID, PlayerStats> playerStats = new HashMap<UUID, PlayerStats>();

    private Player p;

    private UUID playerUUID;

    public static double strength;
    public double max_mana;
    public double max_health;
    public double speed;
    public double cur_intelligence;



    public void setPlayer(Player player) {
        p = player;
    }
    public Player getPlayer() {
        return p;
    }
    public void setUUID(UUID uuid) {
        playerUUID = uuid;
    }
    public UUID getUUID() {
        return playerUUID;
    }
    public void setStrength(double value) {
        strength = value;
    }

    public double getStrength() {
        return strength;
    }

    public void setSpeed(double value) {
        speed = value;
        p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.002 * speed);
    }
    public double getSpeed() {
        return speed;
    }
    public void setMaxIntelligence(double value) {
        max_mana = value;
    }
    public double getMaxIntelligence() {
        return max_mana;
    }
    public void setMaxHealth(double value) {
        max_health = value;
        p.setMaxHealth(value);
        p.setHealthScale(40);
    }
    public double getMaxHealth() {
        return max_health;
    }
    public void setCurrentHealth(double value) {
        if(value < p.getMaxHealth()) {
            p.setHealth(value);
        }
    }
    public double getCurrentHealth() {
        return p.getHealth();
    }
    public void setCurrentIntelligence(double value) {
        cur_intelligence = value;
    }
    public double getCurrentIntelligence() {
        return cur_intelligence;
    }

    public static double  getHealthWithoutBase(Player p) {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/data.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        double health = pD.getDouble("stats.extra_health");
        ItemStack[] armor = p.getInventory().getArmorContents();

        for(ItemStack is : armor) {
            if(is != null && is.hasItemMeta() && is.getItemMeta().hasLore()) {
                health = health + NBTUtils.getDouble(is, "baseHealth") + NBTUtils.getDouble(is, "reforgeHealth");
                p.setHealthScale(40);
               p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
               p.setHealth(health);
            }
        }

        ItemStack iih = p.getItemInHand();
        if(iih != null && iih.hasItemMeta() && iih.getItemMeta().hasLore()) {
            health = health + NBTUtils.getDouble(iih, "baseHealth") + NBTUtils.getDouble(iih, "reforgeHealth");
            p.setHealthScale(40);
        }
        return health;
    }

    public static double  getTotalHealth(Player p) {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/data.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);

        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        double health = Files.cfg.getDouble("base_health") + pD.getDouble("stats.extra_health");
        ItemStack[] armor = p.getInventory().getArmorContents();

        for(ItemStack is : armor) {
            if(is != null && is.hasItemMeta() && is.getItemMeta().hasLore()) {
                health = health + NBTUtils.getDouble(is, "baseHealth") + NBTUtils.getDouble(is, "reforgeHealth");
                p.setHealthScale(40);
                p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
                p.setHealth(health);
            }
        }
        ItemStack iih = p.getItemInHand();
        if(iih != null && iih.hasItemMeta() && iih.getItemMeta().hasLore()) {
            health = health + NBTUtils.getDouble(iih, "baseHealth") + NBTUtils.getDouble(iih, "reforgeHealth");
            p.setHealthScale(40);
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
            p.setHealth(health);
        }
        return health;
    }
    public static double  getTotalIntelligence(Player p) {

        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/data.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);

        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        double intelligence = Files.cfg.getDouble("base_mana") + pD.getDouble("stats.extra_mana");
        ItemStack[] armor = p.getInventory().getArmorContents();

        for(ItemStack is : armor) {
            if(is != null && is.hasItemMeta() && is.getItemMeta().hasLore()) {
                intelligence = intelligence + NBTUtils.getDouble(is, "baseMana") + NBTUtils.getDouble(is, "reforgeMana");
            }
        }
        ItemStack iih = p.getItemInHand();
        if(iih != null && iih.hasItemMeta() && iih.getItemMeta().hasLore()) {
            intelligence = intelligence + NBTUtils.getDouble(iih, "baseMana") + NBTUtils.getDouble(iih, "reforgeMana");
        }
        return intelligence;
    }

    public static double getStrength(Player p) {
        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/data.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        double strength = Files.cfg.getDouble("base_strength") + pD.getDouble("stats.extra_strength");
        ItemStack[] armor = p.getInventory().getArmorContents();
        for(ItemStack is : armor) {
            if(is != null && is.hasItemMeta() && is.getItemMeta().hasLore()) {
                strength = strength + NBTUtils.getDouble(is, "baseStrength") + NBTUtils.getDouble(is, "reforgeStrength");
            }
        }
        ItemStack iih = p.getItemInHand();
        if(iih != null && iih.hasItemMeta() && iih.getItemMeta().hasLore()) {
            strength = strength + NBTUtils.getDouble(iih, "baseStrength") + NBTUtils.getDouble(iih, "reforgeStrength");
        }
        return strength;
    }

    public static double getSpeed(Player p) {

        File playerData = new File("plugins/Mafanation/playerData/" + p.getUniqueId() + "/data.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);

        try {
            pD.load(playerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        double speed = Files.cfg.getDouble("base_speed") + pD.getDouble("stats.extra_speed");
        ItemStack[] armor = p.getInventory().getArmorContents();

        for(ItemStack is : armor) {
            if(is != null && is.hasItemMeta() && is.getItemMeta().hasLore()) {
                speed = speed + NBTUtils.getDouble(is, "baseSpeed") + NBTUtils.getDouble(is, "reforgeSpeed");
            }
        }
        ItemStack iih = p.getItemInHand();
        if(iih != null && iih.hasItemMeta() && iih.getItemMeta().hasLore()) {
            speed = speed + NBTUtils.getDouble(iih, "baseSpeed") + NBTUtils.getDouble(iih, "reforgeSpeed");
        }
        return speed;
    }
}
