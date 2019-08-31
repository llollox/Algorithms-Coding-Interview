package com.llollox.algorithms.problems.easy;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class N1018_BinaryPrefixDivisibleBy5 {

    /*
        Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i]
        interpreted as a binary number (from most-significant-bit to least-significant-bit.)

        Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.

        Example 1:

        Input: [0,1,1]
        Output: [true,false,false]
        Explanation:
        The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
        Only the first number is divisible by 5, so answer[0] is true.

        Example 2:
        Input: [1,1,1]
        Output: [false,false,false]

        Example 3:
        Input: [0,1,1,1,1,1]
        Output: [true,false,false,false,true,false]

        Example 4:
        Input: [1,1,1,0,1]
        Output: [false,false,false,false,false]


        Note:

        1 <= A.length <= 30000
        A[i] is 0 or 1
     */


    public List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> result = new ArrayList<Boolean>();
        int prev = 0;

        for (int a : A) {
            int num = prev * 2 + a;
            result.add(num % 5 == 0);
            prev = num % 5;
        }
        return result;
    }


    public void test() {

//        int[] array1 = {0,1,1};
//        Log.w("TEST", "0,1,1 -> " + prefixesDivBy5(array1).toString());
//
//        int[] array2 = {1,1,1};
//        Log.w("TEST", "1,1,1 -> " + prefixesDivBy5(array2).toString());
//
//        int[] array3 = {0,1,1,1,1,1};
//        Log.w("TEST", "0,1,1,1,1,1 -> " + prefixesDivBy5(array3).toString());
//
//        int[] array4 = {1,1,1,0,1};
//        Log.w("TEST", "1,1,1,0,1 -> " + prefixesDivBy5(array4).toString());

        int[] array5 = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        Log.w("TEST", "1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1 -> " + prefixesDivBy5(array5).toString());
    }

}
