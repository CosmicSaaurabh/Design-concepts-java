package com.saurabh.implementation1.match;

import com.saurabh.implementation1.team.Team;

public class FiftyOverMatch implements Match{
    private static final int numberOfOvers = 50;
    private final Team teamA;
    private final Team teamB;

    public FiftyOverMatch(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    @Override
    public MatchScoreCard getScoreCard() {
        return null;
    }

    @Override
    public void updateMatchScoreCard() {

    }
}
