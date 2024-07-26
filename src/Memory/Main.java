package Memory;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        GameModel model = new GameModel();
        GameView view = new GameView(model);
        GameController controller = new GameController(model,view);
        view.addButtonListener(controller);
        view.setVisible(true);

    }

}
