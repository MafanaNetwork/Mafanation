package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.crafting.MasterTable;
import me.TahaCheji.Mafana.crafting.RecipeUtl;
import me.TahaCheji.Mafana.gameItems.items.BlockOfLife;
import me.TahaCheji.Mafana.gameItems.items.MidasStand;
import me.TahaCheji.Mafana.itemData.*;
import me.TahaCheji.Mafana.itemData.masterData.AbilityType;
import me.TahaCheji.Mafana.itemData.masterData.ItemValueUtl;
import me.TahaCheji.Mafana.itemData.masterData.MasterAbility;
import me.TahaCheji.Mafana.itemData.masterData.MasterItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static me.TahaCheji.Mafana.itemData.ItemUtl.createItem;

public class GoldenLife {

    public ItemStack getGoldenLife(Player player) {
         ItemStack GoldenLife = createItem(Material.GOLDEN_PICKAXE, 1, ItemType.SWORD, player,
                true, true, RarityType.GOLD, "GoldenLife", 15, 10, 0, 0, null, null,
                false, true, 10,null,  "Legend has it Midas himself was scared of this weapon.");
        GemUtl gemUtl = new GemUtl(ChatColor.GOLD + "GoldenTouch", ChatColor.GOLD + "20% more gold on kill!");
       GoldenLife = gemUtl.createGem(GoldenLife);
        return GoldenLife;
    }

    public ItemStack getMasterGoldenLife (Player player) {
        MasterItems masterItems = new MasterItems(Material.GOLDEN_PICKAXE, "GoldenLife", ItemType.SWORD,
                RarityType.GOLD, player, 35, 25, 0, 0, true, true,
                new MasterAbility("GoldenTouch" , AbilityType.LEFT_CLICK, "Every time you hit a mob it will be turned to gold."), new ItemValueUtl(100, true), getGoldenLifeRecipe(), "GOLD! GOLD! I LOVE GOLD", "Legend has it Midas was even scared of this weapon.");
        return masterItems.createItem();
    }


    public MasterTable getGoldenLifeRecipe() {
       return new MasterTable(BlockOfLife.BlockOfLife(), 1, BlockOfLife.BlockOfLife(), 1, BlockOfLife.BlockOfLife(), 1, null, 0,
                 MidasStand.MidasStand(), 1, null, 0, null, 0, MidasStand.MidasStand(), 1, null, 0);

    }




}
