package NumberGuessingGame2;

import java.util.Random;
import java.util.Scanner;

public class Zahlenraten {

    private Random random = null; // Zufallzahlen Generator
    private Scanner scanner = null;
    private int randomZahl;               // Zufallzahl
    private int minZahl, maxZahl;
    private int minZ, maxZ;
    private int zahl;
    private boolean fortsetzen = true;
    private boolean gefunden = false;

    public Zahlenraten() {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
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

    public int getMinZ() {
        return minZ;
    }

    public void setMinZ(int minZ) {
        this.minZ = minZ;
    }

    public int getMaxZ() {
        return maxZ;
    }

    public void setMaxZ(int maxZ) {
        this.maxZ = maxZ;
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

    public void start() {

        System.out.print("Bitte kleinste Zahl eingeben: ");
        this.minZahl = scanner.nextInt();
        System.out.print("Bitte groesste Zahl eingeben: ");
        this.maxZahl = scanner.nextInt();

        sortiere_aufsteigend(this.minZahl, this.maxZahl);

    }

    public void sortiere_aufsteigend(int min, int max) {
        do {
            this.randomZahl = random.nextInt(min, max);
            this.minZ = min;
            this.maxZ = max;

            do {
                System.out.println("Raten Sie Zahl zwischen " + this.minZ + " und " + this.maxZ);
                this.zahl = scanner.nextInt();
                if (this.randomZahl == this.zahl) {
                    this.gefunden = true;
                } else {
                    if (this.zahl > this.randomZahl) {
                        this.maxZ = this.zahl;
                    } else {
                        this.minZ = this.zahl;
                    }
                }
            }
            while (!this.gefunden);

            System.out.println("Die Zaufallzahl war: " + this.zahl);
            System.out.println("Wollen Sie wieter spielen (j/n)?: ");
            if (scanner.next().equals("n")) {
                this.fortsetzen = false;
            } else {
                this.gefunden = false;
            }
        } while (this.fortsetzen);
    }
}
