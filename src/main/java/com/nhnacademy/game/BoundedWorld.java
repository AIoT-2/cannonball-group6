package com.nhnacademy.game;

import java.awt.Rectangle;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Ball ball) {
        return (ball.getMinX() < getBounds().getMinX())
                || (ball.getMaxX() > getBounds().getMaxX())
                || (ball.getMinY() < getBounds().getMinX())
                || (ball.getMaxY() > getBounds().getMaxY());
    }

    @Override
    public void move() {
        if ((getMaxMoveCount() == 0) || (getMoveCount() < getMaxMoveCount())) {
            for (int i = 0; i < getBallCount(); i++) {
                Ball ball = getBall(i);
                if (ball instanceof MovableBall) {
                    MovableBall movableBall = (MovableBall) ball;
                    int x2 = movableBall.getX() + movableBall.getDX();
                    int y2 = movableBall.getY() + movableBall.getDY();
                    int x3 = x2;
                    int y3 = y2;

                    if (outOfBounds(ball)) {

                        if (x2 - movableBall.getRadius() < getBounds().getMinX()) {
                            x3 = 2 * (movableBall.getMaxX() - movableBall.getRadius()) - x2;
                            movableBall.setDX(-movableBall.getDX());
                        } else if (x2 + movableBall.getRadius() > getBounds().getMaxX()) {
                            x3 = 2 * (movableBall.getMinX() + movableBall.getRadius()) - x2;
                            movableBall.setDX(-movableBall.getDX());
                        }

                        if (movableBall.getMinY() < getBounds().getMinY()) {
                            y3 = 2 * (movableBall.getMaxY() - movableBall.getRadius()) - y2;
                            movableBall.setDY(-movableBall.getDY());
                        } else if (movableBall.getMaxY() > getBounds().getMaxY()) {
                            y3 = 2 * (movableBall.getMinY() + movableBall.getRadius()) - y2;
                            movableBall.setDY(-movableBall.getDY());
                        }
                    }
                    movableBall.moveTo(x3, y3);

                    for (int j = 0; j < getBallCount(); j++) {
                        if (i != j) {
                            Ball otherBall = getBall(j);

                            if (ball.isCollision(otherBall)) {
                                Rectangle intersection = ball.intersection(otherBall);

                                if (intersection.getWidth() != ball.getWidth()
                                        && intersection.getWidth() != otherBall.getWidth()) {
                                    movableBall.setDX(-movableBall.getDX());
                                }

                                if (intersection.getHeight() != ball.getHeight()
                                        && intersection.getHeight() != otherBall.getHeight()) {
                                    movableBall.setDY(-movableBall.getDY());
                                }
                            }

                        }
                    }
                }
            }
        }
        moveCount++;

        repaint();
    }
}
