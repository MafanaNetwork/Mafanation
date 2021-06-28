package me.TahaCheji.Mafana.dungeons.AquaDungeon;

import me.TahaCheji.Mafana.game.Title;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MainDungeon implements Listener {
    /*
    public int roomClear = 13;
    Location BossLocationRoom = new Location(Bukkit.getWorld("world"),237,22,101);

    Location BossView = new Location(Bukkit.getWorld("world"),237,39,117);

    Location DungeonLocation = new Location(Bukkit.getWorld("world"),160,25,83);

    public static  Location EndDungeonLocation = new Location(Bukkit.getWorld("world"),146,63,98);

    @EventHandler
    public void start(PlayerFishEvent e) {
        if (e.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)){
            //PlayerMainDungeon
           playerMainDungeon(e.getPlayer());
            //
            //spawnMobs
            MiniDrowned.MiniDrownedMain.MiniDrowned(e.getPlayer());
            SisterDrowned.SisterDrownedMain.SisterDrowned(e.getPlayer());
            TriplitDrowned.TriplitDrownedMain.TriplitDrowned(e.getPlayer());
            // MythicMobs.Mob.Spawn(SkeletalKnight, 10, 18, 100)
            
            ///
        }
    }
    public void playerMainDungeon(Player player) {
        player.teleport(DungeonLocation);
        Title title1 = new Title("Reservoir","Dungeon",15,100,15);
        title1.setTitleColor(ChatColor.DARK_BLUE);
        title1.setSubtitleColor(ChatColor.DARK_AQUA);
        title1.setTimingsToTicks();
        title1.send(player);
        player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 10 ,10);
   player.getInventory().addItem(ReservoirCap.ReservoirCap(player));

    }
    public void bossMain(Player player) {
        player.teleport(BossView);
        player.getInventory().addItem(WaterBreathBow.WaterBreathBow(player));
        FounderDrowned.FounderDrownedMain.FounderDrowned(player);
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 1));
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(me.TahaCheji.Mafana.Main.getInstance(), new Runnable()
     {
            @Override
            public void run() {
                player.sendMessage(ChatColor.DARK_RED + "[Founder]: " + ChatColor.RED + "Welcome non.");
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10 ,10);
            }
        }, 100L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(me.TahaCheji.Mafana.Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.sendMessage(ChatColor.DARK_RED + "[Founder]: " + ChatColor.RED + "I don't want to break too you but....");
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10 ,10);

            }
        }, 120L);
                Bukkit.getScheduler().scheduleSyncDelayedTask(me.TahaCheji.Mafana.Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                player.sendMessage(ChatColor.DARK_RED + "[Founder]: " + ChatColor.RED + "u gonna die lol");
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10 ,10);
                    }
                }, 140L);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(me.TahaCheji.Mafana.Main.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                player.sendMessage(ChatColor.DARK_RED + "[Founder]: " + ChatColor.RED + "anyways doge this!");
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10 ,10);
                            }
                        }, 160L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(me.TahaCheji.Mafana.Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                //right attack
                player.teleport(BossLocationRoom);
                ArmorStand asRight = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(-5, 0, 0), EntityType.ARMOR_STAND);
                asRight.setArms(true);
                asRight.setGravity(true);
                asRight.setVisible(false);
                Location armorstandLocation = asRight.getLocation();
                Vector playerVec = player.getLocation().toVector();
                Vector armorstandVec = armorstandLocation.toVector();
                Vector facingVector = playerVec.subtract(armorstandVec).normalize();
                armorstandLocation.setDirection(facingVector);
                asRight.teleport(armorstandLocation);
                int animate = Bukkit.getScheduler().scheduleAsyncRepeatingTask(me.TahaCheji.Mafana.Main.getInstance(), new ArmorStandAnimationRight(asRight), 0, 1);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Bukkit.getScheduler().cancelTask(animate);
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 10 ,10);
                        asRight.remove();
                    }
                }.runTaskLater(me.TahaCheji.Mafana.Main.getInstance(), 100);
            }
        }, 180L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(me.TahaCheji.Mafana.Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                //Left attack
                player.teleport(BossLocationRoom);
                ArmorStand asLeft = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(5, 0, 0), EntityType.ARMOR_STAND);
                asLeft.setArms(true);
                asLeft.setGravity(true);
                asLeft.setVisible(false);
                Location armorstandLocation = asLeft.getLocation();
                Vector playerVec = player.getLocation().toVector();
                Vector armorstandVec = armorstandLocation.toVector();
                Vector facingVector = playerVec.add(armorstandVec).normalize();
                armorstandLocation.setDirection(facingVector);
                asLeft.teleport(armorstandLocation);
                int animate = Bukkit.getScheduler().scheduleAsyncRepeatingTask(me.TahaCheji.Mafana.Main.getInstance(), new ArmorStandAnimationLeft(asLeft), 0, 1);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Bukkit.getScheduler().cancelTask(animate);
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 10 ,10);
                        asLeft.remove();

                    }
                }.runTaskLater(me.TahaCheji.Mafana.Main.getInstance(), 100);
                Title title1 = new Title("FOUNDER", "STAGE 1!", 15, 100, 15);
                title1.setTitleColor(ChatColor.DARK_RED);
                title1.setSubtitleColor(ChatColor.DARK_RED);
                title1.setTimingsToTicks();
                title1.send(player);
                player.teleport(BossLocationRoom);
            }
        }, 200L);
    }
    @EventHandler
    public void RoomKillEvent(EntityDeathEvent e) {
        LivingEntity entity = e.getEntity();
        Player player = e.getEntity().getKiller();
        if (entity instanceof Drowned) {
            EntityDrowned kill = (EntityDrowned) ((CraftDrowned) e.getEntity()).getHandle();
            if (kill instanceof MiniDrowned || kill instanceof SisterDrowned || kill instanceof TriplitDrowned) {
                -- roomClear;
                if(roomClear == 0) {
                    bossMain(player);
                    roomClear = 13;
                }
            }
        }
    }
    @EventHandler
    public void EndOfDungeon(EntityDeathEvent e) {
        LivingEntity entity = e.getEntity();
        Player player = e.getEntity().getKiller();
        if (entity instanceof Drowned) {
            EntityDrowned kill = (EntityDrowned) ((CraftDrowned) e.getEntity()).getHandle();
            if (kill instanceof FounderDrowned) {
                player.sendMessage(ChatColor.DARK_RED + "[Founder]: " + ChatColor.RED + "NOOOOOOOOOOO!");

                player.teleport(EndDungeonLocation);

                FounderDrownedMainAI.stage1 = 0;
                FounderDrownedMainAI.stage2 = 0;
            }
        }
    }

     */


}
