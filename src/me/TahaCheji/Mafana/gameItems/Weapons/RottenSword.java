package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.itemData.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RottenSword {

    public static ItemStack RottenStick(Player player) {
        ItemStack rottenStick = ItemUtl.createItem(Material.WOODEN_SWORD, 1, ItemType.SWORD, player, false, true,
                RarityType.IRON, "RottenStick", 15, 5, 0, 5, "15% more damage to zombies.", ClickType.HIT, true, false, 5000, null,"Ew what a ugly stick");
    UndeadAttributeUtl undeadAttributeUtl = new UndeadAttributeUtl();
        rottenStick = undeadAttributeUtl.setUndeadAttribute(rottenStick, 15.0);
        return rottenStick;
    }
}
