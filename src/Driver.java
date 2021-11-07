public abstract class Driver {

    private String driverName;
    private String location;
    private String teamName;
    private String stats;

    public Driver (String driverName, String location, String teamName, String stats) {

        this.driverName = driverName;
        this.location = location;
        this.teamName = teamName;
        this.stats = stats;
    }
}
