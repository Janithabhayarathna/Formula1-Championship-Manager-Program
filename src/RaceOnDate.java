import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RaceOnDate {

    /**
     * Referenced from - https://m.youtube.com/watch?v=pybU3E-eKfw
     *                 - - https://www.youtube.com/watch?v=X1JPFGR3I7k&list=PLSob6gvlzsCPWqLcSuuA7_vmRU9v2jVIn
     */

    // Initialized the label and table.
    JLabel label;
    JTable table = new JTable();
    ArrayList<String> allDates = new ArrayList<String>();   //  Used to store all the race dates.

    public RaceOnDate() {
        // RaceOnDate constructor.

        Comparator<RaceData> raceDetails = new Comparator<RaceData>() {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            @Override
            public int compare(RaceData r1, RaceData r2) {
                try {
                    return format.parse(r1.getDateOfRace()).compareTo(format.parse(r2.getDateOfRace()));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        };

        Collections.sort(Formula1ChampionshipManager.races, raceDetails);

        // Frame
        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 810, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Label
        label = new JLabel("📆 Race details sorted on date.");
        frame.getContentPane().add(label);
        label.setBounds(20,0,700,50);
        label.setForeground(Color.white);
        label.setFont(new Font("Calibre",Font.BOLD,22));

        // Table
        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Race date", "1st place", "2nd place", "3rd place"})); // Table column names
        // Filling the table
        for (RaceData race : Formula1ChampionshipManager.races) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{race.getDateOfRace(), race.getPlace()[0], race.getPlace()[1], race.getPlace()[2]});
        }
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setGridColor(Color.blue);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setSelectionForeground(Color.BLUE);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.setRowHeight(25);

        // Scroll pane
        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.white);
        pane.setBounds(5, 100, 780, 570);
        frame.getContentPane().add(pane);

    }
}
