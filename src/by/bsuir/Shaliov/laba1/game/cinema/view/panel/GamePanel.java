package by.bsuir.Shaliov.laba1.game.cinema.view.panel;

import by.bsuir.Shaliov.laba1.game.cinema.controller.BasketController;
import by.bsuir.Shaliov.laba1.game.cinema.handler.MouseMotionHandler;
import by.bsuir.Shaliov.laba1.game.cinema.model.ModelBasket;
import by.bsuir.Shaliov.laba1.game.cinema.model.ModelGamePanel;
import by.bsuir.Shaliov.laba1.game.cinema.model.ModelPopcorn;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    private JLabel score;
    private Image background ;
    private Image popcorn ;
    private Image basket ;
    private ModelGamePanel modelGamePanel;
    private ModelBasket modelBasket;
    private List<ModelPopcorn> popcornList = new ArrayList();

    public GamePanel(int x, int y) {
        modelGamePanel = new ModelGamePanel();

        background = modelGamePanel.getBackground();
        popcorn = modelGamePanel.getPopcorn();
        basket = modelGamePanel.getBasket();

        modelBasket = new ModelBasket(x, y);
        BasketController basketController = new BasketController(modelBasket);
        addMouseMotionListener(new MouseMotionHandler(basketController));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(background != null) {
            g2.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        }
        if(basket != null) {
            g2.drawImage(basket, modelBasket.getX(), modelBasket.getY(), null);
        }
        repaint();
    }
}
