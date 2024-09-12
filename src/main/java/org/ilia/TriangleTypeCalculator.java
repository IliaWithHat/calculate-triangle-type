package org.ilia;

import java.math.BigInteger;

import static org.ilia.TriangleType.*;

public class TriangleTypeCalculator {

    public TriangleType calculateTriangleType(BigInteger a, BigInteger b, BigInteger c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Arguments can't be null");
        }
        if (!a.add(b).add(c).equals(new BigInteger("180"))) {
            throw new IllegalArgumentException("Sum of angles must be 180 degrees");
        }

        if (a.compareTo(new BigInteger("60")) == 0 &&
                b.compareTo(new BigInteger("60")) == 0 &&
                c.compareTo(new BigInteger("60")) == 0) {
            return EQUILATERAL;
        }

        if (a.equals(b) || b.equals(c) || a.equals(c)) {
            return ISOSCELES;
        }

        if (a.equals(new BigInteger("90")) ||
                b.equals(new BigInteger("90")) ||
                c.equals(new BigInteger("90"))) {
            return RIGHT;
        }

        if (a.compareTo(new BigInteger("90")) > 0 ||
                b.compareTo(new BigInteger("90")) > 0 ||
                c.compareTo(new BigInteger("90")) > 0) {
            return OBTUSE;
        }

        return ACUTE;
    }
}
