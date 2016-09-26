package by.bsuir.Shaliov.laba1.game.cinema.view.frame;

import by.bsuir.Shaliov.laba1.game.cinema.constants.WordConstants;
import by.bsuir.Shaliov.laba1.game.cinema.view.panel.Background;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {
    private Background background;

    public StartWindow() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setTitle(WordConstants.NAME_GAME);
        setSize(screenWidth/2 + 10, screenHeight/2 + 20);
        setLocation(screenHeight/4, screenHeight/4);

        background = new Background();
        background.repaint();
        background.setVisible(true);
        this.getContentPane().add(background, BorderLayout.CENTER);



        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
