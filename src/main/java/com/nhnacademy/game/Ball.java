package com.nhnacademy.game;

import java.awt.Rectangle;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ball {

    static final Logger logger = LoggerFactory.getLogger(Ball.class);

    UUID id;

    String name;

    int x;
    int y;

    int radius;

    public Ball(UUID id, int x, int y, int radius) {
        if (radius <= 0) {
            throw new InvalidSizeException();
        }

        if (((x < 0) && (x < (Integer.MIN_VALUE + radius)))
                || ((y < 0) && (y < (Integer.MIN_VALUE + radius)))
                || ((x > 0) && (x > (Integer.MAX_VALUE - radius)))
                || ((y > 0) && (y > (Integer.MAX_VALUE - radius)))) {
            throw new OutOfBoundsException();
        }

        this.id = id;
        this.name = id.toString();
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Ball(String id, int x, int y, int radius) {
        this(UUID.fromString(id), x, y, radius);
    }

    public Ball(int x, int y, int radius) {
        this(UUID.randomUUID(), x, y, radius);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isCollision(Ball ball) {
        return !((ball.getMaxX() < getMinX())
                || (ball.getMinX() > getMaxX())
                || (ball.getMaxY() < getMinY())
                || (ball.getMinY() > getMaxY()));
    }

    public Rectangle intersection(Ball ball) {
        Rectangle rect1 = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
        Rectangle rect2 = new Rectangle(ball.getMinX(), ball.getMinY(), ball.getWidth(), ball.getHeight());

        return rect1.intersection(rect2);
    }

    @Override
    public String toString() {
        return String.format("[%s, (%d,%d),%d]",
                getId(), getX(), getY(), getRadius());
    }
}
