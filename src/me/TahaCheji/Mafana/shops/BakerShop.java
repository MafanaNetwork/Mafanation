package me.TahaCheji.Mafana.shops;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.gameItems.items.BoneShard;
import me.TahaCheji.Mafana.gameItems.items.MagicCookie;
import me.TahaCheji.Mafana.gameItems.items.MidasStand;
import me.TahaCheji.Mafana.shopData.ShopUtl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.io.IOException;

public class BakerShop implements Listener {

    public ShopUtl bakersCock(Player player) {
        ShopUtl shop = new ShopUtl("BakersCook", MidasStand.MidasStand(), BoneShard.BoneShard());
        return shop;
    }



}
