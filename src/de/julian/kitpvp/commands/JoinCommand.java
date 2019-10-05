package de.julian.kitpvp.commands;

import de.julian.kitpvp.gamestate.states.LobbyState;
import de.julian.kitpvp.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand implements CommandExecutor {

    private Main plugin;

    public JoinCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("join").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;

            if(args.length == 0) {
                if(plugin.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
                    plugin.getPlayers().add(p);
                    p.sendMessage("You joined the game");
                    p.sendMessage("Players: " + plugin.getPlayers().size());
                } else {
                    p.sendMessage("§cYou are not in the lobby");
                }
            } else {
                p.sendMessage("§cPlease use /join");
            }
        } else {
            commandSender.sendMessage("§cThis is a player command");
        }

        return true;
    }
}
