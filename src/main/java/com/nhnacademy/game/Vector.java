package com.nhnacademy.game;

public abstract class Vector {

    int dx;

    int dy;

    Vector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void add(Vector other) {
        dx = dx + other.getDX();
        dy = dy + other.getDY();
    }

    public void sub(Vector other) {
        dx = dx - other.getDX();
        dy = dy - other.getDY();
    }

    public int getDX() {
        return dx;
    }


    public int getDY() {
        return dy;
    }

    public int getAngle() {
        if (dx == 0) {
            if (dy > 0) {
                return 90;
            } else if (dy < 0) {
                return -90;
            } else {
                return 0;
            }
        }

        return (int) Math.atan((double) dy / dx);
    }

    public int getMagnitude() {
        return (int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public void turnDX() {
        dx = -dx;
    }

    public void turnDY() {
        dy = -dy;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Vector) && (((Vector) o).getDX() == getDX()) && (((Vector) o).getDY() == getDY());
    }
}
