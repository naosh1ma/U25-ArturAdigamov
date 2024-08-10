package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model model;
    View view;

    int wrongGuess = 0;


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
            String letter = button.getText();
            view.disableButtons(index);
            view.setWordLabel(model.getWord());
            model.makeGuess(letter);

        }
    }
    public class RestartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.restartButtons();
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
