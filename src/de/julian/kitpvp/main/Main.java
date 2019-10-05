package de.julian.kitpvp.main;

import de.julian.kitpvp.commands.JoinCommand;
import de.julian.kitpvp.commands.SetupCommands;
import de.julian.kitpvp.gamestate.GameStateManager;
import de.julian.kitpvp.listener.PlayerConnectionListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    // TODO: Choose kits-> Kitsystem : Error Handling | TeleportSystem -> Config | Surroundings

    private static Main plugin;
    private GameStateManager gameStateManager;
    private ArrayList<Player> players;

    @Override
    public void onEnable() {
        plugin = this;
        players = new ArrayList<>();
        gameStateManager = new GameStateManager(this);
        init();
        getLogger().info("Now it begins...");
    }

    private void init() {
        new PlayerConnectionListener(this);
        new SetupCommands(this);
        new JoinCommand(this);
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public static Main getPlugin() {
        return plugin;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
