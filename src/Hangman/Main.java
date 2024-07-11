package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // File input mit Scanner Klasse
        Scanner inputFile = new Scanner(new File("wortliste.txt"));

        // Arraylist fuer woerter von unserem File
        List<String> woerter = new ArrayList<>();
        // ArrayList fuer Benutzervermutungen
        List<Character> userVermutung = new ArrayList<>();

        // ArrayList mit woerter von wottliste.txt befuellen
        while (inputFile.hasNext()) {
            woerter.add(inputFile.nextLine());
        }
        // Bekommen ein Element von Woerter ArrayList mit Random Index
        // und speichern in String
        String wort = woerter.get(random.nextInt(woerter.size()));
        wort = wort.toLowerCase();

        // Test
        //System.out.print(wort);

        // Counter falschen Vermutungen
        int falsch = 0;

        do {
            if (wortErraten(wort, userVermutung)) {
                System.out.println("Du hast gewonnen!");
                break;
            }
            if (!eingabeVermutung(userVermutung, scanner, wort)) {
                falsch++;
            }
            // Liefer falschCounter als index fuer Ausgabe von Hangman
            printHangman(falsch);
            if(falsch == 6){
                System.out.println("Du hast veloren!");
                break;
            }
            System.out.println();
        } while (!userVermutung.contains(wort));

    }

    private static boolean eingabeVermutung(List<Character> userVermutung, Scanner scanner, String wort) {
        System.out.print("Buchstabe eingeben: ");
        // Speichen Eingabe in einen String
        String buchstabe = scanner.nextLine();
        // Speichern erte Charakter unser String in ArrayList
        userVermutung.add(buchstabe.charAt(0));
        // Liefern true zurueck, wenn Vermutung richtig war und false, wenn nicht
        return wort.contains(buchstabe);
    }

    private static boolean wortErraten(String wort, List<Character> userVermutung) {
        // Counter richtigen Vermutungen
        int richtig = 0;
        for (int i = 0; i < wort.length(); i++) {
            if (userVermutung.contains(wort.charAt(i))) {
                System.out.print(wort.charAt(i));
                richtig++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        // Liefern true zurueck, wenn wir alle Buchstaben richtig vermuten haben
        return richtig == wort.length();
    }

    private static void printHangman(int index) {
        // Erstellen List mit Hangman
        List<String> hangman = List.of(
                """
                          +---+
                          |   |
                              |
                              |
                              |
                              |
                        =========""",
                """
                          +---+
                          |   |
                          O   |
                              |
                              |
                              |
                        =========""",
                """
                          +---+
                          |   |
                          O   |
                          |   |
                              |
                              |
                        =========""",
                """
                          +---+
                          |   |
                          O   |
                         /|   |
                              |
                              |
                        =========""",
                """
                          +---+
                          |   |
                          O   |
                         /|\\  |
                              |
                              |
                        =========""",
                """
                          +---+
                          |   |
                          O   |
                         /|\\  |
                         /    |
                              |
                        =========""",
                """
                          +---+
                          |   |
                          O   |
                         /|\\  |
                         / \\  |
                              |
                        =========""");
        System.out.println(hangman.get(index));
    }
}