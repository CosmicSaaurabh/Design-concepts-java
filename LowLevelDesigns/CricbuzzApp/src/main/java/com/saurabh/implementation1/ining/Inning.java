package com.saurabh.implementation1.ining;

import com.saurabh.implementation1.team.Team;

public class Inning {
    private final Team battingTeam;
    private final Team bowlingTeam;
    InningScoreCard scoreCard;

    public Inning(Team battingTeam, Team bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public void updateInningScoreCard() {

    }
}
