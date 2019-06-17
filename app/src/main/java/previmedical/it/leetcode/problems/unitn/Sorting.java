package previmedical.it.leetcode.problems.unitn;


import previmedical.it.leetcode.problems.unitn.util.ArrayUtil;
import previmedical.it.leetcode.problems.unitn.util.HeapUtil;

import java.util.ArrayList;
import java.util.Random;


public class Sorting {


    // Class functions *************************************************************************************************

    // Swaps subsequent elements if the right most element is greater than left one. n times
    // At the end of the first loop the maximum is at the end of the array.
    // Best case O(n): Already sorted array
    // Worst case O(n2): Every other case
    public int[] bubbleSort(int[] array) {

        boolean swap = true;
        int endIndex = array.length - 1;
        while (swap) {
            swap = false;

            for (int i=0; i<endIndex;i++) {
                if (array[i] > array[i + 1]) {
                    ArrayUtil.swap(array, i, i + 1);
                    swap = true;
                }
            }

            endIndex--;
        }

        return array;
    }


    // Since heapSort jumps from bottom to top of the heap many times,
    // it invalid any kind of caching on pages of memory.
    // That's why it works only for embedded system or when you don't have
    // such many items to sort.
    // It's complexity is O(n * log(n))
    public int[] maxHeapSort(int[] heap) {
        for (int i=0; i<heap.length; i++) {
            int length = heap.length - (i + 1);
            ArrayUtil.swap(heap, 0, length);
            HeapUtil.maxHeapRestore(heap, 0, length);
        }

        return heap;
    }

    public int[] minHeapSort(int[] heap) {
        for (int i=0; i<heap.length; i++) {
            int length = heap.length - (i + 1);
            ArrayUtil.swap(heap, 0, length);
            HeapUtil.minHeapRestore(heap, 0, length);
        }

        return ArrayUtil.reverse(heap);
    }


    // Best case O(n): Already sorted array
    // Best case O(n2): Reverse sorted array
    // Very fast for small arrays (roughly 10)
    public int[] insertionSort(int[] array) {

        int index = 1;
        while (index < array.length) {
            int j = index;
            while (j > 0 && array[j-1] > array[j]) {
                ArrayUtil.swap(array, j-1, j);
                j--;
            }
            index++;
        }

        return array;
    }


    // Every case: O(n log n)
    // It has the problem that uses another array in order to merge.
    // Therefore it requires a space of O(n)
    public int[] mergeSort(int[] array, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return new int[0];
        }

        int midLength = (startIndex + endIndex)/2;

        this.mergeSort(array, startIndex, midLength);
        this.mergeSort(array, midLength + 1, endIndex);
        this.merge(array, startIndex, endIndex, midLength);

        return array;
    }


    // Choose a pivot randomly. Than put all the lower elements to the right, and all the greater elements to the left.
    // Repeat recursively within the two halves.
    // Best case O(n * log2n): Prendo sempre il medio
    // Worst case O(n2): Prendo sempre il minimo o il massimo
    public int[] quickSort(int[] array) {

        if (array.length < 2) {
            return array;
        }

        int pivotIndex = this.randomInt(0, array.length - 1);
        int pivot = array[pivotIndex];

        ArrayList<Integer> lessThanPivot = new ArrayList<Integer>();
        ArrayList<Integer> greaterOrEqualThanPivot = new ArrayList<Integer>();

        for (int i=0; i<array.length; i++) {
            if (i != pivotIndex) {
                if (array[i] < pivot) {
                    lessThanPivot.add(array[i]);
                }
                else {
                    greaterOrEqualThanPivot.add(array[i]);
                }
            }
        }

        // Set elements less than pivot
        int[] lessThanPivotSorted = this.quickSort(this.toArray(lessThanPivot));
        for (int i=0; i<lessThanPivotSorted.length; i++) {
            array[i] = lessThanPivotSorted[i];
        }

        // Set pivot
        int newPivotIndex = lessThanPivot.size();
        array[newPivotIndex] = pivot;


        // Set elements greater than pivot
        int[] greaterOrEqualThanPivotSorted = this.quickSort(this.toArray(greaterOrEqualThanPivot));
        for (int i=0;i<greaterOrEqualThanPivotSorted.length; i++) {
            array[i + newPivotIndex + 1] = greaterOrEqualThanPivotSorted[i];
        }

        return array;
    }


    // Calculate the minimum value n times
    // Every case: O(n2)
    public int[] selectionSort(int[] array) {

        for (int i=0; i < array.length; i++) {
            int minIndex = this.minIndex(array, i);
            ArrayUtil.swap(array, minIndex, i);
        }

        return array;
    }




    // Private class functions *****************************************************************************************
    private void merge(int[] array, int startIndex, int endIndex, int midIndex) {
        int[] mergedArray = new int[endIndex - startIndex];

        int indexArray1 = startIndex;
        int indexArray2 = midIndex + 1;
        int indexMergedArray = 0;

        while (indexArray1 <= midIndex && indexArray2 <= endIndex) {

            int value1 = array[indexArray1];
            int value2 = array[indexArray2];

            if (value1 < value2) {
                mergedArray[indexMergedArray] = value1;
                indexArray1++;
            }
            else {
                mergedArray[indexMergedArray] = value2;
                indexArray2++;
            }

            indexMergedArray++;
        }

        // Se non ho terminato gli elementi del sotto vettore di sinistra
        // Allora li copio alla fine dell'array
        int j = endIndex;
        for (int i=midIndex; i>= indexArray1; i--) {
            array[j] = array[i];
            j--;
        }

        // Copio tutti gli elementi ordinati di merged array dall'inizio
        for (int i=0; i<indexMergedArray; i++) {
            array[i + startIndex] = mergedArray[i];
        }
    }

    private int minIndex(int[] array, int startIndex) {
        if (array.length == 0) {
            return -1;
        }

        int min = array[startIndex];
        int minIndex = startIndex;

        for (int i = startIndex; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private int randomInt(int min, int max) {
        return new Random(System.currentTimeMillis()).nextInt((max - min) + 1) + min;
    }

    private int[] toArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}