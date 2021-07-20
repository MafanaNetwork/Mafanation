package me.TahaCheji.Mafana.mobData;

import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class CreateMob {

    private final String name;
    private final double spawnChance;
    private final double maxHealth;
    private final EntityType type;
    private final int strength;
    private final int defense;
    private final int damage;
    private final int speed;
    private final ItemStack mainItem;
    private final ItemStack[] armor;
    private final List<LootItem> lootTable;

     public CreateMob(String name, double spawnChance, EntityType type, double maxHealth, int strength, int defense, int damage, int speed,
                      ItemStack mainItem, ItemStack[] armor, LootItem... lootItems) {
        this.name = name;
        this.spawnChance = spawnChance;
        this.maxHealth = maxHealth;
        this.type = type;
        this.strength = strength;
        this.defense = defense;
        this.damage = damage;
        this.speed = speed;
        this.mainItem = mainItem;
        this.armor = armor;
        lootTable = Arrays.asList(lootItems);
    }

    public LivingEntity spawnMob(Location location) {
        LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, type);
        entity.setCustomNameVisible(true);
        entity.setCustomName(name + " " + ChatColor.RED + "♥" + maxHealth + "♥");
        entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
        entity.setHealth(maxHealth);
        if(defense != 0) {
            entity.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(defense);
        }
        if(speed != 0) {
            entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
        }
        entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(strength * damage / 5);
        EntityEquipment inv = entity.getEquipment();
        if (armor != null) inv.setArmorContents(armor);
        inv.setHelmetDropChance(0f);
        inv.setChestplateDropChance(0f);
        inv.setLeggingsDropChance(0f);
        inv.setBootsDropChance(0f);
        inv.setItemInMainHand(mainItem);
        inv.setItemInMainHandDropChance(0f);
        NBTUtils.setEntityString(entity, "MobName", name);
        return entity;
    }

    public void tryDropLoot(Location location, Player player) {
        for (LootItem item : lootTable) {
            item.tryDropItem(location, player);
        }
    }

    public String getName() {
        return name;
    }

    public double getSpawnChance() {
        return spawnChance;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public EntityType getType() {
        return type;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public ItemStack getMainItem() {
        return mainItem;
    }

    public ItemStack[] getArmor() {
        return armor;
    }

    public List<LootItem> getLootTable() {
        return lootTable;
    }
}
