import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Formula1ChampionshipManager implements ChampionshipManager {

    public int noOfDrivers;
    public int noOfCars;
    public ArrayList<Formula1Driver> drivers = new ArrayList<Formula1Driver>();
    public ArrayList<String> dates = new ArrayList<String>();
    public int[] pointsScheme = {25,18,15,12,10,8,6,4,2,1,0,0,0,0,0,0,0,0,0,0};
    public Scanner input = new Scanner(System.in).useDelimiter("\n");
    String driverName; String location; String teamName; int position1; int position2; int position3; int points; int numOfRaces;


    public static void main(String[] args) {

        Formula1ChampionshipManager random = new Formula1ChampionshipManager();
        random.loadData();
        System.out.println(" ");
        System.out.println("\t 🎇 Welcome to the Formula 1 Championship Manager Program. 🎇");
        random.menu();
    }

    public void menu() {

        while (true) {

            System.out.println(" ");
            System.out.println("\t -----------------------------------------------------");
            System.out.println("\t|******************** Option Menu ********************|");
            System.out.println("\t -----------------------------------------------------");
            System.out.println("\t|   1 or CND: Create a New Driver.                    |");
            System.out.println("\t|   2 or DAD: Delete a Driver.                        |");
            System.out.println("\t|   3 or CDT: Change the Driver of a Team.            |");
            System.out.println("\t|   4 or DSD: Display the Statistics of a Driver.     |");
            System.out.println("\t|   5 or DDT: Display the Driver Table.               |");
            System.out.println("\t|   6 or ASR: Add Statistics of a completed Race.     |");
            System.out.println("\t|   7 or EXT: Exit from the program.                  |");
            System.out.println("\t -----------------------------------------------------");
            System.out.println("\t 🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️");

            System.out.println(" ");
            System.out.print("Enter the option you want: ");
            String option = input.next().toUpperCase();

            switch (option) {

                case "1":
                case "CND":
                    System.out.println(" ");
                    System.out.println("\t\t 🏎️ _ Create a new driver option _ 🏎️");
                    createDriver();
                    break;

                case "2":
                case "DAD":
                    System.out.println(" ");
                    System.out.println("\t\t 🏎️ _ Delete a driver option _ 🏎️");
                    deleteDriver();
                    break;

                case "3":
                case "CDT":
                    System.out.println(" ");
                    System.out.println("\t\t 🏎️ _ Change the driver of a team option _ 🏎️");
                    changeTeam();
                    break;

                case "4":
                case "DSD":
                    System.out.println(" ");
                    System.out.println("\t\t 🏎️ _ Display statistics of a driver option _ 🏎️");
                    displayStats();
                    break;

                case "5":
                case "DDT":
                    System.out.println(" ");
                    System.out.println("\t\t\t\t\t\t 🏎️ _ Display the driver table option _ 🏎️");
                    driverTable();
                    break;

                case "6":
                case "ASR":
                    System.out.println(" ");
                    System.out.println("\t\t 🏎️ _ Add Statistics of a completed race option _ 🏎️");
                    addRace();
                    break;

                case "7":
                case "EXT":
                    System.out.println(" ");
                    exit();
                    break;

                default:
                    System.out.println(" Please check the input and try again! Refer the option menu.");
                    System.out.println(" ");
            }
        }
    }

    public void createDriver() {

        while(true) {

            instructions();
            availableDrivers();
            System.out.print("Enter the name of the driver: ");
            driverName = input.next().toLowerCase();
            if (checkDriverUniqueness(driverName)) {
                availableTeams();
                System.out.print("Enter the team name of the driver: ");
                teamName = input.next().toLowerCase();
                if (checkTeamUniqueness(teamName)) {
                    System.out.print("Enter the driver's location: ");
                    location = input.next();
                    System.out.print("Enter the number of 1st positions achieved by the driver: ");
                    if (input.hasNextInt()) {
                        position1 = input.nextInt();
                        if (positionValidator(position1)) {
                            System.out.print("Enter the number of 2nd positions achieved by the driver: ");
                            if (input.hasNextInt()) {
                                position2 = input.nextInt();
                                if (positionValidator(position2)) {
                                    System.out.print("Enter the number of 3rd positions achieved by the driver: ");
                                    if (input.hasNextInt()) {
                                        position3 = input.nextInt();
                                        if (positionValidator(position3)) {
                                            System.out.print("Enter number of points of the driver: ");
                                            if (input.hasNextInt()) {
                                                points = input.nextInt();
                                                System.out.print("Enter the number of races that have been participated by the driver: ");
                                                if (input.hasNextInt()) {
                                                    numOfRaces = input.nextInt();
                                                    break;

                                                } else {
                                                    System.out.println("Invalid input! Please enter a correct input and try again.");
                                                    System.out.println(" ");
                                                    input.next();
                                                    menu();
                                                    break;
                                                }
                                            } else {
                                                System.out.println("Invalid input! Please enter a correct input and try again.");
                                                System.out.println(" ");
                                                input.next();
                                                menu();
                                            }
                                        } else {
                                            System.out.println("Invalid input! Please enter a correct input and try again.");
                                            System.out.println(" ");
                                            input.next();
                                            menu();
                                        }
                                    } else {
                                        System.out.println("Invalid input! Please enter a correct input and try again.");
                                        System.out.println(" ");
                                        input.next();
                                        menu();
                                    }
                                } else {
                                    System.out.println("Invalid input! Please enter a correct input and try again.");
                                    System.out.println(" ");
                                    input.next();
                                    menu();
                                }
                            } else {
                                System.out.println("Invalid input! Please enter a correct input and try again.");
                                System.out.println(" ");
                                input.next();
                                menu();
                            }
                        } else {
                            System.out.println("Invalid input! Please enter a correct input and try again.");
                            System.out.println(" ");
                            input.next();
                            menu();
                        }
                    } else {
                        System.out.println("Invalid input! Please enter a correct input and try again.");
                        System.out.println(" ");
                        input.next();
                        menu();
                    }
                } else {
                    System.out.println("Team already exists! Please check the input and try again.");
                    instructions();
                    System.out.println(" ");
                    input.next();
                    menu();
                }
            } else {
                System.out.println("Driver already exist! Please check the input and try again.");
                instructions();
                System.out.println(" ");
                input.next();
                menu();
                break;
            }
        }
            System.out.println("✔ Driver " + driverName + " successfully added.");
            System.out.println("-----------------------------------------------------------------------------------");
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

    public boolean positionValidator(int position) {

        if (position>=0) {
            return true;
        }
        return false;
    }

    public void deleteDriver() {

        availableDrivers();
        System.out.print("Enter the name of the driver that you want to delete: ");
        if (input.hasNext()) {
            String delDriverName = input.next();
            if (checkDriverAvailability(delDriverName)) {
                for (int i =0; i<drivers.size(); i++) {
                    if(drivers.get(i).getDriverName().equals(delDriverName)) {
                        System.out.println("Driver " + drivers.get(i).getDriverName() + " successfully removed.");
                        System.out.println("Team " + drivers.get(i).getTeamName() + " also successfully removed.");
                        drivers.remove(i);
                    }
                }
            } else {
                System.out.println("Driver name not found! Please check the input and try again.");
            }
        }
        else {
            System.out.println("Please enter a valid driver name.");
        }
        noOfDrivers--;
        noOfCars--;
    }

    public void changeTeam() {

        availableTeams();
        System.out.print("Enter the Team name that need to change the driver : ");
        if (input.hasNext()) {
            String changeDriver = input.next();
            if (checkTeamAvailability(changeDriver)) {
                for (Formula1Driver z : drivers) {
                    if (z.getTeamName().equals(changeDriver)) {
                        instructions();
                        availableDrivers();
                        System.out.print("Enter the preferred new driver's name: ");
                        String newDriver = input.next();
                        if (checkDriverUniqueness(newDriver)) {
                            System.out.println(z.getTeamName() + "'s team driver changed as, " + newDriver);
                            z.setDriverName(newDriver);
                        } else{
                            System.out.println("Driver already exist! Please check the input and try again.");
                        }
                    }
                }
            } else {
                System.out.println("Team not found! Please check the input and try again.");
            }
        }
        else {
            System.out.println("Invalid input!");
        }
    }

    public void displayStats() {

        availableDrivers();
        System.out.print("Enter the Name of the driver, that need to display statistics: ");
        if (input.hasNext()) {
            String statDriver = input.next();
            if (checkDriverAvailability(statDriver)) {
                for (Formula1Driver y : drivers) {
                    if (y.getDriverName().equals(statDriver)) {
                        System.out.println("______________ Mr. " + y.getDriverName() + " ___________________");
                        System.out.println("Mr. " + y.getDriverName() + "'s location - " + y.getLocation());
                        System.out.println("Mr. " + y.getDriverName() + "'s team name - " + y.getTeamName());
                        System.out.println("Mr. " + y.getDriverName() + "'s no of 1st places - " + y.getPosition1());
                        System.out.println("Mr. " + y.getDriverName() + "'s no of 2nd places - " + y.getPosition2());
                        System.out.println("Mr. " + y.getDriverName() + "'s no of 3rd places - " + y.getPosition3());
                        System.out.println("Mr. " + y.getDriverName() + "'s no of points - " + y.getPoints());
                        System.out.println("Mr. " + y.getDriverName() + "'s no of races - " + y.getNumOfRaces());
                    }
                }
            } else {
                System.out.println("Driver not found! Please check the driver name and try again.");
            }
        }else {
            System.out.println("Invalid input! Please check the driver name and try again.");
        }
    }

    public void driverTable() {

        Collections.sort(drivers);
        System.out.println(" ---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|    Drivers Name    |   Team Name    |    Location      |  No. of Races  |  Points  |  1st places  |  2nd places  |  3rd places  |");
        System.out.println(" ---------------------------------------------------------------------------------------------------------------------------------");

        for (Formula1Driver l : drivers) {
            System.out.printf("|  %-15s   |  %-10s    |  %-10s      |  %-10s    |  %-6d  |   %-5d      |    %-5d     |  %-8d    |\n", l.getDriverName(), l.getTeamName(), l.getLocation(), l.getNumOfRaces(), l.getPoints(), l.getPosition1(), l.getPosition2(), l.getPosition3());
        }
        System.out.println(" ---------------------------------------------------------------------------------------------------------------------------------");
    }

    public void addRace() {

        if (drivers.size() > 1) {
            System.out.println("Enter the date of race: (dd/mm/yyyy)");
            String date = input.next();
            if(checkDate(date)) {
                dates.add(date);
                availableDrivers();
                for (int i = 0; i < drivers.size(); i++) {
                    System.out.print("Enter the driver's name who got the " + (i + 1) + " place of the race: ");
                    if (input.hasNext()) {
                        String place = input.next();
                        if (checkDriverAvailability(place)) {
                            for (Formula1Driver r : drivers) {
                                if (r.getDriverName().equals(place)) {
                                    r.setNumOfRaces(1);
                                    r.setPoints(pointsScheme[i]);
                                    if (i == 0) {
                                        r.setPosition1(1);
                                    } else if (i == 1) {
                                        r.setPosition2(1);
                                    } else if (i == 2) {
                                        r.setPosition3(1);
                                    }
                                }
                            }
                        } else {
                            System.out.println("Driver not found! Please check the input and try again.");
                            menu();
                            break;
                        }
                    } else {
                        System.out.println("Invalid input! Please check the driver name and try again.");
                        break;
                    }
                }
            } else {
                System.out.println("Invalid date or date format! Please enter a valid input and try again.");
            }
        }else {
            System.out.println("Invalid number of drivers/cars/constructors. (Only " + drivers.size() + " teams are added.) Please add at least 2 drivers to use this function.");
        }
        numOfRaces++;
    }

    public boolean checkDate(String date) {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            Date d = format.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void availableDrivers() {

        System.out.println(" ");
        System.out.println("* List of drivers that has been already added *");
        for (Formula1Driver d : drivers) {
            System.out.println("\t 🏎️ " + d.getDriverName());
        }
        System.out.println(" ");
    }

    public void availableTeams() {

        System.out.println(" ");
        System.out.println("* List of teams that has been already added *");
        for (Formula1Driver d : drivers) {
            System.out.println("\t 🏎️ " + d.getTeamName());
        }
        System.out.println(" ");
    }

    public void instructions() {

        System.out.println(" ");
        System.out.println("             ⚠️Instructions   ⚠️");
        System.out.println("* Driver's should be unique to teams.\n (One driver can be in a one team. One team should have only one driver.)");
        System.out.println(" ");
    }

    public void saveData() {

//      Referenced from - https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java

        try{
            FileOutputStream data = new FileOutputStream("Championship_Info.ser");
            ObjectOutputStream write = new ObjectOutputStream(data);

            write.writeObject(drivers);
            write.flush();
            write.close();
            System.out.println("📂 Data saved to the file successfully...");

        }catch (IOException e) {
            System.out.println("Error while saving data to the file.");
        }
    }

    public void loadData() {

//      Referenced from - https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java

        try {
            FileInputStream read = new FileInputStream("Championship_Info.ser");
            ObjectInputStream stream = new ObjectInputStream(read);

            drivers = (ArrayList<Formula1Driver>) stream.readObject();
            stream.close();
            System.out.println(" ");
            System.out.println("\uD83D\uDCC2 File loaded...");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");

        }catch (IOException | ClassNotFoundException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public void exit() {

        System.out.println("🎇 Thank you for using 'Formula 1 Championship Manager Program 🎇'. \n \t\t\t\t\t Stay safe!");
        saveData();
        System.exit(0);
    }
}
