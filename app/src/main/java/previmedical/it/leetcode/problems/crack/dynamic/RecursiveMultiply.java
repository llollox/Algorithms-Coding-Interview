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
        È possibile dividere il numero piu piccolo per due e moltiplicare il risultato delle chiamate ricorsive per 2.
        In questo modo otteniamo una soluzione O(log(s)), dove s è il minore dei due numeri.
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

    // 31 * 15 = 481 == 30 * 15 + 15 == (31 * (7 * 2)) + 31 = (31 * ((3 * 2) * 2)) + 31 + 31
    private int recursiveMultiplyHelper2(int bigger, int smaller) {
        System.out.println("BIGGER " + bigger + ", smaller: " + smaller);
        if (smaller == 0) {
            return 0;
        }
        else if (smaller == 1) {
            return bigger;
        }

        return 2 * recursiveMultiplyHelper2(bigger, smaller >> 1);
    }
}
