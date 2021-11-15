import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import static java.awt.Color.black;
import static java.awt.Color.white;

public class GUI {

    public static void main(String[] args) {

        JTable table = new JTable();
        Object[] columns = {"Driver's Name, Team Name, Location, No. of Races, Points, 1st places, 2nd places, 3rd places"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("WINDOW");
        frame.getContentPane().setBackground(black);
        frame.getContentPane().setForeground(white);
        frame.setBounds(100, 100, 757, 610);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setSelectionBackground(Color.blue);
        table.setGridColor(Color.red);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Tahoma", Font.PLAIN, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.white);
        pane.setBounds(10,10,10,10);
        frame.getContentPane().add(pane);

        frame.setVisible(true);
    }
}
