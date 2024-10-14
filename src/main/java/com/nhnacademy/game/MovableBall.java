package com.nhnacademy.game;

import java.awt.Color;
import java.util.UUID;

public class MovableBall extends PaintableBall {

    int dx;

    int dy;

    public MovableBall(UUID id, int x, int y, int radius, Color color) {
        super(id, x, y, radius, color);
    }

    public MovableBall(String id, int x, int y, int radius, Color color) {
        super(id, x, y, radius, color);
    }

    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public MovableBall(String id, int x, int y, int radius) {
        super(id, x, y, radius);
    }

    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public int getDX() {
        return dx;
    }

    public int getDY() {
        return dy;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }

    public void move() {
        moveTo(getX() + getDX(), getY() + getDY());
        logger.trace("{} - ({},{})", getId(), getX(), getY());
    }

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }
}
