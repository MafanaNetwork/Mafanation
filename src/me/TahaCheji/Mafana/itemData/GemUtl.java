package me.TahaCheji.Mafana.itemData;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GemUtl {


    private final String name;
    private final String Ability;

    public GemUtl(String name, String ability) {
        this.name = name;
        this.Ability = ability;
    }

    public ItemStack createGem(ItemStack itemStack) {
        List<String> list = new ArrayList<>();
        String line1 = ChatColor.GRAY + "" + ChatColor.GOLD + "Gem [" + name + "]";
        String line2 = Ability;
        for(String lore : itemStack.getItemMeta().getLore()) {
            list.add(lore);
        }
        list.set(15, line1);
        list.set(16, line2);

        itemStack.getItemMeta().setLore(list);
        itemStack.setItemMeta(itemStack.getItemMeta());
        return itemStack;
    }

    public String getName() {
        return name;
    }

    public String getAbility() {
        return Ability;
    }
}
