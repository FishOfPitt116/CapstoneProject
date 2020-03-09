package fhscapstone.fisheltestapp;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class Team {
    private String name;
    private Coach coach;
    private Player[] roster;

    public Team(String n, Coach c) {
        name = n;
        coach = c;
    }

    public Team(String n, Player[] r) {
        name = n;
        roster = r;
    }

    public String getName() {
        return name;
    }

    public Player getPlayer(int id) {
        return roster[id];
    }

    public void inputStats(int[][] game) {
        for (int r = 0; r <= roster.length; r++) {
            if (game[r][0] == 1)
                roster[r].addGamePlayed();
            roster[r].addMinutes(game[r][1]);
            roster[r].addPoints(game[r][2]);
            roster[r].addRebounds(game[r][3]);
            roster[r].addAssists(game[r][4]);
            roster[r].addBlocks(game[r][5]);
            roster[r].addSteals(game[r][6]);
            roster[r].addTurnovers(game[r][7]);

        }
    }
    // 2d array input should have each player with their own row, and then each stat with their own column

    public String getCoachName () {
        return coach.getCoachName();
    }

}