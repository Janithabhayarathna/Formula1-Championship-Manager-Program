import java.io.Serializable;

// Abstract class
public abstract class Driver implements Serializable {

    private String driverName;
    private String location;
    private String teamName;

    public Driver (String driverName, String location, String teamName) {
        // Driver class constructor.

        this.driverName = driverName;
        this.location = location;
        this.teamName = teamName;
    }


    // Setters and getters.

    public String getDriverName() {

        return driverName;
    }

    public void setDriverName(String driverName) {

        this.driverName = driverName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeamName() {
        return teamName;
    }

}
