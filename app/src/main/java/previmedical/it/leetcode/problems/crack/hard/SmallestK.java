package previmedical.it.leetcode.problems.crack.hard;


import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestK {

    // Design an algorithm to find the smallest K numbers in an array.

    // USING A PRIORITY QUEUE
    // Time O(n * log k) Space O(log k)
    public int[] smallestK_Heap(int[] array, int k) {

        if (array == null || k < 0) {
            return null;
        }

        if (k >= array.length) {
            return array;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i2, i1);
            }
        });

        for (int i=0; i<k; i++) {
            pq.add(array[i]);
        }

        for (int i=k; i<array.length; i++) {
            int value = array[i];
            int max = pq.peek();

            if (value < max) {
                pq.poll();
                pq.add(value);
            }
        }

        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }


    // USING PARTITIONING
    // Time O(n)
    /*
        - Scelgo un pivot a random (es l'ultimo elemento)
        - i, j = 0
        - i: indica l'ultimo elemento della prima partizione
        - j: indica l'ultimo elemento analizzato
        - se il numero di elementi nella prima partizione è > di k
            allora ricorro nella prima partizione per cercare di individuare i k minori
            altrimenti tutti gli elementi della prima partizione e ricorro nella seconda cercando
            gli elementi k - partizione più piccoli.
     */

    public int[] smallestK_Partitioning(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return null;
        }

        if (k >= array.length) {
            return array;
        }

        return this.smallestK(array, k, 0, array.length - 1, new int[k]);
    }

    private int[] smallestK(int[] array, int k, int start, int end, int[] result) {
        if (k <= 0) {
            return result;
        }

        int pivotIndex = this.partition(array, start, end);

        int i = start;
        while (k > 0 && i <= pivotIndex) {
            result[k - 1] = array[i];
            i += 1;
            k -= 1;
        }

        return smallestK(array, k, pivotIndex + 1, end, result);
    }


    /*
        i = il divisorio tra le due partizioni. (primo indice della prima partizione)
        j = l'elemento da gestire

        while (j < end)
        array[i] < 6?
            - swappo array[i] con l'elemento a posizione i
            - incremento i di 1
            - incremento j di 1

        array[i] >= 6
            - incremento j

        swappo il pivot con i

                        pvt
        [1, 2, 4, 6, 18, 7]
                  i
                      j
     */

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
