package economy.economy;

import economy.economy.commands.MoneyCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Economy extends JavaPlugin {

    public static List<UUID> players = new ArrayList<>();
    public static Economy instance = null;

    @Override
    public void onEnable() {
        instance = this;

        createMessagesConfig();
        createServerConfig();
        createProfilesConfig();

        if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new PAPI();
        }

        this.getCommand("money").setExecutor(new MoneyCommand());
    }

    public static int getMoney(UUID player) {
        if(!players.contains(player)) {
            players.add(player);
        }

        return instance.getConfig().getInt("money." + player);
    }

    public static void addMoney(UUID player, int amount) {
        if(!players.contains(player)) {
            players.add(player);
        }

        instance.getConfig().set("money." + player, getMoney(player) + amount);
        instance.saveConfig();
    }

    public static void setMoney(UUID player, int amount) {
        if(!players.contains(player)) {
            players.add(player);
        }

        instance.getConfig().set("money." + player, amount);
        instance.saveConfig();
    }

    private File serverFile;
    private FileConfiguration serverConfig;

    public FileConfiguration getServerConfig() {
        return this.serverConfig;
    }

    private void createServerConfig() {
        serverFile = new File(getDataFolder(), "server.yml");
        saveResource("server.yml", false);

        serverConfig = new YamlConfiguration();
        try {
            serverConfig.load(serverFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private File messagesFile;
    private FileConfiguration messagesConfig;

    public FileConfiguration getMessagesConfig() {
        return this.messagesConfig;
    }

    private void createMessagesConfig() {
        messagesFile = new File(getDataFolder(), "messages.yml");
        saveResource("messages.yml", false);

        messagesConfig = new YamlConfiguration();
        try {
            messagesConfig.load(messagesFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private File profilesFile;
    private FileConfiguration profilesConfig;

    public FileConfiguration getProfilesConfig() {
        return this.profilesConfig;
    }

    private void createProfilesConfig() {
        profilesFile = new File(getDataFolder(), "profiles.yml");
        saveResource("profiles.yml", false);

        profilesConfig = new YamlConfiguration();
        try {
            profilesConfig.load(profilesFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
