import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager {

    public int noOfDrivers;
    public int noOfCars;
    public ArrayList<Formula1Driver> drivers = new ArrayList<Formula1Driver>();
    public int[] pointsScheme = {25,18,15,12,10,8,6,4,2,1};
    public Scanner input = new Scanner(System.in).useDelimiter("\n");
    String driverName; String location; String teamName; int position1; int position2; int position3; int points; int numOfRaces;


    public static void main(String[] args) {

        Formula1ChampionshipManager random = new Formula1ChampionshipManager();
        random.menu();
    }

    public void menu() {

        while (true) {
            System.out.println(" ");
            System.out.println("******************* Option Menu ********************");
            System.out.println("----------------------------------------------------");
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
            System.out.println("Please check the driver table. Driver already exist!");
        }
        System.out.print("Enter the driver's location: ");
        location = input.next().toLowerCase();
        System.out.print("Enter the team name of the driver: ");
        if ((input.hasNext()) && (checkTeamUniqueness(input.next()))) {
            teamName = input.next().toLowerCase(Locale.ROOT);
        }
        else {
            System.out.println("Team already exist.");
        }
        System.out.print("Enter the number of 1st positions of the driver: ");
        if ((input.hasNextInt()) && (input.nextInt() >0)) {
            position1 = input.nextInt();
        }
        else {
            System.out.println("Please give a valid input!");
        }
        System.out.print("Enter the number of 2nd positions of the driver: ");
        if ((input.hasNextInt()) && (input.nextInt() >0)) {
            position2 = input.nextInt();
        }
        else {
            System.out.println("Please give a valid input!");
        }
        System.out.print("Enter the number of 3rd positions of the driver: ");
        if ((input.hasNextInt()) && (input.nextInt() >0)) {
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
        if ((input.hasNextInt()) && (input.nextInt() >0)) {
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

    public boolean checkTeamAvailability(String team) {

        for (Formula1Driver y : drivers) {
            if (y.getTeamName().equals(team)) {
                return true;
            }
        }
        return false;
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
            System.out.println("Driver name not found! Please enter a valid driver name.");
        }
        noOfDrivers--;
        noOfCars--;
    }

    public void changeTeam() {

        System.out.print("Enter the Team name that need to change the driver : ");
        if ((input.hasNext()) && (checkTeamAvailability(input.next()))){
            String changeDriver = input.next();
            for (Formula1Driver z : drivers) {
                if (z.getTeamName().equals(changeDriver)) {
                    System.out.print("Enter the preferred new drivers name: ");
                    if ((checkTeamUniqueness(input.next())) && (input.hasNext())) {
                        String newDriver = input.next();
                        System.out.println(z.getTeamName() + "'s team driver changed as, " + newDriver);
                        z.setDriverName(newDriver);
                        drivers.remove(changeDriver);
                    } else {
                        System.out.println("Driver already exist.");
                    }
                }
            }
        }
        else {
            System.out.println("Team name not found! Please check the team name and try again.");
        }
    }

    public void displayStats() {

        System.out.println("Enter the Name of the driver, that need to display statistics: ");
        if ((input.hasNext()) && (checkDriverAvailability(input.next()))) {
            String statDriver = input.next();
            for (Formula1Driver y : drivers) {
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
        }else {
            System.out.println("Driver not found! Please check the driver name and try again.");
        }
    }

    public void driverTable() {

        Collections.sort(drivers);
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("|  Drivers  |  Team Name  | Location  |  No. of Races  |  Points  |  1st places |  2nd places  |  3rd places  |");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (Formula1Driver l : drivers) {
            System.out.printf("| %10d | %10d | %10d | %5d | %5d | %5d | %5d | %5d |", l.getDriverName(), l.getTeamName(), l.getNumOfRaces(), l.getPoints(), l.getPosition1(), l.getPosition2(), l.getPosition3());
        }
    }

    public void addRace() {

        if (drivers.size() > 1) {
            for (int i = 0; i < drivers.size(); i++) {
                System.out.print("Enter the drivers name who got the" + i + 1 + " place of the race: ");
                if ((input.hasNext()) && (checkDriverAvailability(input.next()))) {
                    String place = input.next();
                    for (Formula1Driver r : drivers) {
                        if (r.getDriverName().equals(place)) {
                            r.setNumOfRaces(+1);
                            r.setPoints(+pointsScheme[i+1]);
                            if (i == 0) {
                                r.setPosition1(+1);
                            }else if(i == 1) {
                                r.setPosition2(+1);
                            } else if (i == 2) {
                                r.setPosition3(+1);
                            }
                        }
                    }
                }else {
                    System.out.println("Driver not found! Please check the driver name and try again.");
                }
            }
        }else {
            System.out.println("Invalid number of drivers/cars/constructors. (Only " + drivers.size() + "teams are added.) Please add at least 2 drivers to use this function.");
        }
    }

    public void saveData() {

        try {
            FileWriter writer = new FileWriter("Championship Details");
            writer.write(String.valueOf(drivers));
            writer.close();
            System.out.println("Successfully stored data into the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred while storing data into the file. Please try again.");
            e.printStackTrace();
        }
    }

    public void exit() {

        System.out.println("Thank you for using Formula 1 Championship Manager Program'. \n                  Stay safe!");
        System.exit(0);
    }
}
