package com.llollox.algorithms.problems.easy;

import android.util.Log;

public class N905_SortArrayByParity {

    /*
        Given an array A of non-negative integers,
        return an array consisting of all the even elements of A,
        followed by all the odd elements of A.

        You may return any answer array that satisfies this condition.

        Example 1:
        Input: [3,1,2,4]
        Output: [2,4,3,1]
        The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

        Note:

        1 <= A.length <= 5000
        0 <= A[i] <= 5000
     */

    // Scorro l'array fintanto che i < max,
    // se a[i] e' pari => vado avanti
    // se a[i] e' dispari => lo copio in fondo e riduco il max di uno

    public int[] sortArrayByParity(int[] A) {

        if (A.length <= 1) {
            return A;
        }

        int max = A.length - 1;
        int i=0;

        while (i < max) {
            if (A[i] % 2 == 1) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
                max--;
            }
            else {
                i++;
            }
        }

        return A;
    }

    public void test() {
        int[] array = {3,1,2,4};
        int[] output = this.sortArrayByParity(array);
        Log.w("TEST", "" + output);
    }

}
