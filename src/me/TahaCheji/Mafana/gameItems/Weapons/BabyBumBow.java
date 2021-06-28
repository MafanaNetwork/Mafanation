package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BabyBumBow {

    public static ItemStack getBabyBumBow(Player player) {
        ItemStack getBabyBumBow = ItemUtl.createItem(Material.BOW, 1, ItemType.BOW, player, true, true, RarityType.COAL, "BabyBumBow",
                40, 25, 15, 10, null, null, true, false, 6000, null, "Its a bow, Its a bum, Its a baby, Its the BabyBumBow.");
        return getBabyBumBow;
    }


}
