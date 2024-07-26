package Memory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameModel {

    private int diff;
    private int openCount = 0;
    private int pairsFound = 0;
    private int[] openedCards = {-1, -1};
    private ArrayList<ImageIcon> icons;

    public void createIcons() {
        icons = new ArrayList<>();
        for (int i = 0; i < getDiff() / 2; i++) {
            ImageIcon icon = new ImageIcon(new ImageIcon("icons\\sport" + (i + 1) + ".png").getImage().getScaledInstance(getSize(), getSize(), Image.SCALE_SMOOTH));
            icons.add(icon);
            icons.add(icon);
        }
    }

    public void initGame(int row, int col) {
        setDiff(row * col);
        createIcons();
        iconsShuffle();
    }

    public void iconsShuffle() {
        Collections.shuffle(icons);
    }

    public ImageIcon getIcon(int index) {
        return icons.get(index);
    }

    public int getSize() {
        int size = 0;
        if (getDiff() == 20) {
            size = 100;
        } else if (getDiff() == 36) {
            size = 80;
        } else if (getDiff() == 64) {
            size = 60;
        }
        return size;
    }

    public int getDiff() {return diff;}
    public void setDiff(int diff) {this.diff = diff;}
    //==========================================================
    public void setOpenCard(int index) {
        if (openCount < 2) {
            openedCards[openCount] = index;
            openCount++;
        }
    }

    public boolean checkMatch() {
        return icons.get(openedCards[0]).equals(icons.get(openedCards[1]));
    }
    public void resetOpenedCards() {
        openedCards[0] = -1;
        openedCards[1] = -1;
        openCount = 0;
    }
    public boolean isPairFound() {
        pairsFound++;
        return pairsFound == icons.size() / 2;
    }

    public boolean areBothCardsOpen() {
        return openCount == 2;
    }

    public int[] getOpenedCards() {
        return openedCards;
    }
    //==========================================================
}

