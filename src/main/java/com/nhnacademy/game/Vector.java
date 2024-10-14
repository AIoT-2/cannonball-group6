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

/* 자바에서 Vector 클래스의 용도
동적 배열: 크기가 가변적인 배열로, 필요에 따라 자동으로 크기를 조절합니다.
스레드 안전: 여러 스레드가 동시에 접근해도 안전하게 사용할 수 있습니다.
데이터 저장: 객체를 쉽게 추가, 삭제, 검색할 수 있어 임시 데이터 저장에 유용합니다.
리스트 기능: List 인터페이스를 구현해, 순차적으로 데이터를 관리할 수 있습니다. */