package MemoPrtyp;

import javax.swing.*;

public class GameFrame extends JFrame{
    GameFrame(){

        this.add(new WelcomePanel(this));
        this.setBounds(100, 100, 750, 600);
        this.setTitle("Memory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
