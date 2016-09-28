package by.bsuir.Shaliov.laba1.game.cinema.controller;

import by.bsuir.Shaliov.laba1.game.cinema.model.ModelBasket;


public class BasketController {
    private ModelBasket modelBasket;

    public BasketController(ModelBasket modelBasket) {
        this.modelBasket = modelBasket;

    }

    public void moveBasket(int dx) {
        modelBasket.setX(dx);
    }
}
