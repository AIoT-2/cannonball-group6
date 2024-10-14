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
        frame2.setDefaultCloseOperatApp {
            public static void main(String[] args) throws AlreadyExistException {
                // JFrame 생성 및 설정
                JFrame frame = new JFrame("Ball World");
                frame.setSize(800, 600); // Window 크기 설정
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
                // World 패널 생성 및 추가
                BallPanel world = new BallPanel();
                frame.add(world);
                frame.setVisible(true);
        
                // 랜덤한 위치와 색상, 크기로 Ball과 PaintableBall 생성
                Random rand = new Random();
                int ballCount = 10; // 추가할 공의 개수
                int addedBallCount = 0;
        
                // 월드에 볼 추가시 볼의 모든 부분이 월드의 영역 안에 포함되는지 확인하고 추가하는 반복문
                while (addedBallCount < ballCount) {
                    try {
                        int x = rand.nextInt(750); // frame 사이즈 가로 800이라서
                        int y = rand.nextInt(550); // frame 사이즈 세로 600이라서
                        int radius = 10 + rand.nextInt(41); // 반지름 10-50
                        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                        // RGB 색상의 각 성분(빨강, 초록, 파랑)이 0부터 255까지의 값을 가질 수 있기 때문에 256을 사용해 무작위 색상 생성
        
                        Ball23 ball;
                        if (rand.nextBoolean()) {
                            int dx = rand.nextInt(11) - 5; // -5부터 5까지의 변위량을 랜덤으로 설정
                            int dy = rand.nextInt(11) - 5; // -5부터 5까지의 변위량을 랜덤으로 설정
                            ball = new PaintableBall(x, y, radius, dx, dy); // 기본 색을 사용하는 공 생성
                        } else {
                            ball = new Ball23(x, y, radius); // 일반 공 생성
                        }
        
                        // 공의 영역이 월드(800X600) 안에 포함되는지 확인
                        if (isWithinBounds(ball, frame.getWidth(), frame.getHeight())) {
                            world.addBall(ball); // 볼 추가
                            addedBallCount++; // 추가된 볼 개수 증가
                        } else {
                            throw new OutOfBoundsException("공이 월드 영역 밖입니다.");
                        }
        
                    } catch (OutOfBoundsException e) {
                        System.out.println(e.getMessage() + "해당 볼을 폐기하고 다시 시도합니다.");
                    }
                }
            }
            int dx= new Random().nextInt(21)+10; //10~30의 랜덤 dx
            int dy = new Random().nextInt(21) + 10; //10~30의 랜덤 dy
            PaintableBall ball2 = new PaintableBall(100, 100, radius, dx, dy);
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

            // 볼의 현재 변위량을 설정
            ball.setDX(dx*(random.nextBoolean()? 1: -1)); //x 축 이동
            ball.setDY(dy * (random.nextBoolean() ? 1: -1)); //y축 이동


            //로그 추가
            System.out.printf("Set dx: %d, dy: %d for ball with ID: %s%n", ball.getDX(), ball.getDY(), ball.getID());


            // 볼 이동
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
