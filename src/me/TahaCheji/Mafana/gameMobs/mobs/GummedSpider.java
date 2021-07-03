package me.TahaCheji.Mafana.gameMobs.mobs;

import me.TahaCheji.Mafana.gameItems.Weapons.PointyBone;
import me.TahaCheji.Mafana.gameItems.items.MagicCookie;
import me.TahaCheji.Mafana.mobData.CreateMob;
import me.TahaCheji.Mafana.mobData.LootItem;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class GummedSpider {

    public static CreateMob getGummedSpider(Player player) {
        LootItem lootItem = new LootItem(new ItemStack(Material.AIR), 1, 1, 1);
        return new CreateMob(ChatColor.DARK_AQUA + "GummedSpider", 100, EntityType.SPIDER, 50, 10,
                5, 55, 0, null, null, lootItem);
    }

}
