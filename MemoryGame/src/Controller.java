import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model model;
    Frame frame;

    Controller(Model model, Frame frame) {
        this.model = model;
        this.frame = frame;

        frame.getPanelMenu().addGameEasyListener(new DifficultyListener());
        frame.getPanelMenu().addGameNormListener(new DifficultyListener());
        frame.getPanelMenu().addGameHardListener(new DifficultyListener());
        frame.getPanelSettings().addSettingsThemeListener(new ThemeListener());
        frame.getPanelSettings().addSettingsStartListener(new StartGameListener());
        frame.getPanelGame().addGameNewStartListener(new StartGameListener());
    }

    class DifficultyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            switch (button.getText()) {
                case "4 x 5":
                    System.out.println("4 x 5 Button pressed");
                    openSettings();
                    model.createGame(4,5);

                    break;
                case "6 x 6":
                    System.out.println("6 x 6 Button pressed");
                    openSettings();
                    model.createGame(6,6);
                    break;
                case "8 x 8":
                    System.out.println("8 x 8 Button pressed");
                    openSettings();
                    model.createGame(8,8);
                    break;
            }

        }

        private void openSettings() {
            frame.getPanelMenu().setVisible(false);
            frame.add(frame.getPanelSettings());
            frame.getPanelSettings().setVisible(true);
        }
    }

    public class ThemeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox checkBox = (JCheckBox) e.getSource();

            if (checkBox.isSelected() && checkBox.getText().equals("Autos")) {
                System.out.println(checkBox.getText() + " has added");
                model.setThemes(checkBox.getText());
            }
            else if (!checkBox.isSelected() && checkBox.getText().equals("Autos")) {
                System.out.println(checkBox.getText() + " has removed");
                model.deleteTheme(checkBox.getText());
            }
            if (checkBox.isSelected() && checkBox.getText().equals("Flaggen")) {
                System.out.println(checkBox.getText() + " has added");
                model.setThemes(checkBox.getText());
            }
            else if (!checkBox.isSelected() && checkBox.getText().equals("Flaggen")) {
                System.out.println(checkBox.getText() + " has removed");
                model.deleteTheme(checkBox.getText());
            }
            if (checkBox.isSelected() && checkBox.getText().equals("Sport")) {
                System.out.println(checkBox.getText() + " has added");
                model.setThemes(checkBox.getText());
            }
            else if (!checkBox.isSelected() && checkBox.getText().equals("Sport")) {
                System.out.println(checkBox.getText() + " has removed");
                model.deleteTheme(checkBox.getText());
            }
        }
    }
    public class StartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("GameStartButton pressed");
            model.initGame();
            frame.getPanelSettings().setVisible(false);
            frame.add(frame.getPanelGame());
            frame.getPanelGame().createGameField(model.getRows(),model.getCols());
            frame.getPanelGame().setBackIcon(model.getCardsBack());
            frame.getPanelGame().setVisible(true);
            frame.getPanelGame().addGameFieldButtonsListener(new ButtonListener());
        }
    }
    public class NewStartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.initGame();
            model.resetOpenedCards();
            frame.newPanelGame();
            frame.add(frame.getPanelGame());
            frame.getPanelGame().createGameField(model.getRows(),model.getCols());
            frame.getPanelGame().setBackIcon(model.getCardsBack());
            frame.getPanelGame().addGameFieldButtonsListener(new ButtonListener());
            frame.revalidate();
            frame.repaint();
        }
    }
    public class EndGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int index = frame.getPanelGame().getButtonIndex(button);

            if (button.getIcon() == model.getCardsBack()) {
                model.setOpenCard(index);
                frame.getPanelGame().setButtonIcon(index, model.getIcon(index));

                if (model.areBothCardsOpen()) {
                    Timer timer = new Timer(1000, e1 -> checkForMatch());
                    timer.setRepeats(false);
                    timer.start();
                }
            }
            frame.repaint();
        }
        private void checkForMatch() {
            int[] openedCards = model.getOpenedCards();
            if (model.checkMatch()) {
                frame.getPanelGame().disableButton(openedCards[0]);
                frame.getPanelGame().disableButton(openedCards[1]);
                if (model.isPairFound()) {
                    frame.getPanelGame().showGameOverMessage();
                }
            } else {
                frame.getPanelGame().resetButtonIcon(openedCards[0],model.getCardsBack());
                frame.getPanelGame().resetButtonIcon(openedCards[1],model.getCardsBack());
            }
            model.resetOpenedCards();
        }

    }




}