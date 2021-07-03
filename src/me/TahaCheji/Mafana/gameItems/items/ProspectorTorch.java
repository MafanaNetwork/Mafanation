package me.TahaCheji.Mafana.gameItems.items;

import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ProspectorTorch {

    public static ItemStack getProspectorTorch() {
        ItemStack item = ItemUtl.createMaterial(Material.TORCH, 1, 15, ItemType.MATERIAL, true, true, RarityType.COAL, "ProspectorTorch", "ProspectorTorch", true,
                "Its hot don't touch it.");
        return item;
    }

}
