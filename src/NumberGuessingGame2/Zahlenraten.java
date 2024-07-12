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
    public void start() {
        System.out.print("Bitte untere Intervalgrenze eingeben: ");
        setMinZahl(this.scanner.nextInt());
        System.out.print("Bitte oberste Intervalgrenze eingeben: ");
        setMaxZahl(this.scanner.nextInt());

        int minZ, maxZ;
        boolean fortsetzen = true;
        boolean gefunden = false;

        sortiere_aufsteigend();

        do {
            // zu erratende Zahl erzeugen und speichern
            this.randomZahl = this.random.nextInt(getMinZahl(), getMaxZahl());
            minZ = getMinZahl();
            maxZ = getMaxZahl();
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
            if (this.scanner.next().equalsIgnoreCase("n")) {
                fortsetzen = false;
            } else {
                gefunden = false;
            }
        } while (fortsetzen);
    }

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
