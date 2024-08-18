package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Model {

    Random random;
    Scanner inputFile;

    List<String> words;
    List<Character> userGuess;
    String word = "";
    String hiddenWord;

    int wrongGuess;


    Model() {
        random = new Random();
        words = new ArrayList<>();
        userGuess = new ArrayList<>();
        loadWords();
        setWord();
    }

    private void loadWords() {
        try {
            inputFile = new Scanner(new File("Hangman/wordlist.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (inputFile.hasNext()) {
            words.add(inputFile.nextLine());
        }
        inputFile.close();
    }

    public void setWord() {
        userGuess.clear();
        wrongGuess = 0;

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

    public boolean wordGuessed() {
        int rightGuess = 0;

        for (int i = 0; i < word.length(); i++) {
            if (userGuess.contains(word.charAt(i))) {
                hiddenWord.replace((char) hiddenWord.indexOf(word.charAt(i)), word.charAt(i));
                rightGuess++;
            }
        }
        return rightGuess == word.length();
    }

    public void incrementWrongGuess(){
        wrongGuess++;
    }

    public int getWrongGuess(){
        return wrongGuess;
    }
}
