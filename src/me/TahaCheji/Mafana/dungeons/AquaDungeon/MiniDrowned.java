package me.TahaCheji.Mafana.dungeons.AquaDungeon;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MiniDrowned {
    /*

    public MiniDrowned(Location loc) {
        super(EntityTypes.DROWNED, ((CraftWorld) loc.getWorld()).getHandle());

        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(120);
        this.setHealth(120);
        this.setSlot(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.LEATHER_HELMET)));
        this.setCustomNameVisible(true);
        this.setCustomName(new ChatComponentText(
                ChatColor.translateAlternateColorCodes
                        ('&', "&e&lMiniDrowned ")));

    }


    @Override
    public void initPathfinder() {
        super.initPathfinder();
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, true));
        this.goalSelector.a(1, new PathfinderGoalMeleeAttack(this, 4.0D, false));
    }
    public static class MiniDrownedMain implements Listener {

        public static void MiniDrowned(Player player) {
            spawnPoint1(player);
            spawnPoint2(player);
            spawnPoint3(player);
            spawnPoint4(player);
            spawnPoint5(player);

        }

        public static void spawnPoint1(Player player) {
            Location SpawnPoint1 = new Location(Bukkit.getWorld("world"),171, 18, 83);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint1, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof MiniDrowned) {
                    return;
                }
            }
            MiniDrowned founderDrowned1 = new MiniDrowned(SpawnPoint1);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint2(Player player) {
            Location SpawnPoint2 = new Location(Bukkit.getWorld("world"),173, 18, 93);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint2, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof MiniDrowned) {
                    return;
                }
            }
            MiniDrowned founderDrowned1 = new MiniDrowned(SpawnPoint2);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint3(Player player) {
            Location SpawnPoint3 = new Location(Bukkit.getWorld("world"),182, 17, 87);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint3, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof MiniDrowned) {
                    return;
                }
            }
            MiniDrowned founderDrowned1 = new MiniDrowned(SpawnPoint3);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint4(Player player) {
            Location SpawnPoint4 = new Location(Bukkit.getWorld("world"),174, 16, 98);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint4, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof MiniDrowned) {
                    return;
                }
            }
            MiniDrowned founderDrowned1 = new MiniDrowned(SpawnPoint4);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint5(Player player) {
            Location SpawnPoint5 = new Location(Bukkit.getWorld("world"),186, 16, 99);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint5, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof MiniDrowned) {
                    return;
                }
            }
            MiniDrowned founderDrowned1 = new MiniDrowned(SpawnPoint5);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }



    }

     */





}
