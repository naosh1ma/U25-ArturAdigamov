import ConsoleColors.CS;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int spielFeld, spielTyp;
        boolean pass = true;

        do {
            System.out.print(CS.GREEN_BRIGHT + "Spielen Sie 1-Standardspiel oder 2-Systemspiel?: ");
            spielTyp = scanner.nextInt();
            System.out.println();
            if (spielTyp == 1 || spielTyp == 2) {
                pass = false;
            } else {
                System.out.println(CS.RED_BRIGHT + "Falsche Eingabe.");
            }
        } while (pass);

        System.out.print(CS.GREEN_BRIGHT + "Wieviel Spielfelder wollen Sie?: ");
        spielFeld = scanner.nextInt();
        System.out.println();

        switch (spielTyp) {
            case 1:
                arrayZiehung(arrayScannerStd(spielFeld));
                break;
            case 2:
                arrayZiehung(arrayScannerSys(spielFeld));
                break;
        }
        scanner.close();
    }

    public static int[][] arrayScannerStd(int spielFeld) { // fuer standardspiel

        Scanner scanner = new Scanner(System.in);
        int temp;
        boolean zahlGleich = true;
        int[][] arr_sc = new int[spielFeld][6];

        for (int i = 0; i < arr_sc.length; i++) {
            for (int j = 0; j < arr_sc[i].length; j++) {
                do {
                    System.out.print(CS.GREEN_BRIGHT + "Bitte geben Sie " + CS.WHITE + (j + 1) + CS.GREEN_BRIGHT
                            + ". Zahl beim " + CS.WHITE + (i + 1) + CS.GREEN_BRIGHT + ". Ticket ein: ");
                    temp = scanner.nextInt(); // eingabe von der zahl
                    System.out.print("");
                    if (temp > 0 && temp < 50) {
                        for (int k = 0; k < arr_sc[i].length; k++) {
                            if (temp == arr_sc[i][k]) { // prüfen, ob die zahl schon vorhanden ist
                                zahlGleich = true;
                                System.out.println(CS.RED_BRIGHT + "Zahl ist schon vorhanden.");
                                break;
                            } else {
                                zahlGleich = false;
                            }
                        }
                    } else {
                        System.out.println(CS.RED_BRIGHT + "Falsche Eingabe. Bitte geben Sie von 1 bis 49 ein!");
                        zahlGleich = true;
                    }
                } while (zahlGleich); // wiederholen bis zahlGleich true ist
                arr_sc[i][j] = temp; // speichern eingegebene zahl im array
            }
        }
        scanner.close();
        return arr_sc; // zurueckgabe des arrays
    }

    public static int[][] arrayScannerSys(int spielFeld) { // fue systemspiel

        Scanner scanner = new Scanner(System.in);
        int temp, zahlen;
        boolean zahlGleich = true, eingabe;
        int[][] arr_sc = new int[spielFeld][];

        for (int i = 0; i < arr_sc.length; i++) {
            do {
                System.out.print(CS.GREEN_BRIGHT + "Wieviel Zahlen wollen Sie auf " + CS.WHITE + (i + 1)
                        + CS.GREEN_BRIGHT + ". Spielfeld? (7-12): ");
                zahlen = scanner.nextInt();
                if (zahlen < 7 || zahlen > 12) {
                    System.out.println(CS.RED_BRIGHT + "Falsche eingabe. Bitte geben Sie von 7 bis 12 ein!");
                    System.out.println();
                    eingabe = true;
                } else {
                    eingabe = false;
                }
            } while (eingabe);
            System.out.println();
            arr_sc[i] = new int[zahlen];
            for (int j = 0; j < arr_sc[i].length; j++) {
                do {
                    System.out.print(CS.GREEN_BRIGHT + "Bitte geben Sie " + CS.WHITE + (j + 1) + CS.GREEN_BRIGHT
                            + ". Zahl beim " + CS.WHITE + (i + 1) + CS.GREEN_BRIGHT + ". Ticket ein: ");
                    temp = scanner.nextInt(); // eingabe von der zahl
                    System.out.print("");
                    if (temp > 0 && temp < 50) {
                        for (int k = 0; k < arr_sc[i].length; k++)
                            if (temp == arr_sc[i][k]) { // prüfen, ob die zahl schon vorhanden ist
                                zahlGleich = true;
                                System.out.println(CS.RED_BRIGHT + "Zahl ist schon vorhanden.");
                                break;
                            } else {
                                zahlGleich = false;
                            }
                    } else {
                        System.out.println(CS.RED_BRIGHT + "Falsche Eingabe. Bitte geben Sie von 1 bis 49 ein!");
                        zahlGleich = true;
                    }
                } while (zahlGleich); // wiederholen bis zahlGleich true ist
                arr_sc[i][j] = temp; // speichern eingegebene zahl im array
            }
        }
        scanner.close();
        return arr_sc; // wiedergabe des arrays
    }

    public static int[] arrayRandom() { // array erzeugen und das mit zufaelegen zahlen befuelen

        Random random = new Random();
        boolean zahlGleich = true;
        int temp;
        int[] arr_rd = new int[6];

        for (int i = 0; i < arr_rd.length; i++) {
            do {
                temp = random.nextInt(1, 50); // erzeugen zufälige zahl
                for (int j = 0; j < arr_rd.length; j++) {
                    if (temp == arr_rd[j]) { // prüfen, ob die zahl schon vorhanden ist
                        zahlGleich = true;
                        break;
                    } else {
                        zahlGleich = false;
                    }
                }
            } while (zahlGleich);
            arr_rd[i] = temp; // speichern zufälige zahl im array
        }
        return arr_rd; // rueckgabe des arrays
    }

    public static void arrayZiehung(int[][] arr_sc) {

        int gewinn6 = 2000000, gewinn5 = 5000, gewinn4 = 100, gewinn3 = 10, gewinn = 0;
        int wochenBisGewinn = 0, treffen = 0, investition = 0;
        int richtige3 = 0, richtige4 = 0, richtige5 = 0;
        int system7 = 10, system8 = 35, system9 = 100, system10 = 300, system11 = 600, system12 = 1200;

        do {
            int[] arr_rd = arrayRandom();

            for (int i = 0; i < arr_sc.length; i++) {
                treffen = 0;
                for (int j = 0; j < arr_sc[i].length; j++) {
                    for (int k = 0; k < arr_rd.length; k++) {
                        if (arr_rd[k] == arr_sc[i][j]) { // vergleich arrayRandom mit arrayScanner
                            treffen++;
                            break;
                        }
                    }
                }
                switch (treffen) { // gewinn berechnen mit
                    case 3:
                        gewinn = gewinn + gewinn3;
                        richtige3++;
                        break;
                    case 4:
                        gewinn = gewinn + gewinn4;
                        richtige4++;
                        break;
                    case 5:
                        gewinn = gewinn + gewinn5;
                        richtige5++;
                        break;
                    case 6:
                        gewinn = gewinn + gewinn6;
                        break;
                }
            }
            wochenBisGewinn++;
        } while (treffen < 6);

        int teilung = wochenBisGewinn / arr_sc.length;

        for (int i = 0; i < arr_sc.length; i++) {
            switch (arr_sc[i].length) {
                case 7:
                    investition = investition + (system7 * teilung);
                    break;
                case 8:
                    investition = investition + (system8 * teilung);
                    break;
                case 9:
                    investition = investition + (system9 * teilung);
                    break;
                case 10:
                    investition = investition + (system10 * teilung);
                    break;
                case 11:
                    investition = investition + (system11 * teilung);
                    break;
                case 12:
                    investition = investition + (system12 * teilung);
                    break;
                default:
                    investition = investition + (wochenBisGewinn * 2 * arr_sc.length);
                    break;
            }
        }
        System.out.println();
        System.out.printf(CS.PURPLE_BRIGHT + "3 Zahlen: \033[0;37m%,d%n", richtige3);
        System.out.printf(CS.PURPLE_BRIGHT + "4 Zahlen: \033[0;37m%,d%n", richtige4);
        System.out.printf(CS.PURPLE_BRIGHT + "5 Zahlen: \033[0;37m%,d%n", richtige5);
        System.out.println();
        System.out.printf(CS.CYAN + "Investiert: \033[0;37m%,d $%n", (investition));
        System.out.printf(CS.CYAN + "Gewinn: \033[0;37m%,d $%n", (gewinn - investition));
        System.out.print(CS.RESET);
        zeitBisGewinn(wochenBisGewinn);
    }

    public static void zeitBisGewinn(int woche) { // berechnen gebrauchte zeit bis 6 treffen

        int jahr, monat, rest;
        int woche_jahr = 52;
        int woche_monat = 4;

        jahr = woche / woche_jahr;
        rest = woche % woche_jahr;
        monat = rest / woche_monat;
        rest = rest % woche_monat;
        System.out.println();
        System.out.printf(CS.WHITE + "%,d \033[0;33mWochen gebraucht bis Jackpot%n", woche);
        System.out.printf(CS.WHITE + "%,d \033[0;33mJahre, ", jahr);
        System.out.println(CS.WHITE + monat + CS.YELLOW + " Monate, "
                + CS.WHITE + rest + CS.YELLOW + " Wochen." + CS.RESET);

    }
}