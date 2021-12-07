import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class RaceProbability {

    JTable probabilityTable = new JTable();
    ArrayList<Integer> startingPositions = new ArrayList<Integer>();
    ArrayList<Formula1Driver> driversDuplicate = new ArrayList<Formula1Driver>();
    String date;

    public RaceProbability() {

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
        probabilityTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Race date", "1st place", "2nd place", "3rd place"}));  // Table heading.


          // Filling the table.
        probabilityTable.setBackground(Color.white);
        probabilityTable.setForeground(Color.black);
        probabilityTable.setGridColor(Color.blue);
        probabilityTable.setSelectionBackground(Color.blue);
        probabilityTable.setSelectionForeground(Color.white);
        probabilityTable.setFont(new Font("Serif", Font.PLAIN, 16));
        probabilityTable.setRowHeight(25);

        // Pane
        JScrollPane pane= new JScrollPane(probabilityTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.blue);
        pane.setBounds(5, 190, 820, 570);
        frame.getContentPane().add(pane);


        // Generating the random date.
        int randomDate = (int) (Math.random() * (27 - 1 + 1) + 1);
        String dd = Integer.toString(randomDate);
        int randomMonth = (int) (Math.random() * (11 - 1 + 1) + 1);
        String MM = Integer.toString(randomMonth);

        date = dd + "/" + MM + "/" + "2021";

        driversDuplicate.addAll(Formula1ChampionshipManager.drivers);
        String[] positionsStorage = new String[10];

        for (Formula1Driver driver : Formula1ChampionshipManager.drivers) {

            int startingPosition;
            while (true) {
                while (true) {
                    startingPosition = (int) (Math.random() * Formula1ChampionshipManager.drivers.size()) + 1;
                    if (!startingPositions.contains(startingPosition)) {
                        startingPositions.add(startingPosition);
                        break;
                    }
                }
                int randomNumber = (int) (Math.random() * 100)+1;
                if (startingPosition == 1) {
                    if (randomNumber>0 && randomNumber < 41) {
                       positionsStorage[0] = driver.getDriverName();
                       driver.setPoints(25);
                       driver.setPosition1(1);
                       driver.setNumOfRaces(1);
                       driversDuplicate.remove(driver);

                        Collections.shuffle(driversDuplicate);
                        for (int c=1; c < 10; c++) {

                            if (c == 1) {
                                positionsStorage[1] = driver.getDriverName();
                                driver.setPoints(18);
                                driver.setPosition2(1);

                            } else if (c == 2) {
                                positionsStorage[2] = driver.getDriverName();
                                driver.setPoints(15);
                                driver.setPosition3(1);

                            }else if (c == 3) {
                                positionsStorage[3] = driver.getDriverName();
                                driver.setPoints(12);

                            }else if (c == 4) {
                                positionsStorage[4] = driver.getDriverName();
                                driver.setPoints(10);

                            }else if (c == 5) {
                                positionsStorage[5] = driver.getDriverName();
                                driver.setPoints(8);

                            }else if (c == 6) {
                                positionsStorage[6] = driver.getDriverName();
                                driver.setPoints(6);

                            }else if (c == 7) {
                                positionsStorage[7] = driver.getDriverName();
                                driver.setPoints(4);

                            }else if (c == 8) {
                                positionsStorage[8] = driver.getDriverName();
                                driver.setPoints(2);

                            }else {
                                positionsStorage[9] = driver.getDriverName();
                                driver.setPoints(1);
                            }
                        }
                       break;
                    }
                }else if (startingPosition == 2) {
                    if (randomNumber > 39 && randomNumber < 71) {
                        positionsStorage[0] = driver.getDriverName();
                        driver.setPoints(25);
                        driver.setPosition1(1);
                        driver.setNumOfRaces(1);
                        driversDuplicate.remove(driver);
                        Collections.shuffle(driversDuplicate);
                        for (int c=1; c < 10; c++) {

                            if (c == 1) {
                                positionsStorage[1] = driver.getDriverName();
                                driver.setPoints(18);
                                driver.setPosition2(1);

                            } else if (c == 2) {
                                positionsStorage[2] = driver.getDriverName();
                                driver.setPoints(15);
                                driver.setPosition3(1);

                            }else if (c == 3) {
                                positionsStorage[3] = driver.getDriverName();
                                driver.setPoints(12);

                            }else if (c == 4) {
                                positionsStorage[4] = driver.getDriverName();
                                driver.setPoints(10);

                            }else if (c == 5) {
                                positionsStorage[5] = driver.getDriverName();
                                driver.setPoints(8);

                            }else if (c == 6) {
                                positionsStorage[6] = driver.getDriverName();
                                driver.setPoints(6);

                            }else if (c == 7) {
                                positionsStorage[7] = driver.getDriverName();
                                driver.setPoints(4);

                            }else if (c == 8) {
                                positionsStorage[8] = driver.getDriverName();
                                driver.setPoints(2);

                            }else {
                                positionsStorage[9] = driver.getDriverName();
                                driver.setPoints(1);
                            }
                        }
                        break;
                    }
                }else if (startingPosition == 3) {
                    if (randomNumber > 69 && randomNumber < 81) {
                        positionsStorage[0] = driver.getDriverName();
                        driver.setPoints(25);
                        driver.setPosition1(1);
                        driver.setNumOfRaces(1);
                        driversDuplicate.remove(driver);
                        Collections.shuffle(driversDuplicate);
                        for (int c=1; c < 10; c++) {

                            if (c == 1) {
                                positionsStorage[1] = driver.getDriverName();
                                driver.setPoints(18);
                                driver.setPosition2(1);

                            } else if (c == 2) {
                                positionsStorage[2] = driver.getDriverName();
                                driver.setPoints(15);
                                driver.setPosition3(1);

                            }else if (c == 3) {
                                positionsStorage[3] = driver.getDriverName();
                                driver.setPoints(12);

                            }else if (c == 4) {
                                positionsStorage[4] = driver.getDriverName();
                                driver.setPoints(10);

                            }else if (c == 5) {
                                positionsStorage[5] = driver.getDriverName();
                                driver.setPoints(8);

                            }else if (c == 6) {
                                positionsStorage[6] = driver.getDriverName();
                                driver.setPoints(6);

                            }else if (c == 7) {
                                positionsStorage[7] = driver.getDriverName();
                                driver.setPoints(4);

                            }else if (c == 8) {
                                positionsStorage[8] = driver.getDriverName();
                                driver.setPoints(2);

                            }else {
                                positionsStorage[9] = driver.getDriverName();
                                driver.setPoints(1);
                            }
                        }
                        break;
                    }
                }else if (startingPosition == 4) {
                    if (randomNumber > 79 && randomNumber < 91) {
                        positionsStorage[0] = driver.getDriverName();
                        driver.setPoints(25);
                        driver.setPosition1(1);
                        driver.setNumOfRaces(1);
                        driversDuplicate.remove(driver);
                        Collections.shuffle(driversDuplicate);
                        for (int c=1; c < 10; c++) {

                            if (c == 1) {
                                positionsStorage[1] = driver.getDriverName();
                                driver.setPoints(18);
                                driver.setPosition2(1);

                            } else if (c == 2) {
                                positionsStorage[2] = driver.getDriverName();
                                driver.setPoints(15);
                                driver.setPosition3(1);

                            }else if (c == 3) {
                                positionsStorage[3] = driver.getDriverName();
                                driver.setPoints(12);

                            }else if (c == 4) {
                                positionsStorage[4] = driver.getDriverName();
                                driver.setPoints(10);

                            }else if (c == 5) {
                                positionsStorage[5] = driver.getDriverName();
                                driver.setPoints(8);

                            }else if (c == 6) {
                                positionsStorage[6] = driver.getDriverName();
                                driver.setPoints(6);

                            }else if (c == 7) {
                                positionsStorage[7] = driver.getDriverName();
                                driver.setPoints(4);

                            }else if (c == 8) {
                                positionsStorage[8] = driver.getDriverName();
                                driver.setPoints(2);

                            }else {
                                positionsStorage[9] = driver.getDriverName();
                                driver.setPoints(1);
                            }
                        }
                        break;
                    }
                }else if (startingPosition > 4 && startingPosition < 10 ) {
                    if (randomNumber > 89 && randomNumber < 93) {
                        positionsStorage[0] = driver.getDriverName();
                        driver.setPoints(25);
                        driver.setPosition1(1);
                        driver.setNumOfRaces(1);
                        driversDuplicate.remove(driver);
                        Collections.shuffle(driversDuplicate);
                        for (int c=1; c < 10; c++) {

                            if (c == 1) {
                                positionsStorage[1] = driver.getDriverName();
                                driver.setPoints(18);
                                driver.setPosition2(1);

                            } else if (c == 2) {
                                positionsStorage[2] = driver.getDriverName();
                                driver.setPoints(15);
                                driver.setPosition3(1);

                            }else if (c == 3) {
                                positionsStorage[3] = driver.getDriverName();
                                driver.setPoints(12);

                            }else if (c == 4) {
                                positionsStorage[4] = driver.getDriverName();
                                driver.setPoints(10);

                            }else if (c == 5) {
                                positionsStorage[5] = driver.getDriverName();
                                driver.setPoints(8);

                            }else if (c == 6) {
                                positionsStorage[6] = driver.getDriverName();
                                driver.setPoints(6);

                            }else if (c == 7) {
                                positionsStorage[7] = driver.getDriverName();
                                driver.setPoints(4);

                            }else if (c == 8) {
                                positionsStorage[8] = driver.getDriverName();
                                driver.setPoints(2);

                            }else {
                                positionsStorage[9] = driver.getDriverName();
                                driver.setPoints(1);
                            }
                        }
                        break;
                    }
                }else {
                    driver.setNumOfRaces(1);
                    Collections.shuffle(driversDuplicate);
                    for (int c=1; c < 10; c++) {

                        if (c == 1) {
                            positionsStorage[1] = driver.getDriverName();
                            driver.setPoints(18);
                            driver.setPosition2(1);

                        } else if (c == 2) {
                            positionsStorage[2] = driver.getDriverName();
                            driver.setPoints(15);
                            driver.setPosition3(1);

                        }else if (c == 3) {
                            positionsStorage[3] = driver.getDriverName();
                            driver.setPoints(12);

                        }else if (c == 4) {
                            positionsStorage[4] = driver.getDriverName();
                            driver.setPoints(10);

                        }else if (c == 5) {
                            positionsStorage[5] = driver.getDriverName();
                            driver.setPoints(8);

                        }else if (c == 6) {
                            positionsStorage[6] = driver.getDriverName();
                            driver.setPoints(6);

                        }else if (c == 7) {
                            positionsStorage[7] = driver.getDriverName();
                            driver.setPoints(4);

                        }else if (c == 8) {
                            positionsStorage[8] = driver.getDriverName();
                            driver.setPoints(2);

                        }else {
                            positionsStorage[9] = driver.getDriverName();
                            driver.setPoints(1);
                        }
                    }
                    break;
                }
                break;
            }
        }
        Formula1ChampionshipManager.races.add(new RaceData(date, positionsStorage));
        ((DefaultTableModel) probabilityTable.getModel()).addRow(new Object[]{date, positionsStorage[0], positionsStorage[1],positionsStorage[2]});
    }
}

