package by.bsuir.Shaliov.laba1.game.cinema.view.frame;

import by.bsuir.Shaliov.laba1.game.cinema.constants.WordConstants;
import by.bsuir.Shaliov.laba1.game.cinema.model.ModelBasket;
import by.bsuir.Shaliov.laba1.game.cinema.view.panel.Background;
import by.bsuir.Shaliov.laba1.game.cinema.view.panel.GamePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame {
    private Background background;
    private GamePanel gamePanel;
    private StartWindow startWindow = this;

    public StartWindow() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setTitle(WordConstants.NAME_GAME);
        setSize(screenWidth/2 + 10, screenHeight/2 + 20);
        setLocation(screenHeight/4, screenHeight/4);

        Box box = Box.createHorizontalBox();
        startExit(box);
        box.setBorder(new EmptyBorder(12, 12, 12, 12));

        background = new Background();
        background.repaint();
        background.add(box);
        background.setVisible(true);
        this.getContentPane().add(background, BorderLayout.CENTER);

        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void startExit(Box boxPanel) {
        Box okBox = Box.createHorizontalBox();
        JButton start = new JButton(WordConstants.START);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                background.setVisible(false);
                gamePanel = new GamePanel(startWindow.getWidth(), startWindow.getHeight());
                startWindow.add(gamePanel);
                gamePanel.setVisible(true);
            }
        });
        JButton exit = new JButton(WordConstants.EXIT);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        okBox.add(Box.createHorizontalGlue());
        okBox.add(start);
        okBox.add(Box.createHorizontalStrut(12));
        okBox.add(exit);
        boxPanel.add(okBox);
        boxPanel.add(Box.createVerticalStrut(12));
        boxPanel.add(Box.createHorizontalStrut(24));
    }
}
