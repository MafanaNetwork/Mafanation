package me.TahaCheji.Mafana.itemData;

import org.bukkit.ChatColor;

public enum ClickType {

    RIGHT_CLICK(ChatColor.GOLD, ChatColor.GOLD + "[Right Click]"),
    LEFT_CLICK(ChatColor.GOLD, ChatColor.GOLD + "[Left Click]"),
    RIGHT_CLICK_BLOCK(ChatColor.GOLD, ChatColor.GOLD + "[Right Click-Block]"),
    LEFT_CLICK_BLOCK(ChatColor.GOLD, ChatColor.GOLD + "[Left Click-Block]"),
    SHIFT_RIGHT_CLICK(ChatColor.GOLD, ChatColor.GOLD + "[Shift-Right Click]"),
    SHIFT_LEFT_CLICK(ChatColor.GOLD, ChatColor.GOLD + "[Shift-Left Click]"),
    SHIFT_RIGHT_CLICK_BLOCK(ChatColor.GOLD, ChatColor.GOLD + "[Shift-Right Click-Block]"),
    SHIFT_LEFT_CLICK_BLOCK(ChatColor.GOLD, ChatColor.GOLD + "[Shift-Left Click-Block]"),
    HIT(ChatColor.GOLD, ChatColor.GOLD + "[On-Hit]"),
    PASSIVE(ChatColor.GRAY, ChatColor.GRAY + "[Passive]");

    private final ChatColor color;

    private final String lore;

    ClickType(ChatColor color, String lore) {
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
