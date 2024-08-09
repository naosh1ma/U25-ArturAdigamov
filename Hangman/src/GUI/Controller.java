package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model model;
    View view;

    Controller(Model model, View view){
        this.model = model;
        this.view = view;

        view.addListener(new KeyboardListener());
        view.addRestartListener(new RestartButtonListener());
        view.addEndListener(new EndButtonListener());
    }

    public class KeyboardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    public class RestartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    public class EndButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }


}
