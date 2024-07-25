package Memory;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        GameModel model = new GameModel();
        GameView view = new GameView(model);
        //GameController controller = new GameController(model,view);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameView frame = new GameView(model);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
