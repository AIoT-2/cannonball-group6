package com.nhnacademy.game;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Color[] colors = new Color[] { Color.BLUE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN };

        Random random = new Random();
        JFrame frame = new JFrame();

        frame.setSize(500, 400);

        World world = new World();
        frame.add(world);
        frame.setVisible(true);

        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(500);
            int y = random.nextInt(400);
            int radius = 10 + random.nextInt(41);

            if (random.nextBoolean()) {
                Color color = colors[random.nextInt(colors.length)];
                world.add(new PaintableBall(x, y, radius, color));
            } else {
                world.add(new Ball(x, y, radius));
            }
        }

        frame.repaint();
    }
}
