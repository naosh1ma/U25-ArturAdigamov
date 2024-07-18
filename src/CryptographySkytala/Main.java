package CryptographySkytala;

import java.io.File;

public class Main {

    MyFrame frame = null;
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
        char[] textfield, codefield = null;
        String output = "";
        int lines = z;
        if(!frame.getTextOrig().getText().equals("")) {
            String temp =  frame.getTextOrig().getText();
            textfield = temp.toCharArray();
            codefield = new char[textfield.length];
            int i = 0;
            for(int z = 0; z < lines; z++) {
                for(int s = z; s < textfield.length; s = s+lines) {
                    codefield[i] = textfield[s];
                    i++;
                }
            }
        }
        for( int c =0; c < codefield.length; c++){
            output = output + "" + codefield[c];
        }
        frame.getTextCode().setText(output);
    }
}

