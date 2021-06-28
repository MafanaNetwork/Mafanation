package me.TahaCheji.Mafana.itemLevel.managers;

import me.TahaCheji.Mafana.utils.MessageUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BonusManager {

    public static void reduceDamageTaken(EntityDamageByEntityEvent event) {
        Player player = (Player) event.getEntity();
        double resistDamage = 0;
        if(player.getInventory().getHelmet() != null) {
            resistDamage = LoreManager.getToolLevel(player.getInventory().getHelmet());
        }
        if(player.getInventory().getChestplate() != null) {
            resistDamage = resistDamage + LoreManager.getToolLevel(player.getInventory().getChestplate());
        }
        if(player.getInventory().getLeggings() != null) {
            resistDamage = resistDamage + LoreManager.getToolLevel(player.getInventory().getLeggings());
        }
        if(player.getInventory().getBoots() != null) {
            resistDamage = resistDamage + LoreManager.getToolLevel(player.getInventory().getBoots());
        }
        resistDamage = resistDamage / 20;
        event.setDamage(event.getDamage() - resistDamage);
        if(ConfigManager.getBoolean("actionbar.enable")) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageUtil.translate(ConfigManager.getString("actionbar.damage-decreased")).replace("%amount", "" + resistDamage)));
        }
    }

    public static void increaseDamageDealt(EntityDamageByEntityEvent event) {
        Player player = null;
        if(event.getDamager() instanceof Player) {
            player = (Player) event.getDamager();
        } else if(event.getDamager() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getDamager();
            if(arrow.getShooter() instanceof Player) {
                player = (Player) arrow.getShooter();
            }
        }
        ItemStack is = player.getInventory().getItemInMainHand();
        double additionalDamage = 0;
        additionalDamage = LoreManager.getToolLevel(is) / 10;
        event.setDamage(event.getDamage() + additionalDamage);
        if(ConfigManager.getBoolean("actionbar.enable")) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageUtil.translate(ConfigManager.getString("actionbar.damage-increased")).replace("%amount", "" + additionalDamage)));
        }
    }

    public static void increaseBlockBreakSpeed(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack is = player.getInventory().getItemInMainHand();
        int additionalSpeed = 0;
        additionalSpeed = (int) Math.round(LoreManager.getToolLevel(is));
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20, additionalSpeed));
        if(ConfigManager.getBoolean("actionbar.enable")) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageUtil.translate(ConfigManager.getString("actionbar.more-mining-speed")).replace("%amount", "" + additionalSpeed)));
        }
    }

}
