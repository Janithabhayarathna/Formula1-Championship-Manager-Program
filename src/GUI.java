import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GUI {

    public GUI() {

        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 810, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JTable table = new JTable();
        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Driver's Name", "Team Name", "Location", "No. of Races", "Points", "1st places", "2nd places", "3rd places"}));
        fillTable(Formula1ChampionshipManager.drivers, table);
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setGridColor(Color.blue);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setSelectionForeground(Color.BLUE);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.setRowHeight(25);

        JButton button1 = new JButton("Sort on points");
        button1.setBounds(100,400,100,50);
        frame.getContentPane().add(button1);

        JButton button2 = new JButton("Sort on points");
        button2.setBounds(270,400,100,50);
        frame.getContentPane().add(button2);

        JButton button3 = new JButton("Sort on points");
        button3.setBounds(430,400,100,50);
        frame.getContentPane().add(button3);

        JButton button4 = new JButton("Sort on points");
        button4.setBounds(590,400,100,50);
        frame.getContentPane().add(button4);

        JButton button5 = new JButton("Sort on points");
        button5.setBounds(185,485,100,50);
        frame.getContentPane().add(button5);

        JButton button6 = new JButton("Sort on points");
        button6.setBounds(345,485,100,50);
        frame.getContentPane().add(button6);

        JButton button7 = new JButton("Sort on points");
        button7.setBounds(505,485,100,50);
        frame.getContentPane().add(button7);


        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.white);
        pane.setBounds(5, 5, 780, 570);
        frame.getContentPane().add(pane);
    }

    public static void fillTable (ArrayList < Formula1Driver > driver, JTable table){

        for (Formula1Driver drive : driver) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{drive.getDriverName(), drive.getTeamName(), drive.getLocation(), drive.getNumOfRaces(), drive.getPoints(), drive.getPosition1(), drive.getPosition2(), drive.getPosition3()});
        }
    }

}
