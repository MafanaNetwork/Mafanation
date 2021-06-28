package me.TahaCheji.Mafana.mobData;

import com.google.common.base.Preconditions;
import me.TahaCheji.Mafana.Main;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SpawnMob implements Listener {

    private BukkitTask task;
    private Map<Entity, Integer> indicators = new HashMap<>();
    private Map<Entity, CreateMob> entities = new HashMap<>();

    public SpawnMob spawnMobs(int mobCap, int spawnTime, Location radius1, Location radius2, CreateMob... createMob) {
        CreateMob[] mobTypes = createMob.clone();
        task = new BukkitRunnable() {
            Set<Entity> spawned = entities.keySet();
            List<Entity> removal = new ArrayList<>();
            @Override
            public void run() {
                for (Entity entity : spawned) {
                    if (!entity.isValid() || entity.isDead()) removal.add(entity);
                }
                spawned.removeAll(removal);
                // Spawning Algorithm
                int diff = mobCap - entities.size();
                if (diff <= 0) return;
                int spawnAmount = (int) (Math.random() * (diff + 1)), count = 0;
                while (count <= spawnAmount) {
                    count++;
                    Location location = getRandomLocation(radius1, radius2);
                    if (!isSpawnable(location)) continue;
                    double random = Math.random() * 101, previous = 0;
                    CreateMob typeToSpawn = mobTypes[0];
                    for (CreateMob type : mobTypes) {
                        previous += type.getSpawnChance();
                        if (random <= previous) {
                            typeToSpawn = type;
                            break;
                        }
                    }
                    entities.put(typeToSpawn.spawnMob(location), typeToSpawn);
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, spawnTime * 20);
        return null;
    }

    public SpawnMob spawnMob(Location location, CreateMob createMob) {
        Set<Entity> spawned = entities.keySet();
        List<Entity> removal = new ArrayList<>();
        for (Entity entity : spawned) {
            if (!entity.isValid() || entity.isDead()) removal.add(entity);
        }
        spawned.removeAll(removal);
        Entity entity = createMob.spawnMob(location);
        entities.put(entity, createMob);
        return null;
    }

    public SpawnMob spawnNPC(Location location, CreateNPC createNPC, Player player) {
        createNPC.spawnNPC(location, player);
        return null;
    }



    private boolean isSpawnable(Location loc) {
        Block feetBlock = loc.getBlock(), headBlock = loc.clone().add(0, 1, 0).getBlock(), upperBlock = loc.clone().add(0, 2, 0).getBlock();
        return feetBlock.isPassable() && !feetBlock.isLiquid() && headBlock.isPassable() && !headBlock.isLiquid() && upperBlock.isPassable() && !upperBlock.isLiquid();
    }

    private double getRandomOffset() {
        double random = Math.random();
        if (Math.random() > 0.5) random *= -1;
        return random;
    }

    public static Location getRandomLocation(Location loc1, Location loc2) {
        Preconditions.checkArgument(loc1.getWorld() == loc2.getWorld());
        double minX = Math.min(loc1.getX(), loc2.getX());
        double minY = Math.min(loc1.getY(), loc2.getY());
        double minZ = Math.min(loc1.getZ(), loc2.getZ());
        double maxX = Math.max(loc1.getX(), loc2.getX());
        double maxY = Math.max(loc1.getY(), loc2.getY());
        double maxZ = Math.max(loc1.getZ(), loc2.getZ());
        return new Location(loc1.getWorld(), randomDouble(minX, maxX), randomDouble(minY, maxY), randomDouble(minZ, maxZ));
    }

    public static double randomDouble(double min, double max) {
        return min + ThreadLocalRandom.current().nextDouble(Math.abs(max - min + 1));
    }

    private int getRandomWithNeg(int size) {
        int random = (int) (Math.random() * (size + 1));
        if (Math.random() > 0.5) random *= -1;
        return random;
    }






}
