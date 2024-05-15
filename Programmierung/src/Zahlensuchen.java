import java.util.Random;
import java.util.Scanner;

public class Zahlensuchen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int typ, spalte, zeile, suche, mal = 0;
        boolean spiel = true, runde = true;
        String position = "", antwort;

        do {
            System.out.print(CS.GREEN_BRIGHT);
            System.out.println("Was fuer Array wollen Sie erstellen?: ");
            System.out.print(CS.PURPLE_BRIGHT);
            System.out.print("(1 - 1D, 2 - 2D): ");
            typ = scanner.nextInt();

            if (typ == 1) {
                System.out.print(CS.GREEN_BRIGHT);
                System.out.println("Sie haben sich fuer 1D Array entschieden");
                System.out.println();
                System.out.print("Wiel lang soll Array sein? : ");
                spalte = scanner.nextInt();
                System.out.println();

                int arr[] = new int[spalte];

                for (int i = 0; i < spalte; i++) {

                    arr[i] = random.nextInt(0, 100);
                }
                System.out.print(CS.YELLOW_BRIGHT);
                System.out.print("Welche Zahl suchen Sie?(1-100): ");
                suche = scanner.nextInt();
                System.out.println();
                for (int i = 0; i < spalte; i++) {
                    if (suche == arr[i]) {
                        position = position + i + " ";
                        mal++;
                        System.out.print(CS.YELLOW_BRIGHT);
                        System.out.print(arr[i] + " ");
                    } else {
                        System.out.print(CS.RED_BRIGHT);
                        System.out.print(arr[i] + " ");
                    }

                }
                System.out.println();

                if (mal > 0) {
                    System.out.println(CS.CYAN_BRIGHT);
                    System.out.println("Die zahl " + CS.YELLOW_BRIGHT + suche + CS.CYAN_BRIGHT + " wurde " + CS.YELLOW_BRIGHT + mal + CS.CYAN_BRIGHT + " Mal gefunden auf Position " + CS.YELLOW_BRIGHT + position+ CS.RESET);
                    System.out.println();
                } else {
                    System.out.println(CS.CYAN_BRIGHT);
                    System.out.println("Die zahl " + CS.YELLOW_BRIGHT+ suche + CS.CYAN_BRIGHT +" wurde " +CS.YELLOW_BRIGHT + mal + CS.CYAN_BRIGHT +" Mal gefunden.");
                    System.out.println();
                }
                mal = 0;
                position = "";
                do {
                    System.out.print(CS.GREEN_BRIGHT);
                    System.out.print("Spielen wir noch mal?(ja/nein): ");
                    antwort = scanner.next();
                    if (antwort.equalsIgnoreCase("Ja")) {

                        System.out.println("Dann spielen wir noch eine Runde");
                        System.out.println();
                        runde = false;
                    } else if (antwort.equalsIgnoreCase("Nein")) {

                        System.out.println("Auf Wiedersehen");
                        runde = false;
                        spiel = false;
                    } else {

                        System.out.println("Falsche Eingabe");
                        System.out.println();
                        runde = true;
                    }
                    System.out.print(CS.RESET);
                } while (runde);

            } else if (typ == 2) {
                System.out.print(CS.GREEN_BRIGHT);
                System.out.println("Sie haben sich fuer 2D Array entschieden");
                System.out.println();
                System.out.println("Bitte geben Sie Spalte und Zeile ein.");
                System.out.print(CS.PURPLE_BRIGHT);
                System.out.print("Spalte: ");
                spalte = scanner.nextInt();
                System.out.print("Zeile: ");
                zeile = scanner.nextInt();
                System.out.println();

                int arr2[][] = new int[zeile][spalte];

                for (int i = 0; i < zeile; i++) {

                    for (int j = 0; j < spalte; j++) {

                        arr2[i][j] = random.nextInt(0, 100);
                    }
                }
                System.out.print(CS.YELLOW_BRIGHT);
                System.out.print("Welche Zahl suchen Sie?(1-100): ");
                suche = scanner.nextInt();
                System.out.println();

                for (int i = 0; i < zeile; i++) {
                    for (int j = 0; j < spalte; j++) {


                        if (suche == arr2[i][j]) {
                            position = position + "[" + i + " , " + j + "] ";
                            mal++;
                            System.out.print(CS.YELLOW_BRIGHT);
                            System.out.print(arr2[i][j] + " ");
                        } else {
                            System.out.print(CS.RED_BRIGHT);
                            System.out.print(arr2[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
                if (mal > 0) {
                    System.out.println(CS.CYAN_BRIGHT);
                    System.out.println("Die zahl " + CS.YELLOW_BRIGHT + suche + CS.CYAN_BRIGHT + " wurde " + CS.YELLOW_BRIGHT + mal + CS.CYAN_BRIGHT + " Mal gefunden auf Position " + CS.YELLOW_BRIGHT + position + CS.RESET);
                    System.out.println();
                } else {
                    System.out.println(CS.CYAN_BRIGHT);
                    System.out.println("Die zahl " + CS.YELLOW_BRIGHT+ suche + CS.CYAN_BRIGHT +" wurde " +CS.YELLOW_BRIGHT + mal + CS.CYAN_BRIGHT +" Mal gefunden.");
                    System.out.println();
                }
                mal = 0;
                position = "";
                do {
                    System.out.print(CS.GREEN_BRIGHT);
                    System.out.print("Spielen wir noch mal?(ja/nein): ");
                    antwort = scanner.next();
                    if (antwort.equalsIgnoreCase("Ja")) {

                        System.out.println("Dann spielen wir noch eine Runde");
                        System.out.println();
                        runde = false;
                    } else if (antwort.equalsIgnoreCase("Nein")) {

                        System.out.println("Auf Wiedersehen");
                        runde = false;
                        spiel = false;
                    } else {

                        System.out.println("Falsche Eingabe");
                        System.out.println();
                        runde = true;
                    }
                    System.out.print(CS.RESET);
                } while (runde);

            } else {
                System.out.println("Falsche Eingabe");
            }


        } while (spiel);
        scanner.close();
    }
}
