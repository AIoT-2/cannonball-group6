package com.nhnacademy.game;

public class MovableWorld extends World {

    int moveCount;

    int maxMoveCount;

    int dt;

    public MovableWorld(int maxMoveCount) {
        super();

        if (maxMoveCount < 0) {
            throw new IllegalArgumentException();
        }

        moveCount = 0;
        this.maxMoveCount = maxMoveCount;
    }

    public MovableWorld() {
        this(0);
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }

    public void setMaxMoveCount(int maxMoveCount) {
        if (maxMoveCount < 0) {
            throw new IllegalArgumentException();
        }
        this.maxMoveCount = maxMoveCount;
    }

    public int getDT() {
        return dt;
    }

    public void setDT(int dt) {
        if (dt < 0) {
            throw new IllegalArgumentException();
        }
        this.dt = dt;
    }

    public void reset() {
        moveCount = 0;
    }

    public void move() {
        if ((getMaxMoveCount() == 0) || (getMoveCount() < getMaxMoveCount())) {
            for (int i = 0; i < getBallCount(); i++) {
                Ball ball = getBall(i);

                if (ball instanceof MovableBall) {
                    ((MovableBall) ball).move();
                }
            }
            moveCount++;

            repaint();

        }
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        long nextTime = System.currentTimeMillis();

        while ((getMaxMoveCount() == 0) || (getMoveCount() < getMaxMoveCount())) {
            move();
            try {
                long currentTime = System.currentTimeMillis();
                if (currentTime < nextTime) {
                    Thread.sleep(nextTime - currentTime);
                }

                if (dt != 0) {
                    nextTime = startTime + ((currentTime - startTime) / dt + 1) * dt;
                } else {
                    nextTime = currentTime;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.info("Interrupt occurred.");
            }
        }
    }

}
