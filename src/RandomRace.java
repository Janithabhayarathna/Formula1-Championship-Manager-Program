import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collections;


public class RandomRace {
    // Class of random race.

    /**
     * Referenced from - https://m.youtube.com/watch?v=pybU3E-eKfw
     *                 - https://www.youtube.com/watch?v=X1JPFGR3I7k&list=PLSob6gvlzsCPWqLcSuuA7_vmRU9v2jVIn
     */

    JLabel label1 = new JLabel(" ");    // Initializing label
    private String[] newPositions = new String[Formula1ChampionshipManager.drivers.size()]; // Array used to store positions of the race
    public JTable randomTable = new JTable();   // Initializing label

    public void positionInitializing() {
        // Method used to initialize newPosition array.

        for (int l=0; l< Formula1ChampionshipManager.drivers.size(); l++) {
            newPositions[l] = "No Driver";
        }
    }


    public RandomRace() {
        //Random race constructor.

        positionInitializing();

        // Generating the random date.
        int randomDate = (int)(Math.random()*(27 - 1 + 1) + 1);
        String dd = Integer.toString(randomDate);
        int randomMonth = (int)(Math.random()*(11 - 1 + 1) + 1);
        String MM = Integer.toString(randomMonth);

        String date = dd + "/" + MM +"/" + "2021";

        randomPositions();

        Formula1ChampionshipManager.races.add(new RaceData(date, newPositions));    // Adding the race to the races array list.

        // Frame
        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 710, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);

        // Label
        label1.setText("🏁 Random race details.");
        frame.getContentPane().add(label1);
        label1.setBounds(20,0,700,50);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Calibre",Font.BOLD,22));

        // Table
        randomTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Race date", "1st place", "2nd place", "3rd place"}));
        ((DefaultTableModel) randomTable.getModel()).addRow(new Object[]{date, newPositions[0], newPositions[1], newPositions[2]}); // Filling the table row by row.
        randomTable.setBackground(Color.darkGray);
        randomTable.setForeground(Color.white);
        randomTable.setOpaque(true);
        randomTable.setFillsViewportHeight(true);
        randomTable.setGridColor(Color.black);
        randomTable.setSelectionBackground(Color.LIGHT_GRAY);
        randomTable.setSelectionForeground(Color.BLUE);
        randomTable.setFont(new Font("Serif", Font.PLAIN, 16));
        randomTable.setRowHeight(25);

        // Scroll pane
        JScrollPane pane = new JScrollPane(randomTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.white);
        pane.setBounds(5, 60, 685, 80);
        frame.getContentPane().add(pane);
    }

    public void randomPositions() {
        // Generating the random positions.

        Collections.shuffle(Formula1ChampionshipManager.drivers);   // Shuffling the drivers arraylist.
        for (int i = 0; i < Formula1ChampionshipManager.drivers.size(); i++) {
            newPositions[i] = Formula1ChampionshipManager.drivers.get(i).getDriverName();   // Assigning the positions randomly.
            Formula1ChampionshipManager.drivers.get(i).setNumOfRaces(1);
            Formula1ChampionshipManager.drivers.get(i).setPoints(Formula1ChampionshipManager.pointsScheme[i]);
            if (i == 0) {
                Formula1ChampionshipManager.drivers.get(i).setPosition1(1);
            } else if (i == 1) {
                Formula1ChampionshipManager.drivers.get(i).setPosition2(1);
            } else if (i == 2) {
                Formula1ChampionshipManager.drivers.get(i).setPosition3(1);
            }
        }
    }

}
