package com.nhnacademy.game;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        JFrame frame = new JFrame();

        frame.setSize(500, 400);

        World world = new World();
        frame.add(world);
        frame.setVisible(true);

        MovableBall ball = new MovableBall(50, 50, 20);
        ball.setDX(10);
        ball.setDY(20);
        world.add(ball);
        logger.trace("{},{}", ball.getX(), ball.getY());
        for (int i = 0; i < 10; i++) {
            ball.move();
            logger.trace("{},{}", ball.getX(), ball.getY());
        }

        frame.repaint();
    }
}
