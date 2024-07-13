package Kino;

import ConsoleColors.CS;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int besetztePlaetze = scanner.nextInt();

        boolean[][] platzKunde = new boolean[16][16];

        while (besetztePlaetze > 0) {

            int randomRow = random.nextInt(platzKunde.length);
            int randomCol = random.nextInt(platzKunde[0].length);

            // Überprüfe, ob der Wert an dieser Stelle bereits true ist
            if (!platzKunde[randomRow][randomCol]) {
                platzKunde[randomRow][randomCol] = true;
                besetztePlaetze--;
            }
        }
        System.out.println();

        for (int i = 0; i < platzKunde.length; i++) {

            if (i > 0) {
                if (i > 9) {
                    System.out.print(i);
                } else {
                    System.out.print("0" + i);
                }
            }
            for (int j = 0; j < platzKunde[i].length; j++) {

                if (i == 0) {
                    if (j > 9) {
                        System.out.print(j + " ");
                    } else {
                        System.out.print("0" + j + " ");
                    }
                }
                if (i > 0) {

                    if (platzKunde[i][j]) {
                        System.out.print(CS.RED + " ▰" + CS.RESET);
                    } else {
                        System.out.print(CS.GREEN + " ▰" + CS.RESET);
                    }
                }
            }
            System.out.println();
        }
    }


}
