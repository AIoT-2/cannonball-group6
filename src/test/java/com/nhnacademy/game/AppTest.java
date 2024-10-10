package com.nhnacademy.game;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    //Logger 객체 선언 및 초기화
    private static final Logger logger = Logger.getLogger(AppTest. class.getName());

    @Test
     void testValidBallCreation() {

        Object[][] ballParameters = {
                { 0, 0, 1 },
                { 0, 0, Integer.MAX_VALUE },
                { 100, 100, 100 },
                { 100, -100, 100 },
                { -100, 100, 100 },
                { -100, -100, 100 },
                { Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1, 1 },
                { Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1, 1 },
                { Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1, 1 },
                { Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, 1 }
        };

        // 각 값들로 볼 객체를 생성 시도
        for (int i = 0; i < ballParameters.length; i++) {
            int x = (int) ballParameters[i][0];
            int y = (int) ballParameters[i][1];
            int radius = (int) ballParameters[i][2];

            logger.log(Level.INFO, "Testing ball creation: Ball(x={0}, y={1}, radius={2})",
                    new Object[] { x, y, radius });

            Assertions.assertDoesNotThrow(() -> new Ball23(x, y, radius),
                    "Valid parameters should not throw an exception: Ball" + (i + 1));
        }
    }

    @Test
    void testOutOfBoundsException() {
        // 다음의 값들에 대해 OufOfBoundsException이 발생하는지 확인
        Object[][] ballParameters2 = {
                { Integer.MAX_VALUE, 0, 1 },
                { 0, Integer.MAX_VALUE, 1 },
                { Integer.MIN_VALUE, 0, 1 },
                { 0, Integer.MIN_VALUE, 1 },
                { Integer.MIN_VALUE, Integer.MIN_VALUE, 1 },
                { Integer.MAX_VALUE, Integer.MIN_VALUE, 1 },
                { Integer.MIN_VALUE, Integer.MAX_VALUE, 1 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, 1 },
                { Integer.MAX_VALUE, 0, Integer.MAX_VALUE },
                { 0, Integer.MAX_VALUE, Integer.MAX_VALUE },
                { Integer.MIN_VALUE, 0, Integer.MAX_VALUE },
                { 0, Integer.MIN_VALUE, Integer.MAX_VALUE }
        };

        // 각 값들로 객체를 생성 시도
        for (int i = 0; i < ballParameters2.length; i++) {
            int x = (int) ballParameters2[i][0];
            int y = (int) ballParameters2[i][1];
            int radius = (int) ballParameters2[i][2];

            logger.log(Level.INFO, "Testing ball creation: Ball(x={0}, y={1}, radius={2})",
                    new Object[] { x, y, radius });

            Assertions.assertThrows(OutOfBoundsException.class, () -> new Ball23(x, y, radius),
                    "Excepted OutOfBoundsException: Ball" + (i + 1));
        }
    }

    @Test
    void testInvalidSizeException() {
        Object[][] ballParameters3 = {
                { 0, 0, 0 },
                { 0, 0, -1 },
                { 0, 0, -100 },
                { 0, 0, Integer.MIN_VALUE }
        };

        for (int i = 0; i < ballParameters3.length; i++) {
            int x = (int) ballParameters3[i][0];
            int y = (int) ballParameters3[i][1];
            int radius = (int) ballParameters3[i][2];

            logger.log(Level.INFO, "Testing ball creation: Ball(x={0}, y={1}, radius={2})",
                    new Object[] { x, y, radius });

            Assertions.assertThrows(InvalidSizeException.class, () -> new Ball23(x, y, radius),
                    "Expected InvalidSizeException: Ball" + (i + 1));
        }
    }
}