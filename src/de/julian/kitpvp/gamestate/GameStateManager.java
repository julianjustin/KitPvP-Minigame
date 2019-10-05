package de.julian.kitpvp.gamestate;

import de.julian.kitpvp.gamestate.states.EndingState;
import de.julian.kitpvp.gamestate.states.InGameState;
import de.julian.kitpvp.gamestate.states.LobbyState;
import de.julian.kitpvp.main.Main;

public class GameStateManager {

    private Main plugin;
    private GameState currentGameState;
    private GameState[] gameStates;

    public GameStateManager(Main plugin) {
        this.plugin = plugin;
        gameStates = new GameState[3];
        gameStates[GameState.LOBBY_STATE] = new LobbyState(plugin);
        gameStates[GameState.IN_GAME_STATE] = new InGameState();
        gameStates[GameState.ENDING_STATE] = new EndingState();
    }

    public void setGameState(int gameStateID) {
        if(currentGameState!=null)
            currentGameState.stop();
        currentGameState = gameStates[gameStateID];
        currentGameState.start();
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public void stopGameState() {
        if(currentGameState!=null) {
            currentGameState.stop();
            currentGameState = null;
        }
    }
}
