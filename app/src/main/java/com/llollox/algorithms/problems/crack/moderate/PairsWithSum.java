package com.llollox.algorithms.problems.crack.moderate;

import java.util.HashSet;

public class PairsWithSum {


    /*
        Design an algorithm to find all pairs of
        integers within an array which sum to a specified value.

        Algorithm Time O(n)   Space O(n)
        Create a hash set that contains the searched values.
        For each element x into the array:
        If x is contained into the set, return the pair
        Add into the set sum - x, the searched value for x
     */

    public int[] pairsWithSum(int[] array, int sum) {
        if (array == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            int target = sum - value;
            if (set.contains(target)) {
                return new int[] {value, target};
            }
            else {
                set.add(target);
            }
        }

        return null;
    }


    /*
        If the array is sorted I can take advantage by using to indices,
        one at the beginning of the array (the lowest value),
        and another one at the end of the array (the highest value).
        Compare the sum of both values with the target:
            - if it is equal, return values
            - if it is greater, move the greater index to left
            - if it is smaller, move the lower index to right

        Time O(n) Space O(1)
     */

    public int[] pairsWithSumSortedArray(int[] array, int sum) {
        if (array == null) {
            return null;
        }

        int index1 = 0;
        int index2 = array.length - 1;

        while (index1 < index2) {
            int summed = array[index1] + array[index2];
            if (summed == sum) {
                return new int[] {array[index1], array[index2]};
            }
            else if (summed < sum) {
                index1 += 1;// Increase
            }
            else {
                index2 -= 1; // Decrease
            }
        }

        return null;
    }


}
