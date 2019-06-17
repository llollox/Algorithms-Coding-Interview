package previmedical.it.leetcode.problems.unitn.util;

public class HeapUtil {

    // Since all the leaf are already heaps,
    // we call the maxHeapRestore function starting from the parent nodes
    // of the leafs, and recursively up to the root.
    public static int[] buildMaxHeap(int[] array) {
        int mid = array.length / 2;
        for (int i=mid; i>= 0; i--) {
            maxHeapRestore(array, i, array.length);
        }
        return array;
    }

    public static int[] buildMinHeap(int[] array) {
        int mid = array.length / 2;
        for (int i=mid; i>= 0; i--) {
            minHeapRestore(array, i, array.length);
        }
        return array;
    }

    public static int[] minHeapRestore(int[] array, int nodeIndex, int length) {

        int minIndex = nodeIndex;
        int leftChildIndex = leftChildIndex(nodeIndex);
        int rightChildIndex = rightChildIndex(nodeIndex);


        if (leftChildIndex < length && array[leftChildIndex] < array[minIndex]) {
            minIndex = leftChildIndex;
        }

        if (rightChildIndex < length && array[rightChildIndex] < array[minIndex]) {
            minIndex = rightChildIndex;
        }

        if (minIndex != nodeIndex) {
            ArrayUtil.swap(array, minIndex, nodeIndex);
            minHeapRestore(array, minIndex, length);
        }

        return array;
    }


    // After an insertion / deletation we changed the heap,
    // this functions is useful to restore the maxHeap
    public static int[] maxHeapRestore(int[] array, int nodeIndex, int length) {

        int maxIndex = nodeIndex;
        int leftChildIndex = leftChildIndex(nodeIndex);
        int rightChildIndex = rightChildIndex(nodeIndex);


        if (leftChildIndex < length && array[leftChildIndex] > array[maxIndex]) {
            maxIndex = leftChildIndex;
        }

        if (rightChildIndex < length && array[rightChildIndex] > array[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != nodeIndex) {
            ArrayUtil.swap(array, maxIndex, nodeIndex);
            maxHeapRestore(array, maxIndex, length);
        }

        return array;
    }


    // Private class functions *****************************************************************************************
    private static int leftChildIndex(int nodeIndex) {
        return nodeIndex * 2 + 1;
    }

    private static int rightChildIndex(int nodeIndex) {
        return nodeIndex * 2 + 2;
    }
}
