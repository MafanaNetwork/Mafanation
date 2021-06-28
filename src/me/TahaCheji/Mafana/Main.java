package me.TahaCheji.Mafana;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import de.ancash.actionbar.ActionBarAPI;
import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Mafana.area.SkeletonHills.Mobs.MeatySkeleton;
import me.TahaCheji.Mafana.area.SkeletonHills.Mobs.OutLayer;
import me.TahaCheji.Mafana.crafting.CraftingUtl;
import me.TahaCheji.Mafana.dungeons.AquaDungeon.FounderDrownedMainAI;
import me.TahaCheji.Mafana.dungeons.AquaDungeon.ReservoirCap;
import me.TahaCheji.Mafana.dungeons.AquaDungeon.WaterBreathBow;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import me.TahaCheji.Mafana.Mining.blockevent;
import me.TahaCheji.Mafana.dungeons.AquaDungeon.MainDungeon;
import me.TahaCheji.Mafana.gameItems.Spell.MeshOfSilk;
import me.TahaCheji.Mafana.gameItems.Weapons.*;
import me.TahaCheji.Mafana.gui.itemsCommandGui.ItemsGuiClicks;
import me.TahaCheji.Mafana.gui.ShopGuiManager;
import me.TahaCheji.Mafana.itemData.EnchancmentsUtl;
import me.TahaCheji.Mafana.commands.Commands;
import me.TahaCheji.Mafana.itemData.UndeadAttributeUtl;
import me.TahaCheji.Mafana.itemLevel.commands.*;
import me.TahaCheji.Mafana.listeners.playerRightClick.GuiInvClicks;
import me.TahaCheji.Mafana.mobData.SpawnMob;
import me.TahaCheji.Mafana.npc.town.Shops.Farmist;
import me.TahaCheji.Mafana.npc.town.Shops.OreMaster;
import me.TahaCheji.Mafana.npc.town.Shops.WeaponSmith;
import me.TahaCheji.Mafana.npc.town.Voter.Voter;
import me.TahaCheji.Mafana.npc.town.Voter.VoterGuiEvent;
import me.TahaCheji.Mafana.playerData.playerCollections.playerBlockPlaced;
import me.TahaCheji.Mafana.playerData.playerCollections.playerBlocksBroken;
import me.TahaCheji.Mafana.playerData.playerInfo.*;
import me.TahaCheji.Mafana.playerData.playerInventoryData;
import me.TahaCheji.Mafana.playerData.playerItemFished;
import me.TahaCheji.Mafana.playerData.playerMobData;
import me.TahaCheji.Mafana.playerData.playerTalkedTo;
import me.TahaCheji.Mafana.shops.BakerShop;
import me.TahaCheji.Mafana.utils.data.DataHandler;
import me.TahaCheji.Mafana.gameItems.items.bakersItems.*;
import me.TahaCheji.Mafana.listeners.*;
import me.TahaCheji.Mafana.listeners.PlayerDamage;
import me.TahaCheji.Mafana.npc.*;
import me.TahaCheji.Mafana.npc.town.Baker.Baker;
import me.TahaCheji.Mafana.npc.town.Baker.BakerShopGuiClicks;
import me.TahaCheji.Mafana.game.*;
import me.TahaCheji.Mafana.stats.*;
import me.TahaCheji.Mafana.mainMobs.mobDrops.town.TownZombieDrops;
import me.TahaCheji.Mafana.tradeManagers.trade.*;
import me.TahaCheji.Mafana.utils.Attribute;
import me.TahaCheji.Mafana.utils.Files;
import me.TahaCheji.Mafana.utils.Metrics;
import me.TahaCheji.Mafana.utils.NBTUtils;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcmonkey.sentinel.SentinelPlugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;

public class Main extends JavaPlugin implements Listener {

    public static Main PLUGIN;
    public static ArrayList<Enchantment> custom_enchants = new ArrayList<>();
    private static Main instance;
    private boolean titlechanged = false;
    private Set<Game> games = new HashSet<>();
    private final PlayerListener playerListener = new PlayerListener(this);
    private final BlockListener blockListener = new BlockListener(this);
    private final EntityListener entityListener = new EntityListener(this);
    private final CommandListener commandListener = new CommandListener(this);
    private final InventoryListener inventoryListener = new InventoryListener(this);
    private FileConfiguration lang = null;
    private File langFile = null;
    private static HashMap<String, TradePlayer> traders = new HashMap<String, TradePlayer>();
    private static HashMap<String, TradePlayer> requests = new HashMap<String, TradePlayer>();
    private Map<UUID, Integer> taskId = new HashMap<>();
    private int taskID;
    public static Set<UUID> hold = new HashSet<UUID>();
    private Connection connection;
    public String host, database, username, password, table;
    public int port;
    private static Economy econ = null;
    public WorldGuardPlugin worldGuardPlugin;
    public static Main plugin;
    public final SpawnMob spawnMob = new SpawnMob();
    @Override
    public void onEnable() {
        loadConfig();
        instance = this;
        worldGuardPlugin = getWorldGuard();
        if (DataHandler.getInstance().getGameInfo().getConfigurationSection("games") != null) {
            for (String gameName : DataHandler.getInstance().getGameInfo().getConfigurationSection("games").getKeys(false)) {
            }
        }
        PLUGIN = this;
        plugin = this;
        PluginManager pluginmanager = getServer().getPluginManager();
        pluginmanager.registerEvents(new me.TahaCheji.Mafana.itemLevel.managers.EventManager(), plugin);
        pluginmanager.registerEvents(new me.TahaCheji.Mafana.itemLevel.managers.AnvilManager(), plugin);
        getCommand("givepaper").setExecutor(new GivePaperCommand());
        getCommand("StandTest").setExecutor(new Commands());
        getCommand("configreload").setExecutor(new ReloadConfigCommand());
        getCommand("fix").setExecutor(new FixItemCommand());
        getCommand("iteminfo").setExecutor(new ItemInfoCommand());
        getCommand("setowner").setExecutor(new SetOwnerCommand());
        getCommand("clearowner").setExecutor(new ClearOwnerCommand());
        getCommand("ItemsGui").setExecutor(new Commands());
        getCommand("Sell").setExecutor(new Commands());
        getCommand("spawn").setExecutor(new Commands());
        getCommand("mobTest").setExecutor(new Commands());
        getCommand("InventoryTest").setExecutor(new Commands());
        getCommand("Vote").setExecutor(new Commands());
        getCommand("nick").setExecutor(new Commands());

        plugin.saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(this, this);


        if (!setupEconomy() ) {
            System.out.print("No econ plugin found.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        this.saveDefaultConfig();

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
        pm.registerEvents(blockListener, this);
        pm.registerEvents(entityListener, this);
        pm.registerEvents(inventoryListener, this);

        // Register our commands
        getCommand("trade").setExecutor(commandListener);


        //config
        getConfig().options().copyDefaults(true);
        saveConfig();

        //custom player log

        saveDefaultLangConfig();
        reloadLangFile();

VoterHologram();
        mysqlSetup();

        if (getServer().getPluginManager().getPlugin("Citizens") == null || getServer().getPluginManager().getPlugin("Citizens").isEnabled() == false) {
            getLogger().log(Level.SEVERE, "Citizens 2.0 not found or not enabled");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        try {
            Files.initFiles();
        } catch (IOException | InvalidConfigurationException e2) {
            e2.printStackTrace();
        }
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                regeneratePlayerStats();
            }
        }, 20L, 15L);
        registerEvents();
        Metrics m = new Metrics(plugin, 8795);
        m.getClass();


        for(Player p : Bukkit.getOnlinePlayers()) {
            PlayerStats pS = new PlayerStats();
            pS.setUUID(p.getUniqueId());
            pS.setPlayer(p);
            pS.setMaxHealth(PlayerStats.getTotalHealth(p));
            pS.setCurrentHealth(pS.getMaxHealth());
            pS.setMaxIntelligence(PlayerStats.getTotalIntelligence(p));
            pS.setSpeed(PlayerStats.getSpeed(pS.getPlayer()));
            pS.setCurrentIntelligence(pS.getMaxIntelligence());
            PlayerStats.playerStats.put(p.getUniqueId(), pS);
        }
        if(Files.cfg.getBoolean("actionbar.enabled")) {
            Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                @Override
                public void run() {
                    setPlayerActionBar();
                }
            }, 20L, 15L);
        }
        SentinelPlugin.instance.registerIntegration(new LoafOfHealth());

        statUpdate();
    }





    public static void statUpdate() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {

                for(Player p : Bukkit.getOnlinePlayers()) {
                    for(int slot = 0; slot <= p.getInventory().getSize() ; slot++) {

                        if(p.getInventory().getItem(slot) != null) {
                            ItemStack is = p.getInventory().getItem(slot);
                            if(!is.hasItemMeta() || !is.getItemMeta().hasDisplayName() || !is.getItemMeta().hasLore()) continue;
                            if(new NBTItem(is).hasKey("baseStrength") || new NBTItem(is).hasKey("baseHealth") || new NBTItem(is).hasKey("baseSpeed") || new NBTItem(is).hasKey("baseMana")) continue;
                            is = prepare(is);
                            is = NBTUtils.setString(is, "originalName", is.getItemMeta().getDisplayName());
                            p.getInventory().setItem(slot, is);
                        }
                    }
                }
            }
            private ItemStack prepare(ItemStack is) {
                HashMap<Attribute, Integer> atts = getBaseAttributes(is);
                if(atts == null) return is;
                for(Attribute att : atts.keySet()) {
                    is = NBTUtils.setInt(is, "base" + att.getName().replace(" ", ""), atts.get(att));
                }
                return is;
            }

            private HashMap<Attribute, Integer> getBaseAttributes(ItemStack is){
                HashMap<Attribute, Integer> atts = new HashMap<Attribute, Integer>();
                if(!is.hasItemMeta() || !is.getItemMeta().hasLore()) return null;
                for(String lore : is.getItemMeta().getLore()) {
                    if(lore.contains("§dStrength: §c+")) atts.put(Attribute.STRENGTH, Integer.valueOf(lore.replace("§dStrength: §c+", "")));
                    if(lore.contains("§cHealth: §c+")) atts.put(Attribute.HEALTH, Integer.valueOf(lore.replace("§cHealth: §c+", "").replace(" HP", "")));
                    if(lore.contains("§9Mana: §c+")) atts.put(Attribute.MANA, Integer.valueOf(lore.replace("§9Mana: §c+", "")));
                    if(lore.contains("§bSpeed: §c+")) atts.put(Attribute.SPEED, Integer.valueOf(lore.replace("§bSpeed: §c+", "")));
                }
                return atts;
            }
        }, 30, 50);
    }




    public WorldGuardPlugin getWorldGuard() {
        Plugin plugin = this.getServer().getPluginManager().getPlugin("WorldGuard");

        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null;
        }

        return (WorldGuardPlugin) plugin;
    }
    
    public static void setPlayerActionBar() {
        for(UUID pUUID : PlayerStats.playerStats.keySet()) {
            PlayerStats pS = PlayerStats.playerStats.get(pUUID);
            pS.getPlayer().setSaturation(20);
            pS.setStrength(PlayerStats.getStrength(pS.getPlayer()));
            pS.setMaxIntelligence(PlayerStats.getTotalIntelligence(pS.getPlayer()));
            pS.setMaxHealth(PlayerStats.getTotalHealth(pS.getPlayer()));
            pS.setCurrentHealth(pS.getPlayer().getHealth());
            pS.setSpeed(PlayerStats.getSpeed(pS.getPlayer()));
            pS.getPlayer().setHealthScale(40);
            String msg = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("actionbar.msg"));
            msg = msg.replace("%cur_health%", (""+Math.ceil(pS.getCurrentHealth())).replace(".0", "")).replace("%max_health%", (""+Math.ceil(pS.getMaxHealth())).replace(".0", ""))
                    .replace("%cur_mana%", (""+Math.ceil(pS.getCurrentIntelligence())).replace(".0", "")).replace("%max_mana%", (""+Math.ceil(pS.getMaxIntelligence())).replace(".0", ""))
                    .replace("%cur_strength%", (""+Math.ceil(pS.getStrength())).replace(".0", ""))
                    .replace("%cur_speed%", (""+Math.ceil(pS.getSpeed())).replace(".0", ""));

            File playerData = new File("plugins/Mafanation/playerData/"+pS.getPlayer().getUniqueId().toString()+"/data.yml");
            FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);

            try {
                pD.load(playerData);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
            ActionBarAPI.sendActionBar(pS.getPlayer(), msg);
        }
    }

private void VoterHologram() {
    Block block1 = Bukkit.getServer().getWorld("world").getBlockAt((int) 18.526, 73, 161);
    Block block2 = Bukkit.getServer().getWorld("world").getBlockAt((int) 13.512, 73, 162);
    Block block3 = Bukkit.getServer().getWorld("world").getBlockAt((int) 8.477, 73, 161);

    Hologram holo = HologramsAPI.createHologram(this,block1.getLocation());
    Hologram holo2 = HologramsAPI.createHologram(this,block1.getLocation().subtract(0, 1, 0));

    Hologram holo1 = HologramsAPI.createHologram(this,block2.getLocation());
    Hologram holo3 = HologramsAPI.createHologram(this,block2.getLocation().subtract(0, 1, 0));

    Hologram holo4 = HologramsAPI.createHologram(this,block3.getLocation());
    Hologram holo5 = HologramsAPI.createHologram(this,block3.getLocation().subtract(0, 1, 0));

    Bukkit.getScheduler().runTaskTimer(this,() -> {
        holo.insertTextLine(0,ChatColor.GOLD + "Update #1 Votes: " + VoterGuiEvent.option1);
        holo2.insertTextLine(0,ChatColor.WHITE + "Coming Soon");

        holo1.insertTextLine(0,ChatColor.GOLD + "Update #2 Votes: " + VoterGuiEvent.option2);
        holo3.insertTextLine(0,ChatColor.WHITE + "Coming Soon");

        holo4.insertTextLine(0,ChatColor.GOLD + "Update #3 Votes: " + VoterGuiEvent.option3);
        holo5.insertTextLine(0,ChatColor.WHITE + "Coming Soon");


    },0L,0L);

    Bukkit.getScheduler().runTaskTimer(this,() -> {
        holo.removeLine(0);
        holo2.removeLine(0);

        holo1.removeLine(0);
        holo3.removeLine(0);

        holo4.removeLine(0);
        holo5.removeLine(0);


    },0L,0L);

}

    private void regeneratePlayerStats() {
        for(UUID pUUID : PlayerStats.playerStats.keySet()) {
            PlayerStats pS = PlayerStats.playerStats.get(pUUID);
            if(!pS.getPlayer().isDead()) {
                if(pS.getPlayer().getMaxHealth() >= pS.getCurrentHealth()+(pS.getMaxHealth()/200)) {
                    pS.setCurrentHealth(pS.getCurrentHealth()+pS.getMaxHealth()/200);
                    pS.getPlayer().setHealthScale(40);
                } else
                    pS.setCurrentHealth(pS.getMaxHealth());
                pS.getPlayer().setHealthScale(40);
            }
            if(pS.getMaxIntelligence() >= pS.getCurrentIntelligence()+(pS.getMaxIntelligence()/25)) {
                pS.setCurrentIntelligence(pS.getCurrentIntelligence()+pS.getMaxIntelligence()/25);
            } else
                pS.setCurrentIntelligence(pS.getMaxIntelligence());
            if(pS.getCurrentHealth() < 5) {
                pS.getPlayer().teleport(lobbyPoint);
                pS.getPlayer().sendMessage(ChatColor.RED + "You Died!");
                pS.getPlayer().playSound(pS.getPlayer().getLocation(), Sound.BLOCK_ANVIL_HIT, 10, 10);
                pS.setCurrentHealth(100);
                regeneratePlayerStats();
            }
        }
    }

    private void registerEvents() {
        System.out.println("Registering events...");
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), plugin);
        pm.registerEvents(new PlayerQuit(), plugin);
        getServer().getPluginManager().registerEvents(new WeaponSmith(), this);
        getServer().getPluginManager().registerEvents(new WolfMaster(), this);
        getServer().getPluginManager().registerEvents(new ThirstyEmma(), this);
        getServer().getPluginManager().registerEvents(new Skelitenist(), this);
        getServer().getPluginManager().registerEvents(new Phiko(), this);
        getServer().getPluginManager().registerEvents(new OreMaster(), this);
        getServer().getPluginManager().registerEvents(new Karen(), this);
        getServer().getPluginManager().registerEvents(new Jumper(), this);
        getServer().getPluginManager().registerEvents(new Heloraptor(), this);
        getServer().getPluginManager().registerEvents(new Helper(), this);
        getServer().getPluginManager().registerEvents(new GraveMiner(), this);
        getServer().getPluginManager().registerEvents(new Farmist(), this);
        getServer().getPluginManager().registerEvents(new Frosty(), this);
        getServer().getPluginManager().registerEvents(new Ben(), this);
        getServer().getPluginManager().registerEvents(new Lobby(), this);
        getServer().getPluginManager().registerEvents(new Voter(), this);
        getServer().getPluginManager().registerEvents(new TownZombieDrops(), this);
        getServer().getPluginManager().registerEvents(new WarriorsBlade(), this);
        getServer().getPluginManager().registerEvents(new EnchancmentsUtl(), this);
        getServer().getPluginManager().registerEvents(new WaterBreathBow(), this);
        getServer().getPluginManager().registerEvents(new ReservoirCap(), this);
        getServer().getPluginManager().registerEvents(new blockevent(), this);
        getServer().getPluginManager().registerEvents(new BakerShopGuiClicks(), this);
        getServer().getPluginManager().registerEvents(new BakedPotatoOfSpeed(), this);
        getServer().getPluginManager().registerEvents(new CookieOfStrength(), this);
        getServer().getPluginManager().registerEvents(new LoafOfHealth(), this);
        getServer().getPluginManager().registerEvents(new ManaInfusedPie(), this);
        getServer().getPluginManager().registerEvents(new SlicesOfHealth(), this);
        getServer().getPluginManager().registerEvents(new StewOfStrength(), this);
        getServer().getPluginManager().registerEvents(new Baker(), this);
        getServer().getPluginManager().registerEvents(new PlayerDamage(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
        getServer().getPluginManager().registerEvents(new MainDungeon(), this);
        getServer().getPluginManager().registerEvents(new FounderDrownedMainAI(), this);
        getServer().getPluginManager().registerEvents(new ItemsGuiClicks(), this);
        getServer().getPluginManager().registerEvents(new WaterBreathBow(), this);
        getServer().getPluginManager().registerEvents(new AtomSplit(), this);
        getServer().getPluginManager().registerEvents(new ShopGuiManager(), this);
        getServer().getPluginManager().registerEvents(new Dynamite(), this);
        getServer().getPluginManager().registerEvents(new GuiInvClicks(), this);
        getServer().getPluginManager().registerEvents(new Moon(), this);
        getServer().getPluginManager().registerEvents(new CraftingUtl(), this);
        /*
        getServer().getPluginManager().registerEvents(new MobUtil(), this);
        getServer().getPluginManager().registerEvents(new MobsUtil(), this);
        getServer().getPluginManager().registerEvents(new BossUtl(), this);

         */
        getServer().getPluginManager().registerEvents(new SpawnMob(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceEvent(), this);
        getServer().getPluginManager().registerEvents(new Jumpers_Glock(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveEvent(), this);
        getServer().getPluginManager().registerEvents(new UndeadAttributeUtl(), this);
        getServer().getPluginManager().registerEvents(new MeatySkeleton(), this);
        getServer().getPluginManager().registerEvents(new MeshOfSilk(), this);
        getServer().getPluginManager().registerEvents(new DeformedBone(), this);
        getServer().getPluginManager().registerEvents(new OutLayer(), this);

        getServer().getPluginManager().registerEvents(new playerBlocksBroken(), this);
        getServer().getPluginManager().registerEvents(new playerBlockPlaced(), this);
        getServer().getPluginManager().registerEvents(new playerCoins(), this);
        getServer().getPluginManager().registerEvents(new playerLastLocation(), this);
        getServer().getPluginManager().registerEvents(new playerMostDamage(), this);
        getServer().getPluginManager().registerEvents(new playerDate(), this);
        getServer().getPluginManager().registerEvents(new playerInventoryData(), this);
        getServer().getPluginManager().registerEvents(new playerItemFished(), this);
        getServer().getPluginManager().registerEvents(new playerMobData(), this);
        getServer().getPluginManager().registerEvents(new playerTimePlayed(), this);
        getServer().getPluginManager().registerEvents(new playerTalkedTo(), this);
        getServer().getPluginManager().registerEvents(new BakerShop(), this);
    }




    public static Main getPlugin() {
        return PLUGIN;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEcon() {
        return econ;
    }



    @SuppressWarnings("unchecked")

    @Override
    public void onDisable() {
        for(LivingEntity entity : Bukkit.getWorld("world").getLivingEntities()) {
            entity.remove();
        }
        try {
            Field keyField = Enchantment.class.getDeclaredField("byKey");

            keyField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);

            for (Enchantment enchantment : custom_enchants){
                if(byKey.containsKey(enchantment.getKey())) {
                    byKey.remove(enchantment.getKey());
                }
            }

            Field nameField = Enchantment.class.getDeclaredField("byName");

            nameField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);

            for (Enchantment enchantment : custom_enchants){
                if(byName.containsKey(enchantment.getName())) {
                    byName.remove(enchantment.getName());
                }
            }
        } catch (Exception ignored) { }

    }


    public void reloadLangFile() {
        if (langFile == null) {
            langFile = new File(getDataFolder(), "lang.yml");
        }
        lang = YamlConfiguration.loadConfiguration(langFile);

        this.getLogger().info("Loaded Language File: "+lang.getString("LanguageName"));
    }

    public FileConfiguration getLangFile() {
        if (lang == null) {
            reloadLangFile();
        }
        return lang;
    }
    public void saveDefaultLangConfig() {
        if (langFile == null) {
            langFile = new File(getDataFolder(), "lang.yml");
        }
        if (!langFile.exists()) {
            this.saveResource("lang.yml", false);
        }
    }

    public void saveLangFile() {
        if (lang == null || langFile == null) {
            return;
        }
        try {
            getLangFile().save(langFile);
        } catch (IOException ex) {
            getLogger().log(Level.SEVERE, "Could not save config to " + langFile, ex);
        }
    }

    public String c(String name) {
        String caption = getLangFile().getString(name);
        if (caption == null) {
            this.getLogger().warning("Missing caption: " + name);
            caption = "&c[missing caption]";
        }

        caption = ChatColor.translateAlternateColorCodes('&', caption);

        return caption;
    }

    public HashMap<String, TradePlayer> getRequests() {
        return requests;
    }

    public HashMap<String, TradePlayer> getTraders() {
        return traders;
    }

    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    // MYSQL
    public void mysqlSetup() {
            host = this.getConfig().getString("host");
            port = this.getConfig().getInt("port");
            database = this.getConfig().getString("database");
            username = this.getConfig().getString("username");
            password = this.getConfig().getString("password");
            table = this.getConfig().getString("table");

            try{
                synchronized (this) {
                    if(getConnection() != null && !getConnection().isClosed()) {
                        return;
                    }
                    Class.forName("com.mysql.jdbc.Driver");

                    setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":"
                            + this.port + "/" + this.database, this.username, this.password));

                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL CONNECTED");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private Location lobbyPoint = null;
    public Location getLobbyPoint() {
        if (lobbyPoint == null) {
            int x = 0;
            int y = 0;
            int z = 0;
            String world = "world";

            try {
                x = Main.getInstance().getConfig().getInt("lobby-point.x");
                y = Main.getInstance().getConfig().getInt("lobby-point.y");
                z = Main.getInstance().getConfig().getInt("lobby-point.z");
                world = Main.getInstance().getConfig().getString("lobby-point.world");
            } catch (Exception ex) {
                Main.getInstance().getLogger().severe("Lobby point failed with exception: " + ex);
                ex.printStackTrace();
            }

            lobbyPoint = new Location(Bukkit.getWorld(world), x, y, z);
        }

        return lobbyPoint;
    }



    public static Main getInstance() {
        return instance;
    }


}
