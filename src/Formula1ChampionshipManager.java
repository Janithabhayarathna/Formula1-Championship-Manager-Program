import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {

    private int noOfDrivers;
    private int noOfCars;
    public ArrayList<Formula1Driver> drivers = new ArrayList<Formula1Driver>();
    public Scanner input = new Scanner(System.in).useDelimiter("\n");
    String driverName;
    String location;
    String teamName;
    int position1;
    int position2;
    int position3;
    int points;
    int numOfRaces;

    public static void main(String[] args) {

        Formula1ChampionshipManager random = new Formula1ChampionshipManager();
        random.menu();
    }

    public void menu() {

        while (true) {
            System.out.println(" ");
            System.out.println("****************** Option Menu ********************");
            System.out.println("---------------------------------------------------");
            System.out.println("   1 or CND: Create a New Driver.");
            System.out.println("   2 or DAD: Delete a Driver.");
            System.out.println("   3 or CDT: Change the Driver of a Team.");
            System.out.println("   4 or DSD: Display the Statistics of a Driver.");
            System.out.println("   5 or DDT: Display the Driver Table.");
            System.out.println("   6 or ASR: Add Statistics of a completed Race.");
            System.out.println("   7 or EXT: Exit from the program.");
            System.out.println("---------------------------------------------------");

            System.out.println(" ");
            System.out.print("Enter the option you want: ");
            String option = input.next().toUpperCase();

            switch (option) {

                case "1":
                case "CND":
                    System.out.println(" ");
                    System.out.println("_ Create a new driver method _");
                    System.out.println(" ");
                    createDriver();
                    break;

                case "2":
                case "DAD":
                    System.out.println(" ");
                    System.out.println("_ Delete a driver option _");
                    System.out.println(" ");
                    deleteDriver();
                    break;

                case "3":
                case "CDT":
                    System.out.println(" ");
                    System.out.println("_ Change the driver of a team option _");
                    System.out.println(" ");
                    changeTeam();
                    break;

                case "4":
                case "DSD":
                    System.out.println(" ");
                    System.out.println("_ Display statistics of a driver option _");
                    System.out.println(" ");
                    displayStats();
                    break;

                case "5":
                case "DDT":
                    System.out.println(" ");
                    System.out.println("_ Display the driver table option _");
                    System.out.println(" ");
                    driverTable();
                    break;

                case "6":
                case "ASR":
                    System.out.println(" ");
                    System.out.println("_ Add Statistics of a completed race option _");
                    System.out.println(" ");
                    addRace();
                    break;

                case "7":
                case "EXT":
                    System.out.println(" ");
                    exit();
                    break;

                default:
                    System.out.println("Please check the input and try again!");
                    System.out.println(" ");
            }
        }
    }

    public void createDriver() {

        System.out.print("Enter the name of the driver: ");
        if ((input.hasNext()) && (checkDriverUniqueness(input.next()))) {
             driverName = input.next().toLowerCase(Locale.ROOT);
        }
        else {
            System.out.println("Please enter a valid driver name!");
        }
        System.out.print("Enter the driver's location: ");
        if (input.hasNext()) {
            location = input.next().toLowerCase();
        }
        else {
            System.out.println("Please enter a valid driver location!");
        }
        System.out.print("Enter the team name of the driver: ");
        if ((input.hasNext()) && (checkTeamUniqueness(input.next()))) {
            teamName = input.next().toLowerCase(Locale.ROOT);
        }
        else {
            System.out.println("Team is already exist.");
        }
        System.out.print("Enter the number of 1st positions of the driver: ");
        if (input.hasNextInt() && input.nextInt() >0) {
            position1 = input.nextInt();
        }
        else {
            System.out.println("Please give a valid input!");
        }
        System.out.print("Enter the number of 2nd positions of the driver: ");
        if (input.hasNextInt() && input.nextInt() >0) {
            position2 = input.nextInt();
        }
        else {
            System.out.println("Please give a valid input!");
        }
        System.out.print("Enter the number of 3rd positions of the driver: ");
        if (input.hasNextInt() && input.nextInt() >0) {
            position3 = input.nextInt();
        }
        else {
            System.out.println("Please give a valid input!");
        }
        System.out.print("Enter number of points of the driver: ");
        if (input.hasNextInt()) {
            points = input.nextInt();
        }
        else {
            System.out.println("Please enter a valid input!");
        }
        System.out.print("Enter the number of races that have been participated by the driver: ");
        if (input.hasNextInt() && input.nextInt() >0) {
            numOfRaces = input.nextInt();
        }
        else {
            System.out.println("Please enter a valid input!");
        }

        drivers.add(new Formula1Driver(driverName, location, teamName, position1, position2, position3, points, numOfRaces));
        noOfDrivers++;
        noOfCars++;
    }

    public boolean checkDriverUniqueness(String name) {

        for (Formula1Driver x : drivers) {
            if (x.getDriverName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDriverAvailability(String name) {

        for (Formula1Driver x : drivers) {
            if (x.getDriverName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTeamUniqueness(String team) {

        for (Formula1Driver y : drivers) {
            if (y.getTeamName().equals(team)) {
                return false;
            }
        }
        return true;
    }

    public void deleteDriver() {

        System.out.println("Enter the name of the driver that you want to delete: ");
        if((input.hasNext()) && (checkDriverAvailability(input.next()))) {
            String delDriverName = input.next();
            for(Formula1Driver y : drivers) {
                if(y.getDriverName().equals(delDriverName)) {
                    System.out.println("Driver " + y.getDriverName() + " successfully removed.");
                    System.out.println("Team " + y.getTeamName() + " successfully removed.");
                    drivers.remove(delDriverName);
                }
            }
        }
        else {
            System.out.println("Please enter a valid driver name.");
        }
        noOfDrivers--;
        noOfCars--;
    }

    public void changeTeam() {

        System.out.print("Enter the Team name that need to change the driver : ");
        String changeDriver = input.next();
        for (Formula1Driver z : drivers) {
            if (z.getTeamName().equals(changeDriver)) {
                System.out.print("Enter the preferred new drivers name: ");
                if ((checkTeamUniqueness(input.next())) && (input.hasNext())) {
                    String newDriver = input.next();
                    System.out.println(z.getTeamName() + "'s team driver changed as, " + newDriver);
                    z.setDriverName(newDriver);
                    drivers.remove(changeDriver);
                }else {
                    System.out.println("Driver is already exist.");
                }
            }
        }
    }

    public void displayStats() {

        System.out.println("Enter the Name of the driver, that need to display statistics: ");
        String statDriver = input.next();
        for(Formula1Driver y : drivers) {
            if (y.getDriverName().equals(statDriver)) {
                System.out.println("Mr. " + y.getDriverName());
                System.out.println("Mr. " + y.getDriverName() + "'s location - " + y.getLocation());
                System.out.println("Mr. " + y.getDriverName() + "'s team name - " + y.getTeamName());
                System.out.println("Mr. " + y.getDriverName() + "'s no of 1st places - " + y.getPosition1());
                System.out.println("Mr. " + y.getDriverName() + "'s no of 2nd places - " + y.getPosition2());
                System.out.println("Mr. " + y.getDriverName() + "'s no of 3rd places - " + y.getPosition3());
                System.out.println("Mr. " + y.getDriverName() + "'s no of points - " + y.getPoints());
                System.out.println("Mr. " + y.getDriverName() + "'s no of races - " + y.getNumOfRaces());
            }
        }
    }

    public void driverTable() {


    }

    public void addRace() {

        if (drivers.size() > 1) {
            for (int i = 0; i < drivers.size(); i++) {
                System.out.print("Enter the drivers name who got the" + i + 1 + " place of the race: ");
                String place = input.next();

                //            System.out.println("Enter the drivers name who got the 1st place of the race: ");
                //            String driver1 = input.next();
                //            System.out.println("Enter the drivers name who got the 2nd place of the race: ");
                //            String driver2 = input.next();
                //            System.out.println("Enter the drivers name who got the 3rd place of the race: ");
                //            String driver3 = input.next();
                //            System.out.println("Enter the drivers name who got the 4th place of the race: ");
                //            String driver4 = input.next();
                //            System.out.println("Enter the drivers name who got the 5th place of the race: ");
                //            String driver5 = input.next();
                //            System.out.println("Enter the drivers name who got the 6th place of the race: ");
                //            String driver6 = input.next();
                //            System.out.println("Enter the drivers name who got the 7th place of the race: ");
                //            String driver7 = input.next();
                //            System.out.println("Enter the drivers name who got the 8th place of the race: ");
                //            String driver8 = input.next();
                //            System.out.println("Enter the drivers name who got the 9th place of the race: ");
                //            String driver9 = input.next();
                //            System.out.println("Enter the drivers name who got the 10st place of the race: ");
                //            String driver10 = input.next();
            }
        }else {
            System.out.println("Invalid number of drivers/cars/constructors. (Only " + drivers.size() + "teams are added.) Please add at least 2 drivers to use this function.");
        }
    }

    public void exit() {

        System.out.println("Thank you for using Formula 1 Championship Manager Program'. \n                  Stay safe!");
        System.exit(0);
    }
}
