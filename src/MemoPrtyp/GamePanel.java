package MemoPrtyp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private GameModel model;
    private JPanel panelGameField;
    private JButton btnGameNewStart;
    private JButton btnGameEnd;
    private ArrayList<JButton> buttonsGame;
    private JLabel lblScore;
    private JLabel lblTry;

    boolean running = false;

    GamePanel(int row_size, int col_size) {

        //model.initGame(row_size, col_size);
        buttonsGame = new ArrayList<>();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(734, 600));
        model = new GameModel(row_size,col_size);
        panelGameField = new JPanel();
        panelGameField.setLayout(new GridLayout(row_size, col_size));

        btnGameEnd = new JButton("Beenden");
        btnGameNewStart = new JButton("Neustarten");
        lblScore = new JLabel("Score: ");
        lblTry = new JLabel("Try: ");

        btnGameEnd.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameNewStart.setFont(new Font("Arial", Font.PLAIN, 15));
        lblScore.setFont(new Font("Arial", Font.PLAIN, 15));
        lblTry.setFont(new Font("Arial", Font.PLAIN, 15));

        this.setBounds(0, 0, 734, 561);
        panelGameField.setBounds(0, 1, 734, 503);
        btnGameEnd.setBounds(607, 515, 105, 35);
        btnGameNewStart.setBounds(479, 515, 105, 35);
        lblScore.setBounds(25, 520, 105, 25);
        lblTry.setBounds(180, 520, 105, 25);

        btnGameEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnGameNewStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //gamePanel(row_size, col_size);
            }
        });

        addButtons(row_size, col_size);
        this.add(panelGameField);
        this.add(btnGameEnd);
        this.add(btnGameNewStart);
        this.add(lblScore);
        this.add(lblTry);
        //updatePanel(panelGame);
    }

    private void addButtons(int row_size, int col_size) {
        for (int i = 0; i < row_size * col_size; i++) {
            JButton button = new JButton();
            button.setBackground(new Color(205, 255, 255));
            button.addActionListener(new ButtonListener());
            buttonsGame.add(button);
            panelGameField.add(buttonsGame.get(i));
        }
    }



    public class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int index = getButtonIndex(button);

        if (button.getIcon() == null) {
            //model.setOpenCard(index);
            //setButtonIcon(index, model.getIcon(index));

            if (model.areBothCardsOpen()) {
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        checkForMatch();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
        repaint();
    }

}

    private void checkForMatch() {
        int[] openedCards = model.getOpenedCards();
        if (model.checkMatch()) {
            disableButton(openedCards[0]);
            disableButton(openedCards[1]);
            if (model.isPairFound()) {
                showGameOverMessage();
            }
        } else {
            resetButtonIcon(openedCards[0]);
            resetButtonIcon(openedCards[1]);
        }
        model.resetOpenedCards();
    }

    public void setActionListener(ActionListener listener) {
        for (JButton button : buttonsGame) {
            button.addActionListener(listener);
        }
    }

    public JButton getButton(int index) {
        return buttonsGame.get(index);
    }

    public int getButtonIndex(JButton button) {
        return buttonsGame.indexOf(button);
    }

    public void disableButton(int index) {
        buttonsGame.get(index).setEnabled(false);
    }

    public void resetButtonIcon(int index) {
        buttonsGame.get(index).setIcon(null);
    }

    public void setButtonIcon(int index, ImageIcon icon) {
        buttonsGame.get(index).setIcon(icon);
    }

    public void showGameOverMessage() {
        JOptionPane.showMessageDialog(this, "Du hast alle Paaren gefunden!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }


    public JLabel getLblScore( ) {
        return lblScore;
    }
    public void setScore(int score) {
        lblScore.setText("Score: " + score);
    }
}
