import java.util.ArrayList;

public class Race {

    private String dateOfRace;
    private String[] place;

    public Race(String dateOfRace, String[] place) {

        this.dateOfRace = dateOfRace;
        this.place = place;
    }

    public String getDateOfRace() {
        return dateOfRace;
    }

    public void setDateOfRace(String dateOfRace) {
        this.dateOfRace = dateOfRace;
    }

}
