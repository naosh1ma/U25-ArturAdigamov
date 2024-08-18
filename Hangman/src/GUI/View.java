package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame {
    private JPanel panel;
    private JLabel lblWord;
    private ArrayList<JButton> buttons;
    private JButton btnRestart;
    private JButton btnEnd;

    View(){
        buttons = new ArrayList<>();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        createInterface();
        createKeyboard();
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 650, 550);
        this.setTitle("Hangman");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void createKeyboard() {
        buttons = new ArrayList<>();
        int x = 70;
        int y = 280;
        String letter = "QWERTYUIOPASDFGHJKLZXCVBNM";

        for(int i = 0; i < 26; i++) {
            JButton btn = new JButton();
            btn.setText(Character.toString(letter.charAt(i)));
            btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
            btn.setBounds(x , y, 45, 45);
            if(i == 9) {y = 331; x = 40;}
            if(i == 18) {y = 382; x = 85;}
            x = x + 50;
            buttons.add(btn);
            panel.add(btn);

        }
    }

    public void createInterface() {

        lblWord = new JLabel();
        btnRestart = new JButton("Neustart");
        btnEnd = new JButton("Beenden");

        lblWord.setFont(new Font("Tahoma", Font.PLAIN, 40));
        btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEnd.setFont(new Font("Tahoma", Font.PLAIN, 15));

        lblWord.setHorizontalAlignment(SwingConstants.CENTER);


        lblWord.setBounds(10,180,615,100);
        btnRestart.setBounds(150,450, 120,40);
        btnEnd.setBounds(360,450, 120,40);


        panel.add(lblWord);
        panel.add(btnRestart);
        panel.add(btnEnd);
    }

    public void disableButtons(int index){
        buttons.get(index).setEnabled(false);
    }
    public int getButtonIndex(JButton button){
        return buttons.indexOf(button);
    }
    public void setWordLabel(String word){
        lblWord.setText(word);
    }

    public void resetButtons(){
        for (JButton button : buttons) {
            button.setEnabled(true);
        }
    }









    public void addListener(ActionListener listener){
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }
    public void addRestartListener(ActionListener listener){btnRestart.addActionListener(listener);}
    public void addEndListener(ActionListener listener){btnEnd.addActionListener(listener);}
}
