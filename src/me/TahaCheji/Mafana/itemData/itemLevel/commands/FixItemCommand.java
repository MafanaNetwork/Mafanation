package me.TahaCheji.Mafana.itemData.itemLevel.commands;

import me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager;
import me.TahaCheji.Mafana.utils.MessageUtil;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;



public class FixItemCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission(ConfigManager.getString("permission.fix"))) {
                ItemStack is = player.getInventory().getItemInMainHand();
                Damageable im = (Damageable) is.getItemMeta();
                Material material = is.getType();
                if (material.isBlock() || material.getMaxDurability() < 1) {
                    player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.fix-not-able")));
                    return false;
                }
                if (!im.hasDamage()) {
                    player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.fix-already-fixed")));
                    return false;
                }
                im.setDamage(0);
                is.setItemMeta((ItemMeta) im);
                player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.fix-fixed")));
            } else {
                player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.no-permission")));
            }
        } else {
            sender.sendMessage(MessageUtil.translate(ConfigManager.getString("language.console-cannot-execute-command")));
        }
        return false;
    }

}
