package com.game.my_game;

public class Player {
    private String playerSymbol;
    public Player (String symbol) {
        playerSymbol = symbol;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    public Player flipSymbol() {
        return new Player(playerSymbol.equals("X") ? "O" : "X");
    }
}
