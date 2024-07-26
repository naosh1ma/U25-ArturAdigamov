package Memory;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameModel model = new GameModel();
                GameView view = new GameView(model);
                GameController controller = new GameController(model,view);
                view.addButtonListener(controller);
                view.setVisible(true);
            }
        });
//        GameModel model = new GameModel();
//        GameView view = new GameView(model);
//        GameController controller = new GameController(model,view);
//        view.addButtonListener(controller);
//        view.setVisible(true);
    }
}
