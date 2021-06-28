package me.TahaCheji.Mafana.mobData;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R2.inventory.CraftItemStack;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class CustomMagicMob extends EntityMonster {
    private String name;
    private double spawnChance;
    private double maxHealth;
    private static EntityTypes type;
    private int strength;
    private int defense;
    private int damage;
    private int speed;
    private ItemStack mainItem;
    private ItemStack[] armor;
    private List<LootItem> lootTable;

    public CustomMagicMob (Location loc) {
        super(type, ((CraftWorld) loc.getWorld()).getHandle());

        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        LivingEntity entity = (LivingEntity) this.getBukkitEntity();

        this.setCustomNameVisible(true);
        this.setCustomName(new ChatComponentText(
                ChatColor.translateAlternateColorCodes
                        ('&', name + " " + ChatColor.RED + "♥" + maxHealth + "♥")));
        this.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(maxHealth);
        this.setHealth((float) maxHealth);
        if (defense != 0) {
            this.getAttributeInstance(GenericAttributes.ARMOR).setValue(defense);
        }
        if (speed != 0) {
            this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(speed);
        }
        this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(strength * damage / 5);
        EntityEquipment inv = entity.getEquipment();
        if (armor != null) inv.setArmorContents(armor);
        inv.setHelmetDropChance(0f);
        inv.setChestplateDropChance(0f);
        inv.setLeggingsDropChance(0f);
        inv.setBootsDropChance(0f);
        inv.setItemInMainHand(mainItem);
        inv.setItemInMainHandDropChance(0f);

    }

    public void tryDropLoot(Location location) {
        for (LootItem item : lootTable) {
            item.tryDropItem(location);
        }
    }

    public String getName() {
        return name;
    }

    public double getSpawnChance() {
        return spawnChance;
    }

    public EntityTypes getType() {
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




}
