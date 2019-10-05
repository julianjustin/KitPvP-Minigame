package de.julian.kitpvp.commands;

import de.julian.kitpvp.gamestate.GameState;
import de.julian.kitpvp.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupCommands implements CommandExecutor {

    private Main plugin;

    public SetupCommands(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("start").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if(commandSender instanceof  Player) {
            Player p = (Player) commandSender;

            if(p.hasPermission("kitpvp.setup")) {
                if(args.length == 0) {
                    if(plugin.getGameStateManager().getCurrentGameState() == null) {
                        plugin.getGameStateManager().setGameState(GameState.LOBBY_STATE);
                        p.sendMessage("§6The Lobby has been activated");
                    } else {
                        p.sendMessage("§cThe Plugin was already activated");
                    }
                } else {
                    p.sendMessage("§cPlease use /start");
                }
            } else {
                p.sendMessage("§cYou have no permission to do that");
            }
        } else {
            commandSender.sendMessage("§cThis is a player command");
        }

        return true;
    }
}
