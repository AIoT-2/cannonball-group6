package com.nhnacademy.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import java.awt.Color;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

 // 동일한 테스트 과정을 여러 방법으로 구현해본다. -> 여러 방식의 테스트를 통해 견고한 검증 가능

public class PaintableBallTest {

   
    
    @Test  // 가장 기본적인 테스트. 특정 상황에 대한 간단한 검증 가능. 단점: 반복적인 검증은 따로 구현해야 한다.
    public void testBallMovement() { //주어진 dx와 dy에 따라 공이 올바르게 이동하는지 확인
        PaintableBall ball = new PaintableBall(0, 0, 10, 5, 10);
        ball.move(); //한번 이동
        assertEquals(5, ball.getCenterX(), "Ball should move to x = 5");
        assertEquals(10, ball.getCenterY(), "Ball should move to y= 10");
    }
    
}

class PaintableBallRepeatedTest { //특정 이동을 여러번 반복하여 이동 기능이 일관되게 작동하는지 확인

    @RepeatedTest(10)  //10번 반복
    public void testBallMovementRepeated() {
        PaintableBall ball = new PaintableBall(0, 0, 10,  5, 10);
        ball.move(); //한번 이동
        assertEquals(5, ball.getCenterX(), "Ball should move to x = 5");
        assertEquals(10, ball.getCenterY(), "Ball should move to y = 10");
    }
}

class PaintableBallParameterizedTest {//다양한 dx, dy 값으로 공의 이동을 테스트하는 방법. 다양한 입력 값을 테스트 할 수 있어, 
//     여러 시나리오를 한번에 검증하는데 유리하다.단점: 설정이 상대적으로 복잡할 수 있다.

    @ParameterizedTest
    @CsvSource({
        "0, 0, 5, 10, 5, 10",
        "10, 20, 15, 25, 25, 45",
        "100, 200, 0, 0, 100, 200"
    })
    public void testBallMovementParameterized(int startX, int startY, int dx, int dy, int expectedX, int expectedY) {
        PaintableBall ball = new PaintableBall(startX, startY, 10, dx, dy);
        ball.move(); //한번 이동
        assertEquals(expectedX, ball.getCenterX(), "Ball shoudl move to x = " + expectedX);
        assertEquals(expectedY, ball.getCenterY(), "Ball should move to y=" +expectedY);
    }
}