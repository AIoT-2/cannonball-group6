package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;



class Main {
    public static void main(String[] args) {
        JFrame frame2 = new JFrame("Movable World");
        MovableWorld MovableWorld = new MovableWorld();

        frame2.add(MovableWorld);
        frame2.setSize(800, 600);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

        // 공 추가 예시
        for ( int i= 0; i<5; i++){
            int radius = new Random().nextInt(41)+10; //10~50의 반지름
            PaintableBall ball2 = new PaintableBall(100, 100, radius, Color.RED, 0, 0);
            MovableWorld.addBall(ball2);
        }
        //공 이동 시작
        new Thread(MovableWorld::run).start();
    }
}

public class MovableWorld extends JPanel {
    private final List<PaintableBall> balls; //공 목록
    private int moveCount; //현재 이동 횟수
    private int maxMoveCount; //최대 이동 횟수
    private final Random random; //난수 생성기

    // 생성자 : 최대 이동 횟수를 지정하거나 무한 이동으로 설정
    public MovableWorld(int maxMoveCount) {
        if (maxMoveCount < 0) {
            throw new IllegalArgumentException("Maximum move count cannot be negative");
        }
        this.balls = new ArrayList<>();
        this.moveCount = 0;
        this.maxMoveCount = maxMoveCount; //무한 이동으로 설정
        this.random = new Random();
    }

    // 기본 생성자: 무한 이동으로 설정
    public MovableWorld() {
        this(0); //0으로 설정하여 무한 이동
    }

    //Accessor : 현재 이동 횟수 반환
    public int getMoveCount() {
        return moveCount;
    }

    //Accessor : 최대 이동 횟수 반환
    public int getMaxMoveCount() {
        return maxMoveCount;
    }

    //Mutator: 최대 이동 횟수를 설정
    public void setMaxMoveCount(int count) {
        if (count <0) {
            throw new IllegalArgumentException("Maximum move count cannot be negative");
        }
        this.maxMoveCount = count;
    }

    //Operator : 이동 횟수 초기화
    public void reset() {
        moveCount = 0;  //이동 횟수 초기화
    }

    //Operator: 공 이동
    public void move() {
        //최대 이동 횟수 도달 시 이동하지 않음
        if (maxMoveCount != 0 && moveCount >= maxMoveCount) {
            return; //이동하지 않음
        }

        for (PaintableBall ball : balls) {
            // 각 볼에 대해 무작위로 변위량 생성
            int dx = random.nextInt(21) + 10; //10~30
            int dy = random.nextInt(21) + 10; //10~30

            // 볼을 이동시키고, 위치를 제한
            ball.setDX(dx*(random.nextBoolean()? 1: -1)); //x 축 이동
            ball.setDY(dy * (random.nextBoolean() ? 1: -1)); //y축 이동
            ball.move();
        }

        moveCount++; // 이동횟수 증가
        repaint(); //화면 갱신
    }

    //Operator: 공 이동을 계속 실행
    public void run() {
        while (maxMoveCount ==0 || moveCount < maxMoveCount) {
            move(); //이동
            try {
                Thread.sleep(100); // 이동 간격 조정 (100ms)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break; // 스레드 중단 시 종료
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PaintableBall ball: balls) {
            ball.paint(g); // 각 볼을 그리는 메서드를 호출
        }
    }

    public void addBall(PaintableBall ball) {
        balls.add(ball);
        repaint(); //공이 추가되면 화면을 갱신
    }
}
