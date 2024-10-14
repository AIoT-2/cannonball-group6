package com.nhnacademy.game;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ball {

    static final Logger logger = LoggerFactory.getLogger(Ball.class);

    UUID id;

    String name;

    Rectangle bounds;

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
        this.bounds = new Rectangle(x - radius, y - radius, 2 * radius, 2 * radius);
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

    public Point getLocation() {
        return bounds.getLocation();
    }

    void setLocation(Point location) {
        bounds.setLocation(location);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getCenterX() {
        return (int) bounds.getCenterX();
    }

    public int getCenterY() {
        return (int) bounds.getCenterY();
    }

    public int getRadius() {
        return (int) bounds.getWidth() / 2;
    }

    public int getMinX() {
        return (int) bounds.getMinX();
    }

    public int getMaxX() {
        return (int) bounds.getMaxX();
    }

    public int getMinY() {
        return (int) bounds.getMinY();
    }

    public int getMaxY() {
        return (int) bounds.getMaxY();
    }

    public int getWidth() {
        return (int) bounds.getWidth();
    }

    public int getHeight() {
        return (int) bounds.getHeight();
    }

    public boolean isCollision(Ball ball) {
        return getBounds().intersects(ball.getBounds());
    }

    public Rectangle intersection(Ball ball) {
        return getBounds().intersection(ball.getBounds());
    }

    @Override
    public String toString() {
        return String.format("[%s,%s,%d]",
                getId(), getLocation(), getRadius());
    }
}
