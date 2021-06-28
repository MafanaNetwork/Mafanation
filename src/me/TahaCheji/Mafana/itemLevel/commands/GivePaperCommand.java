package me.TahaCheji.Mafana.itemLevel.commands;

import java.util.ArrayList;
import java.util.List;

import me.TahaCheji.Mafana.itemLevel.managers.ConfigManager;
import me.TahaCheji.Mafana.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class GivePaperCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission(ConfigManager.getString("permission.give-paper"))) {
            try {
                if(args.length == 2) {
                    if(Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0])) && args[1].matches(".*\\d.*")) {
                        givePaper(Bukkit.getPlayer(args[0]), Integer.valueOf(args[1]));
                    } else {
                        sender.sendMessage(MessageUtil.translate(ConfigManager.getString("language.givepaper-usage")));
                    }
                } else {
                    sender.sendMessage(MessageUtil.translate(ConfigManager.getString("language.givepaper-usage")));
                }
            } catch(NumberFormatException e) {
                sender.sendMessage(MessageUtil.translate(ConfigManager.getString("language.givepaper-usage")));
            }
        } else {
            sender.sendMessage(MessageUtil.translate(ConfigManager.getString("language.no-permission")));
        }
        return false;
    }

    private static void givePaper(Player player, int amount) {
        ItemStack is = new ItemStack(Material.PAPER, 1);
        ItemMeta im = is.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§7Level §f" + amount);
        im.setLore(lore);
        im.setDisplayName(MessageUtil.translate(ConfigManager.getString("language.paper-name")));
        is.setItemMeta(im);
        player.getInventory().addItem(is);
        player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.givepaper-success")));
    }

}