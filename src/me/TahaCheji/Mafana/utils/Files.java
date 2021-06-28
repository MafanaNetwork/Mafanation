package me.TahaCheji.Mafana.utils;

import me.TahaCheji.Mafana.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Files {
	
	
	static File configFile = new File("plugins/Mafanation/config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(configFile);
	
	public static void initFiles() throws FileNotFoundException, IOException, InvalidConfigurationException {
		
		if(!new File("plugins/Mafanation").exists()) {
			new File("plugins/Mafanation").mkdir();
		}
		
		if(!configFile.exists()) {
			Main.getInstance().saveDefaultConfig();
		}
		String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

		File playerData = new File("plugins/Mafanation/playerData");
		File recipesData = new File("plugins/Mafanation/Weapons");
		if(!playerData.exists()) {
			playerData.mkdir();
		}
		if(!(recipesData.exists())) {
			recipesData.mkdir();
		}
		
		loadFiles();
		
	}

	private static void loadFiles() throws FileNotFoundException, IOException, InvalidConfigurationException {
		cfg.load(configFile);
	}


	private static void loadFile(InputStream paramInputStream, File paramFile) throws IOException, InvalidConfigurationException {

		if(!paramFile.exists()) {
			FileUtils.copyInputStreamToFile(paramInputStream, paramFile);
		}
		((FileConfiguration)YamlConfiguration.loadConfiguration(paramFile)).load(paramFile);
	}
	
}
