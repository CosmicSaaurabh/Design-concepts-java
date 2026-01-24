package com.saurabh.implementation1.team;

import com.saurabh.implementation1.player.Player;

import java.util.List;

public class Team {
    private final String teamName;
    private final List<Player> playerList;

    public Team(String teamName, List<Player> playerList) {
        this.teamName = teamName;
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public String getTeamName() {
        return teamName;
    }
}
