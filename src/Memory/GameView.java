package Memory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class GameView extends JFrame {

    private static final long serialVersionUID = 1L;

    ActionListener listener;
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
    private ArrayList<JButton> buttonsGame;
    private JButton btnGameNewStart;
    private JButton btnGameEnd;
    private JLabel lblScore;
    private JLabel lblTry;


    public GameView(GameModel model) {

        /*
        add(panelWelcome);
        contentPane.setVisability();
        */

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 600);
        setTitle("Memory Game");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        welcome(model);
    }

    private void welcome(GameModel model) {

        panelWelcome = new JPanel();
        panelWelcome.setBounds(0, 0, 734, 561);
        panelWelcome.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelWelcome.setLayout(null);

        lblWelcome = new JLabel("Willkommen zur Memory");
        lblWelcome.setFont(new Font("Arial", Font.PLAIN, 26));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setBounds(115, 75, 400, 60);
        panelWelcome.add(lblWelcome);

        btnGameEasy = new JButton("4 x 5");
        btnGameEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame(4, 5, model);
            }
        });
        btnGameEasy.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameEasy.setBounds(50, 220, 95, 45);
        panelWelcome.add(btnGameEasy);

        btnGameNorm = new JButton("6 x 6");
        btnGameNorm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame(6, 6, model);
            }
        });
        btnGameNorm.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameNorm.setBounds(50, 276, 95, 45);
        panelWelcome.add(btnGameNorm);

        btnGameHard = new JButton("8 x 8");
        btnGameHard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame(8, 8, model);
            }
        });
        btnGameHard.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameHard.setBounds(50, 332, 95, 45);
        panelWelcome.add(btnGameHard);

        btnThemes = new JButton("Themen");
        btnThemes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnThemes.setHorizontalAlignment(SwingConstants.LEADING);
        btnThemes.setFont(new Font("Arial", Font.PLAIN, 15));
        btnThemes.setBounds(243, 276, 95, 45);
        panelWelcome.add(btnThemes);

        btnRangList = new JButton("Ranglist");
        btnRangList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnRangList.setFont(new Font("Arial", Font.PLAIN, 15));
        btnRangList.setBounds(243, 332, 95, 45);
        panelWelcome.add(btnRangList);
        updatePanel(panelWelcome);
    }

    private void startGame(int row_size, int col_size, GameModel model) {
        //model = new GameModel();
        model.setDiff(row_size * col_size);
        panelGame = new JPanel();
        panelGameField = new JPanel();
        panelGame.setBounds(0, 0, 734, 561);
        panelGameField.setBounds(0, 1, 734, 503);
        panelGame.setLayout(null);
        panelGameField.setLayout(new GridLayout(row_size, col_size));
        panelGame.add(panelGameField);
        buttonsGame = new ArrayList<>();


        for (int i = 0; i < row_size * col_size; i++) {
            JButton button = new JButton();
            //button.setIcon(model.getIcon(i));
            button.setBackground(new Color(205, 255, 255));
            button.addActionListener(listener);
            buttonsGame.add(button);
            panelGameField.add(buttonsGame.get(i));
        }

        btnGameEnd = new JButton("Beenden");
        btnGameEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                welcome(model);
            }
        });
        btnGameEnd.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameEnd.setBounds(607, 515, 105, 35);
        panelGame.add(btnGameEnd);

        btnGameNewStart = new JButton("Neustarten");
        btnGameNewStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame(row_size, col_size, model);
            }
        });
        btnGameNewStart.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameNewStart.setBounds(479, 515, 105, 35);
        panelGame.add(btnGameNewStart);

        lblScore = new JLabel("Score: ");
        lblScore.setFont(new Font("Arial", Font.PLAIN, 15));
        lblScore.setBounds(25, 520, 105, 25);
        panelGame.add(lblScore);

        lblTry = new JLabel("Try: ");
        lblTry.setFont(new Font("Arial", Font.PLAIN, 15));
        lblTry.setBounds(180, 520, 105, 25);
        panelGame.add(lblTry);
        updatePanel(panelGame);
    }

    private void updatePanel(JPanel panelGame) {
        getContentPane().removeAll();
        getContentPane().add(panelGame);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    //=====================================================================
    public void addButtonListener(ActionListener listener) {
        this.listener = listener;
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
        JOptionPane.showMessageDialog(this, "You found all pairs!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

}
