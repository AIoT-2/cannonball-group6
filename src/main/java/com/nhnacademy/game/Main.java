package com.nhnacademy.game;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        Color[] colors = new Color[] { Color.BLUE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN };

        Random random = new Random();
        JFrame frame = new JFrame();

        frame.setSize(500, 400);

        World world = new World();
        frame.add(world);
        frame.setVisible(true);

        while (world.getBallCount() < 10) {
            int x = random.nextInt(500);
            int y = random.nextInt(400);
            int radius = 10 + random.nextInt(41);

            try {
                if (random.nextBoolean()) {
                    Color color = colors[random.nextInt(colors.length)];
                    world.add(new PaintableBall(x, y, radius, color));
                } else {
                    world.add(new Ball(x, y, radius));
                }
            } catch (OutOfBoundsException e) {
                logger.error(e.getMessage());
            }
        }

        frame.repaint();
    }
}
