package me.TahaCheji.Mafana.itemData.itemLevel.managers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import me.TahaCheji.Mafana.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class AnvilManager implements Listener {

    @EventHandler
    public void onAnvilPrepare(PrepareAnvilEvent event) {
        if(event.getInventory().getItem(0) != null && event.getInventory().getItem(1) != null) {
            if(event.getInventory().getItem(1).getType().equals(Material.PAPER) && event.getInventory().getItem(1).hasItemMeta()) {
                List<String> lore = new ArrayList<String>();
                String materialName = event.getInventory().getItem(0).getType().toString();
                if(materialName.contains("AXE") || materialName.contains("SHOVEL") || materialName.contains("SWORD") || materialName.contains("CHESTPLATE") || materialName.contains("BOOTS") || materialName.contains("LEGGINGS") || materialName.contains("HELMET") || materialName.contains("BOW")) {
                    ItemStack is = event.getInventory().getItem(0).clone();
                    ItemMeta im = is.getItemMeta();
                    double maxXP = 10;
                    for(int i = 0; i < LoreManager.getPaperLevel(event.getInventory().getItem(1)); i++) {
                        maxXP = maxXP * ConfigManager.getDouble("multiplier.xp");
                    }
                    lore.add("");
                    DecimalFormat format = new DecimalFormat("0.00");
                    lore.add("§7XP §f" + (double) 0 + " §7/ §f" + format.format(maxXP).replace(",", "."));
                    lore.add("§7Level §f" + LoreManager.getPaperLevel(event.getInventory().getItem(1)));
                    if(ConfigManager.getBoolean("use.owner-binding")) {
                        lore.add("§c" + event.getView().getPlayer().getName());
                    }
                    lore.add("");
                    lore.add(MilestoneManager.getLoreMilestone((Player) event.getView().getPlayer(), is));
                    im.setLore(lore);
                    is.setItemMeta(im);
                    event.setResult(is);
                    Main.plugin.getServer().getScheduler().runTask(Main.plugin, () -> event.getInventory().setRepairCost(1));
                }
            }
        }
    }

}
