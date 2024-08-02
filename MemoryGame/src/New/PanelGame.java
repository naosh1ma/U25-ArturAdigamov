package New;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelGame extends JPanel {
    // Attributen
    private JPanel panelGameField;
    private JButton btnGameNewStart;
    private JButton btnGameEnd;
    private ArrayList<JButton> buttonsGame;
    private JLabel lblScore;
    private JLabel lblTry;

    // Konstruktoren
    PanelGame() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(734, 600));
        this.setBounds(0, 0, 734, 561);

        btnGameEnd = new JButton("Beenden");
        btnGameNewStart = new JButton("Neustarten");
        lblScore = new JLabel("Score: ");
        lblTry = new JLabel("Try: ");

        btnGameEnd.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameNewStart.setFont(new Font("Arial", Font.PLAIN, 15));
        lblScore.setFont(new Font("Arial", Font.PLAIN, 15));
        lblTry.setFont(new Font("Arial", Font.PLAIN, 15));

        btnGameEnd.setBounds(607, 515, 105, 35);
        btnGameNewStart.setBounds(479, 515, 105, 35);
        lblScore.setBounds(25, 520, 105, 25);
        lblTry.setBounds(180, 520, 105, 25);

        this.add(btnGameEnd);
        this.add(btnGameNewStart);
        this.add(lblScore);
        this.add(lblTry);
    }

    // Methoden
    public JLabel getLblScore() {return lblScore;}
    public JButton getButton(int index) {return buttonsGame.get(index);}
    public int getButtonIndex(JButton button) {return buttonsGame.indexOf(button);}
    public void setScore(int score) {lblScore.setText("Score: " + score);}
    public void setButtonIcon(int index, ImageIcon icon) {buttonsGame.get(index).setIcon(icon);}

    public void addGameEndListener(ActionListener listener) {btnGameEnd.addActionListener(listener);}
    public void addGameNewStartListener(ActionListener listener) {btnGameNewStart.addActionListener(listener);}
    public void addGameFieldButtonsListener(ActionListener listener) {
        for (JButton button : buttonsGame) {
            button.addActionListener(listener);
        }
    }
    private void createGameField(int row_size, int col_size) {
        buttonsGame = new ArrayList<>();
        panelGameField = new JPanel();
        panelGameField.setLayout(new GridLayout(row_size, col_size));
        panelGameField.setBounds(0, 1, 734, 503);
        addButtons(row_size, col_size);
        this.add(panelGameField);
    }
    private void addButtons(int row_size, int col_size) {
        for (int i = 0; i < row_size * col_size; i++) {
            JButton button = new JButton();
            button.setBackground(new Color(205, 255, 255));
            buttonsGame.add(button);
            panelGameField.add(buttonsGame.get(i));
        }
    }
    public void disableButton(int index) {
        buttonsGame.get(index).setEnabled(false);
    }
    public void resetButtonIcon(int index) {
        buttonsGame.get(index).setIcon(null);
    }
    public void showGameOverMessage() {
        JOptionPane.showMessageDialog(this, "Du hast alle Paaren gefunden!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }
}
