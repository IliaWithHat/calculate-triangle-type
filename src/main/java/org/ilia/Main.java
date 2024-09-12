package org.ilia;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        TriangleTypeCalculator triangleTypeCalculator = new TriangleTypeCalculator();
        BigInteger a = new BigInteger("30");
        BigInteger b = new BigInteger("50");
        BigInteger c = new BigInteger("100");

        System.out.println(triangleTypeCalculator.calculateTriangleType(a, b, c));
    }
}
