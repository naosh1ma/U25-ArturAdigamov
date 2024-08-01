package New;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelSettings extends JPanel {
    JLabel lblSettings;
    JLabel lblPlayers;
    JLabel lblThemes;
    JCheckBox chckbxTheme1;
    JCheckBox chckbxTheme2;
    JCheckBox chckbxTheme3;
    JCheckBox chckbxTheme4;
    JCheckBox chckbxTheme5;
    JComboBox comboBoxPlayer;
    JButton btnStart;
    JButton btnBack;


    PanelSettings() {

        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        this.setBounds(0, 0, 734, 561);

        lblSettings = new JLabel("Einstellungen");
        lblPlayers = new JLabel("Modus:");
        lblThemes = new JLabel("Themen:");
        chckbxTheme1 = new JCheckBox("Autos");
        chckbxTheme2 = new JCheckBox("Sport");
        chckbxTheme3 = new JCheckBox("Flaggen");
        chckbxTheme4 = new JCheckBox("Tiere");
        chckbxTheme5 = new JCheckBox("Flugzeuge");
        comboBoxPlayer = new JComboBox(new DefaultComboBoxModel(new String[] { "Singleplayer", "1 vs Bot", "1 vs 1" }));
        btnStart = new JButton("Start");
        btnBack = new JButton("Zurück");


        lblSettings.setFont(new Font("Arial", Font.PLAIN, 30));
        lblPlayers.setFont(new Font("Arial", Font.PLAIN, 25));
        lblThemes.setFont(new Font("Arial", Font.PLAIN, 25));
        chckbxTheme1.setFont(new Font("Arial", Font.PLAIN, 20));
        chckbxTheme2.setFont(new Font("Arial", Font.PLAIN, 20));
        chckbxTheme3.setFont(new Font("Arial", Font.PLAIN, 20));
        chckbxTheme4.setFont(new Font("Arial", Font.PLAIN, 20));
        chckbxTheme5.setFont(new Font("Arial", Font.PLAIN, 20));
        comboBoxPlayer.setFont(new Font("Arial", Font.PLAIN, 20));
        btnStart.setFont(new Font("Arial", Font.PLAIN, 25));
        btnBack.setFont(new Font("Arial", Font.PLAIN, 25));

        lblSettings.setBounds(275, 75, 250, 60);
        lblPlayers.setBounds(120, 200, 150, 60);
        lblThemes.setBounds(480, 200, 150, 60);
        chckbxTheme1.setBounds(480, 270, 110, 30);
        chckbxTheme2.setBounds(480, 320, 110, 30);
        chckbxTheme3.setBounds(480, 370, 110, 30);
        chckbxTheme4.setBounds(480, 420, 110, 30);
        chckbxTheme5.setBounds(480, 470, 120, 30);
        comboBoxPlayer.setBounds(120, 270, 150, 30);
        btnStart.setBounds(250, 445, 120, 50);
        btnBack.setBounds(120, 445, 120, 50);

        this.add(lblSettings);
        this.add(lblPlayers);
        this.add(lblThemes);
        this.add(chckbxTheme1);
        this.add(chckbxTheme2);
        this.add(chckbxTheme3);
        this.add(chckbxTheme4);
        this.add(chckbxTheme5);
        this.add(comboBoxPlayer);
        this.add(btnStart);
        this.add(btnBack);
    }



}
