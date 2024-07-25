package NumberGuessingGameGUI;

import java.util.Random;
import java.util.Scanner;

public class Zahlenraten {
    // Variablen
    private final Random random;   // Zufallzahlen Generator
    private final Scanner scanner; // Eingabe Objekt
    private Output output;           // Ausgabe auf Console
    private int randomZahl;        // Zufallzahl
    private int minZahl, maxZahl;  // Intervalgrenzen
    private int zahl;              // Tippzahl
    private int minZ, maxZ;        // Hilfsvariablen

    // Konstruktoren
    public Zahlenraten() {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.output = new Output(Output.CONSOLE);
    }

    public Zahlenraten(int min, int max) {
        this();
        this.minZahl = min;
        this.maxZahl = max;
    }

    // Schnittstellen-Methoden
    public Output getOutput() {
        return output;
    }
    public void setOutput(Output output) {
        this.output = output;
    }
    public int getMinZahl() {
        return minZahl;
    }
    public void setMinZahl(int minZahl) {
        this.minZahl = minZahl;
    }
    public int getMaxZahl() {
        return maxZahl;
    }
    public void setMaxZahl(int maxZahl) {
        this.maxZahl = maxZahl;
    }
    public int getZahl() {
        return zahl;
    }
    public void setZahl(int zahl) {
        this.zahl = zahl;
    }
    public int getRandomZahl() {
        return randomZahl;
    }
    public void setRandomZahl(int randomZahl) {
        this.randomZahl = randomZahl;
    }

    // Sonstige Methoden
    public void start() {
        boolean fortsetzen = true;
        boolean gefunden = false;
        sortiere_aufsteigend();
        do {
            // zu erratende Zahl erzeugen und speichern
            initGame();
            do {
                this.output.writeLn(info());
                setZahl(this.scanner.nextInt());
                gefunden = testZahl();
            }
            while (!gefunden);
            System.out.println("Sie haben gewonnen!");
            System.out.println("Die Zaufallzahl war: " + getZahl() + "\n");
            System.out.println("Wollen Sie wieter spielen (j/n)?: ");
            if (this.scanner.next().equalsIgnoreCase("n")) {
                fortsetzen = false;
            } else {
                gefunden = false;
            }
        } while (fortsetzen);
    }

    // Daten Interface Zahlraten (API)
    public String info() {
        return "Raten Sie Zahl zwischen " + minZ + " und " + maxZ + "!";
    }

    public boolean testZahl() {
        boolean found = false;
        if (getRandomZahl() == getZahl()) {
            found = true;
        } else {
            if (getZahl() > getRandomZahl()) {
                maxZ = getZahl();
            } else {
                minZ = getZahl();
            }
        }
        return found;
    }

    public void initGame() {
        this.randomZahl = this.random.nextInt(getMaxZahl() - getMinZahl() + 1) + getMinZahl();
        minZ = getMinZahl();
        maxZ = getMaxZahl();
    }
    // API Ende

    /**
     * Die Methode sortiert zwei Zahlen unter Verwendung des Swap-Algorithmus in aufsteigender Reihenfolge
     *
     */
    public void sortiere_aufsteigend() {
        int temp;
        if (getMaxZahl() < getMinZahl()) {
            temp = getMaxZahl();
            setMaxZahl(getMinZahl());
            setMinZahl(temp);
        }
    }
}
