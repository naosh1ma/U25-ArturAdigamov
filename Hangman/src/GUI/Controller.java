package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model model;
    View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.setWordLabel(model.getWord()); // Wort von Model an View weitergeben
        // ActionListener hinzufügen
        view.addListener(new KeyboardListener());
        view.addRestartListener(new RestartButtonListener());
        view.addEndListener(new EndButtonListener());
    }

    public class KeyboardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource(); // fangen gedruckten Knopf
            int index = view.getButtonIndex(button);  // finden welcher Index Knopf hat

            view.disableButtons(index); // deaktivieren Knopf nach dem Druck
            view.setWordLabel(model.getWord()); // Wort aktualisieren

            String letter = button.getText(); // Buchstabe des Knopfs auslesen

            if (!model.makeGuess(letter.toLowerCase())) {
                model.incrementWrongGuess();
            }
            if (model.makeGuess(letter.toLowerCase())) {
                model.wordGuessed();
            }
            if (model.wordGuessed()) {
                Object[] options = {"Ja", "Nein"};
                int input = JOptionPane.showOptionDialog(null, "                      Du hast gewonnen!\n" +
                                "                     Willst du neustarten?", "Game Over",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        options, options[0]);
                if (input == JOptionPane.YES_OPTION) {
                    restartGame();
                } else if (input == JOptionPane.NO_OPTION) {
                    endGame();
                }
            }

            if (model.getWrongGuess() == 6) {
                Object[] options = {"Ja", "Nein"};
                int input = JOptionPane.showOptionDialog(null, "                        Du hast verloren!\n" +
                                "                     Willst du neustarten?", "Game Over",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        options, options[0]);
                if (input == JOptionPane.YES_OPTION) {
                    restartGame();
                } else if (input == JOptionPane.NO_OPTION) {
                    endGame();
                }
            }
        }
    }

    public class RestartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            restartGame();
        }
    }

    public static class EndButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            endGame();
        }
    }

    /**
     * Die Methode restartGame stellt alle Knöpfe zurück, sucht ein neues Wort aus und gibt dieses Wort an View weiter.
     */
    private void restartGame() {
        view.resetButtons();
        model.setWord();
        view.setWordLabel(model.getWord());
    }

    /**
     * Die Methode endGame schliesst das Programm.
     */
    private static void endGame() {
        System.exit(0);
    }




}
