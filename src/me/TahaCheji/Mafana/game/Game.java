package me.TahaCheji.Mafana.game;

import me.TahaCheji.Mafana.Main;
import me.TahaCheji.Mafana.utils.data.DataHandler;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import java.util.*;

public class Game {

    private final List<Location> spawnPoints;
    private boolean isTeamGame;
    private Location lobbyPoint;
    private World world;

    private final int amount = 1;
    private final Map<Entity, Location> gamePlayerToSpawnPoint = new HashMap<>();


    public Game(String gameName) {
        FileConfiguration fileConfiguration = DataHandler.getInstance().getGameInfo();
        try {
            String[] values = fileConfiguration.getString("games." + gameName + ".lobbyPoint").split(","); // [X:0, Y:0, Z:0]
            double x = Double.parseDouble(values[0].split(":")[1]); // X:0 -> X, 0 -> 0
            double y = Double.parseDouble(values[1].split(":")[1]);
            double z = Double.parseDouble(values[2].split(":")[1]);
            lobbyPoint = new Location(world, x, y, z);
        } catch (Exception ex) {
            Main.getInstance().getLogger().severe("Failed to load lobbyPoint with metadata " + fileConfiguration.getString("games." + gameName + ".lobbyPoint") + " for gameName: '" + gameName + "'. ExceptionType: " + ex);
        }

        this.spawnPoints = new ArrayList<>();

        for (String point : fileConfiguration.getStringList("games." + gameName + ".spawnPoints")) {
            // X:0,Y:0,Z:0
            try {
                String[] values = point.split(","); // [X:0, Y:0, Z:0]
                double x = Double.parseDouble(values[0].split(":")[1]); // X:0 -> X, 0 -> 0
                double y = Double.parseDouble(values[1].split(":")[1]);
                double z = Double.parseDouble(values[2].split(":")[1]);
                Location location = new Location(world, x, y, z);
                spawnPoints.add(location);
            } catch (Exception ex) {
                Main.getInstance().getLogger().severe("Failed to load spawnPoint with metadata " + point + " for gameName: '" + gameName + "'. ExceptionType: " + ex);
            }
        }


    }
}
