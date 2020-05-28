package com.llollox.algorithms.problems.crack.sorting;

public class BinarySearchRotated {

    /*
        Given a sorted array of n integers that has been rotated an unknown number of times,
        write code to find an element in the array.

        You may assume that the array was originally sorted in increasing order.
        INPUT
            ARRAY = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
            VALUE = 5
        OUTPUT:
            8 (the index of 5 in the array)
     */

    public int binarySearchRotated(int[] array, int n) {
        if (array == null || array.length == 0) {
            return -1;
        }

        return binarySearchHelper(array, n, 0, array.length);
    }

    private int binarySearchHelper(int[] array, int n, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == n) {
            return midIndex;
        }

        boolean roundFound = array[start] < array[end - 1];
        int leftSearch = -1;
        int rightSearch = -1;

        if (midValue > n) {
            leftSearch = binarySearchHelper(array, n, start, midIndex);
            if (!roundFound) {
                rightSearch = binarySearchHelper(array, n, midIndex + 1, end);
            }
        }
        else {
            rightSearch = binarySearchHelper(array, n, midIndex  + 1, end);
            if (!roundFound) {
                leftSearch = binarySearchHelper(array, n, start, midIndex);
            }
        }

        return Math.max(leftSearch, rightSearch);
    }
}
