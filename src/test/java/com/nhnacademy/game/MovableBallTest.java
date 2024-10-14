package com.nhnacademy.game;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MovableBallTest {
    static final Random random = new Random();

    @Test
    void testSetterGetter() {
        assertDoesNotThrow(() -> {
            MovableBall ball = new MovableBall(0, 0, 10);

            for (int i = 0; i < 10; i++) {
                int dx = random.nextInt();
                int dy = random.nextInt();

                ball.setDX(dx);
                ball.setDY(dy);

                assertEquals(dx, ball.getDX());
                assertEquals(dy, ball.getDY());
            }
        });
    }

    @RepeatedTest(10)
    void testSetterGetter2() {
        assertDoesNotThrow(() -> {
            MovableBall ball = new MovableBall(0, 0, 10);

            int dx = random.nextInt();
            int dy = random.nextInt();

            ball.setDX(dx);
            ball.setDY(dy);

            assertEquals(dx, ball.getDX());
            assertEquals(dy, ball.getDY());
        });
    }

    @ParameterizedTest
    @MethodSource("moveTestProvider")
    void testMove(int x, int y, int radius, int dx, int dy, int count, int targetX, int targetY) {
        assertDoesNotThrow(() -> {
            MovableBall ball = new MovableBall(x, y, radius);

            ball.setDX(dx);
            ball.setDY(dy);

            for (int i = 0; i < count; i++) {
                ball.move();
            }

            assertEquals(targetX, ball.getX());
            assertEquals(targetY, ball.getY());
        });
    }

    static Stream<Arguments> moveTestProvider() {
        return Stream.of(
                Arguments.of(0, 0, 10, 10, 10, 10, 100, 100),
                Arguments.of(0, 0, 10, 10, -10, 10, 100, -100),
                Arguments.of(0, 0, 10, -10, 10, 10, -100, 100),
                Arguments.of(0, 0, 10, -10, -10, 10, -100, -100));
    }
}
