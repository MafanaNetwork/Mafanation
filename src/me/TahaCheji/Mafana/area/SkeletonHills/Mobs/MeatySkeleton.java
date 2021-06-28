package me.TahaCheji.Mafana.area.SkeletonHills.Mobs;

import io.lumine.xikage.mythicmobs.drops.Drop;
import me.TahaCheji.Mafana.gameItems.Weapons.PointyBone;
import me.TahaCheji.Mafana.gameItems.items.BoneShard;
import me.TahaCheji.Mafana.gameItems.items.MagicCookie;
import me.TahaCheji.Mafana.gameItems.items.MidasStand;
import me.TahaCheji.Mafana.mobData.CreateMob;
import me.TahaCheji.Mafana.mobData.DropLoot;
import me.TahaCheji.Mafana.mobData.LootItem;
import me.TahaCheji.Mafana.mobData.SpawnMob;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MeatySkeleton implements Listener {

    public CreateMob mob(Player player) {
        LootItem lootItem = new LootItem(BoneShard.BoneShard(), 1, 1, 100);
        return new CreateMob("MeatySkeley", 100, EntityType.ZOMBIE, 150, 15,
                65, 35, 0, PointyBone.pointyBone(player), null,
                lootItem);
    }

    public CreateMob mob2(Player player) {
        LootItem lootItem = new LootItem(MagicCookie.LisaBook(player), 1, 1, 100);
        return new CreateMob("SonicTheCat", 100, EntityType.SKELETON, 150, 15,
                65, 35, 0, PointyBone.pointyBone(player), null, lootItem);
    }


    public void MeatySkeleton(Player player) {
        Location rad1 = new Location(Bukkit.getWorld("world"), -6, 69, 137);
        Location rad2 = new Location(Bukkit.getWorld("world"), 39, 69, 167);
        SpawnMob spawnMob = new SpawnMob();
        spawnMob.spawnMobs(5, 30, rad1, rad2, mob(player));
        spawnMob.spawnMobs(5, 30, rad1, rad2, mob2(player));
    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        new DropLoot().onKill(e, mob2(e.getEntity().getKiller()));
        new DropLoot().onKill(e, mob(e.getEntity().getKiller()));
    }

}
