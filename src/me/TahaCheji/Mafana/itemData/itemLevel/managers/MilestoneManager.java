package me.TahaCheji.Mafana.itemData.itemLevel.managers;
import me.TahaCheji.Mafana.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MilestoneManager {

    public static void applyCommandMilestone(Player player, ItemStack is) {
        try {
            String command = me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getString("console-command-milestones." + String.valueOf(me.TahaCheji.Mafana.itemData.itemLevel.managers.LoreManager.getToolLevel(is) + 1).replace(".0", "")).replace("%player", player.getName());
            if(command != null && command != "") {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageUtil.translate(command));
            }
        } catch(NullPointerException | IllegalArgumentException e) {

        }
        player.sendMessage(MessageUtil.translate(me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getString("language.levelup-message")).replace("%level",
                String.valueOf(me.TahaCheji.Mafana.itemData.itemLevel.managers.LoreManager.getToolLevel(is) + (double) 1).replace(".0", "")));
    }
    public static String getLoreMilestone(Player player, ItemStack is) {
        try {
            String milestone = me.TahaCheji.Mafana.itemData.itemLevel.managers.ConfigManager.getString("lore-milestones." + String.valueOf(me.TahaCheji.Mafana.itemData.itemLevel.managers.LoreManager.getToolLevel(is) + 1).replace(".0", ""));
            if(milestone != null && milestone != "") {
                return MessageUtil.translate(milestone);
            } else {
                return "";
            }
        } catch(NullPointerException e) {
            return "";
        }
    }

}
