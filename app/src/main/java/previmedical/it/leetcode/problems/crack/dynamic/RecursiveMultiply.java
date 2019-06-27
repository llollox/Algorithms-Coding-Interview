package previmedical.it.leetcode.problems.crack.dynamic;

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
}
