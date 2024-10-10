package com.nhnacademy.game;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BallTest {
    @ParameterizedTest
    @MethodSource("legalConstructionProvider")
    void testConstruction(int x, int y, int radius) {
        assertDoesNotThrow(() -> {
            new Ball(x, y, radius);
        });
    }

    @ParameterizedTest
    @MethodSource("invalidSizeProvider")
    void testInvalidSizeException(int x, int y, int radius) {
        assertThrowsExactly(InvalidSizeException.class, () -> {
            new Ball(x, y, radius);
        });
    }

    @ParameterizedTest
    @MethodSource("outOfBoundsProvider")
    void testOutOfBoundsException(int x, int y, int radius) {
        assertThrowsExactly(OutOfBoundsException.class, () -> {
            new Ball(x, y, radius);
        });
    }

    static Stream<Arguments> legalConstructionProvider() {
        return Stream.of(
                Arguments.of(0, 0, 1),
                Arguments.of(0, 0, Integer.MAX_VALUE),
                Arguments.of(100, 100, 100),
                Arguments.of(100, -100, 100),
                Arguments.of(-100, 100, 100),
                Arguments.of(-100, -100, 100),
                Arguments.of(Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1, 1),
                Arguments.of(Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1, 1),
                Arguments.of(Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1, 1),
                Arguments.of(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, 1));
    }

    static Stream<Arguments> outOfBoundsProvider() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE, 0, 1),
                Arguments.of(0, Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, 0, 1),
                Arguments.of(0, Integer.MIN_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, Integer.MIN_VALUE, 1),
                Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MAX_VALUE, 0, Integer.MAX_VALUE),
                Arguments.of(0, Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE, 0, Integer.MAX_VALUE),
                Arguments.of(0, Integer.MIN_VALUE, Integer.MAX_VALUE),
                Arguments.of(Integer.MAX_VALUE - 100, 0, 101),
                Arguments.of(0, Integer.MAX_VALUE - 100, 101),
                Arguments.of(-101, 0, Integer.MAX_VALUE - 99),
                Arguments.of(-101, 0, Integer.MAX_VALUE),
                Arguments.of(101, 0, Integer.MAX_VALUE - 100),
                Arguments.of(101, 0, Integer.MAX_VALUE));
    }

    static Stream<Arguments> invalidSizeProvider() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 0, -1),
                Arguments.of(0, 0, -100),
                Arguments.of(0, 0, Integer.MIN_VALUE + 100),
                Arguments.of(0, 0, Integer.MIN_VALUE));
    }
} 