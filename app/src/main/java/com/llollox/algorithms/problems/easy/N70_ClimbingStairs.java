package com.llollox.algorithms.problems.easy;

public class N70_ClimbingStairs {

    /*
        You are climbing a stair case. It takes n steps to reach to the top.
        Each time you can either climb 1 or 2 steps.
        In how many distinct ways can you climb to the top?

        Note: Given n will be a positive integer.

        Example 1:

        Input: 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps
        Example 2:

        Input: 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step

        1. 1 step = 1
        2. 1. + 1 step / 0. + 2 steps = 2
        3. 1. + 2 steps / 2. + 1 step == a[1] + a[2] = 3
        4. a[2](2) + a[3] = 5


        4. 1s 1s 1s 1s = 5
           1s 1s 2s
           1s 2s 1s
           2s 1s 1s
           2s 2s

        5. 1s 1s 1s 1s 1s = 8
           1s 1s 1s 2s
           1s 1s 2s 1s
           1s 2s 1s 1s
           2s 1s 1s 1s
           2s 2s 1s
           2s 1s 2s
           1s 2s 2s
     */

    /*
        At every single step I can choose if I want to move forward by one single step or two.
        So I can have an array[n] in which:
          array[i] = # of steps to reach i
          array[i] = array[i - 1] + array[i - 2]
     */

    public int climbStairs(int n) {

        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }

        int prevPrev = 1;
        int prev = 2;

        for (int i=3; i<=n; i++) {
            int value = prev + prevPrev;
            prevPrev = prev;
            prev = value;
        }

        return prev;
    }
}
