package by.bsuir.Shaliov.laba1.game.cinema.view.panel;
import by.bsuir.Shaliov.laba1.game.cinema.constants.ImageConstants;

import javax.swing.*;
import java.awt.*;


public class Background extends JPanel {
    private Background background = this;

    public Background() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = Toolkit.getDefaultToolkit().getImage(ImageConstants.BACKGROUND);
        if(image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
        repaint();
    }
    public Background getBackGround() {
        return background;
    }
}
