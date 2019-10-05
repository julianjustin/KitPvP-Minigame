package de.julian.kitpvp.gamestate.states;

import de.julian.kitpvp.gamestate.GameState;
import org.bukkit.Bukkit;

public class InGameState extends GameState {
    @Override
    public void start() {
        Bukkit.broadcastMessage("Now we are INGAME");
    }

    @Override
    public void stop() {

    }
}
