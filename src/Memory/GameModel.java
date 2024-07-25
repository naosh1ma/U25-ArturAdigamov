package Memory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameModel {


    private int diff = 1;
    private JButton firstButton;
    private JButton secondButton;
    private ImageIcon[] icons;
    private ImageIcon[] iconsShaffled;

    GameModel() {
        icons = new ImageIcon[64];
    }
    public int getDiff() {return diff;}
    public void setDiff(int diff) {this.diff = diff;}

    public void createIcons() {
        int index = 0;
        switch (getDiff()) {
            case 1:
                for (int i = 0; i < icons.length / 2; i++) {
                    icons[i + index] = new ImageIcon("icons\\sport" + (i + 1) + "_128.png");
                    icons[i + 1 + index] = new ImageIcon("icons\\sport" + (i + 1) + "_128.png");
                    index++;
                }
                break;
            case 2:
                for (int i = 0; i < icons.length / 2; i++) {
                    icons[i + index] = new ImageIcon("icons\\sport" + (i + 1) + "_64.png");
                    icons[i + 1 + index] = new ImageIcon("icons\\sport" + (i + 1) + "_64.png");
                    index++;
                }
                break;
            case 3:
                for (int i = 0; i < icons.length / 2; i++) {
                    icons[i + index] = new ImageIcon("icons\\sport" + (i + 1) + "_32.png");
                    icons[i + 1 + index] = new ImageIcon("icons\\sport" + (i + 1) + "_32.png");
                    index++;
                }
                break;
        }
    }
    public void iconsShuffle() {
        switch (getDiff()) {
            case 1:
                iconsShaffled = new ImageIcon[20];
                for (int i = 0; i < iconsShaffled.length; i++) {
                    iconsShaffled[i] = icons[i];
                }
                break;
            case 2:
                iconsShaffled = new ImageIcon[36];
                for (int i = 0; i < iconsShaffled.length; i++) {
                    iconsShaffled[i] = icons[i];
                }
                break;
            case 3:
                iconsShaffled = new ImageIcon[64];
                for (int i = 0; i < iconsShaffled.length; i++) {
                    iconsShaffled[i] = icons[i];
                }
                break;
        }
        Collections.shuffle(Arrays.asList(iconsShaffled));
    }

    public ImageIcon getIcon(int index) {
        return iconsShaffled[index];
    }
}

