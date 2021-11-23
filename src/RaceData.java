import java.util.ArrayList;

public class RaceData {

    private String dateOfRace;
    private String[] place;

    public RaceData(String dateOfRace, String[] place) {

        this.dateOfRace = dateOfRace;
        this.place = place;
    }

    public String[] getPlace() {
        return place;
    }

    public void setPlace(String[] place) {
        this.place = place;
    }

    public String getDateOfRace() {

        return dateOfRace;
    }

    public void setDateOfRace(String dateOfRace) {

        this.dateOfRace = dateOfRace;
    }

}
