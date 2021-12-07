import java.io.Serializable;

public class RaceData implements Serializable{

    private final String dateOfRace;  // Date of the race.
    private final String[] place;  // Used to store places in the race.

    /**
     * @param dateOfRace - Date of the race
     * @param place - Array that contain places of the race
     */
    public RaceData(String dateOfRace, String[] place) {
        // RaceData Constructor.

        this.dateOfRace = dateOfRace;
        this.place = place;
    }

    // Setters and getters.

    public String[] getPlace() {

        return place;
    }

    public String getDateOfRace() {

        return dateOfRace;
    }

}
