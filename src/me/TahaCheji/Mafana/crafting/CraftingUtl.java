package me.TahaCheji.Mafana.crafting;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.gameItems.Spell.MeshOfSilk;
import me.TahaCheji.Mafana.gameItems.Weapons.GoldenLife;
import me.TahaCheji.Mafana.gameItems.Weapons.Moon;
import me.TahaCheji.Mafana.gameItems.Weapons.PointyBone;
import me.TahaCheji.Mafana.gui.itemsCommandGui.ItemsGui;
import me.TahaCheji.Mafana.npc.town.Shops.Gui;
import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import javax.xml.bind.helpers.AbstractUnmarshallerImpl;
import java.io.IOException;
import java.util.Objects;

public class CraftingUtl implements Listener {


    public static void createRecipe(ItemStack slot1, int amount1, ItemStack slot2, int amount2, ItemStack slot3, int amount3, ItemStack slot4, int amount4, ItemStack slot5, int
            amount5, ItemStack slot6, int amount6, ItemStack slot7, int amount7, ItemStack slot8, int amount8, ItemStack slot9, int amount9, Player player, ItemStack item, Inventory gui) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    if (gui.getItem(1) == null) {
                        if (gui.getItem(2) == null) {
                            if (gui.getItem(3) == null) {
                                if (gui.getItem(10) == null) {
                                    if (gui.getItem(11) == null) {
                                        if (gui.getItem(12) == null) {
                                            if (gui.getItem(13) == null) {
                                                if (gui.getItem(19) == null) {
                                                    if (gui.getItem(20) == null) {
                                                        if (gui.getItem(21) == null) {
                                                            gui.setItem(14, null);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    final ItemStack itemSlot1 = gui.getItem(1);
                    final ItemStack itemSlot2 = gui.getItem(2);
                    final ItemStack itemSlot3 = gui.getItem(3);
                    final ItemStack itemSlot4 = gui.getItem(10);
                    final ItemStack itemSlot5 = gui.getItem(11);
                    final ItemStack itemSlot6 = gui.getItem(12);
                    final ItemStack itemSlot7 = gui.getItem(19);
                    final ItemStack itemSlot8 = gui.getItem(20);
                    final ItemStack itemSlot9 = gui.getItem(21);
                    gui.setItem(14, null);
                    if (slot1 == null || itemSlot1 != null && NBTUtils.getString(itemSlot1, "ItemKey").equals(NBTUtils.getString(slot1, "ItemKey")) && Objects.requireNonNull(itemSlot1).getAmount() == amount1) {
                        gui.setItem(14, null);
                        if (slot2 == null || itemSlot2 != null && NBTUtils.getString(itemSlot2, "ItemKey").equals(NBTUtils.getString(slot2, "ItemKey")) && Objects.requireNonNull(itemSlot2).getAmount() == amount2) {
                            gui.setItem(14, null);
                            if (slot3 == null || itemSlot3 != null && NBTUtils.getString(itemSlot3, "ItemKey").equals(NBTUtils.getString(slot3, "ItemKey")) && Objects.requireNonNull(itemSlot3).getAmount() == amount3) {
                                gui.setItem(14, null);
                                if (slot4 == null || itemSlot4 != null && NBTUtils.getString(itemSlot4, "ItemKey").equals(NBTUtils.getString(slot4, "ItemKey")) && Objects.requireNonNull(itemSlot4).getAmount() == amount4) {
                                    gui.setItem(14, null);
                                    if (slot5 == null || itemSlot5 != null && NBTUtils.getString(itemSlot5, "ItemKey").equals(NBTUtils.getString(slot5, "ItemKey")) && Objects.requireNonNull(itemSlot5).getAmount() == amount5) {
                                        gui.setItem(14, null);
                                        if (slot6 == null || itemSlot6 != null && NBTUtils.getString(itemSlot6, "ItemKey").equals(NBTUtils.getString(slot6, "ItemKey")) && Objects.requireNonNull(itemSlot6).getAmount() == amount6) {
                                            gui.setItem(14, null);
                                            if (slot7 == null || itemSlot7 != null && NBTUtils.getString(itemSlot7, "ItemKey").equals(NBTUtils.getString(slot7, "ItemKey")) && Objects.requireNonNull(itemSlot7).getAmount() == amount7) {
                                                gui.setItem(14, null);
                                                if (slot8 == null || itemSlot8 != null && NBTUtils.getString(itemSlot8, "ItemKey").equals(NBTUtils.getString(slot8, "ItemKey")) && Objects.requireNonNull(itemSlot8).getAmount() == amount8) {
                                                    gui.setItem(14, null);
                                                    if (slot9 == null || itemSlot9 != null && NBTUtils.getString(itemSlot9, "ItemKey").equals(NBTUtils.getString(slot9, "ItemKey")) && Objects.requireNonNull(itemSlot9).getAmount() == amount9) {
                                                        gui.setItem(14, item);

                                                    }

                                                }

                                            }

                                        }

                                    }
                                }
                            }
                        }
                    }

                }
            }, 0L);
        }



    @EventHandler
    public void onClick(InventoryClickEvent e) throws IOException {
        Player player = (Player) e.getWhoClicked();
        if (!(e.getView().getTitle().contains("MafanaCraft"))) {
            return;
        }
        Inventory GUI = e.getInventory();

        if(e.getSlot() == 1 || e.getSlot() == 2 || e.getSlot() == 3 ||
                e.getSlot() == 10 || e.getSlot() == 11 || e.getSlot() == 12 ||
                e.getSlot() == 19 || e.getSlot() == 20 || e.getSlot() == 21 || e.getSlot() == 14 || e.getClickedInventory() == player.getInventory()) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }

        if(e.getSlot() == 14) {
            if(e.getInventory().getItem(14) == null) {
                return;
            }
            ItemStack air = new ItemStack(Material.AIR);
            GUI.setItem(1, air);
            GUI.setItem(2, air);
            GUI.setItem(3, air);

            GUI.setItem(10, air);
            GUI.setItem(11, air);
            GUI.setItem(12, air);

            GUI.setItem(19, air);
            GUI.setItem(20, air);
            GUI.setItem(21, air);
        }
        GoldenLife.GoldenLifeRecipe(player, e.getInventory());
        //this is where to add your recipe!!!
        PointyBone.pointyBoneRecipe(player, e.getInventory());
        new MeshOfSilk().getMeshOfSilkRecipe(player, e.getInventory());
    }


    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        if (!(e.getView().getTitle().contains("MafanaCraft"))) {
            return;
        }
        Inventory GUI = e.getInventory();

        if(!(e.getInventory().getItem(1) == null)) {
            player.getInventory().addItem(e.getInventory().getItem(1));
        }
        if(!(e.getInventory().getItem(2) == null)) {
            player.getInventory().addItem(e.getInventory().getItem(2));
        }
        if(!(e.getInventory().getItem(3) == null)) {
            player.getInventory().addItem(e.getInventory().getItem(3));
        }

        if(!(e.getInventory().getItem(10) == null)) {
            player.getInventory().addItem(e.getInventory().getItem(10));
        }
        if(!(e.getInventory().getItem(11) == null)) {
            player.getInventory().addItem(e.getInventory().getItem(11));
        }
        if(!(e.getInventory().getItem(12) == null)) {
            player.getInventory().addItem(e.getInventory().getItem(12));
        }

        if(!(e.getInventory().getItem(19) == null)) {
            player.getInventory().addItem(e.getInventory().getItem(19));
        }
        if(!(e.getInventory().getItem(20) == null)) {
            player.getInventory().addItem(e.getInventory().getItem(20));
        }
        if(!(e.getInventory().getItem(21) == null)) {
            player.getInventory().addItem(e.getInventory().getItem(21));
        }

    }



}
