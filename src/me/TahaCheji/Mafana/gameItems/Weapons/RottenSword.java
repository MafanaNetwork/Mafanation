package me.TahaCheji.Mafana.gameItems.Weapons;

import me.TahaCheji.Mafana.itemData.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RottenSword {

    public static ItemStack RottenStick(Player player) {
        ItemStack rottenStick = ItemUtl.createItem(Material.WOODEN_SWORD, 1, ItemType.SWORD, player, false, true,
                RarityType.IRON, "RottenStick", 15, 5, 0, 5, "15% more damage to zombies.", ClickType.HIT, true, false, 5000, null,"Ew what a ugly stick");
    UndeadAttributeUtl undeadAttributeUtl = new UndeadAttributeUtl();
    ItemMeta meta = rottenStick.getItemMeta();
    AttributeModifier health = new AttributeModifier(UUID.randomUUID(), "generic.maxHealth", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
    meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, health);
    rottenStick.setItemMeta(meta);
        rottenStick = UndeadAttributeUtl.setUndeadAttribute(rottenStick, 15.0);
        return rottenStick;
    }
}
