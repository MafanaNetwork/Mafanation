package me.TahaCheji.Mafana.dungeons.AquaDungeon;
import net.minecraft.server.v1_16_R2.EntityDrowned;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class TriplitDrowned  {


    /*
    public TriplitDrowned (Location loc) {
        super(EntityTypes.DROWNED, ((CraftWorld) loc.getWorld()).getHandle());

        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(50);
        this.setHealth(50);
        this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.GOLDEN_HORSE_ARMOR)));
        this.setSlot(EnumItemSlot.CHEST, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.DIAMOND_CHESTPLATE)));
        this.setCustomNameVisible(true);
        this.setCustomName(new ChatComponentText(
                ChatColor.translateAlternateColorCodes
                        ('&', "&c&TriplitDrowned ")));

    }

    public static class TriplitDrownedMain implements Listener {

        public static void TriplitDrowned(Player player) {

            spawnPoint1(player);
            spawnPoint2(player);
            spawnPoint3(player);
            spawnPoint4(player);
            spawnPoint5(player);
        }

        public static void spawnPoint1(Player player) {
            Location SpawnPoint1 = new Location(Bukkit.getWorld("world"),188, 15, 134);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint1, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (org.bukkit.entity.Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof TriplitDrowned) {
                    return;
                }
            }
            TriplitDrowned founderDrowned1 = new TriplitDrowned(SpawnPoint1);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint2(Player player) {
            Location SpawnPoint2 = new Location(Bukkit.getWorld("world"),203, 18, 129);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint2, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (org.bukkit.entity.Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof TriplitDrowned) {
                    return;
                }
            }
            TriplitDrowned founderDrowned1 = new TriplitDrowned(SpawnPoint2);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint3(Player player) {
            Location SpawnPoint3 = new Location(Bukkit.getWorld("world"),193, 22, 109);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint3, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (org.bukkit.entity.Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof TriplitDrowned) {
                    return;
                }
            }
            TriplitDrowned founderDrowned1 = new TriplitDrowned(SpawnPoint3);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint4(Player player) {
            Location SpawnPoint4 = new Location(Bukkit.getWorld("world"),208, 20, 102);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint4, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (org.bukkit.entity.Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof TriplitDrowned) {
                    return;
                }
            }
            TriplitDrowned founderDrowned1 = new TriplitDrowned(SpawnPoint4);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        public static void spawnPoint5(Player player) {
            Location SpawnPoint5 = new Location(Bukkit.getWorld("world"),202, 31, 94);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint5, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof TriplitDrowned) {
                    return;
                }
            }
            TriplitDrowned founderDrowned1 = new TriplitDrowned(SpawnPoint5);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned1, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }


    }

     */


}
