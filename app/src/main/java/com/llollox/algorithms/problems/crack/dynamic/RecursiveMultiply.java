package com.llollox.algorithms.problems.crack.dynamic;

public class RecursiveMultiply {

    /*
        Write a recursive function to multiply two positive integers without using the * operator (or / operator).
        You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
     */

    /*
        Solution 1.
        Dati n, m. Dove n < m.
        Sommo n volte m ricorsivamente.
        O(n), dove n < m.
     */
    public int recursiveMultiply(int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (n > m) {
            return recursiveMultiplyHelper(n, m);
        }
        else {
            return recursiveMultiplyHelper(m, n);
        }
    }

    private int recursiveMultiplyHelper(int bigger, int smaller) {
        if (smaller == 0) {
            return 0;
        }

        return bigger + recursiveMultiplyHelper(bigger, smaller - 1);
    }

    /*
        Solution 2.
        Since 7 * 8 = 2 * (7 * 4).

        It is possible to double the result of the recursive call and divide by two the smaller number.
        In this way we obtain a log(n) complexity algorithm.
        Whenever the smaller number is odd, we simply add the bigger number once.

        Time O(log(n)) Space O(log(n))
     */
    public int recursiveMultiply2(int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (n > m) {
            return recursiveMultiplyHelper2(n, m);
        }
        else {
            return recursiveMultiplyHelper2(m, n);
        }
    }

    private int recursiveMultiplyHelper2(int bigger, int smaller) {
        if (smaller == 0) {
            return 0;
        }
        else if (smaller == 1) {
            return bigger;
        }

        if (smaller % 2 == 1) {
            return bigger + 2 * recursiveMultiplyHelper2(bigger, smaller >> 1);
        }
        else {
            return 2 * recursiveMultiplyHelper2(bigger, smaller >> 1);
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int recursiveMultiplyReImplemented(int a, int b) {
        if (isPower2(a)) {
            return b << log(a);
        }

        if (isPower2(b)) {
            return a << log(b);
        }

        int min = a > b ? b : a;
        int max = a > b ? a : b;

        int result = 0;
        while (min > 0) {
            if (isPower2(min)) {
                return result + (max << log(min));
            }

            result += max;
            min--;
        }

        return result;
    }

    private int log(int value) {
        int count = 0;
        while (value > 1) {
            value >>= 1;
            count++;
        }
        return count;
    }

    private boolean isPower2(int value) {
        return (value & (value - 1)) == 0;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Time O(log n) Space O(log n)
    public int recursiveMultiplyReImplementedOptimal(int a, int b) {
        int smaller = a > b ? b : a;
        int bigger = a > b ? a : b;
        return multiplyHelper(smaller, bigger);
    }

    private int multiplyHelper(int smaller, int bigger) {
        switch (smaller) {
            case 0: return 0;
            case 1: return bigger;
            default:
                int result = multiplyHelper(smaller >> 1, bigger) << 1;
                return smaller % 2 == 0 ? result : result + bigger;
        }
    }
}
