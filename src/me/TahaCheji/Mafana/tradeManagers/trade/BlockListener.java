package me.TahaCheji.Mafana.tradeManagers.trade;

import me.TahaCheji.Mafana.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockPhysicsEvent;

public class BlockListener implements Listener {

    private final Main plugin;

    public BlockListener(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event) {

    }

    @EventHandler
    public void onBlockCanBuild(BlockCanBuildEvent event) {

    }
}
