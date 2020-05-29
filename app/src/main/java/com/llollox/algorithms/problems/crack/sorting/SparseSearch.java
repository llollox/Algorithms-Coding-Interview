package com.llollox.algorithms.problems.crack.sorting;

public class SparseSearch {

    /*
        Given a sorted array of strings that is interspersed with empty strings,
        write a method to find the location of a given string.

        Input:
            {"at", "", "", "", “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”}
            “ball”
        Output: 4
     */

    public int sparseSearch(String[] array, String s) {
        if (array == null || array.length == 0 || s == null) {
            return -1;
        }
        return sparseSearchBS(array, s, 0, array.length);
    }

    private int sparseSearchBS(String[] array, String s, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        String midValue = array[midIndex];

        if (midValue.equals("")) {
            midIndex = findIndexOfNearestString(array, midIndex, start, end);
            if (midIndex == -1) {
                return -1;
            }
            midValue = array[midIndex];
        }

        int comparison = midValue.compareTo(s);
        if (comparison == 0) {
            return midIndex;
        }
        else if (comparison > 0) {
            return sparseSearchBS(array, s, start, midIndex); // s < mid go to left
        }
        else {
            return sparseSearchBS(array, s, midIndex + 1, end);// s > mid go to right
        }
    }

    // Time O(N * M) Space O(1)
    private int findIndexOfNearestString(String[] array, int mid, int start, int end) {
        int left = mid - 1;
        int right = mid + 1;

        while (left >= start || right < end) {
            if (left >= start && !array[left].equals("")) {
                return left;
            }
            if (right < end && !array[right].equals("")) {
                return right;
            }

            left--;
            right++;
        }

        return -1;
    }
}
