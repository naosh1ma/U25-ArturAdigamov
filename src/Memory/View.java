package memory;


import Memory.Model;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;


public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelWelcome;
	private JPanel panelGameHard;



	/**
	 * Create the frame.
	 */
	public View(Model model) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JButton btnGameNorm = new JButton("6 x 6");
		btnGameNorm.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGameNorm.setBounds(50, 276, 95, 45);
		panelWelcome.add(btnGameNorm);
		
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
		panelGameHard.setBounds(0, 0, 634, 411);
		contentPane.add(panelGameHard);
		panelGameHard.setLayout(null);
		
	}
}
