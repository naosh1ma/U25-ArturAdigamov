package CryptographySkytala;

import javax.swing.*;
import java.awt.*;

public class Main {

    private MyFrame frame = null;
    private int z;

    public int getZ() {
        return z;
    }
    public void setZ(int z) {
        this.z = z;
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
    }

    public void crypt(MyFrame frame) {
        char[] textfield = null, codefield = null;
        String output = "";
        int lines = z;
        if (!frame.getTextOrig().getText().equals("")) {
            textfield = frame.getTextOrig().getText().toCharArray();
            codefield = new char[textfield.length];
            int i = 0;
            for (int z = 0; z < lines; z++) {
                for (int s = z; s < textfield.length; s = s + lines) {
                    codefield[i] = textfield[s];
                    i++;
                }
            }
        }
        for (int c = 0; c < codefield.length; c++) {
            output = output + "" + codefield[c];
        }
        frame.getTextCode().setText(output);
    }

    public void decrypt(MyFrame frame) {
        char[] textfield = null, codefield = null;
        String output = "";
        int lines = z;
        if (!frame.getTextOrig().getText().equals("")) {
            codefield = frame.getTextOrig().getText().toCharArray();
            textfield = new char[codefield.length];
            int i = 0;
            for (int z = 0; z < lines; z++) {
                for (int s = z; s < textfield.length; s = s + lines) {
                    textfield[s] = codefield[i];
                    i++;
                }
            }
        }
        for (int c = 0; c < codefield.length; c++) {
            output = output + "" + textfield[c];
        }
        frame.getTextCode().setText(output);
    }

    public void bruteForce(MyFrame frame) {
        for (int i = 2; i <= 10; i++) {
            setZ(i);
            decrypt(frame);
            if (JOptionPane.showConfirmDialog(null, "Richtig?") == 0) {
                break;
            }
        }
    }
}

