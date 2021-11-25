import javax.swing.*;
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
        frame.getContentPane().add(textBox);

        button = new JButton("Search");
        button.setBounds(390,10,100,30);
        frame.getContentPane().add(button);
        button.addActionListener(this);

        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Driver's Name", "Team Name", "Location", "No. of Races", "Points", "1st places", "2nd places", "3rd places"}));

        table.setBackground(Color.white);
        table.setForeground(Color.black);
//        table.setGridColor(Color.blue);
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

        }
    }
}
