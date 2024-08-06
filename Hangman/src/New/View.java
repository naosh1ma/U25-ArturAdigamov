package New;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame {
    private ArrayList<JButton> buttons;
    private JPanel panel;
    View(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        setTitle("Hangman");
        setVisible(true);
        setLocationRelativeTo(null);
        buttons = new ArrayList<>();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(panel);
        createButtons();
    }

    public void createButtons() {
        buttons = new ArrayList<>();
        int x = 65;
        int y = 280;
        String letter = "QWERTYUIOPASDFGHJKLZXCVBNM";

        for(int i = 0; i < 26; i++) {
            JButton btn = new JButton();
            btn.setText(Character.toString(letter.charAt(i)));
            btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
            btn.setBounds(x , y, 45, 45);
            if(i == 9) {y = 331; x = 35;}
            if(i == 18) {y = 382; x = 65;}
            x = x + 50;
            panel.add(btn);
            buttons.add(btn);
        }
    }
    public void addListener(ActionListener listener){
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }
}
