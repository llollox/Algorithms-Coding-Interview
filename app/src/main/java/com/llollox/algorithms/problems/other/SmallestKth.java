package com.llollox.algorithms.problems.other;

public class SmallestKth {

    // Design an algorithm to find the smallest K-th element in an array.
    public int smallestKth(int[] array, int k) {
        if (array == null
                || array.length == 0
                || k <= 0
                || k > array.length) {
            return -1;
        }

        return smallestKth(array, k, 0, array.length -1);
    }


    /*
        start = 0
        end = 2
        k = 3

        a = [1, 2, 4, 6, 18, 7]
        pvt = 2
        ne = 3

     */
    private int smallestKth(int[] array, int k, int start, int end) {
        if (start == end) {
            return array[start];
        }

        int pivotIndex = this.partition(array, start, end);
        int numElements = (pivotIndex - start) + 1;

        if (k == numElements) {
            return array[pivotIndex];
        }
        else if (k > numElements) {
            return smallestKth(array, k - numElements, pivotIndex + 1, end);
        }
        else {
            return smallestKth(array, k, start, pivotIndex - 1);
        }
    }


    // Return the pivot index
    private int partition(int[] array, int start, int end) {
        if (array == null                   // array null
                || start < 0                // start out of bounds
                || end >= array.length      // end out of bounds
                || start > end              // start greater than end
                || (end - start) + 1 < 2) { // num elements less than 2
            return -1;
        }

        int pivot = array[end];
        int i=start;
        int j=start;

        while (j < end) {
            int value = array[j];

            if (value < pivot) {
                swap(array, i, j);
                i = i + 1;
            }

            j = j + 1;
        }

        swap(array, i, end);

        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
