package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Model {

    Random random;
    Scanner scanner;
    Scanner inputFile;

    List<String> words;
    List<Character> userGuess;
    String word;



    Model() {
        random = new Random();
        // Arraylist fuer woerter von unserem File
        words = new ArrayList<>();
        // ArrayList fuer Benutzervermutungen
        userGuess = new ArrayList<>();
    }

    public void initGame() {

        // File input mit Scanner Klasse
        try {
            inputFile = new Scanner(new File("Hangman/wortliste.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // ArrayList mit woerter von wottliste.txt befuellen
        while (inputFile.hasNext()) {
            words.add(inputFile.nextLine());
        }
        // Bekommen ein Element von Woerter ArrayList mit Random Index
        // und speichern in String
        word = words.get(random.nextInt(words.size()));
        word = word.toLowerCase();

        // Zaehler fuer falschen Vermutungen
        int falsch = 0;

        do {
            if (wortErraten(word, userGuess)) {

                System.out.println("Du hast gewonnen!");
                break;
            }
            if (!eingabeVermutung(userGuess, scanner, word)) {
                falsch++;
            }
            // Liefer falschZaehler als index fuer Ausgabe von Hangman
            printHangman(falsch);
            if (falsch == 6) {
                System.out.println("Du hast veloren!");
                break;
            }
            System.out.println();
        } while (!userGuess.contains(word));

    }

    private boolean eingabeVermutung(List<Character> userVermutung, Scanner scanner, String wort) {
        System.out.print("Buchstabe eingeben: ");
        // Speichen Eingabe in einen String
        String buchstabe = scanner.nextLine();
        // Speichern erte Charakter unser String in ArrayList
        userVermutung.add(buchstabe.charAt(0));
        // Liefern true zurueck, wenn Vermutung richtig war und false, wenn nicht
        return wort.contains(buchstabe);
    }

    private boolean wortErraten(String wort, List<Character> userVermutung) {
        // Zaehler fuer richtigen Vermutungen
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

    private String printHangman(int index) {
        // Erstellen List mit Hangman
        List<String> hangman = List.of(
                """
                          +---+
                              |
                              |
                              |
                              |
                              |
                        =========""",
                """
                          +---+
                              |
                          O   |
                              |
                              |
                              |
                        =========""",
                """
                          +---+
                              |
                          O   |
                          |   |
                              |
                              |
                        =========""",
                """
                          +---+
                              |
                          O   |
                         /|   |
                              |
                              |
                        =========""",
                """
                          +---+
                              |
                          O   |
                         /|\\  |
                              |
                              |
                        =========""",
                """
                          +---+
                              |
                          O   |
                         /|\\  |
                         /    |
                              |
                        =========""",
                """
                          +---+
                              |
                          O   |
                         /|\\  |
                         / \\  |
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
        return hangman.get(index);
    }
}
