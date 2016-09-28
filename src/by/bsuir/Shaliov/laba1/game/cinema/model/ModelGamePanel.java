package by.bsuir.Shaliov.laba1.game.cinema.model;

import by.bsuir.Shaliov.laba1.game.cinema.constants.ImageConstants;

import java.awt.*;

public class ModelGamePanel {
    private Image background;
    private Image popcorn;
    private Image basket;
    private int score;

    public ModelGamePanel() {
        background = Toolkit.getDefaultToolkit().getImage(ImageConstants.BACKGROUND);
        popcorn = Toolkit.getDefaultToolkit().getImage(ImageConstants.POPCORN);
        basket = Toolkit.getDefaultToolkit().getImage(ImageConstants.BASKET);
        score = 0;

    }

    public Image getBackground() {
        return background;
    }

    public Image getPopcorn() {
        return popcorn;
    }

    public Image getBasket() {
        return basket;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
