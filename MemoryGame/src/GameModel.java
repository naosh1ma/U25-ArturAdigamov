import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GameModel {
    private int rows = 0, cols = 0, diff = 0;
    private int score = 0;
    private int[] openedCards = {-1, -1};
    private int openCount = 0;
    private int pairsFound = 0;
    private int theme = 0;
    private String[] themes = {"cars", "sport", "flag"};

    private ImageIcon cardBack;
    private List<ImageIcon> images;
    private List<ImageIcon> cards;

    public GameModel() {
        loadIcons();
    }

    public void loadIcons() {
        images = new ArrayList<>();
        cards = new ArrayList<>();
        //cardBack = new ImageIcon(getClass().getResource("icons/back.png"));
        cardBack = new ImageIcon("MemoryGame/icons/back.png");
        //cardBack = new ImageIcon(new ImageIcon("icons/back2.png").getImage().getScaledInstance((int) (getBackSize()+(getBackSize()*0.2)),getBackSize(), Image.SCALE_SMOOTH));
        //cardBack = new ImageIcon(cardBack.getImage().getScaledInstance((int) (getBackSize()+(getBackSize()*0.2)),getBackSize(), Image.SCALE_SMOOTH));
        for (int i = 0; i < 32; i++) {
            //ImageIcon image = new ImageIcon(new ImageIcon("icons/sport" + (i + 1) + ".png").getImage().getScaledInstance(getFrontSize(), getFrontSize(), Image.SCALE_SMOOTH));
            ImageIcon image = new ImageIcon("MemoryGame/icons/"+ themes[theme] + (i + 1) + ".png");
            images.add(image);
            images.add(image);
        }
    }

    public void initGame(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.diff = rows * cols;
        loadIcons();
        cardBack = new ImageIcon(cardBack.getImage().getScaledInstance((int) (getBackSize() + (getBackSize() * 0.2)), getBackSize(), Image.SCALE_SMOOTH));
        int i = 0;
        for (ImageIcon image : images) {
            //card = new ImageIcon(card.getImage().getScaledInstance(getFrontSize(), getFrontSize(), Image.SCALE_SMOOTH));
            image = new ImageIcon(image.getImage().getScaledInstance(getFrontSize(), getFrontSize(), Image.SCALE_SMOOTH));
            i++;
        }
        cards = images.subList(0, getDiff());
        Collections.shuffle(cards);
    }

    public ImageIcon getIcon(int index) {
        return cards.get(index);
    }

    public void setTheme(int theme) {
        this.theme = theme;
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

    public int getFrontSize() {
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

}

