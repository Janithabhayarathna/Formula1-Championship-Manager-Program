import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import static java.awt.Color.black;
import static java.awt.Color.white;

public class GUI {

    public GUI() {

        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 850, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JTable table = new JTable();
        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Driver's Name", "Team Name", "Location", "No. of Races", "Points", "1st places", "2nd places", "3rd places"}));
        fillTable(Formula1ChampionshipManager.drivers, table);
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setGridColor(Color.black);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setSelectionForeground(Color.BLUE);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.setRowHeight(25);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.white);
        pane.setBounds(10, 10, 820, 570);
        frame.getContentPane().add(pane);
    }

    public static void fillTable (ArrayList < Formula1Driver > driver, JTable table){

        for (Formula1Driver drive : driver) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{drive.getDriverName(), drive.getTeamName(), drive.getLocation(), drive.getNumOfRaces(), drive.getPoints(), drive.getPosition1(), drive.getPosition2(), drive.getPosition3()});
        }
    }
    
}
