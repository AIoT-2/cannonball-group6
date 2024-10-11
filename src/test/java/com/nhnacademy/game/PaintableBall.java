package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball {

    Color color;

    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);

        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("[(%d,%d),%d,%s]",
                getX(), getY(), getRadius(), getColor());
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

