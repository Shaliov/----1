package by.bsuir.Shaliov.laba1.game.cinema.view.panel;

import by.bsuir.Shaliov.laba1.game.cinema.controller.BasketController;
import by.bsuir.Shaliov.laba1.game.cinema.controller.PopcornController;
import by.bsuir.Shaliov.laba1.game.cinema.handler.MouseMotionHandler;
import by.bsuir.Shaliov.laba1.game.cinema.model.ModelBasket;
import by.bsuir.Shaliov.laba1.game.cinema.model.ModelGamePanel;
import by.bsuir.Shaliov.laba1.game.cinema.model.ModelPopcorn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GamePanel extends JPanel {
    private JLabel score;
    private ModelGamePanel modelGamePanel;
    private ModelBasket modelBasket;
    private ListIterator<ModelPopcorn> listIteratorPopcorn;
    private List<ModelPopcorn> popcornList = new ArrayList();
    private PopcornController popcornController;

    private int maxWidth;
    private int maxHeight;

    public GamePanel(int maxWidth, int maxHeight) {
        modelGamePanel = new ModelGamePanel();

        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;

        modelBasket = new ModelBasket(maxWidth, maxHeight, modelGamePanel.getBasket());
        BasketController basketController = new BasketController(modelBasket);
        addMouseMotionListener(new MouseMotionHandler(basketController));

        popcornController = new PopcornController();

        addPopcorn();
    }

    private void addPopcorn() {
        Random random = new Random();
        Timer time = new Timer(random.nextInt(1000), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popcornList.add(new ModelPopcorn(random.nextInt(maxWidth), 0, 1 + random.nextInt(1)));
                repaint();
            }
        });
        time.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(modelGamePanel.getBackground() != null) {
            g2.drawImage(modelGamePanel.getBackground(), 0, 0, getWidth(), getHeight(), null);
        }
        if(modelGamePanel.getBasket() != null) {
            g2.drawImage(modelGamePanel.getBasket(), modelBasket.getX(), modelBasket.getY(), null);
        }
        listIteratorPopcorn = popcornList.listIterator();
        while (listIteratorPopcorn.hasNext()) {
            ModelPopcorn popcorn = listIteratorPopcorn.next();
            if(popcorn.getY() >= maxHeight) {
                listIteratorPopcorn.remove();
            }
            else{
//                modelGamePanel.getBasket();
                g2.setColor(Color.RED);
                g2.setStroke(new BasicStroke(6.f));
                g2.drawOval(popcorn.getX(), popcorn.getY(), 3, 3);

                popcornController.movePopcorn(popcorn);
            }
        }

        repaint();
    }
}
