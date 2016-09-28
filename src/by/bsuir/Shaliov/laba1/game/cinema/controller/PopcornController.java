package by.bsuir.Shaliov.laba1.game.cinema.controller;

import by.bsuir.Shaliov.laba1.game.cinema.model.ModelPopcorn;

public class PopcornController {

    public PopcornController() {
    }

    public void movePopcorn(ModelPopcorn popcorn) {
        popcorn.setY(popcorn.getY() + popcorn.getDy());
    }
}
