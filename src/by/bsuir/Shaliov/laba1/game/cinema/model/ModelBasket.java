package by.bsuir.Shaliov.laba1.game.cinema.model;


public class ModelBasket {
    private int x;
    private int y;

    public ModelBasket() {
    }

    public ModelBasket(int dx, int dy) {
         x = dx/2;
         y = dy - 90;
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
