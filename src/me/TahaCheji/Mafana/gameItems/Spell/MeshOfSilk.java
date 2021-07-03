package me.TahaCheji.Mafana.gameItems.Spell;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.crafting.CraftingUtl;
import me.TahaCheji.Mafana.gameItems.items.CompressedSilk;
import me.TahaCheji.Mafana.itemData.ClickType;
import me.TahaCheji.Mafana.itemData.ItemUtl;
import me.TahaCheji.Mafana.itemData.RarityType;
import me.TahaCheji.Mafana.stats.PlayerStats;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MeshOfSilk implements Listener {

    public ItemStack getMeshOfSilk(Player player) {
        ItemStack itemStack = ItemUtl.createSpellBook(Material.BOOK, 1, player, 0, true, true,
                RarityType.REDSTONE, "MeshOfSilk", 75, false, "Freezes mobs for 5 seconds.", 75, ClickType.RIGHT_CLICK, "Spider man, Spider man does whatever a spider does or somthin");

        return itemStack;
    }

    public void getMeshOfSilkRecipe(Player player, Inventory gui) {
       new CraftingUtl().createRecipe(CompressedSilk.getCompressedSilk(), 1, CompressedSilk.getCompressedSilk(), 1, CompressedSilk.getCompressedSilk(), 1, CompressedSilk.getCompressedSilk(), 1, CompressedSilk.getCompressedSilk(), 1, CompressedSilk.getCompressedSilk(), 1, CompressedSilk.getCompressedSilk(), 1, CompressedSilk.getCompressedSilk(), 1, CompressedSilk.getCompressedSilk(), 1, player, getMeshOfSilk(player), gui);
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        ItemStack itemStack = e.getItem();
        Player player = e.getPlayer();
        if (e.getItem() == null) {
            return;
        }
        if (e.getItem().getItemMeta() == null) {
            return;
        }
        if (e.getItem().getItemMeta().getDisplayName() == null) {
            return;
        }
        if (!(player.getItemInHand().getItemMeta().getDisplayName().contains("MeshOfSilk"))) {
            return;
        }
        for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
            Location location = entity.getLocation();
            PlayerStats pS = PlayerStats.playerStats.get(player.getUniqueId());
            if (pS.getCurrentIntelligence() < 75) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You don't have enough mana!");
                return;
            }
            pS.setCurrentIntelligence(pS.getCurrentIntelligence() - 75);
            Block block = location.getBlock();
            block.setType(Material.COBWEB);
            Block block2 = location.add(0, 1, 0).getBlock();
            block2.setType(Material.COBWEB);
            player.playSound(player.getLocation(), Sound.BLOCK_SLIME_BLOCK_PLACE, 10, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    block2.setType(Material.AIR);
                    block.setType(Material.AIR);
                    player.playSound(player.getLocation(), Sound.BLOCK_STONE_BREAK, 10, 10);
                }
            }, 100L);
        }
    }

}
