package com.llollox.algorithms.problems.topics.array;

public class BinarySearch {

    // Given an ordered array. Return if an element is present or not.

    public boolean binarySearch(int[] array, int value) {
        if (array == null || array.length == 0) {
            return false;
        }

        int start = 0;
        int end = array.length;

        while (start < end) {
            int mid = (end + start) / 2;
            if (array[mid] == value) {
                return true;
            }
            else if (value < array[mid]) {
                end = mid;
            }
            else if (value > array[mid]) {
                start = mid + 1;
            }
        }

        return false;
    }
}
