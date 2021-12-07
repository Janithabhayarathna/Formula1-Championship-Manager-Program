import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class RaceProbability {

    JTable table = new JTable();

    public void RaceProbability() {

        // Frame
        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 850, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Table
        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Driver's Name", "Team Name", "Location", "No. of Races", "Points", "1st places", "2nd places", "3rd places"}));  // Table heading.
//        fillTable(Formula1ChampionshipManager.drivers, table);  // Filling the table.
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setGridColor(Color.blue);
        table.setSelectionBackground(Color.blue);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.setRowHeight(25);

        // Pane
        JScrollPane pane;
        pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.blue);
        pane.setBounds(5, 190, 820, 570);
        frame.getContentPane().add(pane);

    }

}
