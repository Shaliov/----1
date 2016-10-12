package by.bsuir.Shaliov.laba1.game.cinema.controller;

import by.bsuir.Shaliov.laba1.game.cinema.model.ModelBasket;

import java.awt.geom.Rectangle2D;


public class BasketController {
    private ModelBasket modelBasket;

    public BasketController(ModelBasket modelBasket) {
        this.modelBasket = modelBasket;

    }

    public void moveBasket(int dx) {
        modelBasket.setX(dx);
        modelBasket.setImaginarySquare(new Rectangle2D.Double((double)dx , (double)modelBasket.getY(), (double)  40, (double) modelBasket.getY()));
    }
}
