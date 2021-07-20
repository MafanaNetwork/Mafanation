package me.TahaCheji.Mafana.crafting;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.utils.NBTUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class MasterTable {

    private final ItemStack checkSlot1;
    private final ItemStack checkSlot2;
    private final ItemStack checkSlot3;

    private final ItemStack checkSlot4;
    private final ItemStack checkSlot5;
    private final ItemStack checkSlot6;

    private final ItemStack checkSlot7;
    private final ItemStack checkSlot8;
    private final ItemStack checkSlot9;

    public ArrayList<ItemStack> recipe = new ArrayList<>();


    private  ItemStack finalItem;

    public MasterTable (ItemStack slot1, int amount1, ItemStack slot2, int amount2, ItemStack slot3, int amount3, ItemStack slot4, int amount4, ItemStack slot5, int
           amount5, ItemStack slot6, int amount6, ItemStack slot7, int amount7, ItemStack slot8, int amount8, ItemStack slot9, int amount9) {
       if(slot1 != null) {
           this.checkSlot1 = slot1;
           this.checkSlot1.setAmount(amount1);
       } else {
           this.checkSlot1 = new ItemStack(Material.AIR);
       }
       if(slot2 != null) {
           this.checkSlot2 = slot2;
           this.checkSlot2.setAmount(amount2);
       }else {
           this.checkSlot2 = new ItemStack(Material.AIR);
       }
       if(slot3 != null) {
           this.checkSlot3 = slot3;
           this.checkSlot3.setAmount(amount3);
       }else {
           this.checkSlot3 = new ItemStack(Material.AIR);
       }

       if(slot4 != null) {
           this.checkSlot4 = slot4;
           this.checkSlot4.setAmount(amount4);
       }else {
           this.checkSlot4 = new ItemStack(Material.AIR);
       }
       if(slot5 != null) {
           this.checkSlot5 = slot5;
           this.checkSlot5.setAmount(amount5);
       }else {
           this.checkSlot5 = new ItemStack(Material.AIR);
       }
       if(slot6 != null) {
           this.checkSlot6 = slot6;
           this.checkSlot6.setAmount(amount6);
       }else {
           this.checkSlot6 = new ItemStack(Material.AIR);
       }

       if(slot7 != null) {
           this.checkSlot7 = slot7;
           this.checkSlot7.setAmount(amount7);
       }else {
           this.checkSlot7 = new ItemStack(Material.AIR);

       }
       if(slot8 != null) {
           this.checkSlot8 = slot8;
           this.checkSlot8.setAmount(amount8);
       }else {
           this.checkSlot8 = new ItemStack(Material.AIR);
       }
       if(slot9 != null) {
           this.checkSlot9 = slot9;
           this.checkSlot9.setAmount(amount9);
       }else {
           this.checkSlot9 = new ItemStack(Material.AIR);
       }



       this.recipe.add(checkSlot1);
       this.recipe.add(checkSlot2);
       this.recipe.add(checkSlot3);
       this.recipe.add(checkSlot4);
       this.recipe.add(checkSlot5);
       this.recipe.add(checkSlot6);
       this.recipe.add(checkSlot7);
       this.recipe.add(checkSlot8);
       this.recipe.add(checkSlot9);

       Main.recipes.add(this);
   }

    public void createRecipe(Inventory gui) {
        System.out.println("Test10");
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            if (gui.getItem(1) == null) {
                if (gui.getItem(2) == null) {
                    if (gui.getItem(3) == null) {
                        if (gui.getItem(10) == null) {
                            if (gui.getItem(11) == null) {
                                if (gui.getItem(12) == null) {
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
            System.out.println("Test12");
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
            if (checkSlot1 == null || checkSlot1.getType() == Material.AIR || itemSlot1 != null && NBTUtils.getString(itemSlot1, "ItemKey").equals(NBTUtils.getString(checkSlot1, "ItemKey")) && Objects.requireNonNull(itemSlot1).getAmount() >= checkSlot1.getAmount()) {
                gui.setItem(14, null);
                if (checkSlot2 == null || checkSlot2.getType() == Material.AIR  || itemSlot2 != null && NBTUtils.getString(itemSlot2, "ItemKey").equals(NBTUtils.getString(checkSlot2, "ItemKey")) && Objects.requireNonNull(itemSlot2).getAmount() >= checkSlot2.getAmount()) {
                    gui.setItem(14, null);
                    if (checkSlot3 == null || checkSlot3.getType() == Material.AIR  || itemSlot3 != null && NBTUtils.getString(itemSlot3, "ItemKey").equals(NBTUtils.getString(checkSlot3, "ItemKey")) && Objects.requireNonNull(itemSlot3).getAmount() >= checkSlot3.getAmount()) {
                        gui.setItem(14, null);
                        if (checkSlot4 == null || checkSlot4.getType() == Material.AIR  || itemSlot4 != null && NBTUtils.getString(itemSlot4, "ItemKey").equals(NBTUtils.getString(checkSlot4, "ItemKey")) && Objects.requireNonNull(itemSlot4).getAmount() >= checkSlot4.getAmount()) {
                            gui.setItem(14, null);
                            if (checkSlot5 == null || checkSlot5.getType() == Material.AIR  || itemSlot5 != null && NBTUtils.getString(itemSlot5, "ItemKey").equals(NBTUtils.getString(checkSlot5, "ItemKey")) && Objects.requireNonNull(itemSlot5).getAmount() >= checkSlot5.getAmount()) {
                                gui.setItem(14, null);
                                if (checkSlot6 == null || checkSlot6.getType() == Material.AIR  || itemSlot6 != null && NBTUtils.getString(itemSlot6, "ItemKey").equals(NBTUtils.getString(checkSlot6, "ItemKey")) && Objects.requireNonNull(itemSlot6).getAmount() >= checkSlot6.getAmount()) {
                                    gui.setItem(14, null);
                                    if (checkSlot7 == null || checkSlot7.getType() == Material.AIR  || itemSlot7 != null && NBTUtils.getString(itemSlot7, "ItemKey").equals(NBTUtils.getString(checkSlot7, "ItemKey")) && Objects.requireNonNull(itemSlot7).getAmount() >= checkSlot7.getAmount()) {
                                        gui.setItem(14, null);
                                        if (checkSlot8 == null || checkSlot8.getType() == Material.AIR  || itemSlot8 != null && NBTUtils.getString(itemSlot8, "ItemKey").equals(NBTUtils.getString(checkSlot8, "ItemKey")) && Objects.requireNonNull(itemSlot8).getAmount() >= checkSlot8.getAmount()) {
                                            gui.setItem(14, null);
                                            if (checkSlot9 == null || checkSlot9.getType() == Material.AIR  || itemSlot9 != null && NBTUtils.getString(itemSlot9, "ItemKey").equals(NBTUtils.getString(checkSlot9, "ItemKey")) && Objects.requireNonNull(itemSlot9).getAmount() >= checkSlot9.getAmount()) {

                                                gui.setItem(14, finalItem);
                                            }

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }

        }, 5L);
    }


    public void craftedItem(InventoryClickEvent e) {
        Inventory GUI = e.getInventory();
        Player player = (Player) e.getWhoClicked();
        if(e.getSlot() == 14) {
            if(e.getInventory().getItem(14) == null) {
                return;
            }

            ItemStack air = new ItemStack(Material.AIR);

            if(GUI.getItem(1) != null && GUI.getItem(1).getAmount() > checkSlot1.getAmount()) {
                ItemStack itemStack = checkSlot1;
                itemStack.setAmount(GUI.getItem(1).getAmount() - checkSlot1.getAmount());
                GUI.setItem(1, itemStack);
            } else  if(GUI.getItem(1) == null || GUI.getItem(1).getAmount() == checkSlot1.getAmount()) {
                GUI.setItem(1, air);
            }

            if(GUI.getItem(2) != null && GUI.getItem(2).getAmount() > checkSlot2.getAmount()) {
                ItemStack itemStack = checkSlot2;
                itemStack.setAmount(GUI.getItem(2).getAmount() - checkSlot2.getAmount());
                GUI.setItem(2, itemStack);
            } else if(GUI.getItem(2) == null ||GUI.getItem(2).getAmount() == checkSlot2.getAmount()) {
                GUI.setItem(2, air);
            }

            if(GUI.getItem(3) != null && GUI.getItem(3).getAmount() > checkSlot3.getAmount()) {
                ItemStack itemStack = checkSlot3;
                itemStack.setAmount(GUI.getItem(3).getAmount() - checkSlot3.getAmount());
                GUI.setItem(3, itemStack);
            } else if(GUI.getItem(3) == null ||GUI.getItem(3).getAmount() == checkSlot3.getAmount()) {
                GUI.setItem(3, air);
            }


            if(GUI.getItem(10) != null && GUI.getItem(10).getAmount() > checkSlot4.getAmount()) {
                ItemStack itemStack = checkSlot4;
                itemStack.setAmount(GUI.getItem(10).getAmount() - checkSlot4.getAmount());
                GUI.setItem(10, itemStack);
            } else if(GUI.getItem(10) == null || GUI.getItem(10).getAmount() == checkSlot4.getAmount()) {
                GUI.setItem(10, air);
            }



            if(GUI.getItem(11) != null && GUI.getItem(11).getAmount() > checkSlot5.getAmount()) {
                ItemStack itemStack = checkSlot5;
                itemStack.setAmount(GUI.getItem(11).getAmount() - checkSlot5.getAmount());
                GUI.setItem(11, itemStack);
            } else if(GUI.getItem(11) == null ||GUI.getItem(11).getAmount() == checkSlot5.getAmount()) {
                GUI.setItem(11, air);
            }

            if(GUI.getItem(12) != null && GUI.getItem(12).getAmount() > checkSlot6.getAmount()) {
                ItemStack itemStack = checkSlot6;
                itemStack.setAmount(GUI.getItem(12).getAmount() - checkSlot6.getAmount());
                GUI.setItem(12, itemStack);
            } else if(GUI.getItem(12) == null ||GUI.getItem(12).getAmount() == checkSlot6.getAmount()) {
                GUI.setItem(12, air);
            }


            if(GUI.getItem(19) != null && GUI.getItem(19).getAmount() > checkSlot7.getAmount()) {
                ItemStack itemStack = checkSlot7;
                itemStack.setAmount(GUI.getItem(19).getAmount() - checkSlot7.getAmount());
                GUI.setItem(19, itemStack);
            } else if(GUI.getItem(19) == null ||GUI.getItem(19).getAmount() == checkSlot7.getAmount()) {
                GUI.setItem(19, air);
            }

            if(GUI.getItem(20) != null && GUI.getItem(20).getAmount() > checkSlot8.getAmount()) {
                ItemStack itemStack = checkSlot8;
                itemStack.setAmount(GUI.getItem(20).getAmount() - checkSlot8.getAmount());
                GUI.setItem(20, itemStack);
            } else if(GUI.getItem(20) == null ||GUI.getItem(20).getAmount() == checkSlot8.getAmount()) {
                GUI.setItem(20, air);
            }

            if(GUI.getItem(21) != null && GUI.getItem(21).getAmount() > checkSlot9.getAmount()) {
                ItemStack itemStack = checkSlot9;
                itemStack.setAmount(GUI.getItem(21).getAmount() - checkSlot9.getAmount());
                GUI.setItem(21, itemStack);
            } else if(GUI.getItem(21) == null ||GUI.getItem(21).getAmount() == checkSlot9.getAmount()) {
                GUI.setItem(21, air);
            }

            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
        }
    }

    public ArrayList<ItemStack> getRecipe() {
        return recipe;
    }

    public ItemStack getCheckSlot1() {
        return checkSlot1;
    }

    public ItemStack getCheckSlot2() {
        return checkSlot2;
    }

    public ItemStack getCheckSlot3() {
        return checkSlot3;
    }

    public ItemStack getCheckSlot4() {
        return checkSlot4;
    }

    public ItemStack getCheckSlot5() {
        return checkSlot5;
    }

    public ItemStack getCheckSlot6() {
        return checkSlot6;
    }

    public ItemStack getCheckSlot7() {
        return checkSlot7;
    }

    public ItemStack getCheckSlot8() {
        return checkSlot8;
    }

    public ItemStack getCheckSlot9() {
        return checkSlot9;
    }

    public void setFinalItem(ItemStack finalItem) {
        this.finalItem = finalItem;
    }

    public ItemStack getFinalItem() {
        return finalItem;
    }



}
