package com.llollox.algorithms.problems.crack.moderate;

import java.util.HashSet;
import java.util.Set;

public class SumSwap {

    /*

    Given two arrays of integers, find a pair of values (one value from each array)
    that you can swap to give the two arrays the same sum.

    INPUT: A1 = [4, 1, 2, 1, 1, 2] / A2 = [3, 6, 3, 3]
    OUTPUT: [1, 3]

    diff = 2

    1 1 1 1 = 4
    2 2 2 = 6

    2 - diff/2

    Solution. Unsorted
    - Calculate the sum of both arrays O(n) O(m)
    - Calculate the difference O(1)
    - If difference is odd return because it is impossibile. O(1)
    - Add all elements of A2 into a set. O(m)
    - For each element x in A1, search for x - difference into the set. O(n)

    Time O(n + m) Space O(m)
     */

    public int[] sumSwap(int[] a1, int[] a2) {
        if (a1 == null || a1.length == 0 || a2 == null || a2.length == 0) {
            return null;
        }

        int sumA1 = this.sum(a1);
        int sumA2 = this.sum(a2);
        int diff = sumA1 - sumA2;

        if (diff % 2 == 1) {
            return null; // It is not even
        }

        Set<Integer> set = new HashSet<>();
        for (int y : a2) {
            set.add(y);
        }

        for (int x : a1) {
            int target = x - (diff / 2);
            if (set.contains(target)) {
                return new int[] {x, target};
            }
        }

        return null;
    }


    /*
        INPUT: A1 = [1, 1, 1, 2, 2, 4]
               A2 = [3, 3, 3, 6]
        OUTPUT: [1, 3]
        Solution sorted.
        Start with two indices at the beginning of both arrays.
        If the difference must increase i move forward the first index,
        otherwise I move forward the other index.

        Time O(n + m)  Space O(1)
     */
    public int[] sumSwapSorted(int[] a1, int[] a2) {
        if (a1 == null || a1.length == 0 || a2 == null || a2.length == 0) {
            return null;
        }

        int sumA1 = this.sum(a1); // O(n)
        int sumA2 = this.sum(a2); // O(m)
        int diff = sumA1 - sumA2;

        if (diff % 2 == 1) {
            return null; // It is not even
        }

        int index1 = 0;
        int index2 = 0;

        int target = diff / 2;

        while (index1 < a1.length && index2 < a2.length) { // O(n + m)
            int currentDiff = a1[index1] - a2[index2];

            if (currentDiff == target) {
                return new int[] {a1[index1], a2[index2]};
            }
            else if (currentDiff < target) {
                index1 += 1;
            }
            else {
                index2 += 1;
            }
        }

        return null;
    }

    private int sum(int[] array) {
        int sum = 0;
        for(int value : array) {
            sum += value;
        }
        return sum;
    }
}
