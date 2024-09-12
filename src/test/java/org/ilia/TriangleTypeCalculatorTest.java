package org.ilia;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTypeCalculatorTest {

    TriangleTypeCalculator triangleTypeCalculator = new TriangleTypeCalculator();

    @Test
    void angleAreNullTest() {
        BigInteger a = null;
        BigInteger b = null;
        BigInteger c = null;
        assertThrows(IllegalArgumentException.class, () -> triangleTypeCalculator.calculateTriangleType(a, b, c));
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

    @Test
    void isoscelesTriangleTest() {
        BigInteger a = new BigInteger("50");
        BigInteger b = new BigInteger("50");
        BigInteger c = new BigInteger("80");
        assertEquals(TriangleType.ISOSCELES, triangleTypeCalculator.calculateTriangleType(a, b, c));
    }

    @Test
    void rightTriangleTest() {
        BigInteger a = new BigInteger("30");
        BigInteger b = new BigInteger("60");
        BigInteger c = new BigInteger("90");
        assertEquals(TriangleType.RIGHT, triangleTypeCalculator.calculateTriangleType(a, b, c));
    }

    @Test
    void obtuseTriangleTest() {
        BigInteger a = new BigInteger("20");
        BigInteger b = new BigInteger("60");
        BigInteger c = new BigInteger("100");
        assertEquals(TriangleType.OBTUSE, triangleTypeCalculator.calculateTriangleType(a, b, c));
    }

    @Test
    void acuteTriangleTest() {
        BigInteger a = new BigInteger("40");
        BigInteger b = new BigInteger("60");
        BigInteger c = new BigInteger("80");
        assertEquals(TriangleType.ACUTE, triangleTypeCalculator.calculateTriangleType(a, b, c));
    }
}
