package com.game.my_game;

public class GameInfo {
    private boolean isOver;
    private String winner;
    private boolean hasFork;
    Player player;

    public GameInfo(boolean isOver, String winner, Player player, boolean hasFork) {
        this.isOver = isOver;
        this.winner = winner;
        this.player = player;
        this.hasFork = hasFork;
    }
}
