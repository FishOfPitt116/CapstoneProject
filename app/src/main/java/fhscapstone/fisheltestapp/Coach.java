package fhscapstone.fisheltestapp;

public class Coach {
    public String coachName;
    public int[][] idealStats;

    // 2x5 with primary stat in first column and secondary stat in the second column

    public Coach (String c, int[][] stats) {
        coachName = c;
        idealStats = stats;
    }

    public String getCoachName () {
        return coachName;
    }

}
