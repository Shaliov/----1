package by.bsuir.Shaliov.laba1.game.cinema.controller;


import by.bsuir.Shaliov.laba1.game.cinema.model.ModelBomb;

public class BombControler {
    public BombControler() {
    }
    public void moveBomb(ModelBomb modelBomb) {
        modelBomb.setY(modelBomb.getY() + modelBomb.getDy());

    }
}
