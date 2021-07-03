package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.crafting.CraftingUtl;
import me.TahaCheji.Mafana.gameItems.items.BlockOfLife;
import me.TahaCheji.Mafana.gameItems.items.MagicCookie;
import me.TahaCheji.Mafana.gameItems.items.MidasStand;
import me.TahaCheji.Mafana.itemData.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

import static me.TahaCheji.Mafana.itemData.ItemUtl.createItem;

public class GoldenLife {

    public static ItemStack GoldenLife(Player player) {
         ItemStack GoldenLife = createItem(Material.GOLDEN_PICKAXE, 1, ItemType.SWORD, player,
                true, true, RarityType.GOLD, "GoldenLife", 15, 10, 0, 0, null, null,
                false, true, 10,null,"Legend has it Midas himself was scared of this weapon.");
        GemUtl gemUtl = new GemUtl(ChatColor.GOLD + "GoldenTouch", ChatColor.GOLD + "20% more gold on kill!");
       GoldenLife = gemUtl.createGem(GoldenLife);
        return GoldenLife;
    }


    public static void GoldenLifeRecipe(Player player, Inventory gui){
        new CraftingUtl().createRecipe(BlockOfLife.BlockOfLife(), 1, BlockOfLife.BlockOfLife(), 1, BlockOfLife.BlockOfLife(), 1, null, 0, MidasStand.MidasStand(), 1, null, 0, null, 0, MidasStand.MidasStand(), 1, null, 0, player, GoldenLife(player), gui);
    }




}
