package Memory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    private final GameModel model;
    private final GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int index = view.getButtonIndex(button);

        if (button.getIcon() == null) {
            model.setOpenCard(index);
            view.setButtonIcon(index, model.getIcon(index));

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
    }

    private void checkForMatch() {
        int[] openedCards = model.getOpenedCards();
        if (model.checkMatch()) {
            view.disableButton(openedCards[0]);
            view.disableButton(openedCards[1]);
            if (model.isPairFound()) {
                view.showGameOverMessage();
            }
        } else {
            view.resetButtonIcon(openedCards[0]);
            view.resetButtonIcon(openedCards[1]);
        }
        model.resetOpenedCards();
    }
}