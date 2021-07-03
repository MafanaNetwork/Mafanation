package me.TahaCheji.Mafana.mobData;

import me.TahaCheji.Mafana.utils.NBTUtils;
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

public class CreateMagicMob extends EntityMonster {
    private final String name;
    private final double spawnChance;
    private final int strength;
    private final int defense;
    private final int damage;
    private final int speed;
    private final ItemStack mainItem;
    private final ItemStack[] armor;
    private PathfinderGoal goals;
    private final List<LootItem> lootTable;

    public CreateMagicMob(EntityTypes<? extends EntityMonster> mob, World world, Location loc, String name, double spawnChance, double maxHealth, int strength, int defense, int damage, int speed, ItemStack mainItem, ItemStack[] armor, LootItem... lootTable) {
        super(mob, world);
        this.name = name;
        this.spawnChance = spawnChance;
        this.strength = strength;
        this.defense = defense;
        this.damage = damage;
        this.speed = speed;
        this.mainItem = mainItem;
        this.armor = armor;
        this.lootTable = Arrays.asList(lootTable);

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
        System.out.println("test 1");
        NBTUtils.setEntityString(entity, "MobName", name);
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
