package me.TahaCheji.Mafana.itemData.itemLevel.commands;

import java.util.ArrayList;
import java.util.List;

import me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager;
import me.TahaCheji.Mafana.itemData.itemLevel.managers.ItemManager;
import me.TahaCheji.Mafana.itemData.itemLevel.managers.LoreManager;
import me.TahaCheji.Mafana.utils.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemInfoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack is = player.getInventory().getItemInMainHand();
            if(is != null) {
                if(ItemManager.isSword(is) || ItemManager.isPickaxe(is) || ItemManager.isAxe(is) || ItemManager.isShovel(is) || ItemManager.isBow(is) || ItemManager.isCrossbow(is) || ItemManager.isHelmet(is) || ItemManager.isChestplate(is) || ItemManager.isLeggings(is) || ItemManager.isBoots(is)) {
                    if(!is.getItemMeta().hasLore()) {
                        ItemMeta im = is.getItemMeta();
                        List<String> lore = new ArrayList<String>();
                        lore.add("");
                        lore.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
                        lore.add("§7Level §f" + (double) 0);
                        if(ConfigManager.getBoolean("use.owner-binding")) {
                            lore.add("§c" + player.getName());
                        }
                        im.setLore(lore);
                        is.setItemMeta(im);
                    }
                    String material = is.getType().toString();
                    double currentXP = LoreManager.getToolXP(is);
                    double maxXP = LoreManager.getMaxToolXP(is);
                    double level = LoreManager.getToolLevel(is);
                    String owner = LoreManager.getOwner(is).getName();
                    if(player.hasPermission(ConfigManager.getString("permission.iteminfo"))) {
                        player.sendMessage("");
                        player.sendMessage("§7Material: §c" + material);
                        player.sendMessage("§7XP: §c" + currentXP + " §f/ §c" + maxXP);
                        player.sendMessage("§7Level: §c" + level);
                        if(ConfigManager.getBoolean("use.owner-binding")) {
                            player.sendMessage("§7Owner: §c" + owner);
                        }
                        player.sendMessage("");
                    } else {
                        player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.no-permission")));
                    }
                } else {
                    player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.iteminfo-no-info-available")));
                }
            } else {
                player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.iteminfo-no-info-available")));
            }
        } else {
            sender.sendMessage(MessageUtil.translate(ConfigManager.getString("language.console-cannot-execute-command")));
        }
        return false;
    }

}
