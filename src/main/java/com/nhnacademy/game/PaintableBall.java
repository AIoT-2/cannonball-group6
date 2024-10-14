package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.UUID;

public class PaintableBall extends Ball {

    public static final Color DEFAULT_COLOR = Color.BLACK;

    Color color;

    public PaintableBall(UUID id, int x, int y, int radius, Color color) {
        super(id, x, y, radius);

        this.color = color;
    }

    public PaintableBall(String id, int x, int y, int radius, Color color) {
        super(id, x, y, radius);

        this.color = color;
    }

    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);

        this.color = color;
    }

    public PaintableBall(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);
    }

    public PaintableBall(String id, int x, int y, int radius) {
        this(id, x, y, radius, DEFAULT_COLOR);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("[%s,%s,%d,%s]",
                getId(), getLocation(), getRadius(), getColor());
    }

    public void paint(Graphics g) {
        if (g == null) {
            throw new NullPointerException();
        }

        Color oldColor = g.getColor();
        g.setColor(color);
        g.fillOval(getMinX(), getMinY(), getWidth(), getHeight());
        g.setColor(oldColor);
    }
}
