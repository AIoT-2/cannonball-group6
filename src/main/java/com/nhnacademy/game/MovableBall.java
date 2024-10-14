package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Point;
import java.util.UUID;

public class MovableBall extends PaintableBall {
   
    Vector motion;


    public MovableBall(UUID id, int x, int y, int radius, Color color) {
        super(id, x, y, radius, color);

        motion = new PositionVector(0, 0);
    }


    public MovableBall(String id, int x, int y, int radius, Color color) {
        super(id, x, y, radius, color);

        motion = new PositionVector(0, 0);
    }


    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);

        motion = new PositionVector(0, 0);
    }


    public MovableBall(String id, int x, int y, int radius) {
        super(id, x, y, radius);

        motion = new PositionVector(0, 0);
    }

    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);

        motion = new PositionVector(0, 0);
    }

    public Vector getMotion() {
        return motion;
    }

 
    public void setMotion(int dx, int dy) {
        this.motion = new PositionVector(dx, dy);
    }


    public void setMotion(Vector motion) {
        this.motion = new PositionVector(motion.getDX(), motion.getDY());
    }

    public void move() {
        moveTo(getCenterX() + motion.getDX(), getCenterY() + motion.getDY());
        logger.trace("{} - ({},{})", getId(), getCenterX(), getCenterY());
    }


    public void moveTo(int x, int y) {
        setLocation(new Point(x, y));
    }
}
