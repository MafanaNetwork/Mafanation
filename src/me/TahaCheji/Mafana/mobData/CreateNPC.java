package me.TahaCheji.Mafana.mobData;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.stats.PlayerStats;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.api.trait.trait.Equipment;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mcmonkey.sentinel.SentinelTrait;

import java.util.Arrays;
import java.util.List;

public class CreateNPC {

    private final String name;
    private final double maxHealth;
    private final int strength;
    private final int defense;
    private final int damage;
    private final int speed;
    private final int attackSpeed;
    private final ItemStack mainItem;
    private final ItemStack offItem;
    private final ItemStack helmet;
    private final ItemStack chestplate;
    private final ItemStack leggings;
    private final ItemStack boots;
    private final int despawnTime;
    private final String skinName;
    private final String signature;
    private final String data;


    public CreateNPC(String name, double maxHealth, int strength, int defense, int damage, int speed, int attackSpeed,
                     ItemStack mainItem, ItemStack offItem, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots, int despawnTime, createSkin skin) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.defense = defense;
        this.damage = damage;
        this.speed = speed;
        this.attackSpeed = attackSpeed;
        this.mainItem = mainItem;
        this.offItem = offItem;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
        this.despawnTime = despawnTime;
        this.skinName = skin.getName();
        this.signature = skin.getSignature();
        this.data = skin.getData();
    }

    public NPC spawnNPC(Location location, Player player) {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC NPC = registry.createNPC(EntityType.PLAYER, name);
        SentinelTrait sentinel = NPC.getOrAddTrait(SentinelTrait.class);
       createSkin skin = new createSkin(name, signature, data);
        skin.setSkin(NPC);
        sentinel.addTarget("player");
        sentinel.setHealth(maxHealth);
        sentinel.armor = defense;
        sentinel.speed = speed;
        sentinel.chasing = player;
        sentinel.attackRate = attackSpeed;
        sentinel.accuracy = 100;
        sentinel.allowKnockback = true;
        sentinel.chaseRange = 15;
        sentinel.reach = 2;
        sentinel.realistic = true;
        sentinel.damage = strength * damage / 5;
        NPC.setName(name + " " + ChatColor.RED + "♥" + maxHealth + "♥");
        NPC.setProtected(false);
        NPC.getTrait(Equipment.class).set(Equipment.EquipmentSlot.HAND,  mainItem);
        NPC.getTrait(Equipment.class).set(Equipment.EquipmentSlot.OFF_HAND, offItem);
        NPC.getTrait(Equipment.class).set(Equipment.EquipmentSlot.HELMET, helmet);
        NPC.getTrait(Equipment.class).set(Equipment.EquipmentSlot.CHESTPLATE, chestplate);
        NPC.getTrait(Equipment.class).set(Equipment.EquipmentSlot.LEGGINGS, leggings);
        NPC.getTrait(Equipment.class).set(Equipment.EquipmentSlot.BOOTS, boots);
        NPC.spawn(location);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                NPC.despawn();
            }
        }, despawnTime * 20);
        return NPC;
    }


}
