import java.util.ArrayList;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {

    private static int noOfDrivers;
    private static int noOfCars;
    public static ArrayList<Formula1Driver> drivers = new ArrayList<Formula1Driver>();
    public static Scanner input = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        menu();
    }

    public static void menu() {

        while (true) {
            System.out.println("Option Menu");
            System.out.println("1 or CND: Create a New Driver.");
            System.out.println("2 or DAD: Delete a Driver.");
            System.out.println("3 or CTD: Change the Team of a Driver.");
            System.out.println("4 or DSD: Display the Stats of the Driver.");
            System.out.println("5 or DDT: Display the Driver Table.");
            System.out.println("6 or ASR: Add Stats of a completed Race.");
            System.out.println("7 or EXT: Exit from the program.");

            Scanner input1 = new Scanner(System.in);
            System.out.print("Enter the option you want: ");
            String option = input1.next().toUpperCase();

            switch (option) {

                case "1":
                case "CND":
                    createDriver();
                    break;

                case "2":
                case "DAD":
                    deleteDriver();
                    break;

                case "3":
                case "CTD":
                    changeTeam();
                    break;

                case "4":
                case "DSD":
                    displayStats();
                    break;

                case "5":
                case "DDT":
                    //.

                case "6":
                case "ASR":
                    //.

                case "7":
                case "EXT":
                    //.

                default:
                    System.out.println("Please check the input and try again!");
            }
        }
    }

    public static void createDriver() {

        Scanner input2 = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter the name of the driver: ");
        String driverName = checkDriverUniqueness(input2.next());
        System.out.print("Enter the driver's location: ");
        String location = input2.next();
        System.out.print("Enter the team name of the driver: ");
        String teamName = checkTeamUniqueness(input2.next());
        System.out.print("Enter the number of 1st positions of the driver: ");
        int position1 = input2.nextInt();
        System.out.print("Enter the number of 2nd positions of the driver: ");
        int position2 = input2.nextInt();
        System.out.print("Enter the number of 3rd positions of the driver: ");
        int position3 = input2.nextInt();
        System.out.print("Enter number of points of the driver: ");
        int points = input2.nextInt();
        System.out.print("Enter the number of races that have been participated by the driver: ");
        int numOfRaces = input2.nextInt();

        drivers.add(new Formula1Driver(driverName, location, teamName, position1, position2, position3, points, numOfRaces));
        noOfDrivers++;
        noOfCars++;
    }

    public static String checkDriverUniqueness(String name) {

        String duplicate = "Driver name already exist";
        for (Formula1Driver x : drivers) {
            if (x.getDriverName().equals(name)) {
                return duplicate;
            }
        }
        return input.next();
    }

    public static String checkTeamUniqueness(String team) {

        String duplicate = "Team name already exist";
        for (Formula1Driver y : drivers) {
            if (y.getTeamName().equals(team)) {
                return duplicate;
            }
        }
        return input.next();
    }

    public static void deleteDriver() {

        Scanner input3 = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the name of the driver that you want to delete: ");
        String delDriverName = input3.nextLine();

        for(Formula1Driver y : drivers) {
            if(y.getDriverName().equals(delDriverName)) {
                System.out.println("Driver " + y.getDriverName() + " successfully removed.");
                System.out.println("Team " + y.getTeamName() + " successfully removed.");
                drivers.remove(delDriverName);
            }
            else {
                System.out.println("Please enter a correct driver name.");
            }
        }
        noOfDrivers--;
    }

    public static void changeTeam() {

        Scanner input4 = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter the Team name that need to change the driver : ");
        String changeDriver = input4.next();

        for (Formula1Driver z : drivers) {
            if (z.getTeamName().equals(changeDriver)) {
                System.out.print("Enter the preferred new drivers name: ");
                String newDriver = checkDriverUniqueness(input4.next());
                System.out.println(z.getTeamName() + "'s team driver changed as, " + newDriver);
                z.setDriverName(newDriver);
            }
        }
    }

    public static void displayStats() {

        Scanner input5 = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the Name of the driver, that need to display statistics: ");
        String statDriver = input5.next();

        for(Formula1Driver y : drivers) {
            if(y.getDriverName().equals(statDriver)) {
                System.out.println(y.getDriverName());
                System.out.println("Mr. " + y.getDriverName() + "'s location - " + y.getLocation());
                System.out.println("Mr. " + y.getDriverName() + "'s team name - " + y.getTeamName());
                System.out.println("Mr. " + y.getDriverName() + "'s no of 1st places - " + y.getPosition1());
                System.out.println("Mr. " + y.getDriverName() + "'s no of 2nd places - " + y.getPosition2());
                System.out.println("Mr. " + y.getDriverName() + "'s no of 3rd places - " + y.getPosition3());
                System.out.println("Mr. " + y.getDriverName() + "'s no of points - " + y.getPoints());
                System.out.println("Mr. " + y.getDriverName() + "'s no of races - " + y.getNumOfRaces());
            }
            else {
                System.out.println("Please enter a correct driver name.");
            }

        }
    }

    public void driverTable() {


    }

    public void addRace() {


    }

    public void exit() {

        System.out.println("Thank you for using Formula 1 Championship Manager Program'. \n                  Stay safe!");
        System.exit(0);
    }
}
