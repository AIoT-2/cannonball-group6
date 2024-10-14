package com.nhnacademy.game;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static final Logger logger = LoggerFactory.getLogger(Main.class);
    static final int BALL_COUNT = 10;
    static final int FRAME_WIDTH = 500;
    static final int FRAME_HEIGHT = 400;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        BoundedWorld world = new BoundedWorld();
        frame.add(world);
        frame.setVisible(true);

        world.setDT(10);
        world.setMaxMoveCount(0);

        world.add(new PaintableBall(FRAME_WIDTH / 2, FRAME_HEIGHT / 2, 50));
        MovableBall ball = new MovableBall(50, 50, 20);
        ball.setMotion(new PositionVector(3, 1));
        world.add(ball);

        world.run();
    }
}
