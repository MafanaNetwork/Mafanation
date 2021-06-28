package me.TahaCheji.Mafana.tradeManagers.trade;
import me.TahaCheji.Mafana.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

public class EntityListener implements Listener {

    private final Main plugin;
    private int itemNumber = 0;

    public EntityListener(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {


    }
}
