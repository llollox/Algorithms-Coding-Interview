package com.llollox.algorithms.problems.easy;

import android.util.Log;

public class N35_SearchInsertPosition {


    /*
        Given a sorted array and a target value, return the index if the target is found.
        If not, return the index where it would be if it were inserted in order.

        You may assume no duplicates in the array.

        Example 1:

        Input: [1,3,5,6], 5
        Output: 2
        Example 2:

        Input: [1,3,5,6], 2
        Output: 1
        Example 3:

        Input: [1,3,5,6], 7
        Output: 4
        Example 4:

        Input: [1,3,5,6], 0
        Output: 0
     */

    public int searchInputPosition(int[] array, int target) {

        int startIndex = 0;
        int endIndex = array.length;

        while (startIndex < endIndex) {

            int midIndex = startIndex + ((endIndex - startIndex) / 2);
            int midValue = array[midIndex];

            if (target == midValue) {
                return midIndex;
            }
            else if (target < midValue) { // cerca nella meta di sinistra
                endIndex = midIndex;
            }
            else { // cerca nella meta di destra
                startIndex = midIndex + 1;
            }
        }

        return startIndex;
    }


    public void test() {

        int[] array = {1,3,5,6};

        int position1 = this.searchInputPosition(array, 5);
        Log.w("TEST", "{1,3,5,6}, 5 -> Position: " + position1);

        int position2 = this.searchInputPosition(array, 2);
        Log.w("TEST", "{1,3,5,6}, 2 -> Position: " + position2);

        int position3 = this.searchInputPosition(array, 7);
        Log.w("TEST", "{1,3,5,6}, 7 -> Position: " + position3);

        int position4 = this.searchInputPosition(array, 0);
        Log.w("TEST", "{1,3,5,6}, 0 -> Position: " + position4);
    }
}
