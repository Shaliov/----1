package by.bsuir.Shaliov.laba1.game.cinema.view.panel;

import by.bsuir.Shaliov.laba1.game.cinema.constants.ImageConstants;
import by.bsuir.Shaliov.laba1.game.cinema.constants.WordConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Background extends JPanel {
    private Background background = this;

    public Background getBackGround() {
        return background;
    }

    public Background() {
        Box box = Box.createHorizontalBox();
        startExit(box);
        box.setBorder(new EmptyBorder(12, 12, 12, 12));
        add(box);

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

    private void startExit(Box boxPanel) {
        Box okBox = Box.createHorizontalBox();
        JButton start = new JButton(WordConstants.START);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                background.setVisible(false);
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
