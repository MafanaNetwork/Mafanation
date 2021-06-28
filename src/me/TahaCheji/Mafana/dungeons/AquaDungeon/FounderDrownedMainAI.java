package me.TahaCheji.Mafana.dungeons.AquaDungeon;


import me.TahaCheji.Mafana.game.Title;
import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FounderDrownedMainAI  implements Listener {

  public static int stage1 = 0;
    public static int stage2 = 0;
/*
    @EventHandler
    public void FoundersEvent(EntityDamageByEntityEvent e) {
        LivingEntity entity = (LivingEntity) e.getEntity();
        if(!(entity instanceof Drowned)) {
            return;
        }
        Player player = (Player) e.getDamager();
        World world = player.getWorld();
        if (e.getDamager() instanceof Player) {
            if (((CraftEntity) entity).getHandle() instanceof FounderDrowned) {
                //stage1
                if (entity.getHealth() <= 800) {
                    if (stage1 == 0) {
                        entity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5, 2));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 50, 1));
                        TriplitDrowned founderDrowned = new TriplitDrowned(player.getLocation().add(1, 0, 0));
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned, CreatureSpawnEvent.SpawnReason.CUSTOM);
                        TriplitDrowned founderDrowned2 = new TriplitDrowned(player.getLocation().add(0, 0, 1));
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned2, CreatureSpawnEvent.SpawnReason.CUSTOM);
                        TriplitDrowned founderDrowned3 = new TriplitDrowned(player.getLocation().add(0, 1, 0));
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned3, CreatureSpawnEvent.SpawnReason.CUSTOM);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 5));
                        Title title1 = new Title("FOUNDER", "STAGE 2!", 15, 100, 15);
                        title1.setTitleColor(ChatColor.DARK_RED);
                        title1.setSubtitleColor(ChatColor.RED);
                        title1.setTimingsToTicks();
                        title1.send(player);
                    }
                        stage1 = 1;
                    }
                }
                if (entity.getHealth() <= 500) {
                    if (stage2 == 0) {
                        Title title1 = new Title("FOUNDER", "STAGE 3!", 15, 100, 15);
                        title1.setTitleColor(ChatColor.DARK_RED);
                        title1.setSubtitleColor(ChatColor.DARK_RED);
                        title1.setTimingsToTicks();
                        title1.send(player);
                        player.sendMessage(ChatColor.DARK_RED + "[Founder]: " + ChatColor.RED + "YOU ARE DEAD!");
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10, 10);
                        TriplitDrowned founderDrowned = new TriplitDrowned(player.getLocation().add(1, 0, 0));
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned, CreatureSpawnEvent.SpawnReason.CUSTOM);
                        TriplitDrowned founderDrowned2 = new TriplitDrowned(player.getLocation().add(0, 0, 1));
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned2, CreatureSpawnEvent.SpawnReason.CUSTOM);
                        TriplitDrowned founderDrowned3 = new TriplitDrowned(player.getLocation().add(0, 1, 0));
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned3, CreatureSpawnEvent.SpawnReason.CUSTOM);
                        entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, 5));
                        entity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 9999999, 1));
                        stage2 = 1;
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(me.TahaCheji.Mafana.Main.getInstance(), new Runnable()
                        {
                            @Override
                            public void run() {
                               entity.teleport(player.getLocation());
                            }
                        }, 100L);
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(me.TahaCheji.Mafana.Main.getInstance(), new Runnable()
                        {
                            @Override
                            public void run() {
                                entity.teleport(player.getLocation());
                            }
                        }, 120L);

                    }
                }
            }
        }


   @EventHandler
   public void playerDeathFounder(PlayerDeathEvent e) {
       LivingEntity entity = e.getEntity();
       Player player = e.getEntity();
       if (((CraftEntity) entity).getHandle() instanceof FounderDrowned) {
           player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 10, 10);
           player.sendMessage(ChatColor.DARK_RED + "[Founder]: " + ChatColor.RED + "You are not good to beat me");
           player.teleport(MainDungeon.EndDungeonLocation);
       }
   }

 */

}
