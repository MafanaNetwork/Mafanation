package me.TahaCheji.Mafana.dungeons.AquaDungeon;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SisterDrowned {
    /*

    public SisterDrowned (Location loc) {
        super(EntityTypes.DROWNED, ((CraftWorld) loc.getWorld()).getHandle());

        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(150);
        this.setHealth(150);
        this.setSlot(EnumItemSlot.FEET, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.LEATHER_BOOTS)));
        this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.STONE_PICKAXE)));
        this.setCustomNameVisible(true);
        this.setCustomName(new ChatComponentText(
                ChatColor.translateAlternateColorCodes
                        ('&', "&7&SisterDrowned ")));
    }

    public static class SisterDrownedMain implements Listener {

        public static void SisterDrowned(Player player) {
             spawnPoint1(player);
             spawnPoint2(player);
             spawnPoint3(player);
             spawnPoint4(player);
             spawnPoint5(player);
        }

        public static void spawnPoint1(Player player) {
            Location SpawnPoint1 = new Location(Bukkit.getWorld("world"),182, 8, 117);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint1, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (org.bukkit.entity.Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof SisterDrowned) {
                    return;
                }
            }
            SisterDrowned founderDrowned1 = new SisterDrowned(SpawnPoint1);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint2(Player player) {
            Location SpawnPoint2 = new Location(Bukkit.getWorld("world"), 173, 6, 117);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint2, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (org.bukkit.entity.Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof SisterDrowned) {
                    return;
                }
            }
            SisterDrowned founderDrowned1 = new SisterDrowned(SpawnPoint2);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint3(Player player) {
            Location SpawnPoint3 = new Location(Bukkit.getWorld("world"),173, 3, 125);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint3, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (org.bukkit.entity.Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof SisterDrowned) {
                    return;
                }
            }
            SisterDrowned founderDrowned1 = new SisterDrowned(SpawnPoint3);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint4(Player player) {
            Location SpawnPoint4 = new Location(Bukkit.getWorld("world"),162, 7, 120);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint4, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (org.bukkit.entity.Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof SisterDrowned) {
                    return;
                }
            }
            SisterDrowned founderDrowned1 = new SisterDrowned(SpawnPoint4);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint5(Player player) {
            Location SpawnPoint5 = new Location(Bukkit.getWorld("world"),167, 9, 134);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint5, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof SisterDrowned) {
                    return;
                }
            }
            SisterDrowned founderDrowned1 = new SisterDrowned(SpawnPoint5);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

    }

     */



}
