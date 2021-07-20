package me.TahaCheji.Mafana.gui.itemsCommandGui;

import me.TahaCheji.Mafana.dungeons.AquaDungeon.ReservoirCap;
import me.TahaCheji.Mafana.dungeons.AquaDungeon.WaterBreathBow;
import me.TahaCheji.Mafana.gameItems.Armor.RottenCap;
import me.TahaCheji.Mafana.gameItems.Armor.RottenPants;
import me.TahaCheji.Mafana.gameItems.Armor.RottenShirt;
import me.TahaCheji.Mafana.gameItems.Armor.RottenShoes;
import me.TahaCheji.Mafana.gameItems.Spell.MeshOfSilk;
import me.TahaCheji.Mafana.gameItems.Weapons.*;
import me.TahaCheji.Mafana.gameItems.items.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;

public class ItemsGui implements InventoryHolder {

    public Inventory WeaponGUI;

    public ItemsGui(Player player) throws IOException {
        WeaponGUI = Bukkit.createInventory(null, 54, ChatColor.GRAY + "" + ChatColor.BOLD + "Items");
        ArrayList<String> lore = new ArrayList<String>();

        ItemStack closeShop = new ItemStack(Material.BARRIER);
        ItemMeta closeShopeta = closeShop.getItemMeta();
        closeShopeta.setDisplayName(ChatColor.GRAY + "Close Shop");
        closeShopeta.setLore(lore);
        closeShop.setItemMeta(closeShopeta);

        ItemStack newItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta newmeta = newItem.getItemMeta();
        newmeta.setDisplayName(ChatColor.GRAY + " ");
        newmeta.setLore(lore);
        newItem.setItemMeta(newmeta);
        for (int emptySlot = 0; emptySlot < WeaponGUI.getSize(); emptySlot++) {
            if (WeaponGUI.getItem(emptySlot) == null || WeaponGUI.getItem(emptySlot).getType().equals(Material.AIR)) {
                WeaponGUI.setItem(emptySlot, newItem);
            }
        }

        WeaponGUI.setItem(49,closeShop);


        WeaponGUI.setItem(10, WarriorsBlade.WarriorsBlade(player));
        WeaponGUI.setItem(11, RottenCap.RottenCap(player));
        WeaponGUI.setItem(12, RottenShirt.RottenShirt(player));
        WeaponGUI.setItem(13, RottenPants.RottenPants(player));
        WeaponGUI.setItem(14, RottenShoes.RottenShoes(player));
        WeaponGUI.setItem(15, RottenSword.RottenStick(player));
        WeaponGUI.setItem(16, WaterBreathBow.WaterBreathBow(player));
        WeaponGUI.setItem(19, ReservoirCap.ReservoirCap(player));
        WeaponGUI.setItem(20, AtomSplit.AtomSplit(player));
        WeaponGUI.setItem(21, new GoldenLife().getMasterGoldenLife(player));
        WeaponGUI.setItem(22, MagicCookie.helmmet(player));
        WeaponGUI.setItem(23, MagicCookie.chestplate(player));
        WeaponGUI.setItem(24, MagicCookie.leggings(player));
        WeaponGUI.setItem(25, MagicCookie.boots(player));
        WeaponGUI.setItem(28, MidasStand.MidasStand());
        WeaponGUI.setItem(29, MagicCookie.AdminRevelation(player));
        WeaponGUI.setItem(30, Dynamite.Dynamite(player));
        WeaponGUI.setItem(31, MagicCookie.LisaBook(player));
        WeaponGUI.setItem(30, BlockOfLife.BlockOfLife());
        WeaponGUI.setItem(32, Jumpers_Glock.Jumpers_Glock(player));
        WeaponGUI.setItem(33, Moon.Moon(player));
        WeaponGUI.setItem(34, RottenSword.RottenStick(player));
        WeaponGUI.setItem(37, BoneShard.BoneShard());
        WeaponGUI.setItem(38, PointyBone.pointyBone(player));
        WeaponGUI.setItem(39, RestoredCristal.getRestoredCristal());
        WeaponGUI.setItem(41, ProspectorTorch.getProspectorTorch());
        WeaponGUI.setItem(42, CollierStick.getCollierStick());
        WeaponGUI.setItem(43, new DeformedBone().getDeformedBone(player));
        WeaponGUI.setItem(45, new MeshOfSilk().getMeshOfSilk(player));
        WeaponGUI.setItem(46, CompressedSilk.getCompressedSilk());
    }

    @Override
    public Inventory getInventory() {
        return WeaponGUI;
    }



}
