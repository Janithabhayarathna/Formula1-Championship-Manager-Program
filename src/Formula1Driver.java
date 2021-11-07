public class Formula1Driver extends Driver {

    private int season;
    private int position1;
    private int position2;
    private int position3;
    private String instances;
    private int points;
    private int numOfRaces;

    public Formula1Driver(String driverName, String location, String teamName, String stats) {

        super(driverName, location, teamName, stats);
    }

    private int[] pointsList = {25,188,15,12,10,8,6,4,2,1};
}
