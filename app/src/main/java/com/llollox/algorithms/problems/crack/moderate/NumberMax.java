package com.llollox.algorithms.problems.crack.moderate;

public class NumberMax {

    /*
        Number Max: Write a method that finds the maximum of two numbers.
        You should not use if-else or any other comparison operator.

        Solution 1.

     */


    public int max(int a, int b) {

        int signA = sign(a); // a >= 0 ? 1 : 0
        int signB = sign(b); // b >= 0 ? 1 : 0
        int signC = sign(a - b); // Segno differenza

        int signOfAB = signA ^ signB; // When a and b have different sign, overflow can occur
        int signOfC = flip(signOfAB); // when both have the same sign.

        int k = signOfAB * signA + signOfC * signC;
        int q = flip(k);

        return k * a + q * b;
    }

    private int sign(int diff) {
        return flip((diff >> 31) & 0x1);
    }

    private int flip(int n) {
        return 1 ^ n;
    }
}
