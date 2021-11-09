public class Formula1Driver extends Driver {

    private int season;
    private int position1;
    private int position2;
    private int position3;
    private int points;
    private int numOfRaces;

    public Formula1Driver(String driverName, String location, String teamName) {

        super(driverName, location, teamName);
    }

    private int[] pointsScheme = {0, 25,18,15,12,10,8,6,4,2,1};

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getPosition1() {
        return position1;
    }

    public void setPosition1(int position1) {
        this.position1 = position1;
    }

    public int getPosition2() {
        return position2;
    }

    public void setPosition2(int position2) {
        this.position2 = position2;
    }

    public int getPosition3() {
        return position3;
    }

    public void setPosition3(int position3) {
        this.position3 = position3;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNumOfRaces() {
        return numOfRaces;
    }

    public void setNumOfRaces(int numOfRaces) {
        this.numOfRaces = numOfRaces;
    }

}
