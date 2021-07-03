package me.TahaCheji.Mafana.gameItems.items;

import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CollierStick {

    public static ItemStack getCollierStick() {
        ItemStack item = ItemUtl.createMaterial(Material.STICK, 1, 50, ItemType.MATERIAL, true, true, RarityType.COAL, "CollierStick", "CollierStick", true,
                "I wonder where he got it?");
        return item;
    }

}
