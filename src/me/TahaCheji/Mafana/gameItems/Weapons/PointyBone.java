package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.crafting.CraftingUtl;
import me.TahaCheji.Mafana.gameItems.items.BoneShard;
import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PointyBone {


    public static ItemStack pointyBone(Player player) {
    ItemStack item = ItemUtl.createItem(Material.BONE,
                1, ItemType.SWORD, player, true,
                false, RarityType.LAPIS, "PointyBone", 35, 15, 95, 20, null, null, true, true, 50000, null, "dont touch the tip.");

        return item;
    }

    public static void pointyBoneRecipe(Player player, Inventory gui) {
      new  CraftingUtl().createRecipe(null, 1, null, 0,
                null, 0, null, 0, BoneShard.BoneShard(), 1,
                null, 0, null, 0, BoneShard.BoneShard(), 1, null, 0, player, pointyBone(player), gui);
    }



}
