package com.nhnacademy.game;

import java.util.logging.Level;
import java.util.logging.Logger;

//Ball class에 볼이 차지하는 영역에 대한 정보 확인이 가능하도록 기능을 추가해보자.
public class Ball23 { // 출력을 위한 logger 메서드
    private static final Logger logger = Logger.getLogger(Ball23.class.getName());

    // 주어진 값들로 볼 생성이 되는지 확인하는 테스트

    public static void logging(Ball23 ball) {
        logger.log(Level.INFO, "Max X: " + ball.getMaxX());
        logger.log(Level.INFO, "Min X: " + ball.getMinX());
        logger.log(Level.INFO, "Max Y: " + ball.getMaxY());
        logger.log(Level.INFO, "Min Y: " + ball.getMinY());

    }

    // Ball22 클래스 정의

    private int x, y, radius;

    public Ball23(int x, int y, int radius) { // 생성자
            // 유효성 검사 추가
            if (radius <= 0) { // 반지름은 양의 정수로만 정의될 수 있다.
                throw new InvalidSizeException("Radius must be greater than 0");
            }
            // 좌표가 int 범위를 넘지 않는지 확인
            if (x - radius < Integer.MIN_VALUE || x + radius > Integer.MAX_VALUE) {
                throw new OutOfBoundsException("x coordinate is out of bounds");
            }
            if (y - radius < Integer.MIN_VALUE || y + radius > Integer.MAX_VALUE) {
                throw new OutOfBoundsException("y coordinate is out of bounds");
            }

            this.x = x; // x좌표
            this.y = y; // y좌표
            this.radius = radius; // 반지름
        }

    // Getter (선택 사항, private 변수에 접근하기 위해 사용)
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    // toString() 메서드 : Ball 객체의 정보를 문자열로 반환
    @Override
    public String toString() {
        return "Ball{" +
                "(x=" + x +
                ", y=" + y +
                "), radius=" + radius +
                '}';

    }

    // Setter (선택사항, private 변수를 수정하기 위해 사용)
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getMinX() { // ball의 영역 중 최소 x좌표값
        return getX() - getRadius();
    }

    public int getMaxX() { // ball의 영역 중 최대 x좌표값
        return getX() + getRadius();
    }

    public int getMinY() { // ball의 영역 중 최소 y좌표값
        return getY() - getRadius();
    }

    public int getMaxY() { // ball의 영역 중 최대 y좌표값
        return getY() + getRadius();
    }

    public int getWidth() { // ball의 영역 넓이(x축의 길이)
        return 2 * getRadius();
    }

    public int getHeight() { // ball의 영역 높이(y축의 길이)
        return 2 * getRadius();
    }

}
