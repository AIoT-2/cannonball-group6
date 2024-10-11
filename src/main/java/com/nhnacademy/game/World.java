package com.nhnacademy.game;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class World extends JPanel {

    static final Logger logger = LoggerFactory.getLogger(World.class);

    List<Ball> ballList = new LinkedList<>();

    public void add(Ball ball) {
        if (ball == null) {
            throw new NullPointerException();
        }

        if (ballList.contains(ball)) {
            throw new AlreadyExistException();
        }

        ballList.add(ball);
    }

    public void remove(Ball ball) {
        if (ball == null) {
            throw new NullPointerException();
        }

        if (!ballList.remove(ball)) {
            throw new NoSuchElementException();
        }
    }

    public void removeBall(int index) {
        ballList.remove(index);
    }

    public int getBallCount() {
        return ballList.size();
    }

    public Ball getBall(int index) {
        return ballList.get(index);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Ball ball : ballList) {
            if (ball instanceof PaintableBall) {
                ((PaintableBall) ball).paint(g);
            }
        }
    }
}
