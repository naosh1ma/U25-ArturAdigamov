package New;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Model {
    private int rows = 0, cols = 0, diff = 0;
    private int score = 0;
    private int openCount = 0;
    private int pairsFound = 0;
    private int theme = 0;

    private int[] openedCards = {-1, -1};
    private String[] themes = {"cars", "sport", "flag"};

    private ImageIcon cardBack;
    private ArrayList<ImageIcon> cards;



    private boolean running = false;

    public void createGame(int rows, int cols) {
        this.running  = true;
        this.rows = rows;
        this.cols = cols;
        cards = new ArrayList<>();
        //cardBack = new ImageIcon(getClass().getResource("icons/back.png"));
        //cardBack = new ImageIcon(cardBack.getImage().getScaledInstance((int) (getBackSize() + (getBackSize() * 0.2)), getBackSize(), Image.SCALE_SMOOTH));
        cardBack = new ImageIcon(new ImageIcon("icons/back.png").getImage().getScaledInstance((int) (getBackSize()+(getBackSize()*0.2)),getBackSize(), Image.SCALE_SMOOTH));

        for (int i = 0; i < getDiff()/2; i++) {
            ImageIcon image = new ImageIcon(new ImageIcon("icons/"+ themes[theme] +
                    (i + 1) + ".png").getImage().getScaledInstance(getFrontWidth(), getFrontHeight(), Image.SCALE_SMOOTH));
            cards.add(image);
            cards.add(image);
        }
        Collections.shuffle(cards);
    }

    public void initGame(int rows, int cols) {

        cardBack = new ImageIcon(cardBack.getImage().getScaledInstance((int) (getBackSize() + (getBackSize() * 0.2)), getBackSize(), Image.SCALE_SMOOTH));
        int i = 0;
        for (ImageIcon card : cards) {
            card = new ImageIcon(new ImageIcon("icons/" + themes[theme] + (i + 1) + ".png").getImage().getScaledInstance(getFrontWidth(), getFrontHeight(), Image.SCALE_SMOOTH));
            i++;
        }

    }

    public ImageIcon getIcon(int index) {
        return cards.get(index);
    }

    public void setOpenCard(int index) {
        if (openCount < 2) {
            openedCards[openCount] = index;
            openCount++;
        }
    }

    public boolean checkMatch() {
        return cards.get(openedCards[0]).equals(cards.get(openedCards[1]));
    }

    public void resetOpenedCards() {
        openedCards[0] = -1;
        openedCards[1] = -1;
        openCount = 0;
    }

    public boolean isPairFound() {
        pairsFound++;
        return pairsFound == cards.size() / 2;
    }

    public boolean areBothCardsOpen() {
        return openCount == 2;
    }

    public int[] getOpenedCards() {
        return openedCards;
    }

    public ImageIcon getCardBack() {
        return cardBack;
    }

    public int getDiff() {
        return diff;
    }

    public int getFrontWidth() {
        int size = 0;
        if (this.diff == 20) {
            size = 100;
        } else if (this.diff == 36) {
            size = 80;
        } else if (this.diff == 64) {
            size = 60;
        }
        return size;
    }

    public int getFrontHeight(){
        int size = 0;
        if (this.diff == 20) {
            size = 100;
        } else if (this.diff == 36) {
            size = 80;
        } else if (this.diff == 64) {
            size = 60;
        }
        return size;
    }


    public int getBackSize() {
        int size = 0;
        if (this.diff == 20) {
            size = 120;
        } else if (this.diff == 36) {
            size = 90;
        } else if (this.diff == 64) {
            size = 70;
        }
        return size;
    }
    public boolean isRunning() {
        return running;
    }
}
