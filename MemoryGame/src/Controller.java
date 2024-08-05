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
        frame.getPanelSettings().addSettingsStartGameListener(new StartGameListener());
        frame.getPanelGame().addGameNewStartListener(new NewStartGameListener());
        frame.getPanelGame().addGameEndListener(new EndGameListener());
    }

    class DifficultyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            switch (button.getText()) {
                case "4 x 5":
                    openSettings();
                    model.createGame(4, 5);
                    break;
                case "6 x 6":
                    openSettings();
                    model.createGame(6, 6);
                    break;
                case "8 x 8":
                    openSettings();
                    model.createGame(8, 8);
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
            if (checkBox.isSelected()) {
                System.out.println(checkBox.getText() + " is added");
                model.setThemes(checkBox.getText());
            } else {
                System.out.println(checkBox.getText() + " is removed");
                model.deleteTheme(checkBox.getText());
            }
        }
    }

    public class StartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.getThemes() == null) {
                    JOptionPane.showMessageDialog(frame, "There are no themes available");
                } else {
                    model.initGame();
                    model.createIcons();
                    frame.getPanelSettings().setVisible(false);
                    frame.add(frame.getPanelGame());
                    frame.getPanelGame().createGameField(model.getRows(), model.getCols());
                    frame.getPanelGame().setBackIcon(model.getCardsBack());
                    frame.getPanelGame().setVisible(true);
                    frame.getPanelGame().addGameFieldButtonsListener(new ButtonListener());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Es wurde noch keine Themen ausgew\u00E4hlt!");
            }
        }
    }

    public class NewStartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] options = {"Ja", "Nein"};
            int input = JOptionPane.showOptionDialog(null, "          Willst du wirklich neustarten?", "=)",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    options, options[0]);
            if (input == JOptionPane.YES_OPTION) {
                restartGame();
            }
        }
    }


    public class EndGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] options = {"Ja", "Nein"};
            int input = JOptionPane.showOptionDialog(null, "        Willst du wirklich Spiel beenden?", "=)",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    options, options[0]);
            if (input == JOptionPane.YES_OPTION) {
                endGame();
            }
        }
    }

    private void restartGame() {
        model.newStart();
        frame.getPanelGame().setBackIcon(model.getCardsBack());
        frame.getPanelGame().enableButtons();
        frame.getPanelGame().revalidate();
        frame.getPanelGame().repaint();
    }

    private void endGame() {
        model.initGame();
        frame.getPanelGame().setVisible(false);
        frame.getPanelMenu().setVisible(true);
        frame.remove(frame.getPanelGame());
        frame.revalidate();
        frame.repaint();
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
                    model.decreaseScore();
                    frame.getPanelGame().setScore(model.getScore());
                    if (model.getScore() == 0) {
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
            } else {
                frame.getPanelGame().resetButtonIcon(openedCards[0], model.getCardsBack());
                frame.getPanelGame().resetButtonIcon(openedCards[1], model.getCardsBack());
            }
            model.resetOpenedCards();
        }
    }


}
