import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {

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
        System.out.println("8 or EXT: Exit from the program.");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the option you want: ");
        String option = input.nextLine().toUpperCase();

        switch (option) {

            case "1":
            case "CND":
                createDriver();

            case "2":
            case  "DTD":
                //.

            case "3":
            case  "CTC":
                //.

            case "4":
            case  "DSD":
                //.

            case "5":
            case  "DDT":
                //.

            case "6":
            case  "ASR":
                //.

            case "7":
            case  "CER":
                //.

            case "8":
            case  "EXT":
                //.
        }
    }

    public static void createDriver() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the driver: ");
        String driverName = input.nextLine();
        System.out.print("Enter the driver's location: ");
        String location = input.nextLine();
        System.out.print("Enter the team name of the driver: ");
        String teamName = input.nextLine();
        System.out.print("Enter the stats of the driver: ");

        Formula1Driver
    }
}
