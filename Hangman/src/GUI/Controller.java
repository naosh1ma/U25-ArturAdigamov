package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model model;
    View view;

    Controller(Model model, View view){
        this.model = model;
        this.view = view;

        view.setWordLabel(model.getWord());
        view.addListener(new KeyboardListener());
        view.addRestartListener(new RestartButtonListener());
        view.addEndListener(new EndButtonListener());
    }

    public class KeyboardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int index = view.getButtonIndex(button);

            view.disableButtons(index);
            view.setWordLabel(model.getWord());

            String letter = button.getText();

            if(!model.makeGuess(letter.toLowerCase())){
                model.incrementWrongGuess();
            }
            if(model.makeGuess(letter.toLowerCase())){
                model.wordGuessed();
            }

            if(model.wordGuessed()){
                Object[] options = {"Ja", "Nein"};
                int input = JOptionPane.showOptionDialog(null, "                      Du hast gewonnen!\n" +
                                "                     Willst du neustarten?", "Game Over",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        options, options[0]);
                if (input == JOptionPane.YES_OPTION) {
                    view.resetButtons();
                    model.setWord();
                    view.setWordLabel(model.getWord());
                } else if (input == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }

            if(model.getWrongGuess() == 6){
                Object[] options = {"Ja", "Nein"};
                int input = JOptionPane.showOptionDialog(null, "                        Du hast verloren!\n" +
                                "                     Willst du neustarten?", "Game Over",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        options, options[0]);
                if (input == JOptionPane.YES_OPTION) {
                    view.resetButtons();
                    model.setWord();
                    view.setWordLabel(model.getWord());
                } else if (input == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        }
    }
    public class RestartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.resetButtons();
            model.setWord();
            view.setWordLabel(model.getWord());
        }
    }
    public static class EndButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
