package me.TahaCheji.Mafana.gameItems.items;

import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BlockOfLife {

    public static ItemStack BlockOfLife() {
        final ItemStack BlockOfLife = ItemUtl.createMaterial(Material.GOLD_BLOCK, 1, 1000, ItemType.MATERIAL, true, true, RarityType.GOLD, "BlockOfLife", "BlcokOfLife",  true, "Used to craft the most golden pickaxe of all time.");
        return BlockOfLife;
    }

}
