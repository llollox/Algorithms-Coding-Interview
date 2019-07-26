package previmedical.it.leetcode.problems.crack.moderate;

import java.util.Arrays;

public class SmallestDifference {

    /*
        Given two arrays of integers, compute the pair of values (one value in each array)
        with the smallest (non-negative) difference. Return the difference.

        Input:
            {1, 3, 15, 11, 2},
            {23, 127, 235, 19, 8}


        Output: 3. That is, the pair (11, 8).

        Solution 1. O(n^2)
        Calcolo tutte le coppie possibili e tengo traccia del minore.

        Solution 2. O(nlogn)
        Ordino i due array e applico binary search per cercare il valore.
        n log n per entrambi gli array
        n log n per fare binary search n volte
        tot 3 * nlogn = O(nlogn)

        Solution 3. O(nlogn)
        Ordino i due array.
        Scorro le due liste insieme, andando ad aumentare l'indice della lista col minore.
        n log n per entrambi gli array
        n + m per scorrere entrambe le liste insieme
        tot nlogn + mlogm + n + m = O(nlogn)
     */

    public int naive(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;

        for (int i=0; i<a.length; i++) {
            for(int j=0; j<b.length; j++) {

                int diff = a[i] - b[j];
                if (diff > 0 && diff < min) {
                    min = diff;
                }
            }
        }

        return min;
    }

    /*
        {1, 2, 5, 11, 15}, {8, 19, 23, 127, 235}
     */
    public int binarySearch(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return -1;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int min = Integer.MAX_VALUE;

        for (int i=0; i<a.length; i++) {

            int valA = a[i];

            int start = 0;
            int end = b.length - 1;

            while (start < end) {
                int mid = (start + end) / 2;

                int valB = b[mid];

                if (valB == valA) {
                    return 0;
                }
                else if (valA < valB) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }

            int diff = valA - b[start];

            if (diff > 0 && min > diff) {
                min = diff;
            }

            if (start > 0) {
                diff = valA - b[start - 1];

                if (diff > 0 && min > diff) {
                    min = diff;
                }
            }

            if (start < b.length - 1) {
                diff = valA - b[start + 1];

                if (diff > 0 && min > diff) {
                    min = diff;
                }
            }
        }

        return min;
    }


    /*
        - Confronto i due valori:
            - se sono uguali ritorno 0
            - se a < b allora faccio avanzare il puntatore di a
            - se a > b allora faccio avanzare il puntatore di b
     */

    public int twoPointers(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return -1;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int idxA = 0;
        int idxB = 0;

        int min = Integer.MAX_VALUE;

        while (idxA < a.length && idxB < b.length) {
            int valA = a[idxA];
            int valB = b[idxB];

            if (valA == valB) {
                return 0;
            }
            else if (valA < valB) {
                idxA++;
            }
            else {
                int diff = valA - valB;
                if (diff < min) {
                    min = diff;
                }
                idxB++;
            }
        }

        return min;
    }

}
