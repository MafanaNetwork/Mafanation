package me.TahaCheji.Mafana.gameItems.items;

import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BoneShard {


    public static ItemStack BoneShard() {
       ItemStack item =  ItemUtl.createMaterial(Material.IRON_NUGGET, 1, 25000, ItemType.MATERIAL, true, false, RarityType.IRON, "BoneShard", "BoneShard", true, "Used to craft a very pointy bone");
        return item;
    }

}
