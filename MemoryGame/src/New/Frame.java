package New;

import javax.swing.*;

public class Frame extends JFrame{
    Frame(){

        this.add(new PanelSettings());
        this.setBounds(100, 100, 750, 600);
        this.setTitle("Memory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
