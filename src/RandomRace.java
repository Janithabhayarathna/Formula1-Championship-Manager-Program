import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class RandomRace {

    private String[] newPositions = new String[20];
    public JTable randomTable = new JTable();
    ArrayList<RandomRace> rRace = new ArrayList<RandomRace>();
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
        double randomDate = (Math.random()*(28 - 1 + 1) + 1);
        String dd = Double.toString(randomDate);
        double randomMonth = (Math.random()*(12 - 1 + 1) + 1);
        String MM = Double.toString(randomMonth);
        double randomYear = (Math.random()*(2021 - 2000 + 1) + 2000);
        String yyyy = Double.toString(randomYear);
        String date = dd + "/" + MM + "/" + yyyy;

        for (int i = 0; i < Formula1ChampionshipManager.drivers.size(); i++) {
            Collections.shuffle(Formula1ChampionshipManager.drivers);
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

        Formula1ChampionshipManager.races.add(new RaceData(date, newPositions));
        rRace.add(new RandomRace(date, newPositions));


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
        fillRandomRaceTable(rRace, randomTable);
        randomTable.setBackground(Color.white);
        randomTable.setForeground(Color.black);
        randomTable.setGridColor(Color.blue);
        randomTable.setSelectionBackground(Color.LIGHT_GRAY);
        randomTable.setSelectionForeground(Color.BLUE);
        randomTable.setFont(new Font("Serif", Font.PLAIN, 16));
        randomTable.setRowHeight(25);

        public void fillRandomRaceTable (ArrayList<RandomRace> Race, JTable table){

            for (RandomRace drive : rRace) {
                ((DefaultTableModel) randomTable.getModel()).addRow(new Object[]{drive.getRandomDate(), newPositions[0], newPositions[1], newPositions[2]});
            }
        }
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
}
