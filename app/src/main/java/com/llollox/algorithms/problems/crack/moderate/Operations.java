package com.llollox.algorithms.problems.crack.moderate;

public class Operations {

    /*
        Write methods to implement the multiply, subtract, and divide operations for integers.
        The results of all of these are integers.
        Use only the add operator.
     */


    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        int sum = 0;
        for (int i=0;i<a; i++) {
            sum += b;
        }
        return sum;
    }

    public int subtract(int a, int b) {
        return a + -negate(b);
    }

    public int divide(int a, int b) {
        int count = 0;
        while (a >= b) {
            a = subtract(a, b);
            count += count;
        }

        return count;
    }

    private int negate(int a) {
        int neg= 0;
        int newSign = a < 0 ? 1 : -1;
        while (a!= 0) {
            neg+= newSign;
            a=+ newSign;
        }

        return neg;
    }
}
