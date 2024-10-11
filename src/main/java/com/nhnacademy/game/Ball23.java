package com.nhnacademy.game;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

 // Ball 클래스 : 개별 공 객체를 나타낸다.
public class Ball23 {
    public int x, y, radius;

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

 // Getter methods (선택 사항, private 변수에 접근하기 위해 사용)
    public int getX() {return x;}

    public int getY() {return y;}

    public int getRadius() {return radius;}


// 영역 정보를 반환하는 메서드
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



@Override
    public String toString() {
        return "Ball{" +
                "(x=" + x +
                ", y=" + y +
                "), radius=" + radius +
                '}';

    }


// @Override
// public String toString() {
//     return String.format("Ball at (%d, %d) with radius %d", x, y, radius);
//     }
}



   // BallWorldApp 클래스 : 메인 실행 부분, JFrame을 이용한 화면 출력
class BallWorldApp {
    public static void main(String[] args) throws AlreadyExistException {
        //JFrame 생성 및 설정
        JFrame frame = new JFrame("Ball World");
        frame.setSize(800, 600); //Window 크기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // World 패널 생성 및 추가
        BallPanel world = new BallPanel();
        frame.add(world);
        frame.setVisible(true);

        // 랜덤한 위치와 색상, 크기로 Ball과 PaintableBall 생성
        Random rand = new Random();
        for (int i=0; i<10; i++){
            int x = rand.nextInt(750); // frame 사이즈 가로 800이라서
            int y = rand.nextInt(550); //frame 사이즈 세로 600이라서
            int radius = 10 + rand.nextInt(41); //반지름 10-50
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); 
            // RGB 색상의 각 성분(빨강, 초록, 파랑)이 0부터 255까지의 값을 가질 수 있기 때문에 256을 사용해 무작위 색상 생성

            Ball23 ball;
            if (rand.nextBoolean()) {
                ball = new PaintableBall(x, y, radius, color);
            } else {
                ball = new Ball23(x, y, radius);  //Ball 클래스는 PaintableBall 과 달리 화면에 그려지지 않음
            }


            world.addBall(ball);  //볼 추가
        }

    }
}

   

   
    // toString() 메서드 : Ball 객체의 정보를 문자열로 반환
    

