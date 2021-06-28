package me.TahaCheji.Mafana.itemData;

import org.bukkit.ChatColor;

public enum EnchancmentsType {

    DAMAGED(ChatColor.GRAY, ChatColor.GRAY + "Damaged"),
    FIERY(ChatColor.GOLD, ChatColor.GOLD + "Fiery"),
    LIQUEFIED(ChatColor.AQUA, ChatColor.AQUA + "Liquefied"),
    NATURAL(ChatColor.GREEN, ChatColor.GREEN + "Natural");


    private final ChatColor color;

    private final String lore;


    EnchancmentsType(ChatColor color, String lore) {
        this.color = color;
        this.lore = lore;
    }


    public ChatColor getColor() {
        return color;
    }

    public String getLore() {
        return lore;
    }






}
