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

    JLabel label;
    JTable table = new JTable();
    ArrayList<String> allDates = new ArrayList<String>();

    public RaceOnDate() {

        for (int m=0; m < Formula1ChampionshipManager.races.size(); m++) {
            allDates.add(Formula1ChampionshipManager.races.get(m).getDateOfRace());
        }

        Collections.sort(allDates, new Comparator<String>() {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            @Override
            public int compare(String d1, String d2) {
                try {
                    return format.parse(d1).compareTo(format.parse(d2));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });

        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 810, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        label = new JLabel("Race details sorted on date.");
        frame.getContentPane().add(label);
        label.setBounds(20,0,700,50);
        label.setForeground(Color.white);
        label.setFont(new Font("Calibre",Font.BOLD,22));

        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Race date", "1st place", "2nd place", "3rd place"}));
        for (int h = 0; h < Formula1ChampionshipManager.races.size(); h++) {
            RaceData temp = Formula1ChampionshipManager.races.get(h);
            for (int s = 0; s < allDates.size(); s++) {
                if (allDates.get(s).equals(temp.getDateOfRace())) {
                    ((DefaultTableModel) table.getModel()).addRow(new Object[]{allDates.get(h), temp.getPlace()[0], temp.getPlace()[1], temp.getPlace()[2]});
                }
            }
        }
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setGridColor(Color.blue);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setSelectionForeground(Color.BLUE);
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.setRowHeight(25);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.white);
        pane.setBounds(5, 100, 780, 570);
        frame.getContentPane().add(pane);

    }
}
