package economy.economy;

import me.clip.placeholderapi.PlaceholderHook;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PAPI extends PlaceholderHook {
    @Override
    public @Nullable String onPlaceholderRequest(Player p, @NotNull String params) {
        if(params.equalsIgnoreCase("money")) {
            return String.valueOf(Economy.getMoney(p.getUniqueId()));
        }

        if(params.equalsIgnoreCase("rank")) {
             return null;
        }

        if(params.equalsIgnroeCase("totalmoney")) {
            int money = 0;

            for(UUID uuid: Economy.Players) {
                money += Economy.getMoney(uuid);
            } 

            return money;
        }

        return null;
    }
}
