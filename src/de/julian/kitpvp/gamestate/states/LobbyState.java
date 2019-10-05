package de.julian.kitpvp.gamestate.states;

import de.julian.kitpvp.countdown.LobbyCountdown;
import de.julian.kitpvp.gamestate.GameState;
import de.julian.kitpvp.main.Main;

public class LobbyState extends GameState {

    private Main plugin;

    public LobbyState(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
        LobbyCountdown lobbyCountdown = new LobbyCountdown(plugin);
        lobbyCountdown.start();
    }

    @Override
    public void stop() {

    }
}
