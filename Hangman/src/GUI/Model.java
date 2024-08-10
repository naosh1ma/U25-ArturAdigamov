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
    String word = "";
    String hiddenWord;

    int wrongGuess;


    Model() {
        scanner = new Scanner(System.in);
        random = new Random();
        words = new ArrayList<>();
        userGuess = new ArrayList<>();
        loadWords();
        setWord();
    }

    public void setWord() {
        userGuess.clear();
        hiddenWord = "";
        word = words.get(random.nextInt(words.size()));
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            hiddenWord += "-";
        }
    }


    public boolean makeGuess(String letter) {
        userGuess.add(letter.toLowerCase().charAt(0));
        return word.contains(letter);
    }

    public String getWord() {
        return hiddenWord;
    }

    public List<Character> getGuesses() {
        return userGuess;
    }

    private boolean enterGuess() {
        System.out.print("Buchstabe eingeben: ");
        String letter = scanner.nextLine();
        userGuess.add(letter.charAt(0));
        return word.contains(letter);
    }


    public boolean wordGuess() {
        int rightGuess = 0;

        for (int i = 0; i < word.length(); i++) {
            if (userGuess.contains(word.charAt(i))) {
                rightGuess++;
            }
        }
        return rightGuess == word.length();
    }


    private void loadWords() {
        try {
            inputFile = new Scanner(new File("Hangman/wortliste.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (inputFile.hasNext()) {
            words.add(inputFile.nextLine());
        }
    }

    public void initGame() {
        setWord();
        wrongGuess = 0;

        do {
            if (wordGuess()) {
                System.out.println("Du hast gewonnen!");
                break;
            }
            if (!enterGuess()) {
                wrongGuess++;
            }
            printHangman(wrongGuess);
            if (wrongGuess == 6) {
                System.out.println("Du hast veloren!");
                break;
            }
            System.out.println();
        } while (!userGuess.contains(word));

    }


    public String printHangman(int index) {

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
