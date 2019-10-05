package de.julian.kitpvp.gamestate;

public abstract class GameState {

    public static final int LOBBY_STATE = 0,
                            IN_GAME_STATE = 1,
                            ENDING_STATE = 2;

    public abstract void start();
    public abstract void stop();

}
