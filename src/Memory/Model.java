package Memory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

    List<ImageIcon> icons = null;
    List<JButton> buttons = null;

    public void setIcons(List icons, int diff) {
        icons = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            icons.add(new ImageIcon("icons/game1_16.png"));
        }

    }
}
