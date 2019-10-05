package de.julian.kitpvp.countdown;

public abstract class Countdown {

    int taskID;
    boolean running;

    public abstract void start();
    public abstract void stop();
}
