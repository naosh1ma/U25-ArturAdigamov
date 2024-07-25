package Memory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameModel {
    private JButton firstButton;
    private JButton secondButton;
    private List<ImageIcon> icons;
    private List<ImageIcon> iconsShaffled;

    private void createIcons(int diff) {
        icons = new ArrayList<>();
        iconsShaffled = new ArrayList<>();
        int index = 0;
        switch (diff) {
            case 1:
                for (int i = 1; i <= 10; i++) {
                    icons.add(index, new ImageIcon("icons\\sport" + i + "_64.png"));
                    icons.add(index + 1, new ImageIcon("icons\\sport" + i + "_64.png"));
                    index++;
                }
            case 2:
                for (int i = 1; i <= 16; i++) {
                    icons.add(index, new ImageIcon("icons\\sport" + i + "_64.png"));
                    icons.add(index + 1, new ImageIcon("icons\\sport" + i + "_64.png"));
                    index++;
                }
            case 3:
                for (int i = 1; i <= 32; i++) {
                    icons.add(index, new ImageIcon("icons\\sport" + i + "_64.png"));
                    icons.add(index + 1, new ImageIcon("icons\\sport" + i + "_64.png"));
                    index++;
                }
        }
    }

    public void iconsShuffled(int diff) {
        switch (diff) {
            case 1:
                iconsShaffled = icons.subList(0, 20);
                break;
            case 2:
                iconsShaffled = icons.subList(0, 36);
                break;
            case 3:
                iconsShaffled = icons.subList(0, 64);
                break;
        }
        Collections.shuffle(iconsShaffled);
    }

    public ImageIcon getIcon(int diff, int index) {
        createIcons(diff);
        iconsShuffled(diff);
        return iconsShaffled.get(index);
    }
}

