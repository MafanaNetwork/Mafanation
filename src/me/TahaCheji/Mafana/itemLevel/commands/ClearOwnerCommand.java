package me.TahaCheji.Mafana.itemLevel.commands;

import java.util.ArrayList;
import java.util.List;

import me.TahaCheji.Mafana.itemLevel.managers.ConfigManager;
import me.TahaCheji.Mafana.itemLevel.managers.LoreManager;
import me.TahaCheji.Mafana.itemLevel.managers.MilestoneManager;
import me.TahaCheji.Mafana.utils.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ClearOwnerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission(ConfigManager.getString("permission.clearowner"))) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                ItemStack is = player.getInventory().getItemInMainHand();
                if(!is.getType().toString().contains("AIR")) {
                    if(!is.getItemMeta().hasLore()) {
                        ItemMeta im = is.getItemMeta();
                        List<String> lore = new ArrayList<String>();
                        lore.add("");
                        lore.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
                        lore.add("§7Level §f" + (double) 0);
                        if(ConfigManager.getBoolean("use.owner-binding")) {
                            lore.add("§c" + player.getName());
                        }
                        lore.add("");
                        lore.add(MilestoneManager.getLoreMilestone(player, is));
                        im.setLore(lore);
                        is.setItemMeta(im);
                    }
                    if(ConfigManager.getBoolean("use.owner-binding") == false) {
                        player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.setowner-disabled")));
                        return false;
                    }
                    if(LoreManager.getOwner(is) != null) {
                        if(LoreManager.getOwner(is).equals(player)) {
                            ItemMeta im = is.getItemMeta();
                            List<String> lore = new ArrayList<String>();
                            lore.add("");
                            lore.add("§7XP §f" + LoreManager.getToolXP(is) + " §7/ §f" + LoreManager.getMaxToolXP(is));
                            lore.add("§7Level §f" + LoreManager.getToolLevel(is));
                            if(ConfigManager.getBoolean("use.owner-binding")) {
                                lore.add("§c");
                            }
                            lore.add("");
                            lore.add(LoreManager.getLoreMilestone(is));
                            im.setLore(lore);
                            is.setItemMeta(im);
                            player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.clearowner-reset")));
                        }
                    } else {
                        player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.setowner-no-owner")));
                    }
                } else {
                    player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.setowner-invalid-item")));
                }
            } else {
                sender.sendMessage(MessageUtil.translate(ConfigManager.getString("language.console-cannot-execute-command")));
            }
        } else {
            sender.sendMessage(MessageUtil.translate(ConfigManager.getString("language.no-permission")));
        }
        return false;
    }

}
