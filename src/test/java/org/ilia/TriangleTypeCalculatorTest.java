package org.ilia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTypeCalculatorTest {

    TriangleTypeCalculator triangleTypeCalculator = new TriangleTypeCalculator();

    @ParameterizedTest
    @MethodSource("provideNullAnglesForAngleAreNullTest")
    void angleAreNullTest(BigInteger a, BigInteger b, BigInteger c) {
        assertThrows(IllegalArgumentException.class, () -> triangleTypeCalculator.calculateTriangleType(a, b, c));
    }

    private static Stream<Arguments> provideNullAnglesForAngleAreNullTest() {
        return Stream.of(
                Arguments.of(null, new BigInteger("50"), new BigInteger("50")),
                Arguments.of(new BigInteger("50"), null, new BigInteger("50")),
                Arguments.of(new BigInteger("50"), new BigInteger("50"), null)
        );
    }

    @Test
    void sumGraterThan180Test() {
        BigInteger a = new BigInteger("40");
        BigInteger b = new BigInteger("60");
        BigInteger c = new BigInteger("180");
        assertThrows(IllegalArgumentException.class, () -> triangleTypeCalculator.calculateTriangleType(a, b, c));
    }

    @Test
    void equilateralTriangleTest() {
        BigInteger a = new BigInteger("60");
        BigInteger b = new BigInteger("60");
        BigInteger c = new BigInteger("60");
        assertEquals(TriangleType.EQUILATERAL, triangleTypeCalculator.calculateTriangleType(a, b, c));
    }

    @ParameterizedTest
    @MethodSource("provideAnglesForIsoscelesTriangleTest")
    void isoscelesTriangleTest(BigInteger a, BigInteger b, BigInteger c) {
        assertEquals(TriangleType.ISOSCELES, triangleTypeCalculator.calculateTriangleType(a, b, c));
    }

    private static Stream<Arguments> provideAnglesForIsoscelesTriangleTest() {
        return Stream.of(
                Arguments.of(new BigInteger("50"), new BigInteger("50"), new BigInteger("80")),
                Arguments.of(new BigInteger("80"), new BigInteger("50"), new BigInteger("50")),
                Arguments.of(new BigInteger("50"), new BigInteger("80"), new BigInteger("50"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideRightTriangleTest")
    void rightTriangleTest(BigInteger a, BigInteger b, BigInteger c) {
        assertEquals(TriangleType.RIGHT, triangleTypeCalculator.calculateTriangleType(a, b, c));
    }

    private static Stream<Arguments> provideRightTriangleTest() {
        return Stream.of(
                Arguments.of(new BigInteger("30"), new BigInteger("60"), new BigInteger("90")),
                Arguments.of(new BigInteger("30"), new BigInteger("90"), new BigInteger("60")),
                Arguments.of(new BigInteger("90"), new BigInteger("60"), new BigInteger("30"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideObtuseTriangleTest")
    void obtuseTriangleTest(BigInteger a, BigInteger b, BigInteger c) {
        assertEquals(TriangleType.OBTUSE, triangleTypeCalculator.calculateTriangleType(a, b, c));
    }

    private static Stream<Arguments> provideObtuseTriangleTest() {
        return Stream.of(
                Arguments.of(new BigInteger("20"), new BigInteger("60"), new BigInteger("100")),
                Arguments.of(new BigInteger("20"), new BigInteger("100"), new BigInteger("60")),
                Arguments.of(new BigInteger("100"), new BigInteger("60"), new BigInteger("20"))
        );
    }

    @Test
    void acuteTriangleTest() {
        BigInteger a = new BigInteger("40");
        BigInteger b = new BigInteger("60");
        BigInteger c = new BigInteger("80");
        assertEquals(TriangleType.ACUTE, triangleTypeCalculator.calculateTriangleType(a, b, c));
    }
}
