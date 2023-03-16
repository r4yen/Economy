package economy.economy;

import economy.economy.commands.MoneyCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Economy extends JavaPlugin {

    public static List<UUID> players = new ArrayList<>();
    public static Economy instance = null;

    @Override
    public void onEnable() {
        instance = this;
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
}
