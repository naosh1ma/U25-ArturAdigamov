package Memory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
//    if (icon1.getDescription().equals(icon2.getDescription())) {
//        System.out.println("Icons sind gleich");
//    } else {
//        System.out.println("Icons sind unterschiedlich");
//    }
}
