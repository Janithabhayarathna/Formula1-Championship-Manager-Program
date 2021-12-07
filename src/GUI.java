import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


public class GUI implements ActionListener{
    // Main class of the GUI

    /**
     * Referenced from - https://m.youtube.com/watch?v=pybU3E-eKfw
     *                 - https://www.youtube.com/watch?v=X1JPFGR3I7k&list=PLSob6gvlzsCPWqLcSuuA7_vmRU9v2jVIn
      */

    // Initialization of buttons, label and table.
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JLabel label = new JLabel("🎇 Welcome to the GUI 🎇");
    JTable table = new JTable();


    public GUI() {

        // Frame
        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 850, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Label
        frame.getContentPane().add(label);
        label.setBounds(20,0,700,50);
        label.setForeground(Color.white);
        label.setFont(new Font("Calibre",Font.BOLD,22));

        // Button 1
        button1 = new JButton("🏁 Points on desc");
        button1.setBounds(80,60,130,40);
        frame.getContentPane().add(button1);
        button1.addActionListener(this);

        // Button 2
        button2 = new JButton("🏁 Points on asc");
        button2.setBounds(250,60,130,40);
        frame.getContentPane().add(button2);
        button2.addActionListener(this);

        // Button 3
        button3 = new JButton("🏁 Desc on 1st pos");
        button3.setBounds(420,60,140,40);
        frame.getContentPane().add(button3);
        button3.addActionListener(this);

        // Button 4
        button4 = new JButton("🏁 Random race");
        button4.setBounds(590,60,130,40);
        frame.getContentPane().add(button4);
        button4.addActionListener(this);

        // Button 5
        button5 = new JButton("🏁 Probability Race");
        button5.setBounds(165,120,130,40);
        frame.getContentPane().add(button5);
        button5.addActionListener(this);

        // Button 6
        button6 = new JButton("🏁 Display races");
        button6.setBounds(335,120,130,40);
        frame.getContentPane().add(button6);
        button6.addActionListener(this);

        // Button 7
        button7 = new JButton("🏁 Driver races");
        button7.setBounds(505,120,130,40);
        frame.getContentPane().add(button7);
        button7.addActionListener(this);

        // Table
        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Driver's Name", "Team Name", "Location", "No. of Races", "Points", "1st places", "2nd places", "3rd places"}));  // Table heading.
        fillTable(Formula1ChampionshipManager.drivers, table);  // Filling the table.
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setGridColor(Color.blue);
        table.setSelectionBackground(Color.blue);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.setRowHeight(25);

        // Pane
        JScrollPane pane = new JScrollPane(table);
//        pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.blue);
        pane.setBounds(5, 190, 820, 570);
        frame.getContentPane().add(pane);
    }


    /**
     * @param driver - Driver name
     * @param table - Driver table
     */
    public static void fillTable (ArrayList < Formula1Driver > driver, JTable table){
        // Used to fill the table data row by row.

        for (Formula1Driver drive : driver) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{drive.getDriverName(), drive.getTeamName(), drive.getLocation(), drive.getNumOfRaces(), drive.getPoints(), drive.getPosition1(), drive.getPosition2(), drive.getPosition3()});
        }
    }


    public void removeContent () {
        // Used to remove the table data

        DefaultTableModel mode = (DefaultTableModel)table.getModel();
        int count= mode.getRowCount();
        for (int i=count-1; i >= 0; i--) {
            mode.removeRow(i);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // When user clicked a button this part will execute.

        // Button 1
        if (e.getSource().equals(button1)) {
            removeContent();
            Collections.sort(Formula1ChampionshipManager.drivers);
            fillTable(Formula1ChampionshipManager.drivers, table);
            label.setText("📃 Stats of all drivers in descending order of points.");
        }
        // Button 2
        else if (e.getSource().equals(button2)) {
            removeContent();
            Collections.sort(Formula1ChampionshipManager.drivers, Formula1Driver.ascendingOnPoint);
            fillTable(Formula1ChampionshipManager.drivers, table);
            label.setText("📃 Stats of all drivers in ascending order of points.");
        }
        // Button 3
        else if (e.getSource().equals(button3)) {
            removeContent();
            Collections.sort(Formula1ChampionshipManager.drivers, Formula1Driver.descendingOnPosition1);
            fillTable(Formula1ChampionshipManager.drivers, table);
            label.setText("📃 Stats of all drivers in descending order of no. of 1st places.");
        }
        // Button 4
        else if (e.getSource().equals(button4)) {
            new RandomRace();
        }
        // Button 5
        else if (e.getSource().equals(button5)) {
            new RaceProbability();
        }
        // Button 6
        else if (e.getSource().equals(button6)) {
            new RaceOnDate();
        }
        // Button 7
        else if (e.getSource().equals(button7)) {
            new SearchRaces();
        }
    }
}
