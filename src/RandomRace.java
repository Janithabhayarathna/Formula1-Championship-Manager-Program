import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class RandomRace {

    private String[] newPositions = new String[Formula1ChampionshipManager.drivers.size()];
    public JTable randomTable = new JTable();
    public static ArrayList<RandomRace> rRace = new ArrayList<RandomRace>();

    private String randomDate;

    public void positionInitializing(String[] positions) {

        for (int l=0; l< newPositions.length; l++) {

            newPositions[l] = "No Driver";
        }
    }

    public RandomRace(String randomDate, String[] newPositions) {

        this.randomDate = randomDate;
        this.newPositions = newPositions;
    }

    public RandomRace() {

        positionInitializing(newPositions);
        int randomDate = (int)(Math.random()*(27 - 1 + 1) + 1);
        String dd = Integer.toString(randomDate);
        int randomMonth = (int)(Math.random()*(11 - 1 + 1) + 1);
        String MM = Integer.toString(randomMonth);
        int randomYear = (int)(Math.random()*(2020 - 2000 + 1) + 2000);
        String yyyy = Integer.toString(randomYear);
        String date = dd + " / " + MM + " / " + yyyy;

        for (int i = 0; i < Formula1ChampionshipManager.drivers.size(); i++) {
            Collections.shuffle(Formula1ChampionshipManager.drivers);
            if (randomPositionValidate(newPositions)) {
                newPositions[i] = Formula1ChampionshipManager.drivers.get(i).getDriverName();
                Formula1ChampionshipManager.drivers.get(i).setNumOfRaces(1);
                Formula1ChampionshipManager.drivers.get(i).setPoints(Formula1ChampionshipManager.pointsScheme[i]);
                if (i == 0) {
                    Formula1ChampionshipManager.drivers.get(i).setPosition1(1);
                } else if (i == 1) {
                    Formula1ChampionshipManager.drivers.get(i).setPosition2(1);
                } else if (i == 2) {
                    Formula1ChampionshipManager.drivers.get(i).setPosition3(1);
                }
            }
        }

        Formula1ChampionshipManager.races.add(new RaceData(date, newPositions));

        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 810, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        randomTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Race date", "1st place", "2nd place", "3rd place"}));
        ((DefaultTableModel) randomTable.getModel()).addRow(new Object[]{date, newPositions[0], newPositions[1], newPositions[2]});
        randomTable.setBackground(Color.white);
        randomTable.setForeground(Color.black);
        randomTable.setGridColor(Color.blue);
        randomTable.setSelectionBackground(Color.LIGHT_GRAY);
        randomTable.setSelectionForeground(Color.BLUE);
        randomTable.setFont(new Font("Serif", Font.PLAIN, 16));
        randomTable.setRowHeight(25);

        JScrollPane pane = new JScrollPane(randomTable);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.white);
        pane.setBounds(5, 5, 780, 570);
        frame.getContentPane().add(pane);

    }

    public String[] getNewPositions() {
        return newPositions;
    }

    public void setNewPositions(String[] newPositions) {
        this.newPositions = newPositions;
    }

    public String getRandomDate() {
        return randomDate;
    }

    public void setRandomDate(String randomDate) {
        this.randomDate = randomDate;
    }

    public boolean randomPositionValidate(String[] newPositions) {

        if (newPositions.length > 0) {
            for (int i = 0; i < Formula1ChampionshipManager.drivers.size(); i++) {
                for (int f = 0; f < newPositions.length; f++) {
                    if (Formula1ChampionshipManager.drivers.get(i).getDriverName().equals(newPositions[f])) {
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }

}
