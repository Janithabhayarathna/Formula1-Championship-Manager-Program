import java.util.Comparator;

public class Formula1Driver extends Driver implements Comparable<Formula1Driver> {

    private int position1;
    private int position2;
    private int position3;
    private int points;
    private int numOfRaces;

    // Formula1Driver constructor.
    public Formula1Driver(String driverName, String location, String teamName, int position1, int position2, int position3, int points, int numOfRaces) {

        super(driverName, location, teamName);  // Accessing the super class constructor(Driver).
        this.position1 = position1;
        this.position2 = position2;
        this.position3 = position3;
        this.points = points;
        this.numOfRaces = numOfRaces;
    }

    // Setters and getters.

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


    /**
     * @param com
     * @return
     */
    @Override
    public int compareTo(Formula1Driver com) {  // Used to sort drivers on points in descending order.
        if (com.getPoints() == this.points) {
            return com.position1 - this.position1;
        }
        else {
            return com.getPoints() - this.points;
        }
    }


    // Used to sort drivers in points in ascending order.
    public static Comparator<Formula1Driver> ascendingOnPoint = new Comparator<Formula1Driver>(){

        @Override
        public int compare(Formula1Driver driver1,Formula1Driver driver2) {

            int point1 = driver1.getPoints();
            int point2 = driver2.getPoints();
            return point1 - point2;
        }
    };


    // Used to sort drivers in points in descending order on number of 1st positions.
    public static Comparator<Formula1Driver> descendingOnPosition1 = new Comparator<Formula1Driver>(){

        @Override
        public int compare(Formula1Driver driver1,Formula1Driver driver2) {

            int position1 = driver1.getPosition1();
            int position2 = driver2.getPosition1();
            return position2 - position1;
        }
    };

}
