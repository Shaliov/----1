package by.bsuir.Shaliov.laba1.game.cinema.view.panel;

import by.bsuir.Shaliov.laba1.game.cinema.constants.WordConstants;
import by.bsuir.Shaliov.laba1.game.cinema.controller.BasketController;
import by.bsuir.Shaliov.laba1.game.cinema.controller.BombControler;
import by.bsuir.Shaliov.laba1.game.cinema.controller.PopcornController;
import by.bsuir.Shaliov.laba1.game.cinema.handler.MouseMotionHandler;
import by.bsuir.Shaliov.laba1.game.cinema.model.ModelBasket;
import by.bsuir.Shaliov.laba1.game.cinema.model.ModelBomb;
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
    private int speed;
    private int score = 0;
    private Timer time;
    private JLabel scoreJlabel;
    private ModelGamePanel modelGamePanel;
    private ModelBasket modelBasket;
    private ListIterator<ModelPopcorn> listIteratorPopcorn;
    private ListIterator<ModelBomb> listIteratorBomb;
    private List<ModelPopcorn> popcornList = new ArrayList();
    private List<ModelBomb> bombList = new ArrayList();
    private PopcornController popcornController;
    private BombControler bombControler;
    private Background background;
    private int check = 0;
    private GamePanel gamePanel;


    private int maxWidth;
    private int maxHeight;

    public GamePanel(int maxWidth, int maxHeight,int speed) {
        modelGamePanel = new ModelGamePanel();
        gamePanel = this;
        this.speed = speed;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;

        modelBasket = new ModelBasket(maxWidth, maxHeight, 60, 60);
        BasketController basketController = new BasketController(modelBasket);
        addMouseMotionListener(new MouseMotionHandler(basketController));

        popcornController = new PopcornController();
        bombControler = new BombControler();

        Box box = Box.createHorizontalBox();

        scoreJlabel = new JLabel();
        scoreJlabel.setFont(new Font("Verdana", Font.PLAIN, 70));
        scoreJlabel.setForeground(Color.WHITE);
        scoreJlabel.setSize(new Dimension(100, 100));
        scoreJlabel.setText(String.valueOf(0));
        box.add(scoreJlabel);

        add(box);
        addPopcorn();
    }

    private void addPopcorn() {
        Random random = new Random();
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(score > 950) {
                    time.stop();
                    scoreJlabel.setText("Next lvl");
                    speed = speed - 300;
                    score = 0;
                    time = new Timer(speed, this);
                    time.start();
                }
                popcornList.add(new ModelPopcorn(random.nextInt(maxWidth), 0, 1 + random.nextInt(1)));
                if(check == 5) {
                    check = 0;
                    bombList.add(new ModelBomb(random.nextInt(maxWidth), 0, 1 + random.nextInt(1)));
                }
                check++;
                repaint();
            }
        };
        time = new Timer(speed, actionListener);
        time.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (modelGamePanel.getBackground() != null) {
            g2.drawImage(modelGamePanel.getBackground(), 0, 0, getWidth(), getHeight(), null);
        }
        if (modelBasket.getImaginarySquare() != null) {
            g2.draw(modelBasket.getImaginarySquare());
        }
        if (modelGamePanel.getBasket() != null) {
            g2.drawImage(modelGamePanel.getBasket(), modelBasket.getX(), modelBasket.getY(), null);
        }

        listIteratorBomb = bombList.listIterator();
        while (listIteratorBomb.hasNext()) {
            ModelBomb bomb = listIteratorBomb.next();
            if (bomb.getY() >= maxHeight) {
                listIteratorBomb.remove();
            } else {
                g2.drawImage(modelGamePanel.getBomb(), bomb.getX(), bomb.getY(), null);
                bombControler.moveBomb(bomb);
                if (modelBasket.getImaginarySquare().contains(bomb.getX(), bomb.getY())) {
                    time.stop();
                    listIteratorBomb.remove();
                    bombList.clear();
                    popcornList.clear();
                    scoreJlabel.setText(WordConstants.LOSE);
                    repaint();
                }
            }
        }
        listIteratorPopcorn = popcornList.listIterator();
        while (listIteratorPopcorn.hasNext()) {
            ModelPopcorn popcorn = listIteratorPopcorn.next();
            if (popcorn.getY() >= maxHeight) {
                listIteratorPopcorn.remove();
                score = score - 150;
                scoreJlabel.setText(String.valueOf(score));
                if (Integer.parseInt(scoreJlabel.getText()) < 0) {
                    time.stop();
                    scoreJlabel.setText(WordConstants.LOSE);
                    popcornList.clear();
                    repaint();
                }
            } else {
                g2.setColor(Color.RED);
                g2.setStroke(new BasicStroke(6.f));
                g2.drawOval(popcorn.getX(), popcorn.getY(), 3, 3);
                popcornController.movePopcorn(popcorn);
                if (modelBasket.getImaginarySquare().contains(popcorn.getX(), popcorn.getY())) {
                    score = score + 100;
                    scoreJlabel.setText(String.valueOf(score));
                    listIteratorPopcorn.remove();
                }
            }
        }

        repaint();
    }

    public void setBackground(Background background) {
        this.background = background;
    }
}
