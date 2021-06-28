package me.TahaCheji.Mafana.commands;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.area.SkeletonHills.Mobs.MeatySkeleton;
import me.TahaCheji.Mafana.crafting.CraftingGui;
import me.TahaCheji.Mafana.crafting.RecipeGui;
import me.TahaCheji.Mafana.gameItems.Weapons.GoldenLife;
import me.TahaCheji.Mafana.gameItems.items.MagicCookie;
import me.TahaCheji.Mafana.gameItems.items.MidasStand;
import me.TahaCheji.Mafana.gui.itemsCommandGui.ItemsGui;

import me.TahaCheji.Mafana.mobData.*;
import me.TahaCheji.Mafana.game.Title;
import me.TahaCheji.Mafana.shopData.ShopUtl;
import me.TahaCheji.Mafana.shops.BakerShop;
import me.TahaCheji.Mafana.utils.NBTUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class Commands implements CommandExecutor {



    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("nick")) { //checks if your wrote the command nick
            if(!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            String nickName = args[0]; //gets the next word from nick like (/Nick ppopo)
            Player player = (Player) sender;
            return true;
        }
        if (label.equalsIgnoreCase("spawn")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            Player player = (Player) sender;
            //OPEN GUI
            player.teleport(Main.getInstance().getLobbyPoint());
            player.sendMessage(ChatColor.GOLD + "Whooooshhhh");
            player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_CLOSE, 10, 10);
            return true;
        }
        if (label.equalsIgnoreCase("oreshop")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            Player player = (Player) sender;
            //OPEN GUI
            return true;
        }
        if (label.equalsIgnoreCase("farmshop")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            Player player = (Player) sender;
            return true;
        }
        if (label.equalsIgnoreCase("mobTest")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            Player player = (Player) sender;
           MeatySkeleton meatySkeleton = new MeatySkeleton();
           meatySkeleton.MeatySkeleton(player);
            return true;
        }
        if (label.equalsIgnoreCase("InventoryTest")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            Player player = (Player) sender;
            BakerShop shop = new BakerShop();
            player.openInventory(shop.bakersCock(player).getInventory());

            return true;
        }
        if (label.equalsIgnoreCase("Vote")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            Player player = (Player) sender;
            CraftingGui gui = new CraftingGui(player);
            player.openInventory(gui.getInventory());
        }
        if (label.equalsIgnoreCase("ItemsGui")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            Player player = (Player) sender;
            ItemsGui gui = null;
            try {
                gui = new ItemsGui(player);
            } catch (IOException e) {
                e.printStackTrace();
            }
            player.openInventory(gui.getInventory());
            return true;
        }
        if (label.equalsIgnoreCase("Sell")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            Player player = (Player) sender;
           if(args.length == 0) {
               if(player.getItemInHand() == null || player.getItemInHand().getType() == Material.AIR) {
                   player.sendMessage(ChatColor.GRAY + "You need to hold something to sell it!");
                   player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
                   return true;
               }
               if(NBTUtils.getBoolean(player.getItemInHand(), "Sellable") == false) {
                   player.sendMessage(ChatColor.GRAY + "You are not able to sell this item!");
                   player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
                   return true;
               }
               TextComponent message = new TextComponent("Would you like to sell this " +
                       "item for: " + net.md_5.bungee.api.ChatColor.WHITE + "$" + NBTUtils.getInt(player.getItemInHand(), "value"));
               message.setColor(net.md_5.bungee.api.ChatColor.GOLD);
               message.setBold(false);
               message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new
                       ComponentBuilder("Click Accept or Decline").color(net.md_5.bungee.api.ChatColor.WHITE).italic(true).create()));
               player.spigot().sendMessage(message);
               TextComponent accept = new TextComponent("[Accept]");
               accept.setColor(net.md_5.bungee.api.ChatColor.GREEN);
               accept.setBold(true);
               accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new
                       ComponentBuilder("Click to Accept").color(net.md_5.bungee.api.ChatColor.GREEN).italic(true).create()));
               accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/Sell Accept"));
               TextComponent decline = new TextComponent("[Decline]");
               decline.setColor(net.md_5.bungee.api.ChatColor.RED);
               decline.setBold(true);
               decline.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new
                       ComponentBuilder("Click to Decline").color(net.md_5.bungee.api.ChatColor.RED).italic(true).create()));
               decline.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/Sell Decline"));
               player.spigot().sendMessage(accept);
               player.sendMessage(ChatColor.GOLD + "Or");
               player.spigot().sendMessage(decline);
               return true;
           }
           if(args[0].equalsIgnoreCase("Accept")) {
               if(player.getItemInHand() == null || player.getItemInHand().getType() == Material.AIR) {
                   player.sendMessage(ChatColor.GRAY + "You need to hold something to sell it!");
                   player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
                   return true;
               }
               if(NBTUtils.getBoolean(player.getItemInHand(), "Sellable") == false) {
                   player.sendMessage(ChatColor.GRAY + "You are not able to sell this item!");
                   player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
                   return true;
               }
               Economy economy = Main.getEcon();
               economy.depositPlayer(player, NBTUtils.getInt(player.getItemInHand(), "value"));
               player.sendMessage(ChatColor.GREEN + "Accepted! " + ChatColor.GOLD + "You Sold Your Item For: " + ChatColor.WHITE + "$" + NBTUtils.getInt(player.getItemInHand(), "value"));
               ItemStack air = new ItemStack(Material.AIR);
               player.setItemInHand(air);
               player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 10);
               return true;
           }
            if(args[0].equalsIgnoreCase("Decline")) {
                player.sendMessage(ChatColor.RED + "Declined!" );
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 10);
                        return true;
            }
        }
        if (label.equalsIgnoreCase("Reboot")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            Player player = (Player) sender;
            if(player.getGameMode() == GameMode.ADVENTURE) {
                player.sendMessage("You do not have perms");
                return true;
            }

            Title title1 = new Title("UPDATE","Please Log Off",15,100,15);
            title1.setTitleColor(ChatColor.DARK_PURPLE);
            title1.setSubtitleColor(ChatColor.AQUA);
            title1.setTimingsToTicks();
            for (Player player1 : Bukkit.getOnlinePlayers()) {
                title1.send(player1);
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    player.performCommand("stop");
                }
            }, 1200L);


            return true;
        }

        return false;
    }
}
