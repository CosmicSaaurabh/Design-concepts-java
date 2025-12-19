package com.game.my_game;

public interface Board {
    public void move(Move move);

    public Board copy();
}
