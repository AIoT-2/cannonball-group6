package com.nhnacademy.game;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class VectorTest {
    Random random = new Random();

    @ParameterizedTest
    @MethodSource("constructionProvider")
    void testConstruction(int magnitude, int angle, int dx, int dy) {

        Vector vector1 = new DisplacementVector(magnitude, angle);
        Vector vector2 = new PositionVector(dx, dy);

        assertEquals(vector1, vector2);
    }

    static Stream<Arguments> constructionProvider() {
        return Stream.of(
                Arguments.of(5, 30, 4, 2));
    }

    @ParameterizedTest
    @MethodSource("addProvider")
    void testAdd(int dx1, int dy1, int dx2, int dy2, int dx, int dy) {
        Vector vector1 = new PositionVector(dx1, dy1);
        Vector vector2 = new PositionVector(dx2, dy2);
        Vector vector3 = new PositionVector(dx, dy);

        vector1.add(vector2);
        assertEquals(vector1, vector3);
    }

    static Stream<Arguments> addProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3, 4, 4, 6));
    }

    @ParameterizedTest
    @MethodSource("subProvider")
    void testSub(int dx1, int dy1, int dx2, int dy2, int dx, int dy) {
        Vector vector1 = new PositionVector(dx1, dy1);
        Vector vector2 = new PositionVector(dx2, dy2);
        Vector vector3 = new PositionVector(dx, dy);

        vector1.sub(vector2);
        assertEquals(vector1, vector3);
    }

    static Stream<Arguments> subProvider() {
        return Stream.of(
                Arguments.of(4, 6, 1, 2, 3, 4));
    }
}
