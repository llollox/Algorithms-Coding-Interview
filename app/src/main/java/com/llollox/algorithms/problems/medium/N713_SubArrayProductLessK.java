package com.llollox.algorithms.problems.medium;

import java.math.BigInteger;

public class N713_SubArrayProductLessK {

    /*
        Your are given an array of positive integers nums.

        Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

        Example 1:
        Input: nums = [10, 5, 2, 6], k = 100
        Output: 8

        Explanation:
        The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
        Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

        Note:
        0 < nums.length <= 50000.
        0 < nums[i] < 1000.
        0 <= k < 10^6.
     */

    /*
        Approach 1 O(N^2)
        - Provare tutte le dimensioni di subarray O(N)
            - Applicare sliding windowd per calcolare il prodotto tutte le volte O(N)
            - Se è minore di K lo aggiungo ad un counter

     */


    // [10, 5, 2, 6]
    // [10,9,10,4,3,8,3,3,6,2,10,10,9,3], 19
    public int numProducts(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 1) {
            return 0;
        }

        int n = array.length;
        int count = 0;
        int prev = -1;

        BigInteger kBig = new BigInteger("" + k);

        for (int d = 1; d <= n; d++) { // dimensions

            // Init
            BigInteger prod = new BigInteger("1");

            // Init Sliding Window
            for (int i=0; i<d; i++) {
                prod = prod.multiply(new BigInteger("" + array[i]));
            }

            if (prod.compareTo(kBig) == -1) {
                count += 1;
            }

            // Sliding Window
            for (int i=d; i<n; i++) {

                prod = prod.divide(new BigInteger("" + array[i - d]));
                prod = prod.multiply(new BigInteger("" + array[i]));

                if (prod.compareTo(kBig) == -1) {
                    count += 1;
                }
            }

            if (prev > 0 && prev == count) {
                break;
            }

            prev = count;
        }

        return count;
    }


    /*

          - Inizializzo una variabile left = 0
          - Inizializzo un count = 0
          - Inizializzo un prod = 1
          - Scorro tutto l'array tramite l'indice right
            - Moltiplico prod per array[right]
            - Qualora il risultato sia >= k
                - Aumento left andando a dividere il prodotto per array[left]
            - Incremento il count di (right - left) + 1.
                - Perchè se moltiplico right - left elementi, il prodotto <= k
                - Allora qualunque sottoinsieme che comprende right sarà comunque <= k

         */
    public int numProductsOptmial(int[] array, int k) {
        int count = 0;
        int prod = 1;
        int left = 0;

        for (int right = 0; right < array.length; right++) {
            prod *= array[right];

            while (prod >= k) {
                prod /= array[left++];
            }

            count += right - left + 1;
        }
        return count;
    }
}
