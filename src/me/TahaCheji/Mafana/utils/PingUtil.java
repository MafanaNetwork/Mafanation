package me.TahaCheji.Mafana.utils;

import org.bukkit.Bukkit;
//import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingUtil {
    public static int getPing(Player p) {
        String v = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        if (!p.getClass().getName().equals("org.bukkit.craftbukkit." + v + ".entity.CraftPlayer")) { //compatibility with some plugins
            p = Bukkit.getPlayer(p.getUniqueId()); //cast to org.bukkit.entity.Player
        }
        try {
            if(p == null) {
                return 0;
            }
            return 0;//p.getPing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
