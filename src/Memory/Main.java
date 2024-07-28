package Memory;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameView view = new GameView(model,null);
        GameController controller = new GameController(model, view);
        view.setActionListener(controller);
    }
}
