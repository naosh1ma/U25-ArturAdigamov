package New;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model model;
    Frame frame;

    Controller(Model model, Frame frame) {
        this.model = model;
        this.frame = frame;
    }

    class DifficultyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            switch (button.getText()) {
                case "4 x 5":
                    frame.getContentPane().setVisible(false);
                    frame.add();
                    break;
                case "5 x 6":

                    break;
                case "6 x 7":

                    break;
            }

        }
    }
    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int index = frame.getButtonIndex(button);

            if (button.getIcon() == null) {
                //model.setOpenCard(index);
                //setButtonIcon(index, model.getIcon(index));

                if (model.areBothCardsOpen()) {
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            checkForMatch();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
            repaint();
        }

    }

    private void checkForMatch() {
        int[] openedCards = model.getOpenedCards();
        if (model.checkMatch()) {
            disableButton(openedCards[0]);
            disableButton(openedCards[1]);
            if (model.isPairFound()) {
                showGameOverMessage();
            }
        } else {
            resetButtonIcon(openedCards[0]);
            resetButtonIcon(openedCards[1]);
        }
        model.resetOpenedCards();
    }


}
