
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int alter, ein, rad, mal;
        String name, spiel;

        System.out.print("Wie ist dein Name? ");
        name = scanner.next();
        System.out.print("Herzlich Willkommen, " + name + ". Wie alt bist du? ");
        alter = scanner.nextInt();

        if (alter < 18) {
            System.out.println("Du darfst nicht spielen. Bye");
        } else {

            spiel = "Ja";
            mal = 0;
            System.out.print("Dein Einsatz: ");
            ein = scanner.nextInt();

            while (spiel.equalsIgnoreCase("Ja")) {

                System.out.println("Dreh Glucksrad");

                rad = random.nextInt(1, 13);
                System.out.println("Zahl ist " + rad + ".");

                switch (rad) {
                    case 1, 3, 5, 7, 9, 11:
                        System.out.println("Du hast gewonnen! Dein Gewinn ist " + ein + ".");
                        ein = ein * 2;
                        System.out.println("Dein Einsatz ist jetzt " + ein + ".\n");
                        break;
                    case 12:
                        ein = ein - ein;
                        System.out.println("Du hast alles verloren.\n");
                        break;
                    default:
                        System.out.println("Du hast nicht verloren. Dein Einsatz bleibt " + ein + ".\n");
                        break;
                }

                mal++;

                if (ein == 0) {
                    spiel = "Nein";
                    System.out.println(" Du hast kein Geld. Du kannst nicht weiter spielen.");
                } else {
                    System.out.print("Willst du weiter spielen? ");
                    spiel = scanner.next();
                }
            }
            System.out.println("Du hast " + mal + " mal gespielt und " + ein + " Euro gewonnen.");
            System.out.println("Komm wieder!");
        }
        scanner.close();
    }
}
