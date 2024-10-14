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
        int x2 = getCenterX() + getMotion().getDX();
        int y2 = getCenterY() + getMotion().getDY();
        int x3 = x2;
        int y3 = y2;

        if (x2 - getRadius() < boundedArea.getMinX()) {
            x3 = 2 * (getMaxX() - getRadius()) - x2;
            setMotion(-getMotion().getDX(), getMotion().getDY());
        } else if (x2 + getRadius() > boundedArea.getMaxX()) {
            x3 = 2 * (getMinX() + getRadius()) - x2;
            setMotion(-getMotion().getDX(), getMotion().getDY());
        }

        if (getMinY() < boundedArea.getMinY()) {
            y3 = 2 * (getMaxY() - getRadius()) - y2;
            setMotion(getMotion().getDX(), -getMotion().getDY());
        } else if (getMaxY() > boundedArea.getMaxY()) {
            y3 = 2 * (getMinY() + getRadius()) - y2;
            setMotion(getMotion().getDX(), -getMotion().getDY());
        }

        moveTo(x3, y3);
    }
}
