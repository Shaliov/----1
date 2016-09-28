package by.bsuir.Shaliov.laba1.game.cinema.model;

import java.awt.geom.Rectangle2D;

public class ModelBasket {
    private int x;
    private int y;

    private Rectangle2D rectangle;

    public ModelBasket() {

    }

    public ModelBasket(int dx, int dy) {
         x = dx/2;
         y = dy - 90;

        rectangle = new Rectangle2D.Double();
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
