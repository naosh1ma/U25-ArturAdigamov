package Memory;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        memory.View view = new memory.View(model);
        Controller controller = new Controller(model,view);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    memory.View frame = new memory.View(model);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
