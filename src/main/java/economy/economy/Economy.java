package economy.economy;

import economy.economy.commands.MoneyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Economy extends JavaPlugin {

    public static Economy instance = null;

    @Override
    public void onEnable() {
        instance = this;
        this.getCommand("money").setExecutor(new MoneyCommand());
    }

    public static Boolean CommandExecutor() {
        return true;
    }
}
