package com.llollox.algorithms.problems.topics.sorting;

public class QuickSort {

    int[] quickSort(int[] array) {
        if (array == null || array.length == 0) return null;
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotValue = array[end];
        int partitionIndex = -1;
        for (int i=0; i<end; i++) {
            if (array[i] <= pivotValue) {
                partitionIndex++;
                swap(array, i, partitionIndex);
            }
        }
        partitionIndex++;
        swap(array, partitionIndex, end);

        quickSort(array, 0, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, end);
    }

    void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
