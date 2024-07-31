package New;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelMenu extends JPanel {

    private JLabel lblWelcome;
    private JButton btnGameEasy;
    private JButton btnGameNorm;
    private JButton btnGameHard;
    private JButton btnRangList;
    private JComboBox comboBoxThemes;
    private JLabel lblThemes;

    public PanelMenu() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

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

        lblWelcome.setBounds(115, 75, 400, 60);
        btnGameEasy.setBounds(50, 220, 95, 45);
        btnGameNorm.setBounds(50, 276, 95, 45);
        btnGameHard.setBounds(50, 332, 95, 45);
        btnRangList.setBounds(243, 332, 95, 45);
        comboBoxThemes.setBounds(243, 295, 95, 22);
        lblThemes.setBounds(243, 254, 95, 30);

//        btnGameEasy.addListener();
//        btnGameNorm.addListener();
//        btnGameHard.addListener();
//        btnRangList.addListener();
//        comboBoxThemes.addListener();


    }

}
