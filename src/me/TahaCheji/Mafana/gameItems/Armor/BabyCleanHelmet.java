package me.TahaCheji.Mafana.gameItems.Armor;

import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BabyCleanHelmet {

    public static ItemStack getBabyCleanHelmet(Player player) {
        ItemStack itemStack = ItemUtl.createItem(Material.IRON_HELMET, 1, ItemType.HELMET, player, true, true, RarityType.GOLD, "BabyCleanHelmet", 55, 75, 10, 5, null,
                null, true, false, 10000, null, "Its a very clean helmet I cannot lie.");

        return itemStack;
    }

    public static ItemStack[] BabyArmor(Player player) {
        ItemStack[] itemStacks = ItemUtl.createArmorSet(getBabyCleanHelmet(player), null, null, null);

        return itemStacks;

    }



}
