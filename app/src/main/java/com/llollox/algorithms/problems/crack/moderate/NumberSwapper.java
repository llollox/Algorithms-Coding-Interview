package com.llollox.algorithms.problems.crack.moderate;

public class NumberSwapper {

    /*
        Write a function to swap a number in place (that is, without temporary variables).
     */

    // a = 5 b = 7
    public void numberSwapper(int a, int b) {
        a = a + b; // a = 12
        b = a - b; // b = 12 - 7 = 5
        a = a - b; // a = 12 - 5 = 7
    }
}


