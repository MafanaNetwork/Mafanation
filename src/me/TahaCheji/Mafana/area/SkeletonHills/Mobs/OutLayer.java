package me.TahaCheji.Mafana.area.SkeletonHills.Mobs;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.gameItems.Armor.BabyCleanHelmet;
import me.TahaCheji.Mafana.gameItems.Weapons.BabyBumBow;
import me.TahaCheji.Mafana.gameItems.Weapons.DeformedBone;
import me.TahaCheji.Mafana.gameItems.Weapons.Jumpers_Glock;
import me.TahaCheji.Mafana.gameItems.items.BoneShard;
import me.TahaCheji.Mafana.gameItems.items.CompressedSilk;
import me.TahaCheji.Mafana.mobData.CreateMob;
import me.TahaCheji.Mafana.mobData.DropLoot;
import me.TahaCheji.Mafana.mobData.LootItem;
import me.TahaCheji.Mafana.mobData.SpawnMob;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class OutLayer implements Listener {

    public CreateMob BabySkeleton(Player player) {
        LootItem Bow = new LootItem(BabyBumBow.getBabyBumBow(player), 1, 1, 5);
        LootItem helm = new LootItem(BabyCleanHelmet.getBabyCleanHelmet(player), 1);
        CreateMob babySkeleton = new CreateMob(ChatColor.AQUA + "BabySkeleton", 100, EntityType.SKELETON, 45, 10,
                15, 10, 0, BabyBumBow.getBabyBumBow(player), BabyCleanHelmet.BabyArmor(player), Bow,  helm);
        return babySkeleton;
    }

    public CreateMob FermentedSpider(Player player) {
        LootItem silk = new LootItem(CompressedSilk.getCompressedSilk(), 1, 2, 25);
        CreateMob fermentedSpider  = new CreateMob(ChatColor.GOLD + "FermentedSpider", 100, EntityType.SPIDER, 20, 45, 35, 50, 0, null, null, silk);
        return fermentedSpider;
    }

    public CreateMob DeformedSkeleton(Player player) {
        LootItem bone = new LootItem(new DeformedBone().getDeformedBone(player), 1, 5, 50);
        CreateMob deformedSkeleton = new CreateMob(ChatColor.GREEN + "DeformedSkeleton", 100, EntityType.SLIME, 30, 20, 0, 150, 0, null, null, bone);
        return deformedSkeleton;

    }

    public CreateMob Wiskers(Player player) {
        LootItem sword = new LootItem(BoneShard.BoneShard(), 1, 1, 35);
        CreateMob wiskers = new CreateMob(ChatColor.DARK_BLUE + "Wiskers", 100, EntityType.WOLF, 15, 25, 5, 15, 0, null, null, sword);
        return wiskers;
    }

    public CreateMob BonelessSkeleton(Player player) {
        CreateMob skele = new CreateMob(ChatColor.GRAY + "BonelessSkeleton", 100, EntityType.WITHER_SKELETON, 105, 15, 0, 5, 0, null, null, new LootItem(new ItemStack(Material.AIR), 0));
        return skele;
    }

    public CreateMob Frosty(Player player) {
        LootItem lootItem = new LootItem(Jumpers_Glock.Jumpers_Glock(player), 5);
        CreateMob mob = new CreateMob(ChatColor.AQUA + "Frosty", 100, EntityType.SNOWMAN, 100, 5, 0, 2, 0, null, null, lootItem);
        return mob;
    }

    public void spawnMob(Player player) {
        Location radius1 = new Location(Bukkit.getWorld("world"), 527, 63, -364);
        Location radius2 = new Location(Bukkit.getWorld("world"), 1192, 74, -393);
        Main.getInstance().spawnMob.spawnMobs(15, 15, radius1, radius2, BabySkeleton(player));
        Main.getInstance().spawnMob.spawnMobs(35, 15, radius1, radius2, FermentedSpider(player));
        Main.getInstance().spawnMob.spawnMobs(35, 15, radius1, radius2, DeformedSkeleton(player));
        Main.getInstance().spawnMob.spawnMobs(35, 15, radius1, radius2, Wiskers(player));
        Main.getInstance().spawnMob.spawnMobs(35, 15, radius1, radius2, BonelessSkeleton(player));
    }

    /*
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        spawnMob(e.getPlayer());
    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        new DropLoot().onKill(e, BabySkeleton(e.getEntity().getKiller()));
        new DropLoot().onKill(e, FermentedSpider(e.getEntity().getKiller()));
        new DropLoot().onKill(e, DeformedSkeleton(e.getEntity().getKiller()));
        new DropLoot().onKill(e, Wiskers(e.getEntity().getKiller()));
    }

     */



}
