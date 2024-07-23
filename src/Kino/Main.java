package Kino;

import ConsoleColors.CS;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Wie viele Plaetze sind besetzt?: ");
        int besetztePlaetze = scanner.nextInt();
        boolean[][] platzKunde = new boolean[15][15];

        besetzung(besetztePlaetze, platzKunde);
        System.out.println();
        istBesetzt(platzKunde);
        System.out.print("Wie viele Personen sind Sie?: ");
        int anzahlKunden = scanner.nextInt();
        System.out.println();
        for (int i = 0; i < platzKunde.length; i++) {
            if (i > 8) {
                System.out.print((i + 1) + " ");
            } else {
                System.out.print(" " + (i + 1) + " ");
            }
            for (int j = 0; j < platzKunde[i].length - anzahlKunden; j++) {
                if (platzKunde[i][j]) {
                    if (passen(platzKunde, anzahlKunden, i, j)) {
                        System.out.print(CS.CYAN + " ▰ " + CS.RESET);
                    } else {
                        System.out.print(CS.RED + " ▰ " + CS.RESET);
                    }
                } else {
                    System.out.print(CS.GREEN + " ▰ " + CS.RESET);
                }
            }
            System.out.println();
        }
    }

    private static boolean passen(boolean[][] platzKunde, int anzahl, int row, int column) {
        int temp = 0;
        for (int i = 0; i < anzahl; i++) {
            if (platzKunde[row][column + i]) {
                temp++;
            }
        }
        return (temp == anzahl) ? true : false;
    }

    private static void istBesetzt(boolean[][] platzKunde) {
        String row = "    1   2   3   4   5   6   7   8   9  10  11 12  13  14  15";
        System.out.println(row);
        for (int i = 0; i < platzKunde.length; i++) {
            if (i > 8) {
                System.out.print((i + 1) + " ");
            } else {
                System.out.print(" " + (i + 1) + " ");
            }
            for (int j = 0; j < platzKunde[i].length; j++) {
                if (platzKunde[i][j]) {
                    System.out.print(CS.RED + " ▰ " + CS.RESET);
                } else {
                    System.out.print(CS.GREEN + " ▰ " + CS.RESET);
                }
            }
            System.out.println();
        }
    }

    private static void besetzung(int besetztePlaetze, boolean[][] platzKunde) {
        Random random = new Random();
        while (besetztePlaetze > 0) {
            int randomRow = random.nextInt(platzKunde.length);
            int randomCol = random.nextInt(platzKunde[0].length);

            if (!platzKunde[randomRow][randomCol]) {
                platzKunde[randomRow][randomCol] = true;
                besetztePlaetze--;
            }
        }
    }
}
