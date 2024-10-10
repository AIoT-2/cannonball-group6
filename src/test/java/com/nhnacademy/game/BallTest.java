package com.nhnacademy.game;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BallTest {
    static final Random random = new Random();
    static final Logger logger = LoggerFactory.getLogger(BallTest.class);

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

    @RepeatedTest(100)
    void testRandomConsturction(RepetitionInfo info) {
        int radius = random.nextInt(Integer.MAX_VALUE);
        int x = (random.nextBoolean() ? 1 : -1) * random.nextInt(Integer.MAX_VALUE - radius);
        int y = (random.nextBoolean() ? 1 : -1) * random.nextInt(Integer.MAX_VALUE - radius);

        logger.trace("{}/{} : new Ball({},{},{})",
                info.getCurrentRepetition(), info.getTotalRepetitions(), x, y, radius);
        assertDoesNotThrow(() -> {
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

    static Stream<Arguments> invalidSizeProvider() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 0, -1),
                Arguments.of(0, 0, -100),
                Arguments.of(0, 0, Integer.MIN_VALUE + 100),
                Arguments.of(0, 0, Integer.MIN_VALUE));
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
}
