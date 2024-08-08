import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // objekte importieren
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        // variablen deklarieren
        int zahl, eingabe, versuch;
        boolean spiel;
        String antwort;
        // setzen spiel auf true
        spiel = true;
        System.out.println("\033[4;37mWillkommen bei Geheimzahlspiel.\n\033[0m");
        // do-while-schleife mit bedingung, dass spiel true ist
        do {
            // random zahl zwischen 1 und 100
            System.out.println("\033[0;37mIch habe die Zahl zwishen 1 und 100 ausgedacht. "
                    + "\nVersuche die zu raten.\n\033[0m");
            zahl = rd.nextInt(100) + 1;
            versuch = 0;
            // do-while-schleife mit bedingung, dass eingabe zahl nicht gleich ist
            do {
                // jeder schleife machen versuch +1
                versuch++;
                System.out.print("\033[0;94mGib dein \033[0;37m" + versuch + ".\033[0m\033[0;94m Versuch ein: ");
                System.out.print("\033[4;37m");
                eingabe = sc.nextInt();
                System.out.println("\033[0m");
                // eingabe und zahl vergleichen
                ausgaberat(zahl, eingabe);
                // wenn eingabe gleich zahl ist, dann kammen wir raus von do-while-schleife
            } while (eingabe != zahl || versuch != 3);
            // ausgabe und eingabe von antwort
            System.out.println("\033[0;37mDu hast " + versuch + " Versuche gebraucht.\033[0m");
            System.out.print("\033[0;37mWillst du nochmal spielen? \033[0m" + "\033[4;37m");
            antwort = sc.next();
            System.out.println("\033[0m");
            // wenn antwort ja ist, dann wird spiel nicht geendert, dh true und wir bleiben
            // in while-schleife
            spiel = antwort(antwort, spiel);
        } while (spiel);
        sc.close();
    }

    public static void ausgaberat(int zahl, int eingabe) {
        if (eingabe > 100 || eingabe < 0) {
            System.out.println("\033[1;33mBist du dumm? Die Zahl ist zwisschen 1 und 100.\033[0m");
        } else if (eingabe > zahl) {
            System.out.println(
                    "\033[0;96mLeider falsch, die Zahl ist kleiner als \033[0;37m" + eingabe + ".\033[0m");
        } else if (eingabe < zahl) {
            System.out.println(
                    "\033[0;91mLeider falsch, die Zahl ist grosser als \033[0;37m" + eingabe + ".\033[0m");
        } else {
            System.out.println("\033[4;32mBingo! Die Zahl ist " + zahl + ".\033[0m\n");
        }
    }

    public static boolean antwort(String antwort, boolean spiel) {
        if (antwort.equalsIgnoreCase("ja")) {
            System.out.println("\033[4;37mDann spielen wir nochmal.\n\033[0m");
            // wenn antwort nicht ja ist, dann wird spiel auf false gesetzt
        } else {
            // setzen spiel auf false, um von while-schleife raus zu kommen
            spiel = false;
            System.out.println("\033[4;37mBis bald.\033[0m");
        }
        return spiel;
    }
}
