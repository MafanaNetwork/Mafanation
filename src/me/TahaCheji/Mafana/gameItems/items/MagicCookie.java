package me.TahaCheji.Mafana.gameItems.items;

import me.TahaCheji.Mafana.itemData.ClickType;
import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import static me.TahaCheji.Mafana.itemData.ItemUtl.*;

public class MagicCookie implements Listener {

    public static ItemStack helmmet(Player player) {
        final ItemStack helmet = createItem(Material.LEATHER_HELMET, 1, ItemType.HELMET, player, false, true, RarityType.COAL,
                "RubbishHelmet", 10, 10, 5, 5, null, null,false, false,  500,null,"Trully The uglyest helmet I could find.");
        return helmet;

    }

    public static ItemStack chestplate(Player player) {
        final ItemStack helmet = createItem(Material.LEATHER_CHESTPLATE, 1, ItemType.CHESTPLATE, player, false, true, RarityType.COAL,
                "RubbishChestplate", 10, 10, 5, 5, null, null,false, false, 10,null,"Trully The uglyest chestplate I could find.");
        return helmet;

    }

    public static ItemStack leggings(Player player) {
        final ItemStack helmet = createItem(Material.LEATHER_LEGGINGS, 1, ItemType.LEGGGINGS, player, false, true, RarityType.COAL,
                "RubbishLeggings", 10, 10, 5, 5, null, null,false, false, 10,null,"Trully The uglyest leggings I could find.");
        return helmet;

    }

    public static ItemStack boots(Player player) {
        final ItemStack helmet = createItem(Material.LEATHER_BOOTS, 1, ItemType.BOOTS, player, false, true, RarityType.COAL,
                "RubbishBoots", 10, 10, 5, 5, null, null,false, false, 10,null,"Trully The uglyest boots I could find.");
        return helmet;

    }

    public static ItemStack[] RubbishArmor(Player player) {
    final ItemStack[] RubbishArmor = createArmorSet(helmmet(player),chestplate(player), leggings(player), boots(player));
        return RubbishArmor;
}


public static ItemStack AdminRevelation(Player player) {
        final ItemStack AdminRevelation = createItem(Material.DIAMOND_AXE, 1,  ItemType.SWORD, player, true, true, RarityType.ADMIN, ChatColor.RED + "AdminRevelation", 25000, 25000, 25000, 25000, null,
                null, false, false, 1, null,"I used a command to spawn this, please dont tell me mom!");
        return AdminRevelation;
}

public static ItemStack LisaBook(Player player) {
        final ItemStack LisaBook = createSpellBook(Material.BOOK, 1, player, 10, true, true, RarityType.REDSTONE, "Lisa is la thot", 150, true, "Spawn's Children to fight for you!", 150, ClickType.RIGHT_CLICK,
                "come a little closer...");
        return LisaBook;
}




/*
    public static ItemStack MagicCookie() {
        ItemStack MagicCookie = new ItemStack(Material.COOKIE);
        ItemMeta MagicCookieMeta = (ItemMeta) MagicCookie.getItemMeta();
        MagicCookieMeta.setDisplayName(Rarity.gold + "MagicCookie");
        MagicCookieMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        //skeletonMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "RIGHT CLICK ABILITY [EAT]");
        lore.add(Rarity.Hunger + "piss:" + ChatColor.GRAY + " 5");
        lore.add("");
        MagicCookieMeta.setLore(lore);
        MagicCookie.setItemMeta(MagicCookieMeta);
        return MagicCookie.clone();
    }

    @EventHandler
    public void thirstAdd(PlayerItemConsumeEvent e) {
        ItemStack item = e.getItem();
        Player player = e.getPlayer();
        if(item.getItemMeta().getDisplayName().equals(Rarity.gold + "MagicCookie")) {
            Thirst thirst = Main.getInstance().thirstMap.get(player.getUniqueId());
            thirst.setThirst(thirst.getThirst() + 100);
        }

    }

    @EventHandler
    public void MagicCookieEAT(PlayerInteractEvent e) {
        if (e.getAction() != null && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            ItemStack is = e.getItem();
            Player p = e.getPlayer();
            if (is != null && !is.getType().equals(Material.AIR)) {
                if(is.getItemMeta().getDisplayName().equals(Rarity.gold + "MagicCookie")) {
                    //add + 10 to hunger stat
                    p.sendMessage(ChatColor.GOLD + "Yum!" + Rarity.Hunger + " 5" );
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_BURP, 10 ,10);
                }
            }
        }
    }


 */

}
