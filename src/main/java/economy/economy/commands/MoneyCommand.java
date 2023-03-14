package economy.economy.commands;

import economy.economy.Economy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = null;

        if(args.length == 1) {
            p = Bukkit.getPlayer(args[0]);
        } else if(sender instanceof Player) {
            p = (Player) sender;
        }

        if(p == null && args.length == 1) {
            sender.sendMessage(/* Player not found */);
        } else if(args.length > 1) {
            sender.sendMessage(/* Too many arguments */);
        } else if(p == null) {
            sender.sendMessage(/* Command from Console */);
        } else {
            sender.sendMessage(/* Money of Player */);
        }

        return true;
    }
}
