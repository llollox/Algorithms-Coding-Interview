package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N633_SumOfSquareNumbers {

    /*

        Given a non-negative integer c,
        your task is to decide whether there're two integers a and b such that a2 + b2 = c.

        Example 1:
        Input: 5
        Output: True
        Explanation: 1 * 1 + 2 * 2 = 5

        Example 2:
        Input: 3
        Output: False

     */

    /*

        Solution.

        In order to find both a and b, I can understand that
        b^2 = c - a^2
        Of course each a,b must be lower than sqrt(c).
        Therefore, I can start from 0 to sqrt(c) and trying if
        b = sqrt(c - a*a) is a perfect square.

        In order to do this, I can compute b = Math.sqrt(c - a*a);
        and then check if b % 1 == 0 to see if it an integer (perfect square) or not.




     */

    public boolean judgeSquareSum(int c) {

        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b % 1 == 0) {
                return true;
            }
        }
        return false;
    }

    public void test() {
//        int input = 2147483646;
//        Log.w("TEST", "is judgeSquareSum(2147483646): " + this.judgeSquareSum(input) + " ==? false");

        int input = 5;
        Log.w("TEST", "is judgeSquareSum(5): " + this.judgeSquareSum(input) + " ==? true");

    }
}
