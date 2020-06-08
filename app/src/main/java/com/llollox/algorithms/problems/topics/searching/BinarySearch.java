package com.llollox.algorithms.problems.topics.searching;

public class BinarySearch {

    int binarySearch(int[] array, int x) {
        if (array == null || array.length == 0) return -1;
        return bs(array, x, 0, array.length);
    }

    private int bs(int[] array, int x, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];

        if (midValue == x) {
            return midIndex;
        }
        else if (x < midValue) {
            return bs(array, x, start, midIndex);
        }
        else {
            return bs(array, x, midIndex + 1, end);
        }
    }
}
