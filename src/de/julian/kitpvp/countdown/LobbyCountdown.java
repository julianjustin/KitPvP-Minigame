package de.julian.kitpvp.countdown;

import de.julian.kitpvp.gamestate.GameState;
import de.julian.kitpvp.main.Main;
import org.bukkit.Bukkit;

public class LobbyCountdown extends Countdown {

    private Main plugin;

    public LobbyCountdown(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                if(plugin.getPlayers().size() == 0) {
                    Bukkit.broadcastMessage("§6Waiting for players...");
                }
                 else if(plugin.getPlayers().size() == 1) {
                    stop();
                }
            }
        }, 1L, 20L*20);
    }

    @Override
    public void stop() {
        Bukkit.getScheduler().cancelTask(taskID);
        plugin.getGameStateManager().setGameState(GameState.IN_GAME_STATE);
    }


}
