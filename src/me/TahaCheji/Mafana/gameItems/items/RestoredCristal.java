package me.TahaCheji.Mafana.gameItems.items;

import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RestoredCristal {

    public static ItemStack getRestoredCristal() {
        ItemStack item = ItemUtl.createMaterial(Material.ORANGE_DYE, 1, 10, ItemType.MATERIAL, true, true, RarityType.COAL, "RestoredCristal", "RestoredCristal", true,
                "Restored and complete.");
        return item;
    }


}
