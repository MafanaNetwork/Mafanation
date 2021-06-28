package me.TahaCheji.Mafana.gameItems.items;

import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CompressedSilk {

    public static ItemStack getCompressedSilk() {
        ItemStack itemStack = ItemUtl.createMaterial(Material.WHITE_WOOL, 1, 1000,
                ItemType.MATERIAL, true, true, RarityType.LAPIS, "CompressedSilk", "CompressedSilk", true, "Why is it sticky...");
        return itemStack;
    }


}

