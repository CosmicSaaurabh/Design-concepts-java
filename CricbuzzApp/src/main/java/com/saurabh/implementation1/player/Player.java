package com.saurabh.implementation1.player;

public class Player {
    private final String name;
    private final int age;

    private final PlayerType playerType;

    public Player(String name, int age, PlayerType playerType) {
        this.name = name;
        this.age = age;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}
