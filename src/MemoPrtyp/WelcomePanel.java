package MemoPrtyp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel implements ActionListener {

    private GameModel model;
    private GameFrame gameFrame;

    private JLabel lblWelcome;
    private JButton btnGameEasy;
    private JButton btnGameNorm;
    private JButton btnGameHard;
    private JButton btnRangList;
    private JComboBox comboBoxThemes;
    private JLabel lblThemes;
    private int rows, cols;

    WelcomePanel(GameFrame frame) {
        this.gameFrame = frame;
        this.setPreferredSize(new Dimension(734, 600));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);

        lblWelcome = new JLabel("Willkommen zur Memory");
        lblThemes = new JLabel("Themen:");
        btnGameEasy = new JButton("4 x 5");
        btnGameNorm = new JButton("6 x 6");
        btnGameHard = new JButton("8 x 8");
        btnRangList = new JButton("Ranglist");
        comboBoxThemes = new JComboBox();

        comboBoxThemes.setModel(new DefaultComboBoxModel(new String[] { "Autos", "Sport", "Flaggen" }));
        comboBoxThemes.setSelectedIndex(0);

        lblWelcome.setFont(new Font("Arial", Font.PLAIN, 26));
        btnGameEasy.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameNorm.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameHard.setFont(new Font("Arial", Font.PLAIN, 15));
        btnRangList.setFont(new Font("Arial", Font.PLAIN, 15));
        comboBoxThemes.setFont(new Font("Arial", Font.PLAIN, 15));
        lblThemes.setFont(new Font("Arial", Font.PLAIN, 15));

        this.setBounds(0, 0, 734, 561);
        lblWelcome.setBounds(115, 75, 400, 60);
        btnGameEasy.setBounds(50, 220, 95, 45);
        btnGameNorm.setBounds(50, 276, 95, 45);
        btnGameHard.setBounds(50, 332, 95, 45);
        btnRangList.setBounds(243, 332, 95, 45);
        comboBoxThemes.setBounds(243, 295, 95, 22);
        lblThemes.setBounds(243, 254, 95, 30);

        comboBoxThemes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int z = comboBoxThemes.getSelectedIndex();
                model.setTheme(z);
            }
        });

        btnGameEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rows = 4;
                cols = 5;
                gameFrame.add(new GamePanel(rows,cols),0);
                gameFrame.revalidate();
                gameFrame.repaint();
                model = new GameModel(rows,cols);
                //model.initGame(4, 5);
                //gamePanel(4, 5);
            }
        });

        btnGameNorm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rows = 6;
                cols = 6;
                gameFrame.add(new GamePanel(rows,cols));
                //model = new GameModel(rows,cols);
                //model.initGame(6, 6);
                //gamePanel(6, 6);
            }
        });

        btnGameHard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rows = 8;
                cols = 8;
                gameFrame.add(new GamePanel(rows,cols));
                //model = new GameModel(rows,cols);
                //model.initGame(8, 8);
                //gamePanel(8, 8);
            }
        });

        btnRangList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        this.add(lblWelcome);
        this.add(btnGameEasy);
        this.add(btnGameNorm);
        this.add(btnGameHard);
        this.add(btnRangList);
        this.add(comboBoxThemes);
        this.add(lblThemes);
        //updatePanel(panelWelcome);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        //this.add(new GamePanel());
        //contentPane.setVisability();
        repaint();
    }
}
