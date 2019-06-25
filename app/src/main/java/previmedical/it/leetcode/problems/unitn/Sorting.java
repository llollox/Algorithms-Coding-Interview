package previmedical.it.leetcode.problems.unitn;


import previmedical.it.leetcode.problems.unitn.util.ArrayUtil;
import previmedical.it.leetcode.problems.unitn.util.HeapUtil;

import java.util.*;


public class Sorting {


    // BUBBLE SORT *****************************************************************************************************
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


    // BUCKET SORT *****************************************************************************************************
    // Crea n empty buckets (lists)
    // Per ogni elemento dell'array, inserisco array[i] nel bucket[n * array[i]]
    // Ordino ogni bucket utilizzando insertion sort.
    // Concateno tutti i bucket sortati.
    //
    // L'idea è quella di creare dei bucket (non troppo grandi) di valori simili in cui poi eseguire insertion Sort
    // che è efficiente quando non abbiamo troppi valori da ordinare.
    // Poichè il range di ogni bucket è minore dell'altro, quando prendo gli elementi del primo bucket saranno tutti
    // minori degli elementi del secondo bucket.
    // Per questo motivo, una volta ordinati tutti i bucket, mi basta concatenarli per ottenere l'array ordinato.
    // Time O(n + k) Space O(n)
    public int[] bucketSort(int[] array) {

        int max = ArrayUtil.max(array);
        int k = power(max) + 1; // # buckets

        ArrayList<List<Integer>> buckets = new ArrayList<>();

        // Initialization
        for (int i=0; i<k; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // Divide the input into 10 buckets
        for (int i=0; i<array.length; i++) {
            int bucketIdx = power(array[i]);
            buckets.get(bucketIdx).add(array[i]);
        }

        // Sort each bucket
        for (int i=0; i<k; i++) {
            Collections.sort(buckets.get(i));
        }


        // Combine results
        int arrayIdx = 0;
        for (int i=0; i<k; i++) {
            List<Integer> bucket = buckets.get(i);
            for (int j=0; j<bucket.size(); j++) {
                array[arrayIdx] = bucket.get(j);
                arrayIdx++;
            }
        }

        return array;
    }

    // COUNTING SORT ***************************************************************************************************
    public int[] countingSort(int[] array) {

        int n = array.length;
        int min = ArrayUtil.min(array);
        int max = ArrayUtil.max(array);

        int range = (max - min) + 1;

        // Output array that will contain the sorted array
        int[] output = new int[n];

        // Count array
        int[] count = new int[range];


        // Take a count array to store the count of each unique object.
        for (int i=0; i<n; i++) {
            int idx = array[i] - min;
            count[idx]++;
        }

        // Modify the count array such that each element at each index
        // stores the sum of previous counts.
        for (int i=1; i<range; i++) {
            count[i] += count[i - 1];
        }

        // Now each the value v, at position i on the modified count array indicates
        // the position of the i-th element into the sorted array.
        // Output each object from the input sequence followed by
        // decreasing its count by 1.
        for (int i=n-1; i>=0; i--) {
            int countIdx = array[i] - min;

            // -1 because array starts from 0.
            output[count[countIdx] - 1] = array[i];
            --count[countIdx];
        }

        return output;
    }


    // MAX HEAP SORT ***************************************************************************************************
    // Since heapSort jumps from bottom to top of the heap many times,
    // it invalid any kind of caching on pages of memory.
    // That's why it works only for embedded system or when you don't have
    // such many items to sort.
    // It's complexity is O(n * log(n))
    public int[] heapSort(int[] array) {
        int[] heap = HeapUtil.buildMaxHeap(array);

        for (int i=0; i<heap.length; i++) {
            int length = heap.length - (i + 1);
            ArrayUtil.swap(heap, 0, length);
            HeapUtil.maxHeapRestore(heap, 0, length);
        }

        return heap;
    }

//    public int[] minHeapSort(int[] heap) {
//        for (int i=0; i<heap.length; i++) {
//            int length = heap.length - (i + 1);
//            ArrayUtil.swap(heap, 0, length);
//            HeapUtil.minHeapRestore(heap, 0, length);
//        }
//
//        return ArrayUtil.reverse(heap);
//    }


    // INSERTION SORT **************************************************************************************************
    // Considero il primo come già ordinato.
    // Parto dal secondo e verifico se è minore del primo, se si li swappo. A questo punto ho i primi 2 ordinati.
    // Prendo il terzo e swappo all'indietro fintanto che trovo la posizione corretta dell'elemento.
    // Avanti cosí per tutti gli elementi dell'array.
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


    // MERGE SORT ******************************************************************************************************
    // Every case: O(n log n)
    // It has the problem that uses another array in order to merge.
    // Therefore it requires a space of O(n)
    public int[] mergeSort(int[] array) {
        return this.mergeSort(array, 0, array.length - 1);
    }

    private int[] mergeSort(int[] array, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return new int[0];
        }

        int midLength = (startIndex + endIndex)/2;

        this.mergeSort(array, startIndex, midLength);
        this.mergeSort(array, midLength + 1, endIndex);
        this.merge(array, startIndex, endIndex, midLength);

        return array;
    }

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


    // QUICK SORT ******************************************************************************************************
    // Choose a pivot randomly. Than put all the lower elements to the right, and all the greater elements to the left.
    // Repeat recursively within the two halves.
    // Best case O(n * log2n): Prendo sempre il medio
    // Worst case O(n2): Prendo sempre il minimo o il massimo
    public int[] quickSort(int[] a) {
        if (a == null || a.length == 1) {
            return a;
        }

        return this.quickSort(a, 0, a.length - 1);
    }

    private int[] quickSort(int[] a, int start, int end) {

        // Base Case
        if (start > end) {
            return a;
        }


        // Partitioning
        int pivot = a[end];

        int i = start - 1;
        for (int j=start; j <= end - 1; j++) {

            // If current element is smaller than or equal to pivot
            if (a[j] <= pivot) {
                i++;
                ArrayUtil.swap(a, i, j);
            }
        }

        int pivotIndex = i + 1;

        ArrayUtil.swap(a, pivotIndex, end);

        // Recursive pass
        a = this.quickSort(a, start, pivotIndex - 1);
        a = this.quickSort(a, pivotIndex + 1, end);

        return a;
    }


    // RADIX SORT ******************************************************************************************************
    // It doesn't work for negative numbers.
    // Very efficient when all the numbers are in a short range since k is small.
    // At every iteration i, it sorts the numbers based on the i-th digit of each number.
    // It applies counting sort for each time.
    // Every case: Time O(nk), where n = length of array, k = log2(max value of array)
    // Every case: Space O(n + k)
    public int[] radixSort(int[] array) {

        // Find the maximum number to know number of digits
        int max = ArrayUtil.max(array);

        // Do counting sort for every digit.
        // Note that instead of passing digit number,
        // exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; max/exp > 0; exp *= 10) {
            this.countingSortForRadix(array, exp);
        }

        return array;
    }

    private int[] countingSortForRadix(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i<n; i++) {
            count[ (array[i] / exp) % 10 ]++;
        }

        for (int k = 1; k<10; k++) {
            count[k] += count[k - 1];
        }

        for (int i=n-1; i>=0; i--) {
            int countIdx = (array[i] / exp) % 10;
            int outputIdx = count[countIdx] - 1;
            output[outputIdx] = array[i];
            count[countIdx]--;
        }

        for (int i=0; i<n; i++) {
            array[i] = output[i];
        }

        return array;
    }


    // SELECTION SORT **************************************************************************************************
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

    private int power(int n) {
        if (n == 0) {
            return 0;
        }

        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count - 1;
    }

}
