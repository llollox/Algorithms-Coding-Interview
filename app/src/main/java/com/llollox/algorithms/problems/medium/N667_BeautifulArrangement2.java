package com.llollox.algorithms.problems.medium;

public class N667_BeautifulArrangement2 {

    /*
        Given two integers n and k, you need to construct a list
        which contains n different positive integers ranging from 1 to n and obeys the following requirement:

        Suppose this list is [a1, a2, a3, ... , an],
        then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.

        If there are multiple answers, print any of them.

        Example 1:
        Input: n = 3, k = 1
        Output: [1, 2, 3]
        Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3,
        and the [1, 1] has exactly 1 distinct integer: 1.

        Example 2:
        Input: n = 3, k = 2
        Output: [1, 3, 2]
        Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3,
        and the [2, 1] has exactly 2 distinct integers: 1 and 2.

        Note:
        The n and k are in the range 1 <= k < n <= 104.
     */

    /*
        Questions:
            - What if k < n? It is not the case
            - What if n == Integer.MAX_VALUE? No, n is at most 104 and it fits in memory



        n = 10
        k = 4
        copio fino all'indice 4
        iniziare dall'indice 5
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        [1, 2, 3, 4, 5, 6, 10, 7, 9, 8]
        [1, 1, 1, 1, 1, 1, 4, 3, 2, 1]
        - Potrei andare avanti fino a (n-k) + 1 mettendo gli elementi in sequenza
        - Dopodichè mettere:
            - il minore e il massimo
            - quello dopo il minore e quello prima del massimo
            - ecc
     */

    public int[] beautifulArrangement(int n, int k) {
        if (n <= 0 || n < k) {
            return new int[]{};
        }

        int[] output = new int[n];

        // Inizializzazione
        for (int i=0; i< (n - k) - 1; i++) {
            output[i] = i + 1;
        }

        int start = (n - k) - 1;
        int end = n - 1;
        int i = start;

        while (i < n) {
            output[i] = start + 1;

            if (i + 1 < n) {
                output[i + 1] = end + 1;
            }

            i += 2;
            start += 1;
            end -= 1;
        }

        return output;
    }
}
