import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import static java.awt.Color.black;
import static java.awt.Color.white;

public class GUI {

    public static void main(String[] args) {

        JTable table = new JTable();
        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Driver's Name", "Team Name", "Location", "No. of Races", "Points", "1st places", "2nd places", "3rd places"}));
        fillTable(Formula1ChampionshipManager.drivers, table);

        JFrame frame = new JFrame("Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setForeground(Color.black);
        frame.setBounds(100, 100, 710, 710);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        table.setBackground(Color.black);
        table.setForeground(Color.white);
        table.setSelectionBackground(Color.blue);
        table.setGridColor(Color.red);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Tahoma", Font.PLAIN, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.white);
        pane.setBounds(0,0,700,700);
        frame.getContentPane().add(pane);

        frame.setVisible(true);

    }

    public static void fillTable(ArrayList<Formula1Driver> drivers, JTable table) {

        for(Formula1Driver d : drivers) {
            ((DefaultTableModel)table.getModel()).addRow(new Object[]{d.getDriverName(),d.getTeamName(),d.getLocation(),d.getNumOfRaces(),d.getPoints(),d.getPosition1(),d.getPosition2(),d.getPosition3()});
        }
    }
}
