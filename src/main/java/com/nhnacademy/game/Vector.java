package com.nhnacademy.game;

public abstract class Vector {
    int dx; // x축으로의 변위량
    int dy; // y축으로의 변위량

    /*
     * 벡터를 생성한다. 단, 확장 클래스에서만 사용하도록 한다.
     * 
     * @param dx X축으로의 변위량
     * 
     * @param dy Y축으로의 변위량
     */

    Vector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /*
     * 주어진 벡터를 더한다.
     * 
     * @param other //피연산자
     */
    public void add(Vector other) {
        dx = dx + other.getDX();
        dy = dy + other.getDY();
    }

    /*
     * 주어진 벡터를 뺀다.
     * 
     * @param other 피연산자
     */
    public void sub(Vector other) {
        dx = dx - other.getDX();
        dy = dy - other.getDY();
    }

    /*
     * X축으로의 변위량
     * 
     * @return 변위량
     */
    public int getDX() {
        return dx;
    }

    /*
     * Y축으로의 변위량
     * 
     * @return 변위량
     */
    public int getDY() {
        return dy;
    }

    /*
     * X축 양의 방향을 기준으로한 벡터의 각도를 반환한다.
     * 
     * @return 벡터 방향
     */
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

    /*
     * 벡터의 크기를 반환한다.
     * 
     * @return 벡터 크기
     * 
     */
    public int getMagnitude() {
        return (int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    /*
     * X축 진행방향을 반대로 전환한다.
     */
    public void turnDX() {
        dx = -dx;
    }

    /*
     * Y축 진행방향을 반대로 전환한다.
     */
    public void turnDY() {
        dy = -dy;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Vector) && (((Vector) o).getDX() == getDX()) && (((Vector) o).getDY() == getDY());
    }

}