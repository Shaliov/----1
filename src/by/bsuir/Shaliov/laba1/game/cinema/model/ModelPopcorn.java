package by.bsuir.Shaliov.laba1.game.cinema.model;


public class ModelPopcorn {
    private int x;
    private int y;
    private int dy;

    public ModelPopcorn(int x, int y, int dy) {
        this.x = x;
        this.y = y;
        this.dy = dy;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDy() {
        return dy;
    }
}
