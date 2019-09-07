package com.llollox.algorithms.problems.crack.hard;

public class AddWithoutPlus {

    /*
        Write a function that adds two numbers. You should not use + or any arithmetic operators.
     */

    public int addWithoutPlus(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b; // Sum without carring
        int carry = (a & b) << 1;

        return addWithoutPlus(sum, carry);
    }
}
