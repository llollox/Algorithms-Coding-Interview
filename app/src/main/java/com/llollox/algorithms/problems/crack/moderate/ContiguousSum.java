package com.llollox.algorithms.problems.crack.moderate;

public class ContiguousSum {

    /*

        You are given an array of integers (both positive and negative).
        Find the contiguous sequence with the largest sum. Return the sum.

        EXAMPLE
        Input: 2, -8, 3, -2, 4, -10
        Output:5 (i.e•, {3, -2, 4})
     */

    public int getMaximumSum(int[] array) {
        int sum = 0;
        int max = 0;

        for (int n: array) {
            sum += n;
            if (sum > max) {
                max = sum;
            }
            else if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
