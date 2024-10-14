
package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.UUID;
import java.util.logging.Logger;
import java.awt.Rectangle;
import java.util.Random;


// PaintableBall 클래스 : 색상 정보를 포함한 그릴 수 있는 공 객체
public class PaintableBall extends Ball23 {
    private static final Logger logger= Logger.getLogger(PaintableBall.class.getName());

    //기본 색 정의 (Google 스타일 가이드에 따르면 상수는 대문자 및 밑줄로 표기)
    private static final Color DEFAULT_COLOR = Color.BLACK;

    private final UUID id; //고유 식별자
    private String name; //공 이름
    private Color color;
    public int dx; //x축 변위량
    public int dy; //Y축 변위량
    private static final Random RANDOM = new Random();  //Random 인스턴스 생성

    //변경 : Rectangle region으로 생성자 정의
   protected Rectangle region; //공의 영역을 정의하는 Rectangle

    //고유 식별자를 포함하는 생성자
    public PaintableBall(String id, String name, int x, int y, int radius, Color color, int dx, int dy) {
        super(x, y, radius); //부모 클래스인 Ball의 생성자 호출
        // Rectangle 생성
        this.region = new Rectangle(x - radius, y-radius, radius *2, radius *2);

        //UUID 형식 검증
        if (id != null) {
            try {
                this.id = UUID.fromString(id);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid UUID format: " + id, e);
            }
        } else {
            this.id = UUID.randomUUID();  //UUID가 null일 경우 자동 생성 
        }

        this.name = name != null ? name : this.id.toString();  //이름 설정 또는 ID로 기본설정

        // 색상 설정: 랜덤 색상 생성
        this.color = new Color(RANDOM.nextInt(256),RANDOM.nextInt(256),RANDOM.nextInt(256));

        this.dx = dx;
        this.dy = dy;

        // Trace 로그 추가
        logger.info(String.format("PaintableBall created [ID: %s, Name: %s] at (%d, %d) with radius: %d, dx: %d, dy: %d",
                                        this.id, this.name, x, y, radius, dx, dy));
    }

    //색을 지정하지 않는 생성자 (기본 색을 사용)
    public PaintableBall(int x, int y, int radius, int dx, int dy) {
        this(null, null, x, y, radius, DEFAULT_COLOR, dx, dy);   //위의 생성자를 호출하여 기본 색을 사용
    }


    // ID 반환
    public UUID getID() {
        return id;
    }

    //이름 반환
    public String getName(){
        return name;
    }

    //이름 설정
    public void setName(String name) {
        this.name = name;
        logger.info(String.format("Name changed to %s for PaintableBall [ID: %s]", name, id));
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
       //현재 위치에서 변위량 만큼 이동
       region.x += dx;
       region.y += dy;

       //이동 후 좌표를 로그로 기록
       logger.finer(String.format("Ball moved to position (%d, %d) with dx : %d, dy : %d", region.x, region.y, dx, dy));
    }

    void moveTo(int x, int y){
        this.region.x = x;
        this.region.y= y;
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
        g.fillOval(region.x - radius, region.y - radius, radius*2, radius*2);

        // 이전 색 복원
        g.setColor(prevColor);

        // 그릴 때마다 로그 출력
        logger.finest(String.format("Ball painted at (%s, %s) with color: %s", id, name, region.x, region.y, color.toString()));
    }


    @Override
    public String toString() {
        return String.format("[(%s, %s), %d, %s]", id, name, region.x, region.y, radius, color.toString());
    }
}