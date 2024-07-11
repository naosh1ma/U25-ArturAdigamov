package ArraySort;

import ConsoleColors.CS;

import java.util.Random;
import java.util.Scanner;

public class TwoDArraySort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Variablen deklarieren
        int row, column, begin, end, typ;
        boolean antwort = true;
        // Eingabe von Größe des Arrays und dessen Zahlgrenzen
        System.out.print(CS.PURPLE + "Zeile: ");
        row = scanner.nextInt();
        System.out.print(CS.CYAN + "Spalte: ");
        column = scanner.nextInt();
        System.out.print(CS.YELLOW + "Untergenze: ");
        begin = scanner.nextInt();
        System.out.print("Obergrenze: ");
        end = scanner.nextInt();
        System.out.println(CS.RESET);
        // Array erstellen mit eingegebenen Daten
        int[][] arr = new int[row][column];
        // Array mit random Zahlen befüllen und ausgeben
        arr_unsort(arr, row, column, begin, end);
        ausgabe();
        // Wert für switch Bedingung eingeben
        do {
            typ = scanner.nextInt();
            if (typ >= 1 && typ <= 4)
                antwort = false;
            else
                System.out.print("(1 - 4): ");
        } while (antwort);
        // Sortiertes Array ausgeben
        arr_sort(arr, row, column, typ);
        scanner.close();
    }

    public static void arr_unsort(int[][] arr, int row, int column, int begin, int end) {
        Random rd = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = rd.nextInt(begin, end);
            }
        } // Array ausgeben
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(CS.RED + arr[i][j] + "  ");
            }
            System.out.println(CS.RESET);
        }
    }

    public static void arr_sort(int[][] arr, int row, int column, int typ) {
        int temp;
        pfeil(typ, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < row; k++) {
                    for (int l = 0; l < column; l++) {
                        // Cases für verschiedene Sortiervarianten
                        switch (typ) {
                            case 1:// Zeile aufsteigend
                                if (arr[k][l] > arr[i][j]) {
                                    // Wertumtausch
                                    temp = arr[i][j];
                                    arr[i][j] = arr[k][l];
                                    arr[k][l] = temp;
                                }
                                break;
                            case 2:// Zeile absteigend
                                if (arr[k][l] < arr[i][j]) {
                                    temp = arr[i][j];
                                    arr[i][j] = arr[k][l];
                                    arr[k][l] = temp;
                                }
                                break;
                            case 3:// Spalte aufsteigend
                                if (arr[l][k] > arr[j][i]) {
                                    temp = arr[j][i];
                                    arr[j][i] = arr[l][k];
                                    arr[l][k] = temp;
                                }
                                break;
                            case 4:// Spalte absteigend
                                if (arr[l][k] < arr[j][i]) {
                                    temp = arr[j][i];
                                    arr[j][i] = arr[l][k];
                                    arr[l][k] = temp;
                                }
                                break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(CS.GREEN_BRIGHT + arr[i][j] + "  ");
            }
            System.out.println(CS.RESET);
        }
    }

    public static void pfeil(int typ, int column) {
        System.out.println();
        for (int i = 0; i < column; i++) {
            switch (typ) {
                case 1:
                    System.out.print(CS.PURPLE + "→  ");
                    break;
                case 2:
                    System.out.print(CS.PURPLE + "←  ");
                    break;
                case 3:
                    System.out.print(CS.PURPLE + "↓  ");
                    break;
                case 4:
                    System.out.print(CS.PURPLE + "↑  ");
                    break;
            }
        }
        System.out.println();
    }

    public static void ausgabe() {
        System.out.println();
        System.out.println(CS.YELLOW + "Es gibt 4 Varianten fuer Sortieren: ");
        System.out.println(CS.PURPLE + "Zeile: 1) - aufsteigend, 2) - absteigend");
        System.out.println(CS.CYAN + "Spalte: 3) - aufsteigend, 4) - absteigend");
        System.out.print(CS.YELLOW + "Waehlen Sie ein Variant aus: ");
    }
}
