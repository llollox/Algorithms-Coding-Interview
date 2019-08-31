package com.llollox.algorithms.problems.crack.moderate;

public class SwapNumbers {

    /*
        Write a function to swap a number in place (that is, without temporary vari­ ables).

        a = 1
        b = 2

        a = a + b = 3
        b = a - b = 1
        a = a - b = 2

     */

    public static class Swap {
        public int a;
        public int b;

        public Swap(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public Swap swapNumbers(Swap swap) {
        int a = swap.a;
        int b = swap.b;
        a = a + b;
        b = a - b;
        a = a - b;

        swap.a = a;
        swap.b = b;
        return swap;
    }
}
