package me.TahaCheji.Mafana.gui.itemsCommandGui;

import me.TahaCheji.Mafana.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ItemsGuiClicks implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Economy econ = Main.getEcon();
        if (!(e.getView().getTitle().contains("Items"))) {
            return;
        }
        e.setCancelled(true);
        if(e.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) {
            return;
        }
        if(e.getSlot() == 40) {
            player.closeInventory();
            return;
        }
        player.getInventory().addItem(e.getCurrentItem());
    }


}
