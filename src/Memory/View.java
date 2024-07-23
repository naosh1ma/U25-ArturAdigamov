package memory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelWelcome;
	private JPanel panelThemes;
	private JPanel panelGameEasy;
	private JPanel panelGameNorm;
	private JPanel panelGameHard;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelGameNorm = new JPanel();
		panelGameNorm.setBounds(0, 0, 634, 411);
		contentPane.add(panelGameNorm);
		panelGameNorm.setLayout(null);
		
		JButton btnGameNorm_1_1 = new JButton("");
		btnGameNorm_1_1.setBounds(80, 30, 50, 50);
		panelGameNorm.add(btnGameNorm_1_1);
		
		JButton btnGameNorm_1_2 = new JButton("");
		btnGameNorm_1_2.setBounds(160, 30, 50, 50);
		panelGameNorm.add(btnGameNorm_1_2);
		
		JButton btnGameNorm_1_3 = new JButton("");
		btnGameNorm_1_3.setBounds(240, 30, 50, 50);
		panelGameNorm.add(btnGameNorm_1_3);
		
		JButton btnGameNorm_1_4 = new JButton("");
		btnGameNorm_1_4.setBounds(320, 30, 50, 50);
		panelGameNorm.add(btnGameNorm_1_4);
		
		JButton btnGameNorm_1_5 = new JButton("");
		btnGameNorm_1_5.setBounds(400, 30, 50, 50);
		panelGameNorm.add(btnGameNorm_1_5);
		
		JButton btnGameNorm_1_6 = new JButton("");
		btnGameNorm_1_6.setBounds(480, 30, 50, 50);
		panelGameNorm.add(btnGameNorm_1_6);
		
		JButton btnGameNorm_2_1 = new JButton("");
		btnGameNorm_2_1.setBounds(80, 91, 50, 50);
		panelGameNorm.add(btnGameNorm_2_1);
		
		JButton btnGameNorm_2_2 = new JButton("");
		btnGameNorm_2_2.setBounds(160, 91, 50, 50);
		panelGameNorm.add(btnGameNorm_2_2);
		
		JButton btnGameNorm_9 = new JButton("");
		btnGameNorm_9.setBounds(240, 91, 50, 50);
		panelGameNorm.add(btnGameNorm_9);
		
		JButton btnGameNorm_10 = new JButton("");
		btnGameNorm_10.setBounds(320, 91, 50, 50);
		panelGameNorm.add(btnGameNorm_10);
		
		JButton btnGameNorm_11 = new JButton("");
		btnGameNorm_11.setBounds(400, 91, 50, 50);
		panelGameNorm.add(btnGameNorm_11);
		
		JButton btnGameNorm_12 = new JButton("");
		btnGameNorm_12.setBounds(480, 91, 50, 50);
		panelGameNorm.add(btnGameNorm_12);
		
		JButton btnGameNorm_13 = new JButton("");
		btnGameNorm_13.setBounds(80, 152, 50, 50);
		panelGameNorm.add(btnGameNorm_13);
		
		JButton btnGameNorm_14 = new JButton("");
		btnGameNorm_14.setBounds(160, 152, 50, 50);
		panelGameNorm.add(btnGameNorm_14);
		
		JButton btnGameNorm_15 = new JButton("");
		btnGameNorm_15.setBounds(240, 152, 50, 50);
		panelGameNorm.add(btnGameNorm_15);
		
		JButton btnGameNorm_16 = new JButton("");
		btnGameNorm_16.setBounds(320, 152, 50, 50);
		panelGameNorm.add(btnGameNorm_16);
		
		JButton btnGameNorm_17 = new JButton("");
		btnGameNorm_17.setBounds(400, 152, 50, 50);
		panelGameNorm.add(btnGameNorm_17);
		
		JButton btnGameNorm_18 = new JButton("");
		btnGameNorm_18.setBounds(480, 152, 50, 50);
		panelGameNorm.add(btnGameNorm_18);
		
		JButton btnGameNorm_4_1 = new JButton("");
		btnGameNorm_4_1.setBounds(80, 213, 50, 50);
		panelGameNorm.add(btnGameNorm_4_1);
		
		JButton btnGameNorm_4_2 = new JButton("");
		btnGameNorm_4_2.setBounds(160, 213, 50, 50);
		panelGameNorm.add(btnGameNorm_4_2);
		
		JButton btnGameNorm_4_3 = new JButton("");
		btnGameNorm_4_3.setBounds(240, 213, 50, 50);
		panelGameNorm.add(btnGameNorm_4_3);
		
		JButton btnGameNorm_4_4 = new JButton("");
		btnGameNorm_4_4.setBounds(320, 213, 50, 50);
		panelGameNorm.add(btnGameNorm_4_4);
		
		JButton btnGameNorm_4_5 = new JButton("");
		btnGameNorm_4_5.setBounds(400, 213, 50, 50);
		panelGameNorm.add(btnGameNorm_4_5);
		
		JButton btnGameNorm_4_6 = new JButton("");
		btnGameNorm_4_6.setBounds(480, 213, 50, 50);
		panelGameNorm.add(btnGameNorm_4_6);
		
		JButton btnGameNorm_5_1 = new JButton("");
		btnGameNorm_5_1.setBounds(80, 274, 50, 50);
		panelGameNorm.add(btnGameNorm_5_1);
		
		JButton btnGameNorm_5_2 = new JButton("");
		btnGameNorm_5_2.setBounds(160, 274, 50, 50);
		panelGameNorm.add(btnGameNorm_5_2);
		
		JButton btnGameNorm_5_3 = new JButton("");
		btnGameNorm_5_3.setBounds(240, 274, 50, 50);
		panelGameNorm.add(btnGameNorm_5_3);
		
		JButton btnGameNorm_5_4 = new JButton("");
		btnGameNorm_5_4.setBounds(320, 274, 50, 50);
		panelGameNorm.add(btnGameNorm_5_4);
		
		JButton btnGameNorm_5_5 = new JButton("");
		btnGameNorm_5_5.setBounds(400, 274, 50, 50);
		panelGameNorm.add(btnGameNorm_5_5);
		
		JButton btnGameNorm_5_6 = new JButton("");
		btnGameNorm_5_6.setBounds(480, 274, 50, 50);
		panelGameNorm.add(btnGameNorm_5_6);
		
		JButton btnGameNorm_6_1 = new JButton("");
		btnGameNorm_6_1.setBounds(80, 335, 50, 50);
		panelGameNorm.add(btnGameNorm_6_1);
		
		JButton btnGameNorm_6_2 = new JButton("");
		btnGameNorm_6_2.setBounds(160, 335, 50, 50);
		panelGameNorm.add(btnGameNorm_6_2);
		
		JButton btnGameNorm_6_3 = new JButton("");
		btnGameNorm_6_3.setBounds(240, 335, 50, 50);
		panelGameNorm.add(btnGameNorm_6_3);
		
		JButton btnGameNorm_6_4 = new JButton("");
		btnGameNorm_6_4.setBounds(320, 335, 50, 50);
		panelGameNorm.add(btnGameNorm_6_4);
		
		JButton btnGameNorm_6_5 = new JButton("");
		btnGameNorm_6_5.setBounds(400, 335, 50, 50);
		panelGameNorm.add(btnGameNorm_6_5);
		
		JButton btnGameNorm_6_6 = new JButton("");
		btnGameNorm_6_6.setBounds(480, 335, 50, 50);
		panelGameNorm.add(btnGameNorm_6_6);
		
		panelGameEasy = new JPanel();
		panelGameEasy.setBounds(0, 0, 634, 411);
		contentPane.add(panelGameEasy);
		panelGameEasy.setLayout(null);
		
		JButton btnGameEasy_1 = new JButton("");
		btnGameEasy_1.setBounds(60, 30, 75, 75);
		panelGameEasy.add(btnGameEasy_1);
		
		JButton btnGameEasy_2 = new JButton("");
		btnGameEasy_2.setBounds(165, 30, 75, 75);
		panelGameEasy.add(btnGameEasy_2);
		
		JButton btnGameEasy_3 = new JButton("");
		btnGameEasy_3.setBounds(270, 30, 75, 75);
		panelGameEasy.add(btnGameEasy_3);
		
		JButton btnGameEasy_4 = new JButton("");
		btnGameEasy_4.setBounds(375, 30, 75, 75);
		panelGameEasy.add(btnGameEasy_4);
		
		JButton btnGameEasy_5 = new JButton("");
		btnGameEasy_5.setBounds(480, 30, 75, 75);
		panelGameEasy.add(btnGameEasy_5);
		
		JButton btnGameEasy_6 = new JButton("");
		btnGameEasy_6.setBounds(60, 125, 75, 75);
		panelGameEasy.add(btnGameEasy_6);
		
		JButton btnGameEasy_7 = new JButton("");
		btnGameEasy_7.setBounds(165, 125, 75, 75);
		panelGameEasy.add(btnGameEasy_7);
		
		JButton btnGameEasy_8 = new JButton("");
		btnGameEasy_8.setBounds(270, 125, 75, 75);
		panelGameEasy.add(btnGameEasy_8);
		
		JButton btnGameEasy_9 = new JButton("");
		btnGameEasy_9.setBounds(375, 125, 75, 75);
		panelGameEasy.add(btnGameEasy_9);
		
		JButton btnGameEasy_10 = new JButton("");
		btnGameEasy_10.setBounds(480, 125, 75, 75);
		panelGameEasy.add(btnGameEasy_10);
		
		JButton btnGameEasy_11 = new JButton("");
		btnGameEasy_11.setBounds(60, 220, 75, 75);
		panelGameEasy.add(btnGameEasy_11);
		
		JButton btnGameEasy_12 = new JButton("");
		btnGameEasy_12.setBounds(165, 220, 75, 75);
		panelGameEasy.add(btnGameEasy_12);
		
		JButton btnGameEasy_13 = new JButton("");
		btnGameEasy_13.setBounds(270, 220, 75, 75);
		panelGameEasy.add(btnGameEasy_13);
		
		JButton btnGameEasy_14 = new JButton("");
		btnGameEasy_14.setBounds(375, 220, 75, 75);
		panelGameEasy.add(btnGameEasy_14);
		
		JButton btnGameEasy_15 = new JButton("");
		btnGameEasy_15.setBounds(480, 220, 75, 75);
		panelGameEasy.add(btnGameEasy_15);
		
		JButton btnGameEasy_16 = new JButton("");
		btnGameEasy_16.setBounds(270, 314, 75, 75);
		panelGameEasy.add(btnGameEasy_16);
		
		JButton btnGameEasy_17 = new JButton("");
		btnGameEasy_17.setBounds(60, 314, 75, 75);
		panelGameEasy.add(btnGameEasy_17);
		
		JButton btnGameEasy_18 = new JButton("");
		btnGameEasy_18.setBounds(165, 314, 75, 75);
		panelGameEasy.add(btnGameEasy_18);
		
		JButton btnGameEasy_19 = new JButton("");
		btnGameEasy_19.setBounds(375, 314, 75, 75);
		panelGameEasy.add(btnGameEasy_19);
		
		JButton btnGameEasy_20 = new JButton("");
		btnGameEasy_20.setBounds(480, 314, 75, 75);
		panelGameEasy.add(btnGameEasy_20);
		
		panelThemes = new JPanel();
		panelThemes.setBounds(0, 0, 634, 411);
		contentPane.add(panelThemes);
		panelThemes.setLayout(null);
		
		JCheckBox chckbxThemeAnimal = new JCheckBox("Tieren");
		chckbxThemeAnimal.setFont(new Font("Arial", Font.PLAIN, 15));
		chckbxThemeAnimal.setBounds(60, 130, 200, 45);
		panelThemes.add(chckbxThemeAnimal);
		
		JCheckBox chckbxThemeCars = new JCheckBox("Autos");
		chckbxThemeCars.setFont(new Font("Arial", Font.PLAIN, 15));
		chckbxThemeCars.setBounds(60, 178, 200, 45);
		panelThemes.add(chckbxThemeCars);
		
		JCheckBox chckbxFlowers = new JCheckBox("Blümen");
		chckbxFlowers.setFont(new Font("Arial", Font.PLAIN, 15));
		chckbxFlowers.setBounds(60, 226, 200, 45);
		panelThemes.add(chckbxFlowers);
		
		JButton btnConfirm = new JButton("Bestätigen");
		btnConfirm.setFont(new Font("Arial", Font.PLAIN, 15));
		btnConfirm.setBounds(454, 322, 120, 45);
		panelThemes.add(btnConfirm);
		
		JButton btnBack = new JButton("Zurück");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBack.setBounds(60, 322, 120, 45);
		panelThemes.add(btnBack);
		
		panelWelcome = new JPanel();
		panelWelcome.setBounds(0, 0, 634, 411);
		panelWelcome.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panelWelcome);
		panelWelcome.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Willkommen zur Memory");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 26));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(115, 75, 400, 60);
		panelWelcome.add(lblWelcome);
		
		JButton btnGameEasy = new JButton("4 x 5");
		btnGameEasy.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGameEasy.setBounds(50, 220, 95, 45);
		panelWelcome.add(btnGameEasy);
		
		JButton btnGameNorm_0;
		btnGameNorm_0 = new JButton("6 x 6");
		btnGameNorm_0.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGameNorm_0.setBounds(50, 276, 95, 45);
		panelWelcome.add(btnGameNorm_0);
		
		JButton btnGameHard = new JButton("8 x 8");
		btnGameHard.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGameHard.setBounds(50, 332, 95, 45);
		panelWelcome.add(btnGameHard);
		
		JButton btnThemes = new JButton("Themen");
		btnThemes.setHorizontalAlignment(SwingConstants.LEADING);
		btnThemes.setFont(new Font("Arial", Font.PLAIN, 15));
		btnThemes.setBounds(243, 276, 95, 45);
		panelWelcome.add(btnThemes);
		
		JButton btnRangList = new JButton("Ranglist");
		btnRangList.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRangList.setBounds(243, 332, 95, 45);
		panelWelcome.add(btnRangList);
		
		panelGameHard = new JPanel();
		panelGameHard.setBounds(328, 10, 1, 1);
		contentPane.add(panelGameHard);
		panelGameHard.setLayout(null);
		
	}
}
