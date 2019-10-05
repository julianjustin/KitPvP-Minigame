package de.julian.kitpvp.listener;

import de.julian.kitpvp.gamestate.GameState;
import de.julian.kitpvp.gamestate.states.LobbyState;
import de.julian.kitpvp.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    private Main plugin;

    public PlayerConnectionListener(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void handleJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(plugin.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
            e.setJoinMessage("§9" + p.getName() + "§3 ist der Lobby beigetreten!");
        }
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("§9" + p.getName() + "§3 hat das Spiel verlassen!");
    }

}
