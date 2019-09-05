package com.llollox.algorithms.problems.crack.dynamic;

public class MagicIndex {

    /*
        A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[i] == i.
        Given a sorted array of distinct integers, write a method to find a magic index,
        if one exists, in array A.

        FOLLOW UP
        What if the values are not distinct?
     */


    // Brute Force O(n)
    public int magicIndexBruteForce(int[] a) {
        if (a == null) {
            return -1;
        }

        for (int i=0; i<a.length; i++) {
            if (a[i] == i) {
                return i;
            }
        }

        return -1;
    }


    public int magicIndexBinarySearch(int[] a) {
        if (a == null) {
            return -1;
        }

        return this.magicIndexBinarySearch(a, 0, a.length);
    }

    private int magicIndexBinarySearch(int[] a, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) /2;

        if (a[mid] == mid) {
            return mid;
        }
        else if (a[mid] < mid) { // posso rimuovere tutti i minori
            return this.magicIndexBinarySearch(a, mid + 1, end);
        }
        else { // posso rimuovere tutti i maggiori
            return this.magicIndexBinarySearch(a, start, mid - 1);
        }
    }

    public int magicIndexBinarySearchIterative(int[] a) {

        if (a == null) {
            return -1;
        }

        int start = 0;
        int end = a.length;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (a[mid] == mid) {
                return mid;
            }
            else if (a[mid] < mid) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int magicIndexDuplicates(int[] a) {

        if (a == null) {
            return -1;
        }

        return magicIndexDuplicates(a, 0, a.length - 1);
    }

    // [1, 1, 1, 4, 6, 8]
    public int magicIndexDuplicates(int[] a, int start, int end) {

        if (start > end) {
            return -1; // FAILURE
        }

        int midIndex = (start + end) / 2;
        int midValue = a[midIndex];

        if (midValue == midIndex) {
            return midIndex; // SUCCESS
        }

        int valueLeft = magicIndexDuplicates(a, start, Math.min(midValue, midIndex - 1));
        if (valueLeft >= 0) {
            return valueLeft;
        }

        return magicIndexDuplicates(a, Math.max(midValue, midIndex + 1), end);
    }
}
