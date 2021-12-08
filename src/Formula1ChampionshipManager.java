import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * name - Janith Chanaka Abhayarathna.
 * UoW Id - w1830253
 * IIT Id - 20200571
 * OOP Course Work.
 */

public class Formula1ChampionshipManager implements ChampionshipManager {

    public int noOfDrivers;
    public int noOfCars;
    public static ArrayList<Formula1Driver> drivers = new ArrayList<Formula1Driver>();      // Array list to store driver details as objects.
    public static ArrayList<RaceData> races = new ArrayList<RaceData>();        // Array list to store race details as objects.
    public static int[] pointsScheme = {25,18,15,12,10,8,6,4,2,1,0,0,0,0,0,0,0,0,0,0};      // Point scheme of the race according to position.
    public Scanner input = new Scanner(System.in).useDelimiter("\n");       //Created an object for Scanner class. Used 'useDelimiter' to ignore spaces between user inputs.
    String driverName; String location; String teamName; int position1; int position2; int position3; int points; int numOfRaces;


    public static void main(String[] args) {

        Formula1ChampionshipManager obj = new Formula1ChampionshipManager();  // Created an object for Formula1Championship manager.
        obj.loadData();     // Calling the loadData method to load data at the beginning of the program.
        obj.loadRaceData();     // Calling the loadRaceData method to load race data at the beginning of the program.
        System.out.println(" ");
        System.out.println("\t🎇 Welcome to the Formula 1 Championship Manager Program©. 🎇");
        obj.menu(); // Calling the menu of the program.
    }


    public void menu() {

        while (true) {

            //Option menu.
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
            System.out.println("\t|   7 or GUI: open the GUI.                           |");
            System.out.println("\t|   8 or EXT: EXiT from the program.                  |");
            System.out.println("\t -----------------------------------------------------");
            System.out.println("\t 🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️🏎️");

            System.out.println(" ");
            System.out.print(" >> Enter the option you want: ");
            String option = input.next().toUpperCase();     // Getting the required option from the user and converting the input to upper case.

            switch (option) {
                // Switch case for directing to the relevant method according to the user input.

                case "1":
                case "CND":
                    System.out.println(" ");
                    System.out.println("\t\t\t 🏎️ _ Create a new driver option _ 🏎️");
                    createDriver();     // Calling the createDriver method.
                    break;

                case "2":
                case "DAD":
                    System.out.println(" ");
                    System.out.println("\t\t 🏎️ _ Delete a driver option _ 🏎️");
                    deleteDriver();     // Calling the deleteDriver method.
                    break;

                case "3":
                case "CDT":
                    System.out.println(" ");
                    System.out.println("\t\t 🏎️ _ Change the driver of a team option _ 🏎️");
                    changeTeam();       // Calling the changeTeam method.
                    break;

                case "4":
                case "DSD":
                    System.out.println(" ");
                    System.out.println("\t\t 🏎️ _ Display statistics of a driver option _ 🏎️");
                    displayStats();     // Calling the displayStats method.
                    break;

                case "5":
                case "DDT":
                    System.out.println(" ");
                    System.out.println("\t\t\t\t\t\t\t\t\t 🏎️ _ Display the driver table option _ 🏎️");
                    driverTable();      // Calling the driverTable method.
                    break;

                case "6":
                case "ASR":
                    System.out.println(" ");
                    System.out.println("\t\t 🏎️ _ Add Statistics of a completed race option _ 🏎️");
                    addRace();      // Calling the addRace method.
                    break;

                case "7":
                case "GUI":
                    System.out.println(" ");
                    System.out.println("\t 🖥️ Graphical User Interface opened...");
                    new GUI();      // Calling the GUI constructor.
                    break;

                case "8":
                case "EXT":
                    System.out.println(" ");
                    exit();     // Calling the changeTeam method.
                    break;

                default:    // Running this part if user enters a wrong input.
                    System.out.println("⚠️Please check the input and try again! Refer the option menu.");
                    System.out.println(" ");
            }
        }
    }


    @Override
    public void createDriver() {
        // Method to add a driver.


        while(true) {

            instructions();     // Calling the instructions method to display the instructions that user need to follow.
            if (drivers.size() > 0) {
                availableDrivers();     // If there are existing drivers this method will be called and display the existing drivers.
            }
            System.out.println(" ");
            System.out.print(" >> Enter the name of the driver: ");
            driverName = input.next().toLowerCase();
            if (checkDriverUniqueness(driverName)) {    // Check whether the given driver name is unique or not.
                if (drivers.size() > 0) {
                    availableTeams();   // If there are existing drivers this method will be called and display the existing drivers.
                }
                System.out.println(" ");
                System.out.print(" >> Enter the team name of the driver: ");
                teamName = input.next().toUpperCase();
                if (checkTeamUniqueness(teamName)) {    // Check whether the given driver name is unique or not.
                    System.out.print(" >> Enter the driver's location: ");
                    location = input.next();
                    System.out.print(" >> Enter the number of 1st positions achieved by the driver: ");
                    if (input.hasNextInt()) {   // Checking whether the user has input an integer as the input
                        position1 = input.nextInt();
                        if (positionValidator(position1)) {    // Validating the position whether it's a positive integer
                            System.out.print(" >> Enter the number of 2nd positions achieved by the driver: ");
                            if (input.hasNextInt()) {   // Checking whether the user has input an integer as the input
                                position2 = input.nextInt();
                                if (positionValidator(position2)) {     // Validating the position whether it's a positive integer
                                    System.out.print(" >> Enter the number of 3rd positions achieved by the driver: ");
                                    if (input.hasNextInt()) {   // Checking whether the user has input an integer as the input
                                        position3 = input.nextInt();
                                        if (positionValidator(position3)) {     // Validating the position whether it's a positive integer
                                            System.out.print(" >> Enter number of points of the driver: ");
                                            if (input.hasNextInt()) {   // Checking whether the user has input an integer as the input
                                                points = input.nextInt();
                                                System.out.print(" >> Enter the number of races that have been participated by the driver: ");
                                                if (input.hasNextInt()) {   // Checking whether the user has input an integer as the input
                                                    numOfRaces = input.nextInt();
                                                    break;

                                                } else {
                                                    System.out.println("⚠️Invalid input! Please enter an integer.");
                                                    input.next();
                                                    System.out.println(" ");
                                                    menu();
                                                    break;
                                                }
                                            } else {
                                                System.out.println("⚠️Invalid type of input! Please enter an integer.");
                                                input.next();
                                                System.out.println(" ");
                                                menu();
                                            }
                                        } else {
                                            System.out.println("⚠️Invalid input! Please enter a positive integer.");
                                            input.next();
                                            System.out.println(" ");
                                            menu();
                                        }
                                    } else {
                                        System.out.println("⚠️Invalid type of input! Please enter an integer.");
                                        input.next();
                                        System.out.println(" ");
                                        menu();
                                    }
                                } else {
                                    System.out.println("⚠️Invalid input! Please enter a positive integer.");
                                    input.next();
                                    System.out.println(" ");
                                    menu();
                                }
                            } else {
                                System.out.println("⚠️Invalid type of input! Please enter an integer and try again.");
                                input.next();
                                System.out.println(" ");
                                menu();
                            }
                        } else {
                            System.out.println("⚠️Invalid input! Input should be a positive integer");
                            input.next();
                            System.out.println(" ");
                            menu();
                        }
                    } else {
                        System.out.println("⚠️Invalid type of input! Please enter an integer and try again.");
                        input.next();
                        System.out.println(" ");
                        menu();
                    }
                } else {
                    System.out.println("⚠️Team already exists! Please Please refer the instructions and try again.");
                    instructions();
                    input.next();
                    System.out.println(" ");
                    menu();
                }
            } else {
                System.out.println("⚠️Driver already exist! Please refer the instructions and try again.");
                instructions();
                input.next();
                System.out.println(" ");
                menu();
                break;
            }
            // If driver entered an invalid input it displays the warning message and going to the menu(calling the menu method).
        }

        System.out.println(" ");
        System.out.println("✔ Driver " + driverName + " of team " + teamName + " successfully added.");
        System.out.println("-----------------------------------------------------------------------------------");
        drivers.add(new Formula1Driver(driverName, location, teamName, position1, position2, position3, points, numOfRaces)); // Passing the driver details to the drivers array list as objects.
        noOfDrivers++;
        noOfCars++;
    }


    /**
     * @param name - Driver name
     */
    public boolean checkDriverUniqueness(String name) {
        // Method used to check the driver name uniqueness.

        for (Formula1Driver x : drivers) {
            if (x.getDriverName().equals(name)) { // If there is a driver which has the same name with entered name this method returns false.
                return false;
            }
        }
        return true;
    }


    /**
     * @param name - Driver name
     */
    public static boolean checkDriverAvailability(String name) {
        // Method used to check the availability of the entered driver name.

        for (Formula1Driver x : drivers) {
            if (x.getDriverName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param team - Team name
     */
    public boolean checkTeamUniqueness(String team) {
        // Method used to check the driver name uniqueness.

        for (Formula1Driver y : drivers) {
            if (y.getTeamName().equals(team)) {
                return false;
            }
        }
        return true;
    }


    /**
     * @param team - Team name
     */
    public boolean checkTeamAvailability(String team) {
        // Method used to check the availability of the entered team name.

        for (Formula1Driver y : drivers) {
            if (y.getTeamName().equals(team)) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param position - Position of the race
     */
    public boolean positionValidator(int position) {
        // Method used to validate the entered position(Whether it is positive(return true) integer or not(return false)).

        if (position>=0) {
            return true;
        }
        return false;
    }


    @Override
    public void deleteDriver() {
        // Method used to delete an existing driver.

        availableDrivers();     // Displaying the existing drivers.
        System.out.print(" >> Enter the name of the driver that you want to delete: ");
        if (input.hasNext()) {
            String delDriverName = input.next().toLowerCase();
            if (checkDriverAvailability(delDriverName)) {   // Checking the availability of the given driver name.
                for (int i =0; i<drivers.size(); i++) {
                    if(drivers.get(i).getDriverName().equals(delDriverName)) {
                        System.out.println("✔ Driver " + drivers.get(i).getDriverName() + " successfully removed.");
                        System.out.println("✔ Team " + drivers.get(i).getTeamName() + " also successfully removed.");
                        drivers.remove(i);
                    }
                }
            } else {
                System.out.println("⚠️Driver name not found! Please refer to the added drivers and try again.");
            }
        }
        else {
            System.out.println("⚠️Please enter a valid driver name.");
        }
        noOfDrivers--;
        noOfCars--;
        System.out.println("-----------------------------------------------------------------------------------");
    }


    @Override
    public void changeTeam() {
        // Method used to change the driver of a team.

        availableTeams();   // Displaying the existing teams.
        System.out.print(" >> Enter the Team name that need to change the driver : ");
        if (input.hasNext()) {
            String changeDriver = input.next().toUpperCase();
            if (checkTeamAvailability(changeDriver)) {  // Check the availability of the team.
                for (Formula1Driver driver : drivers) {
                    if (driver.getTeamName().equals(changeDriver)) {
                        instructions();     // Displaying the instructions.
                        availableDrivers(); // Displaying the existing drivers.
                        System.out.print(" >> Enter the preferred new driver's name: ");
                        String newDriver = input.next().toLowerCase();
                        if (checkDriverUniqueness(newDriver)) {     // Checking the driver name uniqueness.
                            System.out.println("✔ Team " + driver.getTeamName() + "'s driver changed as, " + driver.getDriverName() + " to, " + newDriver);
                            driver.setDriverName(newDriver);
                        } else{
                            System.out.println("⚠️Driver already exist! Please check the input and try again.");
                            menu();
                        }
                    }
                }
            } else {
                System.out.println("⚠️Team not found! Please check the input and try again.");
                menu();
            }
        }
        else {
            System.out.println("⚠️Invalid input!");
            menu();
        }
        // If driver entered an invalid input it displays the warning message and going to the menu(calling the menu method).
        System.out.println("-----------------------------------------------------------------------------------");
    }


    @Override
    public void displayStats() {
        // Method used to display statistics of a driver.

        availableDrivers();     // Displaying the existing drivers.
        System.out.print(" >> Enter the Name of the driver, that need to display statistics: ");
        if (input.hasNext()) {
            String statDriver = input.next().toLowerCase();
            if (checkDriverAvailability(statDriver)) {  // Checking the availability of the driver.
                for (Formula1Driver driver : drivers) {
                    if (driver.getDriverName().equals(statDriver)) {
                        // Displaying the statistics of the relevant driver.
                        System.out.println(" ");
                        System.out.println("🧘______________ Mr. " + driver.getDriverName().toUpperCase() + " __________________🧘");
                        System.out.println("\t⛔ Mr. " + driver.getDriverName() + "'s location - " + driver.getLocation());
                        System.out.println("\t⛔ Mr. " + driver.getDriverName() + "'s team name - " + driver.getTeamName());
                        System.out.println("\t⛔ Mr. " + driver.getDriverName() + "'s no of 1st places - " + driver.getPosition1());
                        System.out.println("\t⛔ Mr. " + driver.getDriverName() + "'s no of 2nd places - " + driver.getPosition2());
                        System.out.println("\t⛔ Mr. " + driver.getDriverName() + "'s no of 3rd places - " + driver.getPosition3());
                        System.out.println("\t⛔ Mr. " + driver.getDriverName() + "'s no of points - " + driver.getPoints());
                        System.out.println("\t⛔ Mr. " + driver.getDriverName() + "'s no of races - " + driver.getNumOfRaces());
                    }
                }
            } else {
                System.out.println("⚠️Driver not found! Please check the driver name and try again.");
                menu();
            }
        }else {
            System.out.println("⚠️Invalid input! Please check the driver name and try again.");
            menu();
        }
        // If driver entered an invalid input it displays the warning message and going to the menu(calling the menu method).
        System.out.println("-----------------------------------------------------------------------------------");
    }


    @Override
    public void driverTable() {
        // Method used to display the driver table.

        Collections.sort(drivers);  // Sorting the drivers array list according to the points of descending order.

        // Driver table.
        System.out.println(" ---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|    Drivers Name    |   Team Name    |    Location      |  No. of Races  |  Points  |  1st places  |  2nd places  |  3rd places  |");
        System.out.println(" ---------------------------------------------------------------------------------------------------------------------------------");

        // Filling the table.
        for (Formula1Driver driver : drivers) {
            System.out.printf("|  %-15s   |  %-10s    |  %-10s      |  %-10s    |  %-6d  |   %-5d      |    %-5d     |  %-8d    |\n", driver.getDriverName(), driver.getTeamName(), driver.getLocation(), driver.getNumOfRaces(), driver.getPoints(), driver.getPosition1(), driver.getPosition2(), driver.getPosition3());
        }
        System.out.println(" ---------------------------------------------------------------------------------------------------------------------------------");
    }


    @Override
    public void addRace() {
        // Method used to add statistics of a completed race.

        String[] positions = new String[drivers.size()];      // Array to store positions of each race.
        if (drivers.size() > 1) {
            System.out.print(" >> Enter the date of race: (DD/MM/2021): ");
            String date = input.next();
            if (checkDate(date)) {      // Validating the entered date.
                availableDrivers();     // Displaying the existing drivers.
                for (int i = 0; i < drivers.size(); i++) {  // Asking the driver's name from the user according to the given position.

                    System.out.print(" >> Enter the driver's name who got the " + (i + 1) + " place of the race: ");
                    if (input.hasNext()) {
                        String place = input.next().toLowerCase();
                        if (checkDriverAvailability(place)) {   // Check the availability of the driver.
                            if (placeAvailability(place, positions)) {  // Check the availability of the place.
                                positions[i] = place;
                                for (Formula1Driver driver : drivers) {
                                    if (driver.getDriverName().equals(place)) {
                                        driver.setNumOfRaces(1);     // Adding 1 to the race count of the relevant driver.
                                        driver.setPoints(pointsScheme[i]);   // Adding points according to the point scheme.
                                        if (i == 0) {
                                            driver.setPosition1(1);  // Adding 1 to the number of 1st places count of the relevant driver.

                                        } else if (i == 1) {
                                            driver.setPosition2(1);  // Adding 1 to the number of 2nd places count of the relevant driver.

                                        } else if (i == 2) {
                                            driver.setPosition3(1);  // Adding 1 to the number of 3rd places count of the relevant driver.

                                        }
                                    }
                                }
                            } else {
                                System.out.println(" ");
                                System.out.println("⚠️Driver " + place + " already has an place in the race.");
                                menu();
                                break;
                            }
                        } else {
                            System.out.println(" ");
                            System.out.println("⚠️Driver not found! Please check the input and try again.");
                            menu();
                            break;
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("⚠️Invalid input! Please check the driver name and try again.");
                        menu();
                        break;
                    }
                    // If driver entered an invalid input it displays the warning message and going to the menu(calling the menu method).
                }

                races.add(new RaceData(date, positions));   // Passing the race details to the races array list as objects.
                System.out.println(" ");
                System.out.println("✔ Race statistics successfully added.");
                numOfRaces++;
                System.out.println("-----------------------------------------------------------------------------------");
                menu();

            } else {
                System.out.println("⚠️Invalid date or date format! Please enter a valid input and try again.");
            }
        } else {
            System.out.println("⚠️Invalid number of drivers/cars/constructors. (Only " + drivers.size() + " teams are added.) Please add at least 2 drivers to use this function.");
        }

    }


    /**
     * @param date - Race date
     */
    public boolean checkDate(String date) {
        // Method used to validate the entered date.
        // Referenced from - http://tutorials.jenkov.com/java-internationalization/simpledateformat.html

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");   // Created an instance of SimpleDateFormat.
        format.setLenient(false);
        try {
            Date d = format.parse(date);    // Parsing the String date into Java.Util.Date instance.
            return true;     // If the date can be passed without an error returns true.
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * @param driver - Driver name
     * @param position - Places of the race
     */
    public boolean placeAvailability(String driver, String[] position) {
        // Method used to check the availability of the entered place.

        for (int n=0; n<position.length; n++){
            if (driver.equals(position[n])) {   // If the driver already has a place it will return false.
                return false;
            }
        }
        return true;
    }


    public void availableDrivers() {
        // Method used to display existing drivers.

        System.out.println(" ");
        System.out.println("* List of drivers that has been already added.");
        for (Formula1Driver driver : drivers) {
            System.out.print(" \t 🏎️ " + driver.getDriverName());
        }
        System.out.println(" ");
    }


    public void availableTeams() {
        // Method used to display existing teams.

        System.out.println(" ");
        System.out.println("* List of teams that has been already added.");
        for (Formula1Driver driver : drivers) {
            System.out.print("\t 🏎️ " + driver.getTeamName());
        }
        System.out.println(" ");
    }


    public void instructions() {
        // Method used to display the instructions.

        System.out.println(" ");
        System.out.println("\t\t\t\t\t⚠️Instructions   ⚠️");
        System.out.println(" ");
        System.out.println("* Driver's should be unique to teams. (One driver can only be in a one team. One team can only have a one driver.)");
        System.out.println("* Enter a name which not in the below list.");
    }


    public void saveData() {
        // Method used to save the race data into the file Championship_Info.
        // Referenced from - https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java

        try{
            FileOutputStream data = new FileOutputStream("Championship_Info.ser");  // Create a file.
            ObjectOutputStream write = new ObjectOutputStream(data);    // Handles the object to be written into the file.

            write.writeObject(drivers); // Writes the drivers array list to the file.
            write.flush();  // To flush all the data in the stream.
            write.close();  // Close the stream.
            System.out.println("📂 Data saved to the file(Championship_Info.ser) successfully...");

        }catch (IOException e) {    // Runs if there is an error while saving data.
            System.out.println("⚠️Error while saving data to the file.");
        }
    }

    public void saveRaceData() {
        // Method used to save the race data into the file Race_Info.
        // Referenced from - https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java

        try{
            FileOutputStream rdata = new FileOutputStream("Race_Info.ser");  // Create a file.
            ObjectOutputStream write = new ObjectOutputStream(rdata);    // Handles the object to be written into the file.

            write.writeObject(races); // Writes the races array list to the file.
            write.flush();  // To flush all the data in the stream.
            write.close();  // Close the stream.
            System.out.println("📂 Race data saved to the file(Race_Info.ser) successfully...");

        }catch (IOException e) {    // Runs if there is an error while saving data.
            System.out.println("⚠️Error while saving race data to the file.");
        }
    }


    public void loadData() {
        // Method used to load data from the Championship_Info file.
        // Referenced from - https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java

        try {
            FileInputStream read = new FileInputStream("Championship_Info.ser");  // To read data from the file.
            ObjectInputStream stream = new ObjectInputStream(read);

            drivers = (ArrayList<Formula1Driver>) stream.readObject();  // Loading data to the driver's arraylist.
            stream.close();     // Close the reading stream.
            System.out.println(" ");
            System.out.println("📂 'Championship_Info' file loaded...");
        }
        catch (FileNotFoundException e) {   // Runs if the file not found.
            System.out.println("❌ 'Championship_Info' file not found.");

        }catch (IOException | ClassNotFoundException e) {   // Runs if there is an error while loading data from the file.
            System.out.println("Error❗");
        }
    }


    public void loadRaceData() {
        // Method used to load data from the Race_Info file.
        // Referenced from - https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java

        try {
            FileInputStream read = new FileInputStream("Race_Info.ser");  // To read data from the file.
            ObjectInputStream stream = new ObjectInputStream(read);

            races = (ArrayList<RaceData>) stream.readObject();  // Loading data to the driver's arraylist.
            stream.close();     // Close the reading stream.
            System.out.println("📂 'Race_Info' file loaded...");
        }
        catch (FileNotFoundException e) {   // Runs if the file not found.
            System.out.println("❌ 'Race_Info' file not found.");

        }catch (IOException | ClassNotFoundException e) {   // Runs if there is an error while loading data from the file.
            System.out.println("Error❗");
            e.printStackTrace();
        }
    }


    @Override
    public void exit() {
        // Method used to exit from the program.

        System.out.println("🎇 Thank you for using 'Formula 1 Championship Manager Program 🎇'. \n \t\t\t\t\t Stay safe!");
        System.out.println("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟");
        saveData();  // Saving the driver's data.
        saveRaceData();     // Saving the race data.
        System.exit(0); // Exiting from the program.
    }
}
