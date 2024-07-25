package memory;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class PanelGameEasy extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton[][] buttons;
	private final int ROW_SIZE = 4;
	private final int COLUMN_SIZE =5;


	public PanelGameEasy() {
		
		JPanel panelGameEasy = new JPanel();
		panelGameEasy.setLayout(new GridLayout(ROW_SIZE, COLUMN_SIZE));
		add(panelGameEasy);
		
		buttons = new JButton[ROW_SIZE][COLUMN_SIZE];

        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                buttons[i][j] = new JButton();
                panelGameEasy.add(buttons[i][j]);
            }
        }

	}

}
