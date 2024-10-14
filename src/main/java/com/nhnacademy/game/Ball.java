package com.nhnacademy.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ball {

    static final Logger logger = LoggerFactory.getLogger(Ball.class);

    int x;
    int y;
    int radius;

    public Ball(int x, int y, int radius) {
        if (radius <= 0) {
            throw new InvalidSizeException();
        }

        if (((x < 0) && (x < (Integer.MIN_VALUE + radius)))
                || ((y < 0) && (y < (Integer.MIN_VALUE + radius)))
                || ((x > 0) && (x > (Integer.MAX_VALUE - radius)))
                || ((y > 0) && (y > (Integer.MAX_VALUE - radius)))) {
            throw new OutOfBoundsException();
        }

        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public int getMinX() {
        return getX() - getRadius();
    }

    public int getMaxX() {
        return getX() + getRadius();
    }

    public int getMinY() {
        return getY() - getRadius();
    }

    public int getMaxY() {
        return getY() + getRadius();
    }

    public int getWidth() {
        return 2 * getRadius();
    }

    public int getHeight() {
        return 2 * getRadius();
    }

    @Override
    public String toString() {
        return String.format("[(%d,%d),%d]",
                getX(), getY(), getRadius());
    }
}
