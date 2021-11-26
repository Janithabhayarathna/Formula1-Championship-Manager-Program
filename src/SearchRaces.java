import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class SearchRaces implements ActionListener {

    JTable table = new JTable();
    JButton button;
    JTextField textBox;

    public SearchRaces() {

        JLabel label1 = new JLabel("  Driver's races.");
        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 810, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        textBox = new JTextField(20);
        textBox.setBounds(20,10,350,30);
        textBox.setText("Enter driver name");
        textBox.setToolTipText("Enter the driver's name here.");
        frame.getContentPane().add(textBox);

        button = new JButton("🔍 Search");
        button.setBounds(390,10,100,30);
        frame.getContentPane().add(button);
        button.addActionListener(this);

        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Date", "Position"}));
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
        pane.setBounds(5, 50, 780, 570);
        frame.getContentPane().add(pane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(button)) {
            String name = textBox.getText().toLowerCase();
//            if (Formula1ChampionshipManager.checkDriverAvailability(name)) {
                for (int k = 0; k<Formula1ChampionshipManager.races.size(); k++) {
                    RaceData temp = Formula1ChampionshipManager.races.get(k);
                    for (int y = 0; y < Formula1ChampionshipManager.positions.length; y++) {
                        if(temp.getPlace()[y].equals(name)) {
                            ((DefaultTableModel) table.getModel()).addRow(new Object[]{Formula1ChampionshipManager.races.get(k).getDateOfRace(),y});
                        }
                    }
                }
//            }
//            else {
//                System.out.println("hriyanne na appa");
//                new SearchRaces();
//
//            }
        }
    }
}
