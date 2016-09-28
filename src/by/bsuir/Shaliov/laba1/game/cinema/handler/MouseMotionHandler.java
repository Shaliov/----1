package by.bsuir.Shaliov.laba1.game.cinema.handler;

import by.bsuir.Shaliov.laba1.game.cinema.controller.BasketController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class MouseMotionHandler implements MouseMotionListener {
    private BasketController basketController;

    public MouseMotionHandler(BasketController basketController) {
        this.basketController = basketController;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        basketController.moveBasket(e.getX());
    }
}
