package memory;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;

public class PanelThemes extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelThemes() {
		
		JPanel panelThemes = new JPanel();
		panelThemes.setLayout(null);
		add(panelThemes);
		
		JCheckBox chckbxThemeAnimal = new JCheckBox("Sport");
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

	}

}
