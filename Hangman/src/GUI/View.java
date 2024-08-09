package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame {
    private JPanel panel;
    private JLabel lblHangman;
    private JLabel lblWord;
    private ArrayList<JButton> buttons;
    private JButton btnRestart;
    private JButton btnEnd;

    View(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 550);
        setTitle("Hangman");
        setVisible(true);
        setLocationRelativeTo(null);
        buttons = new ArrayList<>();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        createKeyboard();
        createInterface();
        add(panel);
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
            panel.add(btn);
            buttons.add(btn);
        }
    }

    public void createInterface() {

        lblHangman = new JLabel();
        lblWord = new JLabel("---");
        btnRestart = new JButton("Neustart");
        btnEnd = new JButton("Beenden");

        lblHangman.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblWord.setFont(new Font("Tahoma", Font.PLAIN, 40));
        btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEnd.setFont(new Font("Tahoma", Font.PLAIN, 15));

        lblHangman.setHorizontalAlignment(SwingConstants.CENTER);
        lblWord.setHorizontalAlignment(SwingConstants.CENTER);



//        lblHangman.setForeground(Color.RED);
//        lblWord.setForeground(Color.BLACK);
//
//        lblHangman.setBackground(Color.PINK);
//        lblWord.setBackground(Color.PINK);

        lblHangman.setBounds(120,10,300,300);
        lblWord.setBounds(10,180,615,100);
        btnRestart.setBounds(150,450, 120,40);
        btnEnd.setBounds(360,450, 120,40);

        panel.add(lblHangman);
        panel.add(lblWord);
        panel.add(btnRestart);
        panel.add(btnEnd);
    }


    public void addListener(ActionListener listener){
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }
    public void addRestartListener(ActionListener listener){btnRestart.addActionListener(listener);}
    public void addEndListener(ActionListener listener){btnEnd.addActionListener(listener);}
}
