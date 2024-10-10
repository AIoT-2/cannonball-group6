package com.nhnacademy.game;

public class Ball {
 
    int x;
    int y;
    int radius;

    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
        return String.format("[(%d,%d),%d]", x, y, radius);
    }
}
