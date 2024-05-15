import java.util.Random;
import java.util.Scanner;

public class ArraySortV1 {
    public static void main(String[] args) {
        // Werkzeuge erschaffen
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        // Variablen deklarieren
        int begin, end, row, column, temp, typ;
        // Eingabe von Größe der Array und deren Zahlenrange
        System.out.print(CS.PURPLE + "Zeile: ");
        row = sc.nextInt();
        System.out.print(CS.CYAN + "Spalte: ");
        column = sc.nextInt();
        System.out.print(CS.YELLOW + "Untergenze: ");
        begin = sc.nextInt();
        System.out.print("Obergrenze: " + CS.RESET);
        end = sc.nextInt();
        System.out.println();
        // Array erstellen mit eingegebenen Daten
        int[][] arr = new int[row][column];
        // Array mit random Zahlen befüllen
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = rd.nextInt(begin, end);
            }
        } // Array ausgeben
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(CS.RED + arr[i][j] + " ");
            }
            System.out.println(CS.RESET);
        } // Eingabe von wert für switch Bedingungen
        System.out.println();
        System.out.println(CS.YELLOW + "Es gibt 4 Varianten fuer Sortieren:");
        System.out.println(CS.PURPLE_BRIGHT + "Zeile: 1) - aufsteigend, 2) - absteigend");
        System.out.println(CS.CYAN_BRIGHT + "Spalte: 3) -  aufsteigend, 4) - absteigend");
        System.out.print(CS.YELLOW + "Waehlen Sie ein Variant aus: ");
        typ = sc.nextInt();
        // Sortieren
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < row; k++) {
                    for (int l = 0; l < column; l++) {
                        // Cases für verschiedene Sortiervarianten
                        switch (typ) {
                            case 1:
                                if (arr[k][l] > arr[i][j]) {
                                    // Wertumtausch
                                    temp = arr[i][j];
                                    arr[i][j] = arr[k][l];
                                    arr[k][l] = temp;
                                }
                                break;
                            case 2:
                                if (arr[k][l] < arr[i][j]) {
                                    temp = arr[i][j];
                                    arr[i][j] = arr[k][l];
                                    arr[k][l] = temp;
                                }
                                break;
                            case 3:
                                if (arr[l][k] > arr[j][i]) {
                                    temp = arr[j][i];
                                    arr[j][i] = arr[l][k];
                                    arr[l][k] = temp;
                                }
                                break;
                            case 4:
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
        System.out.println();
        // Sortiertes Array ausgeben
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(CS.GREEN_BRIGHT + arr[i][j] + " ");
            }
            System.out.println(CS.RESET);
        }
        sc.close();
    }
}
