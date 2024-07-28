package Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class GameView extends JFrame {

    private static final long serialVersionUID = 1L;

    private GameModel model;
    private JPanel contentPane;

    //=====Welcome Attributen==================
    private JPanel panelWelcome;
    private JLabel lblWelcome;
    private JButton btnGameEasy;
    private JButton btnGameNorm;
    private JButton btnGameHard;
    private JButton btnThemes;
    private JButton btnRangList;

    //=====Game Attributen=================
    private JPanel panelGame;
    private JPanel panelGameField;
    private JButton btnGameNewStart;
    private JButton btnGameEnd;
    private ArrayList<JButton> buttonsGame;
    private JLabel lblScore;
    private JLabel lblTry;



    public GameView(GameModel model, ActionListener listener) {
        /*
        add(panelWelcome);
        contentPane.setVisability();
        */
        this.model = model;
        buttonsGame = new ArrayList<>();

        for (int i = 0; i < 64; i++) {
            JButton button = new JButton();
            button.setBackground(new Color(205, 255, 255));
            button.addActionListener(listener);
            buttonsGame.add(button);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 600);
        setTitle("Memory Game");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        welcomePanel();
        setVisible(true);
    }

    private void welcomePanel() {

        panelWelcome = new JPanel();
        panelWelcome.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelWelcome.setLayout(null);

        lblWelcome = new JLabel("Willkommen zur Memory");
        btnGameEasy = new JButton("4 x 5");
        btnGameNorm = new JButton("6 x 6");
        btnGameHard = new JButton("8 x 8");
        btnThemes = new JButton("Themen");
        btnRangList = new JButton("Ranglist");

        lblWelcome.setFont(new Font("Arial", Font.PLAIN, 26));
        btnGameEasy.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameNorm.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameHard.setFont(new Font("Arial", Font.PLAIN, 15));
        btnThemes.setFont(new Font("Arial", Font.PLAIN, 15));
        btnRangList.setFont(new Font("Arial", Font.PLAIN, 15));

        panelWelcome.setBounds(0, 0, 734, 561);
        lblWelcome.setBounds(115, 75, 400, 60);
        btnGameEasy.setBounds(50, 220, 95, 45);
        btnGameNorm.setBounds(50, 276, 95, 45);
        btnGameHard.setBounds(50, 332, 95, 45);
        btnThemes.setBounds(243, 276, 95, 45);
        btnRangList.setBounds(243, 332, 95, 45);

        btnGameEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //model.initGame(4, 5);
                gamePanel(4, 5);
            }
        });

        btnGameNorm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //model.initGame(6, 6);
                gamePanel(6, 6);
            }
        });

        btnGameHard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //model.initGame(8, 8);
                gamePanel(8, 8);
            }
        });

        btnThemes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        btnRangList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        panelWelcome.add(lblWelcome);
        panelWelcome.add(btnGameEasy);
        panelWelcome.add(btnGameNorm);
        panelWelcome.add(btnGameHard);
        panelWelcome.add(btnThemes);
        panelWelcome.add(btnRangList);
        updatePanel(panelWelcome);
    }

    private void gamePanel(int row_size, int col_size) {
        model.initGame(row_size, col_size);
        panelGame = new JPanel();
        panelGame.setLayout(null);
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

        panelGame.setBounds(0, 0, 734, 561);
        panelGameField.setBounds(0, 1, 734, 503);
        btnGameEnd.setBounds(607, 515, 105, 35);
        btnGameNewStart.setBounds(479, 515, 105, 35);
        lblScore.setBounds(25, 520, 105, 25);
        lblTry.setBounds(180, 520, 105, 25);

        btnGameEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                welcomePanel();
            }
        });

        btnGameNewStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gamePanel(row_size, col_size);
            }
        });

        addButtons(row_size, col_size);
        panelGame.add(panelGameField);
        panelGame.add(btnGameEnd);
        panelGame.add(btnGameNewStart);
        panelGame.add(lblScore);
        panelGame.add(lblTry);
        updatePanel(panelGame);
    }

    private void addButtons(int row_size, int col_size) {
        for (int i = 0; i < row_size * col_size; i++) {
//            JButton button = new JButton();
//            button.setBackground(new Color(205, 255, 255));
//            button.addActionListener(listener);
//            buttonsGame.add(button);
            panelGameField.add(buttonsGame.get(i));
        }
    }


    private void updatePanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    //=====================================================================

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
