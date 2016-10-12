package by.bsuir.Shaliov.laba1.game.cinema.model;


public class ModelBomb {
    private int x;
    private int y;
    private int dy;

    public ModelBomb() {
    }

    public ModelBomb(int x, int y, int dy) {
        this.x = x;
        this.y = y;
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
