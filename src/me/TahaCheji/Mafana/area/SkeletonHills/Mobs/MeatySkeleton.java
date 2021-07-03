package me.TahaCheji.Mafana.area.SkeletonHills.Mobs;

import io.lumine.xikage.mythicmobs.drops.Drop;
import me.TahaCheji.Mafana.gameItems.Weapons.PointyBone;
import me.TahaCheji.Mafana.gameItems.items.BoneShard;
import me.TahaCheji.Mafana.gameItems.items.MagicCookie;
import me.TahaCheji.Mafana.gameItems.items.MidasStand;
import me.TahaCheji.Mafana.mobData.*;
import net.minecraft.server.v1_16_R2.EntityTypes;
import net.minecraft.server.v1_16_R2.PathfinderGoal;
import net.minecraft.server.v1_16_R2.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R2.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MeatySkeleton implements Listener {

    public CreateMagicMob mob(Player player, Location location) {
        LootItem lootItem = new LootItem(BoneShard.BoneShard(), 1, 1, 100);
        WorldServer server = ((CraftWorld) player.getWorld()).getHandle();
        return new CreateMagicMob(EntityTypes.ZOMBIE, server, location, "wip",100, 100, 1, 1, 1, 0, null, null, lootItem);
    }


    public void MeatySkeleton(Player player) {
        Location rad1 = new Location(Bukkit.getWorld("world"), -6, 69, 137);
        Location rad2 = new Location(Bukkit.getWorld("world"), 39, 69, 167);
        SpawnMob spawnMob = new SpawnMob();
        spawnMob.spawnMagicMobs(5, 30, rad1, rad2, mob(player, rad1));
    }

}
