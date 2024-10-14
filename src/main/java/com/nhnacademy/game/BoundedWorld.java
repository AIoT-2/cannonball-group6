package com.nhnacademy.game;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.JPanel;


public class BoundedWorld extends JPanel{
    private List<MovableBall> balls; // World 안의 공들


    // 생성자에서 경계 영역을 설정
    public BoundedWorld(List<MovableBall> balls) {
        this.balls= balls;
        //JPanel의 크기를 명시적으로 설정
        this.setBounds(0,0,500,500); //적적한 크기를 설정함
    }
        

    //world의 경계를 가져오는 메서드 (JPanel의 getBounds를 사용)
    @Override
    public Rectangle getBounds() {
        return super.getBounds();
    }

    // 주어진 공이 world의 경계를 벗어났는지 확인
    public boolean outOfBounds(MovableBall ball) {
        Rectangle ballBounds = ball.getBounds();
        Rectangle worldBounds = getBounds();

        return !worldBounds.contains(ballBounds); //world의 경계가 ball을 포함하지 않으면 true
    }

    //단위 시간마다 공을 이동시키고 경계를 벗어났는지 확인하며 위치 조정
    public void move() {
        for (MovableBall ball: balls) {
            ball.move(); //공을 이동시킴

            if (outOfBounds(ball)) {
                adjustBallPosition(ball); //경계를 벗어났을 경우 위치 조정
            }
        }
    }

    //공이 world 경계를 벗어났을 때 위치 조정
    private void adjustBallPosition(MovableBall ball) {
        Rectangle worldBounds = getBounds();

    // x축 조정
    if (ball.getCenterX() - ball.getRadius() < worldBounds.getX()) {
        ball.setCenterX((int) worldBounds.getX() + ball.getRadius());
        ball.setDX(Math.abs(ball.getDX())); //오른쪽으로 튕김
    } else if (ball.getCenterX() + ball.getRadius() > worldBounds.getMaxX()) {
        ball.setCenterX((int) worldBounds.getMaxX() - ball.getRadius());
        ball.setDX(-Math.abs(ball.getDX())); //왼쪽으로 튕김
    }

    //y축 조정
    if(ball.getCenterY() - ball.getRadius() < worldBounds.getY()) {
        ball.setCenterY((int) worldBounds.getY() + ball.getRadius());
        ball.setDY(Math.abs(ball.getDY())); //아래로 튕김
    } else if (ball.getCenterY() + ball.getRadius() > worldBounds.getMaxY()) {
        ball.setCenterY((int) worldBounds.getMaxY() - ball.getRadius());
        ball.setDY(-Math.abs(ball.getDY())); //위로 튕김
    }
    }
}
