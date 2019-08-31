package com.llollox.algorithms.problems.crack.dynamic;

public class TripleSteps {

    /*
        A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
        Implement a method to count how many possible ways the child can run up the stairs.
     */


    public int tripleStepRecursive(int n) {

        if (n <= 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 1 + tripleStepRecursive(n - 1);
        }
        else if (n == 3) {
            return 1 + tripleStepRecursive(n - 2) + tripleStepRecursive(n - 1);
        }
        else {
            return tripleStepRecursive(n - 1) + tripleStepRecursive(n - 2) + tripleStepRecursive(n - 3);
        }
    }

    public int tripleStepMemoization(int n) {
        int[] cache = new int[n+1];
        return this.tripleStepMemoization(n, cache);
    }

    public int tripleStepMemoization(int n, int[] cache) {

        if (n <= 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        else if (n <= 3) {
            return 4;
        }
        else if (cache[n] > 0) {
            return cache[n];
        }
        else {
            return tripleStepRecursive(n - 1) + tripleStepRecursive(n - 2) + tripleStepRecursive(n - 3);
        }
    }

    public int tripleStepDynamicProgramming(int n) {

        if (n <= 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }

        int p = 4;
        int pp = 2;
        int ppp = 1;

        for (int i=0; i < n - 3; i++) {
            int count = p + pp + ppp;
            ppp = pp;
            pp = p;
            p = count;
        }

        return p;
    }


}
