import javax.swing.*;

// Restart Game Button
//



public class Frame extends JFrame{
    // Attributen

    PanelMenu panelMenu;
    PanelSettings panelSettings;
    PanelGame panelGame;

    // Konstruktor
    Frame(){

        panelMenu = new PanelMenu();
        panelSettings = new PanelSettings();
        panelGame = new PanelGame();

        this.add(panelMenu);
        this.setBounds(100, 100, 750, 600);
        this.setTitle("Memory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    // Methoden
    public PanelGame getPanelGame() {return panelGame;}
    public PanelSettings getPanelSettings() {return panelSettings;}
    public PanelMenu getPanelMenu() {return panelMenu;}
}
