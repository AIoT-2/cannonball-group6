package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.logging.Logger;

//MovableBall 클래스
public class MovableBall extends PaintableBall {
    private static final Logger logger = Logger.getLogger(MovableBall.class.getName());

    private Rectangle boundedArea;  //제한 영역

    //생성자
    public MovableBall(String id, String name, int x, int y, int radius, Color color, int dx, int dy) {
        super(id, name, x, y, radius, color, dx, dy); // 부모 클래스에 대한 추가 초기화 코드 작성. 여기서 super = PaintableBall 클래스 가리킴
        //초기 제한 영역 설정
        this.boundedArea = new Rectangle(x - radius, y- radius, radius*2, radius*2);
    }

    // 접근자 : 제한 영역 반환
    public Rectangle getBoundedArea() {
        return boundedArea;
    }

    //변경자 : 제한 영역 설정
    public void setBoundedArea(Rectangle area) {
        //유효성 검사 : 설정하려는 영역이 볼의 영역을 포함해야 함
        if (area == null || !area.contains(getBounds())) {
            throw new IllegalArgumentException("The bounded area must include the ball's area.");
        }
        this.boundedArea = area;
    }

    //공의 경계와 이동 로직
    @Override
    public void move() {
        // 현재 위치에서 변위량만큼 이동
        super.move();

        // 새로운 경계 영역을 포함하는 최소 사각형 계산
        Rectangle newBounds = getBounds();

        // 제한 영역을 벗어난 경우, 위치 조정
        if( !boundedArea.contains(newBounds)) {
            //X축 경계 검사
            if(newBounds.x < boundedArea.x) {  //왼쪽 벽에 부딫힘
                super.setCenterX(boundedArea.x + getRadius());  //왼쪽 벽에 맞게 조정
                super.setDX(Math.abs(super.getDX())); //오른쪽으로 진행
            } else if (newBounds.x + newBounds.width > boundedArea.x + boundedArea.width) { //오른쪽 벽에 부딫힘
                super.setCenterX(boundedArea.x + boundedArea.width - radius*2); // 오른쪽 벽에 맞게 조정
                super.setDX(-Math.abs(super.getDX())); // 왼쪽으로 진행
            }

            //Y축 경계 검사
            if (newBounds.y < boundedArea.y) { //위쪽 벽에 부딪힘
                super.setCenterY(boundedArea.y + getRadius()); //위쪽 벽에 맞게 조정
                super.setDY(Math.abs(super.getDY())); //아래로 진행
            } else if (newBounds.y + newBounds.height > boundedArea.y + boundedArea.height ) {//아래쪽 벽에 부딪힘
                super.setCenterY(boundedArea.y + boundedArea.height - getRadius()*2); //아래쪽 벽에 맞게 조정
                super.setDY(-Math.abs(super.getDY())); //위쪽으로 진행
            }
        }
            //이동 후 위치를 로그로 기록
            logger.finer(String.format("MovableBall moved to position (%d, %d) with bounded area %s", super.getCenterX(), super.getCenterY(), boundedArea));
    }


    // 볼의 경계 박스 반환
    public Rectangle getBounds() {
        return new Rectangle(super.getCenterX() - getRadius(), super.getCenterY() - getRadius(), getRadius()*2, getRadius() *2 );
    }

}

