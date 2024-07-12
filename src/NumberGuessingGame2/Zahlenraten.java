package NumberGuessingGame2;

import java.util.Random;
import java.util.Scanner;

public class Zahlenraten {
    // Variablen
    private final Random random; // Zufallzahlen Generator
    private final Scanner scanner;
    private int randomZahl;               // Zufallzahl
    private int minZahl, maxZahl;
    private int zahl;

    public Zahlenraten() {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public Zahlenraten(int min, int max) {
        this();
        this.minZahl = min;
        this.maxZahl = max;
        sortiere_aufsteigend(min, max);
    }

    // Schnittstellen-Methoden
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


    /**
     *
     */
    public void start() {
        System.out.print("Bitte kleinste Zahl eingeben: ");
        this.minZahl = this.scanner.nextInt();
        System.out.print("Bitte groesste Zahl eingeben: ");
        this.maxZahl = this.scanner.nextInt();

        sortiere_aufsteigend(this.minZahl, this.maxZahl);
    }

    /**
     *
     *
     * @param min
     * @param max
     */
    public void sortiere_aufsteigend(int min, int max) {
        int minZ, maxZ;
        boolean fortsetzen = true;
        boolean gefunden = false;
        do {
            this.randomZahl = this.random.nextInt(min, max); // zu erratende Zahl erzeugen und speichern
            minZ = min;
            maxZ = max;
            do {
                System.out.println("Raten Sie Zahl zwischen " + minZ + " und " + maxZ + "!");
                setZahl(this.scanner.nextInt());
                if (getRandomZahl() == getZahl()) {
                    gefunden = true;
                } else {
                    if (getZahl() > getRandomZahl()) {
                        maxZ = getZahl();
                    } else {
                        minZ = getZahl();
                    }
                }
            }
            while (!gefunden);

            System.out.println("Sie haben gewonnen!");
            System.out.println("Die Zaufallzahl war: " + getZahl() + "\n");
            System.out.println("Wollen Sie wieter spielen (j/n)?: ");
            if (this.scanner.next().equals("n")) {
                fortsetzen = false;
            } else {
                gefunden = false;
            }
        } while (fortsetzen);
    }
}
