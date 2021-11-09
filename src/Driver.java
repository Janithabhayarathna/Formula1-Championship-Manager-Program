public abstract class Driver {

    private String driverName;
    private String location;
    private String teamName;

    public Driver (String driverName, String location, String teamName) {

        this.driverName = driverName;
        this.location = location;
        this.teamName = teamName;
    }

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

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
