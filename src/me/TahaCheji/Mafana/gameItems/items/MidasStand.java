package me.TahaCheji.Mafana.gameItems.items;

import me.TahaCheji.Mafana.itemData.ItemType;
import me.TahaCheji.Mafana.itemData.RarityType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.TahaCheji.Mafana.itemData.ItemUtl.createMaterial;

public class MidasStand {

    public static ItemStack MidasStand() {
        final ItemStack MidasStand = createMaterial(Material.STICK, 1, 150000,  ItemType.MATERIAL, false, false, RarityType.GOLD, ChatColor.GOLD + "MidasStand", "MidasStand", true, "Used to craft one of the most golden sword of all.");
        return MidasStand;
    }

}
