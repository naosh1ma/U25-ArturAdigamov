package NumberGuessingGame2;

import javax.swing.*;

public class View {

    // Klassen Konstanten
    public static final int CONSOLE = 1;
    public static final int TEXTFIELD = 2;
    public static final int TEXTAREA = 3;
    public static final int LABEL = 4;

    // Private Attribut
    private int output = ' ';
    private JTextField out2 = null;
    private JTextArea out3 = null;
    private JLabel out4 = null;

    // Konstruktor
    public View(int output) {
        this.output = output;
    }

    // Service Methoden
    public void write(String line) {
        switch (output) {
            case 1:
                System.out.print(line);
                break;
            case 2:
                out2.setText(line);
                break;
            case 3:
                out3.append(line);
                System.out.println("View: "+out3.hashCode());
                break;
            case 4:
                out4.setText(line);
                break;
            default: System.out.println("Unbekantes Ausgabegeraet "+output+"!");
        }
    }

    public void writeLn(String line) {
        write(line + "\n");
    }

    // Overloading der Metode setOutputDevice
    public void setOutputDevice(JTextField out) {
        this.out2 = out;
    }

    public void setOutputDevice(JTextArea out) {
        this.out3 = out;
    }

    public void setOutputDevice(JLabel out) {
        this.out4 = out;
    }
}
