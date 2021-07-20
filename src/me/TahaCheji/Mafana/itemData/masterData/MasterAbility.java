package me.TahaCheji.Mafana.itemData.masterData;

import me.TahaCheji.Mafana.utils.ItemStackUtil;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class MasterAbility {
    private final String name;
    private final String description;
    private final AbilityType type;
    private int cooldown = 0;

    public MasterAbility(String name, AbilityType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public MasterAbility(String name, AbilityType type, String description, int cooldown) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.cooldown = cooldown;
    }

    public List<String> toLore() {
        List<String> lore = new ArrayList();
        lore.add(ChatColor.GOLD + "Item Ability: " + this.name + " " + ChatColor.GOLD + ChatColor.DARK_GREEN + "[" +  this.type.getText() + "]");
        lore.addAll(ItemStackUtil.stringToLore(this.description, 40, ChatColor.GRAY));
        if (this.cooldown > 0) {
            lore.add(ChatColor.GRAY + "Ability Cooldown: " + ChatColor.GREEN + this.cooldown + "s");
        }

        return lore;
    }
}
