import java.util.Scanner;

public class Formula1ChampionshipManager extends ChampionshipManager {

    private int noOfDrivers;

    public static void main(String[] args) {

        System.out.println("Option Menu");
        System.out.println("1 or CND: Create a New Driver.");
        System.out.println("2 or DTD: Delete The Driver.");
        System.out.println("3 or CTC: Change The Constructor of the driver.");
        System.out.println("4 or DSD: Display the Stats of the Driver.");
        System.out.println("5 or DDT: Display the Driver Table.");
        System.out.println("6 or ASR: Add Stats of a completed Race.");
        System.out.println("7 or CER: Change the existing records.");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the option you want: ");
        String option = input.nextLine().toUpperCase();

        switch (option) {

            case "1":
            case "CND":

        }
    }
}
