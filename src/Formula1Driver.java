import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable, Comparable<Formula1Driver> {

    private int position1;
    private int position2;
    private int position3;
    private int points;
    private int numOfRaces;


    public Formula1Driver(String driverName, String location, String teamName, int position1, int position2, int position3, int points, int numOfRaces) {

        super(driverName, location, teamName);
        this.position1 = position1;
        this.position2 = position2;
        this.position3 = position3;
        this.points = points;
        this.numOfRaces = numOfRaces;
    }

    public int getPosition1() {
        return position1;
    }

    public void setPosition1(int position1) {
        this.position1 += position1;
    }

    public int getPosition2() {
        return position2;
    }

    public void setPosition2(int position2) {
        this.position2 += position2;
    }

    public int getPosition3() {
        return position3;
    }

    public void setPosition3(int position3) {
        this.position3 += position3;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getNumOfRaces() {
        return numOfRaces;
    }

    public void setNumOfRaces(int numOfRaces) {
        this.numOfRaces += numOfRaces;
    }

    @Override
    public int compareTo(Formula1Driver com) {
        if (com.getPoints() == this.points) {
            return com.position1 - this.position1;
        }
        else {
            return com.getPoints() - this.points;
        }
    }

}
