package by.bsuir.Shaliov.laba1.game.cinema.model;


import java.awt.geom.Rectangle2D;

public class ModelBasket {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Rectangle2D imaginarySquare;


    public ModelBasket() {

    }

    public ModelBasket(int x, int y,int dx, int dy ) {
         this.x = x/2;
         this.y = y - 90;
         this.dx = dx;
         this.dy = dy;

        imaginarySquare = new Rectangle2D.Double((double)x/2, (double)y-90, (double) 40, (double) dy-30);
    }


    public Rectangle2D getImaginarySquare() {
        return imaginarySquare;
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

    public void setImaginarySquare(Rectangle2D imaginarySquare) {
        this.imaginarySquare = imaginarySquare;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
