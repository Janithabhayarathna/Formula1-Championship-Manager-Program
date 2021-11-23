import java.util.Collections;
import java.util.Scanner;

public class RandomRace {

    Scanner input = new Scanner(System.in);
    String[] newPositions = new String[20];

    public  void randomRace() {
        
        System.out.println("Enter the date of race: (dd/mm/yyyy)");
        String randomDate = "";
        for (int i = 0; i < Formula1ChampionshipManager.drivers.size(); i++) {
            Collections.shuffle(Formula1ChampionshipManager.drivers);
            newPositions[i] = Formula1ChampionshipManager.drivers.get(i).getDriverName();
            Formula1ChampionshipManager.drivers.get(i).setNumOfRaces(1);
            if (i == 0) {
                Formula1ChampionshipManager.drivers.get(i).setPosition1(1);
            } else if (i == 1) {
                Formula1ChampionshipManager.drivers.get(i).setPosition2(1);
            } else if (i == 2) {
                Formula1ChampionshipManager.drivers.get(i).setPosition3(1);
            }
        }
        Formula1ChampionshipManager.races.add(new RaceData(randomDate, newPositions));
        System.out.println("✔ Random race statistics successfully added.");
    }

}
