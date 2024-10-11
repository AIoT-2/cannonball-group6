
package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Graphics;


// PaintableBall 클래스 : 색상 정보를 포함한 그릴 수 있는 공 객체
public class PaintableBall extends Ball23 {

    //기본 색 정의 (Google 스타일 가이드에 따르면 상수는 대문자 및 밑줄로 표기)
    private static final Color DEFAULT_COLOR = Color.BLACK;

    // 볼의 색을 저장할 필드
    private Color color;

    // 색을 지정하는 생성자
    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);  //부모 클래스인 Ball의 생성자 호출
        this.color = color;   //PaintableBall의 색상 설정 
    }

    //색을 지정하지 않는 생성자 (기본 색을 사용)
    public PaintableBall(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);   //위의 생성자를 호출하여 기본 색을 사용
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
    }


    @Override
    public String toString() {
        return String.format("[(%d, %d), %d, %s]", x, y, radius, color.toString());
    }
}