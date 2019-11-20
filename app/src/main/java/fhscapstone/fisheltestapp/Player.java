package fhscapstone.fisheltestapp;

public class Player {
    private String firstName;
    private String lastName;
    private int position;
    private int number;
    private int[] stats;

    /*
        Stats array positions:
        0 is games played
        1 is minutes
        2 is points
        3 is rebounds
        4 is assists
        5 is blocks
        6 is steals
        7 is turnovers

     */

    public Player () {
        stats = new int[8];
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public void addGamePlayed() {
       stats[0]++;
    }

    public void addMinutes(int m) {
        stats[1]+=m;
    }

    public void addPoints(int p) {
        stats[2]+=p;
    }

    public void addRebounds(int r) {
        stats[3]+=r;
    }

    public void addAssists(int a) {
        stats[4]+=a;
    }

    public void addBlocks(int b) {
        stats[5]+=b;
    }

    public void addSteals(int s) {
        stats[6]+=s;
    }

    public void addTurnovers(int t) {
        stats[7]+=t;
    }

    public int[] calculateAverages() {
        int[] avg = new int[7];
        avg[0] = stats[0];
        for (int i = 1; i <= 7; i++)
            avg[i] = stats[i]/stats[0];
        return avg;
    }
}
