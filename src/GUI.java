import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class GUI implements ActionListener{

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    static JLabel label = new JLabel("🎇 Welcome to the GUI 🎇");
    JTable table = new JTable();

    public GUI() {

        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 810, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        frame.getContentPane().add(label);
        label.setBounds(20,0,700,50);
        label.setForeground(Color.white);
        label.setFont(new Font("Calibre",Font.BOLD,22));

        button1 = new JButton("Points on desc");
        button1.setBounds(80,60,120,40);
        frame.getContentPane().add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Points on asc");
        button2.setBounds(250,60,120,40);
        frame.getContentPane().add(button2);
        button2.addActionListener(this);

        button3 = new JButton("1st positions desc");
        button3.setBounds(420,60,120,40);
        frame.getContentPane().add(button3);
        button3.addActionListener(this);

        button4 = new JButton("Random race");
        button4.setBounds(590,60,120,40);
        frame.getContentPane().add(button4);
        button4.addActionListener(this);

        button5 = new JButton("Random race on position");
        button5.setBounds(165,120,120,40);
        frame.getContentPane().add(button5);

        button6 = new JButton("Display races");
        button6.setBounds(335,120,120,40);
        frame.getContentPane().add(button6);

        button7 = new JButton("Driver races");
        button7.setBounds(505,120,120,40);
        frame.getContentPane().add(button7);
        button7.addActionListener(this);

        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Driver's Name", "Team Name", "Location", "No. of Races", "Points", "1st places", "2nd places", "3rd places"}));
        fillTable(Formula1ChampionshipManager.drivers, table);
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setGridColor(Color.blue);
        table.setSelectionBackground(Color.blue);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.setRowHeight(25);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.blue);
        pane.setBounds(5, 190, 780, 570);
        frame.getContentPane().add(pane);


    }

    public static void fillTable (ArrayList < Formula1Driver > driver, JTable table){

        for (Formula1Driver drive : driver) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{drive.getDriverName(), drive.getTeamName(), drive.getLocation(), drive.getNumOfRaces(), drive.getPoints(), drive.getPosition1(), drive.getPosition2(), drive.getPosition3()});
        }
    }

    public void removeContent () {

        DefaultTableModel mode = (DefaultTableModel)table.getModel();
        int count= mode.getRowCount();
        for (int i=count-1; i >= 0; i--) {
            mode.removeRow(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(button1)) {
            removeContent();
            Collections.sort(Formula1ChampionshipManager.drivers);
            fillTable(Formula1ChampionshipManager.drivers, table);
            label.setText(" Stats of all drivers in descending order of points.");
        }
        else if (e.getSource().equals(button2)) {
            removeContent();
            Collections.sort(Formula1ChampionshipManager.drivers, Formula1Driver.ascendingOnPoint);
            fillTable(Formula1ChampionshipManager.drivers, table);
            label.setText(" Stats of all drivers in ascending order of points.");
        }
        else if (e.getSource().equals(button3)) {
            removeContent();
            Collections.sort(Formula1ChampionshipManager.drivers, Formula1Driver.descendingOnPosition1);
            fillTable(Formula1ChampionshipManager.drivers, table);
            label.setText(" Stats of all drivers in descending order of no. of 1st places.");
        }
        else if (e.getSource().equals(button4)) {
            new RandomRace();
        }
        else if (e.getSource().equals(button7)) {
            new SearchRaces();
        }
    }
}
