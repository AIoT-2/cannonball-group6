
package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Logger;


// PaintableBall 클래스 : 색상 정보를 포함한 그릴 수 있는 공 객체
public class PaintableBall extends Ball23 {
    private static final Logger logger= Logger.getLogger(PaintableBall.class.getName());

    //기본 색 정의 (Google 스타일 가이드에 따르면 상수는 대문자 및 밑줄로 표기)
    private static final Color DEFAULT_COLOR = Color.BLACK;

    private Color color;
    public int dx; //x축 변위량
    public int dy; //Y축 변위량

    // 색을 지정하는 생성자
    public PaintableBall(int x, int y, int radius, Color color, int dx, int dy) {
        super(x, y, radius);  //부모 클래스인 Ball의 생성자 호출
        this.color = color;   //PaintableBall의 색상 설정
        this.dx = dx;
        this.dy = dy;

        //Trace 로그 추가
        logger.finest(String.format("PaintableBall created at (%d, %d) with radius: %d, dx: %d, dy: %d", x, y, radius, dx, dy));
    }

    //색을 지정하지 않는 생성자 (기본 색을 사용)
    public PaintableBall(int x, int y, int radius, int dx, int dy) {
        this(x, y, radius, DEFAULT_COLOR, dx, dy);   //위의 생성자를 호출하여 기본 색을 사용
    }

    public int getDX() {
        return dx;
    }

    public int getDY() {
        return dy;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }

    public void move(){
        // 현재 위치에서 변위량만큼 이동
        x += dx;
        y += dy;

        // 이동 후 좌표를 로그로 기록
        logger.finer(String.format("Ball moved to position (%d, %d) with dx: %d, dy: %d", x, y, dx, dy));
    }

    void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }

    //색상 반환 메서드 
    public Color getColor() {
        return color;
    }

    // 색상 설정 메서드
    public void setColor(Color color) {
        this.color = color;
    }

    //paint 메서드 : AWT Graphisc 인스턴스를 받아 그리기 수행
    public void paint(Graphics g) {
        // 이전 색을 저장(나중에 기존 색상 복구를 위함)
       Color prevColor = g.getColor();

        //새로운 색 설정
        g.setColor(color);

        // 원 그리기 (x와 y는 원을 그릴 사각형의 왼쪽 상단 모서리의 좌표임)
        g.fillOval(x - radius, y - radius, radius*2, radius*2);

        // 이전 색 복원
        g.setColor(prevColor);

        // 그릴 때마다 로그 출력
        logger.finest(String.format("Ball painted at (%d, %d) with color: %s", x, y, color.toString()));
    }


    @Override
    public String toString() {
        return String.format("[(%d, %d), %d, %s]", x, y, radius, color.toString());
    }
}