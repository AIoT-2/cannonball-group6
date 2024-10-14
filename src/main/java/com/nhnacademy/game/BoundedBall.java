package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.UUID;

public class BoundedBall extends MovableBall {

    Rectangle boundedArea;

    public BoundedBall(UUID id, int x, int y, int radius, Color color) {
        super(id, x, y, radius, color);

        boundedArea = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    public BoundedBall(String id, int x, int y, int radius, Color color) {
        super(id, x, y, radius, color);

        boundedArea = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);

        boundedArea = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    public BoundedBall(String id, int x, int y, int radius) {
        super(id, x, y, radius);

        boundedArea = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    public BoundedBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public Rectangle getBoundedArea() {
        return boundedArea;
    }

    public void setBoundedArea(Rectangle boundedArea) {
        if (boundedArea == null) {
            throw new NullPointerException();
        }

        if ((getMinX() < boundedArea.getMinX())
                || (getMaxX() > boundedArea.getMaxX())
                || (getMinY() < boundedArea.getMinY())
                || (getMaxY() > boundedArea.getMaxY())) {
            throw new IllegalArgumentException();
        }

        this.boundedArea = new Rectangle(boundedArea);
    }

    @Override
    public void move() {
        super.move();

        if ((getMinX() < boundedArea.getMinX()) || (getMaxX() > boundedArea.getMaxX())) {
            setDX(-getDX());
        }

        if ((getMinY() < boundedArea.getMinY()) || (getMaxY() > boundedArea.getMaxY())) {
            setDY(-getDY());
        }
    }
}
