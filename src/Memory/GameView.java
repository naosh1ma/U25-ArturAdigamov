package Memory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;


public class GameView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    //=====Welcome Attributen==================
    private JPanel panelWelcome;
    private JLabel lblWelcome;
    private JButton btnGameEasy;
    private JButton btnGameNorm;
    private JButton btnGameHard;
    private JButton btnThemes;
    private JButton btnRangList;

    //=====GameEasy Attributen=================
    private JPanel panelGameEasy;
    private JPanel panelGameEasyField;
    private JButton[][] buttonsGameEasy;
    private JButton btnGameEasyNewStart;
    private JButton btnGameEasyEnd;
    final int ROW_SIZE = 4;
    final int COLUMN_SIZE = 5;

    public GameView(GameModel model) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Welcome Anfang===============================================
        panelWelcome = new JPanel();
        panelWelcome.setBounds(0, 0, 634, 411);
        panelWelcome.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(panelWelcome);
        panelWelcome.setLayout(null);

        lblWelcome = new JLabel("Willkommen zur Memory");
        lblWelcome.setFont(new Font("Arial", Font.PLAIN, 26));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setBounds(115, 75, 400, 60);
        panelWelcome.add(lblWelcome);

        btnGameEasy = new JButton("4 x 5");
        btnGameEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startEasy();
                getContentPane().removeAll();
                getContentPane().add(panelGameEasy);
                getContentPane().revalidate();
                getContentPane().repaint();

            }
        });
        btnGameEasy.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameEasy.setBounds(50, 220, 95, 45);
        panelWelcome.add(btnGameEasy);

        btnGameNorm = new JButton("6 x 6");
        btnGameNorm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnGameNorm.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameNorm.setBounds(50, 276, 95, 45);
        panelWelcome.add(btnGameNorm);

        btnGameHard = new JButton("8 x 8");
        btnGameHard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

        //Welcome Ende=====================================================



    }

    private void startEasy() {
        panelGameEasy = new JPanel();
        panelGameEasyField = new JPanel();
        panelGameEasy.setBounds(0, 0, 634, 411);
        panelGameEasyField.setBounds(0, 1, 634, 350);
        panelGameEasy.setLayout(null);
        panelGameEasyField.setLayout(new GridLayout(ROW_SIZE, COLUMN_SIZE));
        panelGameEasy.add(panelGameEasyField);
        buttonsGameEasy = new JButton[ROW_SIZE][COLUMN_SIZE];

        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                buttonsGameEasy[i][j] = new JButton();
                panelGameEasyField.add(buttonsGameEasy[i][j]);
            }
        }

        btnGameEasyEnd = new JButton("Beenden");
        btnGameEasyEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnGameEasyEnd.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameEasyEnd.setBounds(517, 362, 105, 35);
        panelGameEasy.add(btnGameEasyEnd);

        btnGameEasyNewStart = new JButton("Neustarten");
        btnGameEasyNewStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnGameEasyNewStart.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameEasyNewStart.setBounds(389, 362, 105, 35);
        panelGameEasy.add(btnGameEasyNewStart);
    }
}
