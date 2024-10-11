package com.nhnacademy.game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.swing.JPanel;

//Ball Panel 클래스 : 공들을 관리하고 그리는 패널
class BallPanel extends JPanel{ 
    //필드 : 볼 관리 리스트와 로거
    private final List<Ball23> ballsList = new ArrayList<>();  // 볼들을 관리할 리스트
    private static final Logger logger = Logger.getLogger(BallPanel.class.getName());

    public static void logging(Ball23 ball) {
        logger.log(Level.INFO, "Max X: " + ball.getMaxX());
        logger.log(Level.INFO, "Min X: " + ball.getMinX());
        logger.log(Level.INFO, "Max Y: " + ball.getMaxY());
        logger.log(Level.INFO, "Min Y: " + ball.getMinY());

    }
    
    // 볼 추가 메서드
    public void addBall(Ball23 ball) throws AlreadyExistException{
        if (ball == null) {
            throw new NullPointerException("Ball cannot be null");
        }
        if (ballsList.contains(ball)) {
            throw new AlreadyExistException("Ball already exists in the list");
        }
        ballsList.add(ball);
        logger.info("Ball added: " + ball);
        repaint(); //화면 갱신
    }

     // 볼 제거 메서드 (Ball로 제거)
    public void removeBall(Ball23 ball) {
        if(ball == null) {
            throw new NullPointerException("Ball cannot be null");
        }
        if (!ballsList.contains(ball)) {
            throw new NoSuchElementException("Ball not found in the list");
        }
        ballsList.remove(ball);
        logger.info("Ball removed: " + ball);
        repaint(); //화면 갱신
    }

    //볼 제거 메서드 (index 로 제거)
    public void removeBall(int index) {
        if (index < 0 || index >= ballsList.size()) {
            throw new IndexOutOfBoundsException("Invalid index: "+ index);
        }
        Ball23 removedBall = ballsList.remove(index);
        logger.info("Ball removed at index" +index + ": " + removedBall);
        repaint();
    }

    // 관리 중인 볼의 개수를 반환하는 메서드
    public int getBallCount() {
        return ballsList.size();
    }

    //특정 위치의 볼을 가져오는 메서드
    public Ball23 getBall(int index) {
        if (index <0 || index >= ballsList.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return ballsList.get(index);
    }

    //관리 중인 모든 볼을 그리는 메서드 (paintComponent 재정의)
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Ball23 ball : ballsList) {
        if (ball instanceof PaintableBall) {
            ((PaintableBall) ball).paint(g);
        }
    }
    logger.info("그릴 수 있는 모든 공들이 그려졌습니다.");
   } 
}
