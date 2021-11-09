import java.util.ArrayList;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {

    private int noOfDrivers;
    private int noOfCars;
    public static ArrayList<Formula1Driver> drivers = new ArrayList<Formula1Driver>();
    public static ArrayList<Formula1Driver> teams = new ArrayList<Formula1Driver>();

    public static void main(String[] args) {


    }

    public static void menu() {

        System.out.println("Option Menu");
        System.out.println("1 or CND: Create a New Driver.");
        System.out.println("2 or DAD: Delete a Driver.");
        System.out.println("3 or CTD: Change the Team of a Driver.");
        System.out.println("4 or DSD: Display the Stats of the Driver.");
        System.out.println("5 or DDT: Display the Driver Table.");
        System.out.println("6 or ASR: Add Stats of a completed Race.");
        System.out.println("7 or STR: Save The Records.");
        System.out.println("8 or EXT: Exit from the program.");

        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter the option you want: ");
        String option = input1.nextLine().toUpperCase();

        switch (option) {

            case "1":
            case "CND":
                createDriver();

            case "2":
            case  "DAD":
                //.

            case "3":
            case  "CTD":
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
            case  "STR":
                //.

            case "8":
            case  "EXT":
                //.
        }
    }

    public static void createDriver() {

        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter the name of the driver: ");
        String driverName = input2.nextLine();
        System.out.print("Enter the driver's location: ");
        String location = input2.nextLine();
        System.out.print("Enter the team name of the driver: ");
        for(Driver x : drivers) {
            if (x.getTeamName().equals(input2.nextLine())) {
                System.out.println("Please check the input again. Team name already exist.");
            }
            else {
                String teamName = input2.nextLine();
            }
        }

        drivers.add(new Formula1Driver(driverName, location, teamName));
    }

    public static void deleteDriver() {

        Scanner input3 = new Scanner(System.in);
        System.out.println("Enter the name of the driver that you want to delete: ");
        String delDriverName = input3.nextLine();

        for(Driver driverName : drivers) {

            if(driverName.getDriverName().equals(delDriverName)) {
                System.out.println("Driver " + driverName.getDriverName() + " successfully removed");
                drivers.remove(delDriverName);
            }
            else {
                System.out.println("Please enter a correct driver name.");
            }

        }
    }

    public static void changeTeam() {


    }

    public static void displayStats() {


    }

    public static void driverTable() {


    }

    public static void addRace() {


    }

    public static void saveData() {


    }

    public static void exit() {


    }
}
