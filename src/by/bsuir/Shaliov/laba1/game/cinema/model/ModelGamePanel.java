package by.bsuir.Shaliov.laba1.game.cinema.model;

import by.bsuir.Shaliov.laba1.game.cinema.constants.ImageConstants;

import java.awt.*;

public class ModelGamePanel {
    private Image background;
    private Image popcorn;
    private Image basket;
    private Image bomb;


    public ModelGamePanel() {
        background = Toolkit.getDefaultToolkit().getImage(ImageConstants.BACKGROUND);
        popcorn = Toolkit.getDefaultToolkit().getImage(ImageConstants.POPCORN);
        basket = Toolkit.getDefaultToolkit().getImage(ImageConstants.BASKET);
        bomb = Toolkit.getDefaultToolkit().getImage(ImageConstants.BOMB);

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
    public Image getBomb() {
        return bomb;
    }
}
